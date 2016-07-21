package gui;

import com.company.ToastMessage;
import controller.CompaniesController;
import controller.FlightsController;
import models.Company;
import models.Flight;
import models.Vip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
    private JTextField depJTextField = new HintTextField("Name of the city");
    private JLabel arrJLabel = new JLabel("Arr: ");
    private JTextField arrJTextField = new HintTextField("Name of the city");

    /*
   * classOfTicket
   * */
    private JPanel classOfTicketJPanel = new JPanel(new FlowLayout());
    private JLabel classOfTicketHeaderJLabel = new JLabel("Class of ticket: ");
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

    /*
    * result
    * */
    private JPanel resultTableJPanel = new JPanel(new FlowLayout());

    /*
    * TwoWay*/
    private JComboBox oneWayJComboBox;
    private JLabel oneWayJLabel = new JLabel("One Way: ");
    private JPanel oneWayJPanel = new JPanel(new FlowLayout());

    /*
    * TwoWay*/
    private JComboBox twoWayJComboBox;
    private JLabel twoWayJLabel = new JLabel("Two Way: ");
    private JPanel twoWayJPanel = new JPanel(new FlowLayout());

    /*
    * Button
    * */
    private JButton buyJButton = new JButton("Buy");


    /*
    * vars
    * */
    private final float PRICE_PERCENT = 0.1f;
    private String dep;
    private String arr;
    private boolean isOneWay = true;
    private boolean oneWay = true;
    private FlightsController flightsController = new FlightsController("flights_list.txt");
    private List<Flight> oneWayList = new ArrayList<>();
    private List<Flight> twoWayList = new ArrayList<>();


    public Gui() {

        initGui();
    }

    private void initGui() {

        setLayout(new BorderLayout());

        setSize(new Dimension(1600, 500));

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

//        /*
//        * Class
//        * */
//        classOfTicketJPanel.setPreferredSize(new Dimension(400, 30));
//        classOfTicketJPanel.add(classOfTicketHeaderJLabel);
//
//        classOfTicketButtonsGroup.add(vipJRadioButton);
//        classOfTicketButtonsGroup.add(standardJRadioButton);
//        classOfTicketJPanel.add(vipJRadioButton);
//        classOfTicketJPanel.add(standardJRadioButton);
//
//        filterJPanel.add(classOfTicketJPanel);

        /*
        * type of ticket
        * */
        typeOfTicketJPanel.setPreferredSize(new Dimension(400, 30));
        typeOfTicketJPanel.add(typeOfTicketHeaderJLabel);

        oneWayJRadioButton.setSelected(true);
        ticketTypeButtonsGroup.add(oneWayJRadioButton);
        ticketTypeButtonsGroup.add(twoWayJRadioButton);
        typeOfTicketJPanel.add(oneWayJRadioButton);
        typeOfTicketJPanel.add(twoWayJRadioButton);

        filterJPanel.add(typeOfTicketJPanel);
        filterJPanel.add(searchJButton);

        add(filterJPanel, BorderLayout.WEST);

        /*
        * setOnClick
        * */
        searchJButton.addActionListener(this);
        buyJButton.addActionListener(this);

        /*
        * Result panel
        * */
        resultTableJPanel.setPreferredSize(new Dimension(1200, 500));
        oneWayJPanel.setPreferredSize(new Dimension(1200, 50));
        twoWayJPanel.setPreferredSize(new Dimension(1200, 50));

        resultTableJPanel.add(oneWayJPanel);
        resultTableJPanel.add(twoWayJPanel);
        add(resultTableJPanel, BorderLayout.EAST);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == searchJButton) {

            logic();
        }
        if (e.getSource() == buyJButton) {

            buy();
        }
    }

    private void logic() {

        dep = depJTextField.getText();
        arr = arrJTextField.getText();
        oneWay = oneWayJRadioButton.isSelected();
        flightsController.init();

        if (dep.equals("")) {
            new ToastMessage("Departure box is empty", 5000).setVisible(true);
            return;
        }

        if (arr.equals("")) {
            new ToastMessage("Arrival box is empty", 5000).setVisible(true);
            return;
        }

        if (oneWay) {

            oneWayList = new ArrayList<>();
            oneWayList = flightsController.getListByParams(dep, arr);

            if (oneWayList.size() != 0) {

                /*
                * oneWay
                * */
                oneWayJComboBox = new JComboBox(parseListToArray(oneWayList));

                oneWayJPanel.removeAll();
                oneWayJPanel.add(oneWayJLabel);
                oneWayJPanel.add(oneWayJComboBox);
                resultTableJPanel.add(oneWayJPanel);
                resultTableJPanel.add(buyJButton);


                validate();
                repaint();
            }
        } else {

            oneWayList = new ArrayList<>();
            twoWayList = new ArrayList<>();

            oneWayList = flightsController.getListByParams(dep, arr);
            twoWayList = flightsController.getListByParams(arr, dep);

            if (oneWayList.size() != 0) {

                if (twoWayList.size() != 0) {
                /*
                * oneWay
                * */

                    oneWayJComboBox = new JComboBox(parseListToArray(oneWayList));

                    oneWayJPanel.removeAll();
                    oneWayJPanel.add(oneWayJLabel);
                    oneWayJPanel.add(oneWayJComboBox);
                    resultTableJPanel.add(oneWayJPanel);

                /*
                * twoWay
                * */
                    twoWayJComboBox = new JComboBox(parseListToArray(twoWayList));

                    twoWayJPanel.removeAll();
                    twoWayJPanel.add(twoWayJLabel);
                    twoWayJPanel.add(twoWayJComboBox);
                    resultTableJPanel.add(twoWayJPanel);
                    resultTableJPanel.add(buyJButton);

                    validate();
                    repaint();
                } else {
                    new ToastMessage("Obratnij chka", 5000).setVisible(true);
                }
            } else {
                new ToastMessage("Tuda chka", 5000).setVisible(true);
            }
        }
    }

    private void buy() {

        String name = JOptionPane.showInputDialog(null, "What's your name?");

        isOneWay = oneWayJRadioButton.isSelected();


        if (isOneWay) {
            int oneWaySelectedItemIndex = oneWayJComboBox.getSelectedIndex();
            Flight oneWayFlight = oneWayList.get(oneWaySelectedItemIndex);
            String oneWayCompanyName = oneWayFlight.getCompanyName();
            float oneWayPrice = oneWayFlight.getCost();

            CompaniesController companiesController = new CompaniesController();
            List<Company> companiesList = companiesController.init();

            String externalMessage = "";
            for (Company company : companiesList) {

                if (company.getName().equals(oneWayCompanyName)) {

                    List<Vip> vipList = company.getVipsList();
                    for (int i = 0; i < vipList.size(); i++) {

                        if (vipList.get(i).getFullName().equals(name)) {

                            oneWayPrice = oneWayPrice - (oneWayPrice * PRICE_PERCENT);
                            externalMessage = " Ha hamel asem vor du vip es u qez hamar 10% zexch enq arel.";
                            break;
                        }
                    }
                    break;
                }
            }
            String message = "Urax xaci arel es hahhahahahahahahaha." + externalMessage + "Yndhanur caxsele es esqan " + oneWayPrice;
            new ToastMessage(message, 5000).setVisible(true);

        } else {

            int oneWaySelectedItemIndex = oneWayJComboBox.getSelectedIndex();
            int twoWaySelectedItemIndex = twoWayJComboBox.getSelectedIndex();

            Flight oneWayFlight = oneWayList.get(oneWaySelectedItemIndex);
            String oneWayCompanyName = oneWayFlight.getCompanyName();
            float oneWayPrice = oneWayFlight.getCost();

            Flight twoWayFlight = oneWayList.get(twoWaySelectedItemIndex);
            String twoWayCompanyName = twoWayFlight.getCompanyName();
            float twoWayPrice = twoWayFlight.getCost();
//        if (!oneWayCompanyName.equals(twoWayCompanyName)) {
//            JOptionPane.showMessageDialog(null, "Tomsy petqa nuyn kampaniaic arneq");
//            return;
//        }
            float priceSum = oneWayPrice + twoWayPrice;

            CompaniesController companiesController = new CompaniesController();
            List<Company> companiesList = companiesController.init();

            String externalMessage = "";
            for (Company company : companiesList) {

                if (company.getName().equals(oneWayCompanyName)) {

                    List<Vip> vipList = company.getVipsList();
                    for (int i = 0; i < vipList.size(); i++) {

                        if (vipList.get(i).getFullName().equals(name)) {

                            priceSum = priceSum - (priceSum * PRICE_PERCENT);
                            externalMessage = " Ha hamel asem vor du vip es u qez hamar 10% zexch enq arel.";
                            break;
                        }
                    }
                    break;
                }
            }

            String message = "Urax xaci arel es hahhahahahahahahaha." + externalMessage + "Yndhanur caxsele es esqan " + priceSum;
            new ToastMessage(message, 5000).setVisible(true);
        }
    }

    private String[] parseListToArray(List<Flight> flights) {
        String[] oneWayArray = new String[flights.size()];
        for (int i = 0; i < flights.size(); i++) {
            oneWayArray[i] = flights.get(i).toString();
        }
        return oneWayArray;
    }


    class HintTextField extends JTextField implements FocusListener {

        private final String hint;
        private boolean showingHint;

        public HintTextField(final String hint) {
            super(hint);
            this.hint = hint;
            this.showingHint = true;
            super.addFocusListener(this);
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (this.getText().isEmpty()) {
                super.setText("");
                showingHint = false;
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (this.getText().isEmpty()) {
                super.setText(hint);
                showingHint = true;
            }
        }

        @Override
        public String getText() {
            return showingHint ? "" : super.getText();
        }
    }
}
