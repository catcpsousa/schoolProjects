package Trabalho1;

/**
 * Classe para representar um número complexo com partes real e imaginária.
 * Os valores para as partes real e imaginária são representados como double.
 * Nota: Caso uma das partes seja zero, não será exibida na representação do número complexo.
 */
public class ComplexNumber {

    /**
     * definidos como private para garantir o encapsulamento, ou
     * seja, que somente a própria classe tenha acesso direto a eles
     *
     */
    //Atributo para a parte real do número complexo
    private double real;
    //Atributo para a parte imaginária do número complexo
    private double imaginario;

    /**
     * Construtor vazio que inicializa um número complexo com parte real e imaginária iguais a zero.
     */
    public ComplexNumber(){

    }

    /**
     * Cria um novo número complexo com a parte real igual a r e a parte imaginária igual a i.
     * @param r a parte real do número complexo
     * @param i a parte imaginária do número complexo
     */
    public ComplexNumber(double r, double i){
        this.real = r;
        this.imaginario = i;
    }

    /**
     * Retorna o valor da parte real do número complexo.
     * @return o valor da parte real do número complexo.
     */
    public double getReal(){
        return real;
    }

    /**
     * Retorna o valor da parte imaginária do número complexo.
     * @return o valor da parte imaginária do número complexo.
     */
    public double getImaginario() {
        return imaginario;
    }

    /**
     * Retorna a soma deste número complexo com outro número complexo fornecido.
     *
     * @param o o número complexo a ser somado a este número complexo
     * @return um novo número complexo que é a soma deste número complexo com o número complexo fornecido
     */
    public ComplexNumber somar(ComplexNumber o){
        double resultadoReal = this.real + o.real;
        double resultadoImagin = this.imaginario + o.imaginario;
        return new ComplexNumber(resultadoReal, resultadoImagin);
    }

    /**
     *
     * Subtrai um número complexo 'o' do número complexo atual e retorna um novo número complexo com o resultado.
     * @param o o número complexo a ser subtraído
     * @return o novo número complexo resultado da subtração
     */
    public ComplexNumber subtrair(ComplexNumber o){
        double resultadoReal = this.real - o.real;
        double resultadoImagin = this.imaginario - o.imaginario;
        return new ComplexNumber(resultadoReal, resultadoImagin);
    }

    /**
     *
     * Multiplica um número complexo 'o' do número complexo atual e retorna um novo número complexo com o resultado.
     * @param o o número complexo a ser multiplicado
     * @return o novo número complexo resultado da multiplicação
     */
    public ComplexNumber multiplicar(ComplexNumber o){
        double resultadoReal = this.real * o.real - this.imaginario * o.imaginario;
        double resultadoImagin = this.imaginario * o.imaginario + this.real * o.real;
        return new ComplexNumber(resultadoReal, resultadoImagin);
    }

    /**
     *
     * Divide um número complexo 'o' do número complexo atual e retorna um novo número complexo com o resultado.
     * @param o o número complexo a ser dividido
     * @return o novo número complexo resultado da divisão
     */
    public ComplexNumber dividir(ComplexNumber o){
        double denominador = o.real * o.real + o.imaginario * o.imaginario;
        double resultadoReal = (this.real * o.real + this.imaginario * o.imaginario)/denominador;
        double resultadoImaginario = (this.imaginario * o.imaginario + this.real * o.real) / denominador;
        return new ComplexNumber(resultadoReal,resultadoImaginario);
    }

    /**
     *
     * Conjuga o número complexo atual e retorna um novo número complexo com o resultado.
     * @return o novo número complexo resultado do conjugado
     */
    public ComplexNumber conjugar(){
        //O conjugado de um número complexo 𝑧 = 𝑎 + 𝑏𝑖 é um número complexo denotado por
        //𝑧̄= 𝑎 − 𝑏𝑖.
        return new ComplexNumber(this.real, -this.imaginario);
    }

    /**
     *
     * Inverte o número complexo atual e retorna um novo número complexo com o resultado.
     * @return o novo número complexo resultado do inverso
     */
    public ComplexNumber inverter(){
        double denominador = this.real * this.real + this.imaginario * this.imaginario;
        double resultadoReal = this.real / denominador;
        double resultadoImaginario = -this.imaginario /denominador;
        return new ComplexNumber(resultadoReal, resultadoImaginario);
    }

    /**
     * Retorna o simétrico do número complexo, ou seja, um número complexo
     * cujos valores reais e imaginários são negativos em relação ao número complexo atual.
     * Se algum dos valores resultantes for igual a -0, ele será substituído por 0.
     * @return um novo objeto Trabalho1.ComplexNumber com os valores reais e imaginários negativos
     */
    public ComplexNumber simetrico(){
        double real = -this.real;
        double imaginario = -this.imaginario;
        if (real == -0) {
            real = 0;
        }
        if (imaginario == -0) {
            imaginario = 0;
        }
        return new ComplexNumber(real, imaginario);
    }

    /**
     * Retorna o resultado da exponenciação deste número complexo pelo expoente fornecido.
     *
     * @param e o expoente a ser aplicado a este número complexo
     * @return o resultado da exponenciação
     */
    public ComplexNumber expoente(double e) {
        double r = Math.pow(Math.sqrt(this.real * this.real + this.imaginario * this.imaginario), e);
        double theta = Math.atan2(this.imaginario, this.real);
        double resultadoReal = r * Math.cos(e * theta);
        double resultadoImaginario = r * Math.sin(e * theta);
        return new ComplexNumber(resultadoReal, resultadoImaginario);
    }

    /**
     * retorna uma representação em String do número complexo no formato "a + bi",
     * onde "a" e "b" são os componentes real e imaginário, respectivamente.
     * Se o número complexo for puramente real ou imaginário, a parte não
     * utilizada é omitida na string resultante. Se o imaginário for negativo,
     * a parte real e imaginária são separadas por um sinal de subtração.
     * Caso contrário, são separadas por um sinal de adição. O método usa
     * formatação de string para arredondar os valores com 2 casas decimais, exceto para valores inteiros.
     * @return a string formatada de acordo com o sinal
     */
    @Override
    public String toString() {
        if (imaginario == 0) {
            if (real == (int)real) {
                return String.format("%.0f", real);
            } else {
                return String.format("%.2f", real);
            }
        } else if (real == 0) {
            if (imaginario == (int)imaginario) {
                return String.format("%.0fi", imaginario);
            } else {
                return String.format("%.2fi", imaginario);
            }
        } else if (imaginario < 0) {
            if (imaginario == (int)imaginario) {
                return String.format("%.2f - %.0fi", real, -imaginario);
            } else {
                return String.format("%.2f - %.2fi", real, -imaginario);
            }
        } else {
            if (imaginario == (int)imaginario) {
                return String.format("%.2f + %.0fi", real, imaginario);
            } else {
                return String.format("%.2f + %.2fi", real, imaginario);
            }
        }
    }

}
