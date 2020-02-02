package com.sdty.restfull.service;

import com.sdty.restfull.dto.Soldado;
import org.springframework.stereotype.Service;

@Service
public class SoldadoService {

    public Soldado buscarSoldado(String cpf){
        Soldado soldado = new Soldado();

        soldado.setCpf(cpf);
        soldado.setName("Legolas");
        soldado.setRaca("Elfo");
        soldado.setArma("Arco e Flexa");

        return soldado;
    };
}
