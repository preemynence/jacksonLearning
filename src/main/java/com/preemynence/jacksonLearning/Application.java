package com.preemynence.jacksonLearning;

import com.preemynence.jacksonLearning.examples.JSONToFileAndFileToJSON;
import com.preemynence.jacksonLearning.examples.JacksonStreamExample;
import com.preemynence.jacksonLearning.examples.JacksonTreeModelExample;

public class Application {

	public static void main(String args[]){
		new JSONToFileAndFileToJSON().runExample();
		new JacksonStreamExample().runExample();
		new JacksonTreeModelExample().runExample();
	}

}
