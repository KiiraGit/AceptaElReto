package ProgramaMe_Prueba_2011;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.Arrays;

public class KaprekarMediaVida {
    public static void main(String[] args) throws IOException {

      	StringBuilder asendent = new StringBuilder();
        StringBuilder desendent = new StringBuilder();
        char[] num;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int nNombres, repeticions = 0; 
        nNombres = Integer.parseInt(in.readLine());
        String numS;
        for (int i = 0; i < nNombres; i++) 
        {
            numS = in.readLine();
            repeticions = 0;
            while (!numS.equals("6174")) 
            {
                for (int e = numS.length(); e < 4; e++) 
                {
                	numS += "0";
                }
                num = numS.toCharArray();
                Arrays.sort(num);
                desendent.setLength(0);
                asendent.setLength(0);
                for (int o = 0; o < 4; o++) 
                {
	                desendent.append(num[3 - o]);
	                asendent.append(num[o]);
                }
                numS = new String(String.valueOf(Integer.parseInt(desendent.toString()) - Integer.parseInt(asendent.toString())));
                if (numS.equals("0")) 
                {
                    repeticions = 8;
                    break;
                } 
                else 
                {
                    repeticions++;
                }
            }
            System.out.println(repeticions);
        }
        System.out.println("Fi del programa");
	}
}