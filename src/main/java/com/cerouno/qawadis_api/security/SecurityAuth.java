package com.cerouno.qawadis_api.security;

import jakarta.servlet.http.HttpServletRequest;

public class SecurityAuth {

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
