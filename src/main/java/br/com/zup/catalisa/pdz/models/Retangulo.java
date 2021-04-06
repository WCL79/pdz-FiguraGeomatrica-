package br.com.zup.catalisa.pdz.models;

public class Retangulo extends FiguraGeometrica{

    private Double diagonal;

    public Retangulo() {
        super.setNomeDeFigura("Retângulo");
    }

    public Double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(Double diagonal) {
        this.diagonal = diagonal;
    }
}
