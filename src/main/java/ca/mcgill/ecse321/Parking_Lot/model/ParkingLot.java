package ca.mcgill.ecse321.Parking_Lot.model;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;
import java.sql.Time;

// line 34 "model.ump"
// line 121 "model.ump"
public class ParkingLot
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ParkingLot Attributes
  private String lotName;

  //ParkingLot Associations
  private List<Floor> floors;
  private Schedule schedule;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ParkingLot(String aLotName, Schedule aSchedule)
  {
    lotName = aLotName;
    floors = new ArrayList<Floor>();
    if (aSchedule == null || aSchedule.getLot() != null)
    {
      throw new RuntimeException("Unable to create ParkingLot due to aSchedule. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    schedule = aSchedule;
  }

  public ParkingLot(String aLotName, Time aOpeningHourForSchedule, Time aClosingHourForSchedule, Owner aOwnerForSchedule)
  {
    lotName = aLotName;
    floors = new ArrayList<Floor>();
    schedule = new Schedule(aOpeningHourForSchedule, aClosingHourForSchedule, aOwnerForSchedule, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLotName(String aLotName)
  {
    boolean wasSet = false;
    lotName = aLotName;
    wasSet = true;
    return wasSet;
  }

  public String getLotName()
  {
    return lotName;
  }
  /* Code from template association_GetMany */
  public Floor getFloor(int index)
  {
    Floor aFloor = floors.get(index);
    return aFloor;
  }

  public List<Floor> getFloors()
  {
    List<Floor> newFloors = Collections.unmodifiableList(floors);
    return newFloors;
  }

  public int numberOfFloors()
  {
    int number = floors.size();
    return number;
  }

  public boolean hasFloors()
  {
    boolean has = floors.size() > 0;
    return has;
  }

  public int indexOfFloor(Floor aFloor)
  {
    int index = floors.indexOf(aFloor);
    return index;
  }
  /* Code from template association_GetOne */
  public Schedule getSchedule()
  {
    return schedule;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfFloors()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Floor addFloor(int aFloorLevel, boolean aIsFull)
  {
    return new Floor(aFloorLevel, aIsFull, this);
  }

  public boolean addFloor(Floor aFloor)
  {
    boolean wasAdded = false;
    if (floors.contains(aFloor)) { return false; }
    ParkingLot existingLot = aFloor.getLot();
    boolean isNewLot = existingLot != null && !this.equals(existingLot);
    if (isNewLot)
    {
      aFloor.setLot(this);
    }
    else
    {
      floors.add(aFloor);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeFloor(Floor aFloor)
  {
    boolean wasRemoved = false;
    //Unable to remove aFloor, as it must always have a lot
    if (!this.equals(aFloor.getLot()))
    {
      floors.remove(aFloor);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addFloorAt(Floor aFloor, int index)
  {  
    boolean wasAdded = false;
    if(addFloor(aFloor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFloors()) { index = numberOfFloors() - 1; }
      floors.remove(aFloor);
      floors.add(index, aFloor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveFloorAt(Floor aFloor, int index)
  {
    boolean wasAdded = false;
    if(floors.contains(aFloor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFloors()) { index = numberOfFloors() - 1; }
      floors.remove(aFloor);
      floors.add(index, aFloor);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addFloorAt(aFloor, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while (floors.size() > 0)
    {
      Floor aFloor = floors.get(floors.size() - 1);
      aFloor.delete();
      floors.remove(aFloor);
    }
    
    Schedule existingSchedule = schedule;
    schedule = null;
    if (existingSchedule != null)
    {
      existingSchedule.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "lotName" + ":" + getLotName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "schedule = "+(getSchedule()!=null?Integer.toHexString(System.identityHashCode(getSchedule())):"null");
  }
}