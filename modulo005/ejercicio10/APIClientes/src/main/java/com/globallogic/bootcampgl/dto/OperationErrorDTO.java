package com.globallogic.bootcampgl.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "OperationError Entity", description = "Information displayed at errors")
public class OperationErrorDTO extends OperationResponseDTO implements Serializable {

	private static final long serialVersionUID = -3642310382243888892L;

	@ApiModelProperty(value = "Error code")
	private int errorCode;

	@Builder(builderMethodName = "operationErrorDTOBuilder")
	public OperationErrorDTO(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
}
