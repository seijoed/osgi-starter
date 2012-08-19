package com.packt.osgi.starter.consumer;

import java.util.TimerTask;

import com.packt.osgi.starter.producer.RequestResponseApi;

public class ConsoleResponder extends TimerTask {

    private RequestResponseApi request;

    public ConsoleResponder(RequestResponseApi request) {
        this.request = request;
    }

    @Override
    public void run() {
        System.out.println(request.getResponse("Time is " + System.currentTimeMillis()));
    }
}
