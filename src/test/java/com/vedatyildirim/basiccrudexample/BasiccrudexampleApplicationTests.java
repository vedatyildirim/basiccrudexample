package com.vedatyildirim.basiccrudexample;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.vedatyildirim.basiccrudexample.controller.PostController;
import org.junit.jupiter.api.Test;

@SpringBootTest
class BasiccrudexampleApplicationTests {

	@Autowired
	private PostController controller;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
