package br.com.zup.catalisa.pdz.services;

import br.com.zup.catalisa.pdz.dto.CalcularFormaDTO;
import br.com.zup.catalisa.pdz.exceptions.ValidacaoDeLados;
import br.com.zup.catalisa.pdz.models.*;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class FiguraGeometricaServices implements CalculoDimensionalSupercial {

    private FiguraGeometrica figuraGeometrica;

    public FiguraGeometrica calcularFiguraGeometrica(CalcularFormaDTO calcularFormaDTO) {

        validarLados(calcularFormaDTO.getLados());//Aqui está sendo invocado o metodo para validar os lados cujo o n° seja menor que 1 e maior que 1000

        if (calcularFormaDTO.getLados().size() == 1) {

            return calcularAtributosQuadrado(calcularFormaDTO);

        } else if (calcularFormaDTO.getLados().size() == 2) {

            return calcularAtributosRetangulo(calcularFormaDTO);

        } else if (calcularFormaDTO.getLados().size() == 3) {

            return calcularAtributoTriangulo(calcularFormaDTO);
        }
        return figuraGeometrica;
    }


    private Quadrado calcularAtributosQuadrado(CalcularFormaDTO calcularFormaDTO){

        Quadrado quadrado = new Quadrado();
        figuraGeometrica = quadrado;
        quadrado.setUnidadeMedida(calcularFormaDTO.getUnidadeMedida());
        quadrado.setLados(calcularFormaDTO.getLados());
        quadrado.setArea(calcularArea());
        quadrado.setPerimetro(calcularPerimetro());
        quadrado.setDiagonal(calcularDiagonal());
        return quadrado;
    }

    private Retangulo calcularAtributosRetangulo(CalcularFormaDTO calcularFormaDTO){

        Retangulo retangulo = new Retangulo();
        figuraGeometrica = retangulo;
        retangulo.setUnidadeMedida(calcularFormaDTO.getUnidadeMedida());
        retangulo.setLados(calcularFormaDTO.getLados());
        retangulo.setArea(calcularArea(retangulo.getLados().get(0), retangulo.getLados().get(1)));
        retangulo.setPerimetro(calcularPerimetro(retangulo.getLados().get(0), retangulo.getLados().get(1)));
        retangulo.setDiagonal(calcularDiagonal(retangulo.getLados().get(0), retangulo.getLados().get(1)));
        return retangulo;

    }

    private Triangulo calcularAtributoTriangulo(CalcularFormaDTO calcularFormaDTO){

        Double ladoA = calcularFormaDTO.getLados().get(0);
        Double ladoB = calcularFormaDTO.getLados().get(1);
        Double ladoC = calcularFormaDTO.getLados().get(2);
        Triangulo triangulo = new Triangulo();
        triangulo.setUnidadeMedida(calcularFormaDTO.getUnidadeMedida());
        triangulo.setLados(calcularFormaDTO.getLados());
        figuraGeometrica = triangulo;

        System.out.println(calcularFormaDTO.getLados());

        //ladoA == ladoB  && ladoA == ladoC && ladoB == ladoC DÁ ERRO!!!!
        if (ladoA.equals(ladoB) && ladoB.equals(ladoC)) {

            return calcularEquilatero(triangulo, ladoA, ladoB, ladoC);

            //ladoA == ladoB || ladoA == ladoC || ladoB == ladoC DÁ ERRO!!!

        } else if (ladoA.equals(ladoB) || ladoB.equals(ladoC) || ladoA.equals(ladoC)) {

            return  calcularIsoceles(triangulo, ladoA, ladoB, ladoC);

        //ladoA != ladoB && ladoB != ladoC && ladoA != ladoC
        } else if (!ladoA.equals(ladoB) && !ladoB.equals(ladoC) && !ladoC.equals(ladoA)) {

            return calcularEscaleno(triangulo, ladoA, ladoB, ladoC);

        } else {
            throw new RuntimeException("Erro de processamento");
        }

    }

    //Método para validar a lista de LADOS
    private void validarLados(List<Double> doubleListLados){
        for(Double ladoDouble : doubleListLados){
            if(ladoDouble <= 0 || ladoDouble >= 1000){
                throw new ValidacaoDeLados("LADOS COM VALORES MENOR QUE 1 OU ACIMA DE 1000!");
            }
        }
    }

    private Triangulo calcularEquilatero(Triangulo triangulo, Double ladoA, Double ladoB, Double ladoC){

        triangulo.setClassicacao("EQUILÁTERO");
        triangulo.setArea(calcularAreaTriangulo(ladoA, ladoB, ladoC));
        triangulo.setPerimetro(calcularPerimetroTrianguloEquilatero(ladoA));
        triangulo.setAltura(calcularDeAltura(ladoA, ladoC));
        return triangulo;
    }

    private Triangulo calcularIsoceles(Triangulo triangulo, Double ladoA, Double ladoB, Double ladoC){

        triangulo.setClassicacao("ISÓSCELES");
        triangulo.setArea(calcularAreaTrianguloIsoceles(ladoA, ladoB, ladoC));
        triangulo.setPerimetro(calcularPerimetroTrianguloIsoceles(ladoA, ladoB, ladoC));
        triangulo.setAltura(calcularDeAlturaDoTrianguloIsosceles(ladoA, ladoB, ladoC));
        return triangulo;

    }

    private Triangulo calcularEscaleno(Triangulo triangulo, Double ladoA, Double ladoB, Double ladoC){

        triangulo.setClassicacao("ESCALENO");
        triangulo.setArea(calcularAreaTriangulo(ladoA, ladoB, ladoC));
        triangulo.setPerimetro(calcularPerimetroTrianguloEscaleno(ladoA, ladoB, ladoC));
        triangulo.setAltura(calcularAlturaDoIsocele(ladoA, ladoC));
        return triangulo;

    }

    @Override
    public double calcularArea() {
      return figuraGeometrica.getLados().get(0)*2;
    }

    public double calcularArea(Double ladoA, Double ladoB) {
        return ladoA * ladoB;
    }

    private double calcularAreaTriangulo(Double ladoA, Double base, Double altura){
        return (altura * base)/2;
    }

    private double calcularAreaTrianguloIsoceles(Double catetoA, Double catetoB, Double areaHipotenusa){
            Double  base = catetoA/2;
            areaHipotenusa =  Math.sqrt(Math.pow(catetoB, 2)- Math.pow(base, 2)) ;
            areaHipotenusa = catetoA * areaHipotenusa/2;
            return areaHipotenusa;
    }

    private double calcularDeAltura(Double base, Double lados){

        Double calcAltura = Math.sqrt(Math.pow(lados, 2) - (Math.pow(base, 2) / 4));
        DecimalFormat decimalFormat = new DecimalFormat("###.##");//Expressão regular
        calcAltura = Double.parseDouble(decimalFormat.format(calcAltura).replace(",","."));
        return calcAltura;
    }

    private double calcularDeAlturaDoTrianguloIsosceles(Double catetoA, Double catetoB, Double areaHipotenusa){
        Double  base = catetoA/2;
        areaHipotenusa =  Math.sqrt(Math.pow(catetoB, 2)- Math.pow(base, 2)) ;
        return areaHipotenusa;
    }

    private double calcularAlturaDoIsocele(Double ladoA, Double base){

        Double calcAltura = Math.sqrt(Math.pow(ladoA,2) - (Math.pow(base, 2)/4));
        DecimalFormat decimalFormat = new DecimalFormat("###.##");//Expressão regular
        calcAltura = Double.parseDouble(decimalFormat.format(calcAltura).replace(",","."));
        return calcAltura;
    }

    @Override
    public double calcularPerimetro() {
        return figuraGeometrica.getLados().get(0)*4;
    }

    public double calcularPerimetro(Double base, Double altura){
        return  (2 * base) + (2 * altura);

    }
    public double calcularPerimetroTrianguloEquilatero(Double ladoA){
        return  3 * ladoA;
    }

    public double calcularPerimetroTrianguloIsoceles(Double ladoA, Double ladoB, Double ladoC){
        return  ladoA+ ladoB + ladoC;
    }

    public double calcularPerimetroTrianguloEscaleno(Double ladoA, Double ladoB, Double ladoC){
        return  ladoA + ladoB + ladoC;
    }
    @Override
    public double calcularDiagonal() {
        Double calcDiagonal = Math.sqrt((figuraGeometrica.getLados().get(0)*4));
        DecimalFormat decimalFormat = new DecimalFormat("###.##");//Expressão regular
        calcDiagonal = Double.parseDouble(decimalFormat.format(calcDiagonal).replace(",","."));
        return calcDiagonal;
    }

    public double calcularDiagonal(Double ladoA, Double ladoB){

        Double calcDiagonal = Math.sqrt(Math.pow(ladoA,2)+ Math.pow(ladoB, 2));
        DecimalFormat decimalFormat = new DecimalFormat("###.##");//Expressão regular
        calcDiagonal = Double.parseDouble(decimalFormat.format(calcDiagonal).replace(",","."));
        return calcDiagonal;
    }
}
