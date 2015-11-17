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
		
		double ingresos = 0, mediaSem = 0, diaMaxC = 0, diaMinC = 10000000;
		int cont = 0;
		String diaMax = "", diaMin = "", domMax;
		
		while (ingresos != -1 && cont == 0 || cont > 0)
		{
			ingresos = tec.nextDouble();
			if (ingresos != -1)
			{
				mediaSem += ingresos;
				if (ingresos > diaMaxC) 
				{
					diaMaxC = ingresos;
					diaMax = diaSelect(cont);
				}
				else if (ingresos < diaMinC)
				{
					diaMinC = ingresos;
					diaMin = diaSelect(cont);
				}
				else
				{
					if (ingresos == diaMaxC)
					{
						diaMax = diaSelect(15);
					}
					if (ingresos == diaMinC)
					{
						diaMin = diaSelect(15);
					}
				}
			}
			cont++;
			if (cont == 6)
			{
				cont = 0;
				mediaSem /= 6;
				if (mediaSem > ingresos)
				{
					domMax = "SI";
				}
				else domMax = "NO";
				salida.add(diaMax + diaMin + domMax);
				diaMinC = 10000000;
				diaMaxC = 0;
				diaMax = "";
				diaMin = "";
				domMax = "";
				mediaSem = 0;
			}
		}
	}
	
	public static String diaSelect(int dia)
	{
		switch (dia)
		{
			case 0:
				return "MARTES";
			case 1:
				return "MIERCOLES";
			case 2:
				return "JUEVES";
			case 3:
				return "VIERNES";
			case 4:
				return "SABADO";
			case 5:
				return "DOMINGO";
			default:
				return "EMPATE";
		}
	}

}
