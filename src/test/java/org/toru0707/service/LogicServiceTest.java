package org.toru0707.service;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.toru0707.entity.Entries;

public class LogicServiceTest {

	EntriesService service = new EntriesService();

	@Test
	@Ignore
	public void testStub() {
		Entries result = service.getEntryById("");
		Assert.assertThat(result, null);
	}
}
