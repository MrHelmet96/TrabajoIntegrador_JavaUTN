package Entrega;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import Entrega.Equipo;
import Entrega.Partido;
import Entrega.Pronostico;

public class ProgramaPrincipal {
		
		public static void main(String[] args) throws IOException {
			
			
			ArrayList<Partido> partidos = new ArrayList<Partido>();
			String archivo = "../TPIntegrador/src/Archivos/resultados.txt";
			
			// Leer archivo de partidos
			for (String linea: Files.readAllLines(Paths.get(archivo)) ) {
				
				 // Lógica para procesar el contenido del archivo
				String palabra[] = linea.split("\\s+"); // indica que se deben ignorar uno o más espacios en blanco consecutivos como separadores de palabras
				Equipo equipo1 = new Equipo(), equipo2 = new Equipo();
				int goles1, goles2;	
				
				equipo1.setNombre(palabra[0].replace("_", " ")); // Reemplazamos "_" por espacio en blanco
				goles1= Integer. parseInt(palabra[1]);
				goles2= Integer. parseInt(palabra[2]);
				equipo2.setNombre(palabra[3].replace("_", " ")); 
				Partido partido= new Partido(equipo1,goles1,goles2,equipo2);
				partidos.add(partido);
				
					
			}
			archivo="../TPIntegrador/src/Archivos/pronostico.txt";
			ArrayList<Pronostico> pronosticos = new ArrayList<Pronostico>();
			
			// Leer archivo de pronosticos
			for (String linea: Files.readAllLines(Paths.get(archivo)) ) {
				
				 // Lógica para procesar el contenido del archivo
				String palabra[] = linea.split("\\s+"); // indica que se deben ignorar uno o más espacios en blanco consecutivos como separadores de palabras
				int gana1, gana2, empate;
				Equipo equipo1 = new Equipo(), equipo2 = new Equipo();
				equipo1.setNombre(palabra[0].replace("_", " ")); // Reemplazamos "_" por espacio en blanco
				gana1= Integer. parseInt(palabra[1]);
				empate=Integer. parseInt(palabra[2]);
				gana2= Integer. parseInt(palabra[3]);
				equipo2.setNombre(palabra[4].replace("_", " "));
				Pronostico pronostico= new Pronostico(equipo1,gana1,empate,gana2,equipo2);
				pronosticos.add(pronostico);
				
				
			}
			
			System.out.println("Puntaje del Usuario");
			System.out.println("--------------------------------------------");
			int puntos = calcularPuntaje(partidos, pronosticos);
			System.out.println("--------------------------------------------");
			System.out.println("Puntaje: " + puntos);

		
				
			}
		
		
		// Método para calcular el puntaje
		private static int calcularPuntaje(ArrayList<Partido> partidos, ArrayList<Pronostico> pronosticos) {

			int puntaje=0;
			System.out.println(String.format("-%20s -%20s","Resultado", "Pronostico"));
			System.out.println("--------------------------------------------");
			for (int i=0; i< partidos.size(); i++) {
				 Partido unPartido = partidos.get(i);
				 Equipo equipoGanador = null;
				 if (unPartido.getGolesEquipo1() > unPartido.getGolesEquipo2()) {
					 equipoGanador= unPartido.getEquipo1();
				 }
			
				 if(unPartido.getGolesEquipo1()< unPartido.getGolesEquipo2()) {
						 equipoGanador= unPartido.getEquipo2();
					 }
				 
				 
				 Equipo equipoMarcado = null;
				 Pronostico unResultado= pronosticos.get(i);
				 if (unResultado.getGana1() == 1) {
					 equipoMarcado= unResultado.getEquipo1();
				 }
				 
				 if (unResultado.getGana2() == 1) {
					 equipoMarcado= unResultado.getEquipo2();
				 }
				 
				 
				if (equipoGanador != null && equipoMarcado != null) {
					if(equipoGanador.getNombre().equals(equipoMarcado.getNombre())) {
						puntaje = puntaje + 1;
					}
					System.out.println(String.format("-%20s -%20s",equipoGanador.getNombre() , equipoMarcado.getNombre()));
				}
				else {
						if(equipoGanador == null && equipoMarcado == null) {
						puntaje = puntaje + 1;
						System.out.println(String.format("-%20s -%20s","Empate","Empate"));
						}
						else {
							if(equipoGanador == null) {
								System.out.println(String.format("-%20s -%20s","Empate" , equipoMarcado.getNombre()));
							}
							if(equipoMarcado == null) {
								System.out.println(String.format("-%20s -%20s",equipoGanador.getNombre() ,"Empate"));
							}
							
						}
						
						
						
					}
				
				
				
				
					
				 }
				
			
			
			
				return puntaje;
			
		}

	}
