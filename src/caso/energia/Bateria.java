package caso.energia;

import java.util.ArrayList;

public class Bateria extends Thread
{
	
	private boolean enabled=false;
	private float energyLevel=0;
	private String brand; 
	private ArrayList<PanelSolar>paneles;
	private PanelSolar panel;
	private static boolean charging = false;
	public static int BATTERY_CAPACITY = Constantes.CAPACIDAD_BATERIA;
	
	public Bateria() {
		paneles = new ArrayList<PanelSolar>();
	}
	public void conectarPanel(PanelSolar ppanel) {
		if (paneles==null) {
			this.panel = ppanel;
		}
		this.panel = ppanel;
		paneles.add(ppanel);
	}
	
	public void cargar() {
		if (this.panel!=null && this.panel.isEnabled()==true) {
		Bateria.charging=true;
			while(charging==true) {
				try {
					if (energyLevel<Constantes.CAPACIDAD_BATERIA) {
						Thread.sleep(1000); 
						this.energyLevel+=(panel.absorber()/100.0f)*paneles.size();
						System.out.println("Nivel actual de bateria "+energyLevel);
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} else {
			System.out.println("No puedo cargar la batería porque no hay un panel conectado");
		}
		}
	
	public void consumir(int uso) {
		if (this.energyLevel>0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.energyLevel=this.energyLevel-(uso/70.0f);
			System.out.println("Con la descarga el nivel la bateria es"+energyLevel);
		}else {
			System.out.println("Ya no queda más energía.");
		}
		
	}
	
	public float getEnergyLevel() {
		return energyLevel;
	}
	public void setEnergyLevel(float energyLevel) {
		this.energyLevel = energyLevel;
	}
	public PanelSolar getPanel() {
		return panel;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public void setCharging(boolean charging) {
		Bateria.charging = charging;
	}
	
}
