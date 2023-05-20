package com.ftn.sbnz.service;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

	@Bean
	public KieContainer kieContainer() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks
		.newKieContainer(ks.newReleaseId("com.ftn.sbnz", "kjar", "0.0.1-SNAPSHOT"));
		// pazi na stringove u metodi iznad
		// prvo mora da se poklapa sa paketom, drugo sa nazivom kjar projekta i trece sa verzijom
		// logicno ali mi nije radilo jer je umesto 'kjar' pisalo 'skjar'
		KieScanner kScanner = ks.newKieScanner(kContainer);
		kScanner.start(1000);
		
		return kContainer;
	}
}
