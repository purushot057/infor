package com.infor.utilities;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.Test;

public class ModifyingInputStreamTest {

	@Test
	public void testRead() throws IOException {
		byte[] input = "abc abc abc def".getBytes();
		String result = "pqr pqr pqr def";
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
				InputStream is = new ModifyingInputStream(new ByteArrayInputStream(input), "abc".getBytes(),
						"pqr".getBytes());) {
			int b = 0;
			while ((b = is.read()) > 0) {
				bos.write(b);
			}
			assertTrue(result.equals(bos.toString("UTF-8")));
		}

	}

}
