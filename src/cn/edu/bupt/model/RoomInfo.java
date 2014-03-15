package cn.edu.bupt.model;

public class RoomInfo {
    private String roomId;
    private String roomDescription;
    private String isCheck;
    
    public RoomInfo(String aId, String aDescription, String aCheck) {
        this.roomId = aId;
        this.roomDescription = aDescription;
        this.isCheck = aCheck;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public String getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(String isCheck) {
        this.isCheck = isCheck;
    }
    
    
}
