package dev.sassine.financialcontrol;

import dev.sassine.financialcontrol.mail.service.EmailReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;

@SpringBootApplication
public class FinancialControlApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("uberGmailReaderService")
	private EmailReaderService emailReaderService;

	public static void main(String[] args) {
		SpringApplication.run(FinancialControlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String subjectFilter = "[Personal] Sua viagem";
		Instant start = Instant.parse("2024-08-01T00:00:00Z");
		Instant end = Instant.now();
		emailReaderService.readEmails(subjectFilter, start, end);
	}
}
