package lun.drag_and_drop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"lun.UI", "lun.Data","lun.Entity"})
@EnableJpaRepositories("lun.Data")
@EntityScan("lun.Data")
public class DragAndDropApplication {

	public static void main(String[] args) {
		SpringApplication.run(DragAndDropApplication.class, args);
	}

}






/**
 *
 * @ComponentScan(basePackages = {"guru.springframework.blog.componentscan.example.demopackageA",
 *         "guru.springframework.blog.componentscan.example.demopackageD",
 *         "guru.springframework.blog.componentscan.example.demopackageE"},
 *         basePackageClasses = DemoBeanB1.class)
 */