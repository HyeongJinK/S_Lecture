package khj.study.security.configuration;

import khj.study.security.authentication.CalendarUserAuthenticationProvider;
import khj.study.security.filter.DomainUsernamePasswordAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
    private static final Logger logger = LoggerFactory
            .getLogger(SecurityConfig.class);


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean()
            throws Exception {
        return super.authenticationManagerBean();
    }

//    @Bean
//    @Override
//    public UserDetailsManager userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("user").password("{noop}password").roles("USER").build());
//        manager.createUser(User.withUsername("admin").password("{noop}admin").roles("USER", "ADMIN").build());
//        manager.createUser(User.withUsername("user1@example.com").password("{noop}user1").roles("USER").build());
//        manager.createUser(User.withUsername("admin1@example.com").password("{noop}admin1").roles("USER", "ADMIN").build());
//        return manager;
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}user").roles("USER")  //// {noop} 암호화를 사용하지 않겠다는 표시 없으면 에러가 난다.
//                .and().withUser("admin").password("{noop}admin").roles("USER", "ADMIN")
//                .and().withUser("user1@example.com").password("{noop}user1").roles("USER")
//                .and().withUser("admin1@example.com").password("{noop}admin1").roles("USER", "ADMIN");
//    }
    @Autowired
    private CalendarUserAuthenticationProvider cuap;

    @Override
    public void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(cuap);
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**")
                .antMatchers("/webjars/**")
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resources/**").permitAll()

                .antMatchers("/").permitAll()
                .antMatchers("/login/*").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/signup/*").permitAll()
                .antMatchers("/errors/**").permitAll()
                .antMatchers("/admin/*").hasRole("ADMIN")
                .antMatchers("/events/").hasRole("ADMIN")   // ADMIN 권한이 필요
                .antMatchers("/**").hasRole("USER")     //순서대로 적용 가장 위에 있으면 밑에 모든 주소가 적용이 되지 않는 다.
                //.antMatchers("/**").access("hasRole('USER')")
                .and().formLogin()
                /*.loginPage("/login/form")
                .loginProcessingUrl("/login")
                .failureUrl("/login/form?error")
                .usernameParameter("username")
                .passwordParameter("password")*/
                //.defaultSuccessUrl("/default")    // 로그인 성공 시 해당 url로 이동 시킨다.
                .and().httpBasic()
                .and().logout()
                /*.logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")*/
                .and().csrf().disable()

                .addFilterAt(domainUsernamePasswordAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class)
        ;
    }


    @Bean
    public DomainUsernamePasswordAuthenticationFilter domainUsernamePasswordAuthenticationFilter()
            throws Exception {
        DomainUsernamePasswordAuthenticationFilter dupaf = new DomainUsernamePasswordAuthenticationFilter(
                super.authenticationManagerBean());
        dupaf.setFilterProcessesUrl("/login");
        dupaf.setUsernameParameter("username");
        dupaf.setPasswordParameter("password");

        dupaf.setAuthenticationSuccessHandler(
                new SavedRequestAwareAuthenticationSuccessHandler(){{
                    setDefaultTargetUrl("/default");
                }}
        );

        dupaf.setAuthenticationFailureHandler(
                new SimpleUrlAuthenticationFailureHandler(){{
                    setDefaultFailureUrl("/login/form?error");
                }}
        );

        dupaf.afterPropertiesSet();

        return dupaf;
    }

    @Bean
    public LoginUrlAuthenticationEntryPoint loginUrlAuthenticationEntryPoint(){
        return new LoginUrlAuthenticationEntryPoint("/login/form");
    }
}
