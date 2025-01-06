package com.coderhouse.dtos;

import java.util.List;

public class ComprobanteCompraDTO {

    private ClienteDTO cliente;
    private List<LineaDTO> lineas;

    public ClienteDTO getCliente() {
        return cliente;
    }

   
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
    
    public List<LineaDTO> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaDTO> lineas) {
        this.lineas = lineas;
    }

    public static class ClienteDTO {
        private Long clienteid;

        public Long getClienteid() {
            return clienteid;
        }

        public void setClienteid(Long clienteid) {
            this.clienteid = clienteid;
        }
    }
   

    public static class LineaDTO {
        private int cantidad;
        private ProductoDTO producto;

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public ProductoDTO getProducto() {
            return producto;
        }

        public void setProducto(ProductoDTO producto) {
            this.producto = producto;
        }

        public static class ProductoDTO {
            private Long productoid;

            public Long getProductoid() {
                return productoid;
            }

            public void setProductoid(Long productoid) {
                this.productoid = productoid;
            }
        }
    }
}
