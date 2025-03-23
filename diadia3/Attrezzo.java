package diadia3; 

public class Attrezzo 						//classe che modella un attrezzo 
{
	private String nome;
	private int peso;

	public Attrezzo(String nome, int peso) 
	{
		this.nome = nome;					//dichiarazione variabile nome dell'attrezzo
		this.peso = peso;					//dichiarazione variabile peso dell'attrezzo
	}

	public String getNome() 				//funzione che restituisce il nome di un attrezzo
	{
		return this.nome;
	}

	public int getPeso() 					//funzione che restituisce il peso di un attrezzo
	{
		return this.peso;
	}

	public String toString() 				//funzione che restituisce una rappresentazione dell'attrezzo come stringa nome+peso+( kg)
	{
		return this.getNome()+" ("+this.getPeso()+"kg)";
	}
}