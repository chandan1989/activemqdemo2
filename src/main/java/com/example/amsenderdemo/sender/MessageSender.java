package com.example.amsenderdemo.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
@RequestMapping("/amsenderdemo")
public class MessageSender {

    @Autowired
    private Queue queue;

    @Autowired
    JmsTemplate jmsTemplate;

    @GetMapping("/{message}")
    public String sendMessage(@PathVariable("message") final String message) throws Exception {
        String status= "Not Published";
        try{
            jmsTemplate.convertAndSend(queue,message);
            status = "message : '" + message +  "' published successfully";
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }

        return status;
    }
}
