package diadia3; 												

import java.util.Scanner;

public class Comando											//classe che modella un comando. Un comando ha un nome e un parametro su cui viene eseguito il comando
{
    private String nome="";										//dichiarazione variabile nome del comando
    private String parametro;									//dichiarazione variabile nome del parametro

    public Comando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);		//scanner di parole è il comando che legge dalla console
			
		if (scannerDiParole.hasNext())						
			this.nome = scannerDiParole.next(); 				//la prima parola letta è il nome del comando

		if (scannerDiParole.hasNext())
			this.parametro = scannerDiParole.next();			//la seconda parola, se presente, differenziata dalla prima tramite spazio, è il parametro
    }

    public String getNome() 									//funzione che restituisce il nome del comando
    {
        return this.nome;
    }						

    public String getParametro()								//funzione che restituisce il parametro del comando 
    {
        return this.parametro;
    }

    public boolean sconosciuto()								//NON SO COSA SIA FORSE SI PUò/DEVE TOGLIERE	
    {
        return (this.nome == null);
    }
}