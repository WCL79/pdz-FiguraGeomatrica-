package br.com.zup.catalisa.pdz.services;

import br.com.zup.catalisa.pdz.dto.CalcularFormaDTO;
import br.com.zup.catalisa.pdz.exceptions.ValidacaoDeLados;
import br.com.zup.catalisa.pdz.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiguraGeometricaServices{


    private final QuadradoServices quadradoServices;

    private final RetanguloServices retanguloServices;

    private final TrianguloServices trianguloServices;


    @Autowired
    public FiguraGeometricaServices(QuadradoServices quadradoServices, RetanguloServices retanguloServices, TrianguloServices trianguloServices) {
        this.quadradoServices = quadradoServices;
        this.retanguloServices = retanguloServices;
        this.trianguloServices = trianguloServices;
    }

    public FiguraGeometrica calcularFiguraGeometrica(CalcularFormaDTO calcularFormaDTO) {

        validarLados(calcularFormaDTO.getLados());//Aqui está sendo invocado o metodo para validar os lados cujo o n° seja menor que 1 e maior que 1000

        if (calcularFormaDTO.getLados().size() == 1) {

            return quadradoServices.quadrado(calcularFormaDTO.getUnidadeMedida(), calcularFormaDTO.getLados());

        } else if (calcularFormaDTO.getLados().size() == 2) {

            return retanguloServices.retangulo(calcularFormaDTO.getUnidadeMedida(), calcularFormaDTO.getLados());

        } else if (calcularFormaDTO.getLados().size() == 3) {

            return trianguloServices.calcularAtributoTriangulo(calcularFormaDTO);
        }
        else{
            throw new RuntimeException("Número de lados invalidos!");
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
}
