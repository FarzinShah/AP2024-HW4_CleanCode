package component.controller;

import component.view.MyPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static component.utils.Constant.MISSING_PIECE;

public class MyKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

        int missingPieceIndex = MISSING_PIECE;
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (missingPieceIndex % 3 == 2) {
                return;
            }
            MyPanel.getInstance().swapPieces(missingPieceIndex, missingPieceIndex + 1);
            MyPanel.getInstance().setMissingPiece(missingPieceIndex + 1);
            System.out.println("???????");
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            if (missingPieceIndex % 3 == 0) {
                return;
            }
            MyPanel.getInstance().swapPieces(missingPieceIndex, missingPieceIndex - 1);
            MyPanel.getInstance().setMissingPiece(missingPieceIndex - 1);
            System.out.println("???????");

        } else if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
            if (missingPieceIndex <= 2) {
                return;
            }
            MyPanel.getInstance().swapPieces(missingPieceIndex, missingPieceIndex - 3);
            MyPanel.getInstance().setMissingPiece(missingPieceIndex - 3);
            System.out.println("???????");

        } else if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            if (missingPieceIndex >= 6) {
                return;
            }
            MyPanel.getInstance().swapPieces(missingPieceIndex, missingPieceIndex + 3);
            MyPanel.getInstance().setMissingPiece(missingPieceIndex + 3);
            System.out.println("???????");

        }

        if (MyPanel.getInstance().gameState.equals("finished")) {
            return;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
