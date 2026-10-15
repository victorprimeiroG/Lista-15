/**
 * Exceção customizada não checada (Unchecked) lançada quando se tenta 
 * alocar um container em um servidor que está desligado.
 * - RA: 25182018-2
 */
public class ServidorOfflineException extends RuntimeException {
    
    // Construtor que recebe a mensagem de erro obrigatória
    public ServidorOfflineException(String mensagem) {
        super(mensagem); // - RA: 25182018-2
    }
}
