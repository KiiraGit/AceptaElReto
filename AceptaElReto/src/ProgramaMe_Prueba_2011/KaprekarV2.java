package ProgramaMe_Prueba_2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KaprekarV2 {

	public static void main(String[] args) throws IOException
	{
		//Scanner tec = new Scanner(System.in);
		StringBuilder asc = new StringBuilder();
		StringBuilder desc = new StringBuilder();
		char[] num;
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(tec.readLine());
		
		String[] comprobaciones = new String[n];
		for (int i = 0; i < n; i++)
		{
			comprobaciones[i] = tec.readLine();
		}
		for(int i = 0; i < n; i++)
		{
			
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
