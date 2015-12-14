package Ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class _232FelizNoCumpleanos 
{
	public static void main(String[] args) 
	{
		byte[] diasMeses = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		Scanner tec = new Scanner(System.in);
		String caso = "";
		ArrayList<Integer> salidas = new ArrayList();
		byte diaCum, mesCum, diaCom, mesCom;
		int anoCum, anoCom;
		
		while (!caso.equals("0 0 0 0 0 0"))
		{
			caso = tec.nextLine();
			if (!caso.equals("0 0 0 0 0 0"))
			{
				diaCum = Byte.valueOf(caso.substring(0, caso.indexOf(' ')));
				caso = caso.substring(caso.indexOf(' ') + 1);
				mesCum = Byte.valueOf(caso.substring(0, caso.indexOf(' ')));
				caso = caso.substring(caso.indexOf(' ') + 1);
				anoCum = Integer.valueOf(caso.substring(0, caso.indexOf(' ')));
				caso = caso.substring(caso.indexOf(' ') + 1);
				diaCom = Byte.valueOf(caso.substring(0, caso.indexOf(' ')));
				caso = caso.substring(caso.indexOf(' ') + 1);
				mesCom = Byte.valueOf(caso.substring(0, caso.indexOf(' ')));
				caso = caso.substring(caso.indexOf(' ') + 1);
				anoCom = Integer.valueOf(caso);
				
				if (diaCum == diaCom && mesCum == mesCom)
				{
					salidas.add(0);
				}
				else
				{
					int diasNC = 0;
					int diasAnoCumple = 365, diasAnoCom = 0, diasInt = 0;
					
					for (int i = 0; i < mesCum - 1; i++)
					{
						diasAnoCumple -= diasMeses[i];
					}
					diasAnoCumple -= diaCum;
					
					for (int i = 0; i < mesCom - 1; i++)
					{
						diasAnoCom += diasMeses[i];
					}
					diasAnoCom += diaCom;
					
					diasInt = Math.abs(anoCum - (anoCom - 1)) * 365;
					diasInt -= Math.abs(anoCum - (anoCom - 1));
					diasNC = diasAnoCumple + diasAnoCom + diasInt;
					
					if (mesCom > mesCum || (mesCom == mesCum && diaCom > diaCum))
					{
						diasNC--;
					}
					
					salidas.add(diasNC);
				}
				
			}
		}
		for (int i = 0; i < salidas.size(); i++)
		{
			System.out.println(salidas.get(i));
		}
	}
}
