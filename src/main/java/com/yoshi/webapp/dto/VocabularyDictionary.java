package com.yoshi.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VocabularyDictionary {
	
	private Long id;
	private String text;
	private String meaning;
	
}
