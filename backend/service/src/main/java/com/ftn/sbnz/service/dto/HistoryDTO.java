package com.ftn.sbnz.service.dto;

public class HistoryDTO implements Comparable<HistoryDTO> {

    private String name;

    private String date;

    public HistoryDTO(String name, String date) {
        this.name = name;
        this.date = date;
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

    @Override
    public int compareTo(HistoryDTO o) {
        return o.date.compareTo(this.date);
    }
}
