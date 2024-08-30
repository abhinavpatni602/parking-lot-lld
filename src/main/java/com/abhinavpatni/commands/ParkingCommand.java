package com.abhinavpatni.commands;

import com.abhinavpatni.models.ParkingLot;

public interface ParkingCommand {
  void execute(String[] commandParts, ParkingLot parkingLot);
}
