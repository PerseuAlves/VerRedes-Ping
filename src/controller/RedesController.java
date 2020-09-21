package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {
		super();
	}

	public void ip(String so) {

/////////// Windows //////////////////////////////////////////////////////////////

		if (so.contains("Win")) {
			try {
				int i = 0;
				int ips = 0;
				int Nomes = 0;
				String linha;
				/* String Nome[] = new String[i]; linha: 37 */
				/* String ip[] = new String[ips]; linha: 38 */
				Process p = Runtime.getRuntime().exec("ipconfig");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				while (i < 4) {
					linha = buffer.readLine();
					i++;
				}
				linha = buffer.readLine();
				while (linha != null) {
					if (linha.contains("Adaptador Ethernet")) {
						Nomes++;
					} else if (linha.contains("IPv4")) {
						ips++;
					}
					linha = buffer.readLine();
					if (linha == null) {
						linha = buffer.readLine();
					}
				}
				String Nome[] = new String[Nomes];
				String ip[] = new String[ips];
				buffer.close();
				leitor.close();
				fluxo.close();

///////////	Segunda chamada do processo ip ///////////////////////////////////////

				i = 0;
				ips = 0;
				Nomes = 0;
				Process p2 = Runtime.getRuntime().exec("ipconfig");
				InputStream fluxo2 = p2.getInputStream();
				InputStreamReader leitor2 = new InputStreamReader(fluxo2);
				BufferedReader buffer2 = new BufferedReader(leitor2);
				while (i < 4) {
					linha = buffer2.readLine();
					i++;
				}
				linha = buffer2.readLine();
				while (linha != null) {
					if (linha.contains("Adaptador Ethernet")) {
						Nome[Nomes] = linha;
						Nomes++;
					} else if (linha.contains("IPv4")) {
						ip[ips] = linha.substring(49);
						ips++;
					}
					linha = buffer2.readLine();
					if (linha == null) {
						linha = buffer2.readLine();
					}
				}
				buffer2.close();
				leitor2.close();
				fluxo2.close();

				for (i = 0; i < ips; i++) {
					System.out.println(Nome[i]);
					System.out.println(ip[i]);
				}
///////////	Fim da segunda chamada do processo ip ////////////////////////////////

			} catch (Exception e) {
				String msgError = e.getMessage();
				System.err.println(msgError);
			}

///////////	Linux ////////////////////////////////////////////////////////////////		

		} else if (so.contains("Lin")) {
			try {
				int i = 0;
				int y = 0;
				int sim = 0;
				int ips = 0;
				int Nomes = 0;
				String linha;
				/* String Nome[] = new String[i]; linha: 37 */
				/* String ip[] = new String[ips]; linha: 38 */
				Process p = Runtime.getRuntime().exec("ifconfig");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				linha = buffer.readLine();
				while (linha != null) {
					if (linha.contains("mtu")) {
						Nomes++;
					} else if (linha.contains("netmask")) {
						ips++;
					}
					linha = buffer.readLine();
					if (linha == null) {
						linha = buffer.readLine();
					}
				}
				String Nome[] = new String[Nomes];
				String ip[] = new String[ips];
				buffer.close();
				leitor.close();
				fluxo.close();

///////////	Segunda chamada do processo ip ///////////////////////////////////////

				i = 0;
				ips = 0;
				Nomes = 0;
				Process p2 = Runtime.getRuntime().exec("ifconfig");
				InputStream fluxo2 = p2.getInputStream();
				InputStreamReader leitor2 = new InputStreamReader(fluxo2);
				BufferedReader buffer2 = new BufferedReader(leitor2);
				linha = buffer2.readLine();
				while (linha != null) {
					if (linha.contains("mtu")) {
						Nome[Nomes] = linha;
						Nomes++;
					} else if (linha.contains("netmask")) {
						ip[ips] = linha;
						ips++;
					}
					linha = buffer2.readLine();
					if (linha == null) {
						linha = buffer2.readLine();
					}
				}
				buffer2.close();
				leitor2.close();
				fluxo2.close();

				for (i = 0; i < ips; i++) {
					y = 0;
					String[] vetorNome = Nome[i].split(" ");
					for (String IpNome : vetorNome) {
						if (y == 0) {
							System.out.println(IpNome);
							y++;
						}
					}
				}

				System.out.println(" ");
				System.out.println("ipv4 respectivos: ");
				System.out.println(" ");

				for (i = 0; i < ips; i++) {
					String[] vetorIp = ip[i].split(" ");
					for (String Ip : vetorIp) {
						if (sim == 1) {
							System.out.println(Ip);
							sim = 0;
						} else if (Ip.contains("inet")) {
							sim = 1;
						}
					}
				}
///////////	Fim da segunda chamada do processo ip ////////////////////////////////

			} catch (Exception e) {
				String msgError = e.getMessage();
				System.err.println(msgError);
			}
		}
	}

	public void ping(String so) {

		if (so.contains("Win")) {
			try {
				int i = 0;
				int y = 0;
// var[]	String vet[] = new String[];
				Process p = Runtime.getRuntime().exec("PING -n 10 www.google.com.br");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					// System.out.println(linha);
					linha = buffer.readLine();
					if (linha.contains("dia")) {
						String[] vetorMS = linha.split(" ");
						for (String MS : vetorMS) {
							i++;
						}
						y = i;
						i = 0;
						String[] vetorMS2 = linha.split(" ");
						for (String MS2 : vetorMS2) {
							i++;
							if (i == y) {
								System.out.println(MS2);
							}
						}
						linha = null;
					}
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (Exception e) {
				String msgError = e.getMessage();
				System.err.println(msgError);
			}
		} else if (so.contains("Lin")) {
			try {
				int i = 0;
				int y = 0;
				int sim = 0;
// var[]	String vet[] = new String[];
				Process p = Runtime.getRuntime().exec("ping -c 10 www.google.com.br");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					// System.out.println(linha);
					linha = buffer.readLine();
					if (linha.contains("mdev")) {
						String[] vetorMS = linha.split("/");
						for (String MS : vetorMS) {
							if (i == 4) {
								System.out.println(MS + " ms");
							}
							i++;
						}

						linha = null;
					}
					if ((linha == null) & (sim == 0)) {
						linha = buffer.readLine();
						sim++;
					}

				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (Exception e) {
				String msgError = e.getMessage();
				System.err.println(msgError);
			}
		}
	}
}
