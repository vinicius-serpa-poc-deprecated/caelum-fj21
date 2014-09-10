package br.com.caelum.tarefas.util;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacao {

	// 02998301000181
	static public boolean isCNPJ(String str_cnpj) {
		int soma = 0, aux, dig;
		String cnpj_calc = str_cnpj.substring(0, 12);

		if (str_cnpj.length() != 14)
			return false;

		char[] chr_cnpj = str_cnpj.toCharArray();

		for (int i = 0; i < 4; i++)
			if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9)
				soma += (chr_cnpj[i] - 48) * (6 - (i + 1));

		for (int i = 0; i < 8; i++)
			if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9)
				soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));

		dig = 11 - (soma % 11);

		cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);

		soma = 0;

		for (int i = 0; i < 5; i++)
			if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9)
				soma += (chr_cnpj[i] - 48) * (7 - (i + 1));

		for (int i = 0; i < 8; i++)
			if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9)
				soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));

		dig = 11 - (soma % 11);
		cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(dig);

		return str_cnpj.equals(cnpj_calc);
	}

	public String removeNaoNumericos(String entrada) {
		// Padrão que caracteriza caracteres numéricos
		Pattern numericos = Pattern.compile("([0-9])");

		// Colocando o texto no padrão para ver o que encaixa
		Matcher encaixe = numericos.matcher(entrada);

		// Criando um buffer de saída, que é uma solução
		// mais otimizada do que ir concatenando uma String
		StringBuffer saida = new StringBuffer();

		// A cada número encontrado
		while (encaixe.find())
			// Adiciona-se esse número ao buffer
			saida.append(encaixe.group());

		// Devolvendo o buffer convertido em String
		return saida.toString();
	}

	public static boolean isCPF(String CPF) {

		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111")
				|| CPF.equals("22222222222") || CPF.equals("33333333333")
				|| CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777")
				|| CPF.equals("88888888888") || CPF.equals("99999999999")
				|| (CPF.length() != 11))
			return (false);
		char dig10, dig11;
		int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo
		// (int)
		try {

			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {

				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);

			// converte no respectivo caractere numerico
			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;

			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);

			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos
			// informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else
				return (false);

		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	public static String imprimeCPF(String CPF) {
		return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "."
				+ CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
	}

	public static boolean isEmail(String email)  
    {  
        boolean isEmailIdValid = false;  
        if (email != null && email.length() > 0) {  
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";  
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);  
            Matcher matcher = pattern.matcher(email);  
            if (matcher.matches()) {  
                isEmailIdValid = true;  
            }  
        }  
        return isEmailIdValid;  
    } 
	
	public static void main(String[] args) {
		Validacao v = new Validacao();
		System.out.println(isCNPJ("02998301000181") ? "OK" : "Incorreto");

		Scanner ler = new Scanner(System.in);
		String CPF;
		System.out.printf("Informe um CPF: ");
		CPF = ler.next();
		System.out.printf("\nResultado: "); 
		
		// usando os metodos isCPF() e imprimeCPF() da classe "ValidaCPF"
		if (isCPF(CPF) == true)
			System.out.printf("%s\n", imprimeCPF(CPF));
		else
			System.out.printf("Erro, CPF invalido !!!\n");

	}

}
