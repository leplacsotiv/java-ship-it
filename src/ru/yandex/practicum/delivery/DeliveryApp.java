package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardBox = new ParcelBox<>(100); // max 100kg
    private static ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(80);
    private static ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(90);
    private static List<Trackable> trackableParcels = new ArrayList<>();


    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    trackParcels();
                    break;
                case 5:
                    showBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Трекинг посылки");
        System.out.println("5 — Содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        System.out.println("Тип посылки (1-стандарт, 2-хрупкая, 3-скоропортящаяся):");
        int type = Integer.parseInt(scanner.nextLine());

        System.out.print("Описание: ");
        String desc = scanner.nextLine();
        System.out.print("Вес: ");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.print("Адрес доставки: ");
        String address = scanner.nextLine();
        System.out.print("День отправки: ");
        int sendDay = Integer.parseInt(scanner.nextLine());

        Parcel parcel;
        switch (type) {
            case 1:
                parcel = new StandardParcel(desc, weight, address, sendDay);
                if (standardBox.addParcel((StandardParcel) parcel)) {
                    allParcels.add(parcel);
                    System.out.println("Стандартная посылка добавлена в коробку.");
                }
                break;
            case 2:
                parcel = new FragileParcel(desc, weight, address, sendDay);
                if (fragileBox.addParcel((FragileParcel) parcel)) {
                    allParcels.add(parcel);
                    trackableParcels.add((FragileParcel) parcel);
                    System.out.println("Хрупкая посылка добавлена в коробку.");
                }
                break;
            case 3:
                System.out.print("timeToLive (дней): ");
                int ttl = Integer.parseInt(scanner.nextLine());
                parcel = new PerishableParcel(desc, weight, address, sendDay, ttl);
                if (perishableBox.addParcel((PerishableParcel) parcel)) {
                    allParcels.add(parcel);
                    System.out.println("Скоропортящаяся посылка добавлена в коробку.");
                }
                break;
        }
    }

    private static void trackParcels() {
        System.out.print("Новое местоположение: ");
        String location = scanner.nextLine();
        for (Trackable t : trackableParcels) {
            t.reportStatus(location);
        }
    }


    private static void showBox() {
        System.out.println("Тип коробки (1-стандарт, 2-хрупкая, 3-скоропортящаяся):");
        int type = Integer.parseInt(scanner.nextLine());
        switch (type) {
            case 1 -> {
                System.out.println("Стандартные посылки:");
                standardBox.getAllParcels().forEach(p -> System.out.println("- " + p.getDescription()));
            }
            case 2 -> {
                System.out.println("Хрупкие посылки:");
                fragileBox.getAllParcels().forEach(p -> System.out.println("- " + p.getDescription()));
            }
            case 3 -> {
                System.out.println("Скоропортящиеся посылки:");
                perishableBox.getAllParcels().forEach(p -> System.out.println("- " + p.getDescription()));
            }
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        allParcels.forEach(e -> {
            e.packageItem();
            e.deliver();
        });
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        double sum = 0;
        for (Parcel parcel : allParcels) {
            sum += parcel.calculateDeliveryCost();
        }
        System.out.println(sum);
    }

}
