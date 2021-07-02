import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;


public class ContentPane extends JPanel{

    private static int tileWidth;
    private static int tileHeight;

    public ContentPane()
    {
        super(null, true);
        tileWidth = Life.WIDTH / Life.XCOUNT;
        tileHeight = Life.HEIGHT / Life.YCOUNT;
    }

    protected void paintComponent(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Life.WIDTH, Life.HEIGHT);

        g.setColor(Color.WHITE);
        for(int i = 0; i < Life.YCOUNT; i ++)
        {
            for(int j = 0; j < Life.XCOUNT; j ++)
            {
                if(Life.tiles[i][j])
                {
                    g.fillRect(j * tileWidth, i * tileHeight, tileWidth, tileHeight);
                }
            }
        }
        if(Life.YCOUNT <= 200)
        {
            g.setColor(Color.GRAY);
            for(int i = 0; i < Life.YCOUNT; i ++)
            {
                for(int j = 0; j < Life.XCOUNT; j ++)
                {
                    g.drawRect(j * tileWidth, i * tileHeight, tileWidth, tileHeight);
                }
            }
        }
    }
}
