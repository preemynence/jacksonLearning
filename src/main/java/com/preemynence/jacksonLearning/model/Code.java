package com.preemynence.jacksonLearning.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Code {
	private int[] rgba;
	@JsonProperty(required = true)
	private String hex;
}