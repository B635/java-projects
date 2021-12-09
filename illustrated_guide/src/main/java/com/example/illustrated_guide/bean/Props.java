package com.example.illustrated_guide.bean;

public class Props {
    private int id;
    private String name;
    private String description;
    private String place;
    private String effect;

    public Props(int id, String name, String description, String place, String effect) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.place = place;
        this.effect = effect;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
}

