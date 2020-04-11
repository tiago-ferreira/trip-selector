package br.com.mio.di.bao.trip.selector.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
public class FileReader {

	public Stream<String> readFile(String path, boolean isClasspath) throws IOException {
		if (isClasspath) {
			try {
				System.out.println("Classpath");
				return Files.lines(Paths.get(getClass().getClassLoader().getResource(path).toURI()));

			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
		return Files.lines(Paths.get(path));
	}

	public Boolean isReadable(String path) {
		return Files.isReadable(Paths.get(path));
	}
}
