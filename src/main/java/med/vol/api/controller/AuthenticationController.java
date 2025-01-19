package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.infra.security.DatosJWTToken;
import med.vol.api.infra.security.TokenService;
import med.vol.api.users.User;
import med.vol.api.users.UserAuthenticateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity authenticateUser(@RequestBody @Valid UserAuthenticateData userAuthenticateData) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(userAuthenticateData.login(),
                userAuthenticateData.password());
        var authenticatedUser = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generateToken((User) authenticatedUser.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }
}