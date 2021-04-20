package br.com.zup.catalisa.pdz.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor//Construtor com todos argumentos
public class TrianguloEscaleno extends FiguraGeometrica{

    private String classicacao;

    public TrianguloEscaleno() {
        super.setNomeDeFigura("Triangulo");
    }

}
