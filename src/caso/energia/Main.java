package caso.energia;

public class Main {
	
	public static void main(String args[]) {
		AdminEnergia Main = new AdminEnergia();
		Main.generarBaterias();
		Main.cargarBaterias();
		Main.apagarBaterias();
		Main.consumirBaterias(100);
	}
}