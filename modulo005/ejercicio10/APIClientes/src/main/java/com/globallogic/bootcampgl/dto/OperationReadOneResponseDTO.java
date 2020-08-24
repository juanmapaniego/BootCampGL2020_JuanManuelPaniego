package com.globallogic.bootcampgl.dto;

import java.io.Serializable;
import java.util.Collection;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "OperationReadResponse entity", description = "Informaticon at read operations")
public class OperationReadOneResponseDTO extends OperationResponseDTO implements Serializable {

	private static final long serialVersionUID = 5678601220137764301L;

	@ApiModelProperty(value = "Client")
	private ClientDTO client;

	@Builder(builderMethodName = "operationReadOneResponseDTOBuilder")
	public OperationReadOneResponseDTO(String message, ClientDTO client) {
		super(message);
		this.client = client;
	}
}
