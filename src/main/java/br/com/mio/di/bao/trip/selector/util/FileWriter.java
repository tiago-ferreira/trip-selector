package br.com.mio.di.bao.trip.selector.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileWriter {
	
	@Value("${trip.file.path}")
	private String tripFilePath;
	
	@Value("${trip.file.is.on.the.aplication.resources}")
	private boolean tripFileIsOnTheApplicationResources;

	public boolean writeEndOfAFile(String content) throws URISyntaxException {
		Path filePathObj = (tripFileIsOnTheApplicationResources) ? Paths.get(getClass().getClassLoader().getResource(tripFilePath).toURI())
				: Paths.get(tripFilePath);
		if (Files.exists(filePathObj)) {
			try {
				Files.write(filePathObj, content.getBytes(), StandardOpenOption.APPEND);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
