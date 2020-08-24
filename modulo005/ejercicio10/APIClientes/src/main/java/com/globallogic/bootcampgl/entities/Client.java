package com.globallogic.bootcampgl.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client implements Serializable {
	@Id
	private Long dni;
	private String firstName;
	private String lastName;
	private String phone;
	private String mail;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Direction> directions;
	
	private static final long serialVersionUID = -7167644914265349889L;
}
