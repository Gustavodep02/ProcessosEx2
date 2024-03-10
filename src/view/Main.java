package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {
		KillController k = new KillController();
		int escolha = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opcao:\n1- Listar processos\n2- Matar por pid\n3- Matar por nome"));
		switch(escolha) {
		case 1:
			k.listaProcessos();
			break;
		case 2:
			int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o pid para matar"));
			k.mataPid(pid);
			break;
		case 3:
			String nome = JOptionPane.showInputDialog("Digite o nome do processo para matar");
			k.mataNome(nome);
			break;
		default:
			System.out.println("numero invalido");
		}

	}

}
