package br.com.mio.di.bao.trip.selector.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileReader {
	
	@Value("${trip.file.path}")
	private String tripFilePath;
	
	@Value("${trip.file.is.on.the.aplication.resources}")
	private boolean tripFileIsOnTheApplicationResources;

	public Stream<String> readFile() throws IOException {
		if (tripFileIsOnTheApplicationResources) {
			try {
				System.out.println("Classpath");
				return Files.lines(Paths.get(getClass().getClassLoader().getResource(tripFilePath).toURI()));

			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
		return Files.lines(Paths.get(tripFilePath));
	}

	public Boolean isReadable(String path) {
		return Files.isReadable(Paths.get(path));
	}
}
