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
public class ErrorObjRoomType implements Serializable{
    String roomTypeError,descriptionError,quantityError,capacityError,priceError,statusError;

    public ErrorObjRoomType() {
    }

    public ErrorObjRoomType(String roomTypeError, String descriptionError, String quantityError, String capacityError, String priceError, String statusError) {
        this.roomTypeError = roomTypeError;
        this.descriptionError = descriptionError;
        this.quantityError = quantityError;
        this.capacityError = capacityError;
        this.priceError = priceError;
        this.statusError = statusError;
    }

    public String getRoomTypeError() {
        return roomTypeError;
    }

    public void setRoomTypeError(String roomTypeError) {
        this.roomTypeError = roomTypeError;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }

    public String getQuantityError() {
        return quantityError;
    }

    public void setQuantityError(String quantityError) {
        this.quantityError = quantityError;
    }

    public String getCapacityError() {
        return capacityError;
    }

    public void setCapacityError(String capacityError) {
        this.capacityError = capacityError;
    }

    public String getPriceError() {
        return priceError;
    }

    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

    public String getStatusError() {
        return statusError;
    }

    public void setStatusError(String statusError) {
        this.statusError = statusError;
    }
    
}
