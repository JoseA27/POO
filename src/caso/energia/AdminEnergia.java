package caso.energia;

import java.util.ArrayList;

public class AdminEnergia extends Thread{
	private float cantBat= Constantes.CANT_BATERIAS;
	private float cantPan= Constantes.CANT_PANELS;
	private ArrayList<Bateria> baterias;
	private Motor motor;
	
	public AdminEnergia() {
		baterias = new ArrayList<Bateria>();
		Motor motor = new Motor();
		this.motor=motor;
	}
	
	public void generarBaterias(){
		for (int i=0; i<cantBat; i++) {
			Bateria pbateria = new Bateria();
			for (int n=0; n<cantPan; n++) {
				PanelSolar pPanel = new PanelSolar();
				pPanel.setEnabled(true);
				pbateria.conectarPanel(pPanel);
			}
			this.baterias.add(pbateria);
			
		}
	}
	public void cargarBaterias() {
		for (int n=0; n<baterias.size(); n++ ) {
			(baterias.get(n)).setEnabled(true);
			(baterias.get(n)).setCharging(true);
			(baterias.get(n)).cargar();
		}
	}
	public void consumirBaterias(int uso) {
		for (int x=0; x<baterias.size(); x++ ) {
			while ((baterias.get(x)).getEnergyLevel()>0) {
					(baterias.get(x)).consumir(uso);
			}
		}
	}
	public void apagarBaterias() {
		for (int n=0; n<baterias.size(); n++ ) {
			(baterias.get(n)).setCharging(false);
		}
	}
	public void aumentarVelocidad() {
	}
}
