package ProblemaDeLaSemana;

import java.util.ArrayList;
import java.util.Scanner;

public class VacasPensantes2 {

	public static void main(String[] args) 
	{
		Scanner tec = new Scanner(System.in);
		
		short N = 1000;
		
		while(true)
		{
			System.out.println("Nueva entrada");
			N = tec.nextShort();
			if (N == 0) break;
			//else if (N < 1 || N > 1000) continue;
			
			String cantidades = tec.nextLine();
			cantidades += ' ';
			ArrayList<Short> cantidad = new ArrayList();
			
			for (int i = 0; i < N; i++)
			{
				cantidad.add(Short.parseShort(cantidades.substring(0, cantidades.indexOf(' '))));
				System.out.println(cantidades);
				if (cantidad.get(cantidad.size() - 1) > 10000 || cantidad.get(cantidad.size() - 1) < 1)
				{
					cantidad.remove(cantidad.size() - 1);
				}
				cantidades = cantidades.substring(cantidades.indexOf(' ') + 1);
			}
			for (int i = 0; i < cantidad.size(); i++)
			{
				System.out.println(cantidad.get(i));
			}
		}
		
		System.out.println("Salida");
		
	}

}
