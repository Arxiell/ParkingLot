package ca.mcgill.ecse321.Parking_Lot.model;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.sql.Date;

// line 80 "model.ump"
// line 161 "model.ump"
public class Subscription
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Subscription Attributes
  private int subscriptionId;
  private Date purchaseDate;
  private Date expiryDate;

  //Subscription Associations
  private Client client;
  private MemberSpot spot;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Subscription(int aSubscriptionId, Date aPurchaseDate, Date aExpiryDate, Client aClient, MemberSpot aSpot)
  {
    subscriptionId = aSubscriptionId;
    purchaseDate = aPurchaseDate;
    expiryDate = aExpiryDate;
    if (!setClient(aClient))
    {
      throw new RuntimeException("Unable to create Subscription due to aClient. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (!setSpot(aSpot))
    {
      throw new RuntimeException("Unable to create Subscription due to aSpot. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSubscriptionId(int aSubscriptionId)
  {
    boolean wasSet = false;
    subscriptionId = aSubscriptionId;
    wasSet = true;
    return wasSet;
  }

  public boolean setPurchaseDate(Date aPurchaseDate)
  {
    boolean wasSet = false;
    purchaseDate = aPurchaseDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setExpiryDate(Date aExpiryDate)
  {
    boolean wasSet = false;
    expiryDate = aExpiryDate;
    wasSet = true;
    return wasSet;
  }

  public int getSubscriptionId()
  {
    return subscriptionId;
  }

  public Date getPurchaseDate()
  {
    return purchaseDate;
  }

  public Date getExpiryDate()
  {
    return expiryDate;
  }
  /* Code from template association_GetOne */
  public Client getClient()
  {
    return client;
  }
  /* Code from template association_GetOne */
  public MemberSpot getSpot()
  {
    return spot;
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
  public boolean setSpot(MemberSpot aNewSpot)
  {
    boolean wasSet = false;
    if (aNewSpot != null)
    {
      spot = aNewSpot;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    client = null;
    spot = null;
  }


  public String toString()
  {
    return super.toString() + "["+
            "subscriptionId" + ":" + getSubscriptionId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "purchaseDate" + "=" + (getPurchaseDate() != null ? !getPurchaseDate().equals(this)  ? getPurchaseDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "expiryDate" + "=" + (getExpiryDate() != null ? !getExpiryDate().equals(this)  ? getExpiryDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "client = "+(getClient()!=null?Integer.toHexString(System.identityHashCode(getClient())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "spot = "+(getSpot()!=null?Integer.toHexString(System.identityHashCode(getSpot())):"null");
  }
}