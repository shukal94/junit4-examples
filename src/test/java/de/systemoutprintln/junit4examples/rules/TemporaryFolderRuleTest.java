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

import static de.systemoutprintln.junit4examples.matchers.IsFileExisting.exists;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TemporaryFolderRuleTest {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	
	private static File txtFile, tempFolder;
	
	@Test
	public void createTempFile() throws IOException {
		txtFile = folder.newFile("some.txt");
		
		// it actually exists! :)
		assertTrue(txtFile.exists());
		// and we can write to it...
		assertTrue(txtFile.canWrite());
		// let's try that
		FileUtils.writeStringToFile(txtFile, "I'm writing to a temp file!");
		String contents = FileUtils.readFileToString(txtFile);

		assertEquals("I'm writing to a temp file!", contents);
	}

	@Test
	public void createTempFolder() throws IOException {
		// the same works for dirs... nice!
		tempFolder = folder.newFolder("tmp");

		// TODO add some examples
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// everything is cleaned up after test execution
		assertThat(txtFile, not(exists()));
		assertThat(tempFolder, not(exists()));
	}

}
