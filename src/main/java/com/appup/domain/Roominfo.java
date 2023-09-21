package com.appup.domain;


public class Roominfo {
    private String arename;
    private String building;
    private String buildingID;
    private String floor;
    private String floorID;
    private String room;
    private String roomID;


    public Roominfo() {
    }

    public Roominfo(String arename, String building, String buildingID, String floor, String floorID, String room, String roomID) {
        this.arename = arename;
        this.building = building;
        this.buildingID = buildingID;
        this.floor = floor;
        this.floorID = floorID;
        this.room = room;
        this.roomID = roomID;
    }

    /**
     * 获取
     * @return arename
     */
    public String getArename() {
        return arename;
    }

    /**
     * 设置
     * @param arename
     */
    public void setArename(String arename) {
        this.arename = arename;
    }

    /**
     * 获取
     * @return building
     */
    public String getBuilding() {
        return building;
    }

    /**
     * 设置
     * @param building
     */
    public void setBuilding(String building) {
        this.building = building;
    }

    /**
     * 获取
     * @return buildingID
     */
    public String getBuildingID() {
        return buildingID;
    }

    /**
     * 设置
     * @param buildingID
     */
    public void setBuildingID(String buildingID) {
        this.buildingID = buildingID;
    }

    /**
     * 获取
     * @return floor
     */
    public String getFloor() {
        return floor;
    }

    /**
     * 设置
     * @param floor
     */
    public void setFloor(String floor) {
        this.floor = floor;
    }

    /**
     * 获取
     * @return floorID
     */
    public String getFloorID() {
        return floorID;
    }

    /**
     * 设置
     * @param floorID
     */
    public void setFloorID(String floorID) {
        this.floorID = floorID;
    }

    /**
     * 获取
     * @return room
     */
    public String getRoom() {
        return room;
    }

    /**
     * 设置
     * @param room
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * 获取
     * @return roomID
     */
    public String getRoomID() {
        return roomID;
    }

    /**
     * 设置
     * @param roomID
     */
    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String toString() {
        return "Roominfo{arename = " + arename + ", building = " + building + ", buildingID = " + buildingID + ", floor = " + floor + ", floorID = " + floorID + ", room = " + room + ", roomID = " + roomID + "}";
    }
}