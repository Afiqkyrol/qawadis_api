package com.cerouno.qawadis_api.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtSecurity {

    private static String SECRET_KEY = "08a9916854a24be85c00b16bb9adceaaa7b1a03ec5babd298fa75d71d93f65a605bb0887424ebacf53a8c6a36a90e64848b2a1301b2ec815ff7cce6c195fe01bb19c02de73568c75fd6c74ea919b881139224352a826a2a9f3fcb8f7783b7f1a101e45ac1239f716880d74db2efb6ee64c28f90feffa9a2fa4ac729cd38c2ec40ec5e8078fee6e134571f38fe944b3890e86d19b1fc0a049aff1ef9639234ce11d610efd72127f9a3685fa51b1f36e817c3c2a10148b9ef4840826a242efc7f581b3c83a3645bf93395663e75cbb18525f94b47279e9011234ff943a1b97a21424d053d739d52a0840fc67d53f5d68601849ba5766a24d14102d749a03444e4f";
    private static long EXPIRATION_TIME = 1000 * 60 * 60;

    public static String generateToken(Integer userId) {
        return Jwts.builder()
                .setSubject(String.valueOf(userId))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static Integer extractUserId(String token) {
        return Integer.valueOf(Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject());
    }

    public static boolean validateToken(String token) {
        try{
            return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().size() > 0;
        }catch (Exception e){
            return false;
        }
    }
}