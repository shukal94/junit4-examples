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
package de.systemoutprintln.junit4examples.rules;

import static org.hamcrest.core.Is.isA;
import static org.hamcrest.core.AllOf.allOf;

import static de.systemoutprintln.junit4examples.matchers.HasMessage.hasMessage;

import com.zebrunner.agent.core.annotation.Maintainer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

@Maintainer("sshukalovich")
public class ExpectedExceptionRuleTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void unexpectedException() {
		// uh uh, didn't see that coming...
		throw new RuntimeException();
	}

	@Test
	public void wrongExpectedException() {
		thrown.expect(IllegalArgumentException.class);
		throw new RuntimeException();
	}

	@Test
	public void expectedException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("null");
		throw new IllegalArgumentException("Argument must not be null");
	}

	@Test
	public void expectedCause() {
		thrown.expectCause(isA(NullPointerException.class));
		throwWrappedNpe();
	}

	@Test
	public void expectCauseWithMatchers() {
		thrown.expectCause(allOf(isA(NullPointerException.class), hasMessage("null")));
		throwWrappedNpe();
	}

	private void throwWrappedNpe() {
		NullPointerException theCause = new NullPointerException("Argument must not be null");
		RuntimeException ex = new RuntimeException(theCause);
		throw ex;
	}

	
}
