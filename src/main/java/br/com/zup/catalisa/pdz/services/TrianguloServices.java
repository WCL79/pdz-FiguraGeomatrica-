package br.com.zup.catalisa.pdz.services;

import br.com.zup.catalisa.pdz.dto.CalcularFormaDTO;
import br.com.zup.catalisa.pdz.models.CalculoDimensionalSupercial;
import br.com.zup.catalisa.pdz.models.Triangulo;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;


@Service
public class TrianguloServices implements CalculoDimensionalSupercial {

    private Triangulo triangulo;


    public TrianguloServices() {
        this.triangulo = new Triangulo();
    }


    public Triangulo calcularAtributoTriangulo(CalcularFormaDTO calcularFormaDTO){

        Double ladoA = calcularFormaDTO.getLados().get(0);
        Double ladoB = calcularFormaDTO.getLados().get(1);
        Double ladoC = calcularFormaDTO.getLados().get(2);
        triangulo.setUnidadeMedida(calcularFormaDTO.getUnidadeMedida());
        triangulo.setLados(calcularFormaDTO.getLados());

        //ladoA == ladoB  && ladoA == ladoC && ladoB == ladoC DÁ ERRO!!!!
        if (ladoA.equals(ladoB) && ladoB.equals(ladoC)) {

            return calcularEquilatero(triangulo, ladoA, ladoB, ladoC);

            //ladoA == ladoB || ladoA == ladoC || ladoB == ladoC DÁ ERRO!!!

        } else if (ladoA.equals(ladoB) || ladoB.equals(ladoC) || ladoA.equals(ladoC)) {

            return  calcularIsosceles(triangulo, ladoA, ladoB, ladoC);

            //ladoA != ladoB && ladoB != ladoC && ladoA != ladoC
        } else if (!ladoA.equals(ladoB) && !ladoB.equals(ladoC) && !ladoC.equals(ladoA)) {

            return calcularEscaleno(triangulo, ladoA, ladoB, ladoC);

        } else {
            throw new RuntimeException("Erro de processamento");
        }

    }

    private Triangulo calcularEquilatero(Triangulo triangulo, Double ladoA, Double ladoB, Double ladoC){

        triangulo.setClassicacao("EQUILÁTERO");
        triangulo.setArea(calcularAreaTrianguloEquilatero(ladoA, ladoB, ladoC));
        triangulo.setPerimetro(calcularPerimetroTrianguloEquilatero(ladoA));
        triangulo.setAltura(calcularDeAltura(ladoA, ladoC));
        return triangulo;
    }

    private Triangulo calcularIsosceles(Triangulo triangulo, Double ladoA, Double ladoB, Double ladoC){

        triangulo.setClassicacao("ISÓSCELES");
        triangulo.setArea(calcularAreaTrianguloIsoceles(ladoA, ladoB, ladoC));
        triangulo.setPerimetro(calcularPerimetroTrianguloIsoceles(ladoA, ladoB, ladoC));
        triangulo.setAltura(calcularAlturaDoIsosceles(ladoB, ladoC));
        return triangulo;

    }

    private Triangulo calcularEscaleno(Triangulo triangulo, Double ladoA, Double ladoB, Double ladoC){

        triangulo.setClassicacao("ESCALENO");
        triangulo.setArea(calcularAreaTrianguloEscaleno(ladoA, ladoB, ladoC));
        triangulo.setPerimetro(calcularPerimetroTrianguloEscaleno(ladoA, ladoB, ladoC));
        triangulo.setAltura(0.0);
        return triangulo;

    }


    @Override
    public double calcularArea() {
        return 0;
    }

    @Override
    public double calcularPerimetro() {
        return 0;
    }

    @Override
    public double calcularDiagonal() {
        return 0;
    }

    private double calcularPerimetroTrianguloEquilatero(Double ladoA){
        return  3 * ladoA;
    }

    private double calcularPerimetroTrianguloIsoceles(Double ladoA, Double ladoB, Double ladoC){
        return  ladoA+ ladoB + ladoC;
    }

    private double calcularPerimetroTrianguloEscaleno(Double ladoA, Double ladoB, Double ladoC){
        return  ladoA + ladoB + ladoC;
    }

    private double calcularDeAltura(Double base, Double lados){

        Double calcAltura = Math.sqrt(Math.pow(lados, 2) - (Math.pow(base, 2) / 4));
        DecimalFormat decimalFormat = new DecimalFormat("###.##");//Expressão regular
        calcAltura = Double.parseDouble(decimalFormat.format(calcAltura).replace(",","."));
        return calcAltura;
    }


    private double calcularAreaTrianguloEquilatero(Double catetoA, Double catetoB, Double areaHipotenusa){

        Double resultado = (calcularAlturaDoIsosceles(catetoB, areaHipotenusa)*areaHipotenusa)/2;
        Double  base = catetoA/2;
        areaHipotenusa =  Math.sqrt(Math.pow(catetoB, 2) - Math.pow(base, 2)) ;
        areaHipotenusa *= catetoA/2;
        return resultado;
    }

    private double calcularAreaTrianguloIsoceles(Double catetoA, Double catetoB, Double areaHipotenusa){
        Double resultado = (calcularAlturaDoIsosceles(catetoB, areaHipotenusa)*areaHipotenusa)/2;
        Double  base = catetoA/2;
        areaHipotenusa =  Math.sqrt(Math.pow(catetoB, 2) - Math.pow(base, 2)) ;
        areaHipotenusa *= catetoA/2;
        return resultado;
    }

    private double calcularAreaTrianguloEscaleno(Double ladoA, Double ladoB, Double ladoC){
        Double p = (ladoA + ladoB + ladoC)/2;
        System.out.println(p);
        Double areaEscaleno = Math.sqrt(p*(p-ladoA)*(p-ladoB)*(p-ladoC));
        DecimalFormat decimalFormat = new DecimalFormat("###.##");//Expressão regular
        areaEscaleno = Double.parseDouble(decimalFormat.format(areaEscaleno).replace(",","."));
        return  areaEscaleno;
    }

    private double calcularAlturaDoIsosceles(Double ladoA, Double base){
        Double calcAltura = Math.sqrt(Math.pow(ladoA,2) - Math.pow(base/2, 2));
        System.out.println(calcAltura);
        DecimalFormat decimalFormat = new DecimalFormat("###.##");//Expressão regular
        calcAltura = Double.parseDouble(decimalFormat.format(calcAltura).replace(",","."));
        System.out.println(calcAltura);
        return calcAltura;
    }

}


