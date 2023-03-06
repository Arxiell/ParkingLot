package ca.mcgill.ecse321.Parking_Lot.model;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.sql.Time;

// line 86 "model.ump"
// line 166 "model.ump"
public class Schedule
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Schedule Attributes
  private Time openingHour;
  private Time closingHour;

  //Schedule Associations
  private Owner owner;
  private ParkingLot lot;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Schedule(Time aOpeningHour, Time aClosingHour, Owner aOwner, ParkingLot aLot)
  {
    openingHour = aOpeningHour;
    closingHour = aClosingHour;
    if (!setOwner(aOwner))
    {
      throw new RuntimeException("Unable to create Schedule due to aOwner. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (aLot == null || aLot.getSchedule() != null)
    {
      throw new RuntimeException("Unable to create Schedule due to aLot. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    lot = aLot;
  }

  public Schedule(Time aOpeningHour, Time aClosingHour, Owner aOwner, String aLotNameForLot)
  {
    openingHour = aOpeningHour;
    closingHour = aClosingHour;
    boolean didAddOwner = setOwner(aOwner);
    if (!didAddOwner)
    {
      throw new RuntimeException("Unable to create schedule due to owner. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    lot = new ParkingLot(aLotNameForLot, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setOpeningHour(Time aOpeningHour)
  {
    boolean wasSet = false;
    openingHour = aOpeningHour;
    wasSet = true;
    return wasSet;
  }

  public boolean setClosingHour(Time aClosingHour)
  {
    boolean wasSet = false;
    closingHour = aClosingHour;
    wasSet = true;
    return wasSet;
  }

  public Time getOpeningHour()
  {
    return openingHour;
  }

  public Time getClosingHour()
  {
    return closingHour;
  }
  /* Code from template association_GetOne */
  public Owner getOwner()
  {
    return owner;
  }
  /* Code from template association_GetOne */
  public ParkingLot getLot()
  {
    return lot;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setOwner(Owner aNewOwner)
  {
    boolean wasSet = false;
    if (aNewOwner != null)
    {
      owner = aNewOwner;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    owner = null;
    ParkingLot existingLot = lot;
    lot = null;
    if (existingLot != null)
    {
      existingLot.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "openingHour" + "=" + (getOpeningHour() != null ? !getOpeningHour().equals(this)  ? getOpeningHour().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "closingHour" + "=" + (getClosingHour() != null ? !getClosingHour().equals(this)  ? getClosingHour().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "owner = "+(getOwner()!=null?Integer.toHexString(System.identityHashCode(getOwner())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "lot = "+(getLot()!=null?Integer.toHexString(System.identityHashCode(getLot())):"null");
  }
}