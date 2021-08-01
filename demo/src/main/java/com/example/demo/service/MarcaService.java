package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.ServiceException;
import com.example.demo.model.Marca;
import com.example.demo.repository.MarcaRepository;
import com.example.demo.util.Mensagens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> getAllMarcas() {
        List<Marca> marcas = marcaRepository.findAll();

        if (ObjectUtils.isEmpty(marcas)) {
            throw new ServiceException(Mensagens.MSG_NENHUM_REGISTRO_ENCONTRADO);
        }

        return marcas;
    }

    public Marca getMarca(final Long id) {
        return marcaRepository.findById(id)
                .orElseThrow(() -> new ServiceException(Mensagens.MSG_NENHUM_REGISTRO_ENCONTRADO));
    }

    @Transactional
    public Marca salvar(final Marca marca) {
        validarCamposObrigatorios(marca);
        return marcaRepository.save(marca);
    }

    public void excluir(final Long id) {
        Marca marca = getMarca(id);
        marcaRepository.deleteById(marca.getId());
    }

    private void validarCamposObrigatorios(final Marca marca) {
        boolean vazio = Boolean.FALSE;

        if (StringUtils.isEmpty(marca.getNome())) {
            vazio = Boolean.TRUE;
        }

        if (StringUtils.isEmpty(marca.getOrigem())) {
            vazio = Boolean.TRUE;
        }

        if (vazio) {
            throw new ServiceException(Mensagens.MSG_CAMPOS_OBRIGATORIOS);
        }
    }
}