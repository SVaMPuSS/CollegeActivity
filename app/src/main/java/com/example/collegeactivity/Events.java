package com.example.collegeactivity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Events implements Serializable {
    private int id;
    private int eventId;
    private int divisionId;
    private String name;
    private String date;
    private String dateStart;
    private String dateEnd;
    private String location;
    private int idPesFace;

    public Events(int id, int eventId, int divisionId, String name, String date, String dateStart, String dateEnd, String location, int idPesFace) {
        this.id = id;
        this.eventId = eventId;
        this.divisionId = divisionId;
        this.name = name;
        this.date = date;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.location = location;
        this.idPesFace = idPesFace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getIdPesFace() {
        return idPesFace;
    }

    public void setIdPesFace(int idPesFace) {
        this.idPesFace = idPesFace;
    }
}
