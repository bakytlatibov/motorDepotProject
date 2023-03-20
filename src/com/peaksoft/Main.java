package com.peaksoft;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    public static GsonBuilder GSON_BUILDER = new GsonBuilder();
    public static Gson GSON = GSON_BUILDER.setPrettyPrinting().create();
    public static String GSON_WRITE = "./.gson.truck";
    public static String GSON_DRIVER1 = "./.gson.driver/";


    public static void main(String[] args) {
        Truck[] trucks = {
                Truck.creatTruck(1, "RENULT", new Driver(), Status.BASE),
                Truck.creatTruck(2, "VOLVO ", new Driver(), Status.BASE),
                Truck.creatTruck(3, "DAF XT", new Driver(), Status.BASE)
        };
        Driver[] drivers = {
                Driver.creatDriver(1, "  Bakyt",""),
                Driver.creatDriver(2, "  Uson",""),
                Driver.creatDriver(3, "  Asan","")
        };
        String gsonTruck = GSON.toJson(trucks);
        String gsonDriver = GSON.toJson(drivers);

        Truck.truckTab(gsonTruck);
        System.out.println();
        Driver.drivers(gsonDriver);
        int count = 0;
        while (count < 6) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Выберите грузовика :");
                int change = scanner.nextInt();
                TruckService.changeTruck(trucks, drivers, change);
                System.out.println();
                System.out.println("# | Truck | Driver | Status");
                System.out.println("--*-------*--------*--------");

                for (Truck truck : trucks) {
                    System.out.println(truck.getId() +"  "+ truck.getName() + "  " + truck.getDriver().getName() + "         " + truck.getStatus());
                }
                count++;
            } catch (RuntimeException r) {
                System.out.println(r.getMessage());
            }
        }
    }

    public static void write(String gson, String var) {
        Path path = Paths.get(var);
        try {
            Files.writeString(path, gson, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        } catch (IOException e) {
            e.getStackTrace();


        }
    }

    public static void readFiles(String var) {

        try {
            FileReader fileReader = new FileReader(GSON_WRITE);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }

        } catch (
                IOException e) {
            System.out.println(e.getMessage());
        }
    }
}