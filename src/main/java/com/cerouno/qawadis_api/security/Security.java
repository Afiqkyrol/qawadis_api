package com.cerouno.qawadis_api.security;

import jakarta.servlet.http.HttpServletRequest;

import javax.security.sasl.AuthenticationException;
import java.nio.file.AccessDeniedException;

public class Security {

    public static boolean AuthorizeToken(HttpServletRequest request){

        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {

            String token = authorizationHeader.substring(7);

            return JwtSecurity.validateToken(token);

        } else {
            return false;
        }
    }
}
