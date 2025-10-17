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
        } else if (os.contains("win")) {
            return getWindowsTerminalWidth();
        } else {
            return 80; // fallback for unknown OS
        }
    }

    private static int getUnixTerminalWidth() {
        try {
            // Try to get terminal size from environment variables first
            String columns = System.getenv("COLUMNS");
            if (columns != null && !columns.isEmpty()) {
                return Integer.parseInt(columns);
            }

            // Fallback to stty command
            ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", "stty size </dev/tty");
            pb.redirectErrorStream(true);
            Process process = pb.start();
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));
            String output = reader.readLine();
            if (output != null && !output.isEmpty()) {
                String[] parts = output.trim().split(" ");
                return Integer.parseInt(parts[1]); // columns
            }
        } catch (Exception ignored) {
            // Silently ignore errors and fall back to default
        }
        return 80; // fallback
    }

    private static int getWindowsTerminalWidth() {
        // Github Copilot (Claude Sonnet 4) attempted to get columns.
        // Did not work on parallels.
        try {
            // Try to get terminal size from environment variables first
            String columns = System.getenv("COLUMNS");
            if (columns != null && !columns.isEmpty()) {
                return Integer.parseInt(columns);
            }

            // Try using PowerShell with different approaches
            // Method 1: Try to get console window size directly
            ProcessBuilder pb = new ProcessBuilder("powershell", "-Command",
                    "[Console]::WindowWidth");
            // also (Get-Host).UI.RawUI.WindowSize.Width didn't work
            pb.redirectErrorStream(true);
            Process process = pb.start();
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));
            String output = reader.readLine();
            if (output != null && !output.isEmpty()) {
                try {
                    return Integer.parseInt(output.trim());
                } catch (NumberFormatException ignored) {
                    // Continue to next method if parsing fails
                }
            }

        } catch (Exception e) {
            // If PowerShell fails, try using cmd with mode command
            try {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "mode con");
                pb.redirectErrorStream(true);
                Process process = pb.start();
                java.io.BufferedReader reader = new java.io.BufferedReader(
                        new java.io.InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("Columns:")) {
                        String[] parts = line.split(":");
                        if (parts.length > 1) {
                            try {
                                return Integer.parseInt(parts[1].trim());
                            } catch (NumberFormatException ignored) {
                                // Continue to fallback
                            }
                        }
                    }
                }
            } catch (Exception ignored) {
                // Silently ignore errors and fall back to default
            }
        }
        return 80; // fallback
    }
}
