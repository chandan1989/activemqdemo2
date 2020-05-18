package com.example.amsenderdemo.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ListenerDemo {

    @JmsListener(destination = "amsenderdemo-queue1")
    public void listener(String message) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Received : " + message);


    }
}
