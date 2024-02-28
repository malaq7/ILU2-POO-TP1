package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les légendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
	private static class Marche{
		Etal[] etals ;
		private int nbEtals;
		private Marche(int nbEtal){
			Etal[] etals = new Etal[nbEtal];
			for (int i = 0; i < nbEtals; i++) {
				etals[i] = new Etal();}
		}
    	private void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
    		if (indiceEtal >= 0 && indiceEtal < marche.nbEtals) {
    			marche.etals[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
    		} else {
    			System.out.println("Indice d'étal invalide.");
    		}
    	}
        public int trouverEtalLibre() {
            for (int i = 0; i < marche.nbEtals; i++) {
                if (!marche.etals[i].isEtalOccupe()) {
                    return i; 
                }            }
            return -1;
        }
}
}