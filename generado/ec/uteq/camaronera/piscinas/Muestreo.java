/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.0.8639.dcaf9c798 modeling language!*/

package ec.uteq.camaronera.piscinas;
import java.sql.Date;

// line 42 "../../../../../model.ump"
// line 106 "../../../../../model.ump"
public class Muestreo
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Muestreo Attributes
  private Date fecha;
  private double pesoPromG;

  //Muestreo Associations
  private Empleado empleado;
  private CicloCultivo cicloCultivo;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Muestreo(Date aFecha, double aPesoPromG, Empleado aEmpleado, CicloCultivo aCicloCultivo)
  {
    fecha = aFecha;
    pesoPromG = aPesoPromG;
    boolean didAddEmpleado = setEmpleado(aEmpleado);
    if (!didAddEmpleado)
    {
      throw new RuntimeException("Unable to create muestreo due to empleado. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddCicloCultivo = setCicloCultivo(aCicloCultivo);
    if (!didAddCicloCultivo)
    {
      throw new RuntimeException("Unable to create muestreo due to cicloCultivo. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
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

  public boolean setPesoPromG(double aPesoPromG)
  {
    boolean wasSet = false;
    pesoPromG = aPesoPromG;
    wasSet = true;
    return wasSet;
  }

  public Date getFecha()
  {
    return fecha;
  }

  public double getPesoPromG()
  {
    return pesoPromG;
  }
  /* Code from template association_GetOne */
  public Empleado getEmpleado()
  {
    return empleado;
  }
  /* Code from template association_GetOne */
  public CicloCultivo getCicloCultivo()
  {
    return cicloCultivo;
  }
  /* Code from template association_SetOneToMany */
  public boolean setEmpleado(Empleado aEmpleado)
  {
    boolean wasSet = false;
    if (aEmpleado == null)
    {
      return wasSet;
    }

    Empleado existingEmpleado = empleado;
    empleado = aEmpleado;
    if (existingEmpleado != null && !existingEmpleado.equals(aEmpleado))
    {
      existingEmpleado.removeMuestreo(this);
    }
    empleado.addMuestreo(this);
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
      existingCicloCultivo.removeMuestreo(this);
    }
    cicloCultivo.addMuestreo(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Empleado placeholderEmpleado = empleado;
    this.empleado = null;
    if(placeholderEmpleado != null)
    {
      placeholderEmpleado.removeMuestreo(this);
    }
    CicloCultivo placeholderCicloCultivo = cicloCultivo;
    this.cicloCultivo = null;
    if(placeholderCicloCultivo != null)
    {
      placeholderCicloCultivo.removeMuestreo(this);
    }
  }

  // line 48 "../../../../../model.ump"
  public Double calcularBiomasa(){
    return pesoPromG;
  }


  public String toString()
  {
    return super.toString() + "["+
            "pesoPromG" + ":" + getPesoPromG()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "fecha" + "=" + (getFecha() != null ? !getFecha().equals(this)  ? getFecha().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "empleado = "+(getEmpleado()!=null?Integer.toHexString(System.identityHashCode(getEmpleado())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "cicloCultivo = "+(getCicloCultivo()!=null?Integer.toHexString(System.identityHashCode(getCicloCultivo())):"null");
  }
}