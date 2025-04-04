package component.model;

import javax.net.ssl.SSLContext;
import java.util.ArrayList;
import java.util.Arrays;

public class Board {
//    ArrayList<Integer> piecesRandomOrder = new ArrayList<>(Arrays.asList(0,7, 1, 8, 3, 2, 6, 5, 4));
    ArrayList<PuzzlePiece> puzzlePieces = new ArrayList<>();
    public ArrayList<String> list_of_images;
    public ArrayList<Integer> piecesRandomOrder;


    public Board(){

    }

    public Board(ArrayList<String> a, ArrayList<Integer> b){
        list_of_images = new ArrayList<>();
        piecesRandomOrder = b;


    }



    public static boolean solvable(int missingPiece, ArrayList<Integer> piecesOrder) {
        int inversionCount = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (piecesOrder.get(i) > piecesOrder.get(j)) {
                    inversionCount += 1;
                }
            }
        }

        int parity = inversionCount % 2;
        int distanceOfMissingPiece = (2 - (missingPiece % 3)) + (2 - (missingPiece / 3));

        parity ^= (distanceOfMissingPiece % 2);
        if (parity == 0) {
            return true;
        }
        return false;
    }
}
