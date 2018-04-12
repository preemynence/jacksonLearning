package com.preemynence.jacksonLearning.examples;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class JacksonTreeModelExample implements com.preemynence.jacksonLearning.Examples {

	private String fileName = "target/streamExample.json";

	@Override
	public void runExample() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(new File(fileName));

			JsonNode colors = root.path("colors");

			for (JsonNode oneColor : colors) {
				JsonNode node = oneColor;

				JsonNode color = node.path("color");
				System.out.print("color : " + color.asText() + ",");

				JsonNode category = node.path("category");
				System.out.print("category : " + category.asText() + ",");

				JsonNode type = node.path("type");
				System.out.print("type : " + type.asText() + ",");

				JsonNode codesNode = node.path("code");
				{
					Iterator<JsonNode> rgba = codesNode.path("rgba").elements();
					System.out.print("code : [ ");
					while (rgba.hasNext()) {
						System.out.print(rgba.next().asInt() + ",");
					}

					System.out.print("],");
					JsonNode hex = codesNode.path("hex");
					System.out.println("hex : " + hex.asText());
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
