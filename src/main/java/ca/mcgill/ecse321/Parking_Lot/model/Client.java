package ca.mcgill.ecse321.Parking_Lot.model;
import jakarta.persistence.Entity;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 25 "model.ump"
// line 114 "model.ump"
@Entity
public class Client extends User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Client Attributes
  private boolean isMonthly;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Client(String aUsername, String aPassword, String aName, int aPhoneNumber, boolean aIsMonthly)
  {
    super(aUsername, aPassword, aName, aPhoneNumber);
    isMonthly = aIsMonthly;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsMonthly(boolean aIsMonthly)
  {
    boolean wasSet = false;
    isMonthly = aIsMonthly;
    wasSet = true;
    return wasSet;
  }

  public boolean getIsMonthly()
  {
    return isMonthly;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isIsMonthly()
  {
    return isMonthly;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "isMonthly" + ":" + getIsMonthly()+ "]";
  }
}