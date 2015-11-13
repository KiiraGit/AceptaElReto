package Ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class _140SumaDeDigitos 
{
	public static void main(String[] args) 
	{
		Scanner tec = new Scanner(System.in);
		int num = 1;
		ArrayList<String> salida = new ArrayList();
		
		while (num > 0)
		{
			num = tec.nextInt();
			if (num > 0)
			{
				char[] digits = String.valueOf(num).toCharArray();
				int suma = 0;
				String result = "";
				if (digits.length > 0)
				{
					for (int i = 0; i < digits.length; i++)
					{
						suma += digits[i];
						result += digits[i];
						if (i + 1 == digits.length)
						{
							result += " = ";
						}
						else
						{
							result += " + ";
						}
					}
					result += suma;
				}
				salida.add(result);
			}
		}
		
		for (int i = 0; i < salida.size(); i++)
		{
			System.out.println(salida.get(i));
		}
	}

}
