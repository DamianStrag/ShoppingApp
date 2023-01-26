package pl.zakupy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("pl.zakupy.repository")
//@ComponentScan("pl.zakupy.repository")
public class AplikacjaZakupowaApplication {




	public static void main(String[] args) {
		SpringApplication.run(AplikacjaZakupowaApplication.class, args);
	}

}
