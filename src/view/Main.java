package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		
		RedesController Control = new RedesController();
		String so = System.getProperty("os.name");
		
		int Opc = 0;
        while (Opc != 9){
            Opc = Integer.parseInt(JOptionPane.showInputDialog("\n      Atividade 1 \n 1 – ip \n 2 – ping \n 9 - sair"));
            switch (Opc){
                case 1:
                	Control.ip(so);
                	System.out.println(" ");
                    break;
                case 2:
                	Control.ping(so);
                	System.out.println(" ");
                    break;
                case 9:
                    System.out.println("Finalizado");
                    break;
                default:
                    System.out.println("Erro, digite novamente");
            }
        }
	}
}
