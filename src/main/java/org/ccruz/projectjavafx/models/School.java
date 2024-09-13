package org.ccruz.projectjavafx.models;

import java.util.ArrayList;
import java.util.List;

public class School {
    private int id;
    private String name;
    private List<Studiant> studiants;

    public School() {}

    public School(String name) {
        this.name = name;
        this.studiants = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Studiant> getStudiants() {
        return studiants;
    }

    public void setStudiants(List<Studiant> studiants) {
        this.studiants = studiants;
    }

    public void addStudiant(Studiant studiant) {
        studiants.add(studiant);
    }

    public void updateStudiant(Studiant studiantToUpdated) {
//        studiants.forEach(studiant -> {
//            if (studiant.getId() == studiantToUpdated.getId()) {
//                studiant.setName(studiantToUpdated.getName());
//                studiant.setEmail(studiantToUpdated.getEmail());
//                studiant.setEnrollment(studiantToUpdated.getEnrollment());
//            }
//        });

        studiants.stream()
                .filter(studiant -> studiant.getId() == studiantToUpdated.getId())
                .findFirst()
                .ifPresent(studiant -> {
                    studiant.setName(studiantToUpdated.getName());
                    studiant.setEmail(studiantToUpdated.getEmail());
                    studiant.setEnrollment(studiantToUpdated.getEnrollment());
                });
    }

    public void deleteStudiant(Studiant studiant) {
        studiants.remove(studiant);
    }
}
