package br.com.zup.catalisa.pdz.models;

public class Quadrado extends FiguraGeometrica{

    private Double diagonal;

    public Quadrado() {
        super.setNomeDeFigura("Quadrado");
    }

    public Quadrado(Double diagonal) {
        this.diagonal = diagonal;
    }

    public Double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(Double diagonal) {
        this.diagonal = diagonal;
    }
}
