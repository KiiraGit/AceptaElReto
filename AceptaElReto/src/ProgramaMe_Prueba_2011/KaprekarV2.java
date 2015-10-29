package ProgramaMe_Prueba_2011;

import java.util.Scanner;

public class KaprekarV2 {

	public static void main(String[] args) 
	{
		Scanner tec = new Scanner(System.in);
		
		int n = tec.nextInt();
		int[] comprobaciones = new int[n];
		for (int i = 0; i < n; i++)
		{
			comprobaciones[i] = tec.nextInt();
			
		}
	}

	private static boolean repdigit(String comprobar) 
	{
		//String comprobar = String.format("%04d", numero);
		for (int i = 1; i < comprobar.length(); i++)
		{
			if (comprobar.charAt(0) != comprobar.charAt(i)) return false;
		}
		return true;
	}

}
