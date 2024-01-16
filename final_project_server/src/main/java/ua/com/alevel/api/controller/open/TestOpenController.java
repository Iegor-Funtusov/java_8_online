package ua.com.alevel.api.controller.open;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.alevel.exception.EntityNotFoundException;

@RestController
@RequestMapping(path = "/api/open/test")
public class TestOpenController {

    @GetMapping
    public String test(@RequestParam int number) {
        System.out.println("number = " + number);

        if (number == 3) {
            throw new EntityNotFoundException("3 is not valid");
        }

        return "Hello world";
    }
}
