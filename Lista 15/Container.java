import java.util.Objects;

/**
 * Representa uma aplicação/container virtual na nuvem.
 * Aplica encapsulamento rigoroso e identidade baseada no ID.
 * - RA: 25182018-2
 */
public class Container {
    private String id;
    private double ramNecessaria;

    // Construtor para inicializar o container - RA: 25182018-2
    public Container(String id, double ramNecessaria) {
        this.id = id;
        this.ramNecessaria = ramNecessaria;
    }

    // Getters e Setters - RA: 25182018-2
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getRamNecessaria() {
        return ramNecessaria;
    }

    public void setRamNecessaria(double ramNecessaria) {
        this.ramNecessaria = ramNecessaria;
    }

    // Regra de Identidade: Dois Containers são iguais se possuem o mesmo ID - RA: 25182018-2
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return Objects.equals(id, container.id); // - RA: 25182018-2
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // - RA: 25182018-2
    }
}
