import java.util.Scanner;
import java.util.Random;

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
					jogo();
					break;
				case 4:
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
		String[] Carros = { "carros", "10", "monza", "opala", "marea", "doblo",
				"ferrari", "mustang", "porsche", "uno", "gol",
				"punto" };
		String[] Objetos = { "objetos", "10", "cadeira", "chave", "bola", "lousa", "giz",
				"lapis", "caneta", "borracha",
				"canivete", "regua" };
		String[] Animais = { "animais", "10", "cachorro", "gato", "cavalo", "iguana",
				"ratel", "anta", "hipopotamo", "girafa",
				"galinha", "pato" };
		String[] Paises = { "paises", "10", "eslovaquia", "franca", "belgica", "alemanha",
				"brasil", "russia", "mexico",
				"butao", "india", "china" };
		String[] Cores = { "cores", "10", "amarelo", "vermelho", "preto", "cinza",
				"branco", "azul", "verde", "laranja",
				"bege", "marrom" };

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

		listar = Character.toLowerCase(ler.next().charAt(0));
		ler.nextLine();

		if (!(listar == 'N' || listar == 'n')) {
			gerenciarTemas_imprimirTemas();
		}

		System.out.println("Digite o tema que deseja adicionar:");
		novoTema = ler.next().toLowerCase();
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

		buscador = ler.next().toLowerCase();
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
		for (int posicao = 0; posicao < JogoDaForca.contadorTemas; posicao++) {
			if (buscador.equals(JogoDaForca.TemasEPalavras[posicao][0])) {
				return posicao;
			}
		}
		return -1;
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
		tema = ler.next().toLowerCase();
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
		palavra = ler.next().toLowerCase();
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
		tema = ler.next().toLowerCase();
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
			String Palavra = ler.next().toLowerCase();
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

	private static void jogo() {
		String tema;
		String[] temaEscolhido;
		int posicaoTema;
		boolean rejogar = true;
		System.out.println("Iniciando o Jogo Da Forca!");
		do {
			System.out.println("Escolha em qual tema voce deseja sortear a palavra para acertar:");
			gerenciarTemas_imprimirTemas();

			System.out.println("Qual tema deseja escolher?");
			tema = ler.next().toLowerCase();
			ler.nextLine();
			posicaoTema = gerenciarTemas_ferramentaDeBusca(tema);

			if (posicaoTema == -1) {
				System.out.println(
						"Esse tema nao existe!Pode cadastra-lo(recomendado se estiver jogando com mais uma pessoa) se quiser.");
				continue;
			}
			temaEscolhido = JogoDaForca.TemasEPalavras[posicaoTema];
			String palavraEscolhida = jogo_escolherPalavra(temaEscolhido);
			rejogar = jogo_iniciarRodada(palavraEscolhida.toCharArray(), palavraEscolhida.length());
		} while (rejogar != false);
	}

	private static String jogo_escolherPalavra(String[] temaEscolhido) {
		Random numberGenerator = new Random();
		int indiceEscolhido;
		do {
			indiceEscolhido = numberGenerator.nextInt(Integer.parseInt(temaEscolhido[1]));
		} while (indiceEscolhido <= 1);
		return temaEscolhido[indiceEscolhido];
	}

	private static boolean jogo_iniciarRodada(char[] palavraEscolhida, int tamanhoPalavraEscolhida) {
		char[] letrasChutadas = new char[tamanhoPalavraEscolhida + 5];
		char[] letrasCorretas = jogo_iniciarRodada_letrasCorretas(tamanhoPalavraEscolhida);
		char letraLida;
		int qtdLetrasChutadas = 0;
		int erros = 0;
		int acertos = 0;
		char jogarDnv;

		jogo_iniciarRodada_forca(tamanhoPalavraEscolhida, letrasCorretas, erros);
		while (erros < 5 && acertos < tamanhoPalavraEscolhida) {
			System.out.println("");
			System.out.println("Digite a letra que deseja chutar: ");
			letraLida = Character.toLowerCase(ler.next().charAt(0));
			ler.nextLine();

			if (jogo_iniciarRodada_checarRepetidas(letrasChutadas, letraLida, qtdLetrasChutadas)) {
				System.out.println("Tente outra letra!");
				continue;
			}
			int acertoAtual = jogo_iniciarRodada_checarChute(letrasCorretas, palavraEscolhida, tamanhoPalavraEscolhida,
					letraLida);
			if (acertoAtual != 0) {
				acertos += acertoAtual;
			} else {
				erros++;
			}
			letrasChutadas[qtdLetrasChutadas] = letraLida;
			qtdLetrasChutadas++;
			jogo_iniciarRodada_forca(tamanhoPalavraEscolhida, letrasCorretas, erros);
		}
		System.out.println("");
		if (acertos == tamanhoPalavraEscolhida) {
			System.out
					.println("Voce acertou a palavra!Deseja jogar novamente?S para rejogar, qualquer outra coisa para nao.");
		} else if (erros == 5) {
			System.out.println("Voce perdeu! Deseja jogar novamente?S para rejogar,qualquer outra coisa para nao.");
		}
		jogarDnv = Character.toLowerCase(ler.next().charAt(0));
		ler.nextLine();

		return jogarDnv == 's';
	}

	private static int jogo_iniciarRodada_checarChute(char[] letrasCorretas, char[] palavraEscolhida,
			int tamanhoPalavraEscolhida, char letraEscolhida) {
		int acertos = 0;
		for (int i = 0; i < tamanhoPalavraEscolhida; i++) {
			if (palavraEscolhida[i] == letraEscolhida) {
				letrasCorretas[i] = letraEscolhida;
				acertos++;
			}
		}
		return acertos;
	}

	private static void jogo_iniciarRodada_forca(int tamanhoPalavraEscolhida, char[] letrasCorretas, int erros) {
		System.out.printf("Adivinhe a seguinte palavra!Voce possui %d tentativas.\n", (5 - erros));
		System.out.println("--------");
		System.out.println("|      |");
		System.out.println("|");
		System.out.println("|");
		System.out.print("| ");

		for (int i = 0; i < tamanhoPalavraEscolhida; i++) {
			System.out.print(letrasCorretas[i] + " ");
		}
	}

	private static boolean jogo_iniciarRodada_checarRepetidas(char[] letrasChutadas, char letraLida,
			int qtdLetrasChutadas) {
		for (int i = 0; i < qtdLetrasChutadas; i++) {
			if (letrasChutadas[i] == letraLida) {
				return true;
			}
		}
		return false;
	}

	private static char[] jogo_iniciarRodada_letrasCorretas(int tamanhoPalavraEscolhida) {
		char[] retorno = new char[tamanhoPalavraEscolhida];
		for (int i = 0; i < tamanhoPalavraEscolhida; i++) {
			retorno[i] = '_';
		}
		return retorno;
	}

}
