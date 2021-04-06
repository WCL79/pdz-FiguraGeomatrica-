package br.com.zup.catalisa.pdz.models;

import javax.validation.constraints.*;
import java.util.List;

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

    public FiguraGeometrica() {
    }

    public String getNomeDeFigura() {
        return nomeDeFigura;
    }

    public void setNomeDeFigura(String nomeDeFigura) {
        this.nomeDeFigura = nomeDeFigura;
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

    public Double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(Double perimetro) {
        this.perimetro = perimetro;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }
}
