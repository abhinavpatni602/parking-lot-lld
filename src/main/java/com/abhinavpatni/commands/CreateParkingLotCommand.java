package com.abhinavpatni.commands;

import com.abhinavpatni.models.ParkingLot;

public class CreateParkingLotCommand implements ParkingCommand {
  @Override
  public void execute(String[] commandParts, ParkingLot parkingLot) {
    int capacity = Integer.parseInt(commandParts[1]);
    parkingLot.createParkingLot(capacity);
  }
}
