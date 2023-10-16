import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainScreen extends JFrame {

    /*****************************
     * Subscriber Panel1
     **********************************/
    JPanel subscriberPanel;

    JLabel subFirstnameLabel;
    JLabel subLastnamelabel;
    JLabel subMobileLabel;
    JLabel subCityLabel;

    JTextField subFirstname;   //Text-field for single line
    JTextField subLastname;
    JTextField subMobile;
    JTextField subCity;

    /******************************* Cycle Panel 2 ******************************/

    JPanel cyclePanel;
    SimpleDateFormat dateFormat; // For date format
    Date currentdate; // For current date and time

    JLabel todayLabel;
    JLabel startCycleLabel;
    JLabel endCycleLabel;
    JLabel numberTVLabel;

    JTextField startCycle;
    JTextField endCycle;
    JTextField numberTV;

    /*******************************  Package Panel 3 ***********************************/

    JPanel packagepanel;

    JCheckBox sportCheckBox;
    JCheckBox moviesCheckBox;
    JCheckBox documentaryCheckBox;

    /*******************************  AvailableChannels Panel 4 ***********************************/

    JPanel detailsPanel;

    JTextArea channelsAreaSports;   //JText-area for sports channel (multiple line)
    JTextArea channelsAreaMovies;       //JText-area for movies channel (multiple line)
    JTextArea channelsAreaDocumentaries;      //JText-area for Documentaries channel (multiple line)

    /******************************* Fees Panel 5 ******************************/

    JPanel feePanel;

    JLabel installationFeesLabel;
    JLabel packageFeesLabel;
    JLabel totalFeesLabel;

    /******************************* Customer Table Panel 6 ******************************/

    JPanel customerTablePanel;
    JTable table;
    DefaultTableModel tableModel;

    /******************************* Action Panel 7 ******************************/

    JPanel actionPanel;
    JButton saveButton;
    JButton loadButton;
    JButton newButton;


    //Classes and objects
    Subscriber subscriber;
    Subscription subscription;

    // instance variable for showPrice()
    int packageSelectedPrice = 0;
    int totalPrice;



    // Constructor
    public MainScreen() {

        /****************************
         * Subscriber Panel1
         **********************************/

        subscriberPanel = new JPanel();
        Border panel1 = BorderFactory.createTitledBorder("Subscriber Details"); // Creating border with a title-header
                                                                                // subscriber details

        subscriberPanel.setBorder(panel1);
        subscriberPanel.setBounds(15, 15, 300, 200);
        subscriberPanel.setLayout(new GridLayout(4, 2)); // column for: 1)JLabel 2)JTextField

        // JLabel
        subFirstnameLabel = new JLabel(" First Name: ");
        subLastnamelabel = new JLabel("Last Name: ");
        subMobileLabel = new JLabel("Mobile No: ");
        subCityLabel = new JLabel("City: ");

        // JTextField
        subFirstname = new JTextField();
        subLastname = new JTextField();
        subMobile = new JTextField();
        subCity = new JTextField();

        // JTextField will not have a background (Transparent)
        subFirstname.setOpaque(false);
        subLastname.setOpaque(false);
        subMobile.setOpaque(false);
        subCity.setOpaque(false);

        // Adding component to the Subscription panel1
        subscriberPanel.add(subFirstnameLabel);
        subscriberPanel.add(subFirstname);
        subscriberPanel.add(subLastnamelabel);
        subscriberPanel.add(subLastname);
        subscriberPanel.add(subMobileLabel);
        subscriberPanel.add(subMobile);
        subscriberPanel.add(subCityLabel);
        subscriberPanel.add(subCity);

        /******************************* Cycle Panel 2 ******************************/

        cyclePanel = new JPanel();
        cyclePanel.setBounds(15, 230, 300, 500);
        cyclePanel.setLayout(new GridLayout(14, 1));
        Border panel2 = BorderFactory.createTitledBorder("Subscription Details");
        cyclePanel.setBorder(panel2);

        // Setting today's date to display
        todayLabel = new JLabel();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Format pattern of date
        currentdate = new Date(); // Getting the current date
        todayLabel.setText("Today: " + dateFormat.format(currentdate)); // Displaying the current date in
                                                                        // SimpleDateFormat("dd/MM/yyyy")

        // JLabel
        startCycleLabel = new JLabel("Start Date (DD/MM/YYY) ");
        endCycleLabel = new JLabel("Expiry Date (DD/MM/YYY) ");
        numberTVLabel = new JLabel("Number of TV: ");

        // JTextField
        startCycle = new JTextField();
        endCycle = new JTextField();
        numberTV = new JTextField();

        // JTextField will not have a background (Transparent)
        startCycle.setOpaque(false);
        endCycle.setOpaque(false);
        numberTV.setOpaque(false);

        // Adding component to cycle Panel2
        cyclePanel.add(todayLabel);
        cyclePanel.add(startCycleLabel);
        cyclePanel.add(startCycle);
        cyclePanel.add(endCycleLabel);
        cyclePanel.add(endCycle);
        cyclePanel.add(numberTVLabel);
        cyclePanel.add(numberTV);

        /*******************************  Package Panel 3 ***********************************/

        packagepanel = new JPanel();
        Border panel3 = BorderFactory.createTitledBorder("Available Packages");
        packagepanel.setBorder(panel3);
        packagepanel.setBounds(330,15,300,200);
        packagepanel.setLayout(new GridLayout(5,1));

        JLabel packagesLabel = new JLabel("Select your packages: ");

        //CheckBox
        sportCheckBox = new JCheckBox("Sports");
        moviesCheckBox = new JCheckBox("Movies");
        documentaryCheckBox = new JCheckBox("Documentaries");

        //Button
        JButton subscribeBtn = new JButton("Subscribe");

        //Adding components to Package panel 3
        packagepanel.add(packagesLabel);
        packagepanel.add(sportCheckBox);
        packagepanel.add(moviesCheckBox);
        packagepanel.add(documentaryCheckBox);
        packagepanel.add(subscribeBtn);

        //Adding action listener for subscribe button
        subscribeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    GetSubscriberData();
                }catch (Exception ee){

                }

            }
        });


        // Checkbox Item listeners
        sportCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(sportCheckBox.isSelected()){
                    DisplaySportsChannels();
                    //make price changes
                }else{
                    
                }
            }
        });
        
        moviesCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(moviesCheckBox.isSelected()){
                    DisplayMoviesChannels();
                }else {
                    
                }
            }
        });
        
        documentaryCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(documentaryCheckBox.isSelected()) {
                    DisplayDocumentaryChannels();
                }else{
                    
                }
            }
        });


        /*******************************  AvailableChannels Panel 4 ***********************************/

        detailsPanel = new JPanel();
        Border panel4 = BorderFactory.createTitledBorder("Available Channels");
        detailsPanel.setBorder(panel4);
        detailsPanel.setBounds(330,230,300,500);
        detailsPanel.setLayout(new GridLayout(3,1));

        channelsAreaSports = new JTextArea(5,1);
        channelsAreaSports.setEditable(false);  // user cannot edit the text in JTextArea
        channelsAreaSports.setOpaque(false);    // JTextArea will not have a background (Transparent)
        channelsAreaSports.setLineWrap(true);   // wrapping lines to fit within the available width

        channelsAreaMovies = new JTextArea(5,1);
        channelsAreaMovies.setEditable(false);
        channelsAreaMovies.setOpaque(false);
        channelsAreaMovies.setLineWrap(true);

        channelsAreaDocumentaries = new JTextArea(5,1);
        channelsAreaDocumentaries.setEditable(false);
        channelsAreaDocumentaries.setOpaque(false);
        channelsAreaDocumentaries.setLineWrap(true);

        //Adding components to panel4
        detailsPanel.add(channelsAreaSports);
        detailsPanel.add(channelsAreaMovies);
        detailsPanel.add(channelsAreaDocumentaries);

        /******************************* Fees Panel 5 ******************************/
        
        feePanel = new JPanel();
        Border panel5 = BorderFactory.createTitledBorder("Fees & Payments");
        feePanel.setBorder(panel5);
        feePanel.setBounds(645,15,200,200);
        feePanel.setLayout(new GridLayout(3,1));

        installationFeesLabel = new JLabel("Installation fees: ");
        packageFeesLabel = new JLabel("Package fees: ");
        totalFeesLabel = new JLabel("Total Amount: ");

        //Adding component to fee panel 5
        feePanel.add(installationFeesLabel);
        feePanel.add(packageFeesLabel);
        feePanel.add(totalFeesLabel);

        /******************************* Customer Table Panel 6 ******************************/

        customerTablePanel = new JPanel();
        Border panel6 = BorderFactory.createTitledBorder("Customers");
        customerTablePanel.setBorder(panel6);
        customerTablePanel.setBounds(645,230,515,500);
        customerTablePanel.setLayout(new GridLayout(3,1));


        tableModel = new DefaultTableModel(); // Choosing default table model to manage the structure and data of table
        table = new JTable(tableModel); // passing tableModel as a parameter to create a default table model

        // adding columns to the table
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("Phone Number");
        tableModel.addColumn("Start Date");
        tableModel.addColumn("Expiry Date");
        tableModel.addColumn("Total Amount");


        //ScrollPane for horizontal and vertical scroll
        JScrollPane jScrollPane = new JScrollPane(table);

        //Adding components to the customer table panel 6
        customerTablePanel.add(jScrollPane);   //JScrollPane - table - tableModel


        /******************************* Action Panel 7 ******************************/

        actionPanel = new JPanel();
        Border panel7 = BorderFactory.createTitledBorder("Action Panel");
        actionPanel.setBorder(panel7);
        actionPanel.setBounds(860,15,300,200);
        actionPanel.setLayout(new GridLayout(4,1));


        //Buttons
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveDataToDisk();

            }
        });


        loadButton = new JButton("Load");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadDataFromDisk();

            }
        });


        newButton = new JButton("New");
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newData();

            }
        });


        //Adding components to Action Panel 7
        actionPanel.add(saveButton);
        actionPanel.add(loadButton);
        actionPanel.add(newButton);




        // Adding panel to JFrame
        add(subscriberPanel);         //Panel-1
        add(cyclePanel);              //Panel-2
        add(packagepanel);            //Panel-3
        add(detailsPanel);            //panel-4
        add(feePanel);               //panel-5
        add(customerTablePanel);     //Panel-6
        add(actionPanel);            //Panel-7
        setLayout(null); // null layout for jFrame

    }



    //Methods

    private void saveDataToDisk() {
    }
    private void loadDataFromDisk() {
    }
    private void newData() {
    }

    //Method to get Subscriber and subscription data
    private void GetSubscriberData() throws ParseException {
        //Getting current date and time
        Date currentDate = new Date();

        // getting Subscriber data
        subscriber = new Subscriber(
                subFirstname.getText(),
                subLastname.getText(),
                subMobile.getText(),
                subCity.getText()
        );

        //Subscription cycle
        Date startCycle1 = dateFormat.parse(startCycle.getText()); //converting startCycle date  into SimpleDateFormat
        Date endCycle1 = dateFormat.parse(endCycle.getText());    //converting endCycle date into SimpleDateFormat

        //Creating SubscriptionCycle object named cycle
        SubscriptionCycle cycle = new SubscriptionCycle(
                dateFormat.format(startCycle1),
                dateFormat.format(endCycle1)
        );

        // Getting Subscription data
        subscription = new Subscription(
                Integer.parseInt(numberTV.getText()),
                subscriber,
                cycle,  // this object contains both startCycle & endCycle
                dateFormat.format(currentDate)  //current date format as string
        );

        installationFeesLabel.setText("Installation fee: "+
                    subscription.getTotalFee()+" $");  //Calling getTotalFee method from Subscription class

        //Calling ShowPrice method
        ShowPrice();
    }

    //Method to display package price and total fee
    private void ShowPrice() {
        if(documentaryCheckBox.isSelected()){
            packageSelectedPrice += DisplayDocumentaryChannels();  // package price of documentary channel (0 + packagePrice)
        }else if(moviesCheckBox.isSelected()){
            packageSelectedPrice += DisplayMoviesChannels();     // package price of movie channel
        }else if(sportCheckBox.isSelected()){
            packageSelectedPrice += DisplaySportsChannels();     // package price of sport channel
        }


        packageFeesLabel.setText("Packages fee: "+packageSelectedPrice+" $");
        totalPrice = subscription.getTotalFee() + packageSelectedPrice;  //Subscription total fee + package selected price
        totalFeesLabel.setText("Total Amount: "+totalPrice+" $");
    }


    //Method to display sport channels and calculate package price
    private int DisplaySportsChannels() {
        //Creating instance of SportsChannel class
        SportChannel c1 = new SportChannel("ESPN Sports", "ENG", "Sport", 10);
        SportChannel c2 = new SportChannel("Fox Sports", "    ESP", "Sport", 8);
        SportChannel c3 = new SportChannel("Sky Sports", "    AR", "Sport", 12);
        SportChannel c4 = new SportChannel("NBC Sports", "  GER", "Sport", 9);
        SportChannel c5 = new SportChannel("Star Sports", "    IND", "Sport", 7);
        SportChannel c6 = new SportChannel("Euro Sports", "  ENG", "Sport", 11);

        ArrayList<SportChannel> sportArrayList = new ArrayList<>();
        sportArrayList.add(c1);
        sportArrayList.add(c2);
        sportArrayList.add(c3);
        sportArrayList.add(c4);
        sportArrayList.add(c5);
        sportArrayList.add(c6);

        String sportChannelString = "";
        int packagePrice = 0;

        //Iterating over sportArrayList(Arraylist) to get their name,language and price
        for(int i = 0; i<sportArrayList.size(); i++){
            sportChannelString += "          "+sportArrayList.get(i).getChannelName()
                    +"           "+sportArrayList.get(i).getLanguage()
                    +"           "+sportArrayList.get(i).getPrice()
                    +"\n";     //Creating a new line
            packagePrice += sportArrayList.get(i).getPrice();  //Getting the individual price of sport channel and adding them
        }
        channelsAreaSports.setText(sportChannelString);
        return packagePrice;
    }


    //Method to display movie channels and calculate package price
    private int DisplayMoviesChannels() {
        //Creating instance of MoviesChannel lass
        MovieChannel c1 = new MovieChannel("Action Flicks", "ENG", "Movie", 10);
        MovieChannel c2 = new MovieChannel("Max Cinema", "GER", "Movie", 8);
        MovieChannel c3 = new MovieChannel("Zoom Plus", "   ESP", "Movie", 12);
        MovieChannel c4 = new MovieChannel("Film Fest", "     ENG", "Movie", 9);
        MovieChannel c5 = new MovieChannel("Family Movie ", "IND", "Movie", 7);
        MovieChannel c6 = new MovieChannel("Horror Movie ", "AR", "Movie", 11);

        ArrayList<MovieChannel> movieArrayList = new ArrayList<>();
        movieArrayList.add(c1);
        movieArrayList.add(c2);
        movieArrayList.add(c3);
        movieArrayList.add(c4);
        movieArrayList.add(c5);
        movieArrayList.add(c6);

        String movieChannelString = "";
        int packagePrice = 0;

        //Iterating over movieArrayList(Arraylist) to get their name,language and price
        for(int i = 0; i<movieArrayList.size(); i++){
            movieChannelString += "          "+movieArrayList.get(i).getChannelName()
                                   +"           "+movieArrayList.get(i).getLanguage()
                                   +"           "+movieArrayList.get(i).getPrice()
                                   +"\n";     //Creating a new line
            packagePrice += movieArrayList.get(i).getPrice();   //Getting the individual price of movie channel and adding them
        }
        channelsAreaMovies.setText(movieChannelString);
        return  packagePrice;
    }


    //Method to display documentary channels and calculate package price
    private int DisplayDocumentaryChannels() {
        //Creating instance of DocumentaryChannel class
        DocumentaryChannel c1 = new DocumentaryChannel("National Geo","ENG","DOC",2);
        DocumentaryChannel c2 = new DocumentaryChannel("Timeline","       GER","DOC",3);
        DocumentaryChannel c3 = new DocumentaryChannel("Journey Man","ESP","DOC",4);
        DocumentaryChannel c4 = new DocumentaryChannel("Doc Tube","     ENG","DOC",3);
        DocumentaryChannel c5 = new DocumentaryChannel("Canal D","        IND","DOC",2);
        DocumentaryChannel c6 = new DocumentaryChannel("Ray Four","       AR","DOC",1);

        ArrayList<DocumentaryChannel> docArrayList = new ArrayList<>();
        docArrayList.add(c1);
        docArrayList.add(c2);
        docArrayList.add(c3);
        docArrayList.add(c4);
        docArrayList.add(c5);
        docArrayList.add(c6);

        String docChannelString = "";
        int packagePrice = 0;

        //Iterating over docArrayList(Arraylist) to get their name,language and price
        for(int i = 0; i<docArrayList.size(); i++){
            docChannelString += "          "+docArrayList.get(i).getChannelName()
                               +"            "+docArrayList.get(i).getLanguage()
                               +"            "+docArrayList.get(i).getPrice()
                               +"\n";   //Creating a new line
            packagePrice += docArrayList.get(i).getPrice();   //Getting the individual price of documentary channel and adding them
        }
        //Displaying the docChannelString in the textarea
        channelsAreaDocumentaries.setText(docChannelString);
        return  packagePrice;

    }




    public static void main(String[] args) {

        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
        mainScreen.setBounds(20,10,1200,800);

    }

}
