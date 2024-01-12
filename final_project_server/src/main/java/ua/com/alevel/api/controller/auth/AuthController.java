package ua.com.alevel.api.controller.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.alevel.api.dto.request.auth.RegisterDto;
import ua.com.alevel.api.dto.response.auth.AuthDto;
import ua.com.alevel.config.security.AuthenticationService;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthDto> register(@RequestBody RegisterDto dto) {
        return ResponseEntity.ok(authenticationService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthDto> login(@RequestBody RegisterDto dto) {
        return ResponseEntity.ok(authenticationService.login(dto));
    }
}
