package com.abhinavpatni.commands;

import com.abhinavpatni.models.ParkingLot;

public class LeaveCommand implements ParkingCommand {
  @Override
  public void execute(String[] commandParts, ParkingLot parkingLot) {
    int slotNumber = Integer.parseInt(commandParts[1]);
    parkingLot.leave(slotNumber);
  }
}
