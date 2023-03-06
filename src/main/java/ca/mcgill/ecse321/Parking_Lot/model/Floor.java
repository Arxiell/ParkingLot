package ca.mcgill.ecse321.Parking_Lot.model;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 41 "model.ump"
// line 128 "model.ump"
public class Floor
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Floor Attributes
  private int floorLevel;
  private boolean isFull;

  //Floor Associations
  private List<Spot> spots;
  private ParkingLot lot;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Floor(int aFloorLevel, boolean aIsFull, ParkingLot aLot)
  {
    floorLevel = aFloorLevel;
    isFull = aIsFull;
    spots = new ArrayList<Spot>();
    boolean didAddLot = setLot(aLot);
    if (!didAddLot)
    {
      throw new RuntimeException("Unable to create floor due to lot. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFloorLevel(int aFloorLevel)
  {
    boolean wasSet = false;
    floorLevel = aFloorLevel;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsFull(boolean aIsFull)
  {
    boolean wasSet = false;
    isFull = aIsFull;
    wasSet = true;
    return wasSet;
  }

  public int getFloorLevel()
  {
    return floorLevel;
  }

  public boolean getIsFull()
  {
    return isFull;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isIsFull()
  {
    return isFull;
  }
  /* Code from template association_GetMany */
  public Spot getSpot(int index)
  {
    Spot aSpot = spots.get(index);
    return aSpot;
  }

  public List<Spot> getSpots()
  {
    List<Spot> newSpots = Collections.unmodifiableList(spots);
    return newSpots;
  }

  public int numberOfSpots()
  {
    int number = spots.size();
    return number;
  }

  public boolean hasSpots()
  {
    boolean has = spots.size() > 0;
    return has;
  }

  public int indexOfSpot(Spot aSpot)
  {
    int index = spots.indexOf(aSpot);
    return index;
  }
  /* Code from template association_GetOne */
  public ParkingLot getLot()
  {
    return lot;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfSpots()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */


  public boolean addSpot(Spot aSpot)
  {
    boolean wasAdded = false;
    if (spots.contains(aSpot)) { return false; }
    Floor existingFloor = aSpot.getFloor();
    boolean isNewFloor = existingFloor != null && !this.equals(existingFloor);
    if (isNewFloor)
    {
      aSpot.setFloor(this);
    }
    else
    {
      spots.add(aSpot);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSpot(Spot aSpot)
  {
    boolean wasRemoved = false;
    //Unable to remove aSpot, as it must always have a floor
    if (!this.equals(aSpot.getFloor()))
    {
      spots.remove(aSpot);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addSpotAt(Spot aSpot, int index)
  {  
    boolean wasAdded = false;
    if(addSpot(aSpot))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSpots()) { index = numberOfSpots() - 1; }
      spots.remove(aSpot);
      spots.add(index, aSpot);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSpotAt(Spot aSpot, int index)
  {
    boolean wasAdded = false;
    if(spots.contains(aSpot))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSpots()) { index = numberOfSpots() - 1; }
      spots.remove(aSpot);
      spots.add(index, aSpot);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSpotAt(aSpot, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setLot(ParkingLot aLot)
  {
    boolean wasSet = false;
    if (aLot == null)
    {
      return wasSet;
    }

    ParkingLot existingLot = lot;
    lot = aLot;
    if (existingLot != null && !existingLot.equals(aLot))
    {
      existingLot.removeFloor(this);
    }
    lot.addFloor(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    while (spots.size() > 0)
    {
      Spot aSpot = spots.get(spots.size() - 1);
      aSpot.delete();
      spots.remove(aSpot);
    }
    
    ParkingLot placeholderLot = lot;
    this.lot = null;
    if(placeholderLot != null)
    {
      placeholderLot.removeFloor(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "floorLevel" + ":" + getFloorLevel()+ "," +
            "isFull" + ":" + getIsFull()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "lot = "+(getLot()!=null?Integer.toHexString(System.identityHashCode(getLot())):"null");
  }
}