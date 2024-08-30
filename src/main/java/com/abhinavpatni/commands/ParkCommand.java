package com.abhinavpatni.commands;

import com.abhinavpatni.models.ParkingLot;

public class ParkCommand implements ParkingCommand {
  @Override
  public void execute(String[] commandParts, ParkingLot parkingLot) {
    String registrationNumber = commandParts[1];
    String color = commandParts[2];
    parkingLot.park(registrationNumber, color);
  }
}
