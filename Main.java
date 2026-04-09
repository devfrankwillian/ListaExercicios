import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        // Executa as validações teóricas dos exercícios 9 ao 14
        testesTeoricos();

        // =============== EXERCÍCIO 15 (Mini-sistema) ===============
        Scanner scanner = new Scanner(System.in);
        ArrayList<Carro> frota = new ArrayList<>();
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n--- MENU ---");
            System.out.println("1) Cadastrar Carro");
            System.out.println("2) Listar todos");
            System.out.println("3) Total cadastrado");
            System.out.println("4) Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            if (opcao == 1) {
                System.out.print("Marca: ");
                String marca = scanner.nextLine();
                System.out.print("Modelo: ");
                String modelo = scanner.nextLine();
                System.out.print("Ano: ");
                int ano = scanner.nextInt();

                // Ex 15c: Criação usando construtor parametrizado
                Carro novoCarro = new Carro(marca, modelo, ano); 
                frota.add(novoCarro);
                System.out.println("Carro cadastrado!");

            } else if (opcao == 2) {
                System.out.println("\n--- Frota Cadastrada ---");
                // Ex 3: Uso do for-each com ArrayList
                for (Carro c : frota) {
                    c.exibir();
                }
            } else if (opcao == 3) {
                // Ex 15d: Chamada de método static da classe
                Carro.imprimirTotal(); 
            }
        }
        scanner.close();
    }

    // =========================================================================
    // RESOLUÇÃO TEÓRICA E TESTES SOLICITADOS NA LISTA
    // =========================================================================
    public static void testesTeoricos() {
        
        // Ex 7c: Impressão do totalCarros chamando pela Classe
        /* Ex 7d: Acessamos via Carro.totalCarros (nome da classe) porque é um atributo static.
           A diferença é que um atributo de instância cria um valor único para CADA objeto
           (cada carro tem sua placa), enquanto um atributo static é compartilhado por TODOS
           os objetos daquela classe na memória. */

        // Ex 9c: Teste do final
        // Carro.ANO_PRIMEIRO_CARRO = 1900; -> ISSO DÁ ERRO DE COMPILAÇÃO!
        /* Ex 9c: A palavra 'final' transforma a variável em uma constante. O valor
           atribuído não pode ser alterado posteriormente em nenhum lugar do código. */

        // Ex 10 - Escopo de variável
        int x = 0; // Ex 10b: A correção é declarar a variável fora do bloco 'if'
        if (true) {
            x = 10;
        }
        System.out.println("Ex 10 - x: " + x); // Ex 10a: Dava erro pois 'x' morria no if
        /* Ex 10c: Escopo é o bloco de visibilidade onde uma variável existe na memória.
           Como 'x' estava declarado dentro das chaves {}, ele só existia lá dentro. */

        // Ex 11 - Referência vs valor (primitivo)
        int a = 10;
        int b = a;
        b = 99;
        System.out.println("\nEx 11 - a: " + a + " | b: " + b); // a=10, b=99
        /* Ex 11b: Alterar 'b' não mudou 'a'. Tipos primitivos (int, double, etc) em Java
           são passados por CÓPIA DE VALOR. 'b' copiou o número 10, de forma independente. */

        // Ex 12 - Referência vs valor (objeto)
        Carro c1 = new Carro("Fiat", "Uno", 2020);
        Carro c2 = c1;
        c2.setModelo("Palio");
        System.out.println("\nEx 12 - c1 modelo: " + c1.getModelo()); // Imprime Palio
        System.out.println("Ex 12 - c2 modelo: " + c2.getModelo()); // Imprime Palio
        
        /* Ex 12b: Alterar c2 mudou c1 porque c1 e c2 compartilham a mesma referência.
           Ex 12c: A variável ponteiro (c1 e c2) fica na Stack, mas o objeto em si fica na Heap.
           Ao fazer c2 = c1, não copiamos o carro, apenas criamos outro ponteiro na Stack
           apontando para a mesma área de memória na Heap. */

        // Ex 13 - Passagem de objeto para método
        Carro meuCarro = new Carro("VW", "Gol", 2015);
        trocarModelo(meuCarro);
        System.out.println("\nEx 13 - Modelo trocado: " + meuCarro.getModelo()); // Imprime Fusca
        
        /* Ex 13b: A mudança afetou o objeto original porque o Java passa a referência por valor.
           O parâmetro 'c' do método aponta para o exato mesmo endereço de memória na Heap
           que a variável 'meuCarro' original. */

        // Ex 14e: Criação de um objeto com cada construtor
        System.out.println("\n--- Ex 14: Teste Clientes ---");
        Cliente cli1 = new Cliente("João", "joao@email.com", "9999-9999");
        Cliente cli2 = new Cliente("Maria", "maria@email.com");
        Cliente cli3 = new Cliente("Pedro");
        cli1.exibirInfo();
        cli2.exibirInfo();
        cli3.exibirInfo();
        System.out.println("Total Clientes cadastrados: " + Cliente.totalClientes);
    }

    // Método de apoio para o Exercício 13
    public static void trocarModelo(Carro c) {
        c.setModelo("Fusca");
    }
}