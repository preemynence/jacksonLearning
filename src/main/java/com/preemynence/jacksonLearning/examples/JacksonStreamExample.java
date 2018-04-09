package com.preemynence.jacksonLearning.examples;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.preemynence.jacksonLearning.Examples;

import java.io.File;
import java.io.IOException;

public class JacksonStreamExample implements Examples {

	private String fileName = "target/streamExample.json";

	public void runExample() {
		streamWriter();
		streamReader();
	}

	private void streamReader() {
		try {

			JsonFactory jsonFactory = new JsonFactory();

			// read from file
			JsonParser jParser = jsonFactory.createParser(new File(fileName));

			readObject(jParser);

			jParser.close();

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	private void streamWriter() {
		try {

			JsonFactory jsonFactory = new JsonFactory();

			// write to file
			JsonGenerator jGenerator = jsonFactory.createGenerator(new File(fileName
			), JsonEncoding.UTF8);
			jGenerator.writeStartObject(); // {
			jGenerator.writeArrayFieldStart("colors");
			{
				int[] val = {255, 255, 255, 1};
				writeColorObject(jGenerator, "black", "hue", "primary", val, "#000");
				val[0] = 0;
				val[1] = 0;
				val[2] = 0;
				val[3] = 1;
				writeColorObject(jGenerator, "white", "value", null, val, "#FFF");
				val[0] = 255;
				val[1] = 0;
				val[2] = 0;
				val[3] = 1;
				writeColorObject(jGenerator, "red", "hue", "primary", val, "#F00");
				val[0] = 0;
				val[1] = 0;
				val[2] = 255;
				val[3] = 1;
				writeColorObject(jGenerator, "blue", "hue", "primary", val, "#00F");
				val[0] = 255;
				val[1] = 255;
				val[2] = 0;
				val[3] = 1;
				writeColorObject(jGenerator, "yellow", "hue", "primary", val, "#FF0");
				val[0] = 0;
				val[1] = 255;
				val[2] = 0;
				val[3] = 1;
				writeColorObject(jGenerator, "green", "hue", "secondary", val, "#0F0");
			}
			jGenerator.writeEndArray();

			jGenerator.close();

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	private void writeColorObject(JsonGenerator jGenerator, String color, String category, String type, int[] rgba, String hex) throws IOException {
		jGenerator.writeStartObject();
		{
			jGenerator.writeStringField("color", color);
			jGenerator.writeStringField("category", category);
			jGenerator.writeStringField("type", type);
			jGenerator.writeFieldName("code");
			{
				jGenerator.writeStartObject();
				jGenerator.writeArrayFieldStart("rgba");
				{
					for (int i = 0; i < rgba.length; i++) {
						jGenerator.writeNumber(rgba[i]);
					}
				}
				jGenerator.writeEndArray();
				jGenerator.writeStringField("hex", hex);
			}
			jGenerator.writeEndObject();
		}
		jGenerator.writeEndObject();
	}

	private void readObject(JsonParser jParser) throws IOException {
		// loop until token equal to "}"

		while (getNextToken(jParser) != JsonToken.END_ARRAY) {
			while (getNextToken(jParser) != JsonToken.END_OBJECT) {
				String fieldName = jParser.getCurrentName();
				if ("color".equals(fieldName)) {
					getNextToken(jParser);
					System.out.println("color=" + jParser.getText()); // display mkyong
				} else if ("category".equals(fieldName)) {
					getNextToken(jParser);
					System.out.println("category=" + jParser.getText()); // display mkyong
				} else if ("type".equals(fieldName)) {
					getNextToken(jParser);
					System.out.println("type=" + jParser.getText()); // display mkyong
				} else if ("code".equals(fieldName)) {
					while (getNextToken(jParser) != JsonToken.END_OBJECT) {
						fieldName = jParser.getCurrentName();
						if ("rgba".equals(fieldName)) {
							System.out.print("rgba=[");
							if(getNextToken(jParser) == JsonToken.START_ARRAY) {
								while (getNextToken(jParser) != JsonToken.END_ARRAY) {
									Integer value = jParser.getValueAsInt();
									if (value != null) {
										System.out.print(value + " ");
									}
								}
							}
							System.out.println("]");
						} else if ("hex".equals(fieldName)) {
							getNextToken(jParser);
							System.out.println("hex=" + jParser.getText()); // display mkyong
						}
					}
				}
			}
			System.out.println("-------------------");

		}
	}

	private JsonToken getNextToken(JsonParser jParser) throws IOException {
		JsonToken token = jParser.nextToken();
		return token;
	}

}