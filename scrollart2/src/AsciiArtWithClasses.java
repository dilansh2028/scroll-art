import java.util.Random;

// Elephant by Yiannis, Ice Cream by Ishaan, Rocket by Rayden

public class AsciiArtWithClasses {
    static final int width = getTerminalWidth();
    static final int ballx = 8;
    static final int bally = 8;
    static final int iceHeight = 6;
    static final int iceWidth = 8;
    static final int ELEPHANT_WIDTH = 20;
    static final int ELEPHANT_HEIGHT = 9;
    static final int ROCKET_WIDTH = 12;
    static final int ROCKET_HEIGHT = 16;
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        AsciiArt[] images = { new AsciiArt(getfootball()), new AsciiArt(getIceCream()),new AsciiArt(getElephant()), new AsciiArt(getRocket())};
        while(true){
            int arttype = rand.nextInt(images.length);
            AsciiArt art = images[arttype];
            int num = rand.nextInt(width-10);
            if(arttype == 2){
                num = rand.nextInt(width - 50);
            } else{
                num = rand.nextInt(width-10);
            }

            for (int y = 0; y < art.height; y=y+1){
                System.out.println();
                for(int i = 0; i < num; i++){
                    System.out.print(" ");
                }
                for (int x = 0; x <art.width; x++){
                    System.out.print(art.img[y][x]);
                } 
                
            }
            Thread.sleep(200);
            
    }

        
    }

    public static int getTerminalWidth() {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            return getUnixTerminalWidth();
        } else {
            return 80; 
        }
    }

    static char[][] getIceCream() {
        char[][] img = new char[iceHeight][iceWidth];

        // Meant to Fill  exmpty spaces
        for (int y = 0; y < iceHeight; y++) {
            for (int x = 0; x < iceWidth; x++) {
             img[y][x] = ' ';
            }
        }
        //Actual Ice Cream Art
        img[0][3] = '0';
        img[1][1] = '(';
        img[1][6] = ')';
        img[2][0] = '(';
        img[2][2] = '_';
        img[2][3] = '_';
        img[2][4] = '_';
        img[2][5] = '_';
        img[2][7] = ')';
        img[3][1] = '\\';
        img[3][6] = '/';
        img[4][2] = '\\';
        img[4][5] = '/';
        img[5][3] = '\\';
        img[5][4] = '/';

        return img;
    }
    static char[][] getElephant() {
        char[][] img = new char[ELEPHANT_HEIGHT][ELEPHANT_WIDTH];
        // fill with empty space
        for (int y = 0; y < ELEPHANT_HEIGHT; y++) {
            for (int x = 0; x < ELEPHANT_WIDTH; x++) {
                img[y][x] = ' ';
            }
        }
        // then fill individual characters
        img[0][14] = '_';
        img[1][5] = '(';
        img[1][6] = ')';
        img[1][13] = '|';
        img[1][14] = '~';
        img[1][15] = '|';
        img[2][4] = '/';
        img[2][5] = '|';
        img[2][6] = '|';
        img[2][7] = '\\';
        img[2][13] = '|';
        img[2][14] = '~';
        img[2][15] = '|';
        img[2][10] = '_';
        img[2][11] = '_';
        img[3][5] = '/';
        img[3][6] = '\\';
        img[3][9] = '/';
        img[3][12] = '\\';
        img[3][13] = '~';
        img[3][14] = '~';
        img[3][15] = '~';
        img[3][16] = '\\';
        img[2][17] = '_';
        img[2][18] = '_';
        img[3][19] = '\\';
        img[4][3] = ',';
        img[4][4] = '-';
        img[4][5] = '-';
        img[4][6] = '-';
        img[4][7] = '-';
        img[4][8] = '(';
        img[4][13] = '-';
        img[4][15] = '-';
        img[4][19] = ')';
        img[5][2] = '/';
        img[5][18] = '/';
        img[6][1] = '/';
        img[6][3] = '|';
        img[6][12] = '(';
        img[6][13] = '\\';
        img[6][16] = '|';
        img[6][17] = '(';
        img[7][0] = '^';
        img[7][3] = '\\';
        img[7][0] = '^';
        img[7][7] = '/';
        img[7][8] = '_';
        img[7][9] = '_';
        img[7][10] = '\\';
        img[7][13] = '/';
        img[7][14] = '\\';
        img[7][16] = '|';
        img[8][4] = '|';
        img[8][5] = '_';
        img[8][6] = '_';
        img[8][7] = '|';
        img[8][10] = '|';
        img[8][11] = '_';
        img[8][12] = '_';
        img[8][13] = '|';
        img[8][14] = '-';
        img[8][15] = '"';

        return img;
    }

    static char[][] getfootball() {
        char[][] img = new char[bally][ballx];
        // fill with empty space
        for (int y = 0; y < bally; y++) {
            for (int x = 0; x < ballx; x++) {
                img[y][x] = ' ';
            }
        }
        // then fill individual characters
        img[0][3] = '_';
        img[0][4] = '_';
        img[1][2] = '/';
        img[7][6] = 'D';
        img[7][7] = 'S';
        img[1][5] = '\\';
        img[2][1] = '(';
        img[2][6] = ')';
        img[3][0] = '(';
        img[3][2] = '+';
        img[3][3] = '+';
        img[3][4] = '+';
        img[3][5] = '+';
        img[3][7] = ')';
        img[4][0] = '(';
        img[4][7] = ')';
        img[5][1] = '(';
        img[5][6] = ')';
        img[6][2] = '\\';
        img[6][5] = '/';
        img[7][3] = '-';
        img[7][4] = '-';
        return img;
    }
    static char[][] getRocket() {
        char[][] img = new char[ROCKET_HEIGHT][ROCKET_WIDTH];
        // fill with empty space
        for (int y = 0; y < ROCKET_HEIGHT; y++) {
            for (int x = 0; x < ROCKET_WIDTH; x++) {
                img[y][x] = ' ';
            }
        }
        // then fill individual characters
        img[0][5] = '/';
        img[0][6] = '\\';
        img[1][4] = '/';
        img[1][7] = '\\';
        img[2][3] = '/';
        img[2][8] = '\\';
        img[3][2] = '/';
        img[3][9] = '\\';
        img[4][1] = '|';
        img[4][10] = '|';
        img[5][1] = '|';
        img[5][10] = '|';
        img[6][1] = '|';
        img[6][5] = 'R';
        img[6][6] = 'W';
        img[6][10] = '|';
        img[7][1] = '|';
        img[7][10] = '|';
        img[8][1] = '|';
        img[8][10] = '|';
        img[9][1] = '|';
        img[9][10] = '|';
        img[10][1] = '\\';
        img[10][10] = '/';
        img[11][2] = '\\';
        img[11][9] = '/';
        img[12][3] = '|';
        img[12][4] = '|';
        img[12][5] = '_';
        img[12][6] = '_';
        img[12][7] = '|';
        img[12][8] = '|';
        img[13][3] = '|';
        img[13][4] = '|';
        img[13][7] = '|';
        img[13][8] = '|';
        img[14][3] = '|';
        img[14][4] = '|';
        img[14][7] = '|';
        img[14][8] = '|';

        return img;
    }


    private static int getUnixTerminalWidth() {
        try {
            
            String columns = System.getenv("COLUMNS");
            if (columns != null && !columns.isEmpty()) {
                return Integer.parseInt(columns);
            }

            
            ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", "stty size </dev/tty");
            pb.redirectErrorStream(true);
            Process process = pb.start();
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));
            String output = reader.readLine();
            if (output != null && !output.isEmpty()) {
                String[] parts = output.trim().split(" ");
                return Integer.parseInt(parts[1]); 
            }
        } catch (Exception ignored) {
        }
        return 80;
    }
}
