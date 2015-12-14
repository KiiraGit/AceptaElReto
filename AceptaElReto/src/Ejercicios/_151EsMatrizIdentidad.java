package Ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class _151EsMatrizIdentidad 
{
	public static void main(String[] args) 
	{
		Scanner tec = new Scanner(System.in);
		int caso = 10;
		boolean esMatriz = true;
		ArrayList<String> matrizIntroducida = new ArrayList<String>();
		ArrayList<Boolean> salidas = new ArrayList<Boolean>();

		while (caso != 0)
		{
			caso = tec.nextInt();
			if (caso != 0)
			{
				for (int i = 0; i < caso; i++)
				{
					matrizIntroducida.add(tec.nextLine());
				}
			}
		}
		
	}
	
	public static void checkMatrix(ArrayList<String> matriz)
	{
		for (int i = 1; i < matriz.size(); i++)
		{
			for (int j = 1; j < matriz.size(); j++)
			{
				if (i == 1 && j == 1)
				{
					
				}
			}
		}
	}

}
