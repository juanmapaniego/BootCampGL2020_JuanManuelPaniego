package com.globallogic.bootcampgl.error;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseJsonError {
	private String message;
	private Integer status_code;
	private String uri;
}
