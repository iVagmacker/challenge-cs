package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.model.Marca;
import com.example.demo.service.MarcaService;
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

@Api(tags = "marcas")
@RestController
@RequestMapping("/marcas")
@CrossOrigin(origins = "http://localhost:4200")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @ApiResponses(
            @ApiResponse(code = 200, message = "Success", response = Marca.class)
    )
    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Marca>> getMarcas() {
        List<Marca> marcas = marcaService.getAllMarcas();
        return ResponseEntity.status(HttpStatus.OK).body(marcas);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Marca> getMarca(@PathVariable final Long id) {
        Marca marca = marcaService.getMarca(id);
        return ResponseEntity.status(HttpStatus.OK).body(marca);
    }

    @PostMapping(path = "/salvar")
    public ResponseEntity<Marca> salvar(@RequestBody @Validated Marca marca) {
        marca = marcaService.salvar(marca);
        return ResponseEntity.status(HttpStatus.CREATED).body(marca);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Marca> alterar(@PathVariable final BigDecimal id, @Validated @RequestBody Marca marca) {
        marca = marcaService.salvar(marca);
        return ResponseEntity.status(HttpStatus.OK).body(marca);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> excluir(@PathVariable final Long id) {
        marcaService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}