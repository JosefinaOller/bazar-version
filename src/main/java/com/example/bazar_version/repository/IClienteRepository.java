package com.example.bazar_version.repository;

import com.example.bazar_version.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IClienteRepository extends JpaRepository<Cliente,Long>{
}
