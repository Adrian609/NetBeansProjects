/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joesautomotive;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Arod6
 */
public class JoesAutomotive extends JFrame {

    private ServicesPanel services; //Topping panel

    private final GreetingPanel banner; //To display a greeting
    private JPanel buttonPanel; //to hold the buttons
    private JButton calcButton; //to calculate the cost
    private JButton exitButton; //to exist the application
    private final double TAX_RATE = 0.06; //Sales tax rate
    

    //constructor
    public JoesAutomotive() {
        //display a title.
        setTitle("Joes Automotive");

        //specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create a borderLyaout manager
        setLayout(new BorderLayout());

        //create the custom panels.
        banner = new GreetingPanel();

        services = new ServicesPanel();

        //create the button panel
        buildButtonPanel();

        //add the components to the content pane.
        add(banner, BorderLayout.NORTH);
        //add(bagels, BorderLayout.WEST);
        add(services, BorderLayout.CENTER);
        //add(coffee, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);

        //pack the contents of the window and display it.
        pack();
        setVisible(true);
    }

    //the buildButtonPanel method builds the button panel
    private void buildButtonPanel() {
        //create a panel for the buttons.
        buttonPanel = new JPanel();
        //create the buttons.
        calcButton = new JButton("Calculate");
        exitButton = new JButton("Exit");

        //Register the action listeners
        calcButton.addActionListener(new CalcButtonListener());
        exitButton.addActionListener(new ExitButtonListener());

        //add the buttons to the button panel
        buttonPanel.add(calcButton);
        buttonPanel.add(exitButton);
    }

    //private inner class that handles the event when the user clicks the calculate button.
    private class CalcButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //Cariables to hold the subtotal, tzx, and total
            double subtotal, tax, total;

            //calculate the subtotal.
            subtotal = services.getServicesCost();

            //calculate the sales tax
            tax = subtotal * TAX_RATE;

            //calculate total
            total = subtotal + tax;

            //display the charges
            JOptionPane.showMessageDialog(null, String.format("Subtotal:$%,.2f\n"
                    + "Tax: $%,.2f\n" + "Total:$%,.2f", subtotal, tax, total));

        }
    }

    //private inner class that handles the event when the user clicks the Exit button
    private class ExitButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    //main method
    public static void main(String[] args) {
        new JoesAutomotive();
    }
}
