public  abstract class TvChannel {


    //Instance variables (attributes)
    String channelName;
    String language;
    String category;
    int price;


    //Constructor
    public TvChannel(String channelName,String language,String category,int price){
        this.channelName = channelName;
        this.language = language;
        this.category = category;
        this.price = price;
    }


    //Getter
    public String getChannelName(){
        return channelName;
    }

    public String getLanguage() {
        return language;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }


    //Setter
    public void setChannelName(String channelName){
        this.channelName = channelName;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(int price){
        this.price = price;
    }



}
