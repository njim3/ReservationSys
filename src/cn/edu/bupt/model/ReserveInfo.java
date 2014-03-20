package cn.edu.bupt.model;

public class ReserveInfo {
    private String cusId;
    private int roomId;
    private int roomType;
    
    public ReserveInfo(String aId, int aRoomId, int aRoomType) {
        this.cusId = aId;
        this.roomId = aRoomId;
        this.roomType = aRoomType;
    }
    
    public String getCusId() {
        return cusId;
    }
    public void setCusId(String cusId) {
        this.cusId = cusId;
    }
    public int getRoomId() {
        return roomId;
    }
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    public int getRoomType() {
        return roomType;
    }
    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }
    
    
}
