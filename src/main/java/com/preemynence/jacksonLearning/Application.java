package com.preemynence.jacksonLearning;

import com.preemynence.jacksonLearning.examples.JSONToFileAndFileToJSON;
import com.preemynence.jacksonLearning.examples.JacksonDataBindExample;
import com.preemynence.jacksonLearning.examples.JacksonStreamExample;
import com.preemynence.jacksonLearning.examples.JacksonTreeModelExample;

public class Application {

	public static void main(String args[]){

		Examples examples = new JSONToFileAndFileToJSON();
		System.out.println("Running JSONToFileAndFileToJSON");
		examples.runExample();
		examples = new JacksonStreamExample();
		System.out.println("Running JacksonStreamExample");
		examples.runExample();
		examples = new JacksonTreeModelExample();
		System.out.println("Running JacksonTreeModelExample");
		examples.runExample();
		examples = new JacksonDataBindExample();
		System.out.println("Running JacksonDataBindExample");
		examples.runExample();
	}

}
