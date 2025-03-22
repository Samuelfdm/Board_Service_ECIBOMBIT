package edu.eci.arsw.Board;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootTest
@EnableMongoRepositories(basePackages = "edu.eci.arsw.Board.repository")
class BoardApplicationTests {

	@Test
	void contextLoads() {
	}

}
