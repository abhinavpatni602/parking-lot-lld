package com.abhinavpatni.input;

import com.abhinavpatni.commands.CommandExecutorFactory;
import com.abhinavpatni.models.ParkingLot;
import java.util.Scanner;

public class InteractiveInputStrategy implements InputStrategy {
  private CommandExecutorFactory commandExecutorFactory;

  public InteractiveInputStrategy(CommandExecutorFactory commandExecutorFactory) {
    this.commandExecutorFactory = commandExecutorFactory;
  }

  @Override
  public void processInput(ParkingLot parkingLot) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      String command = scanner.nextLine();
      if (command.equals("exit")) {
        break;
      }
      commandExecutorFactory.executeCommand(command, parkingLot);
    }
    scanner.close();
  }
}
