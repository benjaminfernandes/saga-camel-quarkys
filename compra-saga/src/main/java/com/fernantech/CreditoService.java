package com.fernantech;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Header;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreditoService {
    
    private int creditoTotal;
    private Map<Long, Integer> pedido_valor = new HashMap<>();

    public CreditoService() {
        this.creditoTotal = 100;
    }

    public void newPedidoValor(@Header("pedidoId") Long pedidoId, @Header("valor") int valor){
        if(valor > creditoTotal){
            throw new IllegalStateException("Saldo insuficiente!");
        }

        creditoTotal = creditoTotal - valor;
        pedido_valor.put(pedidoId, valor);
    }

    public void cancelPedidoValor(@Header("id") Long id){
        System.out.println("PedidoValor falhou. Iniciando cancelamento do pedido");
    }

    public int getCreditoTotal(){
        return creditoTotal;
    }

}
