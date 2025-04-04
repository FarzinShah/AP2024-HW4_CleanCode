package component.view;

import component.controller.MyKeyListener;
import javax.swing.*;
import static component.utils.Constant.SCREEN_HEIGHT;
import static component.utils.Constant.SCREEN_WIDTH;

public class GameView {
    public JFrame frame = new JFrame();
    public MyPanel panel = MyPanel.getInstance();

    public GameView(){
        int maxSize = Math.max(SCREEN_WIDTH, SCREEN_HEIGHT) / 3;
        panel.setSize(maxSize, maxSize);
        panel.setLocation(SCREEN_WIDTH / 2 - maxSize / 2, SCREEN_HEIGHT / 2 - maxSize / 2);
        frame.setSize(panel.getSize());
        frame.setLocation(panel.getLocation());
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addKeyListener(new MyKeyListener());
        frame.setVisible(true);

    }
}
