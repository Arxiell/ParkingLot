package ca.mcgill.ecse321.Parking_Lot.model;
import jakarta.persistence.Entity;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 21 "model.ump"
// line 109 "model.ump"
@Entity
public class Owner extends User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Owner(String aUsername, String aPassword, String aName, int aPhoneNumber)
  {
    super(aUsername, aPassword, aName, aPhoneNumber);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

}