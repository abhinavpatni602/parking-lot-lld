package com.abhinavpatni.input;

import com.abhinavpatni.models.ParkingLot;

public class InputHandler {
  private InputStrategy strategy;

  public InputHandler(InputStrategy strategy) {
    this.strategy = strategy;
  }

  public void handleInput(ParkingLot parkingLot){
    strategy.processInput(parkingLot);
  }
}
