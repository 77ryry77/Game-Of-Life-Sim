import java.awt.event.*;

public class TimerEventProcessor implements ActionListener{

    public void actionPerformed(ActionEvent e)
    {
        Life.addRands();
        Life.updateTiles();
        Life.window.repaint();
    }
}
