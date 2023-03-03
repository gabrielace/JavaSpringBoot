package AulasJava.service;

import AulasJava.dto.CanetaDTO;
import AulasJava.entity.CanetaEntity;
import AulasJava.repository.CanetaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AcaoCanetaServiceImp implements AcaoCanetaService{

    private final CanetaRepository repository;

    public CanetaDTO buscarCaneta(Integer id){
        Optional<CanetaEntity> caneta = this.repository.findById(id);
        CanetaDTO response = new CanetaDTO();
        response.setPonta(caneta.get().getPonta());
        response.setCor(caneta.get().getCor());
        response.setTampa(caneta.get().getTampa());
        response.setTamanho(caneta.get().getTamanho());
        response.setMarca(caneta.get().getMarca());
        return response;
    }

    public void criarCaneta(CanetaDTO dto){
        if ((dto.getPonta() == 0.5 || dto.getPonta() == 0.7) && dto.getTamanho() == 5) {
            if ("BIC".equals(dto.getMarca()) || "FABER".equals(dto.getMarca()) ||
                    "COMPACTOR".equals(dto.getMarca())) {
                CanetaEntity caneta = new CanetaEntity();
                caneta.setPonta(dto.getPonta());
                caneta.setCor(dto.getCor());
                caneta.setTampa(dto.getTampa());
                caneta.setTamanho(dto.getTamanho());
                caneta.setMarca(dto.getMarca());
                this.repository.save(caneta);
            } else {
                System.out.println("Não temos essa marca, apenas Bic, Faber e Compactor.");
            }
        }else {
            System.out.println("Ponta apenas 0.5 ou 0.7, tamanho padrão da caneta é 5cm");
        }
    }

    public CanetaDTO editarCaneta (CanetaEntity entity, Integer id){
        this.isExist(id);
        this.repository.save(entity);
        CanetaDTO response = new CanetaDTO();
        response.setPonta(entity.getPonta());
        response.setCor(entity.getCor());
        response.setTampa(entity.getTampa());
        response.setTamanho(entity.getTamanho());
        response.setMarca(entity.getMarca());
        return response;
    }

    public void deletarCaneta (Integer id){
        this.isExist(id);
        this.repository.deleteById(id);
    }

    private void isExist (Integer id) {
        if (!this.repository.existsById(id))
            throw new RuntimeException("Caneta não existe");
    }
}
