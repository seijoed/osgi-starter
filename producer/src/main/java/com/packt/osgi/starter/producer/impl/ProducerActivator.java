package com.packt.osgi.starter.producer.impl;

import com.packt.osgi.starter.producer.RequestResponseApi;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ProducerActivator implements BundleActivator {

    RequestResponseApi requestResponse = new RequestResponseService();
    ServiceRegistration registration;

    public void start(BundleContext bundleContext) throws Exception {
        //Register the service with the container.
        //Register the Interface, implementation and possible properties
        registration = bundleContext.registerService(RequestResponseApi.class.getName(), requestResponse, null);
    }

    public void stop(BundleContext bundleContext) throws Exception {
        //When we stop, clean up the references.
        registration.unregister();
    }
}
