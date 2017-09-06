package com.qait.training.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YamlReader {

	static Yaml yaml = new Yaml();
	static String yamlFilePath = "src/test/resources/Yaml.yml";
	static Reader doc = null;

	public static void setYamlPath() {
		try {
			doc = new FileReader(yamlFilePath);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}

	}

	public static String getProperty(String type) {
		setYamlPath();
		Map<String, String> result = (Map<String, String>) yaml.load(doc);
		return result.get(type);
	}
}
