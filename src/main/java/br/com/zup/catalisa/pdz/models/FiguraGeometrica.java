package br.com.zup.catalisa.pdz.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.List;

@Data//O @Data contem todos
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
public class FiguraGeometrica {


    private String nomeDeFigura;
    @NotNull(message = "Por favor informar a Unidade de Medida para o calculo!")
    @NotBlank(message = "Esse campo não pode estar vazio")
    private String unidadeMedida;

    @Size(min = 1, max = 3, message = "Deve ser informado pelo meno um lado")
    @Min(message = "Deve ser informado no mínimo 1", value = 1)
    @Max(message = "O maximo a ser informado não deve ultrapassar 10.000",value = 10000)
    private List<Double> lados;
    private Double perimetro;
    private Double area;

}
