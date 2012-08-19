package com.packt.osgi.starter.tests;

import javax.inject.Inject;

import com.packt.osgi.starter.producer.RequestResponseApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.ExamReactorStrategy;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.ops4j.pax.exam.spi.reactors.AllConfinedStagedReactorFactory;
import org.osgi.framework.BundleContext;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.ops4j.pax.exam.CoreOptions.junitBundles;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.OptionUtils.combine;

@RunWith(JUnit4TestRunner.class)
@ExamReactorStrategy(value = AllConfinedStagedReactorFactory.class)

public class ProducerAndConsumerTest {

    @Inject
    BundleContext bundleContext = null;

    @Inject
    private RequestResponseApi request;

    @Configuration
    public Option[] config() {
        Option[] options = combine(options(mavenBundle("org.osgi", "org.osgi.compendium"),
            mavenBundle("asm", "asm-all"),
            mavenBundle("org.apache.aries", "org.apache.aries.util").versionAsInProject(),
            mavenBundle("org.apache.aries.blueprint", "org.apache.aries.blueprint").versionAsInProject(),
            mavenBundle("org.apache.aries.proxy", "org.apache.aries.proxy").versionAsInProject(),
            mavenBundle("asm","asm-all"),

            junitBundles(), mavenBundle("starter", "producer").versionAsInProject(),
            mavenBundle("starter", "consumer").versionAsInProject()));

        return options;
    }

    @Test
    public void testServiceRegistration() {
        assertNotNull(request);
        assertTrue("You called the service with ding".equals(request.getResponse("ding")));
    }
}
