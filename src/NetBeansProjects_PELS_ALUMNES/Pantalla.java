/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NetBeansProjects_PELS_ALUMNES;

import java.util.Scanner;

import NetBeansProjects_PELS_ALUMNES.Llibreries.Varies.IKSRotarranConstants;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;



/**
 *
 * @author gmartinez
 */
public class Pantalla {
	
	public static void bloquejarPantalla(Scanner sc) {
        System.out.println();
        System.out.print("Toca 'C' per a continuar ");
        while (sc.hasNext()) {
            if ("C".equalsIgnoreCase(sc.next())) break;
        }
        System.out.println();
        System.out.println();
    }
    

	public static void main(String[] args) {
		String opcio;
        Scanner sc = new Scanner(System.in);
        StringBuilder menu = new StringBuilder("");
        
        Drassana_Dades drassana_MCRN = new Drassana_Dades();

        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        // D'aquesta manera s'updateja els objectes <Nau_Dades>, <Peça_electronica_Dades> i <Peça_mampara_Dades> que hi ha dins de Drassana_Dades:
        config.common().objectClass(Drassana_Dades.class).cascadeOnUpdate(true);		
        ObjectContainer db = Db4oEmbedded.openFile(config, IKSRotarranConstants.pathBD);

        do {
        	menu.delete(0, menu.length());
            
            menu.append(System.getProperty("line.separator"));
            menu.append(Drassana_Dades.nomDrassana);
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator")); 
            
            menu.append("1. Inicialitzar naus");
            menu.append(System.getProperty("line.separator"));
            menu.append("2. Inicialitzar drassana");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("10. Drassana: veure les naus que hi ha en la drassana ordenades");
            menu.append(System.getProperty("line.separator"));
            menu.append("11. Drassana: veure stock de peces trencades d'una nau");
            menu.append(System.getProperty("line.separator"));
            menu.append("12. Drassana: veure tots els radars i la seva localització");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("20. Drassana: reparar els radars trencats de les naus i la drassana");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            
            menu.append("50. Tornar al menú pare (PNS-24 Puma)");
            menu.append(System.getProperty("line.separator"));
            
            
            System.out.print(MenuConstructorPantalla.constructorPantalla(menu));
            
            opcio = sc.next();

            switch (opcio) {
	            case "1":
	            	Drassana.inicialitzarNaus(drassana_MCRN, db);
	            	System.out.println();
	            	Drassana.inicialitzarPecesNaus(drassana_MCRN, db);
	            	System.out.println();
	            	
	                bloquejarPantalla(sc);
	                break;  
	                
	            case "2":
                	Drassana.inicialitzarPecesDrassana(drassana_MCRN, db);
                	
                    bloquejarPantalla(sc);
                    break;	                
	                
                case "10":
                	System.out.println();
                	Drassana.veureDadesDeLesNausEnDrassanaOrdenades(drassana_MCRN, db);
                    
                	bloquejarPantalla(sc);
                    break;
                    
                case "11":
                	Drassana.veureStockPecesElectroniquesTrencadesDUnaNau(drassana_MCRN, db);
                    
                	bloquejarPantalla(sc);
                    break;
                    
                case "12":
                    Drassana.veureTotsElsRadarsILaSevaLocalitzacio(drassana_MCRN, db);
                	
                	bloquejarPantalla(sc);
                    break;
                    
                case "20":
                	Drassana.repararTotsElsRadarsTrencats(drassana_MCRN, db);
                    
                	bloquejarPantalla(sc);
                    break;
                 
                case "50":
                	db.close();
                    break; 
                    
                default:
                    System.out.println("ERROR: COMANDA NO RECONEGUDA");
                    System.out.println();
            }   

        } while (!opcio.equals("50"));
    }    
}
