package ProgramaMe_Prueba_2011;

import java.util.Arrays;
import java.util.Scanner;

public class ConstanteKaprekar 
{
	public static void main(String[] args) 
	{
		Scanner tec = new Scanner(System.in);
		short N = tec.nextShort();
		int[] casos = new int[N];
		
		for (int i = 0; i < N; i++)
		{
			casos[i] = tec.nextInt();
			if (String.valueOf(casos[i]).length() > 4) i--;
		}
		for (int i = 0; i < N; i++)
		{
			System.out.println(Kaprekar(casos[i]));
		}
	}

	private static int[] transform(int num) 
	{
		int[] asc = new int[4];
		String cadena = String.format("%04d", num);
		int[] trans = new int[2];
		
		for (int i = 0; i < 4; i++)
		{
			asc[i] = Integer.parseInt(String.valueOf(cadena.charAt(i)));
		}
		Arrays.sort(asc);
		trans[0] = asc[3] * 1000 + asc[2] * 100 + asc[1] * 10 + asc[0];
		trans[1] = asc[0] * 1000 + asc[1] * 100 + asc[2] * 10 + asc[3];
		
		return trans;
	}

	private static int Kaprekar(int numero) 
	{
		final int kaprekar = 6174;
		byte counter = 0;
		if (repdigit(String.format("%04d", numero))) return 8;
		if (numero == kaprekar) return 0;
		int[] transforms = new int[2];

		while (numero != kaprekar)
		{
			transforms = transform(numero);
			numero = transforms[0] - transforms[1];
			//System.out.println(transforms[0] + " - " + transforms[1] + " = " + numero);
			counter++;
		}
		
		return counter;
	}

	private static boolean repdigit(String comprobar) 
	{
		//String comprobar = String.format("%04d", numero);
		for (int i = 1; i < comprobar.length(); i++)
		{
			if (comprobar.charAt(0) != comprobar.charAt(i)) return false;
		}
		return true;
	}

}
