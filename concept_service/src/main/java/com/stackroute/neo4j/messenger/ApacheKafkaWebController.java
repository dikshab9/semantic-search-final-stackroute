package com.stackroute.neo4j.messenger;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ApacheKafkaWebController {

	@Autowired
	Sender kafkaSender;


	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

//	@RequestMapping()
//	public ResponseEntity<?> getOneResults() {
//		kafkaSender.send("heya");
//		return new ResponseEntity<String>("heya", HttpStatus.OK);
//	}
	
	@RequestMapping()
	public ResponseEntity<?> sendclass() {
		Concept user=new Concept(1,"Java","class");
		kafkaSender.sendclass(user);
		return new ResponseEntity<Concept>(user, HttpStatus.OK);
	}
	
	

}