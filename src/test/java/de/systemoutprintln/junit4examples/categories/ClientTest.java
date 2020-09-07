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
package de.systemoutprintln.junit4examples.categories;

import com.zebrunner.agent.core.annotation.Maintainer;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Only some tests are declared as being slow, so not all tests will be executed
 * by the SlowTestsSuite
 */
@Maintainer("sshukalovich")
public class ClientTest {

	private final static Logger LOGGER = Logger.getLogger(ClientTest.class);
	@Test
	public void fastTest() {
		LOGGER.info("Log4j info");
		System.out.println("I run fast!");
	}
	
	@Test
	@Category(value = { SlowTests.class })
	public void slowTest() {
		System.out.println("I'm a slow running test...");
	}

	@Test
	@Category(value = { PerformanceTests.class })
	public void performanceTest() {
		System.out.println("I test performance and may therefore be slow...");
	}
	
}
