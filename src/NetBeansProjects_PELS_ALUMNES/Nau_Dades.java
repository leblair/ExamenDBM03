package NetBeansProjects_PELS_ALUMNES;

import java.text.Collator;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;


public class Nau_Dades implements Comparable<Nau_Dades>{
	private String nau_ID;
	private String nau_nom;
	private ArrayList<Peça_electronica_Dades> llistaPecesElectronica = new ArrayList<Peça_electronica_Dades>();
	private ArrayList<Peça_mampara_Dades> llistaPecesMampara = new ArrayList<Peça_mampara_Dades>();
	private int num_tripulants;
	private LocalDateTime data_fabricacio;
	
	

	public Nau_Dades(String nau_ID, String nau_nom, int num_tripulants, LocalDateTime data_fabricacio) {
		this.nau_ID = nau_ID;
		this.nau_nom = nau_nom;
		this.num_tripulants = num_tripulants;
		this.data_fabricacio = data_fabricacio;
	}


	public String getNau_ID() {
		return nau_ID;
	}

	public void setNau_ID(String nau_ID) {
		this.nau_ID = nau_ID;
	}

	public String getNau_nom() {
		return nau_nom;
	}

	public void setNau_nom(String nau_nom) {
		this.nau_nom = nau_nom;
	}

	public ArrayList<Peça_electronica_Dades> getLlistaPecesElectronica() {
		return llistaPecesElectronica;
	}

	public void setLlistaPecesElectronica(ArrayList<Peça_electronica_Dades> llistaPecesElectronica) {
		this.llistaPecesElectronica = llistaPecesElectronica;
	}

	public ArrayList<Peça_mampara_Dades> getLlistaPecesMampara() {
		return llistaPecesMampara;
	}

	public void setLlistaPecesMampara(ArrayList<Peça_mampara_Dades> llistaPecesMampara) {
		this.llistaPecesMampara = llistaPecesMampara;
	}


	public int getNum_tripulants() {
		return num_tripulants;
	}


	public void setNum_tripulants(int num_tripulants) {
		this.num_tripulants = num_tripulants;
	}


	public LocalDateTime getData_fabricacio() {
		return data_fabricacio;
	}


	public void setData_fabricacio(LocalDateTime data_fabricacio) {
		this.data_fabricacio = data_fabricacio;
	}



	@Override
	public String toString() {
		StringBuilder dades = new StringBuilder("");
		
		dades.append("ID: " + nau_ID);
		dades.append(System.getProperty("line.separator"));
		dades.append("NOM: " + nau_nom);
		dades.append(System.getProperty("line.separator"));
		
		dades.append("PECES D'ELECTRÒNICA: ");
		dades.append(System.getProperty("line.separator"));
		for (Peça_electronica_Dades peçaElecTmp : this.getLlistaPecesElectronica()) {
			dades.append("    " + peçaElecTmp);
			dades.append(System.getProperty("line.separator"));
		}
		
		dades.append("MAMPARES: ");
		dades.append(System.getProperty("line.separator"));
		for (Peça_mampara_Dades peçaMampTmp : this.getLlistaPecesMampara()) {
			dades.append("    " + peçaMampTmp);
			dades.append(System.getProperty("line.separator"));
		}
		
		dades.append("Nº DE TRIPULANTS: " + num_tripulants);
		dades.append(System.getProperty("line.separator"));
		dades.append("DATA DE CONSTRUCCIÓ: " + data_fabricacio);
		dades.append(System.getProperty("line.separator"));
		
		return dades.toString();
	}

	@Override
	public int compareTo(Nau_Dades o) {
		Collator comparador = Collator.getInstance(new Locale("es"));
		comparador.setStrength(Collator.PRIMARY);

		return comparador.compare(this.getNau_nom(), o.getNau_nom());
	}
	
	
	
	
	
}
