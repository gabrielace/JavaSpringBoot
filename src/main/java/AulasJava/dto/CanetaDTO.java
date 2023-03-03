package AulasJava.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CanetaDTO {

    private Double ponta;
    private String cor;
    private String tampa;
    private Integer tamanho;
    private String marca;

}
