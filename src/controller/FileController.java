package controller;

import java.io.IOException;

import service.FileService;

public class FileController {

	private String fileName = "generic_food";
	private String groupSearch = "Fruits";
	private FileService service;
	
	public FileController() {
		this.service = new FileService();
	}
	
	public void getFruits() throws IOException {
		String data = service.readData(this.fileName);
		
		String[] rawData = data.split("\r\n");
		
		for (String line : rawData) {
			String[] fruitType = line.split(",");
			if (fruitType[2].contains(this.groupSearch)) {
				System.out.println("======================");
				System.out.println(line);
				System.out.println("======================");
			}
		}
	}
}
