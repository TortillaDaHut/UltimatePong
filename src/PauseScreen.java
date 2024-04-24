package gameObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseScreen extends JPanel {

    private PongGame pongGame;

    public PauseScreen(PongGame pongGame) {
        this.pongGame = pongGame;
        setLayout(new BorderLayout());

        // Add a panel for the center area to contain the "Game Paused" text
        JPanel centerPanel = new JPanel(new GridBagLayout());
        add(centerPanel, BorderLayout.CENTER);

        // Add a label for "Game Paused"
        JLabel pausedLabel = new JLabel("Game Paused", SwingConstants.CENTER);
        pausedLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Customize font if needed
        centerPanel.add(pausedLabel);

        // Add a panel for the buttons at the top
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(buttonPanel, BorderLayout.NORTH);

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(e -> restartGame());
        buttonPanel.add(restartButton);

        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.addActionListener(e -> returnToMainMenu());
        buttonPanel.add(mainMenuButton);
    }

    private void restartGame() {
        pongGame.restartGame();
    }

    private void returnToMainMenu() {
        pongGame.returnToMainMenu();
    }
}

