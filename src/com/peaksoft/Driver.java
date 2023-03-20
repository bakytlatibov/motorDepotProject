package com.peaksoft;

import com.google.gson.Gson;

import static com.peaksoft.Main.GSON;

public class Driver {
    private int id;
    private  String name;
    private String truckName;
    public static Driver creatDriver(int id,String name,String truckName){
        Driver driver=new Driver();
        driver.id=id;
        driver.name=name;
        driver.truckName=truckName;

        return driver;
    }
    public static void drivers(String gson){
        Driver[]drivers= GSON.fromJson(gson,Driver[].class);
        System.out.println("# | Driver |  Bus ");
        System.out.println("--+--------+------");
        for (Driver driver : drivers) {
            System.out.println(driver.infoDriving());

        }



    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }  public String getTruckName() {
        return truckName;
    }

    public void setTruckName(String truckName) {
        this.truckName = truckName;
    }

    @Override
    public String toString() {
        return "";
    }
    public String infoDriving() {
        return id + " " + name;
    }
}
