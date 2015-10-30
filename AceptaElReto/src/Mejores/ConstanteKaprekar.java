package Mejores;

import java.util.Arrays;
import java.util.Scanner;

public class ConstanteKaprekar 
{	//	Tiempo: 1.943s		Memoria: 3585KiB
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
		char[] asc = new char[4];
		String cadena = String.format("%04d", num);
		int[] trans = new int[2];
		asc = cadena.toCharArray();
		Arrays.sort(asc);
		trans[0] = asc[3] * 1000 + asc[2] * 100 + asc[1] * 10 + asc[0];
		trans[1] = asc[0] * 1000 + asc[1] * 100 + asc[2] * 10 + asc[3];
		return trans;
	}

	private static int Kaprekar(int numero) 
	{
		final int kaprekar = 6174;
		byte counter = 0;
		if (numero == kaprekar) return 0;
		int[] transforms = new int[2];

		while (numero != kaprekar)
		{
			transforms = transform(numero);
			numero = transforms[0] - transforms[1];
			if (numero == 0) return 8;
			counter++;
		}
		
		return counter;
	}

}
