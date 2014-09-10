package br.com.caelum.tarefas.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacoes
{
    //Método que valida o CPF
    public static boolean ValidaCPF(String vrCPF)
    {
        String valor = vrCPF.replace(".", "");
        valor = valor.replace("-", "");
        
        if (valor.length() != 11)
            return false;

        boolean igual = true;
        for (int i = 1; i < 11 && igual; i++)
            if (valor.charAt(i) != valor.charAt(0))
                igual = false;

        if (igual || valor == "12345678909")
            return false;

        int[] numeros = new int[11];
        for (int i = 0; i < 11; i++)
            numeros[i] = Integer.parseInt((String.valueOf(valor.charAt(i))));

        int soma = 0;
        for (int i = 0; i < 9; i++)
            soma += (10 - i) * numeros[i];
       
        int resultado = soma % 11;
        if (resultado == 1 || resultado == 0)
        {
            if (numeros[9] != 0)
                return false;
        }
        else if (numeros[9] != 11 - resultado)
            return false;

        soma = 0;
        for (int i = 0; i < 10; i++)
            soma += (11 - i) * numeros[i];

        resultado = soma % 11;

        if (resultado == 1 || resultado == 0)
        {
            if (numeros[10] != 0)
                return false;

        }
        else
            if (numeros[10] != 11 - resultado)
                return false;
        return true;

    }

    //Método que valida o CNPJ 
    public static boolean ValidaCNPJ(String vrCNPJ)
    {

        String CNPJ = vrCNPJ.replace(".", "");
        CNPJ = CNPJ.replace("/", "");
        CNPJ = CNPJ.replace("-", "");

        int[] digitos, soma, resultado;
        int nrDig;
        String ftmt;
        boolean[] CNPJOk;

        ftmt = "6543298765432";
        digitos = new int[14];
        soma = new int[2];
        soma[0] = 0;
        soma[1] = 0;
        resultado = new int[2];
        resultado[0] = 0;
        resultado[1] = 0;
        CNPJOk = new boolean[2];
        CNPJOk[0] = false;
        CNPJOk[1] = false;

        try
        {
            for (nrDig = 0; nrDig < 14; nrDig++)
            {
                digitos[nrDig] = Integer.parseInt(CNPJ.substring(nrDig, 1));
                if (nrDig <= 11)
                    soma[0] += (digitos[nrDig] * Integer.parseInt(ftmt.substring(nrDig + 1, 1)));
                if (nrDig <= 12)
                    soma[1] += (digitos[nrDig] * Integer.parseInt(ftmt.substring(nrDig, 1)));
              }

            for (nrDig = 0; nrDig < 2; nrDig++)
            {
                resultado[nrDig] = (soma[nrDig] % 11);
                if ((resultado[nrDig] == 0) || (resultado[nrDig] == 1))
                    CNPJOk[nrDig] = (
                    digitos[12 + nrDig] == 0);

                else
                    CNPJOk[nrDig] = (
                    digitos[12 + nrDig] == (
                    11 - resultado[nrDig]));

            }

            return (CNPJOk[0] && CNPJOk[1]);

        }
        catch (Exception e)
        {
            return false;
        }

    }

    //Método que valida o Cep
    public static boolean ValidaCep(String cep)
    {
        if (cep.length() == 8)
        {
            cep = cep.substring(0, 5) + "-" + cep.substring(5, 3);
            //txt.Text = cep;
        }
        
        // Padrão que caracteriza caracteres numéricos
 		Pattern numericos = Pattern.compile("([0-9])");

 		// Colocando o texto no padrão para ver o que encaixa
 		//Matcher encaixe = numericos.matcher(entrada);
        
        //return System.Text.RegularExpressions.Regex.IsMatch(cep, ("[0-9]{5}-[0-9]{3}"));
 		
 		return false;
    }

    //Método que valida o Email
    public static boolean ValidaEmail(String email)
    {
        // return System.Text.RegularExpressions.Regex.IsMatch(email, ("(?<user>[^@]+)@(?<host>.+)"));
    	return false;
    }


}
