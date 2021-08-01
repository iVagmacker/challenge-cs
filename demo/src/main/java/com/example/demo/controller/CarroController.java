package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.model.Carro;
import com.example.demo.model.Marca;
import com.example.demo.service.CarroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "carros")
@RestController
@RequestMapping("/carros")
@CrossOrigin(origins = "http://localhost:4200")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @ApiResponses(
            @ApiResponse(code = 200, message = "Success", response = Carro.class)
    )
    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Carro>> getCarros() {
        List<Carro> carros = carroService.getAllCarros();
        return ResponseEntity.status(HttpStatus.OK).body(carros);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Carro> getCarro(@PathVariable final Long id) {
        Carro carro = carroService.getCarro(id);
        return ResponseEntity.status(HttpStatus.OK).body(carro);
    }

    @PostMapping(path = "/salvar")
    public ResponseEntity<Carro> salvar(@RequestBody @Validated Carro carro) {
        carro = carroService.salvar(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(carro);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Carro> alterar(@PathVariable final BigDecimal id, @Validated @RequestBody Carro carro) {
        carro = carroService.salvar(carro);
        return ResponseEntity.status(HttpStatus.OK).body(carro);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> excluir(@PathVariable final Long id) {
        carroService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}