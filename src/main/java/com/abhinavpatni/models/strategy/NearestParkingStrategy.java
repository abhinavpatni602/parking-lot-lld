package com.abhinavpatni.models.strategy;

import com.abhinavpatni.models.Slot;
import java.util.List;
import java.util.TreeSet;

public class NearestParkingStrategy implements ParkingStrategy{
  private TreeSet<Integer> availableSpots = new TreeSet<>();

  @Override
  public int getNextAvailableSpot(List<Slot> spots) {
    if (availableSpots.isEmpty()) {
      return -1;
    }
    return availableSpots.first();
  }

  @Override
  public void addSpot(int spotNumber) {
    availableSpots.add(spotNumber);
  }

  @Override
  public void removeSpot(int spotNumber) {
    availableSpots.remove(spotNumber);
  }
}
