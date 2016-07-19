package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Hayk on 19.07.2016.
 */
public class Gui extends JFrame implements ActionListener {

    private JPanel filterJPanel = new JPanel(new FlowLayout());

    /*
    *  Dep
    *  Arr
    *  */
    private JPanel depArrJPanel = new JPanel(new FlowLayout());
    private JLabel depJLabel = new JLabel("Dep: ");
    private JTextField depJTextField = new JTextField(10);
    private JLabel arrJLabel = new JLabel("Arr: ");
    private JTextField arrJTextField = new JTextField(10);

    /*
   * classOfTicket
   * */
    private JPanel classOfTicketJPanel = new JPanel(new FlowLayout());
    private JLabel classOfTicketHeaderJLabel = new JLabel("Class of ticket");
    private ButtonGroup classOfTicketButtonsGroup = new ButtonGroup();
    private JRadioButton vipJRadioButton = new JRadioButton("VIP");
    private JRadioButton standardJRadioButton = new JRadioButton("Standard");

    /*
    *  typeOfTicket
    * */
    private JPanel typeOfTicketJPanel = new JPanel(new FlowLayout());
    private JLabel typeOfTicketHeaderJLabel = new JLabel("Type of ticket");
    private ButtonGroup ticketTypeButtonsGroup = new ButtonGroup();
    private JRadioButton oneWayJRadioButton = new JRadioButton("One Way");
    private JRadioButton twoWayJRadioButton = new JRadioButton("Two Way");

    /*
    * Button
    * */
    private JButton searchJButton = new JButton("Search");

    private JPanel resultTableJPanel = new JPanel(new FlowLayout());

    public Gui() {

        initGui();
    }

    private void initGui() {

        setLayout(new FlowLayout());

        setSize(new Dimension(800, 500));

        filterJPanel.setPreferredSize(new Dimension(400, 500));
        filterJPanel.setBackground(Color.lightGray);

        /*
        * Dep Arr
        * */
        depArrJPanel.setPreferredSize(new Dimension(400, 30));
        depArrJPanel.add(depJLabel);
        depArrJPanel.add(depJTextField);
        depArrJPanel.add(arrJLabel);
        depArrJPanel.add(arrJTextField);

        filterJPanel.add(depArrJPanel);

        /*
        * Class
        * */
        classOfTicketJPanel.setPreferredSize(new Dimension(400, 30));
        classOfTicketJPanel.add(classOfTicketHeaderJLabel);

        classOfTicketButtonsGroup.add(vipJRadioButton);
        classOfTicketButtonsGroup.add(standardJRadioButton);
        classOfTicketJPanel.add(vipJRadioButton);
        classOfTicketJPanel.add(standardJRadioButton);

        filterJPanel.add(classOfTicketJPanel);

        /*
        * type of ticket
        * */
        typeOfTicketJPanel.setPreferredSize(new Dimension(400, 30));
        typeOfTicketJPanel.add(typeOfTicketHeaderJLabel);

        ticketTypeButtonsGroup.add(oneWayJRadioButton);
        ticketTypeButtonsGroup.add(twoWayJRadioButton);
        typeOfTicketJPanel.add(oneWayJRadioButton);
        typeOfTicketJPanel.add(twoWayJRadioButton);

        filterJPanel.add(typeOfTicketJPanel);
        filterJPanel.add(searchJButton);

        add(filterJPanel);

        /*
        * setOnClick
        * */
        searchJButton.addActionListener(this);

        /*
        * Result panel
        * */
        resultTableJPanel.setPreferredSize(new Dimension(400, 500));
        resultTableJPanel.setBackground(Color.blue);

        add(resultTableJPanel);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == searchJButton) {

            System.out.println("clk");
        }
    }
}
