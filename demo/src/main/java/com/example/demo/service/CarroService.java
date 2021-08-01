package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.ServiceException;
import com.example.demo.model.Carro;
import com.example.demo.repository.CarroRepository;
import com.example.demo.util.Mensagens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> getAllCarros() {
        List<Carro> carros = carroRepository.findAll();

        if (ObjectUtils.isEmpty(carros)) {
            throw new ServiceException(Mensagens.MSG_NENHUM_REGISTRO_ENCONTRADO);
        }

        return carros;
    }

    public Carro getCarro(final Long id) {
        return carroRepository.findById(id)
                .orElseThrow(() -> new ServiceException(Mensagens.MSG_NENHUM_REGISTRO_ENCONTRADO));
    }

    @Transactional
    public Carro salvar(final Carro carro) {
        validarCamposObrigatorios(carro);
        return carroRepository.save(carro);
    }

    public void excluir(final Long id) {
        Carro carro = getCarro(id);
        carroRepository.deleteById(carro.getId());
    }

    private void validarCamposObrigatorios(final Carro carro) {
        boolean vazio = Boolean.FALSE;

        if (StringUtils.isEmpty(carro.getNome())) {
            vazio = Boolean.TRUE;
        }

        if (StringUtils.isEmpty(carro.getKmPorGalao())) {
            vazio = Boolean.TRUE;
        }

        if (StringUtils.isEmpty(carro.getCilindros())) {
            vazio = Boolean.TRUE;
        }

        if (StringUtils.isEmpty(carro.getPeso())) {
            vazio = Boolean.TRUE;
        }

        if (StringUtils.isEmpty(carro.getAceleracao())) {
            vazio = Boolean.TRUE;
        }

        if (StringUtils.isEmpty(carro.getCavaloDeForca())) {
            vazio = Boolean.TRUE;
        }

        if (StringUtils.isEmpty(carro.getAno())) {
            vazio = Boolean.TRUE;
        }

        if (StringUtils.isEmpty(carro.getOrigem())) {
            vazio = Boolean.TRUE;
        }

        if (vazio) {
            throw new ServiceException(Mensagens.MSG_CAMPOS_OBRIGATORIOS);
        }
    }
}