import boundary.MainUI;

public class Main {
    public static void main(String[] args) {
        MainUI mainUI = new MainUI();
        while(!mainUI.isQuit()) {
            mainUI.displayMenu();
        }

    }
}

