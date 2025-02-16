// This class represents data being used by both the Contender Class/ The UltimateBattleApp Class

class Water {
    public synchronized void drink(String contenderName) {
        System.out.println(contenderName + " starts drinking water.");
        try {
            if (contenderName.equals("John Cena")) {
                Thread.sleep(2000); // John Cena drinks longer
            } else {
                Thread.sleep(1000); // Randy Orton drinks shorter
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(contenderName + " finishes drinking water.");
    }
}
