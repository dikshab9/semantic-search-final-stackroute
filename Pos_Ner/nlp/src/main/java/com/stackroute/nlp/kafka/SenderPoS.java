package com.stackroute.nlp.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.nlp.domain.NerModel;
import com.stackroute.nlp.domain.PosModel;



@Service
public class SenderPoS {
	
	@Autowired
	private KafkaTemplate<String, PosModel> kafkaTemplate;


	String kafkaTopic="posproducer1";
	
	
	@Autowired
	private KafkaTemplate<String, NerModel> kafkaTemplate1;
	
	String kafkaTopic1="nerproducer5";
	
	public void send(PosModel posmodel) {
		

		kafkaTemplate.send(kafkaTopic, posmodel);
		System.out.println("PoS Model is sending: ");
		System.out.println(posmodel.getWords());
		System.out.println(posmodel.getPos());
		

		
	}
	
public void sendner(NerModel nermodel) {
		
	System.out.print("Ner model is sending: ");

	System.out.println("keywords" +nermodel.getKeywords());
	System.out.println("query" +nermodel.getWords());
		kafkaTemplate1.send(kafkaTopic1, nermodel);
		
		
	}

}
