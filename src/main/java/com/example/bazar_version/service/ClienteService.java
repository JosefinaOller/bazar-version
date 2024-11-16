package com.example.bazar_version.service;

import com.example.bazar_version.model.Cliente;
import com.example.bazar_version.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService implements IClienteService {
    
     @Autowired
    private IClienteRepository cliRepo;
    
    @Override
    public void saveCliente(Cliente cliente) {
        cliRepo.save(cliente);
    }

    @Override
    public List<Cliente> getClientes() {
        return cliRepo.findAll();
    }

    @Override
    public Cliente findCliente(Long id) {
        return cliRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteCliente(Long id) {
        cliRepo.deleteById(id);
    }

    @Override
    public void editCliente(Cliente cliente) {
        cliRepo.save(cliente);
    }
    
    
}
