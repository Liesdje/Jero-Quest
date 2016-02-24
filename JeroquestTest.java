
/**
 * Prácticas de Metodología de la Programación.
 * Jeroquest - Un ejemplo de Programación orientada a objetos.
 * Programa principal 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 * @version 1
 *
 */

public class JeroquestTest {

	public static void main(String[] args) {
		
		Momia ramses = new Momia("Ramses");
		Barbaro conan = new Barbaro("Conan");
		
		System.out.println(ramses);
		System.out.println(conan);
		
		// conan ataca a ramses
		int impactos = conan.atacar();
		ramses.defender(impactos);
		
		// si los dos están vivos se realiza un ataque
		while(ramses.estaVivo() && conan.estaVivo())
			conan.defender(ramses.atacar());
			
		System.out.println(ramses);
		System.out.println(conan);
		
		
		Momia[] v_momias=new Momia[10];
		Barbaro[] v_barbaros=new Barbaro[10];
		//Creamos los vectors de momias y barabaos
		for(int i=0;i<5;i++)
		{
			v_momias[i]= new Momia("Ramses"+i);
			v_barbaros[i]= new Barbaro("Conan"+i);
		}
		
		int turnos =10;
		//Realizamos los ataques
		//7.1.d
//		for(int i=0;i<turnos && !todosmuertos(v_momias,v_barbaros);i++)
//		{
//			//si están vivos
//			if(v_momias[i].estaVivo())
//				v_momias[i].defender(v_barbaros[Dado.tira(5)].atacar());
//			if(v_barbaros[i].estaVivo())
//				v_barbaros[i].defender(v_momias[Dado.tira(5)].atacar());
//			
//		}
		//7.1.e ataque siendo simepre al que mas vida tiene
		for(int i=0;i<turnos && !Personaje.todosmuertos(v_barbaros) && !Personaje.todosmuertos(v_momias);i++)
		{
			for(int j=0;j<v_barbaros.length ;j++)
			{
				v_momias[Personaje.masvida(v_momias)].defender(v_barbaros[j].atacar());
				v_barbaros[Personaje.masvida(v_barbaros)].defender(v_momias[j].atacar());
			}
		}
		Personaje.ordenaPersonajes(v_barbaros);
		Personaje.ordenaPersonajes(v_momias);
		for(int j=0;j<v_barbaros.length;j++)
		{
			System.out.println(v_barbaros);
			System.out.println(v_momias);
		}
			
	}
}
