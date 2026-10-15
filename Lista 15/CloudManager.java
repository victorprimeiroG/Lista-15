import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Gerenciador principal de clientes e servidores em nuvem (Banco de Dados em memória).
 * - RA: 25182018-2
 */
public class CloudManager {
    // Banco de dados mapeando Clientes a um Conjunto (Set) de Servidores sem duplicidade - RA: 25182018-2
    private Map<Cliente, Set<Servidor>> bancoDeDados = new HashMap<>();

    // Método auxiliar para registrar o cliente no mapa - RA: 25182018-2
    public void registrarCliente(Cliente cliente) {
        bancoDeDados.putIfAbsent(cliente, new HashSet<>()); // - RA: 25182018-2
    }

    // Método auxiliar para associar um servidor ao cliente - RA: 25182018-2
    public void adicionarServidorAoCliente(Cliente cliente, Servidor servidor) {
        bancoDeDados.computeIfAbsent(cliente, k -> new HashSet<>()).add(servidor); // - RA: 25182018-2
    }

    /**
     * Calcula a fatura ativa do cliente filtrando apenas os servidores ligados via Streams API - RA: 25182018-2
     */
    public double calcularFaturaAtiva(Cliente c) {
        Set<Servidor> servidores = bancoDeDados.get(c);
        if (servidores == null) {
            return 0.0; // - RA: 25182018-2
        }
        
        return servidores.stream()
                .filter(Servidor::isStatusLigado) // Filtra APENAS os servidores ligados - RA: 25182018-2
                .mapToDouble(Servidor::getPrecoPorHora) // Extrai o preço por hora - RA: 25182018-2
                .sum(); // Retorna a soma final - RA: 25182018-2
    }

    public Map<Cliente, Set<Servidor>> getBancoDeDados() {
        return bancoDeDados; // - RA: 25182018-2
    }
}
