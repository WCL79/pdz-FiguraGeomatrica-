package br.com.zup.catalisa.pdz.models;

public class Triangulo extends FiguraGeometrica {

    private Double altura;
    private String classicacao;

    public Triangulo() {
        super.setNomeDeFigura("Triangulo");
    }

    public Triangulo(Double altura, String classicacao) {
        this.altura = altura;
        this.classicacao = classicacao;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getClassiicacao() {
        return classicacao;
    }

    public void setClassiicacao(String classicacao) {
        this.classicacao = classicacao;
    }
}
