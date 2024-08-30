package com.abhinavpatni.models;

public class Slot {
  private Car parkedCar;
  private Integer slotNumber;

  public Slot(final Integer slotNumber) {
    this.slotNumber = slotNumber;
  }

  public Integer getSlotNumber() {
    return slotNumber;
  }

  public Car getParkedCar() {
    return parkedCar;
  }

  public boolean isFree() {
    return parkedCar == null;
  }

  public void parkCar(Car car) {
    this.parkedCar = car;
  }

  public void freeSlot(){
    this.parkedCar = null;
  }
}
