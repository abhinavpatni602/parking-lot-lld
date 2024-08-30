package com.abhinavpatni.models;

import com.abhinavpatni.models.strategy.ParkingStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingLot {
  private int capacity;
  private List<Slot> slots;
  private Map<String, Integer> registrationMap = new HashMap<>();
  private Map<String, List<Integer>> colorMap = new HashMap<>();
  private ParkingStrategy parkingStrategy;

  public ParkingLot(ParkingStrategy parkingStrategy) {
    this.parkingStrategy = parkingStrategy;
  }

  public void createParkingLot(int capacity) {
    this.capacity = capacity;
    this.slots = new ArrayList<>(Collections.nCopies(capacity, null));
    for (int i = 0; i < capacity; i++) {
      slots.set(i, new Slot(i + 1)); // Initialize each spot
      parkingStrategy.addSpot(i + 1);
    }
    System.out.println("Created a parking lot with " + capacity + " slots");
  }

  public void park(String registrationNumber, String color) {
    int spotNumber = parkingStrategy.getNextAvailableSpot(slots);
    if (spotNumber == -1) {
      System.out.println("Sorry, parking lot is full");
      return;
    }

    Car car = new Car(registrationNumber, color);
    Slot slot = slots.get(spotNumber - 1);
    slot.parkCar(car);
    parkingStrategy.removeSpot(spotNumber);
    registrationMap.put(registrationNumber, spotNumber);
    colorMap.computeIfAbsent(color, k -> new ArrayList<>()).add(spotNumber);
    System.out.println("Sorry, parking lot is full");
  }

  public void leave(int slotNumber) {
    if (slotNumber <= 0 || slotNumber > capacity) {
      System.out.println("Invalid slot number");
      return;
    }

    Slot slot = slots.get(slotNumber - 1);
    if (slot.isFree()) {
      System.out.println("Slot number is already empty");
    } else {
      Car car = slot.getParkedCar();
      slot.freeSlot();
      parkingStrategy.addSpot(slotNumber);
      registrationMap.remove(car.getRegistrationNumber());
      colorMap.get(car.getColor()).remove((Integer) slotNumber);
      System.out.println("Slot number " + slotNumber + " is free");
    }
  }

  public void status() {
    System.out.println("Slot No.    Registration No    Colour");
    for (Slot slot : slots) {
      if (!slot.isFree()) {
        Car car = slot.getParkedCar();
        System.out.println(slot.getSlotNumber() + "           " + car.getRegistrationNumber() + "      " + car.getColor());
      }
    }
  }

  public void registrationNumbersForCarsWithColour(String color) {
    if (colorMap.containsKey(color)) {
      System.out.println(colorMap.get(color).stream()
          .map(slotNumber -> slots.get(slotNumber - 1).getParkedCar().getRegistrationNumber())
          .collect(Collectors.joining(", ")));
    } else {
      System.out.println("Not found");
    }
  }

  public void slotNumbersForCarsWithColour(String color) {
    if (colorMap.containsKey(color)) {
      System.out.println(colorMap.get(color).stream()
          .map(Object::toString)
          .collect(Collectors.joining(", ")));
    } else {
      System.out.println("Not found");
    }
  }

  public void slotNumberForRegistrationNumber(String registrationNumber) {
    if (registrationMap.containsKey(registrationNumber)) {
      System.out.println(registrationMap.get(registrationNumber));
    } else {
      System.out.println("Not found");
    }
  }
}
