package com.jk.explore.spring.ioc.xml.simple;

import com.jk.explore.spring.ioc.xml.simple.domain.Domain;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SimpleXmlBasedContainerTest {

    @Test
    void context() {
        SimpleXmlBasedContainer container = new SimpleXmlBasedContainer("/xml/context/simpleContext.xml");
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

    @Test
    void resourceCreation() throws IOException {
        URL url = new URL("https", "google.com", "");
        Resource urlResource = new UrlResource(url);
        byte[] bytes = urlResource.getContentAsByteArray();
        String content = new String(bytes, StandardCharsets.UTF_8);
        assertNotNull(content);
    }

    @Test
    void resourceCreationFromXmlConfig() {
        SimpleXmlBasedContainer container = new SimpleXmlBasedContainer("xml/context/url-resource-creation.xml");
        URL url = container.getContext().getBean("googleHomePageUrl", URL.class);
        assertNotNull(url);
        UrlResource urlResource = container.getContext().getBean("googleUrlResource", UrlResource.class);
        assertNotNull(urlResource);
    }

}
