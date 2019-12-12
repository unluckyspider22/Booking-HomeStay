/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyen.dtos;

import java.io.Serializable;

/**
 *
 * @author Unlucky Spider
 */
public class RoomDTO implements Serializable{
    String roomId,roomType;
    int status;

    public RoomDTO() {
    }

    public RoomDTO(String roomId, String roomType, int status) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.status = status;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
