package mg.jerryharim.activitytracker.core.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Activite {

    private final LocalDate date;
    private final LocalTime heureDebut;
    private final LocalTime heureFin;
    private final List<String> motCles;
    private final String nom;
    private String detail;

    public Activite(LocalDate date, LocalTime heureDebut, LocalTime heureFin, String nom, 
            List<String> motCles) {
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.motCles = motCles;
        this.nom = nom;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getNom() {
        return nom;
    }

    public List<String> getMotCle() {
        return motCles;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDetail() {
        return this.detail;
    }

}

