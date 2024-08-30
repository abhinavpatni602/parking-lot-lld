package com.abhinavpatni.input;

import com.abhinavpatni.commands.CommandExecutorFactory;
import com.abhinavpatni.models.ParkingLot;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileInputStrategy implements InputStrategy {
  private CommandExecutorFactory commandExecutorFactory;
  private String filePath;

  public FileInputStrategy(CommandExecutorFactory commandExecutorFactory, String filePath) {
    this.commandExecutorFactory = commandExecutorFactory;
    this.filePath = filePath;
  }

  @Override
  public void processInput(ParkingLot parkingLot) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String command;
      while ((command = reader.readLine()) != null) {
        commandExecutorFactory.executeCommand(command, parkingLot);
      }
    } catch (IOException e) {
      System.out.println("Error reading file: " + e.getMessage());
    }
  }
}
