package Trabalho1;

public class Main {
    public static void main(String[] args) {

        /**
         * Instância um novo objeto da classe History, que representa o histórico de operações.
         */
        History historico = new History();
        /**
         * Instância um novo objeto da classe Operation, que representa as operações.
         */
        Operation o = new Operation();

        /**
         * Cria um objeto Calculator que utiliza uma operação inicial e um histórico de operações para realizar cálculos.
         * @param o a operação inicial a ser usada na calculadora
         * @param historico o histórico de operações para ser usado na calculadora
         */
        Calculator c = new Calculator(o, historico);

        /**
         * Cria um objeto Menu para a calculadora, associando-a a um histórico de operações.
         * @param c Objeto Calculator que será utilizado pelo Menu para realizar as operações.
         * @param historico Objeto History que será utilizado pelo Menu para armazenar as operações realizadas.
         */
        Menu m = new Menu(c, historico);

        m.run();

    }
}