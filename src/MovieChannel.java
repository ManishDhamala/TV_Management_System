public class MovieChannel extends TvChannel{

    // Instance variable (Attributes)
    int additionalPrice = 10;

    //Constructor
    public MovieChannel(String channelName,String language,String category,int price){
        super(channelName,language,category,price);  //calling superclass/parent class constructor

    }

    @Override
    public int getPrice() {
        return super.getPrice() + additionalPrice;  //Superclass(TvChannel) price + movieChannel Price(additional)
    }
}
