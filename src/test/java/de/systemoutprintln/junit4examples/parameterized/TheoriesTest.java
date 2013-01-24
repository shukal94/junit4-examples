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
package de.systemoutprintln.junit4examples.parameterized;

import static org.junit.Assume.assumeTrue;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheoriesTest {

	@DataPoints
	public static int[] sizes = new int[]{0, 1, 10, 250, 2500, 10000};

	@Theory
	public void chunkTheory(int aParameter, int anotherParameter) {
		// we don't want to execute tests if aParameter is less than anotherParameter
		assumeTrue(anotherParameter > 0);
		
		// this combination fails for some reason...
		if (aParameter == 10 && anotherParameter == 10000) {
			throw new RuntimeException();
		}
	}
}
