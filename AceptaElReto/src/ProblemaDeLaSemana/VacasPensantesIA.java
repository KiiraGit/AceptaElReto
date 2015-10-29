package ProblemaDeLaSemana;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class VacasPensantesIA 
{
	public static void main(String[] args) 
	{
		Scanner tec = new Scanner(System.in);
		short N = 1000;
		int[] cantidad = null;
		ArrayList<Integer> salidas = new ArrayList();
//		ArrayList<Integer> cantidad;
		
		while (N != 0)
		{
			N = tec.nextShort();
//			cantidad = new ArrayList();
			
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
//				while (cantidades.indexOf(' ') > 0 && cantidad.size() < N)
//				{
//					cantidad.add(Integer.parseInt(cantidades.substring(0, cantidades.indexOf(' '))));
//					cantidades = cantidades.substring(cantidades.indexOf(' ') + 1);
//					if (cantidad.get(cantidad.size() - 1) < 1 || cantidad.get(cantidad.size() - 1) > 10000)
//					{
//						cantidad.remove(cantidad.size() - 1);
//					}
//				}
			}
			salidas.add(simulacion(cantidad, true));
			//System.out.println(simulacion(cantidad, true));
//			short[] cantida = {8, 7, 1, 4};
//			System.out.println(simulacion(cantida, true, 1));
		}
		for (int i = 0; i < salidas.size() - 1; i++)
		{
			System.out.println(salidas.get(i));
		}
	}
	
	public static int simulacion(int[] cantidad, boolean turno)
	{
//		System.out.println(nivel);
//		for(int i = 0; i < cantidad.length; i++)
//		{
//			System.out.print(cantidad[i] + "(" + i + ")" + " ");
//		}
//		System.out.println();
		
		if (turno)
		{
			if (cantidad.length == 1)
			{
				//System.out.println("Yo termino: " + cantidad[0]);
				return cantidad[0];
			}
			else
			{
				int left = cantidad[0] + simulacion(Arrays.copyOfRange(cantidad, 1, cantidad.length), !turno);
				//System.out.println(Arrays.copyOfRange(cantidad, 1, cantidad.length).length);
				int right = cantidad[cantidad.length - 1] + simulacion(Arrays.copyOfRange(cantidad, 0, cantidad.length - 1), !turno);
				//System.out.println(Arrays.copyOfRange(cantidad, 0, cantidad.length - 1).length);
//				if (left >= right)
//				{
//					System.out.println("Como " + cantidad[0]);
//				}
//				else System.out.println("Como " + cantidad[cantidad.length - 1]);
				return Math.max(left, right);
			}
		}
		else
		{
			if (cantidad.length == 1)
			{
				//System.out.println("Devoradora termina: " + cantidad[0]);
				return 0;
			}
			else
			{
				if (cantidad[0] >= cantidad[cantidad.length - 1])
				{
					return simulacion(Arrays.copyOfRange(cantidad, 1, cantidad.length), !turno);
					//System.out.println(Arrays.copyOfRange(cantidad, 1, cantidad.length).length);
				}
				else
				{
					return simulacion(Arrays.copyOfRange(cantidad, 0, cantidad.length - 1), !turno);
					//System.out.println(Arrays.copyOfRange(cantidad, 0, cantidad.length - 1).length);
				}
			}
		}
	}
	
	public static int simulator(ArrayList<Short> cantidad, boolean turno)
	{
		System.out.println(cantidad.size() + " " + turno);
		for(int i = 0; i < cantidad.size(); i++)
		{
			System.out.print(cantidad.get(i) + " ");
		}
		System.out.println();
		if (cantidad.size() == 1)
		{
			if (turno) return cantidad.get(0);
			else return 0;
		}
		else 
		{
			if (turno)
			{
				int first = simulator(new ArrayList<Short>(cantidad.subList(1, cantidad.size())), !turno);
				int last = simulator(new ArrayList<Short>(cantidad.subList(0, cantidad.size() - 2)), !turno);
				System.out.println("First " + first);
				System.out.println("Last " + last);
				return Math.max(first, last);
			}
			else 
			{
				if (cantidad.get(0) >= cantidad.get(cantidad.size() - 1))
				{
					return simulator(new ArrayList<Short>(cantidad.subList(1, cantidad.size() - 1)), !turno);
				}
				else return simulator(new ArrayList<Short>(cantidad.subList(0, cantidad.size() - 2)), !turno);
			}
		}
	}
}
