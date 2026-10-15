import java.util.Objects;

/**
 * Representa um cliente da NexusCloud. 
 * Aplica encapsulamento rigoroso e igualdade baseada no CPF.
 * - RA: 25182018-2
 */
public class Cliente {
    private String cpf;
    private String nome;

    // Construtor parametrizado para inicialização dos dados do cliente - RA: 25182018-2
    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    // Getters e Setters para encapsulamento - RA: 25182018-2
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Regra de Identidade: Dois Clientes são iguais se possuem o mesmo CPF - RA: 25182018-2
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf); // - RA: 25182018-2
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf); // - RA: 25182018-2
    }
}
