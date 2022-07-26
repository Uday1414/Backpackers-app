package com.ty.backpackersapp.dto;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double total;
	private String status;
	private Date checkInDate;
	@ManyToOne
	@JoinColumn
	private Person person;
	@ManyToMany(mappedBy = "bookings", cascade = CascadeType.PERSIST)
	private List<Bed> beds;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Stay stay;
}
