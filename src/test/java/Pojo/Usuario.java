package Pojo;

public class Usuario {

    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private String password;
    private String confirmPassword;
    private Boolean isSubscribe;
    private Boolean privacyPolicy;

    public Usuario(String firstName, String lastName, String email, String telephone, String password, String confirmPassword, Boolean isSubscribe, Boolean privacyPolicy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.isSubscribe = isSubscribe;
        this.privacyPolicy = privacyPolicy;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Boolean getSubscribe() {
        return isSubscribe;
    }

    public void setSubscribe(Boolean subscribe) {
        isSubscribe = subscribe;
    }

    public Boolean getPrivacyPolicy() {
        return privacyPolicy;
    }

    public void setPrivacyPolicy(Boolean privacyPolicy) {
        this.privacyPolicy = privacyPolicy;
    }

    @Override
    public String toString() {
        return  "First Name : " + firstName + '\'' +
                ", Last Name : " + lastName + '\'' +
                ", Email : " + email + '\'' +
                ", Telephone : " + telephone + '\'' +
                ", Subscribe? : " + isSubscribe +
                ", Privacy Policy Accepted? : " + privacyPolicy;
    }
}
