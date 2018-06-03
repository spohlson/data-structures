package com.practice.utilities;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Dictionary {

	private Set<String> wordsSet;

	public Dictionary() throws IOException {
		Path path = Paths.get("src/main/resources/words.txt");
		byte[] readBytes = Files.readAllBytes(path);
		String wordListContents = new String(readBytes, StandardCharsets.UTF_8);
		String[] words = wordListContents.split("\\r?\\n");
		wordsSet = new HashSet<>(words.length);
		Collections.addAll(wordsSet, words);
	}

	public boolean contains(String word) {
		return wordsSet.contains(word);
	}

}
