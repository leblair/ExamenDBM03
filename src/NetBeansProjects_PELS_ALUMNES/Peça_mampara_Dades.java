package NetBeansProjects_PELS_ALUMNES;

import java.text.Collator;
import java.util.Locale;

public class Peça_mampara_Dades extends Peça_prototipus_Dades{
	private int peça_altura;
	private int peça_amplada;

	
	public Peça_mampara_Dades(String peça_ID, int peça_num_serie, String peça_nom, String fabricant_ID, boolean peça_reparable, boolean peça_trancada, int peça_altura, int peça_amplada) {
		super(peça_ID, peça_num_serie, peça_nom, fabricant_ID, peça_reparable, peça_trancada);
		this.peça_altura = peça_altura;
		this.peça_amplada = peça_amplada;
	}


	@Override
	protected boolean esReparable() {
		return isPeça_reparable();
	}


	public int getPeça_altura() {
		return peça_altura;
	}

	public void setPeça_altura(int peça_altura) {
		this.peça_altura = peça_altura;
	}

	public int getPeça_amplada() {
		return peça_amplada;
	}

	public void setPeça_amplada(int peça_amplada) {
		this.peça_amplada = peça_amplada;
	}

	
	


	@Override
	public String toString() {
		return super.toString() + ", altura: " + peça_altura + ", amplada: " + peça_amplada+ "\n";
	}


	@Override
	public int compareTo(Peça_prototipus_Dades o) {
		return 0;
	}
}
