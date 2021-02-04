import java.util.Scanner;
public class MainJuego{
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();
        int repeat=2;
        System.out.println("~Bienvenido al juego de los dados~");
        System.out.println("==================================");
        do{
            do{
                System.out.print("ingresa el resultado del primer dado: ");
                dado1.setCaraSuperior(entrada.nextInt()); 
            }while(dado1.getCaraSuperio()<1 || dado1.getCaraSuperio()>6);
            do{
            System.out.print("ingresa el resultado del segundo dado: ");
            dado2.setCaraSuperior(entrada.nextInt());
            }while(dado2.getCaraSuperio()<1 || dado2.getCaraSuperio()>6);  
                    
            int resultado = comprobarJuego(dado1, dado2);
            switch (resultado) {
                case 1:
                    System.out.println("Felicidades, haz ganado el PREMIO MAYOR!!!1");
                    repeat=2;
                    break;
                case 2:
                    System.out.println("NooOOoooO, haz perdido :(");
                    repeat=2;
                    break;
                case 3:
                    System.out.print("Mmmm, tienes otra oportunidad para volver a tirar, la tomas? 1=si 2=no: ");
                    repeat=entrada.nextInt();
                    break;
            }
        }while(repeat==1);
        System.out.println("Fin del juego, Te esperamos pronto!! :)");
    }
    public static int comprobarJuego(Dado dado1, Dado dado2){
        int resultado;
        resultado = dado1.getCaraSuperio() + dado2.getCaraSuperio();
        if((resultado == 7)||(resultado == 11)){
           resultado =1;
        }else if((resultado == 2)||(resultado == 3)||(resultado == 12)){
            resultado=2;
        }else if((resultado == 4)||(resultado == 5)||(resultado == 6)||(resultado == 8)||(resultado == 9)||(resultado == 10)){
            resultado = 3;
        }  
        return resultado;  
    }
}
