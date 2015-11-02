package Ejercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _106_CodigosDeBarras 
{
	
	public static void main(String[] args)
	{		
		Scanner tec = new Scanner(System.in);
		ArrayList<String> salida = new ArrayList<String>();
		
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
				else
				{
					codigo = String.format("%013d", Long.parseLong(codigo));
				}
				System.out.println(codigo);
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
		final Map<String, String> codigosPaises = new HashMap<String, String>();
		codigosPaises.put("0", "EEUU");
		codigosPaises.put("380", "Bulgaria");
		codigosPaises.put("50", "Inglaterra");
		codigosPaises.put("539", "Irlanda");
		codigosPaises.put("560", "Portugal");
		codigosPaises.put("70", "Noruega");
		codigosPaises.put("759", "Venezuela");
		codigosPaises.put("850", "Cuba");
		codigosPaises.put("890", "India");
		
		String pais = "";
		int suma = 0;
		
		if (codigo.length() == 13)
		{
			for (String key : codigosPaises.values())
			{
				System.out.println(codigo.startsWith(codigosPaises.get(key)));
				System.out.println(codigosPaises.get(key));
				if (codigo.startsWith(codigosPaises.get(key)))
				{
					pais = " " + codigosPaises.get(key);
				}
			}
			if (pais == "")
			{
				pais = " Desconocido";
			}
		}
		
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
		if (suma%10 == 0)
		{
			return "SI" + pais;
		}
		else return "NO";
		//return String.valueOf(suma);
	}
}
