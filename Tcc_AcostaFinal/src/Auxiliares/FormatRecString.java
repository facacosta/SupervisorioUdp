package Auxiliares;

import java.util.ArrayList;
//import Banco.EditarBanco;
import Banco.EditarBd;
import Modelo.SensorNivel;
/**
 *
 * @author facac
 */
public class FormatRecString {
    
    private String dado = null;
    private float valor = 0;
    private String tabela = null;
    private SensorNivel s = null;
    private EditarBd eb = null;
    private ArrayList<Integer> ListEndereco = new ArrayList<Integer>();
    private ArrayList<Integer> ListValor = new ArrayList<Integer>();
    private String endStr = null;
    private int end;
    
    public FormatRecString() {
       
    }
    /**
 * 
 * @param variavel
 * @param in_min
 * @param in_max
 * @param out_min
 * @param out_max
 * @return 
 * função original do map
long map(long x, long in_min, long in_max, long out_min, long out_max)
{   return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;} 
}
 */
     
float mapeamento(int var, int in_min, int in_max, float out_min, float out_max){
      
float variavelf = var;
float in_maxf = in_max;
float in_minf = in_min;
float rangeIn = in_max - in_min;
float rangeOut = out_max - out_min;
float ent = variavelf - in_minf;
float parcela = ent * rangeOut / rangeIn;
valor = parcela + out_min;


return valor;
   }
    public String StatusNivel(int st){
        String status;
        switch(st){
            case 1: // caso o número passado for 1
               return status = "baixo";
            case 2: // caso o número passado for 2
               return status = "normal";
            case 3: // caso o número passado for 2
               return status = "alto";
        }
        return null;
    }
            
     public String StatusBomba(int st){
        String status;
        switch(st){
            case 0: // caso o número passado for 1
               return status = "Desligada";
            case 1: // caso o número passado for 2
               return status = "Ligada";
            case 2: // caso o número passado for 2
               return status = "em falha";
        }
        return null;
    }
    
