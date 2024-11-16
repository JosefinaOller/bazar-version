package com.example.bazar_version.controller;

import com.example.bazar_version.model.Cliente;
import com.example.bazar_version.service.IClienteService;
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
public class ClienteController {
    
    @Autowired
    private IClienteService cliService;
    
    @PostMapping
    ("/clientes/crear")
    public String createCliente(@RequestBody Cliente cliente){
        cliService.saveCliente(cliente);
        return "El cliente fue creado correctamente";
    }
    
    @GetMapping
    ("/clientes")
    public List<Cliente> getClientes(){
        return cliService.getClientes();
    }
    
    @GetMapping
    ("/clientes/{id_cliente}")
    public Cliente findCliente(@PathVariable Long id_cliente){
        return cliService.findCliente(id_cliente);
    }
    
    @DeleteMapping
    ("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente){
        cliService.deleteCliente(id_cliente);
        return "El cliente fue eliminado correctamente";
    }
    
    @PutMapping
    ("/clientes/editar")
    public String editCliente(@RequestBody Cliente cliente){
        cliService.editCliente(cliente);
        return "El cliente fue editado correctamente";
    }
    
    
}
