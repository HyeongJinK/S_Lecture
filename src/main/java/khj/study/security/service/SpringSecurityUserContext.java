package khj.study.security.service;

import khj.study.security.authority.CalendarUserAuthorityUtils;
import khj.study.security.domain.CalendarUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class SpringSecurityUserContext implements UserContext {
    /*private final CalendarService calendarService;
    private final UserDetailsService userDetailsService;

    @Autowired
    public SpringSecurityUserContext(final CalendarService calendarService,
                                     final UserDetailsService userDetailsService) {
        if (calendarService == null) {
            throw new IllegalArgumentException("calendarService cannot be null");
        }
        if (userDetailsService == null) {
            throw new IllegalArgumentException("userDetailsService cannot be null");
        }
        this.calendarService = calendarService;
        this.userDetailsService = userDetailsService;
    }*/

    @Override
    public CalendarUser getCurrentUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();    // 현재 사용자를 가져온다.
        if (authentication == null)
            return null;
        return (CalendarUser) authentication.getPrincipal();
//        String email = authentication.getName();
//        return calendarService.findUserByEmail(email);
    }

    @Override
    public void setCurrentUser(CalendarUser user) {
        if (user == null) {
            throw new IllegalArgumentException("user cannot be null");
        }
        Collection<? extends GrantedAuthority> authorities = CalendarUserAuthorityUtils.createAuthorities(user);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,
                user.getPassword(), authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);//스프링 시큐리티는 SecurityContextHolder의 SecurityContext 객체를 HTTP 세션에 자동으로 연결한다.

       /* UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, user.getPassword(), userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication); *///스프링 시큐리티는 SecurityContextHolder의 SecurityContext 객체를 HTTP 세션에 자동으로 연결한다.
    }
}
