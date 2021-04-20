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
===================================================================================================

RET NGULO.

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
===================================================================================================
