package ua.com.alevel.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ua.com.alevel.persistence.entity.token.Token;
import ua.com.alevel.persistence.repositoty.token.TokenRepository;
import ua.com.alevel.util.SecurityUtil;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final TokenRepository tokenRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String servletPath = request.getServletPath();
        if (servletPath.contains("/api/open") || servletPath.contains("/api/auth")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        final String jwt = authHeader.substring(7);
        final String login = jwtService.extractUsername(jwt);
        if (StringUtils.isNotBlank(login) && !SecurityUtil.isAuthenticated()) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(login);
            Token token = tokenRepository
                    .findByToken(jwt)
                    .orElseThrow(() -> new RuntimeException("Invalid token"));
//            boolean isExpiredToken = token.getExpired();
            if (jwtService.isNotExpiredToken(jwt)) {
                var authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityUtil.setAuthentication(authToken);
                System.out.println("authToken = " + authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
