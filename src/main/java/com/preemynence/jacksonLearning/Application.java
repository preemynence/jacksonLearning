package com.preemynence.jacksonLearning;

import com.preemynence.jacksonLearning.examples.JSONToFileAndFileToJSON;
import com.preemynence.jacksonLearning.examples.JacksonStreamExample;

public class Application {

	public static void main(String args[]){
		Examples examples = new JSONToFileAndFileToJSON();
		examples.runExample();
		examples = new JacksonStreamExample();
		examples.runExample();
	}

}
