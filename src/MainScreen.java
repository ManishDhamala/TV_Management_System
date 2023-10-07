import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainScreen extends JFrame {

    JPanel subscriberPanel;

    JLabel subFirstnameLabel;
    JLabel subLastnamelabel;
    JLabel subMobileLabel;
    JLabel subCityLabel;

    JTextField subFirstname;
    JTextField subLastname;
    JTextField subMobile;
    JTextField subCity;

    // Constructor
    public MainScreen() {
        subscriberPanel = new JPanel();
        Border panel1 = BorderFactory.createTitledBorder("Subscriber details"); // Creating border with a title-header
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

        // Adding component to the panel1
        subscriberPanel.add(subFirstnameLabel);
        subscriberPanel.add(subFirstname);
        subscriberPanel.add(subLastnamelabel);
        subscriberPanel.add(subLastname);
        subscriberPanel.add(subMobileLabel);
        subscriberPanel.add(subMobile);
        subscriberPanel.add(subCityLabel);
        subscriberPanel.add(subCity);

        // Adding panel to JFrame
        add(subscriberPanel);
        setLayout(null); // null layout for jFrame


    }

    public static void main(String[] args) {

        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
        mainScreen.setBounds(100, 10, 1000, 800);

    }

}
