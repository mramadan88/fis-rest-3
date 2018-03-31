package com.rahmed.redhat.demo.mongodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//https://docs.mongodb.com/v3.0/tutorial/create-an-auto-incrementing-field/#auto-increment-optimistic-loop
@Service
public class CustomSequenceService {
	@Autowired
	private CustomSequencesRepository customSequencesRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomSequenceService.class);
	public long getNext(String sequenceId) {
		CustomSequences counter = customSequencesRepository.findOne(sequenceId);
		if (counter==null) 
		{
			counter = new CustomSequences();
			counter.setId(sequenceId);
			counter.setSeq(1);
		}
		
		logger.info("CustomSequences == "+counter);
		long seq = counter.getSeq();
		counter.setSeq(seq + 1);
		customSequencesRepository.save(counter);
		return seq;
	}
}
