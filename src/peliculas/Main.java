package peliculas;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 
 * Programa que gestiona la administración de una productora de películas de cine. La
 * El programa almacena en un archivo llamado “películas.txt” toda la información de las
 * películas que produce.
 * 
 * 
 * @author unai
 * @version 1.0
 */

public class Main {
	
	private ArrayList <Pelicula> peliculas = new ArrayList<Pelicula>();
	/**
	 * Añade un objeto pelicula
	 * @param pelicula pelicula introducida por el usuario.
	 */
	public void altaPelicula(Pelicula pelicula) {
		peliculas.add(pelicula);
	}
	/**
	 * Elimina una pelicula elegida por el usuario dentro del array
	 * @param codigoPelicula codigo de pelicula introducido por el usuario para eliminar.
	 */
	public void darBaja(int codigoPelicula) {
		for(int i=0;i<peliculas.size();i++) {
			if(peliculas.get(i).getCodigoPelicula()==codigoPelicula) {
				peliculas.remove(i);
				break;
			}			
		}	
	}
	/**
	 * Saca un listado por pantalla de todas las peliculas dentro del array.
	 */
	public void mostrarListado() {
		for(int i=0;i<peliculas.size();i++) {
			System.out.println(peliculas.get(i).toString());
		}
	}
	/**
	 * Muestra la pelicula con el codigo de pelicula introducida por el usuario.
	 * @param codigoPelicula codigo de pelicula introducido por el usuario.
	 */
	public void mostrarPelicula(int codigoPelicula) {
		for(int i=0;i<peliculas.size();i++) {
			if(peliculas.get(i).getCodigoPelicula()==codigoPelicula) {
				System.out.println(peliculas.get(i).toString());
				break;
			}
			
		}
	}
	/**
	 * Lee el archivo por cada linea del archivo mete un array peliculas.
	 */
	public void cargarArchivo() {
		String separador = Pattern.quote("||");
		try {
			File archivo=new File("peliculas.txt");
			BufferedReader br = new BufferedReader(new FileReader("peliculas.txt"));
			try {
				String linea = br.readLine();
				while (linea!=null){
			
					
					String[] partes = linea.split(separador);
					Pelicula pelicula = new Pelicula(
							           new Integer(partes[0]).intValue(),
							           partes[1],
							           new Integer(partes[2]).intValue(),
							           partes[3],
							           new Integer(partes[4]).intValue()
							           );
					peliculas.add(pelicula);
					linea=br.readLine();
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Vuelca el array de peliculas en el fichero borrando el contenido anterior que existia.
	 */
	public void pasarArchivo() {
		try {
			File archivo=new File("peliculas.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter("peliculas.txt", false));
			for (int i=0;i<peliculas.size();i++) {
				bw.write(peliculas.get(i).toString());
				if (peliculas.size()-1!=i) {
					bw.newLine();
				}
			
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main productora = new Main();
		//
		productora.cargarArchivo();
		
		Scanner sc = new Scanner(System.in);
		Scanner sn = new Scanner(System.in);
		int opc=0;
		
		System.out.println("1)Alta de película.");
		System.out.println("2)Baja de película.");
		System.out.println("3)Consulta de todas las películas.");
		System.out.println("4)Consulta de dato de una película por cod_pelicula.");
		System.out.println("5)Salir.");
		
		do {
			opc=sn.nextInt();
			switch(opc) {
			
			
				case 1:
					System.out.print("Introduce el codigo de la pelicula: ");
					int codigoPelicula = sn.nextInt();
					System.out.print("Introduce el titulo de la pelicula: ");
					String titulo= sc.nextLine();
					System.out.print("Introduce el año de estreno de la pelicula: ");
					int añoEstreno= sn.nextInt();
					System.out.print("Introduce el protagonista de la pelicula: ");
					String protagonista= sc.nextLine();
					System.out.print("Introduce el coste de producción de la pelicula: ");
					int costeProduccion=sn.nextInt();
					
					productora.altaPelicula(new Pelicula(codigoPelicula,titulo,añoEstreno,protagonista,costeProduccion));
					break;
				case 2:
					System.out.print("Introduce el codigo de la pelicula que quieres dar de baja: ");
					codigoPelicula = sn.nextInt();
					productora.darBaja(codigoPelicula);
                    
					 break;
				case 3:
					productora.mostrarListado();
					 break;
				case 4:
					System.out.print("Introduce el codigo de la pelicula que quieres mostrar: ");
					codigoPelicula = sn.nextInt();
					productora.mostrarPelicula(codigoPelicula);
					 break;

				case 5:
					productora.pasarArchivo();
					break;
			}		
		}while(opc!=6);
		
		
	
	}
	
}
