package Ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _285VacasPensantesIterativoFinal 
{
	
	public static void main(String[] args) 
	{
		Scanner tec = new Scanner(System.in);
		int cubos;
		ArrayList<Integer> salidas = new ArrayList<Integer>();
		int cont = 0;
		double totalTime = 0;
		
		do
		{
			ArrayList<Integer> listaCubos = new ArrayList<Integer>();
			cubos = tec.nextInt();
			tec.nextLine();
			
			if (cubos > 0)
			{
				String cantidades = tec.nextLine();
				
				String[] arr = cantidades.split(" ");
				for (String cubo : arr)
				{
					listaCubos.add(Integer.valueOf(cubo));
				}
				
				salidas.add(Search(listaCubos, true, 0));
			}
		} while (cubos != 0);
		for (int i = 0; i < salidas.size(); i++)
		{
			System.out.print(salidas.get(i) + "\n");
		}
		tec.close();
	}
	
	public static int Search(List<Integer> leftFood, boolean turn, int eaten)
	{
		if (turn) //	Mi Vaca
		{
			if (leftFood.size() >= 3)
			{
				int left = Search(leftFood.subList(1,  leftFood.size()), !turn, eaten + leftFood.get(0));
				int right = Search(leftFood.subList(0,  leftFood.size() - 1), !turn, eaten + leftFood.get(leftFood.size() - 1));
				return Math.max(left, right);
			}
			else if (leftFood.size() == 2)
			{
				if (leftFood.get(0) > leftFood.get(1))
				{
					eaten += leftFood.get(0);
				}
				else 
				{
					eaten += leftFood.get(1);
				}
				return eaten;
			}
			else
			{
				eaten += leftFood.get(0);
				return eaten;
			}
		}
		else	//	Devoradora
		{
			if (leftFood.get(0) > leftFood.get(leftFood.size() - 1))
			{
				return Search(leftFood.subList(1,  leftFood.size()), !turn, eaten);
			}
			else
			{
				return Search(leftFood.subList(0,  leftFood.size() - 1), !turn, eaten);
			}
		}
	}
}
