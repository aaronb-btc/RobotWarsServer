package com.btc.rwserver.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Maps")
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")

    private String id;

    @Column(name = "Map Width")
    private int mapSizeX;

    @Column(name = "Map Size")
    private int mapSize;

    @Column(name = "Map Items")
    private MapItem[] mapItems;

    public Map() {}

    public Map(String id, int mapSizeX, int mapSize, MapItem[] mapItems) {
        this.id = id;
        this.mapSizeX = mapSizeX;
        this.mapSize = mapSize;
        this.mapItems = mapItems;
    }

    public String getId() {
        return id;
    }

    public int getMapSizeX() {
        return mapSizeX;
    }

    public int getMapSize() {
        return mapSize;
    }

    public MapItem[] getMapItems() {
        return mapItems;
    }
}

class MapItem {
    protected String type;
    protected int index;

    public MapItem() {}

    public MapItem(String type, int index) {
        this.type = type;
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public int getIndex() {
        return index;
    }
}
