package com.example.banknote.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
	private static final String FILE_NAME = "data_storage.txt";

	public static String getCred() {
		String returnValue = "";
		FileReader file = null;

		try {
			file = new FileReader(FILE_NAME);
			BufferedReader reader = new BufferedReader(file);
			String line = "";
			while ((line = reader.readLine()) != null) {
				returnValue += line + "\n";
			}
			reader.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					// Ignore issues during closing
				}
			}
		}
		return returnValue;
	}

	public static void addCred(String cred) {
		FileWriter output = null;
		try {
			output = new FileWriter(FILE_NAME);
			BufferedWriter writer = new BufferedWriter(output);
			writer.write(cred);
			writer.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					// Ignore issues during closing
				}
			}
		}

	}
}
