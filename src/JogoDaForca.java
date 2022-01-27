import java.util.Scanner;

public class JogoDaForca {
	static int contadorTemas = 0;
	static String[][] TemasEPalavras = new String[52][52];
	static Scanner ler = new Scanner(System.in);

	public static void main(String[] args) {
		preCadastro();
		menu();
	}

	public static void clear() {
		System.out.print("\n\n\n\n\n\n\n\n\n\n");
	}

	public static void menu() {
		int menu;

		do {
			System.out.println("Bem vindos ao Jogo Da Forca! Para continuar, escolha o que pretende fazer: ");
			System.out.println("1- Gerenciar meus temas disponiveis");
			System.out.println("2- Gerenciar as palavras em meus temas");
			System.out.println("3- Jogar!");
			System.out.println("4 Sair...");

			menu = ler.nextInt();
			ler.nextLine();
			switch (menu) {
				case 1:
					clear();
					gerenciarTemas();
					break;
				case 2:
					clear();
					// gerenciarPalavras(TemasEPalavras,contadorTemas,contadorPalavras);
					break;
				case 3:
					clear();
					// jogo(TemasEPalavras);
					break;
				case 4:
					// esta dando buffer
					System.out.println("Obrigado por jogar!");
					break;
				default:
					System.out.println("Nao ha nada atribuido a esse numero.Selecione uma opcao valida");
					break;
			}

		} while (menu != 4);

	}

	static void gerenciarTemas() {
		int menu;

		do {
			System.out.println("Gerenciador de temas iniciado com sucesso!");
			System.out.println("Escolha uma das opcoes abaixo:");
			System.out.println("1-Cadastrar Temas(farei uma lista para você se orientar, voce pode ignora-la caso queira)");
			System.out.println("2-Excluir Tema");
			System.out.println("3-Buscar Tema");
			System.out.println("4-Voltar");

			menu = ler.nextInt();
			ler.nextLine();

			switch (menu) {
				case 1:
					gerenciarTemas_cadastro();
					break;

				case 2:

					break;

				case 3:
					gerenciarTemas_buscar();
					break;

				case 4:

					break;

				default:

					System.out.println("Opcao invalida neste escopo, digite uma funcao disponivel.");

					break;

			}
		} while (menu != 4);

	}

	private static void gerenciarTemas_buscar() {

	}

	private static void gerenciarTemas_cadastro() {
		char listar;
		String novoTema;
		boolean existe = false;

		System.out.println("Iniciando o cadastro de temas!");
		System.out.println("Lista com temas ja disponiveis:");
		System.out.println("Caso nao queira checar, digite N/n para ignorar.");

		listar = ler.next().charAt(0);
		ler.nextLine();

		if (!(listar == 'N' || listar == 'n')) {
			gerenciarTemas_imprimirTemas();
		}

		System.out.println("Digite o tema que deseja adicionar:");
		novoTema = ler.next();
		ler.nextLine();
		existe = gerenciarTemas_checarExistencia(novoTema);

		if (existe == false) {
			gerenciarTemas_salvarNovoTema(novoTema);
			System.out.println("Tema cadastrado com sucesso!");
		} else {
			System.out.println("Tema existente.Recadastre outro ou selecione outra funcionalidade.");
		}
		System.out.println("Aperte ENTER para continuar:");
		ler.nextLine();
	}

	private static void gerenciarTemas_salvarNovoTema(String novoTema) {
		JogoDaForca.TemasEPalavras[contadorTemas][0] = novoTema;
		contadorTemas++;
	}

	private static boolean gerenciarTemas_checarExistencia(String novoTema) {
		boolean encontrei = false;
		for (int i = 0; i < JogoDaForca.contadorTemas; i++) {
			if (novoTema.equals(JogoDaForca.TemasEPalavras[i][0])) {

				encontrei = true;
				break;
			}
		}
		return encontrei;
	}

	private static void gerenciarTemas_imprimirTemas() {
		for (int i = 0; i < JogoDaForca.contadorTemas; i++) {
			System.out.printf("%d - %s\n", (i + 1), JogoDaForca.TemasEPalavras[i][0]);
		}

		System.out.println("Aperte ENTER para continuar:");
		ler.nextLine();

	}

	public static void preCadastro() {
		String[] Carros = { "Carros", "10", "Monza", "Opala", "Marea", "Doblo",
				"Ferrari", "Mustang", "Porsche", "Uno", "Gol",
				"Punto" };
		String[] Objetos = { "Objetos", "10", "Cadeira", "Chave", "Bola", "Lousa", "Giz",
				"Lapis", "Caneta", "Borracha",
				"Canivete", "Regua" };
		String[] Animais = { "Animais", "10", "Cachorro", "Gato", "Cavalo", "Iguana",
				"Ratel", "Anta", "Hipopotamo", "Girafa",
				"Galinha", "Pato" };
		String[] Paises = { "Paises", "10", "Eslovaquia", "Franca", "Belgica", "Alemanha",
				"Brasil", "Russia", "Mexico",
				"Butao", "India", "China" };
		String[] Cores = { "Cores", "10", "Amarelo", "Vermelho", "Preto", "Cinza",
				"Branco", "Azul", "Verde", "Laranja",
				"Bege", "Marrom" };

		for (int i = 0; i < 11; i++) {
			JogoDaForca.TemasEPalavras[0][i] = Carros[i];
			JogoDaForca.TemasEPalavras[1][i] = Objetos[i];
			JogoDaForca.TemasEPalavras[2][i] = Animais[i];
			JogoDaForca.TemasEPalavras[3][i] = Paises[i];
			JogoDaForca.TemasEPalavras[4][i] = Cores[i];
		}

		JogoDaForca.contadorTemas += 5;

	}

}
