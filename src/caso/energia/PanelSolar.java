package caso.energia;

public class PanelSolar {
	private boolean enabled;
	private int EnergiaSolar;
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public float absorber() {
		return Constantes.ENERGIA_SOL;
		
	}
	
}
