package com.example.de_api.network.Rooms.RoomsGet;

import com.google.gson.annotations.SerializedName;

public class Items {
    @SerializedName("name")
    private String name;
    @SerializedName("type")
    private String type;

    public Items(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
