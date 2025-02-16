//This class is created for the purpose of initiating the battle in the UltimateBattleApp

public class UltimateBattleApp {
    public static void main(String[] args) {
        Water water = new Water();

        Contender johnCena = new Contender("John Cena", 15, 500, water);
        Contender randyOrton = new Contender("Randy Orton", 5, 1000, water);

        Thread johnCenaThread = new Thread(johnCena);
        Thread randyOrtonThread = new Thread(randyOrton);

        johnCenaThread.setDaemon(false);
        randyOrtonThread.setDaemon(false);

        johnCenaThread.start();
        randyOrtonThread.start();

        try {
            johnCenaThread.join();
            randyOrtonThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupt status
            System.err.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("Battle Over!");
    }
}