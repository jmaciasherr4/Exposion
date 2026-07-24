/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.0.8639.dcaf9c798 modeling language!*/

package ec.uteq.camaronera.piscinas;
import java.sql.Date;

// line 58 "../../../../../model.ump"
// line 116 "../../../../../model.ump"
public class Cosecha
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Cosecha Attributes
  private Date fecha;
  private double totalLibras;

  //Cosecha Associations
  private CicloCultivo cicloCultivo;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Cosecha(Date aFecha, double aTotalLibras, CicloCultivo aCicloCultivo)
  {
    fecha = aFecha;
    totalLibras = aTotalLibras;
    boolean didAddCicloCultivo = setCicloCultivo(aCicloCultivo);
    if (!didAddCicloCultivo)
    {
      throw new RuntimeException("Unable to create cosecha due to cicloCultivo. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFecha(Date aFecha)
  {
    boolean wasSet = false;
    fecha = aFecha;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotalLibras(double aTotalLibras)
  {
    boolean wasSet = false;
    totalLibras = aTotalLibras;
    wasSet = true;
    return wasSet;
  }

  public Date getFecha()
  {
    return fecha;
  }

  public double getTotalLibras()
  {
    return totalLibras;
  }
  /* Code from template association_GetOne */
  public CicloCultivo getCicloCultivo()
  {
    return cicloCultivo;
  }
  /* Code from template association_SetOneToOptionalOne */
  public boolean setCicloCultivo(CicloCultivo aNewCicloCultivo)
  {
    boolean wasSet = false;
    if (aNewCicloCultivo == null)
    {
      //Unable to setCicloCultivo to null, as cosecha must always be associated to a cicloCultivo
      return wasSet;
    }
    
    Cosecha existingCosecha = aNewCicloCultivo.getCosecha();
    if (existingCosecha != null && !equals(existingCosecha))
    {
      //Unable to setCicloCultivo, the current cicloCultivo already has a cosecha, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    CicloCultivo anOldCicloCultivo = cicloCultivo;
    cicloCultivo = aNewCicloCultivo;
    cicloCultivo.setCosecha(this);

    if (anOldCicloCultivo != null)
    {
      anOldCicloCultivo.setCosecha(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    CicloCultivo existingCicloCultivo = cicloCultivo;
    cicloCultivo = null;
    if (existingCicloCultivo != null)
    {
      existingCicloCultivo.setCosecha(null);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "totalLibras" + ":" + getTotalLibras()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "fecha" + "=" + (getFecha() != null ? !getFecha().equals(this)  ? getFecha().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "cicloCultivo = "+(getCicloCultivo()!=null?Integer.toHexString(System.identityHashCode(getCicloCultivo())):"null");
  }
}