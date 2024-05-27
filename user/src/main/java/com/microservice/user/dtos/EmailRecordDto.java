package com.microservice.user.dtos;

import java.util.UUID;

public record EmailRecordDto(
		UUID id,
		String emailTo,
		String subject,
		String text
		) {

}
