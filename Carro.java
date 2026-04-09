public class Carro {
    // Ex 9a: Criação de constante static final
    public static final int ANO_PRIMEIRO_CARRO = 1886;

    // Ex 7a: Atributo de classe (static)
    public static int totalCarros = 0;

    // Ex 4a: Encapsulamento de todos os atributos
    private String marca;
    private String modelo;
    private int ano;

    // Ex 5a: Construtor parametrizado
    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        setAno(ano); // Usa a validação no setter
        totalCarros++; // Ex 7b: Incremento do contador
    }

    // Ex 6b: Sobrecarga de construtor (sem parâmetros)
    public Carro() {
        this.marca = "Desconhecido";
        this.modelo = "Desconhecido";
        this.ano = 0;
        totalCarros++; // Ex 7b: Incremento do contador
    }
    
    /* Ex 5c: A vantagem de usar o construtor em vez de setters um por um é garantir
       que o objeto já nasça com um estado válido e completo. Isso reduz a repetição de
       código na Main e evita esquecer de preencher algum dado obrigatório. */

    /* Ex 6c: O que muda entre os dois construtores é a assinatura (parâmetros).
       O primeiro exige que você informe os dados na criação, o segundo permite instanciar
       um carro genérico com valores padrão já definidos. */

    // Ex 4b: Getters e Setters
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAno() { return ano; }
    
    // Ex 4c e 9b: Validação com a constante
    public void setAno(int ano) {
        if (ano < ANO_PRIMEIRO_CARRO || ano > 2026) {
            System.out.println("Erro: Ano inválido! Não foi alterado.");
        } else {
            this.ano = ano;
        }
    }

    // Ex 2a: Método void
    /* Ex 2c: Este método apenas executa uma ação (imprimir no console) e não devolve valor. */
    public void exibir() {
        System.out.println(marca + " " + modelo + " - Ano: " + ano);
    }

    // Ex 2b: Método com retorno
    /* Ex 2c: Este método devolve um valor inteiro que pode ser armazenado ou impresso. */
    public int idadeDoCarro() {
        return 2026 - ano;
    }

    // Ex 8a: Método de classe (static)
    public static void imprimirTotal() {
        System.out.println("Total de carros cadastrados: " + totalCarros);
        
        // Ex 8b: Se tentar fazer System.out.println(modelo); ocorre um ERRO DE COMPILAÇÃO.
        /* Ex 8c: Um método static pertence à classe toda, não a um objeto específico.
           O atributo "modelo" é de instância. Como o método static é chamado sem precisar de
           um objeto instanciado, ele não sabe qual "modelo" ler (não existe o 'this' aqui). */
    }
}