import java.io.Serializable;

public class SubscriptionCycle implements Serializable {

    private String startDate;
    private String expiryDate;

    public SubscriptionCycle(String startDate,String expiryDate){
        this.startDate = startDate;
        this.expiryDate = expiryDate;
    }

    //Getter
    public String getStartDate(){
        return startDate;
    }

    public String getExpiryDate(){
        return  expiryDate;
    }

    //Setter
    public void setStartDate(String startDate){
        this.startDate = startDate;
    }

    public  void setExpiryDate(String expiryDate){
        this.expiryDate = expiryDate;
    }

    //string representation of an object
    @Override
    public String toString() {
        return "SubscriptionCycle{" +
                "startDate='" + startDate + '\'' +       // \' is an escape character used to represent a single quote within a string
                ", expiryDate='" + expiryDate + '\'' +
                '}';
    }

}
