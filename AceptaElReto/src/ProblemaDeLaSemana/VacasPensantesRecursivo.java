package ProblemaDeLaSemana;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class VacasPensantesRecursivo 
{
	public static void main(String[] args) 
	{
		Scanner tec = new Scanner(System.in);
		short N = 1000;
		int[] cantidad = null;
		ArrayList<Integer> salidas = new ArrayList();
		
		while (N != 0)
		{
			N = tec.nextShort();
			
			if (N >= 1 && N <= 1000)
			{
				cantidad = new int[N];
				tec.nextLine();
				String cantidades = tec.nextLine();
				cantidades = cantidades.trim() + ' ';
				for (int i = 0; i < N; i++)
				{
					cantidad[i] = Integer.parseInt(cantidades.substring(0, cantidades.indexOf(' ')));
					cantidades = cantidades.substring(cantidades.indexOf(' ') + 1);
					if (cantidad[i] < 1 || cantidad[i] > 10000)
					{
						i--;
					}
				}
			}
			salidas.add(simulacion(cantidad, true));
		}
		for (int i = 0; i < salidas.size() - 1; i++)
		{
			System.out.println(salidas.get(i));
		}
	}
	
	public static int simulacion(int[] cantidad, boolean turno)
	{
		if (turno)
		{
			if (cantidad.length == 1)
			{
				return cantidad[0];
			}
			else
			{
				int left = cantidad[0] + simulacion(Arrays.copyOfRange(cantidad, 1, cantidad.length), !turno);
				int right = cantidad[cantidad.length - 1] + simulacion(Arrays.copyOfRange(cantidad, 0, cantidad.length - 1), !turno);
				return Math.max(left, right);
			}
		}
		else
		{
			if (cantidad.length == 1)
			{
				return 0;
			}
			else
			{
				if (cantidad[0] >= cantidad[cantidad.length - 1])
				{
					return simulacion(Arrays.copyOfRange(cantidad, 1, cantidad.length), !turno);
				}
				else
				{
					return simulacion(Arrays.copyOfRange(cantidad, 0, cantidad.length - 1), !turno);
				}
			}
		}
	}
}
