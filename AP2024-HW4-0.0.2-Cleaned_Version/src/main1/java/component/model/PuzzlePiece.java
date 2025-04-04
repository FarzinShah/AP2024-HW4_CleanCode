package component.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PuzzlePiece {
    public Image img;
    public int pieceNumber;
    public Location location;
    Gson gson = new Gson();

    public PuzzlePiece(String imageName) throws IOException {
//        Gson gson = new Gson();


        try {
            img = ImageIO.read(new File("src/main1/java/assets/" + imageName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!imageName.equals("missing.jpg")) {
            pieceNumber = Integer.parseInt(imageName.substring(0, 1)) - 1;
        } else {
            pieceNumber = 8;
        }
    }

    public PuzzlePiece(String ImagePath, Location location) throws IOException {
        this(ImagePath);
        this.location = location;
    }

    public PuzzlePiece(Image img, Location location, int pieceIdentifier) {
        this.img = img;
        this.location = location;
        this.pieceNumber = pieceIdentifier;
    }

    public void setPieceNumber(int pieceNumber) {
        this.pieceNumber = pieceNumber;
    }

    public void setImage(Image img) {
        this.img = img;
    }

    public PuzzlePiece getClone() {
        PuzzlePiece clone = new PuzzlePiece(img, location, pieceNumber);
        return clone;
    }
}