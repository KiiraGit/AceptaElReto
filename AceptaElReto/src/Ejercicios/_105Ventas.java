package Ejercicios;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class _105Ventas
{
	public static void main(String[] args) 
	{
		Scanner tec = new Scanner(System.in).useLocale(Locale.US);
		ArrayList<String> salida = new ArrayList();
		
		double ingresos = 0, cont = 0, mediaSem = 0;
		String diaMax, diaMin, domMax;
		
		while (ingresos != -1 && cont == 0 || cont > 0)
		{
			ingresos = tec.nextDouble();
			if (ingresos != -1)
			{
				mediaSem += ingresos;
			}
			cont++;
			if (cont > 6)
				cont = 0;
		}
	}

}
