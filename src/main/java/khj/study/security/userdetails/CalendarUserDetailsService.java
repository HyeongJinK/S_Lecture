package khj.study.security.userdetails;

import khj.study.security.authority.CalendarUserAuthorityUtils;
import khj.study.security.dataaccess.CalendarUserDao;
import khj.study.security.domain.CalendarUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CalendarUserDetailsService implements UserDetailsService { // 새로운 UserDetailsService 구현
    private final CalendarUserDao calendarUserDao;

    @Autowired
    public CalendarUserDetailsService(CalendarUserDao calendarUserDao) {
        this.calendarUserDao = calendarUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CalendarUser user = calendarUserDao.findUserByEmail(username);

        if (user == null) {
            throw  new UsernameNotFoundException("Invalid username/password.");
        }

        Collection<? extends GrantedAuthority> authorities = CalendarUserAuthorityUtils.createAuthorities(user);

        return new CalendarUserDetails(user);
    }

    private final class CalendarUserDetails extends CalendarUser implements UserDetails {
        CalendarUserDetails(CalendarUser user) {
            setId(user.getId());
            setEmail(user.getEmail());
            setFirstName(user.getFirstName());
            setLastName(user.getLastName());
            setPassword(user.getPassword());
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return CalendarUserAuthorityUtils.createAuthorities(this);
        }

        @Override
        public String getUsername() {
            return getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        private static final long serialVersionUID = 3384436451564509032L;
    }
}
