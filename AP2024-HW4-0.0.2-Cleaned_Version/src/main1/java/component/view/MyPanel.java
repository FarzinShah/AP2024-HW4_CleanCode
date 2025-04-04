package component.view;

import component.model.PuzzlePiece;
import component.utils.Constant;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class MyPanel extends JPanel {
    public static MyPanel panelInstance;
    public ArrayList<PuzzlePiece> puzzlePieces = new ArrayList<>();
    public String gameState = "#";

    public MyPanel() {

    }

    public static MyPanel getInstance() {
        if (panelInstance == null) {
            panelInstance = new MyPanel();
            return panelInstance;
        }
        return panelInstance;
    }

    public void swapPieces(int i, int j) {
        PuzzlePiece copy = this.puzzlePieces.get(i).getClone();
        puzzlePieces.get(i).setImage(puzzlePieces.get(j).img);
        puzzlePieces.get(i).setPieceNumber(puzzlePieces.get(j).pieceNumber);
        puzzlePieces.get(j).setImage(copy.img);
        puzzlePieces.get(j).setPieceNumber(copy.pieceNumber);

        if (gameFinished()) {
            gameState = "finished";
        }
    }

    public boolean gameFinished() {
        for (int i = 0; i < 9; i++) {
            int pieceIdentifier = puzzlePieces.get(i).pieceNumber;
            if (pieceIdentifier == 8) {
                continue;
            }

            if (pieceIdentifier != i) {
                return false;
            }
        }
        return true;
    }

    public void setPuzzlePieces(ArrayList<PuzzlePiece> puzzlePieces) {
        this.puzzlePieces = puzzlePieces;
    }

    public void setMissingPiece(int missingPiece) {
        Constant.MISSING_PIECE = missingPiece;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (PuzzlePiece piece : puzzlePieces) {
            g.drawImage(piece.img, piece.location.x, piece.location.y, (int) this.getSize().getWidth() / 3, (int) this.getSize().getHeight() / 3, null);
        }
    }
}


