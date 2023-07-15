package com.auth.msvcauth.security;


import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.IDToken;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.keycloak.representations.IDToken;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.UserInfo;
import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController

@RequestMapping(value = "/api")
public class Controller {
    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/employees")
    public ResponseEntity<?> getEmployees(@AuthenticationPrincipal Jwt jwt) {

        return new ResponseEntity<>(Collections.singletonMap("principal",jwt), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/departments")
    public ResponseEntity<?>getDeparts(KeycloakAuthenticationToken keycloakAuthenticationToken) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        KeycloakPrincipal<KeycloakSecurityContext> principal2 = (KeycloakPrincipal<KeycloakSecurityContext>) keycloakAuthenticationToken
                .getPrincipal();
        System.out.println(principal2.getKeycloakSecurityContext().getIdTokenString());
        //      auth.getAuthorities().forEach(a-> System.out.println(String.valueOf(a)));
        //    System.out.println(auth.getPrincipal().toString());
        KeycloakAuthenticationToken authentication = (KeycloakAuthenticationToken)
                SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getDetails());
        System.out.println(authentication.getName());
        System.out.println(authentication.getAccount().toString());
        Principal principal = (Principal) authentication.getPrincipal();
        System.out.println(principal.getName());


        return new ResponseEntity<>( auth.toString(), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/access-denied-response")
    public String accessDenied() {
        return "Access Denied... You don't have permission.";
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping(value="/demo")
    public SenderResponse adminEndPoint() {

        System.out.println("ME llamo admin");
        return new SenderResponse("Hello From Admin");
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping(value="/manager")
    public SenderResponse managerEndPoint() {
        System.out.println("ME llamo manager");
        return new SenderResponse("Hello From Manager");
    }
}

