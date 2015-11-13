package ProblemaDeLaSemana;

import java.util.Scanner;

public class Artropodos 
{	//	Tiempo: 1.685s		Memoria: 3585KiB
	public static void main(String[] args)
	{
		Scanner tec = new Scanner(System.in);
		int casos, caso;
		
		casos = tec.nextInt();
		
		int salida[] = new int[casos];
		
		tec.nextLine();
		
		for (int i = 0; i < casos; i++)
		{
			String datos = tec.nextLine();
			salida[i] = 0;
			
			//	Insectos (6 patas)
			caso = Integer.valueOf(datos.substring(0, datos.indexOf(' ')));
			salida[i] += caso * 6;
			datos = datos.substring(datos.indexOf(' ') + 1);
//			System.out.println(caso + " insectos = " + caso * 6);
//			System.out.println("Total = " + salida[i]);
			
			//	Aracnidos (8 patas)
			caso = Integer.valueOf(datos.substring(0, datos.indexOf(' ')));
			salida[i] += caso * 8;
			datos = datos.substring(datos.indexOf(' ') + 1);
//			System.out.println(caso + " aracnidos = " + caso * 8);
//			System.out.println("Total = " + salida[i]);
			
			//	Crustaceos (10 patas)
			caso = Integer.valueOf(datos.substring(0, datos.indexOf(' ')));
			salida[i] += caso * 10;
			datos = datos.substring(datos.indexOf(' ') + 1);
//			System.out.println(caso + " crustaceos = " + caso * 10);
//			System.out.println("Total = " + salida[i]);
			
			//	Escolopendras
			caso = Integer.valueOf(datos.substring(0, datos.indexOf(' ')));
			datos = datos.substring(datos.indexOf(' ') + 1);
			
			//	Anillos
//			System.out.println(caso + " escolopendras de " + Integer.valueOf(datos) + " anillos = " + caso * Integer.valueOf(datos));
			salida[i] += caso * (Integer.valueOf(datos) * 2);
//			System.out.println("Total = " + salida[i]);
		}
		for (int i = 0; i < casos; i++)
		{
			System.out.println(salida[i]);
		}
		
	}

}
