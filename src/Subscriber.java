public class Subscriber {

    private String firstName;
    private String lastName;
    private String mobileNo;
    private String city;


    public Subscriber(String firstName, String lastName, String mobileNo, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNo = mobileNo;
        this.city = city;
    }

    // Getter and Setter
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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //string representation of an object.
    @Override
    public String toString() {
        return "Subscriber{" +
                "firstName='" + firstName + '\'' +  // \' is an escape character used to represent a single quote within a string
                ", lastName='" + lastName + '\'' +
                ", MobileNo='" + mobileNo + '\'' +
                ", city='" + city + '\'' +
                '}';
    }


}
