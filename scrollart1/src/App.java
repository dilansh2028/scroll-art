import java.util.Random;

public class App {
        static final String[] symbols = new String[]{"*", "+", "@", "#"};
        static final int WIDTH = getTerminalWidth();
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        int num = rand.nextInt(4);
        while(true){
            int numSpaces = rand.nextInt(WIDTH);
            System.out.print(symbols[num]);
            for(int s = 0; s < numSpaces; s++){
                System.out.print(" ");
            }
            num = rand.nextInt(3);
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
