package com.abhinavpatni.commands;

import com.abhinavpatni.models.ParkingLot;

public class RegistrationNumbersForCarsWithColourCommand implements ParkingCommand {
  @Override
  public void execute(String[] commandParts, ParkingLot parkingLot) {
    parkingLot.registrationNumbersForCarsWithColour(commandParts[1]);
  }
}
