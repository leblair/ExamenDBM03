package NetBeansProjects_PELS_ALUMNES;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.Map.Entry;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;


public class Drassana {

    //1. Inicialitzar naus (part I)
    public static void inicialitzarNaus(Drassana_Dades drassana_MCRN, ObjectContainer db) {
        // La següent línia peta perquè les 2 llistes estan apuntant a un null i per tant ja no existeixen.
        //Nau_Dades Donnager = new Nau_Dades("MCRN 101", "Donnager", null, null);
        LocalDate dataTmp;
        LocalTime tempsTmp;
        LocalDateTime dataCompletaTmp;


        dataTmp = LocalDate.of(2101, 1, 1);
        tempsTmp = LocalTime.now();
        dataCompletaTmp = LocalDateTime.of(dataTmp, tempsTmp);
        Nau_Dades Donnager = new Nau_Dades("mcrn 101", "Donnager", 11, dataCompletaTmp);

        dataTmp = LocalDate.of(2102, 2, 2);
        tempsTmp = LocalTime.now();
        dataCompletaTmp = LocalDateTime.of(dataTmp, tempsTmp);
        Nau_Dades Pella = new Nau_Dades("mcrn 202", "Pella", 22, dataCompletaTmp);

        dataTmp = LocalDate.of(2103, 3, 3);
        tempsTmp = LocalTime.now();
        dataCompletaTmp = LocalDateTime.of(dataTmp, tempsTmp);
        Nau_Dades Carcassonne = new Nau_Dades("mcrn 303", "Carcassonne", 33, dataCompletaTmp);

        System.out.println("LocalDateTime.now() = " + LocalDateTime.now());

        drassana_MCRN.getLlistaNausEnDrassana().clear();
        drassana_MCRN.getLlistaNausEnDrassana().add(Donnager);
        drassana_MCRN.getLlistaNausEnDrassana().add(Pella);
        drassana_MCRN.getLlistaNausEnDrassana().add(0, Carcassonne);

        for (Nau_Dades nauTmp : drassana_MCRN.getLlistaNausEnDrassana()) {
            System.out.println("Drassana " + Drassana_Dades.nomDrassana + ": AFEGIDA LA NAU " + nauTmp.getNau_nom() + " AMB ID " + nauTmp.getNau_ID() + ".");
        }
    }


