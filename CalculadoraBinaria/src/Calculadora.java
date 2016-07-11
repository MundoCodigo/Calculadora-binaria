import java.util.Scanner;

public class Calculadora {

	
	public String resolverOperacion(String operando, String numeroUno, String numeroDos){
		String  resultado = "";
		
		if(numeroUno.length() < numeroDos.length() ){
			String temp = numeroDos.substring(0 , numeroDos.length()-numeroUno.length());
			temp 		= temp.replace('1','0');
			numeroUno = temp = temp+numeroUno;
		}else{
			String temp = numeroUno.substring(0 , numeroUno.length()-numeroDos.length());
			temp 		= temp.replace('1','0');
			numeroDos 	= temp = temp+numeroDos;	
		}
		if(operando.equals("+")){
			resultado = sumarNumerosBinarios(numeroUno, numeroDos);
		}else if(operando.equals("-")){
			resultado = restarNumerosBinarios(numeroUno, numeroDos);
			if(resultado .charAt(0)=='-')
				resultado = complementoADos(resultado);	
		}
		return resultado;
	}
	
	public String sumarNumerosBinarios(String numeroUno, String numeroDos){
		String resultado = "";
		char acarreo = '0';
		for(int i = numeroUno.length()-1; i>= 0; i--){
			if(numeroUno.charAt(i) == '0' && numeroDos.charAt(i) == '0' ){
				if(acarreo == '0'){
					resultado = "0"+resultado;
				}else {
					resultado = "1"+resultado;
				}
			}else if((numeroUno.charAt(i) == '0' && numeroDos.charAt(i) == '1' )||
					 (numeroUno.charAt(i) == '1' && numeroDos.charAt(i) == '0')){
				if(acarreo == '0'){
					resultado = "1"+resultado;
				}else {
					acarreo = '1';
					resultado = "0"+resultado;
				}
			}else if((numeroUno.charAt(i) == '1' && numeroDos.charAt(i) == '1' )){
				if(acarreo == '0'){
					acarreo = '1';
					resultado = "0"+resultado;
				}else {
					resultado = "1"+resultado;
				}
			}
		}
		if(acarreo =='1'){
			resultado = acarreo + resultado;
		}
		return resultado;
	}
	
	public String restarNumerosBinarios(String numeroUno, String numeroDos){
		String resultado = "";
		char debo = '0';
		
		for(int i = numeroUno.length()-1; i>= 0; i--){
			if((numeroUno.charAt(i) == '0' && debo == '0') || 
			   (numeroUno.charAt(i) == '1' && debo == '1')){
				if(numeroDos.charAt(i) =='0'){
					debo = '0';
					resultado = "0"+resultado;
				}else {
					debo = '1';
					resultado = "1"+resultado;
				}
			}else if(numeroUno.charAt(i) == '1' && debo == '0' ){
				debo = '0';
				if(numeroDos.charAt(i) =='0'){
					resultado = "1"+resultado;
				}else {
					resultado = "0"+resultado;
				}
			}else if(numeroUno.charAt(i) == '0' && debo == '1' ){
				debo = '1';
				if(numeroDos.charAt(i) =='0'){
					resultado = "1"+resultado;
				}else {
					resultado = "0"+resultado;
				}
			}
		}
		if(debo == '1')
			resultado = "-"+resultado;
		return resultado;		
	}
	public String complementoADos(String numero){
		int indice = numero.length();
		String nuevo = "";
		for(int i = numero.length()-1; i>= 0; i--){
			if(numero.charAt(i)=='1'){
				nuevo =  numero.charAt(i)+nuevo;
				indice = i-1;
				break;
			}
			nuevo =  numero.charAt(i)+nuevo;
		}
		for(int i = indice; i>= 0; i--){
			if(numero.charAt(i)=='1'){
				nuevo =  '0'+nuevo;
			}else if(numero.charAt(i)=='0'){
				nuevo =  '1'+nuevo;
			}else{
				nuevo =  numero.charAt(i)+nuevo;		
			}
		}
		return nuevo;
	}

	
	
	
	public static void main(String[] args) {
		Calculadora calculadora = new Calculadora();
		Scanner in = new Scanner (System.in);
		while(in.hasNextLine()){
			String numeroUno = in.nextLine();
			String operando	 = in.nextLine();
			String numeroDos = in.nextLine();
			System.out.println(calculadora.resolverOperacion(operando, numeroUno, numeroDos));
		}
	}

}
