package Ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _285VacasPensantesIterativo 
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
//			if (cont < 999)
//				cubos = (int)(Math.random() * 1000) + 1;
//			else cubos = 0;
			
			if (cubos > 0)
			{
				//boolean turno = true;
				String cantidades = tec.nextLine();
				
				//	Prueba
//				String cantidades = "";
//				for (int i = 0; i < 10; i++)
//				{
//					cantidades += String.valueOf((int)(Math.random() * 10000) + 1) + " ";
//				}
				/////////////////////

				//	String conversion into int list ~ 300 millis
					String[] arr = cantidades.split(" ");
					for (String cubo : arr)
					{
						listaCubos.add(Integer.valueOf(cubo));
					}
				/////////////////////

				long start_time = System.nanoTime();
				//Search(listaCubos, true, 0);
					salidas.add(Search(listaCubos, true, 0));
				long end_time = System.nanoTime();
				System.out.println((end_time - start_time)/1e6);
				totalTime += (end_time - start_time)/1e6;
				
				//System.out.println(listaCubos);
				
				//salidas.add(cantidadComida);
				listaCubos.clear();
				//cantidadComida = 0;
				cont++;
			}
		} while (cubos != 0);
		System.out.println("TIEMPO TOTAL: " + totalTime);
		for (int i = 0; i < salidas.size(); i++)
		{
			System.out.println(salidas.get(i));
		}
		tec.close();
	}
	
	public static int Search(List<Integer> leftFood, boolean turn, int eaten)
	{
//		System.out.println((turn?"Mi turno: ":"Turno devoradora: ") + leftFood + ", tamaño: " + leftFood.size());
//		System.out.println("Izquierdo: " + leftFood.get(0) + "; Derecho: " + leftFood.get(leftFood.size() - 1));
		if (turn) //	Mi Vaca
		{
			//System.out.println(leftFood.size());
			if (leftFood.size() >= 3)
			{
				//System.out.println("Cojo el cubo izquierdo con " + leftFood.get(0));
				int left = Search(leftFood.subList(1,  leftFood.size()), !turn, eaten + leftFood.get(0));
//				System.out.println("Trazo 1 con " + left);
//				System.out.println("Cojo el cubo derecho con: " + leftFood.get(leftFood.size() - 1));
				int right = Search(leftFood.subList(0,  leftFood.size() - 1), !turn, eaten + leftFood.get(leftFood.size() - 1));
//				System.out.println("Trazo 2 con " + right);
				return Math.max(left, right);
			}
			else if (leftFood.size() == 2)
			{
				if (leftFood.get(0) > leftFood.get(1))
				{
//					System.out.println("Cojo el cubo izquierdo con " + leftFood.get(0));
					eaten += leftFood.get(0);
				}
				else 
				{
//					System.out.println("Cojo el cubo derecho con: " + leftFood.get(1));
					eaten += leftFood.get(1);
				}
				return eaten;
			}
			else
			{
//				System.out.println("Cojo el ultimo cubo con: " + leftFood.get(0));
				eaten += leftFood.get(0);
				return eaten;
			}
		}
		else	//	Devoradora
		{
//			if (leftFood.size() > 1)
//			{
				if (leftFood.get(0) > leftFood.get(leftFood.size() - 1))
				{
//					System.out.println("Coje el cubo izquierdo con " + leftFood.get(0));
					return Search(leftFood.subList(1,  leftFood.size()), !turn, eaten);
				}
				else
				{
//					System.out.println("Coje el cubo derecho con: " + leftFood.get(leftFood.size() - 1));
					return Search(leftFood.subList(0,  leftFood.size() - 1), !turn, eaten);
				}
//			}
//			else
//			{
//				System.out.println("Cojo el ultimo cubo con: " + leftFood.get(0));
//				return eaten;
//			}
		}
	}
}
