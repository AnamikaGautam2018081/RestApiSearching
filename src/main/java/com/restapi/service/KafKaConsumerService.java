package com.restapi.service;

import com.restapi.model.AppConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

 
@Service
public class KafKaConsumerService 
{
    @Autowired
    private MyService myService;

    private final Logger logger = 
            LoggerFactory.getLogger(KafKaConsumerService.class);
 
    @KafkaListener(topics = AppConstants.TOPIC_NAME, 
            groupId = AppConstants.GROUP_ID)
    public void consume(String message) 
    {
      
        logger.info(String.format("Received Patient id is -> %s", message));
          System.out.println(myService.saveOrUpdate(message));
          System.out.println("kafkaend");
    }
}