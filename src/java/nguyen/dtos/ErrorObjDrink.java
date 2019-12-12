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
public class ErrorObjDrink implements Serializable{
    String drinkIdError,drinkNameError,descriptionError,priceError;

    public ErrorObjDrink() {
    }

    public ErrorObjDrink(String drinkIdError, String drinkNameError, String descriptionError, String priceError) {
        this.drinkIdError = drinkIdError;
        this.drinkNameError = drinkNameError;
        this.descriptionError = descriptionError;
        this.priceError = priceError;
    }

    public String getdrinkIdError() {
        return drinkIdError;
    }

    public void setdrinkIdError(String drinkIdError) {
        this.drinkIdError = drinkIdError;
    }

    public String getdrinkNameError() {
        return drinkNameError;
    }

    public void setdrinkNameError(String drinkNameError) {
        this.drinkNameError = drinkNameError;
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
