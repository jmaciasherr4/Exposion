/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.0.8639.dcaf9c798 modeling language!*/

package ec.uteq.camaronera.piscinas;
import java.sql.Date;

// line 52 "../../../../../model.ump"
// line 111 "../../../../../model.ump"
public class Alimentacion
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Alimentacion Attributes
  private Date fecha;
  private double cantidadKg;

  //Alimentacion Associations
  private Insumo insumo;
  private CicloCultivo cicloCultivo;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Alimentacion(Date aFecha, double aCantidadKg, Insumo aInsumo, CicloCultivo aCicloCultivo)
  {
    fecha = aFecha;
    cantidadKg = aCantidadKg;
    boolean didAddInsumo = setInsumo(aInsumo);
    if (!didAddInsumo)
    {
      throw new RuntimeException("Unable to create alimentacion due to insumo. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddCicloCultivo = setCicloCultivo(aCicloCultivo);
    if (!didAddCicloCultivo)
    {
      throw new RuntimeException("Unable to create alimentacion due to cicloCultivo. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
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

  public boolean setCantidadKg(double aCantidadKg)
  {
    boolean wasSet = false;
    cantidadKg = aCantidadKg;
    wasSet = true;
    return wasSet;
  }

  public Date getFecha()
  {
    return fecha;
  }

  public double getCantidadKg()
  {
    return cantidadKg;
  }
  /* Code from template association_GetOne */
  public Insumo getInsumo()
  {
    return insumo;
  }
  /* Code from template association_GetOne */
  public CicloCultivo getCicloCultivo()
  {
    return cicloCultivo;
  }
  /* Code from template association_SetOneToMany */
  public boolean setInsumo(Insumo aInsumo)
  {
    boolean wasSet = false;
    if (aInsumo == null)
    {
      return wasSet;
    }

    Insumo existingInsumo = insumo;
    insumo = aInsumo;
    if (existingInsumo != null && !existingInsumo.equals(aInsumo))
    {
      existingInsumo.removeAlimentacion(this);
    }
    insumo.addAlimentacion(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setCicloCultivo(CicloCultivo aCicloCultivo)
  {
    boolean wasSet = false;
    if (aCicloCultivo == null)
    {
      return wasSet;
    }

    CicloCultivo existingCicloCultivo = cicloCultivo;
    cicloCultivo = aCicloCultivo;
    if (existingCicloCultivo != null && !existingCicloCultivo.equals(aCicloCultivo))
    {
      existingCicloCultivo.removeAlimentacion(this);
    }
    cicloCultivo.addAlimentacion(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Insumo placeholderInsumo = insumo;
    this.insumo = null;
    if(placeholderInsumo != null)
    {
      placeholderInsumo.removeAlimentacion(this);
    }
    CicloCultivo placeholderCicloCultivo = cicloCultivo;
    this.cicloCultivo = null;
    if(placeholderCicloCultivo != null)
    {
      placeholderCicloCultivo.removeAlimentacion(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "cantidadKg" + ":" + getCantidadKg()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "fecha" + "=" + (getFecha() != null ? !getFecha().equals(this)  ? getFecha().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "insumo = "+(getInsumo()!=null?Integer.toHexString(System.identityHashCode(getInsumo())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "cicloCultivo = "+(getCicloCultivo()!=null?Integer.toHexString(System.identityHashCode(getCicloCultivo())):"null");
  }
}