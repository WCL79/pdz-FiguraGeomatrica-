package br.com.zup.catalisa.pdz.services;

import br.com.zup.catalisa.pdz.models.CalculoDimensionalSupercial;
import br.com.zup.catalisa.pdz.models.Retangulo;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class RetanguloServices implements CalculoDimensionalSupercial {

    private Retangulo retangulo;

    public RetanguloServices() {
        this.retangulo = new Retangulo();
    }

    @Override
    public double calcularArea() {
        return retangulo.getLados().get(0)*retangulo.getLados().get(1);
    }

    @Override
    public double calcularPerimetro() {
        return 2*(retangulo.getLados().get(0)+retangulo.getLados().get(1));
    }

    @Override
    public double calcularDiagonal() {
        Double calcDiagonal = Math.sqrt(Math.pow(retangulo.getLados().get(0), 2)+ Math.pow(retangulo.getLados().get(1), 2));
        DecimalFormat decimalFormat = new DecimalFormat("###.##");//Expressão regular
        calcDiagonal = Double.parseDouble(decimalFormat.format(calcDiagonal).replace(",","."));
        return calcDiagonal;
    }

    public Retangulo retangulo(String unidadeDeMediada, List<Double> lados){
        retangulo.setUnidadeMedida(unidadeDeMediada);
        retangulo.setLados(lados);
        retangulo.setArea(calcularArea());
        retangulo.setPerimetro(calcularPerimetro());
        retangulo.setDiagonal(calcularDiagonal());
        return retangulo;
    }
}
