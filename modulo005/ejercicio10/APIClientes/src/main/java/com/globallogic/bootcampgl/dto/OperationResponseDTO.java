package com.globallogic.bootcampgl.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "Entidad OperationResponse", description = "Información de la Operación")
public class OperationResponseDTO implements Serializable {

	private static final long serialVersionUID = -3642310382243888892L;
	
	@ApiModelProperty(value = "Mensaje por la operación realizada")
	private String message;

}
