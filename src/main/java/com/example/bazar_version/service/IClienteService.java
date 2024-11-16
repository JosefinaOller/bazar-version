package com.example.bazar_version.service;

import com.example.bazar_version.model.Cliente;
import java.util.List;


public interface IClienteService {
    
    public void saveCliente(Cliente cliente);
    
    public List<Cliente> getClientes();
    
    public Cliente findCliente(Long id);
    
    public void deleteCliente(Long id);
    
    public void editCliente(Cliente cliente);
    
}
