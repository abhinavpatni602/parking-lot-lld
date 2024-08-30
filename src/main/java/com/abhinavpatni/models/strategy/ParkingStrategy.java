package com.abhinavpatni.models.strategy;

import com.abhinavpatni.models.Slot;
import java.util.List;

public interface ParkingStrategy {
  int getNextAvailableSpot(List<Slot> spots);
  void addSpot(int spotNumber);
  void removeSpot(int spotNumber);
}
