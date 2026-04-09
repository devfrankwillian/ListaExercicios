public class Cliente {
    private String nome;
    private String email;
    private String telefone;

    public static int totalClientes = 0;

    // Construtor 1 (Completo)
    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        totalClientes++;
    }

    // Construtor 2 (Sem telefone)
    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.telefone = "Não informado";
        totalClientes++;
    }

    // Construtor 3 (Só nome)
    public Cliente(String nome) {
        this.nome = nome;
        this.email = "Não informado";
        this.telefone = "Não informado";
        totalClientes++;
    }

    public void exibirInfo() {
        System.out.println("Nome: " + nome + " | Email: " + email + " | Telefone: " + telefone);
    }
}