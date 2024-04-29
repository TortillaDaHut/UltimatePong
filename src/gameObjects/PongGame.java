package gameObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class PongGame extends JPanel {

    public AIPaddle aiPaddle;
    public PlayerPaddle playerPaddle;
    public Ball ball;
    private Timer timer;
    private long startTime; // Store the start time
    private long elapsedTime = 0; // Store the elapsed time
    private boolean paused = false; // Track pause state
    public boolean AIPlayer = true; // Set to false to enable two-player mode
    private PauseScreen pauseScreen;

    public PongGame() {
        setPreferredSize(new Dimension(GameObject.W, GameObject.H));
        setBackground(Color.BLACK);
        
        pauseScreen = new PauseScreen(this);
        pauseScreen.setVisible(false);
        add(pauseScreen);

        // Deferred call to showMainMenu after the panel is added to a JFrame whever
        SwingUtilities.invokeLater(this::showMainMenu);
        
    }

    private void showMainMenu() {
        MainMenu mainMenu = new MainMenu(this);
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.getContentPane().add(mainMenu); // Add MainMenu directly to the content pane
    }

    public void initializeGame(boolean singlePlayer) {
        AIPlayer = singlePlayer;

        aiPaddle = new AIPaddle(this, AIPlayer);
        add(aiPaddle);

        playerPaddle = new PlayerPaddle(this);
        add(playerPaddle);

        ball = new Ball(playerPaddle, aiPaddle, 0, 0);
    }

    public void startGame() {
        // Timer that triggers every 10 ms.
        timer = new Timer(10, new ActionListener() {

            @Override // this is the game loop
            public void actionPerformed(ActionEvent e) {
                updateGameState();
                repaint();
            }
        });

        timer.start(); // Start the timer

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                handleKeyRelease(e);
            }
        });

        setFocusable(true); // the two focus methods here are why I had to move the the controls out of the paddle classes to the PongGame class
        requestFocusInWindow();
        startTime = System.currentTimeMillis();
    }

    public void handleKeyPress(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_P) {
            togglePause(); // pauses the game
        } else if (!paused) { // prevents movement if the game is paused and penalizes pause buffering(type of cheating)
            if (keyCode == KeyEvent.VK_W) {
                playerPaddle.setUpPressed(true);
            } else if (keyCode == KeyEvent.VK_S) {
                playerPaddle.setDownPressed(true);
            } else if (keyCode == KeyEvent.VK_UP) {
                aiPaddle.setUpPressed(true);
            } else if (keyCode == KeyEvent.VK_DOWN) {
                aiPaddle.setDownPressed(true);
            }
        }
    }

    public void handleKeyRelease(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W) {
            playerPaddle.setUpPressed(false);
        } else if (keyCode == KeyEvent.VK_S) {
            playerPaddle.setDownPressed(false);
        } else if (keyCode == KeyEvent.VK_UP) {
            aiPaddle.setUpPressed(false);
        } else if (keyCode == KeyEvent.VK_DOWN) {
            aiPaddle.setDownPressed(false);
        }
    }

    private void togglePause() {
        paused =! paused; // Toggle the pause state
        if (paused) {
            pauseGame(); // Pause the timer
        } else {
            resumeGame(); // Resume the timer
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));

        if (!paused) {// Update elapsed time if game is not paused
            elapsedTime = System.currentTimeMillis() - startTime;
        }

        int seconds = (int) (elapsedTime / 1000);
        int minutes = seconds / 60;
        seconds %= 60;
        String timeStr = String.format("%02d:%02d", minutes, seconds);
        FontMetrics fontMetrics = g.getFontMetrics();
        int x = (getWidth() - fontMetrics.stringWidth(timeStr)) / 2;
        g.drawString(timeStr, x, 30);
        if (ball != null) { // because paintComponent can be called prior to the ball being initiallized this removes the errors from the log even though it would have no effect on gameplay 
        	g.drawString("Score: " + ball.score1, 20, 30);
        	g.drawString("Score: " + ball.score2, GameObject.W - 100, 30);
        	playerPaddle.updatePaddle();
        	aiPaddle.updateAIPaddle(ball);
        	ball.move();
        	ball.paint(g);
        	aiPaddle.paint(g);
        	playerPaddle.paints(g);
        }
    }

    private void updateGameState() {
        if (!paused) {
        	ball.move();
            playerPaddle.updatePaddle();
            aiPaddle.updateAIPaddle(ball);
        }
    }

    // Method to pause the game
    public void pauseGame() {
        timer.stop(); // Stop the timer
        pauseScreen.setVisible(true);
    }

    // Method to resume the game
    public void resumeGame() {
    	pauseScreen.setVisible(false);
        timer.start(); // Start the timer
    }
    
    public void restartGame() {
    	
    	ball.score1 = 0;
    	ball.score2 = 0;

    	int xSpeed = ball.getBallSpeedX();
    	int ySpeed = ball.getBallSpeedY();
    	ball.resetBall();
    	ball.setBallSpeedX(xSpeed);
    	ball.setBallSpeedY(ySpeed);

        startTime = System.currentTimeMillis();

    	paused = false;


        resumeGame();

    }
    
    public void returnToMainMenu() {
    	
    	remove(playerPaddle);
    	remove(aiPaddle);
    	remove(ball);

    	
    	paused = false;
    	
    	pauseScreen.setVisible(false);
    	
    	showMainMenu();
    	
    	addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                handleKeyRelease(e);
            }
        });
    }
    
    
}