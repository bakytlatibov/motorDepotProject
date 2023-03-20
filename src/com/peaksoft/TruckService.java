package com.peaksoft;

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.Random;
import java.util.Scanner;

public class TruckService {

    static String driverName;
    static String truckName;
    static Scanner scanner = new Scanner(System.in);
    static Driver driver = new Driver();
    static Random random = new Random();


    public static void changeTruck(Truck[] trucks, Driver[] drivers, int id) {
        for (Truck truck : trucks) {
            if (truck.getDriver().getName() == null) {
                truck.getDriver().setName(" ");
            } else {
                driverName = truck.getDriver().getName();
            }
            truckName = truck.getName();
            if (truck.getId() == id) {
                System.out.println(truck.getId());
                System.out.println("# | Truck | Driver | Status");
                System.out.println("--*-------*--------*--------");
                System.out.println(truck.getId() + "   " + truck.getName()+"  " + truck.getDriver().getName());
                System.out.println();
                System.out.println("Для отправки в путь нажмите : 1");
                System.out.println("Для отправки в ремонт нажмите на 2");
                System.out.println("Для выбора водителя  нажмите на 3");
                if (truck.getStatus().equals(Status.BASE)) {
                    int change = scanner.nextInt();
                    if (change == 1) {
                        randomDriver(drivers);
                        truck.setDriver(driver);
                        startDriving(truck.getName(), driverName);
                        truck.setStatus(Status.ROUTE);
                    }
                    if (change == 2) {

                        truck.setStatus(Status.REPAIR);
                      startRepair(truck.getName(), truck.getDriver().getName());

                    }
                    if (change == 3) {
                        changeDriver(drivers);
                        truck.setDriver(driver);
                        System.out.println("Чтобы отправит в путь нажмите на 1 ");
                        System.out.println("Чтобы оставить на базе нажмите на 0 ");
                        change = scanner.nextInt();
                        if (change == 1) {
                            startDriving(truck.getName(), driverName);
                            truck.setStatus(Status.ROUTE);
                        }
                        if (change == 0) {
                            System.out.println("Грузовик " + truck.getName() + " остался на базе");
                        }
                        if (change > 2 || change < 0) {
                            throw new RuntimeException(" Не правиьный выбор водителя!");
                        }
                    }


                }

                if (truck.getStatus().equals(Status.REPAIR)) {
                    System.out.println(truck.getId() + " " + truck.getName() + "   " + driverName + "      " + Status.REPAIR);

                }
                if (truck.getStatus().equals(Status.ROUTE)) {
                    System.out.println(truck.getId() + "    " + truck.getName() + " " + driverName + "  уже п пути.  ");

                }
            }
            if (id > trucks.length) {
                throw new RuntimeException("Выберите водителя одного из 3-х !");
            }
        }
    }


    public static void startDriving(String truckName, String driverName) {
        System.out.println("# | Truck | Driver | Status");
        System.out.println("--*-------*--------*--------");
        //  System.out.println(truckName + "   " + driverName + "  ");

    }

  public static void startRepair(String truckName, String driverName) {
        //   System.out.println("Truck : " + truckName + "Driver : " + driverName);

    }


    public static void randomDriver(Driver[] drivers) {
        int d = random.nextInt(3) + 1;
        for (Driver driver1 : drivers) {
            if (driver1.getId() == d) {
                driverName = driver1.getName();
                driver = driver1;

            }


        }

    }

    public static void changeDriver(Driver[] drivers) {
        System.out.println("Выберите водитея :");
        int changeDriver = scanner.nextInt();
        for (Driver driver1 : drivers) {
            if (driver1.getId() == changeDriver) {
                driver = driver1;
                driverName = driver1.getName();
                System.out.println("У грузовика " + truckName + " Водитель " + driver1.getName());

            }

        }

    }
}



