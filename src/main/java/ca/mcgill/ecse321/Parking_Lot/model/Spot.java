package ca.mcgill.ecse321.Parking_Lot.model;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 48 "model.ump"
// line 134 "model.ump"
public abstract class Spot
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Spot Attributes
  private int spotId;
  private int spotNumber;
  private boolean isLargeSpot;

  //Spot Associations
  private Floor floor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Spot(int aSpotId, int aSpotNumber, boolean aIsLargeSpot, Floor aFloor)
  {
    spotId = aSpotId;
    spotNumber = aSpotNumber;
    isLargeSpot = aIsLargeSpot;
    boolean didAddFloor = setFloor(aFloor);
    if (!didAddFloor)
    {
      throw new RuntimeException("Unable to create spot due to floor. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSpotId(int aSpotId)
  {
    boolean wasSet = false;
    spotId = aSpotId;
    wasSet = true;
    return wasSet;
  }

  public boolean setSpotNumber(int aSpotNumber)
  {
    boolean wasSet = false;
    spotNumber = aSpotNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsLargeSpot(boolean aIsLargeSpot)
  {
    boolean wasSet = false;
    isLargeSpot = aIsLargeSpot;
    wasSet = true;
    return wasSet;
  }

  public int getSpotId()
  {
    return spotId;
  }

  public int getSpotNumber()
  {
    return spotNumber;
  }

  public boolean getIsLargeSpot()
  {
    return isLargeSpot;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isIsLargeSpot()
  {
    return isLargeSpot;
  }
  /* Code from template association_GetOne */
  public Floor getFloor()
  {
    return floor;
  }
  /* Code from template association_SetOneToMany */
  public boolean setFloor(Floor aFloor)
  {
    boolean wasSet = false;
    if (aFloor == null)
    {
      return wasSet;
    }

    Floor existingFloor = floor;
    floor = aFloor;
    if (existingFloor != null && !existingFloor.equals(aFloor))
    {
      existingFloor.removeSpot(this);
    }
    floor.addSpot(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Floor placeholderFloor = floor;
    this.floor = null;
    if(placeholderFloor != null)
    {
      placeholderFloor.removeSpot(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "spotId" + ":" + getSpotId()+ "," +
            "spotNumber" + ":" + getSpotNumber()+ "," +
            "isLargeSpot" + ":" + getIsLargeSpot()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "floor = "+(getFloor()!=null?Integer.toHexString(System.identityHashCode(getFloor())):"null");
  }
}