package com.btc.rwserver.Models;

public class Map {
    private String id;
    private int mapSizeX;
    private int mapSize;
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
