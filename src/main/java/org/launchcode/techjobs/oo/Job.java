package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }
    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job job)) return false;
        Job job1 = (Job) o;
        return getId() == job1.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
    public String toString(){
        if (name == null && employer == null && location == null && positionType == null && coreCompetency == null) {
            return "OOPS! This job does not seem to exist.";
        }
//        return System.lineSeparator()+
//                "\nID: "+id+
//                "\nName: "+(name!=null ? name : "Data not available")+
//                "\nEmployer: "+(employer!=null ? employer : "Data not available")+
//                "\nLocation: "+(location!=null? location: "Data not available")+
//                "\nPosition Type: "+(positionType!=null ? positionType : "Data not available")+
//                "\nCore Competency: "+(coreCompetency!=null? coreCompetency : "Data not available")+
//                System.lineSeparator();
        return String.format(
                "%sID: %d%n" +
                        "Name: %s%n" +
                        "Employer: %s%n" +
                        "Location: %s%n" +
                        "Position Type: %s%n" +
                        "Core Competency: %s%s",
                System.lineSeparator(), id, (name != null && !name.isEmpty() ? name : "Data not available"),
                (employer != null && !employer.getValue().isEmpty()? employer : "Data not available"),
                (location != null && !location.getValue().isEmpty()? location : "Data not available"),
                (positionType != null && !positionType.getValue().isEmpty()? positionType : "Data not available"),
                (coreCompetency != null && !coreCompetency.getValue().isEmpty() ? coreCompetency : "Data not available"),
                System.lineSeparator()).replace("\r\n", "\n");
    }
    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
