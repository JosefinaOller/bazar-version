package com.example.bazar_version.service;

import com.example.bazar_version.model.Producto;
import com.example.bazar_version.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {
    
    @Autowired
    private IProductoRepository prodRepo;
    
    @Override
    public void saveProducto(Producto producto) {
        prodRepo.save(producto);
    }

    @Override
    public List<Producto> getProductos() {
        return prodRepo.findAll();
    }

    @Override
    public Producto findProducto(Long codigo_producto) {
        return prodRepo.findById(codigo_producto).orElse(null);
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        prodRepo.deleteById(codigo_producto);
    }

    @Override
    public void editProducto(Producto producto) {
        prodRepo.save(producto);
    }

    @Override
    public List<Producto> getProductosStock() {
        List<Producto> lista = new ArrayList();
        for (Producto producto : prodRepo.findAll()) {
            if (producto.getCantidad_disponible()<5) {
                lista.add(producto);
            }
            
        }
        return lista;
    }
    
}
