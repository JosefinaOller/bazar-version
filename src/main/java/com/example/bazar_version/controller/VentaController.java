package com.example.bazar_version.controller;

import com.example.bazar_version.dto.VentaClienteDTO;
import com.example.bazar_version.model.Producto;
import com.example.bazar_version.model.Venta;
import com.example.bazar_version.service.IVentaService;
import java.time.LocalDate;
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
public class VentaController {
    
    @Autowired
    private IVentaService ventaService;
    
    @PostMapping
    ("/ventas/crear")
    public String createVenta(@RequestBody Venta venta){
        ventaService.saveVenta(venta);
        return "La venta fue creada correctamente";
    }
    
    @GetMapping
    ("/ventas")
    public List<Venta> getVentas(){
        return ventaService.getVentas();
    }
    
    @GetMapping
    ("/ventas/{codigo_venta}")
    public Venta findVenta(@PathVariable Long codigo_venta){
        return ventaService.findVenta(codigo_venta);
    }
    
    @DeleteMapping
    ("/ventas/eliminar/{codigo_venta}")
    public String deleteCliente(@PathVariable Long codigo_venta){
        ventaService.deleteVenta(codigo_venta);
        return "La venta fue eliminada correctamente";
    }
    
    @PutMapping
    ("/ventas/editar")
    public String editVenta(@RequestBody Venta venta){
        ventaService.editVenta(venta);
        return "La venta fue editada correctamente";
    }
    
    @GetMapping
    ("/ventas/productos/{codigo_venta}")
    public List<Producto> getProductos(@PathVariable Long codigo_venta){
        return ventaService.getProductos(codigo_venta);
    }
    
    @GetMapping
    ("/ventas/fecha/{fecha_venta}")
    public String getTotalCant(@PathVariable LocalDate fecha_venta){
        return ventaService.getTotalVentas(fecha_venta);
    }
    
    @GetMapping
    ("/ventas/mayor_venta")
    public VentaClienteDTO getMayorVenta(){
        return ventaService.montoAltoVenta();
    }
    
}
