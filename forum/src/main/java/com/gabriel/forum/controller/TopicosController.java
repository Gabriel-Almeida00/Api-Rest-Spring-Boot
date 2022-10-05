package com.gabriel.forum.controller;

import com.gabriel.forum.controller.dto.TopicoDTO;
import com.gabriel.forum.modelo.Curso;
import com.gabriel.forum.modelo.Topico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    @RequestMapping("/topicos")
    public List<TopicoDTO> lista(){
        Topico topico = new Topico("Duvida", "duvida com spring", new Curso("Spring", "Programação"));
        return TopicoDTO.converter(Arrays.asList(topico, topico, topico));
    }
}
