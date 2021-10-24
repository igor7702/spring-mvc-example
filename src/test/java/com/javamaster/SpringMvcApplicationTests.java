package com.javamaster;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ParameterResolver;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import com.javamaster.model.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringMvcApplicationTests {
	@BeforeAll
	static void beforeAll(TestInfo testInfo) {
		System.out.println("Before all take parameters. Started: " + testInfo.getDisplayName());
	}

	@BeforeAll
	static void beforeAll(TestReporter testReporter) {
		testReporter.publishEntry("myEntry", "myValue");
	}

	@BeforeAll
	static void beforeAll(TestInfo testInfo, TestReporter testReporter) {
		testReporter.publishEntry("myOtherEntry", testInfo.getDisplayName());
	}

	@BeforeEach
	void beforeEach(){
		System.out.println("Run my test!");
	}

	@BeforeEach
	void beforeEach(TestInfo testInfo) {

	}

	@Test
	void contextLoads() {
	}

	@DisplayName("JUnit5 - GetRaceFromDB()")
	@Test
	void GetRaceFromDB(){
	}

	@DisplayName("JUnit5 - SetRaceToDB()")
	@Test
	void SetRaceToDB(){
	}

	@DisplayName("JUnit5 - Calculator + ")
	@Test
	void addsTwoNumbers() {
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
	}


}
