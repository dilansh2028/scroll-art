import java.util.Random;

public class App {
    static final int width = getTerminalWidth();
    static final int ballx = 8;
    static final int bally = 8;
    public static void main(String[] args) throws Exception {
        
        char[][] football= getfootball();
        Random rand = new Random();
        while(true){
            int num = rand.nextInt(width - 10);

            for (int y = 0; y < bally; y=y+1){
                System.out.println();
                for(int i = 0; i < num; i++){
                    System.out.print(" ");
                }
                for (int x = 0; x <ballx; x++){
                    System.out.print(football[y][x]);
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
