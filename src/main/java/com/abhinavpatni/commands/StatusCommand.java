package com.abhinavpatni.commands;

import com.abhinavpatni.models.ParkingLot;

public class StatusCommand implements ParkingCommand {
  @Override
  public void execute(String[] commandParts, ParkingLot parkingLot) {
    parkingLot.status();
  }
}
