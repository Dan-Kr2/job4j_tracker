package ru.job4j.cast;

public class VehiclePark {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle longBus = new Bus();
        Vehicle boeing = new Plane();
        Vehicle airbus = new Plane();
        Vehicle swallow = new Train();
        Vehicle sapsan = new Train();

        Vehicle[] vehicles = new Vehicle[] {bus, longBus, boeing, airbus, swallow, sapsan};
        for (Vehicle object : vehicles) {
            object.move();
        }
    }
}