    //1. Inicialitzar naus (part II)
    public static void inicialitzarPecesNaus(Drassana_Dades drassana_MCRN, ObjectContainer db) {
        // Les peces les estan fent servir i si s'espatllen a llavors la nau ha d'anar a la drassana per substituir-les.
        // Creem les peces electròniques i mampares que aniran en les naus (hi haurà 3 naus):
        Peça_electronica_Dades radar_000 = new Peça_electronica_Dades("Cyrano IV", 0, "radar monopulso Thomson-CSF Cyrano IV", "Thomson-CSF", true, true, 120, "kW");
        Peça_electronica_Dades radar_001 = new Peça_electronica_Dades("Cyrano IV", 1, "radar monopulso Thomson-CSF Cyrano IV", "Thomson-CSF", false, true, 120, "kW");
        Peça_electronica_Dades radar_002 = new Peça_electronica_Dades("Cyrano IV", 2, "radar monopulso Thomson-CSF Cyrano IV", "Thomson-CSF", true, false, 120, "kW");

        ArrayList<Peça_electronica_Dades> llista_radars = new ArrayList<Peça_electronica_Dades>(Arrays.asList(radar_000, radar_001, radar_002));

        Peça_electronica_Dades visorIR_000 = new Peça_electronica_Dades("SAT SCM2400 Super Cyclone", 0, "cámara d'infrarojos SAT SCM2400 Super Cyclone", "Thomson-CSF", true, false, 5, "kW");
        Peça_electronica_Dades visorIR_001 = new Peça_electronica_Dades("SAT SCM2400 Super Cyclone", 1, "cámara d'infrarojos SAT SCM2400 Super Cyclone", "Thomson-CSF", true, true, 5, "kW");
        Peça_electronica_Dades visorIR_002 = new Peça_electronica_Dades("SAT SCM2400 Super Cyclone", 2, "cámara d'infrarojos SAT SCM2400 Super Cyclone", "Thomson-CSF", true, false, 5, "kW");

        ArrayList<Peça_electronica_Dades> llista_visorsIR = new ArrayList<Peça_electronica_Dades>(Arrays.asList(visorIR_000, visorIR_001, visorIR_002));

        Peça_mampara_Dades mampara5x5_000 = new Peça_mampara_Dades("mampara de 5x5", 0, "mampara de nanopartícules de grafit de 5 x 5 metres", "Dassault", true, false, 5, 5);
        Peça_mampara_Dades mampara5x5_001 = new Peça_mampara_Dades("mampara de 5x5", 1, "mampara de nanopartícules de grafit de 5 x 5 metres", "Dassault", true, true, 5, 5);
        Peça_mampara_Dades mampara5x5_002 = new Peça_mampara_Dades("mampara de 5x5", 2, "mampara de nanopartícules de grafit de 5 x 5 metres", "Dassault", true, false, 5, 5);

        ArrayList<Peça_mampara_Dades> llista_mampares = new ArrayList<Peça_mampara_Dades>(Arrays.asList(mampara5x5_000, mampara5x5_001, mampara5x5_002));

        // Assignem les peces a les naus:
        int i = 0;
        ListIterator<Nau_Dades> it_naus = drassana_MCRN.getLlistaNausEnDrassana().listIterator(drassana_MCRN.getLlistaNausEnDrassana().size());
        while (it_naus.hasPrevious()) {
            Nau_Dades nauTmp = it_naus.previous();

            Peça_electronica_Dades radarTmp = llista_radars.get(i);
            Peça_electronica_Dades visorIRTmp = llista_visorsIR.get(i);
            Peça_mampara_Dades mamparaTmp = llista_mampares.get(i);

            nauTmp.getLlistaPecesElectronica().add(radarTmp);
            nauTmp.getLlistaPecesElectronica().add(visorIRTmp);
            nauTmp.getLlistaPecesMampara().add(mamparaTmp);
            System.out.println("Nau " + nauTmp.getNau_nom() + " (ID " + nauTmp.getNau_ID() + "):");
            System.out.println("    AFEGIDES LES PECES ELECTRÓNIQUES:");
            System.out.println("        " + radarTmp.getPeça_nom() + " Nº SERIE " + radarTmp.getPeça_num_serie());
            System.out.println("        " + visorIRTmp.getPeça_nom() + " Nº SERIE " + visorIRTmp.getPeça_num_serie());
            System.out.println("    AFEGIDES LES PECES MAMPARES:");
            System.out.println("        " + mamparaTmp.getPeça_nom() + " Nº SERIE " + mamparaTmp.getPeça_num_serie());

            i++;
        }

        db.store(drassana_MCRN);
    }


