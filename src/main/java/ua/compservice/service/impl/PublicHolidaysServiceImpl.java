package ua.compservice.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import ua.compservice.model.PublicHolidays;
import ua.compservice.repository.PublicHolidaysRepository;
import ua.compservice.service.PublicHolidaysService;

@Transactional
public class PublicHolidaysServiceImpl implements PublicHolidaysService {

	private PublicHolidaysRepository repos;
	
	@Autowired
	public PublicHolidaysServiceImpl(PublicHolidaysRepository repos) {
		this.repos = repos;
	}

	@Override
	public List<PublicHolidays> findAll() {
		return this.repos.findAll();
	}

	@Override
	public PublicHolidays findById(Long id) {
		return this.repos.findOne(id);
	}

	@Override
	public void save(PublicHolidays holiday) {
		this.repos.save(holiday);
	}

}
