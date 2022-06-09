package com.example.falhafezz.model;

public class Poet {

    private String name;
    private String birthYearInLHijri;
    private String deathYearInLHijri;
    private String birthPlace;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYearInLHijri() {
        return birthYearInLHijri;
    }

    public void setBirthYearInLHijri(String birthYearInLHijri) {
        this.birthYearInLHijri = birthYearInLHijri;
    }

    public String getDeathYearInLHijri() {
        return deathYearInLHijri;
    }

    public void setDeathYearInLHijri(String deathYearInLHijri) {
        this.deathYearInLHijri = deathYearInLHijri;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Poet(String name, String birthYearInLHijri, String deathYearInLHijri, String birthPlace) {
        this.name = name;
        this.birthYearInLHijri = birthYearInLHijri;
        this.deathYearInLHijri = deathYearInLHijri;
        this.birthPlace = birthPlace;
    }
}