    public void FormatarDados(String dado){ // metodo para separar as variaveis
        this.dado = dado;   // dado recebido
        String endereco = null; // endereço valor que representa a variavel recebida
        int size = dado.length(); // tamanho do dado recebido
        System.out.print("o dado recebido é: " + dado + "com tamanho: " + size);
        ArrayList<Integer> posi = new ArrayList<Integer>();//armazenar as posições do caracter de marcação
        for(int i = 0; i < size; i++){ // percorre cada caracter do dado
          if (dado.charAt(i) == '#'){ // verifica dentro do dado as posições do "#"
         posi.add(i); // adiciona o valor do indice da posição do caracter
          }
        }
        int sizeListaPosi = posi.size(); // verifica o tamanho da lista dos caracter "#"
        int QuantValores = sizeListaPosi - 1; // o ultimo valor de marcação não carrega 
        //variavel sendo um caracter de fim.
        //System.out.println("A quantidade de valores recebidos é: " + QuantValores);
         for(int i = 0; i < QuantValores; i++){ // famz um loop com a quantidade de # que tem
         char end0 = dado.charAt(posi.get(i) + 1);// soma o valor que este na  posição i com 1 
         char end1 = dado.charAt(posi.get(i) + 2);// soma o valor que este na  posição i com 2
         String end0Str = String.valueOf(end0); // converte para String
         String end1Str = String.valueOf(end1); // converte para String
         endStr = end0Str + end1Str; // concatena os strings achando o endereço;
         System.out.print("o valor do endereço é " + end);
         ListEndereco.add(end); // cria uma lista para endereços
         //int ende0 = Integer.parseInt(String.valueOf(end0));
         //int ende1 = Integer.parseInt(String.valueOf(end1));
         //end = (10 * ende0) + ende1;
        char var0; // posição 0 para o caracter variavel
        char var1; // posição 1 para o caracter variavel
        char var2; // posição 2 para o caracter variavel
        char var3; // posição 3 para o caracter variavel
        int vari0 = 0; // conversão do caracter 0 em inteiro da variável
        int vari1 = 0; // conversão do caracter 1 em inteiro da variável
        int vari2 = 0; // conversão do caracter 2 em inteiro da variável
        int vari3 = 0; // conversão do caracter 3 em inteiro da variável
        int vari = 0; // conversão do caracter 4 em inteiro da variável
         int compVariavel = (posi.get(i + 1)) - (posi.get(i) + 3);// acha o tamanho da variavel
         System.out.print("o tamanho da variavel é " + compVariavel);
         switch(compVariavel){
             case 4: // se a variavel tiver 4 caracteres utiliza este caso
                var0 = dado.charAt(posi.get(i) + 3); //verificar o caracter que esta na posição i + 3
                var1 = dado.charAt(posi.get(i) + 4); // verificar o caracter que esta na posição i + 4
                var2 = dado.charAt(posi.get(i) + 5); // verificar o caracter que esta na posição i + 5
                var3 = dado.charAt(posi.get(i) + 6); // verificar o caracter que esta na posição i + 6
                vari0 = Integer.parseInt(String.valueOf(var0));//cálcula o inteiro que esta na posição i + 3
                vari1 = Integer.parseInt(String.valueOf(var1));//cálcula o inteiro que esta na posição i + 4
                vari2 = Integer.parseInt(String.valueOf(var2));//cálcula o inteiro que esta na posição i + 5
                vari3 = Integer.parseInt(String.valueOf(var3));//cálcula o inteiro que esta na posição i + 6
                vari = (1000 * vari0) + (100 * vari1) + (10 * vari2) + vari3;//Cálcula o valor de acordo com o peso
             break;
             case 3: // se a variavel tiver 3 caracteres utiliza este caso
                var0 = dado.charAt(posi.get(i) + 3);//verificar o caracter que esta na posição i + 3 
                var1 = dado.charAt(posi.get(i) + 4);//verificar o caracter que esta na posição i + 4
                var2 = dado.charAt(posi.get(i) + 5);//verificar o caracter que esta na posição i + 5
                vari0 = Integer.parseInt(String.valueOf(var0));//cálcula o inteiro que esta na posição i + 3
                vari1 = Integer.parseInt(String.valueOf(var1));//cálcula o inteiro que esta na posição i + 4
                vari2 = Integer.parseInt(String.valueOf(var2));//cálcula o inteiro que esta na posição i + 5
                vari = (100 * vari0) + (10 * vari1) + vari2;//Cálcula o valor de acordo com o peso
             break;
             case 2: // se a variavel tiver 4 caracteres utiliza este caso
                var0 = dado.charAt(posi.get(i) + 3); 
                var1 = dado.charAt(posi.get(i) + 4);
                vari0 = Integer.parseInt(String.valueOf(var0));
                vari1 = Integer.parseInt(String.valueOf(var1));
                vari = (10 * vari0) + vari1;
             break;
             case 1: // se a variavel tiver 4 caracteres utiliza este caso
                var0 = dado.charAt(posi.get(i) + 3); 
                vari0 = Integer.parseInt(String.valueOf(var0));
                vari = vari0;
              break;   
          }
         System.out.print("O valor da variavel é " + vari);
         ListValor.add(vari);
        }
    }

public void enviarDados(String dado){
    
    this.FormatarDados(dado);
    eb = new EditarBd();
    float volume;
    float area = 0;
    
    int sizeList = ListEndereco.size();
    System.out.println("A quantidade de dados da lista de endereço é: " + sizeList);
    for(int i = 0; i < sizeList; i ++){
      //  int endereco = ListEndereco.get(i);
        float valor = 0;
        String status;
        String tag;
        
        switch(endStr) {
  case "00"://Sensor0 nivel cisterna
    //valores de nivel tem um mapeamento que nada mais converter o valor vindo do 
    //arduino para valores em cm utilizando o metodo mapeamento.
    valor = this.mapeamento(ListValor.get(i), 103, 145, 0, 18); 
    Memoria.dadoRec0 = valor;// grava o valor na variavel estatica da classe Memoria
    area = (float)0.785; // define uma area para cálculo do volume
    s = new SensorNivel(); // cria uma instancia da classe SensorNivel 
    volume = s.CalculaVolume(valor, area); // calcula o volume atraves da classe SensorNivel
    Memoria.dadoRec11 = volume; // grava a variavel de volume na variavel Statica da classe Memoria
 // envia os valores da váriavel e do volume para a tabela NivelCisterna do banco.
    eb.InserirDadosBancoNivel(valor, volume, "NivelCisterna" ); //utiliza 
  break;    
      
 case "01"://Sensor1 nivel caixa
   valor = this.mapeamento(ListValor.get(i), 115, 145, 0, 18);
   Memoria.dadoRec1 = valor;
   s = new SensorNivel();
    area = (float) 0.004415;
    volume = s.CalculaVolume(valor, area);
    Memoria.dadoRec12 = volume;
  eb.InserirDadosBancoNivel(valor, volume, "NivelCaixa");
  break;    
     
  case "02":// fluxo 
   Memoria.dadoRec2 = valor;
   eb.InserirDadosBancoFloat(valor, "Fluxo");
  break; 
   
   case "03":// Volume
    Memoria.dadoRec8 = valor;
    eb.InserirDadosBancoFloat(valor,"Volume");
   break;     
            
   case "04"://status nivel Cisterna
   status = this.StatusNivel(ListValor.get(i));
   Memoria.dadoRec3 = status;
   tag = "Nível da cisterna";
  eb.InserirDadosBancoSuamrio(dado, tag);
  break;
       
  case "05"://Status nivel caixa
   status = this.StatusNivel(ListValor.get(i));
   Memoria.dadoRec4 = status;
   tag = "Nível da caixa";
  eb.InserirDadosBancoSuamrio(dado, tag);
  break; 
  
  case "06"://Status da bomba do Poço
   status = this.StatusBomba(ListValor.get(i));
   Memoria.dadoRec6 = status;
   tag = "Bomba do Poço";
  eb.InserirDadosBancoSuamrio(status, tag);
  eb.InserirDadosBancoString(status, "BombaPoco");
    
  break; 
      
  case "07"://Status da bomba da Cisterna
   status = this.StatusBomba(ListValor.get(i));
   Memoria.dadoRec7 = status;
   tag = "Bomba da Cisterna";
  eb.InserirDadosBancoSuamrio(status, tag);
  eb.InserirDadosBancoString(status, "BombaCisterna");
    
  break;
      }
    }    
   }
}