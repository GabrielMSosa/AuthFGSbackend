package com.auth.msvcauth.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import java.security.Principal;
import org.springframework.security.access.prepost.PreAuthorize;


@RestController
public class Controller {

    
    //TENER EN CUENTA QUE DEBEMOS CREAR EL ROL COMO ROLE_USER KEYCLOAK
    @CrossOrigin(origins = "*")
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/departments")
    public String customers(@AuthenticationPrincipal Jwt principal) {
        System.out.println(principal.getClaimAsString("preferred_username"));
        System.out.println(principal.getClaimAsString("company"));

        return principal.getClaimAsString("preferred_username");
    }
}
