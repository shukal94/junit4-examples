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
package de.systemoutprintln.junit4examples.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class HasMessage<T extends Throwable> extends TypeSafeMatcher<T> {

	private String substring;

	public HasMessage(String substring) {
		this.substring = substring;
	}

	public void describeTo(Description description) {
		description.appendText("Message should contain ").appendValue(substring);
	}

	@Override
	protected boolean matchesSafely(T throwable) {
		if (throwable.getMessage() != null) {
			return throwable.getMessage().contains(substring);
		}
		return false;
	}
	
	@Factory
	public static <T extends Throwable> Matcher<T> hasMessage(String substring) {
		return new HasMessage<T>(substring);
	}

}
