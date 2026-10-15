import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representa um servidor de infraestrutura com lista de containers e motor de alocação.
 * - RA: 25182018-2
 */
public class Servidor {
    private String ip;
    private double ramTotal;
    private double precoPorHora;
    private boolean statusLigado;
    
    // Inicializa o atributo containers como ArrayList para evitar NullPointerException - RA: 25182018-2
    private List<Container> containers = new ArrayList<>();

    // Construtor padrão inicializando o servidor desligado - RA: 25182018-2
    public Servidor(String ip, double ramTotal, double precoPorHora) {
        this.ip = ip;
        this.ramTotal = ramTotal;
        this.precoPorHora = precoPorHora;
        this.statusLigado = false; // Nasce desligado por padrão - RA: 25182018-2
    }

    // Métodos de controle de estado - RA: 25182018-2
    public void ligar() {
        this.statusLigado = true; // - RA: 25182018-2
    }

    public void desligar() {
        this.statusLigado = false; // - RA: 25182018-2
    }

    /**
     * Motor de alocação aplicando política Fail-Fast (Unchecked e Checked) - RA: 25182018-2
     */
    public void alocarContainer(Container c) throws CapacidadeExcedidaException {
        // Validação de Status (Unchecked): Lança exceção se o servidor estiver desligado - RA: 25182018-2
        if (!statusLigado) {
            throw new ServidorOfflineException("Erro: Não é possível alocar containers em um servidor desligado."); // - RA: 25182018-2
        }

        // Calcula a RAM atualmente em uso - RA: 25182018-2
        double ramEmUso = calcularRamEmUso();

        // Validação de Capacidade (Checked): Lança exceção se a RAM estourar o limite - RA: 25182018-2
        if (ramEmUso + c.getRamNecessaria() > ramTotal) {
            throw new CapacidadeExcedidaException("Falha Crítica: Memória RAM insuficiente no servidor " + ip + "."); // - RA: 25182018-2
        }

        // Adiciona o container à lista cronológica interna - RA: 25182018-2
        containers.add(c);
    }

    /**
     * Motor de Auditoria: Calcula a RAM em uso utilizando Streams API sem laços for - RA: 25182018-2
     */
    public double calcularRamEmUso() {
        return containers.stream()
                .mapToDouble(Container::getRamNecessaria)
                .sum(); // - RA: 25182018-2
    }

    // Getters e Setters - RA: 25182018-2
    public String getIp() { return ip; }
    public void setIp(String ip) { this.ip = ip; }

    public double getRamTotal() { return ramTotal; }
    public void setRamTotal(double ramTotal) { this.ramTotal = ramTotal; }

    public double getPrecoPorHora() { return precoPorHora; }
    public void setPrecoPorHora(double precoPorHora) { this.precoPorHora = precoPorHora; }

    public boolean isStatusLigado() { return statusLigado; }
    public void setStatusLigado(boolean statusLigado) { this.statusLigado = statusLigado; }

    public List<Container> getContainers() { return containers; }

    // Regra de Identidade: Dois Servidores são iguais se possuem o mesmo IP - RA: 25182018-2
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servidor servidor = (Servidor) o;
        return Objects.equals(ip, servidor.ip); // - RA: 25182018-2
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip); // - RA: 25182018-2
    }
}
