package Trabalho1;

public class Operation {

    /**
     * Representa um operador matemático, como soma (+), subtração (-),
     * multiplicação (*), divisão (/), expoente (^),
     * simétrico (s), conjugado (c) ou inverso (i).
     */
    private char operador;

    /**
     * Representa um número complexo usado numa operação.
     */
    private ComplexNumber num;

    /**
     * Cria uma nova instância de Operation com o operador
     * e o número complexo inicializados como nulos (0 + 0i).
     */
    public Operation (){

    }

    /**
     * Retorna o número complexo associado à operação.
     * @return o número complexo associado à operação.
     */
    public ComplexNumber getNum(){
        return num;
    }

    /**
     * Cria uma operação com um operador específico.
     * @param op o operador a ser atribuído à operação.
     */
    public Operation(char op){
        this.operador = op;
    }

    /**
     * Cria uma nova instância de Operation com um operador e número complexo especificados.
     * @param op o operador a ser usado na operação
     * @param n o número complexo a ser usado na operação
     */
    public Operation(char op, ComplexNumber n){
        this.num = n;
        this.operador = op;
    }

    /**
     * Retorna o tipo de operação realizada.
     * @return caracter a representar o tipo de operação
     */
    public char getTipo(){
        return operador;
    }

    /**
     * Retorna uma representação em string do objeto Operation,
     * que é a representação em string do número complexo contido no objeto.
     * @return uma string que representa o objeto Operation
     */
    @Override
    public String toString(){
        return num.toString();
    }
}
