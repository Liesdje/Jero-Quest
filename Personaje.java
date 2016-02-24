/**
 * Prácticas de Metodología de la Programación.
 * Jeroquest - Un ejemplo de Programación orientada a objetos.
 * Clase Personaje 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 * @version 1
 * 
 */

public abstract class Personaje {
	// atributos actuales del personaje
	protected int mueve; // unidades de movimiento por turno
	protected int ataque; // total dados de ataque
	protected int defensa; // total dados de defensa
	protected int cuerpo; // puntos  de vida
	protected String nombre; // nombre del personaje

	
/**
 * Crea un personaje a partir de su nombre,
 * inicialmente su posición es nula (fuera del tablero)
 * @param suNombre nombre del personaje
 */

	/**
	 * Crea un personaje a partir de su nombre y sus atributos iniciales
	 * @param suNombre el nombre
	 * @param suMovimiento numero de casillas que mueve por turno
	 * @param suAtaque numero de dados a lanzar en un ataque
	 * @param suDefensa numero de dados a lanzar al defenderse
	 * @param suCuerpo puntos de vida iniciales
	 */
	public Personaje(String suNombre, int suMovimiento, int suAtaque, int suDefensa,int suCuerpo) {
		nombre = suNombre;
		mueve = suMovimiento;
		ataque = suAtaque;
		defensa = suDefensa;
		cuerpo = suCuerpo;

}

	/**
	 * Obtén las unidades de movimiento por turno
	 * (observador)
	 * @return unidades de movimiento del personaje
	 */
	public int getMueve() {
		return mueve;
	}

	/**
	 * Obtén los dados de ataque
	 * @return dados de ataque del personaje
	 */
	public int getAtaque() {
		return ataque;
	}

	/**
	 * Obtén los dados de defensa
	 * @return dados de defensa del personaje
	 */
	public int getDefensa() {
		return defensa;
	}

	/** 
	 * Obtén los puntos de vida 
	 * @return puntos de vida del personaje
	 */
	public int getCuerpo() {
		return cuerpo;
	}

	/**
	 * Obtén el nombre 
	 * @return el nombre del personaje 
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Comprueba si al personaje le queda algún punto de vida
	 * @return cierto si está vivo, falso en otro caso
	 */
	public boolean estaVivo() {
		return cuerpo > 0;
	}

	/** 
	 * Calcula un ataque del personaje calculando el número de impactos,
	 * para ello tira tantos dados como su propiedad ataque indique
	 * @return el número de impactos del personaje
	 */
	public int atacar() {
		int impactos = 0;
		for (int x = 0; x < ataque; x++)
			if (Dado.tira() > 3)
				impactos++;
		return impactos;
	}

	/** 
	 * El personaje se defiende de un ataque
	 * (método abstracto: cada subclase definirá su comportamiento propio)
	 * @param impactos el total de impactos que tiene que intentar detener o sufrir
	 * @return el numero de heridas sufridas
	 */
	public abstract int defender(int impactos);
	/**
	 * 
	 * @param v_personajes
	 * @return si estan todos muertos retorna verdadero
	 */
	public static boolean todosmuertos(Personaje[] v_personajes)
	{
		boolean muertos=true;
		
		for(int i=0;i<v_personajes.length;i++)
		{
			if(v_personajes[i].estaVivo())
				muertos=false;
		}
		return muertos;
	}
	/**
	 * 
	 * @param v_personajes
	 * @return indice del personaj con mas vida
	 */
	public static int masvida(Personaje[] v_personajes)
	{
		int vida=0,indice=0;
		for(int i=0;i<v_personajes.length;i++)
		{
			if(v_personajes[i].getCuerpo()>vida)
			{
				vida=v_personajes[i].getCuerpo();
				indice=i;
			}
		}
		return indice;
		
	}
	
	public static void ordenaPersonajes(Personaje[] v_personajes)
	{
		Personaje aux;
		for(int i=0;i<v_personajes.length-1;i++)
		{
			for(int j=i+1;j<v_personajes.length;j++)
			{
				if(v_personajes[j].getCuerpo()> v_personajes[i].getCuerpo())
				{
					aux= v_personajes[i];
					v_personajes[i]=v_personajes[j];
					v_personajes[i]=aux;
				}
			}
		}
	}
	/** 
	 * Genera la versión String imprimible del objeto
	 *  (Método reescrito)
	 * @return La versión como String imprimible del personaje 
	 */
	@Override
	public String toString() {
		return String
				.format("%s (mueve:%d ataque:%d defensa:%d cuerpo:%d)",
						getNombre(), getMueve(), getAtaque(), getDefensa(),
						getCuerpo());
	}

}
