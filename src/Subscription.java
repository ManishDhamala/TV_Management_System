public class Subscription {

    private int installFee;    // fixed fee 15$/TV
    private int noOfTv;
    private Subscriber subscriber;
    private SubscriptionCycle subscriptionCycle;
    private String date;

    private  int totalFee;

    //constructor
    public Subscription(int noOfTv, Subscriber subscriber, SubscriptionCycle subscriptionCycle, String date) {
        this.noOfTv = noOfTv;
        this.subscriber = subscriber;
        this.subscriptionCycle = subscriptionCycle;
        this.date = date;

        this.installFee = noOfTv * 15; // No parameter because it is fixed and calculated as per no of TV
    }

    //Getters and Setters
    public int getNoOfTv() {
        return noOfTv;
    }

    public void setNoOfTv(int noOfTv) {
        this.noOfTv = noOfTv;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public SubscriptionCycle getSubscriptionCycle() {
        return subscriptionCycle;
    }

    public void setSubscriptionCycle(SubscriptionCycle subscriptionCycle) {
        this.subscriptionCycle = subscriptionCycle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalFee() {
        totalFee = installFee + 5 ;
        return totalFee;
    }                       /*No setter  for total fee because it can't be set by users.It is
                             calculated on the basis of install fee */




    //string representation of an object
    @Override
    public String toString() {
        return "Subscription{" +
                "installFee=" + installFee +
                ", noOfTv=" + noOfTv +
                ", subscriber=" + subscriber +
                ", subscriptionCycle=" + subscriptionCycle +
                ", date='" + date + '\'' +    // \' is an escape character used to represent a single quote within a string
                ", totalFee=" + totalFee +
                '}';
    }
}
