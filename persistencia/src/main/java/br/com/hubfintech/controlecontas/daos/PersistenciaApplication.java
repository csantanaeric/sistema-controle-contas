package br.com.hubfintech.controlecontas.daos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {TransacaoDao.class })
public class PersistenciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersistenciaApplication.class, args);
	}
}
