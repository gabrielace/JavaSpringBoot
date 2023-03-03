package AulasJava.controller;

import AulasJava.dto.CanetaDTO;
import AulasJava.entity.CanetaEntity;
import AulasJava.service.AcaoCanetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/canetas.com")
@RequiredArgsConstructor
public class CanetaController {

     private final AcaoCanetaService canetaService;

     @GetMapping("/buscar/{id}")
     public CanetaDTO getCaneta (@PathVariable("id") Integer id){
          return canetaService.buscarCaneta(id);
     }

     @PostMapping("/criar")
     public String postCaneta (@RequestBody CanetaDTO dto){
          canetaService.criarCaneta(dto);
          return "Caneta criada com sucesso";
     }

     @PutMapping("/alterar/{id}")
     public CanetaDTO putCaneta (@RequestBody CanetaEntity entity, @PathVariable("id") Integer id){
          return canetaService.editarCaneta(entity, id);
     }

     @DeleteMapping("/deletar/{id}")
     public String deleteCaneta (@PathVariable Integer id){
          canetaService.deletarCaneta(id);
          return "Caneta excluida com sucesso";
     }
}
