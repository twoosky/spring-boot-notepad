package hanuel.springbootnotepad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class SpringBootNotepadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootNotepadApplication.class, args);
	}

}
