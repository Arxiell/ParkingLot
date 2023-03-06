package ca.mcgill.ecse321.Parking_Lot.model;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 62 "model.ump"
// line 145 "model.ump"
public class GeneralSpot extends Spot
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GeneralSpot Attributes
  private boolean isOccupied;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GeneralSpot(int aSpotId, int aSpotNumber, boolean aIsLargeSpot, Floor aFloor, boolean aIsOccupied)
  {
    super(aSpotId, aSpotNumber, aIsLargeSpot, aFloor);
    isOccupied = aIsOccupied;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsOccupied(boolean aIsOccupied)
  {
    boolean wasSet = false;
    isOccupied = aIsOccupied;
    wasSet = true;
    return wasSet;
  }

  public boolean getIsOccupied()
  {
    return isOccupied;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isIsOccupied()
  {
    return isOccupied;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "isOccupied" + ":" + getIsOccupied()+ "]";
  }
}