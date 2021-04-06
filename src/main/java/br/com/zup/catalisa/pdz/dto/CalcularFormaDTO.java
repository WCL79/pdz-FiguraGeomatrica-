package br.com.zup.catalisa.pdz.dto;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.validation.constraints.*;
import java.util.List;


public class CalcularFormaDTO{

    @NotNull (message="Por favor informar a Unidade de Medida para o calculo!")
    @NotBlank (message="Esse campo não pode estar vazio")
    private String unidadeMedida;


   //

    //@Digits(integer=10, fraction=0)
    //@DecimalMax("10.000")
   // @DecimalMin("1")

    @Size(min = 1, max = 3, message = "Deve ser informado pelo meno um lado")
    private List<Double> lados;

    public CalcularFormaDTO() {

    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public List<Double> getLados() {
        return lados;
    }

    public void setLados(List<Double> lados) {
        this.lados = lados;
    }
}
