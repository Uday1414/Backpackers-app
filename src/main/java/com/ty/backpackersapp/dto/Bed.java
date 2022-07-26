package com.ty.backpackersapp.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Bed {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bed_type;
	private double cost;
	private String status = "available";
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	@JsonIgnore
	private Room room;
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn , inverseJoinColumns = @JoinColumn)
	@JsonIgnore
	private List<Booking> bookings;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private TempBooking tempBooking;
}
