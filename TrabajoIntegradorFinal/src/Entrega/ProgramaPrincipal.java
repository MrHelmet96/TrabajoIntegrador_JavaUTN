package Entrega;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		
		ArrayList<Partido> listaPartidos=new ArrayList<Partido>();
		
		Partido unPartido;
		
		Equipo unEquipo1;
		Equipo unEquipo2;
		
		String archivo = "archivos\\resultados.txt";
		for (String linea : Files.readAllLines(Paths.get(archivo))) {
		String lineas[]=linea.split(" ");
		
		unPartido=new Partido();
		unEquipo1=new Equipo();
		unEquipo2=new Equipo();
		
			unEquipo1.nombre=lineas[0];
			unEquipo2.nombre=lineas[3];
		unPartido.equipo1=unEquipo1;
		unPartido.equipo2=unEquipo2;
		unPartido.golesEquipo1=Integer.parseInt(lineas[1]);
		unPartido.golesEquipo2=Integer.parseInt(lineas[2]);
		listaPartidos.add(unPartido);
	}
		
		for(int i=0;i<listaPartidos.size();i++) {
		JOptionPane.showMessageDiaglog(null,listaPartidos.get(i).equipo.nombre+" "+listaPartidos.get(i).golesEquipo1)+" "listaPartidos.get(i).golesEquipo2+" "+listaPartidos.get(i).equipo2.nombre);
		}
		
	}

}
