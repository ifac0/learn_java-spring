package com.sdty.restfull.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdty.restfull.controller.request.SoldadoEditRequest;
import com.sdty.restfull.controller.response.SoldadoListResponse;
import com.sdty.restfull.controller.response.SoldadoResponse;
import com.sdty.restfull.dto.Soldado;
import com.sdty.restfull.entity.SoldadoEntity;
import com.sdty.restfull.repository.SoldadoRepository;
import com.sdty.restfull.resource.ResourceSoldado;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SoldadoService {

    private SoldadoRepository soldadoRepository;
    private ObjectMapper objectMapper;
    private ResourceSoldado resourceSoldado;

    public SoldadoService(SoldadoRepository soldadoRepository, ObjectMapper objectMapper, ResourceSoldado resourceSoldado){
        this.soldadoRepository = soldadoRepository;
        this.objectMapper = objectMapper;
        this.resourceSoldado = resourceSoldado;
    }

    public SoldadoResponse buscarSoldado(Long id){
        SoldadoEntity soldado = soldadoRepository.findById(id).orElseThrow(null);
        SoldadoResponse soldadoResponse = objectMapper.convertValue(soldado, SoldadoResponse.class);
        return  soldadoResponse;
    }

    public void criarSoldade(Soldado soldado){
        SoldadoEntity soldadoEntity = objectMapper.convertValue(soldado, SoldadoEntity.class);
        soldadoRepository.save(soldadoEntity);
    }

    public void alterarSoldado(Long id, SoldadoEditRequest soldadoEditRequest) {
        SoldadoEntity soldadoEntity = objectMapper.convertValue(soldadoEditRequest, SoldadoEntity.class);
        soldadoEntity.setId(id);
        soldadoRepository.save(soldadoEntity);
    }

    public void deletarSoldado(Long id) throws Exception {
        SoldadoEntity soldado = soldadoRepository.findById(id).orElseThrow(Exception::new);
        soldadoRepository.delete(soldado);
    }

    public List<SoldadoListResponse> buscarSoldados() {
       List<SoldadoEntity> all = soldadoRepository.findAll();
       List<SoldadoListResponse> soldadoStream = all.stream()
               .map(it -> resourceSoldado.criarLink(it))
               .collect(Collectors.toList());
       return soldadoStream;
    }
}
