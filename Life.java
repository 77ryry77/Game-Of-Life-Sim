import javax.swing.JFrame;
import javax.swing.Timer;

public class Life {

    public static JFrame window;
    public static final int XCOUNT = 100;
    public static final int YCOUNT = 100;
    public static boolean tiles[][] = new boolean[YCOUNT][XCOUNT];
    public static boolean preState[][];
    public static boolean prepreState[][];
    public static final int WIDTH = 1600;
    public static final int HEIGHT = 800;
    public static Timer timer;
    public static void main(String[] args) {
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WIDTH, HEIGHT);
        window.setResizable(false);
        window.setContentPane(new ContentPane());
        timer = new Timer(40, new TimerEventProcessor());
        timer.start();
        window.setLocation(10, 10);
        window.setVisible(true);
        reset();
    }

    public static void reset()
    {
        tiles = new boolean[YCOUNT][XCOUNT];
        for(int i = 0; i < YCOUNT; i++)
        {
            for(int j = 0; j < XCOUNT; j ++)
            {
                tiles[i][j] = false;
            }
        }
        /*random
        for(int i = 0; i < XCOUNT * YCOUNT / 2; i ++)
        {
            tiles[(int)(Math.random() * (YCOUNT - 50)) + 50][(int)(Math.random() * XCOUNT)] = true;
        }*/


        /*
        //glider creators
        int multiply = -1;
        int offset = 99;
        tiles[5][1 * multiply + offset] = true;tiles[5][2 * multiply + offset] = true;tiles[6][1 * multiply + offset] = true;tiles[6][2 * multiply + offset] = true;

        tiles[5][11 * multiply + offset] = true;tiles[6][11 * multiply + offset] = true;tiles[7][11 * multiply + offset] = true;tiles[4][12 * multiply + offset] = true;tiles[3][13 * multiply + offset] = true;tiles[8][12 * multiply + offset] = true;tiles[9][13 * multiply + offset] = true;tiles[9][14 * multiply + offset] = true;tiles[3][14 * multiply + offset] = true;tiles[6][15 * multiply + offset] = true;tiles[4][16 * multiply + offset] = true;tiles[8][16 * multiply + offset] = true;tiles[5][17 * multiply + offset] = true;tiles[7][17 * multiply + offset] = true;tiles[6][17 * multiply + offset] = true;tiles[6][18 * multiply + offset] = true;

        tiles[5][21 * multiply + offset] = true;tiles[4][21 * multiply + offset] = true;tiles[3][21 * multiply + offset] = true;tiles[5][22 * multiply + offset] = true;tiles[4][22 * multiply + offset] = true;tiles[3][22 * multiply + offset] = true;tiles[2][23 * multiply + offset] = true;tiles[6][23 * multiply + offset] = true;tiles[2][25 * multiply + offset] = true;tiles[6][25 * multiply + offset] = true;tiles[1][25 * multiply + offset] = true;tiles[7][25 * multiply + offset] = true;

        tiles[3][35 * multiply + offset] = true;tiles[3][36 * multiply + offset] = true;tiles[4][35 * multiply + offset] = true;tiles[4][36 * multiply + offset] = true;

        tiles[5][1 * multiply + offset] = true;tiles[5][2 * multiply + offset] = true;tiles[6][1 * multiply + offset] = true;tiles[6][2 * multiply + offset] = true;

        tiles[5][11 * multiply + offset] = true;tiles[6][11 * multiply + offset] = true;tiles[7][11 * multiply + offset] = true;tiles[4][12 * multiply + offset] = true;tiles[3][13 * multiply + offset] = true;tiles[8][12 * multiply + offset] = true;tiles[9][13 * multiply + offset] = true;tiles[9][14 * multiply + offset] = true;tiles[3][14 * multiply + offset] = true;tiles[6][15 * multiply + offset] = true;tiles[4][16 * multiply + offset] = true;tiles[8][16 * multiply + offset] = true;tiles[5][17 * multiply + offset] = true;tiles[7][17 * multiply + offset] = true;tiles[6][17 * multiply + offset] = true;tiles[6][18 * multiply + offset] = true;

        tiles[5][21 * multiply + offset] = true;tiles[4][21 * multiply + offset] = true;tiles[3][21 * multiply + offset] = true;tiles[5][22 * multiply + offset] = true;tiles[4][22 * multiply + offset] = true;tiles[3][22 * multiply + offset] = true;tiles[2][23 * multiply + offset] = true;tiles[6][23 * multiply + offset] = true;tiles[2][25 * multiply + offset] = true;tiles[6][25 * multiply + offset] = true;tiles[1][25 * multiply + offset] = true;tiles[7][25 * multiply + offset] = true;

        tiles[3][35 * multiply + offset] = true;tiles[3][36 * multiply + offset] = true;tiles[4][35 * multiply + offset] = true;tiles[4][36 * multiply + offset] = true;
        
        multiply = 1;
        offset = 0;
        tiles[5][1 * multiply + offset] = true;tiles[5][2 * multiply + offset] = true;tiles[6][1 * multiply + offset] = true;tiles[6][2 * multiply + offset] = true;tiles[5][11 * multiply + offset] = true;tiles[6][11 * multiply + offset] = true;tiles[7][11 * multiply + offset] = true;tiles[4][12 * multiply + offset] = true;tiles[3][13 * multiply + offset] = true;tiles[8][12 * multiply + offset] = true;tiles[9][13 * multiply + offset] = true;tiles[9][14 * multiply + offset] = true;tiles[3][14 * multiply + offset] = true;tiles[6][15 * multiply + offset] = true;tiles[4][16 * multiply + offset] = true;tiles[8][16 * multiply + offset] = true;tiles[5][17 * multiply + offset] = true;tiles[7][17 * multiply + offset] = true;tiles[6][17 * multiply + offset] = true;tiles[6][18 * multiply + offset] = true;        tiles[5][21 * multiply + offset] = true;tiles[4][21 * multiply + offset] = true;tiles[3][21 * multiply + offset] = true;tiles[5][22 * multiply + offset] = true;tiles[4][22 * multiply + offset] = true;tiles[3][22 * multiply + offset] = true;tiles[2][23 * multiply + offset] = true;tiles[6][23 * multiply + offset] = true;tiles[2][25 * multiply + offset] = true;tiles[6][25 * multiply + offset] = true;tiles[1][25 * multiply + offset] = true;tiles[7][25 * multiply + offset] = true;        tiles[3][35 * multiply + offset] = true;tiles[3][36 * multiply + offset] = true;tiles[4][35 * multiply + offset] = true;tiles[4][36 * multiply + offset] = true;tiles[5][1 * multiply + offset] = true;tiles[5][2 * multiply + offset] = true;tiles[6][1 * multiply + offset] = true;tiles[6][2 * multiply + offset] = true;tiles[5][11 * multiply + offset] = true;tiles[6][11 * multiply + offset] = true;tiles[7][11 * multiply + offset] = true;tiles[4][12 * multiply + offset] = true;tiles[3][13 * multiply + offset] = true;tiles[8][12 * multiply + offset] = true;tiles[9][13 * multiply + offset] = true;tiles[9][14 * multiply + offset] = true;tiles[3][14 * multiply + offset] = true;tiles[6][15 * multiply + offset] = true;tiles[4][16 * multiply + offset] = true;tiles[8][16 * multiply + offset] = true;tiles[5][17 * multiply + offset] = true;tiles[7][17 * multiply + offset] = true;tiles[6][17 * multiply + offset] = true;tiles[6][18 * multiply + offset] = true;        tiles[5][21 * multiply + offset] = true;tiles[4][21 * multiply + offset] = true;tiles[3][21 * multiply + offset] = true;tiles[5][22 * multiply + offset] = true;tiles[4][22 * multiply + offset] = true;tiles[3][22 * multiply + offset] = true;tiles[2][23 * multiply + offset] = true;tiles[6][23 * multiply + offset] = true;tiles[2][25 * multiply + offset] = true;tiles[6][25 * multiply + offset] = true;tiles[1][25 * multiply + offset] = true;tiles[7][25 * multiply + offset] = true;        tiles[3][35 * multiply + offset] = true;tiles[3][36 * multiply + offset] = true;tiles[4][35 * multiply + offset] = true;tiles[4][36 * multiply + offset] = true;
        */
        /*
        //alternating  shapes
        
        tiles[3][1] = true;tiles[3][2] = true;tiles[3][3] = true;tiles[2][2] = true;tiles[2][3] = true;tiles[2][4] = true;
        */
    }

    public static void updateTiles()
    {
        boolean[][] r = new boolean[YCOUNT][XCOUNT];
        for(int i = 0; i < YCOUNT; i ++)
        {
            for(int j = 0; j < XCOUNT; j ++)
            {
                if (tiles[i][j] == true && (countNeighbors(i, j) == 3 || countNeighbors(i, j) == 2))
                {
                    r[i][j] = true;
                }
                else if(tiles[i][j] == false && countNeighbors(i, j) == 3)
                {
                    r[i][j] = true;
                }
                else
                {
                    r[i][j] = false;
                }
            }
        }
        tiles = r;
    }

    private static int countNeighbors(int i, int j)
    {
        int count = 0;
        for (int k = i - 1; k < i + 2; k ++)
        {
            for (int l = j - 1; l < j + 2; l ++)
            {  
                if(!(i == k && l == j))
                {
                    if(k >= 0 && l >= 0 && k < YCOUNT && l < XCOUNT)
                        if(tiles[k][l] == true)
                            count ++;
                }
            }
        }
        return count;
    }

    private static int frameCounter = 0;
    public static void addRands()
    {
        if(frameCounter == 12)
        {
            for(int i = 0; i < XCOUNT * YCOUNT / 6; i ++)
                tiles[(int)(Math.random() * YCOUNT)][(int)(Math.random() * XCOUNT)] = true;
            frameCounter = 0;
        }
        else
            frameCounter ++;
    }
}