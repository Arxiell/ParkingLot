package ca.mcgill.ecse321.Parking_Lot.model;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 11 "model.ump"
// line 102 "model.ump"
@Entity
public class Employee extends User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Employee Attributes
  private String jobTitle;
  private int salary;

  //Employee Associations
  private Owner employer;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Employee(String aUsername, String aPassword, String aName, int aPhoneNumber, String aJobTitle, int aSalary, Owner aEmployer)
  {
    super(aUsername, aPassword, aName, aPhoneNumber);
    jobTitle = aJobTitle;
    salary = aSalary;
    if (!setEmployer(aEmployer))
    {
      throw new RuntimeException("Unable to create Employee due to aEmployer. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setJobTitle(String aJobTitle)
  {
    boolean wasSet = false;
    jobTitle = aJobTitle;
    wasSet = true;
    return wasSet;
  }

  public boolean setSalary(int aSalary)
  {
    boolean wasSet = false;
    salary = aSalary;
    wasSet = true;
    return wasSet;
  }

  public String getJobTitle()
  {
    return jobTitle;
  }

  public int getSalary()
  {
    return salary;
  }
  /* Code from template association_GetOne */
  @ManyToOne(optional = false)
  public Owner getEmployer()
  {
    return employer;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setEmployer(Owner aNewEmployer)
  {
    boolean wasSet = false;
    if (aNewEmployer != null)
    {
      employer = aNewEmployer;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    employer = null;
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "jobTitle" + ":" + getJobTitle()+ "," +
            "salary" + ":" + getSalary()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "employer = "+(getEmployer()!=null?Integer.toHexString(System.identityHashCode(getEmployer())):"null");
  }
}