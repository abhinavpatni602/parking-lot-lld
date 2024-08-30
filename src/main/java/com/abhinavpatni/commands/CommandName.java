package com.abhinavpatni.commands;

import java.util.HashMap;
import java.util.Map;

public enum CommandName {
  CREATE_PARKING_LOT("create_parking_lot"),
  PARK("park"),
  LEAVE("leave"),
  STATUS("status"),
  REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR("registration_numbers_for_cars_with_colour"),
  SLOT_NUMBERS_FOR_CARS_WITH_COLOUR("slot_numbers_for_cars_with_colour"),
  SLOT_NUMBER_FOR_REGISTRATION_NUMBER("slot_number_for_registration_number"),
  EXIT("exit");

  private final String command;
  private static final Map<String, CommandName> COMMAND_MAP = new HashMap<>();

  static {
    for (CommandName cmd : CommandName.values()) {
      COMMAND_MAP.put(cmd.command.toLowerCase(), cmd);
    }
  }

  CommandName(String command) {
    this.command = command;
  }

  public String getCommand() {
    return command;
  }

  public static CommandName fromString(String command) {
    return COMMAND_MAP.get(command.toLowerCase());
  }
}