package Ejercicios;

import java.util.Scanner;

public class _125NumerosVampiro 
{
	public static void main(String[] args) 
	{
		Scanner tec = new Scanner(System.in);
		int n;
		
		n = tec.nextInt();
		boolean[] salidas = new boolean[n];
		
		for (int i = 0; i < n; i++)
		{
			String caso = tec.next();
			if (caso.length() % 2 == 0)
			{
				calcularColmillos(caso);
			}
		}
		
	}
	
	public static void calcularColmillos(String num)
	{
		String colmillo1, colmillo2;
		int longitudColmillo = num.length() / 2;
		//	Prueba laterales
		colmillo1 = num.substring(0, longitudColmillo);
		colmillo2 = num.substring(longitudColmillo);
		System.out.println(colmillo1);
		System.out.println(colmillo2);
	}

}
