package component.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import component.view.GameView;
import component.view.MyPanel;

import javax.swing.*;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import static component.utils.Constant.MISSING_PIECE;

public class Game {
    GameView gameView;
    boolean gameFinished = false;

    public Game() throws IOException {
        gameView = new GameView();
        ObjectMapper objectMapper = new ObjectMapper();
        Board board = objectMapper.readValue(new File("C:\\Users\\Notebook\\IdeaProjects\\AP2024-HW4-0.0.2\\src\\main1\\java\\component\\utils\\Info.json"), Board.class);
        Collections.shuffle(board.piecesRandomOrder);
        for (int i = 0; i < board.piecesRandomOrder.size(); i++)
            if (board.piecesRandomOrder.get(i) == 8)
                gameView.panel.setMissingPiece(i);
        if (!Board.solvable(MISSING_PIECE, board.piecesRandomOrder)) {
            JOptionPane.showMessageDialog(gameView.frame, "this puzzle is not solvable, change your config and try again", "Puzzle not solvable", JOptionPane.WARNING_MESSAGE);
            gameFinished = true;
        }
        for (int i = 0; i < 9; i++) {
            System.out.println(i + " " + board.piecesRandomOrder.get(i));
            if (MISSING_PIECE != i) {
                board.puzzlePieces.add(new PuzzlePiece(board.piecesRandomOrder.get(i) + 1 + ".png", new Location(gameView.panel.getHeight() / 3 * (i % 3), gameView.panel.getWidth() / 3 * (i / 3))));
            } else {
                board.puzzlePieces.add(new PuzzlePiece("missing.jpg", new Location(gameView.panel.getHeight() / 3 * (i % 3), gameView.panel.getWidth() / 3 * (i / 3))));
            }
        }
        gameView.panel.setPuzzlePieces(board.puzzlePieces);

        while (true) {
            try {
                // TODO: CHANGE THIS FOR IMPROVING YOUR FRAME RATE... (OPTIONAL)
                Thread.sleep(1000 / 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            gameView.panel.repaint();
            gameView.frame.repaint();

            if (gameFinished) {
                break;
            }

            if (gameView.panel.gameState.equals("finished")) {
                JOptionPane.showMessageDialog(gameView.frame, "You finished the game, congratulation", "Game Finished", JOptionPane.INFORMATION_MESSAGE);
//                gameFinished = true;
                MyPanel.getInstance().gameState = "#";
                gameView.frame.dispose();
                new Game();
//                gameFinished = false;

            }
        }
    }


}
