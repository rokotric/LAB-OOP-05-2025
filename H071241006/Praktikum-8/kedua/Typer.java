class Typer extends Thread {
    private String botName, wordsTyped;
    private double wpm;
    private TypeRacer typeRacer;

    public Typer(String botName, double wpm, TypeRacer typeRacer) {
        this.botName = botName;
        this.wpm = wpm;
        this.wordsTyped = "";
        this.typeRacer = typeRacer;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public void setWpm(double wpm) {
        this.wpm = wpm;
    }

    public void addWordsTyped(String newWordsTyped) {
        this.wordsTyped += newWordsTyped + " ";
    }

    public String getWordsTyped() {
        return wordsTyped.trim();
    }

    public String getBotName() {
        return botName;
    }

    public double getWpm() {
        return wpm;
    }

    @Override
    public void run() {
        String[] wordsToType = typeRacer.getWordsToType().split(" ");

        // TODO (1)
        // Buatlah variable howLongToType yang memuat waktu yang diperlukan typer
        // (dalam milidetik) untuk mengetik satu kata, berdasarkan WPM
        long howLongToType = (long) ((60.0 / wpm) * 1000); // konversi WPM ke ms per kata

        // TODO (2)
        // Buatlah perulangan untuk menambahkan kata dengan method
        // addWordToTyped setelah interval waktu sebanyak howLongToType
        long startTime = System.currentTimeMillis();
        for (String word : wordsToType) {
            try {
                Thread.sleep(howLongToType);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            this.addWordsTyped(word);
        }
        this.addWordsTyped("(Selesai)");
        long finishTime = System.currentTimeMillis();

        // TODO (3)
        // Tambahkan typer yang telah selesai mengetik semua kata ke list typeRaceTabel
        // yang ada di class typeRacer.
        int timeTaken = (int) (finishTime - startTime); // dalam ms
        Result result = new Result(this.botName, timeTaken);
        typeRacer.getTypeRaceTable().add(result);
    }
}
