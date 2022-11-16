package com.dev.backend.domain.entity.service;

import com.dev.backend.api.mapper.PessoaMapper;
import com.dev.backend.api.request.PessoaRequest;
import com.dev.backend.domain.entity.Pessoa;
import com.dev.backend.domain.entity.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class PessoaGerenciamentoService {

    private final PessoaRepository repository;
    private final EmailService emailService;
    private final PessoaMapper mapper;

    public String solicitarCodigo(String email) {

        Pessoa pessoa = repository.findByEmail(email);
        pessoa.setCodigoRecuperacaoSenha(getCodigoRecuperacaoSenha(pessoa.getId()));
        pessoa.setDataEnvioCodigo(new Date());
        repository.save(pessoa);
        emailService.enviarEmailTexto(pessoa.getEmail(), "Código de recuperação de senha", "Olá " +
                "o seu código para recuperação de senha é: "+pessoa.getCodigoRecuperacaoSenha());
        return "Código Enviado!";
    }

    public String alterarSenha(PessoaRequest request) {
        Pessoa pessoaBanco = repository.findByEmailAndCodigoRecuperacaoSenha
                (request.getEmail(), request.getCodigoRecuperacaoSenha());

        Date diferenca = new Date(new Date().getTime() - pessoaBanco.getDataEnvioCodigo().getTime());

        if(diferenca.getTime()/1000 < 900) {
            pessoaBanco.setSenha(request.getSenha());
            pessoaBanco.setCodigoRecuperacaoSenha(null);
            pessoaBanco.setDataEnvioCodigo(null);
            repository.save(pessoaBanco);
            return "Senha alterada com sucesso";
        } else {
            return "Tempo expirado, solicite um novo código";
        }
    }

    private String getCodigoRecuperacaoSenha(Long id) {
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");
        return format.format(new Date())+id;
    }
}
