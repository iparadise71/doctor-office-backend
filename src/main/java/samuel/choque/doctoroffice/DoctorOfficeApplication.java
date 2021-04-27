package samuel.choque.doctoroffice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "samuel.choque.doctoroffice.mapper")
public class DoctorOfficeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorOfficeApplication.class, args);
	}

}
