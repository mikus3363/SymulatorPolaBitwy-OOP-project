package me.simulation;

public class SuperStart {
    /**
     * The entry point of the application.
     *
     * This method is the main entry point for the application. It prints a prompt and a welcome message,
     * then calls the `ApplicationMain.main` method to start the application.
     *
     * @param args the command-line arguments
     * @throws InterruptedException if the main thread is interrupted while sleeping
     */
    public static void main(String[] args) throws InterruptedException {
        String prompt = "  ___                _      _             ___     _        ___ _ _                \n" +
                " / __|_  _ _ __ _  _| |__ _| |_ ___ _ _  | _ \\___| |__ _  | _ |_) |___ __ ___  _  \n" +
                " \\__ \\ || | '  \\ || | / _` |  _/ _ \\ '_| |  _/ _ \\ / _` | | _ \\ |  _\\ V  V / || | \n" +
                " |___/\\_, |_|_|_\\_,_|_\\__,_|\\__\\___/_|   |_| \\___/_\\__,_| |___/_|\\__|\\_/\\_/ \\_, | \n" +
                "      |__/                                                                  |__/  \n";
        String welcome = " __      __   _                    _ _ _ \n" +
                " \\ \\    / /__| |__ ___ _ __  ___  | | | |\n" +
                "  \\ \\/\\/ / -_) / _/ _ \\ '  \\/ -_) |_|_|_|\n" +
                "   \\_/\\_/\\___|_\\__\\___/_|_|_\\___| (_|_|_)\n\n";

        System.out.print(prompt);
        System.out.print(welcome);
        ApplicationMain.main(args);
    }
}
