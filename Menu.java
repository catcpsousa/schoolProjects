package Trabalho1;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    /**
     * String que quando chamada mostra uma mensagem de ajuda
     */
    private static final String ajuda = """
            As opções disponíveis são:
            + r i: somar
            - r i: subtrair
            * r i: multiplicar
            / r i: dividir
            q: elevar o número complexo à potência\s
            s: calcular o simétrico do número complexo\s
            c: calcular o conjugado do número complexo\s
            i: calcular o inverso do número complexo\s
            h: mostra operações para o histórico
            t: trocar operação e recalcular histórico
            l: limpa a tela da calculadora e o histórico de operações
            a: mostra esta mensagem de ajuda
            e: encerra a calculadora
            """;

    /**
     * Instância privada da Classe Calculator
     */
    private final Calculator c;
    private final History h;

    /**
     * Objeto do tipo classe ComplexNumber
     */
    ComplexNumber num = new ComplexNumber();
    private char op;

    public Menu(Calculator calc, History hist) {
        this.c = calc;
        this.h = hist;
    }

    /**
     * Método de exibição da mensagem inicial da calculadora
     */
    private void displayMenu(){
        System.out.println("Bem vindo à calculadora de números complexos");
        System.out.println("Introduza a letra 'a' e pressione ENTER para visualizar a ajuda");
    }

    /**
     * Método responsável por limpar a visor da consola
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Responsável por receber a entrada do utilizador, realizar uma operação de acordo com o comando inserido
     * e exibir o resultado no visor. É usado a classe Scanner para ler a entrada do utilizador passada como parâmetro
     * e, em seguida, divide a entrada num array de strings usando o espaço como separador. Verifica a primeira string
     * do array para determinar qual operação deve ser realizada e, em seguida, lê os próximos dois valores como a parte
     * real e imaginária do número complexo.
     * @param input entrada do utilizador
     */
    public void input(String input){

        Scanner teclado = new Scanner(System.in);
        String[] tokens = input.split(" ");
        op = tokens[0].charAt(0);
        double r = 0.0, i = 0.0;
        num = new ComplexNumber(r, i);
        System.out.print("Visor: ");
        if(input.length() == 1){
            switch (op) {
                case 'q' -> {
                    System.out.println("Qual o valor do expoente?");
                    //verificar continuamente se o próximo token é um inteiro,
                    // enquanto o utilizador não digitar um valor válido.
                    while (!teclado.hasNextInt()) {
                        System.out.println("Por favor, digite um valor inteiro para o expoente:");
                        teclado.next(); // limpa a entrada inválida
                    }
                    int exp = teclado.nextInt();
                    c.expNComplexo(exp);
                }
                case 's' -> c.simNComplexo();
                case 'c' -> c.conjNComplexo();
                case 'i' -> c.invNComplexo();
                case 'h' -> {
                    System.out.println("1 - Mostrar Histórico");
                    System.out.println("2 - Apagar uma operação do Histórico");
                    System.out.println("3 - Apagar todo o Histórico");
                    int opcao = teclado.nextInt();
                    switch (opcao) {
                        case 1 -> h.mostrarHistorico();
                        case 2 -> {
                            h.mostrarHistorico();
                            System.out.println();
                            System.out.println("Qual o id da operação que deseja apagar?");
                            int id = teclado.nextInt();
                            h.removerOp(id);
                        }
                        case 3 -> h.limparHistorico();
                    }
                }
                case 't' -> {
                    h.mostrarHistorico();
                    System.out.println();
                    System.out.println("Índice da primeira operação a ser trocada:");
                    int i1 = teclado.nextInt();
                    System.out.println("Índice da segunda operação a ser trocada:");
                    int i2 = teclado.nextInt();
                    h.trocarOperacao(i1, i2);
                }
                case 'a' -> System.out.println(ajuda);
                case 'l' -> clearScreen();
                default -> System.out.println("Comando inválido. Digite 'a' para ajuda.");
            }
        } else {
            if(tokens.length < 3){
                System.out.println("Entrada inválida. Tente de novo. Digite 'a' para ajuda.");
            } else{
                try {
                    r = Double.parseDouble(tokens[1]);
                    i = Double.parseDouble(tokens[2]);
                    num = new ComplexNumber(r, i);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Tente de novo. Digite 'a' para ajuda.");
                    return;
                }
                switch (op) {
                    case '+' -> {
                        c.somarNComplexo(num);
                    }
                    case '-' -> c.subtrairNComplexo(num);
                    case '*' -> c.multiplicarNComplexo(num);
                    case '/' -> c.dividirNComplexo(num);
                    default -> System.out.println("Comando inválido. Digite 'a' para ajuda.");
                }

            }
        }

    }

    /**
     *  Loop principal do programa, que permite ao utilizador interagir com a calculadora de números complexos.
     *  Começa por criar um objeto Scanner para ler a entrada do utilizador, exibe o menu da calculadora e entra
     *  num loop while que só termina quando o utilizador digita o comando "e" para sair do programa.
     *  A cada iteração do loop, o programa lê a entrada do utilizador, chama o método input() para processar a entrada
     *  e exibe o resultado da operação no visor. Se o utilizador digita o comando "l", o programa limpa a tela
     *  e o histórico da calculadora antes de continuar. Por fim, o Scanner é fechado para libertar os recursos do sistema.
     */
    public void run(){

        Scanner teclado = new Scanner(System.in);
        boolean run = true;
        displayMenu();
        while (run){
            System.out.print(">");
            String input = teclado.nextLine();
            op = input.charAt(0);
            if (op == 'l') {
                clearScreen();
                h.limparHistorico();
                continue;
            }
            if (op == 'e'){
                System.out.println("Obrigada por utilizar a calculadora de números complexos");
                run = false;
            }else{
                input(input);
                System.out.println(c.getNumeroAtual());
            }
        }
        teclado.close();
    }
}
