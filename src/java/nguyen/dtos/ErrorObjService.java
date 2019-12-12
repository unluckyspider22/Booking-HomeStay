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
public class ErrorObjService implements Serializable{
    String serviceIdError,serviceNameError,descriptionError,priceError;

    public ErrorObjService() {
    }

    public ErrorObjService(String serviceIdError, String serviceNameError, String descriptionError, String priceError) {
        this.serviceIdError = serviceIdError;
        this.serviceNameError = serviceNameError;
        this.descriptionError = descriptionError;
        this.priceError = priceError;
    }

    public String getserviceIdError() {
        return serviceIdError;
    }

    public void setserviceIdError(String serviceIdError) {
        this.serviceIdError = serviceIdError;
    }

    public String getserviceNameError() {
        return serviceNameError;
    }

    public void setserviceNameError(String serviceNameError) {
        this.serviceNameError = serviceNameError;
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
