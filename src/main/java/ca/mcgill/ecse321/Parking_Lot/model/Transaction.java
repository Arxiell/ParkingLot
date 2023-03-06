package ca.mcgill.ecse321.Parking_Lot.model;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.sql.Date;

// line 68 "model.ump"
// line 150 "model.ump"
public class Transaction
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Transaction Attributes
  private int transactionId;
  private Date date;
  private float amount;

  //Transaction Associations
  private Client client;
  private Service service;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Transaction(int aTransactionId, Date aDate, float aAmount, Client aClient, Service aService)
  {
    transactionId = aTransactionId;
    date = aDate;
    amount = aAmount;
    if (!setClient(aClient))
    {
      throw new RuntimeException("Unable to create Transaction due to aClient. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (!setService(aService))
    {
      throw new RuntimeException("Unable to create Transaction due to aService. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTransactionId(int aTransactionId)
  {
    boolean wasSet = false;
    transactionId = aTransactionId;
    wasSet = true;
    return wasSet;
  }

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setAmount(float aAmount)
  {
    boolean wasSet = false;
    amount = aAmount;
    wasSet = true;
    return wasSet;
  }

  public int getTransactionId()
  {
    return transactionId;
  }

  public Date getDate()
  {
    return date;
  }

  public float getAmount()
  {
    return amount;
  }
  /* Code from template association_GetOne */
  public Client getClient()
  {
    return client;
  }
  /* Code from template association_GetOne */
  public Service getService()
  {
    return service;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setClient(Client aNewClient)
  {
    boolean wasSet = false;
    if (aNewClient != null)
    {
      client = aNewClient;
      wasSet = true;
    }
    return wasSet;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setService(Service aNewService)
  {
    boolean wasSet = false;
    if (aNewService != null)
    {
      service = aNewService;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    client = null;
    service = null;
  }


  public String toString()
  {
    return super.toString() + "["+
            "transactionId" + ":" + getTransactionId()+ "," +
            "amount" + ":" + getAmount()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "client = "+(getClient()!=null?Integer.toHexString(System.identityHashCode(getClient())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "service = "+(getService()!=null?Integer.toHexString(System.identityHashCode(getService())):"null");
  }
}