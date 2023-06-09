package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileService {

	 String directory = "C:\\temp";
	 String fileFormat = "csv";
	
	public  void run(String fileName, String data) throws Exception {
		File file = new File(makeFilePath(fileName));
		
		if (file.exists() && file.isFile()) {
			appendFile(file, data);
			return;
		}
		
		if (file.exists() && file.isDirectory()) {
			throw new Exception("O arquivo n�o pode ser um diret�rio");
		}
		
		createFile(file, data);
	}
	
	private String makeFilePath(String fileName) {
		return String.format("%s" + "\\" + fileName + ".%s", directory, fileFormat);
	}
	
	private void createFile(File file, String data) throws IOException {
		FileWriter fwrite = new FileWriter(file, false);
		
		writeOnFile(fwrite, data);
		
		fwrite.close();
	}
	
	private void appendFile(File file, String data) throws IOException {
		FileWriter fwrite = new FileWriter(file, true);

		writeOnFile(fwrite, data);
		
		fwrite.close();
	}
	
	private void writeOnFile(FileWriter fwrite, String data) {
		PrintWriter print = new PrintWriter(fwrite);

		print.write(data);
		print.flush();
		print.close();
	}
	
	public String readData(String fileName) throws IOException {
		File file = new File(makeFilePath(fileName));
				
		if (file.exists() && file.isFile()) {
			FileInputStream fluxo = new FileInputStream(file);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			
			BufferedReader buffer = new BufferedReader(leitor);
			
			String linha = buffer.readLine();
			StringBuffer text = new StringBuffer();
			
			while (linha != null) {
				text.append(linha + "\r\n");

				linha = buffer.readLine();
			}
			
			buffer.close();
			leitor.close();
			fluxo.close();
			
			return text.toString();
		} else {
			throw new IOException("Arquivo n�o existe");
		}
	}

}