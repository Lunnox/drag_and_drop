package lun.drag_and_drop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"lun.UI", "lun.Data","lun.Entity"})
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