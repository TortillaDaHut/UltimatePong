package gameObjects;

import javax.swing.*;
import java.awt.*;


public class MainMenu extends JPanel {

    private PongGame pongGame;
    private JButton singlePlayerButton;
    private JButton multiplayerButton;

    public MainMenu(PongGame pongGame) {
        this.pongGame = pongGame;
        setLayout(new GridLayout(2, 1)); // Two options vertically aligned

        singlePlayerButton = new JButton("Single Player");
        singlePlayerButton.addActionListener(e -> startGame(true)); // Lambda expression
        add(singlePlayerButton);

        multiplayerButton = new JButton("Multiplayer");
        multiplayerButton.addActionListener(e -> startGame(false)); // Lambda expression
        add(multiplayerButton);
    }

private void startGame(boolean singlePlayer) {
    pongGame.initializeGame(singlePlayer); // Initialize the game with the selected mode

    singlePlayerButton.setEnabled(false);
    multiplayerButton.setEnabled(false);

    // Remove the buttons from the main menu
    remove(singlePlayerButton);
    remove(multiplayerButton);

    // Remove the main menu components
    Container parent = getParent();
    if (parent != null && parent instanceof JFrame) {
        Container contentPane = ((JFrame) parent).getContentPane();
        if (contentPane != null) {
            contentPane.remove(this);
            contentPane.revalidate();
            contentPane.repaint();
        }
    }

    // Add the game panel to the frame
    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
    if (frame != null) {
        frame.getContentPane().add(pongGame);
        frame.revalidate();
        frame.repaint();

        // Start the game
        pongGame.startGame();
    } else {
        System.err.println("Unable to find the parent frame.");
    }
}
}