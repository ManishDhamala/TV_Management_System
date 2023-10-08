import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
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

        // Adding panel to JFrame
        add(subscriberPanel);
        add(cyclePanel);
        setLayout(null); // null layout for jFrame

    }

    public static void main(String[] args) {

        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
        mainScreen.setBounds(100, 10, 1000, 800);

    }

}
