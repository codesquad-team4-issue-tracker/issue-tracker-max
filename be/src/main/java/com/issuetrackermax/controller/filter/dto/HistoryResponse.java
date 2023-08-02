package com.issuetrackermax.controller.filter.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
public class HistoryResponse {
	private String editor;
	private LocalDateTime modifiedAt;

	@Builder
	public HistoryResponse(String editor, LocalDateTime modifiedAt) {
		this.editor = editor;
		this.modifiedAt = modifiedAt;
	}
}
