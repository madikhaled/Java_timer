import java.util.ArrayList;
import java.util.List;
public class Utilis {
    //calcule seconde en minute
    public static int secondeEnMinute(int seconde) {
        return seconde / 60;
    }
    //calcule seconde en heure
    public static int secondeEnHeure(int seconde) {
        return seconde / 3600;
    }
    //calcule seconde en jour
    public static int secondeEnJour(int seconde) {
        return seconde / 86400;
    }
    //calcule seconde en annee
    public static int secondeEnAnnee(int seconde) {
        return seconde / 31536000;
    }

    public static String formatDuration(int seconde) {// prend en parametre un entier
        int annee = secondeEnAnnee(seconde);
        seconde %= 31536000;
        int jour = secondeEnJour(seconde);
        seconde %= 86400;
        int heure = secondeEnHeure(seconde);
        seconde %= 3600;
        int minute = secondeEnMinute(seconde);
        seconde %= 60;



        List<String> tblDuree = new ArrayList<>();
        if (annee > 0) {
            tblDuree.add(annee > 1 ? annee + " années" : annee + " année");
        }
        if (jour > 0) {
            tblDuree.add(jour > 1 ? jour + " jours" : jour + " jour");
        }
        if (heure > 0) {
            tblDuree.add(heure > 1 ? heure + " heures" : heure + " heure");
        }
        if (minute > 0) {
            tblDuree.add(minute > 1 ? minute + " minutes" : minute + " minute");
        }
        if (seconde > 0) {
            tblDuree.add(seconde > 1 ? seconde + " secondes" : seconde + " seconde");
        }
        if (seconde ==0) {
            tblDuree.add("Now !");
        }

        String duration = String.join(", ", tblDuree);//join les elements de la liste avec une virgule
        int derniereVirgule = duration.lastIndexOf(",");
        if (derniereVirgule != -1) { //si la virgule existe, on la remplace par "et"
            duration = duration.substring(0, derniereVirgule) + " et" + duration.substring(derniereVirgule + 1);
        }

        return duration;

    }
}


