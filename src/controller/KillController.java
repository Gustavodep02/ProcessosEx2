package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	public KillController() {
		
	}
	private String os(){
		return System.getProperty("os.name");// pega o SO e retorna
	}
	public void listaProcessos() {//listar processos
		String os= os();
		Process process;
		String processo = "ps -ef";
		if (os.contains("Windows")) {
			processo = "TASKLIST /FO TABLE";
		}
		try {
			process =Runtime.getRuntime().exec(processo);
			InputStream fluxo = process.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha !=null) {
				System.out.println(linha);
					linha = buffer.readLine();
				
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void mataPid(int pid) {
		String os= os();
		Process process;
		String processo = ("kill -9 "+pid);
		if (os.contains("Windows")) {
			processo = ("TASKKILL /F /PID "+pid);
		}
		try {
			process =Runtime.getRuntime().exec(processo);
	}
		catch(Exception e) {
			e.printStackTrace();
		}
}
public void mataNome(String nome) {
	String os= os();
	Process process;
	String processo = ("TASKKILL /IM "+nome);
	if (os.contains("Windows")) {
		processo = ("TASKKILL /F /PID "+nome);
	}
	try {
		process =Runtime.getRuntime().exec(processo);
}
	catch(Exception e) {
		e.printStackTrace();
	}
}}
