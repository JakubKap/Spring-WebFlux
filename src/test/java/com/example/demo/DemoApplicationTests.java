package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		Flux.just("Jacob", "Anna", "Ron")
						.filter(x -> x.startsWith("J"))
								.subscribe(System.out::println);
//		Mono.just()

	}

}
