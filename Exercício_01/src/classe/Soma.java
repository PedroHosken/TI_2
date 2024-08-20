package classe;
import java.util.*;

class Soma {
	
	//scanner
	  public static Scanner sc = new Scanner(System.in);
	//main
	  public static void main(String args[]) {
		  //definir dados
		    int x,y,sum;
		  //ler dados
		    System.out.println("Entre com dado 01:");
		    x = sc.nextInt();
		    System.out.println("Entre com dado 02:");
		    y = sc.nextInt();
		  //realizar soma
		    sum = x + y;
		  //printar resultado
		    System.out.println("A soma desse resultado e " + sum);
	  }
	

}
