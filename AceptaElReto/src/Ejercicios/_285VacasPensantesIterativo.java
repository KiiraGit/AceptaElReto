package Ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _285VacasPensantesIterativo 
{

	public static int maxTry = 0;
	
	public static void main(String[] args) 
	{
		Scanner tec = new Scanner(System.in);
		int cubos;
		ArrayList<Integer> salidas = new ArrayList<Integer>();
		int cont = 0;
		double totalTime = 0;
		
		do
		{
			maxTry = 0;
			ArrayList<Integer> listaCubos = new ArrayList<Integer>();
			//cubos = tec.nextInt();
			//tec.nextLine();
			if (cont < 999)
				cubos = (int)(Math.random() * 1000) + 1;
			
			else cubos = 0;
			
			if (cubos > 0)
			{
				//boolean turno = true;
				//String cantidades = tec.nextLine();
				
				//	Prueba
				String cantidades = "";
				for (int i = 0; i < 1000; i++)
				{
					cantidades += String.valueOf((int)(Math.random() * 10000) + 1) + " ";
				}
				/////////////////////

				//	String conversion into int list ~ 300 millis
					String[] arr = cantidades.split(" ");
					for (String cubo : arr)
					{
						listaCubos.add(Integer.valueOf(cubo));
					}
				/////////////////////

				long start_time = System.nanoTime();
				Search(listaCubos, true, 0);
				long end_time = System.nanoTime();
				totalTime += (end_time - start_time)/1e6;
				
				//System.out.println(listaCubos);
				
				//salidas.add(cantidadComida);
				//listaCubos.clear();
				//cantidadComida = 0;
				cont++;
			}
		} while (cubos != 0);
		System.out.println(totalTime);
//		for (int i = 0; i < salidas.size(); i++)
//		{
//			System.out.println(salidas.get(i));
//		}
		tec.close();
	}
	
	public static void Search(List<Integer> leftFood, boolean turn, int eaten)
	{
		if (turn)
		{
			switch(leftFood.size())
			{
				case 1:
					eaten += leftFood.get(0);
					if (eaten > maxTry)
						maxTry = eaten;
					break;
				case 2:
					if (leftFood.get(0) >= leftFood.get(1))
						eaten += leftFood.get(0);
					else 
						eaten += leftFood.get(1);
					if (eaten > maxTry)
						maxTry = eaten;
					break;
				default:
					Search(leftFood.subList(1,  leftFood.size() - 1), !turn, eaten + leftFood.get(0));
					Search(leftFood.subList(0,  leftFood.size() - 2), !turn, eaten + leftFood.get(leftFood.get(leftFood.size() - 1)));
			}
		}
		else
		{
			if (leftFood.get(0) > leftFood.get(leftFood.size() - 1))
			{
				Search(leftFood.subList(1,  leftFood.size() - 1), !turn, eaten);
			}
			else
			{
				Search(leftFood.subList(0,  leftFood.size() - 2), !turn, eaten);
			}
		}
	}
	
//	public static void Devoradora()
//	{
//		if (listaCubos.get(0) >= listaCubos.get(listaCubos.size() - 1))
//		{
//			listaCubos.remove(0);
//		}
//		else
//		{
//			listaCubos.remove(listaCubos.size() - 1);
//		}
//	}
//	
//	public static void MiVaca()
//	{
//		int op1 = listaCubos.get(0) - Math.max(listaCubos.get(1), listaCubos.get(listaCubos.size() - 1));
//		int op2 = listaCubos.get(listaCubos.size() - 1) - Math.max(listaCubos.get(listaCubos.size() - 2), listaCubos.get(0));
//		//System.out.println("Op1: " + op1 + "; Op2: " + op2);
//		if (op1 >= op2)
//		{
//			cantidadComida += listaCubos.get(0);
//			listaCubos.remove(0);
//		}
//		else
//		{
//			cantidadComida += listaCubos.get(listaCubos.size() - 1);
//			listaCubos.remove(listaCubos.size() - 1);
//		}
//	}

}
