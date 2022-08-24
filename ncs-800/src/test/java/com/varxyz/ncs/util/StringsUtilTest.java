package com.varxyz.ncs.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringsUtilTest {

	@Test
	void testExtractIntCharacters() {
//		fail("Not yet implemented");
		StringsUtil su = new StringsUtil();
		assertEquals("1234", su.extractIntCharacters("test1234"));
		assertEquals("", su.extractIntCharacters("test"));
		assertEquals("1234", su.extractIntCharacters("test-4"));
	}

	@Test
	void testExtractNum() {
//		fail("Not yet implemented");
		StringsUtil su = new StringsUtil();
		assertEquals(1234, su.extractNum("tarts1234"));
		assertEquals(1234, su.extractNum("tarts"));
		assertEquals(-4, su.extractNum("tarts-4"));
	}

}
