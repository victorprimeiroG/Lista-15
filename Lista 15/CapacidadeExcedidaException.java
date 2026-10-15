/**
 * Exceção customizada checada (Checked) lançada quando a RAM necessária 
 * dos containers ultrapassa a capacidade total do servidor.
 * - RA: 25182018-2
 */
public class CapacidadeExcedidaException extends Exception {
    
    // Construtor que recebe a mensagem de erro customizada com o IP
    public CapacidadeExcedidaException(String mensagem) {
        super(mensagem); // - RA: 25182018-2
    }
}
