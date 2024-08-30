package com.abhinavpatni;

import com.abhinavpatni.commands.CommandExecutorFactory;
import com.abhinavpatni.input.FileInputStrategy;
import com.abhinavpatni.input.InputHandler;
import com.abhinavpatni.input.InteractiveInputStrategy;
import com.abhinavpatni.models.ParkingLot;
import com.abhinavpatni.models.strategy.NearestParkingStrategy;

public class ParkingLotApp {
  public static void main(String[] args) {
    ParkingLot parkingLot = new ParkingLot(new NearestParkingStrategy());
    CommandExecutorFactory commandExecutor = new CommandExecutorFactory();
    InputHandler inputHandler;

    if (args.length > 0) {
      // File input mode
      String filePath = args[0];
      inputHandler = new InputHandler(new FileInputStrategy(commandExecutor, filePath));
    } else {
      // Interactive input mode
      inputHandler = new InputHandler(new InteractiveInputStrategy(commandExecutor));
    }

    inputHandler.handleInput(parkingLot);
  }
}