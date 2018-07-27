package com.preemynence.jackson;

import com.preemynence.jackson.examples.JSONToFileAndFileToJSON;
import com.preemynence.jackson.examples.JacksonDataBindExample;
import com.preemynence.jackson.examples.JacksonStreamExample;
import com.preemynence.jackson.examples.JacksonTreeModelExample;
import com.preemynence.jackson.scenarios.Scenario1;

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
		examples = new Scenario1();
		System.out.println("Running Scenario1");
		examples.runExample();
	}

}
