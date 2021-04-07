package br.com.zup.catalisa.pdz.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.List;


@Data//O @Data contem todos
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
public class CalcularFormaDTO{

    @NotNull (message="Por favor informar a Unidade de Medida para o calculo!")
    @NotBlank (message="Esse campo não pode estar vazio")
    private String unidadeMedida;

    @Size(min = 1, max = 3, message = "Deve ser informado pelo meno um lado")
    private List<Double> lados;
}
