package Entrega;

public class Equipo {
		private String nombre;
		private String descripcion;


		@Override
		public String toString() {
			return "Equipo [nombre=" + nombre + ", descripcion=" + descripcion + "]";
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		
		
}
