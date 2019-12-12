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
public class ErrorObjRoom implements Serializable{
    String roomIdError,roomTypeError,statusError;

    public ErrorObjRoom() {
    }

    public ErrorObjRoom(String roomIdError, String roomTypeError, String statusError) {
        this.roomIdError = roomIdError;
        this.roomTypeError = roomTypeError;
        this.statusError = statusError;
    }

    public String getRoomIdError() {
        return roomIdError;
    }

    public void setRoomIdError(String roomIdError) {
        this.roomIdError = roomIdError;
    }

    public String getRoomTypeError() {
        return roomTypeError;
    }

    public void setRoomTypeError(String roomTypeError) {
        this.roomTypeError = roomTypeError;
    }

    public String getStatusError() {
        return statusError;
    }

    public void setStatusError(String statusError) {
        this.statusError = statusError;
    }
    
}
