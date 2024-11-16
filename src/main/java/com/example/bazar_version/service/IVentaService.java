package com.example.bazar_version.service;

import com.example.bazar_version.dto.VentaClienteDTO;
import com.example.bazar_version.model.Producto;
import com.example.bazar_version.model.Venta;
import java.time.LocalDate;
import java.util.List;


public interface IVentaService {
    
    public void saveVenta(Venta venta);
    
    public List<Venta> getVentas();
    
    public Venta findVenta(Long codigo_venta);
    
    public void deleteVenta(Long codigo_venta);
    
    public void editVenta(Venta venta);
    
    public List<Producto> getProductos(Long codigo_venta);
    
    public String getTotalVentas(LocalDate fecha_venta);
    
    public VentaClienteDTO montoAltoVenta();
    
}
