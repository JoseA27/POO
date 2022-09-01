package caso.energia;

public class Motor {
	public boolean enable=false;
	
	public boolean isEnable() {
		return enable;
	}

	public float setEnable(boolean enable) {
		this.enable = enable;
		int vel = Constantes.NUDOS;
		return vel;
	}

}
