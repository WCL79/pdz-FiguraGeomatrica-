package br.com.zup.catalisa.pdz.controllers;

import br.com.zup.catalisa.pdz.dto.CalcularFormaDTO;
import br.com.zup.catalisa.pdz.models.FiguraGeometrica;
import br.com.zup.catalisa.pdz.services.FiguraGeometricaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.Valid;



@RestController//Indica que este controller por padrão responderá usando, por padrão, o formato JSON
@RequestMapping("/figurasgeometricas")//para mapear as urls dos nossos métodos, neste caso, todos os métodos
// desse controller terão como base o quadrado.
public class FiguraGeometricaController {

    @Autowired//essa anotação indica que os parâmetros serão injetados
    private FiguraGeometricaServices retanguloService;

    @PostMapping//mapea método para grava na lista. Este método será invocado quando a
    // url: /quadrados/, usando o método POST for acessada.
    @ResponseStatus(HttpStatus.CREATED)
    public FiguraGeometrica calcularForma(@RequestBody @Valid CalcularFormaDTO calcularFormato){
        try {
            return retanguloService.calcularFiguraGeometrica(calcularFormato);
        }catch (RuntimeException exception){
       throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }
}