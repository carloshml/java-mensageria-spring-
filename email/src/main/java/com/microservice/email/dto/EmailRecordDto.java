package com.microservice.email.dto;

import java.util.UUID;

public record EmailRecordDto(UUID id,
		String emailTo,
		String subject,
		String text
		) {

}
