/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.0.8639.dcaf9c798 modeling language!*/

package ec.uteq.camaronera.piscinas;
import java.util.*;
import java.sql.Date;

// line 68 "../../../../../model.ump"
// line 126 "../../../../../model.ump"
public class Empleado
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Empleado Attributes
  private String cedula;
  private String nombre;

  //Empleado Associations
  private List<Muestreo> muestreos;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Empleado(String aCedula, String aNombre)
  {
    cedula = aCedula;
    nombre = aNombre;
    muestreos = new ArrayList<Muestreo>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCedula(String aCedula)
  {
    boolean wasSet = false;
    cedula = aCedula;
    wasSet = true;
    return wasSet;
  }

  public boolean setNombre(String aNombre)
  {
    boolean wasSet = false;
    nombre = aNombre;
    wasSet = true;
    return wasSet;
  }

  public String getCedula()
  {
    return cedula;
  }

  public String getNombre()
  {
    return nombre;
  }
  /* Code from template association_GetMany */
  public Muestreo getMuestreo(int index)
  {
    Muestreo aMuestreo = muestreos.get(index);
    return aMuestreo;
  }

  public List<Muestreo> getMuestreos()
  {
    List<Muestreo> newMuestreos = Collections.unmodifiableList(muestreos);
    return newMuestreos;
  }

  public int numberOfMuestreos()
  {
    int number = muestreos.size();
    return number;
  }

  public boolean hasMuestreos()
  {
    boolean has = muestreos.size() > 0;
    return has;
  }

  public int indexOfMuestreo(Muestreo aMuestreo)
  {
    int index = muestreos.indexOf(aMuestreo);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfMuestreos()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Muestreo addMuestreo(Date aFecha, double aPesoPromG, CicloCultivo aCicloCultivo)
  {
    return new Muestreo(aFecha, aPesoPromG, this, aCicloCultivo);
  }

  public boolean addMuestreo(Muestreo aMuestreo)
  {
    boolean wasAdded = false;
    if (muestreos.contains(aMuestreo)) { return false; }
    Empleado existingEmpleado = aMuestreo.getEmpleado();
    boolean isNewEmpleado = existingEmpleado != null && !this.equals(existingEmpleado);
    if (isNewEmpleado)
    {
      aMuestreo.setEmpleado(this);
    }
    else
    {
      muestreos.add(aMuestreo);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMuestreo(Muestreo aMuestreo)
  {
    boolean wasRemoved = false;
    //Unable to remove aMuestreo, as it must always have a empleado
    if (!this.equals(aMuestreo.getEmpleado()))
    {
      muestreos.remove(aMuestreo);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addMuestreoAt(Muestreo aMuestreo, int index)
  {  
    boolean wasAdded = false;
    if(addMuestreo(aMuestreo))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMuestreos()) { index = numberOfMuestreos() - 1; }
      muestreos.remove(aMuestreo);
      muestreos.add(index, aMuestreo);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMuestreoAt(Muestreo aMuestreo, int index)
  {
    boolean wasAdded = false;
    if(muestreos.contains(aMuestreo))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMuestreos()) { index = numberOfMuestreos() - 1; }
      muestreos.remove(aMuestreo);
      muestreos.add(index, aMuestreo);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMuestreoAt(aMuestreo, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=muestreos.size(); i > 0; i--)
    {
      Muestreo aMuestreo = muestreos.get(i - 1);
      aMuestreo.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "cedula" + ":" + getCedula()+ "," +
            "nombre" + ":" + getNombre()+ "]";
  }
}