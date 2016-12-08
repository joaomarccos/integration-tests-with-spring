
package io.github.joaomarccos.testecommockspring.tomcat.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldService {

	@Value("${name:World}")
	private String name;

	public String getHelloMessage() {
            System.out.println("Hello message invoked");
		return "Hello " + this.name;
	}

}
