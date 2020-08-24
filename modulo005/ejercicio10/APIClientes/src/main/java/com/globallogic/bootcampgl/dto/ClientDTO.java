package com.globallogic.bootcampgl.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Client entity", description = "Client information")
public class ClientDTO extends RepresentationModel<ClientDTO> implements Serializable {
	private static final long serialVersionUID = 6198725498682655760L;
	
	@ApiModelProperty("Client's DNI")
	private Long dni;
	@ApiModelProperty("Client's First name")
	private String firsrName;
	@ApiModelProperty("Client's Last name")
	private String lastName;
	@ApiModelProperty("Client's phone")
	private String phone;
	@ApiModelProperty("Client's mail")
	private String mail;
	private List<DirectionDTO> directions;
}
