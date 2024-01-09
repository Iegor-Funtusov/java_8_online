package ua.com.alevel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.com.alevel.persistence.entity.user.Personal;
import ua.com.alevel.persistence.repositoty.user.PersonalRepository;

@SpringBootApplication
public class FinalProjectServerApplication {

    @Autowired
    private PersonalRepository personalRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(FinalProjectServerApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() {

//        String password = "Test123!";
//        String hash1 = "$2a$10$/RBu35SncGjTUoxSwrx1cObhSA7uA9Kx/NlKfCiVFjvt5ibILJEeW";
//        String hash2 = "$2a$10$/RBu35SncGjTUoxSwrx1cObhSA7uA9Kx/NlKfCiVFjvt5ibILJEeI";
//
//        System.out.println("hash1 = " + passwordEncoder.encode(password));
//        System.out.println("hash2 = " + passwordEncoder.encode(password));
//        System.out.println("hash3 = " + passwordEncoder.encode(password));
//        System.out.println("hash4 = " + passwordEncoder.encode(password));
//
//        System.out.println(passwordEncoder.matches(password, hash1));
//        System.out.println(passwordEncoder.matches(password, hash2));


//        System.out.println("FinalProjectServerApplication.run");
//        Personal personal = new Personal();
//        personal.setLogin("login");
//        personal.setPassword("password");
//        personalRepository.save(personal);
    }
}
