package ua.com.alevel;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@AllArgsConstructor
@SpringBootApplication
public class Unit20SpringDataApplication {

	private final RepositoryTest repositoryTest;

	public static void main(String[] args) {
		SpringApplication.run(Unit20SpringDataApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void start() {
		repositoryTest.test();
	}
}
