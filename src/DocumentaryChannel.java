public class DocumentaryChannel extends TvChannel{

    // Instance variable (Attributes)
    int additionalPrice = 15;

    //Constructor
    public DocumentaryChannel(String channelName,String language,String category,int price){
        super(channelName,language,category,price);   //calling superclass/parent class constructor

    }

    @Override
    public int getPrice() {
        return super.getPrice() + additionalPrice;  ////Superclass(TvChannel) price + movieChannel Price(additional)
    }
}
