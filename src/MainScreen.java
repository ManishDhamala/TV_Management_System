import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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

    JTextField subFirstname;
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

        // Making opacity for fields (Removing white color textField)
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

        // Make opacity for fields (Removing white color textField)
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
        Border panel3 = BorderFactory.createTitledBorder("Available Packages: ");
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



        // Adding panel to JFrame
        add(packagepanel);
        add(subscriberPanel);
        add(cyclePanel);
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
