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

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Category can be used as class level annotation. This will add all methods to
 * the given category-
 */
@Category(value = { IntegrationTests.class })
public class RemoteServicesTest {

	@Test
	public void aTest() {
		System.out.println("I'm slow, because my class annotation says so!");
	}
	
	@Test
	public void anotherTest() {
		System.out.println("I'm also slow...");
	}
}
