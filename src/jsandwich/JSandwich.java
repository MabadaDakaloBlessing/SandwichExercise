import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JSandwich extends JFrame implements ActionListener
{
    String[] fillings = {"Chicken", "Beef", "Cheese"};
    double[] fillingPrices = {45.00, 55.00, 35.00};

    String[] breads = {"White Bread", "Brown Bread", "Rye Bread"};
    double[] breadPrices = {10.00, 12.00, 15.00};

    JList<String> fillingList;
    JList<String> breadList;

    JLabel totalLabel;

    public JSandwich()
    {
        setTitle("Sublime Sandwich Shop");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        fillingList = new JList<>(fillings);
        fillingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        breadList = new JList<>(breads);
        breadList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JButton calculateButton = new JButton("Calculate Price");
        calculateButton.addActionListener(this);

        totalLabel = new JLabel("Total Price: R0.00");

        add(new JLabel("Choose Sandwich Filling:"));
        add(new JScrollPane(fillingList));

        add(new JLabel("Choose Bread Type:"));
        add(new JScrollPane(breadList));

        add(calculateButton);
        add(totalLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int fillingIndex = fillingList.getSelectedIndex();
        int breadIndex = breadList.getSelectedIndex();

        if(fillingIndex == -1 || breadIndex == -1)
        {
            JOptionPane.showMessageDialog(null,
                    "Please select a filling and a bread type.");
        }
        else
        {
            double totalPrice =
                    fillingPrices[fillingIndex] + breadPrices[breadIndex];

            totalLabel.setText("Total Price: R" + totalPrice);
        }
    }

    public static void main(String[] args)
    {
        new JSandwich();
    }
}