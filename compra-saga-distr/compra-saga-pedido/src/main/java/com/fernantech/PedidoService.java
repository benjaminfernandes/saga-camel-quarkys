package com.fernantech;

import java.util.HashSet;
import java.util.Set;

import org.apache.camel.Header;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PedidoService {
    
    private Set<Long> pedidos = new HashSet<>();
    
    public void newPedido(@Header("id") Long id) {
        pedidos.add(id);
    }

    public void cancelPedido(@Header("id") Long id) {
        pedidos.remove(id);
    }

}
