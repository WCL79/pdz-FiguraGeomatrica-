# pdz-FiguraGeomatrica:

Nesse repositório contém uma API que faz cálculo de Área, Perímetro e Altura das formas geométricas: 
Quadrado, Retângulo e de Triângulos (Equilátero, Isósceles e Escaleno, ESSE NÃO HÁ CÁLCULO DE ALTURA!).

COMO TESTAR?

QUADRADO.

Entrada:
{
  "lados": [
    2
  ],
  "unidadeMedida": "cm"
}

PROCESSAMENTO:
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

Saída:
{
  "nomeDeFigura": "Quadrado",
  "unidadeMedida": "cm",
  "lados": [
    2
  ],
  "perimetro": 8,
  "area": 4,
  "diagonal": 2.83
}
-------------------------------------------------------------------------------------

RETÂNGULO.

Entrada:

{
  "lados": [
    2 , 4
  ],
  "unidadeMedida": "cm"
}
PROCESSAMENTO 

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
Saída:

{
  "nomeDeFigura": "Retângulo",
  "unidadeMedida": "cm",
  "lados": [
    2,
    4
  ],
  "perimetro": 12,
  "area": 8,
  "diagonal": 4.47
--------------------------------------------------------------------------------------------------------------------------
TRIÂNGULO EQUILÁTERO.

Entrada:
{
  "lados": [
    4, 4, 4
  ],
  "unidadeMedida": "cm"
}
PROCESSAMENTO

private double calcularPerimetroTrianguloEquilatero(Double ladoA){
   return  3 * ladoA;
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

Saída:
{
  "nomeDeFigura": "Triangulo",
  "unidadeMedida": "cm",
  "lados": [
    4,
    4,
    4
  ],
  "perimetro": 12,
  "area": 6.92,
  "altura": 3.46,
  "classicacao": "EQUILÁTERO"
}
--------------------------------------------------------------------------------------------------------------------------------------------
TRIÂNGULO ISÓSCELES.

Entrada:

{
  "lados": [
    4, 4, 6 => OBSERVAÇÃO ESSE ÚLTIMO INDEX REFERE-SE A BASE DO CÁLCULO A=b*h/2, ENTÃO PARA RESULTADO CERTO DEVE-SE SEGUIR DESTA FORMA!
  ],
  "unidadeMedida": "cm"
}

PROCESSAMENTO

private double calcularPerimetroTrianguloIsoceles(Double ladoA, Double ladoB, Double ladoC){
   return  ladoA+ ladoB + ladoC;
}

private double calcularAreaTrianguloIsoceles(Double catetoA, Double catetoB, Double areaHipotenusa){

   Double resultado = (calcularAlturaDoIsosceles(catetoB, areaHipotenusa)*areaHipotenusa)/2;
   Double  base = catetoA/2;
   areaHipotenusa =  Math.sqrt(Math.pow(catetoB, 2) - Math.pow(base, 2)) ;
   areaHipotenusa *= catetoA/2;
   DecimalFormat decimalFormat = new DecimalFormat("###.##");//Expressão regular
   resultado = Double.parseDouble(decimalFormat.format(resultado).replace(",","."));
   return resultado;
}

Saída:
{
  "nomeDeFigura": "Triangulo",
  "unidadeMedida": "cm",
  "lados": [
    4,
    4,
    6
  ],
  "perimetro": 14,
  "area": 7.95,
  "altura": 2.65,
  "classicacao": "ISÓSCELES"
}
-----------------------------------------------------------------------------------------------------------------------------
TRI NGULO ESCALENO.

Entrada:

{
  "lados": [
    4, 6, 8
  ],
  "unidadeMedida": "cm"
}

PROCESSAMENTO

private double calcularPerimetroTrianguloEscaleno(Double ladoA, Double ladoB, Double ladoC){
   return  ladoA + ladoB + ladoC;
}

private double calcularAreaTrianguloEscaleno(Double ladoA, Double ladoB, Double ladoC){
   Double p = (ladoA + ladoB + ladoC)/2;
   Double areaEscaleno = Math.sqrt(p*(p-ladoA)*(p-ladoB)*(p-ladoC));
   DecimalFormat decimalFormat = new DecimalFormat("###.##");//Expressão regular
   areaEscaleno = Double.parseDouble(decimalFormat.format(areaEscaleno).replace(",","."));
   return  areaEscaleno;
}

Saída:

{
  "nomeDeFigura": "Triangulo",
  "unidadeMedida": "cm",
  "lados": [
    4,
    6,
    8
  ],
  "perimetro": 18,
  "area": 11.62,
  "classicacao": "ESCALENO"
}



