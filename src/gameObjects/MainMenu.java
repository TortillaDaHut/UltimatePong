package gameObjects;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JPanel {

    private PongGame pongGame;
    private JButton singlePlayerButton;
    private JButton multiplayerButton;
    private JLabel titleLabel;
    private JSlider ballSpeedSlider;

    public MainMenu(PongGame pongGame) {
        this.pongGame = pongGame;
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // Title label
        titleLabel = new JLabel("Ultimate Pong");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        buttonPanel.setOpaque(false);
        add(buttonPanel, BorderLayout.CENTER);

        // Create buttons
        singlePlayerButton = createButton("Single Player");
        singlePlayerButton.addActionListener(e -> startGame(true));
        buttonPanel.add(singlePlayerButton);

        multiplayerButton = createButton("Multiplayer");
        multiplayerButton.addActionListener(e -> startGame(false));
        buttonPanel.add(multiplayerButton);

        // Ball speed slider
        ballSpeedSlider = new JSlider(JSlider.HORIZONTAL, 1, 10, 5);
        ballSpeedSlider.setMajorTickSpacing(1);
        ballSpeedSlider.setPaintTicks(true);
        ballSpeedSlider.setPaintLabels(true);
        ballSpeedSlider.setOpaque(false);
        ballSpeedSlider.setForeground(Color.WHITE);
        ballSpeedSlider.setFont(new Font("Arial", Font.PLAIN, 16));
        add(ballSpeedSlider, BorderLayout.SOUTH);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 24));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(52, 152, 219)); // Button color
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(41, 128, 185)); // Hover color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(52, 152, 219)); // Default color
            }
        });
        return button;
    }

    private void startGame(boolean singlePlayer) {
        int ballSpeed = ballSpeedSlider.getValue();
        pongGame.initializeGame(singlePlayer, ballSpeed);

        // Find parent frame
        Component component = this;
        while (!(component instanceof JFrame) && component != null) {
            component = component.getParent();
        }
        if (component instanceof JFrame) {
            JFrame frame = (JFrame) component;
            frame.getContentPane().removeAll();
            frame.getContentPane().add(pongGame);
            frame.revalidate();
            frame.repaint();
            pongGame.startGame();
        } else {
            System.err.println("Unable to find the parent frame.");
        }
    }
}
