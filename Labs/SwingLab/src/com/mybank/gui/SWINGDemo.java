package com.mybank.gui;

import com.mybank.data.DataSource;
import com.mybank.domain.Account;
import com.mybank.domain.Bank;
import com.mybank.domain.CheckingAccount;
import com.mybank.domain.Customer;
import com.mybank.domain.SavingsAccount;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Alexander 'Taurus' Babich
 */
public class SWINGDemo {

    private final JEditorPane log;
    private final JButton show;
    private final JButton report;
    private final JComboBox clients;

    public SWINGDemo() {
        log = new JEditorPane("text/html", "");
        log.setPreferredSize(new Dimension(250, 200));

        show = new JButton("Show");
        report = new JButton("Report");
        clients = new JComboBox();
        for (int i = 0; i < Bank.getNumberOfCustomers(); i++) {
            clients.addItem(Bank.getCustomer(i).getLastName() + ", " + Bank.getCustomer(i).getFirstName());
        }

    }

    private void launchFrame() {
        JFrame frame = new JFrame("MyBank clients");
        frame.setLayout(new BorderLayout());
        JPanel cpane = new JPanel();
        cpane.setLayout(new GridLayout(1, 3));

        cpane.add(clients);
        cpane.add(show);
        cpane.add(report);
        frame.add(cpane, BorderLayout.NORTH);
        frame.add(new JScrollPane(log), BorderLayout.CENTER);

        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer current = Bank.getCustomer(clients.getSelectedIndex());
                String custInfo = customerToString(current);

                log.setText(custInfo);
            }

        });

        report.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String custInfo = "&nbsp;&nbsp;<h1>CUSTOMERS REPORT<br>&nbsp;&nbsp;================</h1>";
                for (int cust_idx = 0;
                        cust_idx < Bank.getNumberOfCustomers();
                        cust_idx++) {
                    Customer customer = Bank.getCustomer(cust_idx);
                    custInfo = custInfo + customerToString(customer);
                }

                log.setText(custInfo);
            }
        });

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private static String customerToString(Customer current) {
        String custInfo = "<br>&nbsp;<b><span style=\"font-size:2em;\">" + current.getLastName() + ", "
                + current.getFirstName() + "</span><br><hr>" + "&nbsp;";
        String accounts = "";
        for (int i = 0; i < current.getNumberOfAccounts(); i++) {
            Account account = current.getAccount(i);
            accounts = accounts + "<br><b>Acc Type: </b >"
                    + (account instanceof CheckingAccount ? "Checking" : "Savings")
                    + "<br>&nbsp;<b>Balance: <span style=\"color:red;\">$" + account.getBalance() + "</span></b>";
        }
        custInfo = custInfo + accounts;
        return custInfo;
    }

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.out.println("USAGE: java SWINGDemo <filename>");
            System.exit(0);
        }

        DataSource ds = new DataSource(args[0]);
        ds.loadData();

        SWINGDemo demo = new SWINGDemo();
        demo.launchFrame();
    }

}
