package Ejercicios;

import java.util.Scanner;

public class _300PalabrasPentavocalicas 
{
	public static void main(String[] args) 
	{
		Scanner tec = new Scanner(System.in);
		int n;
		
		n = tec.nextInt();
		
		boolean[] salidas = new boolean[n];
		
		for (int j = 0; j < n; j++)
		{
			boolean a = false, e = false, i = false, o = false, u = false;
			String nextWord = tec.next();
			
			for (int l = 0; l < nextWord.length(); l++)
			{
				switch(nextWord.charAt(l))
				{
					case 'a':
						a = true;
						break;
					case 'e':
						e = true;
						break;
					case 'i':
						i = true;
						break;
					case 'o':
						o = true;
						break;
					case 'u':
						u = true;
				}
			}
			salidas[j] = (a && e && i && o && u);
		}
		for (int s = 0; s < n; s++)
		{
			System.out.println(salidas[s]?"SI":"NO");
		}
	}

}
