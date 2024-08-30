package com.abhinavpatni.commands;

import com.abhinavpatni.models.ParkingLot;

public class SlotNumbersForCarsWithColourCommand implements ParkingCommand {
  @Override
  public void execute(String[] commandParts, ParkingLot parkingLot) {
    parkingLot.slotNumbersForCarsWithColour(commandParts[1]);
  }
}
