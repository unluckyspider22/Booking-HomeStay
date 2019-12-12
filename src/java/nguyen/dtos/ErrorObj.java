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
public class ErrorObj implements Serializable{
    private String usernameError,passwordError,confirmError,fullnameError,emailError,phoneError,idNumberError,dobError,roleError,nationalityError,invalidUNP;

    public ErrorObj() {
    }

    public ErrorObj(String usernameError, String passwordError, String confirmError, String fullnameError, String emailError, String phoneError, String idNumberError, 
            String dobError, String roleError, String nationalityError, String invalidUNP) {
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.confirmError = confirmError;
        this.fullnameError = fullnameError;
        this.emailError = emailError;
        this.phoneError = phoneError;
        this.idNumberError = idNumberError;
        this.dobError = dobError;
        this.roleError = roleError;
        this.nationalityError = nationalityError;
        this.invalidUNP = invalidUNP;
    }

    public String getInvalidUNP() {
        return invalidUNP;
    }

    public void setInvalidUNP(String invalidUNP) {
        this.invalidUNP = invalidUNP;
    }

    

    public String getRoleError() {
        return roleError;
    }

    public void setRoleError(String roleError) {
        this.roleError = roleError;
    }

    public String getNationalityError() {
        return nationalityError;
    }

    public void setNationalityError(String nationalityError) {
        this.nationalityError = nationalityError;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public String getFullnameError() {
        return fullnameError;
    }

    public void setFullnameError(String fullnameError) {
        this.fullnameError = fullnameError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getIdNumberError() {
        return idNumberError;
    }

    public void setIdNumberError(String idNumberError) {
        this.idNumberError = idNumberError;
    }

    public String getDobError() {
        return dobError;
    }

    public void setDobError(String dobError) {
        this.dobError = dobError;
    }
}
