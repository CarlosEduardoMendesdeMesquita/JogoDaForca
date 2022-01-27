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
					gerenciarPalavras();
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

		for (int i = 0; i < 12; i++) {
			JogoDaForca.TemasEPalavras[0][i] = Carros[i];
			JogoDaForca.TemasEPalavras[1][i] = Objetos[i];
			JogoDaForca.TemasEPalavras[2][i] = Animais[i];
			JogoDaForca.TemasEPalavras[3][i] = Paises[i];
			JogoDaForca.TemasEPalavras[4][i] = Cores[i];
		}

		JogoDaForca.contadorTemas += 5;

	}

	private static void gerenciarTemas_imprimirTemas() {
		for (int i = 0; i < JogoDaForca.contadorTemas; i++) {
			System.out.printf("%d - %s\n", (i + 1), JogoDaForca.TemasEPalavras[i][0]);
		}

		System.out.println("Aperte ENTER para continuar:");
		ler.nextLine();

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

	private static void gerenciarTemas_buscar() {
		String buscador;
		System.out.println("Iniciando a busca de temas!");
		System.out.println("Digite o Tema que deseja buscar: ");

		buscador = ler.next();
		ler.nextLine();

		int posicao = gerenciarTemas_ferramentaDeBusca(buscador);
		if (posicao == -1) {
			System.out.println("Tema nao encontrado.Voce pode cadastra-lo caso queira.");
		} else {
			System.out.printf("Tema encontrado na posicao %d\n", (posicao + 1));
		}
		System.out.println("Aperte ENTER para continuar.");
		ler.nextLine();
		clear();

	}

	private static int gerenciarTemas_ferramentaDeBusca(String buscador) {
		boolean encontrei = false;
		int posicao;
		for (posicao = 0; posicao < JogoDaForca.contadorTemas; posicao++) {
			if (buscador.equals(JogoDaForca.TemasEPalavras[posicao][0])) {

				encontrei = true;
				break;
			}
		}
		if (encontrei == false) {
			return -1;
		} else {
			return posicao;
		}
	}

	private static void gerenciarPalavras() {
		int menu;

		do {

			System.out.println("Gerenciador de palavras iniciado com sucesso!");
			System.out.println("Escolha uma das opcoes abaixo:");
			System.out.println("1-Cadastrar palavra:");
			System.out.println("2-Excluir palavras");
			System.out.println("3-Buscar palavras");
			System.out.println("4-Listar palavras");
			System.out.println("5-Voltar");

			menu = ler.nextInt();
			ler.nextLine();

			switch (menu) {
				case 1:
					gerenciarPalavras_cadastro();
					break;

				case 2:

					break;

				case 3:
					gerenciarPalavras_buscar();
					break;

				case 4:
					gerenciarPalavras_Listar();
					break;

				case 5:

					break;

				default:
					System.out.println("Opcao invalida neste escopo, digite uma funcao disponivel.");
					break;

			}
		} while (menu != 5);
	}

	private static void gerenciarPalavras_Listar() {
		String tema;
		int posicao;

		System.out.println("Funcao listar palavras iniciada com sucesso!");
		System.out.println("Para auxiliar, segue a lista de temas existentes.");
		gerenciarTemas_imprimirTemas();

		System.out.println("Deseja listar as palavras de que tema?");
		tema = ler.next();
		ler.nextLine();
		posicao = gerenciarTemas_ferramentaDeBusca(tema);
		if (posicao == -1) {
			System.out.println("Esse tema nao foi cadastrado.Voce pode faze-lo caso queira.");
		} else {
			gerenciarPalavras_ferramentaDeListagem(posicao);
		}
	}

	private static void gerenciarPalavras_ferramentaDeListagem(int posicao) {
		String[] Tema = JogoDaForca.TemasEPalavras[posicao];
		int TamanhoDoTema = Integer.parseInt(Tema[1]);

		for (int i = 2; i < TamanhoDoTema + 2; i++) {
			System.out.printf("%d - %s\n", (i - 1), Tema[i]);
		}
		System.out.println("Aperte ENTER para continuar.");
		ler.nextLine();
	}

	private static void gerenciarPalavras_buscar() {
		String palavra;
		int posicao;
		System.out.println("Iniciando a busca de palavras!");
		System.out.println("Qual palavra voce deseja buscar?");
		palavra = ler.next();
		ler.nextLine();
		posicao = gerenciarPalavras_ferramentaDeBusca(palavra);
		if (posicao == -1) {
			System.out.println("Palavra nao encontrada");
		} else {
			System.out.printf("Palavra encontrada no tema %s\n", JogoDaForca.TemasEPalavras[posicao][0]);
		}
		System.out.println("Aperte ENTER para continuar.");
		ler.nextLine();
	}

	private static int gerenciarPalavras_ferramentaDeBusca(String palavra) {
		for (int i = 0; i < JogoDaForca.contadorTemas; i++) {
			String[] Tema = JogoDaForca.TemasEPalavras[i];
			int TamanhoDoTema = Integer.parseInt(Tema[1]);
			for (int j = 2; j < TamanhoDoTema + 2; j++) {
				if (Tema[j].equals(palavra)) {
					return i;
				}
			}
		}
		return -1;
	}

	private static void gerenciarPalavras_cadastro() {
		String tema;
		int posicao;
		System.out.println("Cadastrar palavras iniciado com sucesso!");
		System.out.println("Primeiro, escolha o tema em que deseja cadastrar a palavra:");
		tema = ler.next();
		ler.nextLine();
		posicao = gerenciarTemas_ferramentaDeBusca(tema);
		if (posicao == -1) {
			System.out.println(("Esse tema ainda nao existe!Voce pode cadastra-lo caso queira."));
		} else {
			gerenciarPalavras_cadastrarPalavras(posicao);
		}
	}

	private static void gerenciarPalavras_cadastrarPalavras(int posicao) {
		String[] Tema = JogoDaForca.TemasEPalavras[posicao];
		int tamanhoTema = Integer.parseInt(Tema[1]);// transformar de string para int.
		int Cadastro;
		System.out.println("Quantas palavras deseja cadastrar?");
		Cadastro = ler.nextInt();
		ler.nextLine();
		int i = 0;
		while (i < Cadastro) {
			System.out.println("Digite a palavra que deseja cadastrar:");
			String Palavra = ler.next();
			ler.nextLine();
			if (gerenciarPalavras_checarExistencia(Palavra, Tema)) {
				System.out.println("Esta palavra ja esta cadastrada.");
				continue;
			} else {
				Tema[tamanhoTema + 2] = Palavra;
				tamanhoTema++;
				Tema[1] = "" + tamanhoTema;// gambiarra para transformar o numero em uma string.
				i++;
			}
		}
		System.out.println("Palavras cadastradas com suceso!");
		System.out.println("Aperte ENTER para continuar.");
		ler.nextLine();
	}

	private static boolean gerenciarPalavras_checarExistencia(String Palavra, String[] Tema) {
		boolean encontrei = false;
		int tamanho = Integer.parseInt(Tema[1]);
		for (int i = 2; i < tamanho + 2; i++) {
			if (Palavra.equals(Tema[i])) {

				encontrei = true;
				break;
			}
		}
		return encontrei;
	}

}
