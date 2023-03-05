package com.jk.explore.spring.ioc.xml.simple;

import com.jk.explore.spring.ioc.xml.simple.domain.Domain;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SimpleXmlBasedContainerTest {

    @Test
    void context() {
        SimpleXmlBasedContainer container = new SimpleXmlBasedContainer("/simpleContext.xml");
        assertNotNull(container);
        ClassPathXmlApplicationContext context = container.getContext();
        assertNotNull(context);
        Domain myDomain = context.getBean("myDomain", Domain.class);
        assertNotNull(myDomain);
        Domain domain = context.getBean("domain", Domain.class);
        assertNotNull(domain);
        assertEquals(myDomain, domain);
        org.assertj.core.api.Assertions.assertThat(context.containsBean("myDomain")).isTrue();
    }

}
