package com.globallogic.bootcampgl.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.globallogic.bootcampgl.entities.Direction;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "Direction entity", description = "Client's direction information")
public class DirectionDTO implements Serializable {
		private String street;
		private Integer number;
		private String city;
		private String prov;
	
	private static final long serialVersionUID = -7167644914265349888L;
}