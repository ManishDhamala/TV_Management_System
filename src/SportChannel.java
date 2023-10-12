public class SportChannel  extends  TvChannel{

   // Instance variable (Attributes)
    int additionalPrice = 5;

    //Constructor
    public SportChannel(String channelName,String language,String category,int price){
        super(channelName,language,category,price);   //calling superclass/parent class constructor

    }

    @Override
    public int getPrice() {
        return super.getPrice() + additionalPrice;  //Superclass(TvChannel) price + sportChannel Price(additional)
    }

}
