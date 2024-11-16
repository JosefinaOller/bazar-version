package com.example.bazar_version.service;

import com.example.bazar_version.dto.VentaClienteDTO;
import com.example.bazar_version.model.Producto;
import com.example.bazar_version.model.Venta;
import com.example.bazar_version.repository.IProductoRepository;
import com.example.bazar_version.repository.IVentaRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {
    
    @Autowired
    private IVentaRepository ventaRepo;
    
    @Autowired
    private IProductoRepository produRepo;

    @Override
    @Transactional //Para que las operaciones no sean atomicas 
    public void saveVenta(Venta venta) {
        List<Producto> lista = venta.getListaProductos();
        List<Producto> listaActualizada = new ArrayList();
        
        Double total = 0.0;
        
        ventaRepo.save(venta);
        
        for (Producto producto: lista) { 
            Producto producto_repo = produRepo.findById(producto.getCodigo_producto()).orElse(null);
            //analizo si existe el producto solicitado
            if(producto_repo==null){
                this.deleteVenta(venta.getCodigo_venta());
                throw new RuntimeException("No existe el producto solcitado");
            }
            else{
                if (producto_repo.getCantidad_disponible()<1) { //controlo el stcok
                //lanza excepcion si no hay stock disponible
                this.deleteVenta(venta.getCodigo_venta());
                throw new RuntimeException("Stock insuficiente para el producto: " + producto_repo.getNombre());
                }
                else{
                    producto_repo.setCantidad_disponible(producto_repo.getCantidad_disponible()-1);
                    produRepo.save(producto_repo); //Es como un edit
                    total+=producto_repo.getCosto();
                    
                    //Relacion bidireccional
                    producto_repo.setVenta(venta);
                    listaActualizada.add(producto_repo);
                }
            } 
            
        }
        venta.setListaProductos(listaActualizada);
        venta.setTotal(total);
        ventaRepo.save(venta); //se modifica la venta si no se lanza la expecion.
        
    }

    @Override
    public List<Venta> getVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public Venta findVenta(Long codigo_venta) {
        return ventaRepo.findById(codigo_venta).orElse(null);
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
        ventaRepo.deleteById(codigo_venta);
    }

    @Override
    public void editVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public List<Producto> getProductos(Long codigo_venta) {
        Venta venta = ventaRepo.findById(codigo_venta).orElse(null);
        if (venta!=null) {
            return venta.getListaProductos();
            
        }
        return null;
    }

    @Override
    public String getTotalVentas(LocalDate fecha_venta) {
        Double monto = 0.0;
        int cant_ventas = 0;
        for (Venta venta : ventaRepo.findAll()) {
            if (venta.getFecha_venta().equals(fecha_venta)) {
                monto+=venta.getTotal();
                cant_ventas++;   
            }
        }
        return "En la fecha de " + fecha_venta + " la suma total de ventas es de: $" + monto + " y la cantidad de ventas es : " + cant_ventas;
    }

    @Override
    public VentaClienteDTO montoAltoVenta() {
        List<Venta> lista = ventaRepo.findAll();
        Double max = lista.get(0).getTotal();
        Venta venta_max = lista.get(0);
        for (Venta venta : lista) {
            if (venta.getTotal()>max) {
                max = venta.getTotal();
                venta_max = venta;
            }
        }
        VentaClienteDTO venta_clienteDTO = new VentaClienteDTO();
        venta_clienteDTO.setCodigo_venta(venta_max.getCodigo_venta());
        venta_clienteDTO.setTotal(max);
        venta_clienteDTO.setCant_productos(venta_max.getListaProductos().size());
        venta_clienteDTO.setNombre_cliente(venta_max.getUnCliente().getNombre());
        venta_clienteDTO.setApellido_cliente(venta_max.getUnCliente().getApellido());
        
        return venta_clienteDTO;
        
    }
    
}
