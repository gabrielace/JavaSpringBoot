package AulasJava.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CanetaEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Double ponta;
    private String cor;
    private String tampa;
    private Integer tamanho;
    private String marca;

}
