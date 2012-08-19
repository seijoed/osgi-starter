package com.packt.osgi.starter.consumer;

import java.util.Timer;

import com.packt.osgi.starter.producer.RequestResponseApi;

public class SimpleResponseConsumer {

    //This is an injected OSGi service that is implemented by the producer module.
    private RequestResponseApi request;

    public void init() {
        Timer timer = new Timer();
        //Start the task with a fixed delay of 5000 ms after 500 ms.
        timer.scheduleAtFixedRate(new ConsoleResponder(request), 500l, 5000l);

    }

    public void setRequest(RequestResponseApi request) {
        this.request = request;
    }
}