    //2. Inicialitzar drassana
    public static void inicialitzarPecesDrassana(Drassana_Dades drassana_MCRN, ObjectContainer db) {
        // Creem i assignem les peces a la drassana (peces que es poden fer servir per a arreglar les naus).
        Peça_electronica_Dades radar_003 = new Peça_electronica_Dades("Cyrano IV", 3, "radar monopulso Thomson-CSF Cyrano IV", "Thomson-CSF", true, true, 120, "kW");
        Peça_electronica_Dades radar_004 = new Peça_electronica_Dades("Cyrano IV", 4, "radar monopulso Thomson-CSF Cyrano IV", "Thomson-CSF", false, true, 120, "kW");
        Peça_electronica_Dades radar_005 = new Peça_electronica_Dades("Cyrano IV", 5, "radar monopulso Thomson-CSF Cyrano IV", "Thomson-CSF", true, false, 120, "kW");
        Peça_electronica_Dades radar_006 = new Peça_electronica_Dades("Cyrano IV", 6, "radar monopulso Thomson-CSF Cyrano IV", "Thomson-CSF", true, false, 120, "kW");
        Peça_electronica_Dades radar_007 = new Peça_electronica_Dades("Cyrano IV", 7, "radar monopulso Thomson-CSF Cyrano IV", "Thomson-CSF", true, false, 120, "kW");

        drassana_MCRN.getMapaStockPeces().put("Cyrano IV", 5);
        drassana_MCRN.getMapaPecesElectronica().put("Cyrano IV", new LinkedList<Peça_electronica_Dades>(Arrays.asList(radar_003, radar_004, radar_005, radar_006, radar_007)));


        Peça_electronica_Dades radio_000 = new Peça_electronica_Dades("radio UHF/VHF", 0, "radio salto frecuencias UHF/VHF", "Thomson-CSF", true, false, 10, "kW");
        Peça_electronica_Dades radio_001 = new Peça_electronica_Dades("radio UHF/VHF", 1, "radio salto frecuencias UHF/VHF", "Thomson-CSF", true, false, 10, "kW");

        drassana_MCRN.getMapaStockPeces().put("radio UHF/VHF", 2);
        drassana_MCRN.getMapaPecesElectronica().put("radio UHF/VHF", new LinkedList<Peça_electronica_Dades>(Arrays.asList(radio_000, radio_001)));


        Peça_electronica_Dades visorIR_000 = new Peça_electronica_Dades("SAT SCM2400 Super Cyclone", 0, "cámara d'infrarojos SAT SCM2400 Super Cyclone", "Thomson-CSF", true, false, 5, "kW");
        Peça_electronica_Dades visorIR_001 = new Peça_electronica_Dades("SAT SCM2400 Super Cyclone", 1, "cámara d'infrarojos SAT SCM2400 Super Cyclone", "Thomson-CSF", true, false, 5, "kW");
        Peça_electronica_Dades visorIR_002 = new Peça_electronica_Dades("SAT SCM2400 Super Cyclone", 2, "cámara d'infrarojos SAT SCM2400 Super Cyclone", "Thomson-CSF", true, false, 5, "kW");

        drassana_MCRN.getMapaStockPeces().put("SAT SCM2400 Super Cyclone", 3);
        drassana_MCRN.getMapaPecesElectronica().put("SAT SCM2400 Super Cyclone", new LinkedList<Peça_electronica_Dades>(Arrays.asList(visorIR_000, visorIR_001, visorIR_002)));


        Peça_mampara_Dades mampara5x5_000 = new Peça_mampara_Dades("mampara de 5x5", 0, "mampara de nanopartícules de grafit de 5 x 5 metres", "Dassault", true, false, 5, 5);
        Peça_mampara_Dades mampara5x5_001 = new Peça_mampara_Dades("mampara de 5x5", 1, "mampara de nanopartícules de grafit de 5 x 5 metres", "Dassault", true, false, 5, 5);

        drassana_MCRN.getMapaStockPeces().put("mampara de 5x5", 2);
        drassana_MCRN.getMapaPecesMampares().put("mampara de 5x5", new LinkedList<Peça_mampara_Dades>(Arrays.asList(mampara5x5_000, mampara5x5_001)));

        // MOSTRAR LES QUANTITATS DE PECES PER PANTALLA --> SEL·LECCIONAR 1 --> MOSTRAR LES DADES DELS OBJECTES (DE LES PECES).
        System.out.println("Drassana " + Drassana_Dades.nomDrassana + ": ");
        System.out.println("    AFEGIDES LES PECES ELECTRÓNIQUES:");
        for (Entry<String, LinkedList<Peça_electronica_Dades>> entradaMapaTmp : drassana_MCRN.getMapaPecesElectronica().entrySet()) {
            for (Peça_electronica_Dades peçaTmp : entradaMapaTmp.getValue()) {
                System.out.println("        " + peçaTmp.getPeça_ID() + " Nº SERIE " + peçaTmp.getPeça_num_serie());
            }
        }

        System.out.println("    AFEGIDES LES MAMPARES:");
        for (Entry<String, LinkedList<Peça_mampara_Dades>> entradaMapaTmp : drassana_MCRN.getMapaPecesMampares().entrySet()) {
            for (Peça_mampara_Dades peçaTmp : entradaMapaTmp.getValue()) {
                System.out.println("        " + peçaTmp.getPeça_ID() + " Nº SERIE " + peçaTmp.getPeça_num_serie());
            }
        }

        db.store(drassana_MCRN);
    }


