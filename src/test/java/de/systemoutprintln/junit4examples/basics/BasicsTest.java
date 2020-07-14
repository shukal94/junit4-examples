/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.systemoutprintln.junit4examples.basics;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

//import ch.qos.logback.classic.Logger;
import de.systemoutprintln.junit4examples.categories.ClientTest;
import de.systemoutprintln.junit4examples.categories.RemoteServicesTest;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
//import org.slf4j.LoggerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasicsTest {

//	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(BasicsTest.class);
//private final static Logger LOGGER = Logger.getLogger(BasicsTest.class);
private Logger LOGGER = LogManager.getLogger(BasicsTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("This is executed once before any test runs.");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("This is executed once after all tests have been run.");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("This is executed once before every test.");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("This is executed once after every test.");
	}

	@Test
	public void passingTest() {
		System.out.println("I'm a simple test that passes!");
	}
	
	@Test
	public void failingTest() {
		System.out.println("I fail! :(");
		fail();
	}

	@Test
	public void failingTestWithException() {
		LOGGER.info("Logback info");
		LOGGER.debug("Logback debug");
		LOGGER.error("Logback error");
		System.out.println("I fail with an unexpected Exception!");
		throw new RuntimeException();
	}

	@Test(expected =  IllegalArgumentException.class)
	public void failingTestWithWrongException() {
		System.out.println("I fail, because the wrong exception is thrown!");
		throw new RuntimeException();
	}

	@Test(expected = RuntimeException.class)
	public void passingTestWithExpectedException() {
		System.out.println("I pass, although an exception is thrown!");
		throw new RuntimeException();
	}

	@Test
	@Ignore
	public void ignoredTest() {
		System.out.println("I'm ignored :-(");
		fail();
	}

	@Test(timeout=1000)
	public void passingTestWithTimeout() {
		System.out.println("I pass because my exception doesn't take too long.");
	}

	@Test(timeout=1000)
	public void failingTestWithTimeout() throws Exception {
		System.out.println("I fail because my exception takes too long.");
		TimeUnit.SECONDS.sleep(2);
	}
	
}
