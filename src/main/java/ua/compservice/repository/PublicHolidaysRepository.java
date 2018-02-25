package ua.compservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.compservice.model.PublicHolidays;

@Repository
public interface PublicHolidaysRepository extends JpaRepository<PublicHolidays, Long>{

}
