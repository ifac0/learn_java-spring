package com.sdty.restfull.service;

import com.sdty.restfull.controller.request.SoldadoEditRequest;
import com.sdty.restfull.dto.Soldado;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class SoldadoService {

    public Soldado buscarSoldado(String cpf){
        Soldado soldado = new Soldado();

        soldado.setCpf(cpf);
        soldado.setName("Legolas");
        soldado.setRaca("Elfo");
        soldado.setArma("Arco e Flexa");

        return soldado;
    }

    public void criarSoldade(Soldado soldado){

    }

    public void alterarSoldado(String cpf, SoldadoEditRequest soldadoEditRequest) {

    }

    public void deletarSoldado(String cpf) {

    }

    public List<Soldado> buscarSoldados() {
        Soldado soldado1 = new Soldado();

        soldado1.setCpf("444555666");
        soldado1.setName("Legolas");
        soldado1.setRaca("Elfo");
        soldado1.setArma("Arco e Flexa");

        Soldado soldado2 = new Soldado();

        soldado2.setCpf("1122334455");
        soldado2.setName("Pedrinho");
        soldado2.setRaca("Anão");
        soldado2.setArma("Flexa");

        return Arrays.asList(soldado1, soldado2);
    }
}
