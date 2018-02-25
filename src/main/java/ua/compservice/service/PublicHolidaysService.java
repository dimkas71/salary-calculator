package ua.compservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.compservice.model.PublicHolidays;

@Service
public interface PublicHolidaysService {

	List<PublicHolidays> findAll();
	PublicHolidays findById(Long id);
	void save(PublicHolidays holiday);
	
}
