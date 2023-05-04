package view;

import java.io.IOException;

import controller.FileController;

public class Main {

	public static void main(String[] args) {
		FileController fc = new FileController();
		
		try {
			fc.getFruits();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
