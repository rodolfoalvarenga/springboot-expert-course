package io.github.rodolfoalvarenga.exception;

public class PedidoNaoEncontracoException extends RuntimeException {

    public PedidoNaoEncontracoException() {
        super("Pedido não encontrado");
    }
}
