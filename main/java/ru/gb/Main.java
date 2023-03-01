package ru.gb;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Кот (имя, аппетит, сытность)
        // Тарелка (содержит какое-то количество еды)
        // Кот ест из тарлеки. Если в тарелке недостаточно еды - кот ее не трогает

        // ДЗ:
        // while (true) -> while (!plate.isEmpty())
        // 1. Создать массив котов. Пусть все коты из массива по очереди едят из одной тарелки.
        // В конце каждого цикла мы досыпаем в тарелку еду.
        // Для досыпания еды сделать метод increaseFood в классе Plate.
        // 2. Поменять поле satiety у кота с boolean на int.
        // Допустим у кота апптит 10, сытность 3. Значит кот захочет поесть 7 единиц.
        // 3. * Доработать поток thread в классе Cat, чтобы он каждую секунду уменьшал сытость кота на 1.
        
        List<Cat> cats = new ArrayList<>();
        Cat murzik = new Cat("Мурзик", 15, 5);
        Cat barsik = new Cat("Барсик", 5, 2);
        Cat murlo = new Cat("Мурло", 60, 1);

        Plate plate = new Plate(300);

       while (true) {
            murzik.makeHungry();
            barsik.makeHungry();
            murlo.makeHungry();

            murzik.eat(plate);
            barsik.eat(plate);
            murlo.eat(plate);
            
            plate.increaseFood();

            System.out.println(plate);
            System.out.println(murzik);
            System.out.println(barsik);
            System.out.println(murlo);
            System.out.println(cats.toString());

            Thread.sleep(1000);
       }
    }
}