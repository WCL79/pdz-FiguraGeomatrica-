package br.com.zup.catalisa.pdz.services;


import br.com.zup.catalisa.pdz.models.CalculoDimensionalSupercial;
import br.com.zup.catalisa.pdz.models.Quadrado;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class QuadradoServices implements CalculoDimensionalSupercial {

    private Quadrado quadrado;

    public QuadradoServices() {
        this.quadrado = new Quadrado();
    }

    @Override
    public double calcularArea() {
        return quadrado.getLados().get(0)*2;
    }

    @Override
    public double calcularPerimetro() {
        return quadrado.getLados().get(0)*4;
    }

    @Override
    public double calcularDiagonal() {
        Double calcDiagonal = Math.sqrt((quadrado.getLados().get(0)*4));
        DecimalFormat decimalFormat = new DecimalFormat("###.##");//Expressão regular
        calcDiagonal = Double.parseDouble(decimalFormat.format(calcDiagonal).replace(",","."));
        return calcDiagonal;
    }

    public Quadrado quadrado(String unidadeDeMediada, List<Double>lados){

        quadrado.setUnidadeMedida(unidadeDeMediada);
        quadrado.setLados(lados);
        quadrado.setArea(calcularArea());
        quadrado.setPerimetro(calcularPerimetro());
        quadrado.setDiagonal(calcularDiagonal());
        return quadrado;
    }
}