    //10. Drassana: veure les naus que hi ha en la drassana ordenades
    public static void veureDadesDeLesNausEnDrassanaOrdenades(Drassana_Dades drassana_MCRN, ObjectContainer db) {
        Predicate predicate = new Predicate<Nau_Dades>() {
            @Override
            public boolean match(Nau_Dades o) {
                return drassana_MCRN.getLlistaNausEnDrassana().contains(o);
            }
        };

        List<Nau_Dades> nausEnDrassana = db.query(predicate);
        ArrayList<Nau_Dades> nausOrdenades = new ArrayList<>();
        nausOrdenades.addAll(nausEnDrassana);
        Collections.sort(nausOrdenades);
        for (Nau_Dades nau : nausOrdenades) {
            System.out.println("ID: " + nau.getNau_ID() +
                    "\nNOM: " + nau.getNau_nom() +
                    "\nPECES D'ELECTRONICA:\n" +
                    nau.getLlistaPecesElectronica().toString() +
                    "\nMAMPARES: " + nau.getLlistaPecesMampara() +
                    "N DE TRIPULANTS: " + nau.getNum_tripulants() +
                    "\nDATA DE CONSTRUCCIO: " + nau.getData_fabricacio());
        }
    }


    public static Nau_Dades seleccionarNauDeLaDrassana(Drassana_Dades drassana_MCRN, ObjectContainer db) {
        Scanner sc = new Scanner(System.in);
        Predicate predicate = new Predicate<Nau_Dades>() {
            @Override
            public boolean match(Nau_Dades o) {
                return drassana_MCRN.getLlistaNausEnDrassana().contains(o);
            }
        };
        List<Nau_Dades> nausEnDrassana = db.query(predicate);
        ArrayList<Nau_Dades> nausOrdenades = new ArrayList<>();
        nausOrdenades.addAll(nausEnDrassana);
        Collections.sort(nausOrdenades);
        int cont = 0;
        for (Nau_Dades nau : nausOrdenades) {
            System.out.println(cont + ". " + nau.getNau_nom());
            cont++;
        }
        System.out.println("SELECCIONI UNA NAU:");
        int option = sc.nextInt();
        return nausOrdenades.get(option);
    }

    //11. Drassana: veure stock de peces electròniques trencades d'una nau.
    public static void veureStockPecesElectroniquesTrencadesDUnaNau(Drassana_Dades drassana_MCRN, ObjectContainer db) {
        Nau_Dades selectedNave = seleccionarNauDeLaDrassana(drassana_MCRN, db);

        List<Peça_electronica_Dades> trencades = new ArrayList<>();

        Predicate navs = new Predicate<Nau_Dades>() {
            @Override
            public boolean match(Nau_Dades o) {
                if (o.getNau_nom().equals(selectedNave.getNau_nom())) {
                    return true;
                }
                return false;
            }
        };
        ObjectSet<Nau_Dades> naveSacada = db.query(navs);

        Nau_Dades tmp = naveSacada.next();
        if (tmp.getLlistaPecesElectronica().size() == 0) {
            System.out.println("AQUESTA NAU NO TE PECES");
        } else {
            for (Peça_electronica_Dades b : tmp.getLlistaPecesElectronica()) {
                if (b.isPeça_trencada()) {
                    trencades.add(b);
                }
            }

            if (trencades.size() == 0) {
                System.out.println("AQUESTA NAU NO TE PECES TRENCADES");
            } else {
                System.out.println("Id: " + tmp.getNau_ID());
                System.out.println("Nom: " + tmp.getNau_nom());
                System.out.println("Peces electronica: ");
                for (Peça_electronica_Dades b : trencades) {
                    System.out.println("\tPEÇA ID: " + b.getPeça_ID() + " (nº serie: " + b.getPeça_num_serie() + ")"
                            + ",nom: " + b.getPeça_nom()
                            + ", fabricant: " + b.getFabricant_ID()
                            + ", reparable? " + b.esReparable()
                            + ", trencada? " + b.isPeça_trencada()
                            + ", consum energetic: " + b.getPeça_consumEnergetic() + b.getPeça_consumEnergetic_Unitat_de_mesura());

                }
            }

        }


    }




