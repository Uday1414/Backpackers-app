package com.ty.backpackersapp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private int no_of_beds;
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Stay stay;
	@OneToMany(mappedBy = "room" , cascade = CascadeType.PERSIST)
	private List<Bed> beds;
}
