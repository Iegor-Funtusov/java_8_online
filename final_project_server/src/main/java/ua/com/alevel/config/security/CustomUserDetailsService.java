//package ua.com.alevel.config.security;
//
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import ua.com.alevel.persistence.entity.user.User;
//import ua.com.alevel.persistence.repositoty.user.UserRepository;
//
//@Service
//@RequiredArgsConstructor
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UserRepository<User> userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository
//                .findByLogin(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//    }
//
////    private UserDetails convertUserToUserDetails(User user) {
////        return new UserDetails() {
////            @Override
////            public Collection<? extends GrantedAuthority> getAuthorities() {
////                return null;
////            }
////
////            @Override
////            public String getPassword() {
////                return user.getPassword();
////            }
////
////            @Override
////            public String getUsername() {
////                return user.getLogin();
////            }
////
////            @Override
////            public boolean isAccountNonExpired() {
////                return false;
////            }
////
////            @Override
////            public boolean isAccountNonLocked() {
////                return false;
////            }
////
////            @Override
////            public boolean isCredentialsNonExpired() {
////                return false;
////            }
////
////            @Override
////            public boolean isEnabled() {
////                return false;
////            }
////        };
////    }
//}
