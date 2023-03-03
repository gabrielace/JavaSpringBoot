package AulasJava.service;

import AulasJava.dto.CanetaDTO;
import AulasJava.entity.CanetaEntity;

public interface AcaoCanetaService {

    CanetaDTO buscarCaneta(Integer id);

    void criarCaneta(CanetaDTO dto);

    CanetaDTO editarCaneta (CanetaEntity entity, Integer id);

    void deletarCaneta (Integer id);
}
