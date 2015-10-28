package ProblemaDeLaSemana;

import java.util.ArrayList;
import java.util.Scanner;

public class VacasPensantes 
{
	public static void main(String[] args) 
	{
		Scanner tec = new Scanner(System.in);
		
		short N = 1000;
		ArrayList<Short> cantidades = new ArrayList();
		String cantidad;
		ArrayList<Short> salidas = new ArrayList();
		
		while(N > 0)
		{
			System.out.println("Prueba nueva");
			N = tec.nextShort();
			if (N > 0 && N < 1000)
			{
				cantidades = new ArrayList(N);
				for (int i = 0; i < N; i++)
				{
					cantidad = tec.nextLine();
					cantidad += ' ';
					while(cantidad.indexOf(' ') > 0 && cantidades.size() < N)
					{
						cantidades.add(Short.parseShort(cantidad.substring(0, cantidad.indexOf(' '))));
						System.out.println(cantidades.get(cantidades.size() - 1));
						cantidad = cantidad.substring(cantidad.indexOf(' ') + 1);
						if (cantidades.get(cantidades.size() - 1) < 0 || cantidades.get(cantidades.size() - 1) > 10000)
						{
							cantidades.remove(cantidades.size() - 1);
						}
					}
				}
				salidas.add(calcularComida(cantidades));
			}
		}
		for(int i = 0; i < salidas.size(); i++)
		{
			System.out.println(salidas.get(i));
		}
	}
	
	public static short calcularComida(ArrayList<Short> cantidades)
	{
		short comidaIngerida = 0;
		boolean turno = false;
		while (!cantidades.isEmpty())
		{
			if (cantidades.get(0) > cantidades.get(cantidades.size() - 1))
			{
				if (!turno)
				{
					comidaIngerida += cantidades.get(0);
				}
				cantidades.remove(0);
			}
			else
			{
				if (!turno)
				{
					comidaIngerida += cantidades.get(cantidades.size() - 1);
				}
				cantidades.remove(cantidades.size() - 1);
			}
			turno = !turno;
		}
		return comidaIngerida;
	}
}
