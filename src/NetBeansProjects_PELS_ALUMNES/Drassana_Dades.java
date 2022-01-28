package NetBeansProjects_PELS_ALUMNES;

import java.util.LinkedHashMap;
import java.util.LinkedList;



public class Drassana_Dades {
	public static final String nomDrassana = "MCRN Calisto "; 
	
	private LinkedList<Nau_Dades> llistaNausEnDrassana = new LinkedList<Nau_Dades>();		// Cua de tipus FIFO que suporti null's
	
	// La clau serà peça_ID. El valor serà la quantitat de peces que hi ha del propi model.
	private LinkedHashMap<String, Integer> mapaStockPeces = new LinkedHashMap<String, Integer>();
	
	// La clau serà peça_ID. El valor seran els objecte de tipus Peça_electronica_Dades i es diferenciaran pel peça_num_serie.
	private LinkedHashMap<String, LinkedList<Peça_electronica_Dades>> mapaPecesElectronica = new LinkedHashMap<String, LinkedList<Peça_electronica_Dades>>();
	
	// La clau serà peça_ID. El valor seran els objecte de tipus Peça_mampara_Dades i es diferenciaran pel peça_num_serie.
	private LinkedHashMap<String, LinkedList<Peça_mampara_Dades>> mapaPecesMampares = new LinkedHashMap<String, LinkedList<Peça_mampara_Dades>>();

	
	
	public LinkedList<Nau_Dades> getLlistaNausEnDrassana() {
		return llistaNausEnDrassana;
	}

	public void setLlistaNausEnDrassana(LinkedList<Nau_Dades> llistaNausEnDrassana) {
		this.llistaNausEnDrassana = llistaNausEnDrassana;
	}

	public LinkedHashMap<String, Integer> getMapaStockPeces() {
		return mapaStockPeces;
	}

	public void setMapaStockPeces(LinkedHashMap<String, Integer> mapaStockPeces) {
		this.mapaStockPeces = mapaStockPeces;
	}

	public LinkedHashMap<String, LinkedList<Peça_electronica_Dades>> getMapaPecesElectronica() {
		return mapaPecesElectronica;
	}

	public void setMapaPecesElectronica(LinkedHashMap<String, LinkedList<Peça_electronica_Dades>> mapaPecesElectronica) {
		this.mapaPecesElectronica = mapaPecesElectronica;
	}

	public LinkedHashMap<String, LinkedList<Peça_mampara_Dades>> getMapaPecesMampares() {
		return mapaPecesMampares;
	}

	public void setMapaPecesMampares(LinkedHashMap<String, LinkedList<Peça_mampara_Dades>> mapaPecesMampares) {
		this.mapaPecesMampares = mapaPecesMampares;
	}
	
	
	

}
