package khj.side.user.controller;

import org.springframework.http.ResponseEntity;

public interface UserController {
    ResponseEntity signUp();
    ResponseEntity signIn();
    ResponseEntity logout();
    ResponseEntity findId();
    ResponseEntity findPassword();
}
