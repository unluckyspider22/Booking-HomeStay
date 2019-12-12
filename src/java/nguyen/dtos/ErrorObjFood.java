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
public class ErrorObjFood implements Serializable{
    String foodIdError,foodNameError,descriptionError,priceError;

    public ErrorObjFood() {
    }

    public ErrorObjFood(String foodIdError, String foodNameError, String descriptionError, String priceError) {
        this.foodIdError = foodIdError;
        this.foodNameError = foodNameError;
        this.descriptionError = descriptionError;
        this.priceError = priceError;
    }

    public String getFoodIdError() {
        return foodIdError;
    }

    public void setFoodIdError(String foodIdError) {
        this.foodIdError = foodIdError;
    }

    public String getFoodNameError() {
        return foodNameError;
    }

    public void setFoodNameError(String foodNameError) {
        this.foodNameError = foodNameError;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }

    public String getPriceError() {
        return priceError;
    }

    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }
    
}
