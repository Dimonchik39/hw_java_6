package ru.gb;

public class Cat {

    private String name;
    private int appetite;
    private volatile int satiety;

    public Cat(String name, int appetite, int satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;

        Thread backgroundSatietyManagement = new Thread(() -> {
            while (true) {
                this.satiety = satiety;
                try {
                    Thread.sleep(5 * 1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        backgroundSatietyManagement.setDaemon(true);
        backgroundSatietyManagement.start();
    }

    public void eat(Plate plate) {
            boolean result = plate.decreaseFood(appetite);

    }

    public boolean makeHungry() {
        if (satiety < appetite) {
            return true;
        }
        return false;

    }

    @Override
    public String toString() {
        return name + "{appetite=" + appetite + ", satiety=" + satiety + "}";
    }
}
