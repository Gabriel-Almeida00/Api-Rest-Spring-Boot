package com.gabriel.forum.controller;

import com.gabriel.forum.controller.Form.TopicoForm;
import com.gabriel.forum.controller.dto.TopicoDTO;
import com.gabriel.forum.modelo.Curso;
import com.gabriel.forum.modelo.Topico;
import com.gabriel.forum.repositories.CursoRepository;
import com.gabriel.forum.repositories.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/topicos")
public class TopicosController {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDTO> lista(String nomeCurso){
        if(nomeCurso == null){
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDTO.converter(topicos);
        }else {
            List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
            return TopicoDTO.converter(topicos);
        }
    }
    @PostMapping
    public void cadastrar(@RequestBody TopicoForm form){
       Topico topico =  form.converter(cursoRepository);
        topicoRepository.save(topico);

    }
}
