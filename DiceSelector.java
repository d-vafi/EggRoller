import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiceSelector {
    private JFrame frame;
    private JButton[] buttons;
    private String[] imagePaths;
    private String[] diceNames = { "D4", "D6", "D8", "D10", "D12", "D20" };

    public DiceSelector() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        buttons = new JButton[6];

        imagePaths = new String[] { "images/d4.png", "images/d6.png", "images/d8.png", "images/d10.png",
                "images/d12.png", "images/d20.png" };
        frame.setLayout(new GridLayout(6, 3));

        for (int i = 0; i < 6; i++) {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePaths[i]));
            JButton button = new JButton("Open", imageIcon);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Determine which button was pressed
                    for (int j = 0; j < buttons.length; j++) {
                        if (e.getSource() == buttons[j]) {
                            // Show an output related to the button pressed
                            // Generate a random number based on the button pressed with corresponding image
                            switch (j) {
                                case 0:
                                    // dice 4
                                    new WhichDice(4, imagePaths[j]);
                                    break;
                                case 1:
                                    new WhichDice(6, imagePaths[j]);
                                    break;
                                case 2:
                                    new WhichDice(8, imagePaths[j]);
                                    break;
                                case 3:
                                    new WhichDice(10, imagePaths[j]);
                                    break;
                                case 4:
                                    new WhichDice(12, imagePaths[j]);
                                    break;
                                case 5:
                                    new WhichDice(20, imagePaths[j]);
                                    break;
                                default:
                                    break;
                            }// end of switch
                        }
                    }
                }
            });
            buttons[i] = button;
            frame.add(button);
            JLabel label = new JLabel(diceNames[i]);
            frame.add(label);
        }
        frame.pack();
        frame.setVisible(true);
    }

}