package br.com.zup.catalisa.pdz.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor//Construtor com todos argumentos
public class Quadrado extends FiguraGeometrica{

    private Double diagonal;

    public Quadrado() {
        super.setNomeDeFigura("Quadrado");
    }
}
