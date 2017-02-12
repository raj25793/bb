package org.test.falcon.dto;

public class RegisterUser extends User {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String            password;

    private String            confirmPassword;

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
