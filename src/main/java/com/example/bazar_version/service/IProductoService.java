package com.example.bazar_version.service;

import com.example.bazar_version.model.Producto;
import java.util.List;


public interface IProductoService {
    
    public void saveProducto(Producto producto);
    
    public List<Producto> getProductos();
    
    public Producto findProducto(Long codigo_producto);
    
    public void deleteProducto(Long codigo_producto);
    
    public void editProducto(Producto producto);
    
    public List<Producto> getProductosStock();
    
}
