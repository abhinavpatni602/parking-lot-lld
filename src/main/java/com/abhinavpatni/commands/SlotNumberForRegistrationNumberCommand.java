package com.abhinavpatni.commands;

import com.abhinavpatni.models.ParkingLot;

public class SlotNumberForRegistrationNumberCommand implements ParkingCommand {
  @Override
  public void execute(String[] commandParts, ParkingLot parkingLot) {
    parkingLot.slotNumberForRegistrationNumber(commandParts[1]);
  }
}
