package ca.mcgill.ecse321.Parking_Lot.model;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.sql.Date;

// line 74 "model.ump"
// line 155 "model.ump"
public class Service
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Service Attributes
  private String serviceName;
  private Date dateOfService;

  //Service Associations
  private Employee employee;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Service(String aServiceName, Date aDateOfService, Employee aEmployee)
  {
    serviceName = aServiceName;
    dateOfService = aDateOfService;
    if (!setEmployee(aEmployee))
    {
      throw new RuntimeException("Unable to create Service due to aEmployee. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setServiceName(String aServiceName)
  {
    boolean wasSet = false;
    serviceName = aServiceName;
    wasSet = true;
    return wasSet;
  }

  public boolean setDateOfService(Date aDateOfService)
  {
    boolean wasSet = false;
    dateOfService = aDateOfService;
    wasSet = true;
    return wasSet;
  }

  public String getServiceName()
  {
    return serviceName;
  }

  public Date getDateOfService()
  {
    return dateOfService;
  }
  /* Code from template association_GetOne */
  public Employee getEmployee()
  {
    return employee;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setEmployee(Employee aNewEmployee)
  {
    boolean wasSet = false;
    if (aNewEmployee != null)
    {
      employee = aNewEmployee;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    employee = null;
  }


  public String toString()
  {
    return super.toString() + "["+
            "serviceName" + ":" + getServiceName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "dateOfService" + "=" + (getDateOfService() != null ? !getDateOfService().equals(this)  ? getDateOfService().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "employee = "+(getEmployee()!=null?Integer.toHexString(System.identityHashCode(getEmployee())):"null");
  }
}