    //12. Drassana: veure tots els radars i la seva localització.
    public static void veureTotsElsRadarsILaSevaLocalitzacio(Drassana_Dades drassana_MCRN, ObjectContainer db) {
        Predicate predicate = new Predicate<Peça_electronica_Dades>() {
            @Override
            public boolean match(Peça_electronica_Dades o) {
                return o.getPeça_ID().equals("Cyrano IV");
            }
        };
        List<Peça_electronica_Dades> radars = db.query(predicate);

        for (Peça_electronica_Dades radar : radars) {
            Predicate p1 = new Predicate<Nau_Dades>() {
                @Override
                public boolean match(Nau_Dades o) {

                    return o.getLlistaPecesElectronica().contains(radar);
                }
            };
            ObjectSet<Nau_Dades> nausRadar =db.query(p1);

            if (nausRadar.isEmpty()) {
                System.out.println("ALERTA NO S'HA TROBAT EL RADAR: " + radar.toString() + " EN CAP NAU, EL BUSQUEM EN LA DRASSANA...");
            } else {
                for (Nau_Dades nau : nausRadar) {
                    System.out.println("TROBAT RADAR: " + radar.toString() + " EN LA NAU " + nau.getNau_nom() + " (" + nau.getNau_ID() + ")");
                }
            }

            Predicate p2 = new Predicate<Drassana_Dades>() {
                @Override
                public boolean match(Drassana_Dades o) {

                    for(Map.Entry<String, LinkedList<Peça_electronica_Dades>> entry: o.getMapaPecesElectronica().entrySet()){
                        if(entry.getValue().contains(radar)) return true;
                    }
                    return false;
                }

            };
            ObjectSet<Drassana_Dades> d = db.query(p2);
            for(Drassana_Dades drassana_dades: d ){
                System.out.println("TROBAT RADAR: " + radar.toString() + " EN LA DRASSANA.");
            }

        }
    }


    //20. Drassana: reparar els radars trencats de les naus i la drassana
    // Els radars són les peces electròniques amb nom == "Cyrano IV".
    //
    // Buscar tots els radars trencats de totes les naus i de la drassana.
    //
    // S'arreglaran els radar trencats que siguin "is_reparable() == true" (els haurem de fer un
    // update amb trencat = false) i els que són "is_reparable() == false" seran destruits (esborrats de la BD).
    public static void repararTotsElsRadarsTrencats(Drassana_Dades drassana_MCRN, ObjectContainer db) {
        Predicate predicate = new Predicate<Peça_electronica_Dades>() {
            @Override
            public boolean match(Peça_electronica_Dades o) {
                return (o.getPeça_ID().equals("Cyrano IV") && o.isPeça_trencada());
            }
        };
        ObjectSet<Peça_electronica_Dades> radarsTrencats = db.query(predicate);
        while (radarsTrencats.hasNext()){
            Peça_electronica_Dades peca = radarsTrencats.next();
            if(!peca.esReparable()){
                System.out.println("DESTRUIT RADAR " + peca.toString());
                db.delete(peca);
            }else if(peca.esReparable()){
                peca.setPeça_trencada(false);
                System.out.println("REPARAT RADAR " + peca.toString());
                db.store(peca);
            }
        }


    }


}






























	
