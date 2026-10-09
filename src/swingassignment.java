import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// Inheritance: ColorPanel extends JPanel
class ColorPanel extends JPanel {

    // Constructor
    public ColorPanel(Color background) {
        super(new BorderLayout());
        setBackground(background);
    }
}

public class swingassignment {

    private JFrame frame;
    private ColorPanel panel;
    private JLabel label;
    private JButton button;
    private int clickCount = 0;

    private final Color[] colors = {
            Color.LIGHT_GRAY, Color.CYAN, Color.PINK, Color.YELLOW, Color.RED
    };

    // Constructor
    public swingassignment() {
        frame = new JFrame();
        panel = new ColorPanel(Color.LIGHT_GRAY);


        label = new JLabel("Welcome to Java Swing First Individual Assignment by Ramatu");
        label.setFont(new Font("Tahoma", Font.BOLD, 18));

        button = new JButton("Change Text & Color");
        button.addActionListener((ActionEvent e) -> {
            clickCount++;
            label.setText("You clicked the button " + clickCount + " time(s)!");
            panel.setBackground(colors[clickCount % colors.length]);
        });

        JPanel buttonHolder = new JPanel(new GridBagLayout());
        buttonHolder.setOpaque(false);
        buttonHolder.add(button);

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(30, 10, 10,10));

        panel.add(label, BorderLayout.NORTH);
        panel.add(buttonHolder, BorderLayout.CENTER);
        frame.add(panel);

        frame.setTitle("Java Swing Assignment");
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ImageIcon icon = new ImageIcon("icon.png");
        frame.setIconImage(icon.getImage());

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(swingassignment::new);
    }
}
