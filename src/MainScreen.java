import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
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


        tableModel = new DefaultTableModel(); // Choosing deafult table model to manage the structure and data of table
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






        // Adding panel to JFrame
        add(subscriberPanel);  //Panel-1
        add(cyclePanel);       //Panel-2
        add(packagepanel);     //Panel-3
        add(detailsPanel);     //panel-4
        add(feePanel);         //panel-5
        add(customerTablePanel); //Panel-6
        setLayout(null); // null layout for jFrame

    }



    

    //Methods
    private void GetSubscriberData() {
    }
    private void DisplaySportsChannels() {
    }
    private void DisplayMoviesChannels() {
    }

    private void DisplayDocumentaryChannels() {
    }




    public static void main(String[] args) {

        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
        mainScreen.setBounds(100, 10, 1000, 800);

    }

}
