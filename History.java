package Trabalho1;

import java.util.ArrayList;

public class History {

    /**
     * ArrayList "historico" que armazena objetos do tipo "Operation".
     * "final" pois não pode ser reatribuído depois de inicializado,
     * garantindo que sempre irá referir-se ao mesmo ArrayList durante a execução do programa.
     */
    private final ArrayList<Operation> historico = new ArrayList<Operation>();

    /**
     *  Objeto ComplexNumber chamado "num" e o inicializa com os valores 0 + 0i por padrão.
     *  Utilizado para armazenar o resultado atual das operações matemáticas realizadas com o histórico de operações.
     */
    private ComplexNumber num = new ComplexNumber(0,0);

    /**
     * Responsável por limpar o histórico de operações armazenado no objeto History, removendo todas as operações
     * previamente adicionadas à lista histórico. Isso é feito utilizando o método clear() da classe ArrayList.
     */
    public void limparHistorico(){
        historico.clear();
    }

    /**
     * Adiciona uma operação ao histórico de operações da calculadora.
     * @param op operação a ser adicionada
     */
    public void adicionar(Operation op){
        historico.add(op);
    }

    /**
     * Remove uma operação específica do histórico
     * @param i índice da operação a ser removida
     */
    public void removerOp(int i){
        historico.remove(i);
        System.out.println("Operação apagada!");
    }

    /**
     * Imprimir no visor o histórico inteiro de operações realizadas
     * É percorrida a lista com um loop for, onde para cada item da
     * lista é exibido o índice e a operação realizada
     */
    public void mostrarHistorico(){
        if(historico.size() == 0){
            System.out.println("Histórico vazio!");
        }else{
            System.out.println("Histórico:");
            for(Operation op : historico){
                System.out.println(historico.indexOf(op) + " - " + op.toString());
            }
        }
    }

    /**
     * Troca a posição de duas operações no histórico e recalcula o número resultante a partir da troca do histórico.
     * @param index1 índice da primeira operação a ser trocada.
     * @param index2 índice da segunda operação a ser trocada.
     * @throws IllegalArgumentException se algum dos índices for inválido.
     */
    public void trocarOperacao(int index1, int index2) {
        // Verifica se o índice está dentro dos limites do histórico
        if (index1 < 0 || index1 >= historico.size() || index2 < 0 || index2 >= historico.size()) {
            throw new IllegalArgumentException("Índice inválido!");
        }

        // Troca as operações nos índices especificados
        Operation temp = historico.get(index1);
        historico.set(index1, historico.get(index2));
        historico.set(index2, temp);

        // Recalcula todas as operações posteriores à operação trocada
        num = new ComplexNumber(0, 0); // Reinicia o número
        for (int i = 0; i < historico.size(); i++) {
            Operation op = historico.get(i);
            if (op.getTipo() == '+') {
                num = num.somar(op.getNum());
            } else if (op.getTipo() == '-') {
                num = num.subtrair(op.getNum());
            } else if (op.getTipo() == '*') {
                num = num.multiplicar(op.getNum());
            } else if (op.getTipo() == '/') {
                num = num.dividir(op.getNum());
            } else if (op.getTipo() == '^') {
                num = num.expoente(op.getNum().getReal());
            } else if (op.getTipo() == 's') {
                num = num.simetrico();
            } else if (op.getTipo() == 'c') {
                num = num.conjugar();
            } else if (op.getTipo() == 'i') {
                num = num.inverter();
            }
        }
    }

}
