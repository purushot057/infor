package com.infor.utilities;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This utility class holds the methods that fundamentally modifies the input stream
 * 
 * @author Purushottam S.
 * @version 1.0
 *
 */
public class ModifyingInputStream extends FilterInputStream {

	private Queue<Integer> inQueue;
	private Queue<Integer> outQueue;
	private final byte[] searchBytes;
	private final byte[] replacementBytes;

	public ModifyingInputStream(InputStream in, byte[] search, byte[] replacement) {
		super(in);
		this.inQueue = new LinkedList<>();
		this.outQueue = new LinkedList<>();
		this.searchBytes = search;
		this.replacementBytes = replacement;
	}

	@Override
	public int read() throws IOException {
		// Next byte already determined.
		while (outQueue.isEmpty()) {
			readAhead();
			if (isMatchFound()) {
				for (byte searchByte : searchBytes) {
					inQueue.remove();
				}

				for (byte replacementByte : replacementBytes) {
					outQueue.offer((int) replacementByte);
				}
			} else {
				outQueue.add(inQueue.remove());
			}
		}
		return outQueue.remove();
	}

	// Check if match exists for each byte in searchBytes
	private boolean isMatchFound() {
		Iterator<Integer> iterator = inQueue.iterator();
		for (byte searchByte : searchBytes) {
			if (!iterator.hasNext() || searchByte != iterator.next()) {
				return false;
			}
		}
		return true;
	}

	// Keep reading until max length of searchBytes
	private void readAhead() throws IOException {
		while (inQueue.size() < searchBytes.length) {
			int next = super.read();
			inQueue.offer(next);
			if (next == -1) {
				break;
			}
		}
	}
}
