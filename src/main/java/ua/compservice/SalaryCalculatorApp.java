package ua.compservice;

import java.time.LocalDate;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ua.compservice.model.PublicHolidays;
import ua.compservice.repository.PublicHolidaysRepository;
import ua.compservice.service.PublicHolidaysService;
import ua.compservice.service.impl.PublicHolidaysServiceImpl;

@SpringBootApplication
public class SalaryCalculatorApp {

	private static final Logger logger = LoggerFactory.getLogger(SalaryCalculatorApp.class);

	public static void main(String[] args) {
		SpringApplication.run(SalaryCalculatorApp.class, args);
	}

	
	//TODO: remove bean definitions (below) to a configuration class
	@Bean
	PublicHolidaysService service(PublicHolidaysRepository repos) {
		return new PublicHolidaysServiceImpl(repos);
	}
	
	@Bean
	CommandLineRunner holidaysInitializer(PublicHolidaysRepository repos) {
		return (args) -> {
			Arrays.asList("1 января – Новый год (понедельник)",
					"7 января – Рождество Христово, православное (воскресенье)", 
					"Читайте также: Выходной 25 декабря: Парубий сделал важный шаг", 
					"8 марта – Международный женский день (четверг)", 
					"8 апреля – Пасха (воскресенье)",
					"1 мая – День международной солидарности трудящихся (вторник)", 
					"9 мая – День Победы (среда)", 
					"27 мая – Троица (воскресенье)",
					"28 июня – День Конституции Украины (четверг)",
					"24 августа – День независимости Украины (пятница)", 
					"14 октября – День защитника Украины (воскресенье)",
					"25 декабря – Рождество Христово, католическое (вторник)")
			.stream()
				.forEach(holiday -> {
					repos.save(new PublicHolidays(null, holiday, LocalDate.now()));
				});
			
			
			logger.info("Holidays initializer runned");
		};
	}
	
}
