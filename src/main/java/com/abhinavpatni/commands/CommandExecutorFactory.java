package com.abhinavpatni.commands;

import com.abhinavpatni.models.ParkingLot;
import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {
  private final Map<CommandName, ParkingCommand> commands = new HashMap<>();

  public CommandExecutorFactory() {
    commands.put(CommandName.CREATE_PARKING_LOT, new CreateParkingLotCommand());
    commands.put(CommandName.PARK, new ParkCommand());
    commands.put(CommandName.LEAVE, new LeaveCommand());
    commands.put(CommandName.STATUS, new StatusCommand());
    commands.put(CommandName.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR, new RegistrationNumbersForCarsWithColourCommand());
    commands.put(CommandName.SLOT_NUMBERS_FOR_CARS_WITH_COLOUR, new SlotNumbersForCarsWithColourCommand());
    commands.put(CommandName.SLOT_NUMBER_FOR_REGISTRATION_NUMBER, new SlotNumberForRegistrationNumberCommand());
  }

  public void executeCommand(String input, ParkingLot parkingLot) {
    String[] commandParts = input.split(" ");
    CommandName commandName = CommandName.fromString(commandParts[0]);

    if (commandName != null) {
      ParkingCommand command = commands.get(commandName);
      if (command != null) {
        command.execute(commandParts, parkingLot);
      } else {
        System.out.println("Invalid command");
      }
    } else {
      System.out.println("Invalid command");
    }
  }
}
