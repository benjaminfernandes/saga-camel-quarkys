package com.fernantech;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("credito")
public class CompraCreditoResource {
    
    @Inject
    CreditoService creditoService;

    @GET
    @Path("newPedidoValor")
    @Produces(MediaType.TEXT_PLAIN)
    public void newPedidoValor(@QueryParam("pedidoId") Long pedidoId, @QueryParam("valor") int valor){
        this.creditoService.newPedidoValor(pedidoId, valor);
    }

    @GET
    @Path("cancelPedidoValor")
    @Produces(MediaType.TEXT_PLAIN)
    public void cancelPedidoValor(Long pedidoId, int valor){
        this.creditoService.cancelPedidoValor(pedidoId);
    }

    @GET
    @Path("getCreditoTotal")
    @Produces(MediaType.TEXT_PLAIN)
    public int getCreditoTotal(){
        return this.creditoService.getCreditoTotal();
    }

}
