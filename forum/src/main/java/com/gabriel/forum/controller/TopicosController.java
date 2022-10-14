package com.gabriel.forum.controller;

import com.gabriel.forum.controller.Form.AtualizacaoTopicoForm;
import com.gabriel.forum.controller.Form.TopicoForm;
import com.gabriel.forum.controller.dto.DetalhesDoTopicoDTO;
import com.gabriel.forum.controller.dto.TopicoDTO;
import com.gabriel.forum.modelo.Curso;
import com.gabriel.forum.modelo.Topico;
import com.gabriel.forum.repositories.CursoRepository;
import com.gabriel.forum.repositories.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
    public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder){
       Topico topico =  form.converter(cursoRepository);
        topicoRepository.save(topico);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDTO(topico));
    }

    @GetMapping("/{id}")
    public DetalhesDoTopicoDTO detalhar (@PathVariable Long id){
        Topico topico = topicoRepository.getOne(id);
        return new DetalhesDoTopicoDTO(topico);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form ){
        Topico topico = form.atualizar(id, topicoRepository);
        return ResponseEntity.ok(new TopicoDTO(topico));
    }
}
