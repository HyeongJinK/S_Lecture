package khj.study.security.service;

import java.util.List;

import khj.study.security.dataaccess.CalendarUserDao;
import khj.study.security.dataaccess.EventDao;
import khj.study.security.domain.CalendarUser;
import khj.study.security.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Repository;


/**
 * A default implementation of {@link CalendarService} that delegates to {@link EventDao} and {@link CalendarUserDao}.
 *
 * @author Rob Winch
 *
 */
@Repository
public class DefaultCalendarService implements CalendarService {
    private final EventDao eventDao;
    private final CalendarUserDao userDao;

    @Autowired
    public DefaultCalendarService(final EventDao eventDao,
                                  final CalendarUserDao userDao) {   //5.0 버전으로 변경 되면서 지정 필요
        if (eventDao == null) {
            throw new IllegalArgumentException("eventDao cannot be null");
        }
        if (userDao == null) {
            throw new IllegalArgumentException("userDao cannot be null");
        }
        this.eventDao = eventDao;
        this.userDao = userDao;
    }
//    @Autowired
//    public DefaultCalendarService(final EventDao eventDao,
//                                  final CalendarUserDao userDao,
//                                  @Qualifier("userDetailsService") final UserDetailsManager userDetailsManager) {   //5.0 버전으로 변경 되면서 지정 필요
//        if (eventDao == null) {
//            throw new IllegalArgumentException("eventDao cannot be null");
//        }
//        if (userDao == null) {
//            throw new IllegalArgumentException("userDao cannot be null");
//        }
//        if (userDetailsManager == null) {
//            throw new IllegalArgumentException("userDetailsManager cannot be null");
//        }
//        this.eventDao = eventDao;
//        this.userDao = userDao;
//        this.userDetailsManager = userDetailsManager;
//    }

    public Event getEvent(int eventId) {
        return eventDao.getEvent(eventId);
    }

    public int createEvent(Event event) {
        return eventDao.createEvent(event);
    }

    public List<Event> findForUser(int userId) {
        return eventDao.findForUser(userId);
    }

    public List<Event> getEvents() {
        return eventDao.getEvents();
    }

    public CalendarUser getUser(int id) {
        return userDao.getUser(id);
    }

    public CalendarUser findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    public List<CalendarUser> findUsersByEmail(String partialEmail) {
        return userDao.findUsersByEmail(partialEmail);
    }
    public int createUser(CalendarUser user) {
        return userDao.createUser(user);
    }
//    public int createUser(CalendarUser user) {      // 새로운 사용자 생성
//        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");   //권한 하드코딩 생성
//        UserDetails userDetails = new User(user.getEmail(), user.getPassword(), authorities);
//        userDetailsManager.createUser(userDetails);
//        return userDao.createUser(user);
//    }
}