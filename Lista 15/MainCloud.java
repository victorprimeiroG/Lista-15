/**
 * Classe executável contendo o roteiro rigoroso de testes exigido pela NexusCloud.
 * - RA: 25182018-2
 */
public class MainCloud {
    public static void main(String[] args) {
        // 1. Instancie o CloudManager - RA: 25182018-2
        CloudManager manager = new CloudManager();

        // 2. Instancie 1 Cliente (Ex: "111.222.333-44", "Wayne Enterprises") - RA: 25182018-2
        Cliente cliente = new Cliente("111.222.333-44", "Wayne Enterprises");

        // 3. Instancie 1 Servidor (Ex: IP "192.168.0.1", RAM Total 16.0 GB, Preço R$ 5.50) - RA: 25182018-2
        Servidor servidor = new Servidor("192.168.0.1", 16.0, 5.50);

        // 4. Registre o cliente no banco de dados do Manager e adicione o servidor a ele - RA: 25182018-2
        manager.registrarCliente(cliente);
        manager.adicionarServidorAoCliente(cliente, servidor);

        // 5. Instancie 2 Containers diferentes (Ex: C-01 com 10.0 RAM e C-02 com 8.0 RAM) - RA: 25182018-2
        Container c1 = new Container("C-01", 10.0);
        Container c2 = new Container("C-02", 8.0);

        // 6. Teste Falha Unchecked: Tente alocar o Container 1 no Servidor (desligado).
        // Deixado intencionalmente sem try-catch para exibir a exceção no console (tela vermelha).
        // ATENÇÃO: Após testar o Passo 6, comente a linha abaixo conforme a instrução do Passo 7.
        // servidor.alocarContainer(c1); // - RA: 25182018-2

        // 7. Siga em frente: Comente a linha do Passo 6 acima e prossiga com o fluxo:
        servidor.ligar(); // 8. Chame o método ligar() do servidor - RA: 25182018-2

        try {
            // 9. Aloque com sucesso: Aloque o Container 1 no Servidor - RA: 25182018-2
            servidor.alocarContainer(c1);
            System.out.println("Container " + c1.getId() + " alocado com sucesso!"); // - RA: 25182018-2
        } catch (CapacidadeExcedidaException e) {
            System.out.println(e.getMessage());
        }

        // 10. Teste Falha Checked: Tente alocar o Container 2 dentro de um bloco try-catch - RA: 25182018-2
        try {
            servidor.alocarContainer(c2); // (10.0 + 8.0 = 18.0 > 16.0) - RA: 25182018-2
        } catch (CapacidadeExcedidaException e) {
            // Captura e imprime o erro de forma elegante no console - RA: 25182018-2
            System.out.println(e.getMessage()); 
        }

        // 11. Imprima no console o valor retornado por calcularFaturaAtiva do CloudManager (deve ser 5.50) - RA: 25182018-2
        double faturaAtiva = manager.calcularFaturaAtiva(cliente);
        System.out.println("Fatura Ativa do Cliente: R$ " + faturaAtiva); // - RA: 25182018-2
    }
}
