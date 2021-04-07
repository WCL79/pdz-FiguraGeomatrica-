package br.com.zup.catalisa.pdz.models;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor//Construtor com todos argumentos
public class Retangulo extends FiguraGeometrica{

    private Double diagonal;

    public Retangulo(){
        super.setNomeDeFigura("Retângulo");
    }

}
