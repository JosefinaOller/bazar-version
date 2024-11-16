package com.example.bazar_version.controller;

import com.example.bazar_version.model.Producto;
import com.example.bazar_version.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService prodService;
    
    @PostMapping
    ("/productos/crear")
    public String createCliente(@RequestBody Producto producto){
        prodService.saveProducto(producto);
        return "El producto fue creado correctamente";
    }
    
    @GetMapping
    ("/productos")
    public List<Producto> getProductos(){
        return prodService.getProductos();
    }
    
    @GetMapping
    ("/productos/{codigo_producto}")
    public Producto findProducto(@PathVariable Long codigo_producto){
        return prodService.findProducto(codigo_producto);
    }
    
    @DeleteMapping
    ("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto){
        prodService.deleteProducto(codigo_producto);
        return "El producto fue eliminado correctamente";
    }
    
    @PutMapping
    ("/productos/editar")
    public String editProducto(@RequestBody Producto producto){
        prodService.editProducto(producto);
        return "El producto fue editado correctamente";
    }
    
    @GetMapping
    ("/productos/falta_stock")
    public List<Producto> getFaltaStock(){
        return prodService.getProductosStock();
    }
    
}
