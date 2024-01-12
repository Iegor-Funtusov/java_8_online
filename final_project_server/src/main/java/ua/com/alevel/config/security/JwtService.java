package ua.com.alevel.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;

    @Value("${application.security.jwt.expiration}")
    private long expiredTime;

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public boolean isNotExpiredToken(String token) {
        Date expiration = extractClaim(token, Claims::getExpiration);
        return expiration.after(new Date());
    }

    public String generateToken(UserDetails userDetails) {

        Map<String, String> map = new HashMap<>();
        map.put("hello", "world");

        return Jwts
                .builder()
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + expiredTime))
                .setIssuedAt(new Date())
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .setSubject(userDetails.getUsername())
                .compact();
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
