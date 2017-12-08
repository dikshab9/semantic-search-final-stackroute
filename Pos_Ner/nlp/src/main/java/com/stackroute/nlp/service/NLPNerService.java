package com.stackroute.nlp.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.nlp.domain.NerModel;
import com.stackroute.nlp.kafka.SenderPoS;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;


@Service
public class NLPNerService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());



	
	
	@Autowired
	SenderPoS sender;
	
	NerModel nermodel=new NerModel();
	public void findName(String[] words) throws IOException {
		System.out.println("WORDS"+words.length);
		
		for(String word:words) {
			System.out.println(word);
		}
		
		InputStream is = new FileInputStream("ner-custom-model.bin");

		// load the model from file
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();

		// feed the model to name finder class
		NameFinderME nameFinder = new NameFinderME(model);



		//String[] result=new String[words.length];
		ArrayList<String> result=new ArrayList<String>();
		Span nameSpans[]=null;
			for (int i=0;i<words.length;i++) {
			nameSpans = nameFinder.find(words);
			}


			// nameSpans contain all the possible entities detected
			int start=0, end=0;
			for(Span s: nameSpans){
				logger.info(s.toString());
				logger.info("  :  ");
				//System.out.println("ANJALI");
				start=s.getStart();
				end=s.getEnd();
				System.out.println(s.getStart());
				System.out.println(s.getEnd());
				
			}
				// s.getStart() : contains the start index of possible name in the input string array
				// s.getEnd() : contains the end index of the possible name in the input string array
				for(int index=start;index<end;index++){
					result.add(words[index]);
					
					//logger.info("RESULT");
					//logger.info(result.get(index)+" ");
				}
				
				
				for(int i1=0;i1<result.size();i1++)
					logger.info(result.get(i1));
		

			
//		}
			
			nermodel.setKeywords(result);
			ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(words));
			nermodel.setWords(arrayList);
			
			System.out.println("INSIDE SERVICE");
			System.out.println(nermodel.getKeywords());
			System.out.println(nermodel.getWords());
			sender.sendner(nermodel);
			
			
	}
	
	

		
	}
	




