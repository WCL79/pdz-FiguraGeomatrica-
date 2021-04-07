package br.com.zup.catalisa.pdz.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor//Construtor com todos argumentos
public class Triangulo extends FiguraGeometrica {

    private Double altura;
    private String classicacao;

    public Triangulo() {
        super.setNomeDeFigura("Triangulo");
    }
}
