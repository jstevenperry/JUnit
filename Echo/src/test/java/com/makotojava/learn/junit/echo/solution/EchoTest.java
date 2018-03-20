/*
 * Copyright 2018 Makoto Consulting Group Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.makotojava.learn.junit.echo.solution;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * Test the Echo class.
 * 
 * @author J Steven Perry
 *
 */
@DisplayName("Testing the Echo class")
@RunWith(JUnitPlatform.class)
public class EchoTest {

  /**
   * The class under test
   */
  private Echo classUnderTest;

  @Test
  @Disabled("This test is ambiguous... which echo method is it testing??")
  public void testEcho() {
    // Hm, which echo() method do I test here?
  }

  @Nested
  @DisplayName("When testing the String overload of the echo method...")
  class StringEchoTest {

    @Test
    @DisplayName("...I should get the exact string passed in")
    public void testEcho() {
      classUnderTest = new Echo();

      String expectedString = "This is a test";

      assertAll("String version of echo() method",
          // equals() should match, but that's not good enough
          () -> assertEquals(expectedString, classUnderTest.echo(expectedString))
          // hash codes should match, but that's not quite good enough
          , () -> assertEquals(expectedString.hashCode(), classUnderTest.echo(expectedString).hashCode())
          // this should do the trick
          , () -> assertEquals(System.identityHashCode(expectedString),
              System.identityHashCode(classUnderTest.echo(expectedString))));
    }

  }

  @Nested
  @DisplayName("When testing the Integer overload of the echo method...")
  class IntegerEchoTest {

    @Test
    @DisplayName("...I should get the exact Integer passed in")
    public void testEcho() {
      classUnderTest = new Echo();

      Integer expectedInteger = Integer.valueOf(238);

      assertAll("Integer version of echo() method",
          // equals() should match, but that's not good enough
          () -> assertEquals(expectedInteger, classUnderTest.echo(expectedInteger))
          // hash codes should match, but that's not quite good enough
          , () -> assertEquals(expectedInteger.hashCode(), classUnderTest.echo(expectedInteger).hashCode())
          // this should do the trick
          , () -> assertEquals(System.identityHashCode(expectedInteger),
              System.identityHashCode(classUnderTest.echo(expectedInteger))));
    }

  }

}
