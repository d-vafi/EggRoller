import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUInterface {
    // default constructor
    private int modifier;

    public int getModifier() {
        return modifier;
    }

    public GUInterface() {
        // empty constructor
    }

    // constructor with image path as string parameter
    public GUInterface(int dice, String imagePath) {
        JFrame frame = new JFrame("DnD Roller");

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(frame);

        // Top row
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(100, 50, 50, 50));
        JLabel numberLabel = new JLabel("Number");
        topPanel.add(numberLabel, BorderLayout.CENTER);
        frame.add(topPanel, BorderLayout.NORTH);

        // Center row
        JPanel centerPanel = new JPanel(new FlowLayout());
        JLabel modifierLabel = new JLabel("Modifier");
        modifierLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        JSpinner spinner = new JSpinner();
        spinner.setValue(0);
        spinner.addChangeListener(e -> {
            modifier = (int) spinner.getValue();
        });
        JButton rollButton = new JButton("ROLL");
        centerPanel.add(modifierLabel);
        centerPanel.add(spinner);
        centerPanel.add(rollButton);
        frame.add(centerPanel, BorderLayout.CENTER);

        // on ROLL, generate random number and display in table
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // dice from DiceSelector > WhichDice.java, modifier from spinner input
                int result_roll = generateDice(dice, modifier);

                numberLabel.setText("Result: " + result_roll);
                numberLabel.setFont(new Font("Arial", Font.PLAIN, 28));
            }
        });

        // Bottom row
        JPanel bottomPanel = new JPanel(new FlowLayout());
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));
        JLabel imageLabel = new JLabel(imageIcon);
        bottomPanel.add(imageLabel);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public int generateDice(int dice, int modifier) {
        // generate random number from 0 to 'dice', decided beforehand from the link
        int dRoll = (int) (Math.random() * dice) + 1;
        System.out.println("Result: " + dRoll + " (+  " + modifier + ")");
        dRoll += modifier;

        return dRoll;

    }

}
