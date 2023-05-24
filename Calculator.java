package Trabalho1;
public class Calculator {

    /**
     * Variável de instância que armazena um número complexo utilizado nas operações.
     * A visibilidade é definida como privada para que possa ser acedida apenas dentro da classe Trabalho1.ComplexNumber.
     */
    private ComplexNumber num;

    private History h;

    private final Operation o;

    /**
     * construtor responsável por criar um novo objeto Trabalho1.Calculator. Ele inicializa o número complexo
     * padrão como 0 + 0i e cria uma nova lista vazia para armazenar o histórico de operações.
     */
    public Calculator(Operation op, History hist){
        num = new ComplexNumber(0,0);
        this.h = hist;
        this.o = op;
    }

    public ComplexNumber getNumeroAtual(){
        return num;
    }

    public void setNumeroAtual(ComplexNumber n){
        num = n;
    }

    /**
     * Soma do número complexo recebido como parâmetro com o número
     * atual da calculadora e armazena o resultado na variável num
     * Também adiciona uma string contendo a operação realizada
     * e o número somado ao histórico de operações.
     * @param n número complexo a ser somado ao número atual da calculadora
     */
    public void somarNComplexo(ComplexNumber n){
        ComplexNumber resultado = this.num.somar(n);
        this.num = resultado;
        Operation op = new Operation('+', n);
        this.h.adicionar(op);
    }

    /**
     * Subtração do número complexo recebido como parâmetro com o número
     * atual da calculadora e armazena o resultado na variável num
     * Também adiciona uma string contendo a operação realizada
     * e o número subtraído ao histórico de operações.
     * @param n número complexo a ser subtraído ao número atual da calculadora
     */
    public void subtrairNComplexo(ComplexNumber n){
        ComplexNumber resultado = this.num.subtrair(n);
        this.num = resultado;
        Operation op = new Operation('-', n);
        this.h.adicionar(op);
    }

    /**
     * Multiplicação do número complexo recebido como parâmetro com o número
     * atual da calculadora e armazena o resultado na variável num
     * Também adiciona uma string contendo a operação realizada
     * e o número multiplicado ao histórico de operações.
     * @param n número complexo a ser multiplicado ao número atual da calculadora
     */
    public void multiplicarNComplexo(ComplexNumber n){
        ComplexNumber resultado = this.num.multiplicar(n);
        this.num = resultado;
        Operation op = new Operation('*', n);
        this.h.adicionar(op);
    }

    /**
     * Divisão do número complexo recebido como parâmetro com o número
     * atual da calculadora e armazena o resultado na variável num
     * Sendo que, em primeiro lugar é verificado se o número atual
     * é 0, pois não é possível dividir por 0
     * Também adiciona uma string contendo a operação realizada
     * e o número somado ao histórico de operações.
     * @param n número complexo a ser divido ao número atual da calculadora
     */
    public void dividirNComplexo(ComplexNumber n){
        if (num.getReal() == 0 && num.getImaginario() == 0) {
            throw new ArithmeticException("Não é possível dividir por zero");
        }
        ComplexNumber resultado = this.num.dividir(n);
        this.num = resultado;
        Operation op = new Operation('/', n);
        this.h.adicionar(op);
    }

    /**
     * Calcula a exponenciação do número complexo atual elevado à potencia e
     *  e armazena o resultado na variável num
     * Também adiciona uma string contendo a operação realizada
     * e o número elevado à potência ao histórico de operações.
     * @param e valor da potência
     */
    public void expNComplexo(double e){
        ComplexNumber resultado = this.num.expoente(e);
        this.num = resultado;
        Operation op = new Operation('^', num);
        this.h.adicionar(op);
    }

    /**
     * Calcula o simétrico do número complexo atual
     * e armazena o resultado na variável num
     * Também adiciona uma string contendo a operação realizada
     * e o número simétrico ao histórico de operações.
     */
    public void simNComplexo(){
        ComplexNumber resultado = this.num.simetrico();
        this.num = resultado;
        Operation op = new Operation('s');
        this.h.adicionar(op);
    }

    /**
     * Calcula a conjugação do número complexo atual
     * e armazena o resultado na variável num
     * Também adiciona uma string contendo a operação realizada
     * e o número conjugado ao histórico de operações.
     */
    public void conjNComplexo(){
        ComplexNumber resultado = this.num.conjugar();
        this.num = resultado;
        Operation op = new Operation('c');
        this.h.adicionar(op);
    }

    /**
     * Calcula o inverso do número complexo atual
     * e armazena o resultado na variável num
     * Também adiciona uma string contendo a operação realizada
     * e o número invertido ao histórico de operações.
     */
    public void invNComplexo(){
        ComplexNumber resultado = this.num.inverter();
        this.num = resultado;
        Operation op = new Operation('i');
        this.h.adicionar(op);
    }

}


