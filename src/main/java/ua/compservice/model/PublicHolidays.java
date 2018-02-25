package ua.compservice.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "public_holidays")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicHolidays {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "desc")
	private String description;
	
	@Column(name = "holiday")
	private LocalDate holiday;
	

}
