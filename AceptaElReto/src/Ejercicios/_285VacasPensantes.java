package Ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class _285VacasPensantes 
{

	public static ArrayList<Integer> listaCubos = new ArrayList();
	public static int cantidadComida = 0;
	
	public static void main(String[] args) 
	{
		Scanner tec = new Scanner(System.in);
		int cubos;
		ArrayList<Integer> salidas = new ArrayList();
		
		do
		{
			cubos = tec.nextInt();
			tec.nextLine();
			
			if (cubos > 0)
			{
				boolean turno = true;
				String cantidades = tec.nextLine();
				cantidades += " ";
				
				while (cantidades.length() > 0)
				{
					listaCubos.add(Integer.parseInt(cantidades.substring(0, cantidades.indexOf(' '))));
					cantidades = cantidades.substring(cantidades.indexOf(' ') + 1);
				}
				
				while(listaCubos.size() > 0)
				{
					if (turno)
					{
						if (listaCubos.size() > 2)
						{
							MiVaca();
						} else if (listaCubos.size() > 1)
						{
							if (listaCubos.get(0) >= listaCubos.get(1))
							{
								cantidadComida += listaCubos.get(0);
								listaCubos.remove(0);
							}
							else
							{
								cantidadComida += listaCubos.get(1);
								listaCubos.remove(1);
							}
						} else if (listaCubos.size() == 1)
						{
							cantidadComida += listaCubos.get(0);
							listaCubos.remove(0);
						}
					}
					else
					{
						Devoradora();
					}
					turno = !turno;
				}
				salidas.add(cantidadComida);
				listaCubos.clear();
				cantidadComida = 0;
			}
		} while (cubos != 0);
		
		for (int i = 0; i < salidas.size(); i++)
		{
			System.out.println(salidas.get(i));
		}
	}
	
	public static void Devoradora()
	{
		if (listaCubos.get(0) >= listaCubos.get(listaCubos.size() - 1))
		{
			listaCubos.remove(0);
		}
		else
		{
			listaCubos.remove(listaCubos.size() - 1);
		}
	}
	
	public static void MiVaca()
	{
		int op1 = listaCubos.get(0) - Math.max(listaCubos.get(1), listaCubos.get(listaCubos.size() - 1));
		int op2 = listaCubos.get(listaCubos.size() - 1) - Math.max(listaCubos.get(listaCubos.size() - 2), listaCubos.get(0));
		//System.out.println("Op1: " + op1 + "; Op2: " + op2);
		if (op1 >= op2)
		{
			cantidadComida += listaCubos.get(0);
			listaCubos.remove(0);
		}
		else
		{
			cantidadComida += listaCubos.get(listaCubos.size() - 1);
			listaCubos.remove(listaCubos.size() - 1);
		}
	}

}
