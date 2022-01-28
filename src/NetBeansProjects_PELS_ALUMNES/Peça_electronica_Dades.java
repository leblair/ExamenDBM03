package NetBeansProjects_PELS_ALUMNES;

import java.text.Collator;
import java.util.Locale;

public class Peça_electronica_Dades extends Peça_prototipus_Dades{
	private int peça_consumEnergetic;
	private String peça_consumEnergetic_Unitat_de_mesura;

	
	public Peça_electronica_Dades(String peça_ID, int peça_num_serie, String peça_nom, String fabricant_ID, boolean peça_reparable, 
			boolean peça_trancada, int peça_consumEnergetic, String peça_consumEnergetic_Unitat_de_mesura) {
		
		super(peça_ID, peça_num_serie, peça_nom, fabricant_ID, peça_reparable, peça_trancada);
		this.peça_consumEnergetic = peça_consumEnergetic;
		this.peça_consumEnergetic_Unitat_de_mesura = peça_consumEnergetic_Unitat_de_mesura;
	}


	@Override
	protected boolean esReparable() {
		return isPeça_reparable();
	}


	public int getPeça_consumEnergetic() {
		return peça_consumEnergetic;
	}

	public void setPeça_consumEnergetic(int peça_consumEnergetic) {
		this.peça_consumEnergetic = peça_consumEnergetic;
	}

	public String getPeça_consumEnergetic_Unitat_de_mesura() {
		return peça_consumEnergetic_Unitat_de_mesura;
	}

	public void setPeça_consumEnergetic_Unitat_de_mesura(String peça_consumEnergetic_Unitat_de_mesura) {
		this.peça_consumEnergetic_Unitat_de_mesura = peça_consumEnergetic_Unitat_de_mesura;
	}

	
	
	

	


	@Override
	public String toString() {
		return super.toString() + ", consum energetic: " + peça_consumEnergetic + " " + peça_consumEnergetic_Unitat_de_mesura + "\n";
	}


	


	@Override
	public int hashCode() {
		return this.getPeça_ID().hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Peça_electronica_Dades other = (Peça_electronica_Dades) obj;
		if (this.getPeça_num_serie() != other.getPeça_num_serie())
			return false;
		return true;
	}


	@Override
	public int compareTo(Peça_prototipus_Dades o) {
		return 0;
	}
}
