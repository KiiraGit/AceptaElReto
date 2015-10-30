package Ejercicios;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Scanner;

public class _106_CodigosDeBarras 
{
	public static void main(String[] args) 
	{
		Scanner tec = new Scanner(System.in);
		ArrayList<String> salida = new ArrayList();
		
		String codigo = "-1";
		while (true)
		{
			codigo = tec.next();
			if(!codigo.equals("0"))
			{
				if (codigo.length() <= 8)
				{
					codigo = String.format("%08d", Integer.parseInt(codigo));
				}
				else if (codigo.length() < 13)
				{
					codigo = String.format("%013d", Integer.parseInt(codigo));
				}
				salida.add(decrypt(codigo));
			}
			else break;
		}
		for (int i = 0; i < salida.size(); i++)
		{
			System.out.println(salida.get(i));
		}
	}

	private static String decrypt(String codigo) 
	{
		int suma = 0;
		for (int i = 1; i < codigo.length(); i++)
		{
			if (i%2 == 0)
			{
				suma += Integer.parseInt(String.valueOf(codigo.charAt(codigo.length() - i - 1)));
			}
			else
			{
				suma += Integer.parseInt(String.valueOf(codigo.charAt(codigo.length() - i - 1))) * 3;
			}
		}
		suma += Integer.parseInt(String.valueOf(codigo.charAt(codigo.length() - 1)));
		if (codigo.length() == 13)
		{
			
		}
		if (suma%10 == 0)
		{
			return "SI";
		}
		else return "NO";
		//return String.valueOf(suma);
	}
}
