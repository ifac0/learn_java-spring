package com.sdty.restfull.controller;

import com.sdty.restfull.controller.request.SoldadoEditRequest;
import com.sdty.restfull.controller.response.SoldadoListResponse;
import com.sdty.restfull.controller.response.SoldadoResponse;
import com.sdty.restfull.dto.Soldado;
import com.sdty.restfull.service.SoldadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {

    private SoldadoService soldadoService;

    public SoldadoController(SoldadoService soldadoService) {
        this.soldadoService = soldadoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoldadoResponse> buscarSoldado(@PathVariable() Long id){
        SoldadoResponse soldado = soldadoService.buscarSoldado(id);
        return ResponseEntity.status(HttpStatus.OK).body(soldado);
    }

    @GetMapping
    public ResponseEntity<List<SoldadoListResponse>> buscarSoldado(){
        List<SoldadoListResponse> soldadoListResponsesdos = soldadoService.buscarSoldados();
        return  ResponseEntity.status(HttpStatus.OK).body(soldadoListResponsesdos);
    }

    @PostMapping
    public ResponseEntity criarSoldado(@RequestBody Soldado soldado){
        soldadoService.criarSoldade(soldado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{cpf}")
    public ResponseEntity editarSoldado(@PathVariable() Long id,
                                        SoldadoEditRequest soldadoEditRequest){
        soldadoService.alterarSoldado(id, soldadoEditRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public  ResponseEntity deletarSoldado(@PathVariable Long id) throws Exception {
        soldadoService.deletarSoldado(id);
        return ResponseEntity.ok().build();
    }
}
