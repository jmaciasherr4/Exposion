/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.0.8639.dcaf9c798 modeling language!*/

package ec.uteq.camaronera.piscinas;
import java.util.*;
import java.sql.Date;

// line 63 "../../../../../model.ump"
// line 121 "../../../../../model.ump"
public class Insumo
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Insumo Attributes
  private String nombre;
  private String tipo;

  //Insumo Associations
  private List<Alimentacion> alimentacions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Insumo(String aNombre, String aTipo)
  {
    nombre = aNombre;
    tipo = aTipo;
    alimentacions = new ArrayList<Alimentacion>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNombre(String aNombre)
  {
    boolean wasSet = false;
    nombre = aNombre;
    wasSet = true;
    return wasSet;
  }

  public boolean setTipo(String aTipo)
  {
    boolean wasSet = false;
    tipo = aTipo;
    wasSet = true;
    return wasSet;
  }

  public String getNombre()
  {
    return nombre;
  }

  public String getTipo()
  {
    return tipo;
  }
  /* Code from template association_GetMany */
  public Alimentacion getAlimentacion(int index)
  {
    Alimentacion aAlimentacion = alimentacions.get(index);
    return aAlimentacion;
  }

  public List<Alimentacion> getAlimentacions()
  {
    List<Alimentacion> newAlimentacions = Collections.unmodifiableList(alimentacions);
    return newAlimentacions;
  }

  public int numberOfAlimentacions()
  {
    int number = alimentacions.size();
    return number;
  }

  public boolean hasAlimentacions()
  {
    boolean has = alimentacions.size() > 0;
    return has;
  }

  public int indexOfAlimentacion(Alimentacion aAlimentacion)
  {
    int index = alimentacions.indexOf(aAlimentacion);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAlimentacions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Alimentacion addAlimentacion(Date aFecha, double aCantidadKg, CicloCultivo aCicloCultivo)
  {
    return new Alimentacion(aFecha, aCantidadKg, this, aCicloCultivo);
  }

  public boolean addAlimentacion(Alimentacion aAlimentacion)
  {
    boolean wasAdded = false;
    if (alimentacions.contains(aAlimentacion)) { return false; }
    Insumo existingInsumo = aAlimentacion.getInsumo();
    boolean isNewInsumo = existingInsumo != null && !this.equals(existingInsumo);
    if (isNewInsumo)
    {
      aAlimentacion.setInsumo(this);
    }
    else
    {
      alimentacions.add(aAlimentacion);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAlimentacion(Alimentacion aAlimentacion)
  {
    boolean wasRemoved = false;
    //Unable to remove aAlimentacion, as it must always have a insumo
    if (!this.equals(aAlimentacion.getInsumo()))
    {
      alimentacions.remove(aAlimentacion);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAlimentacionAt(Alimentacion aAlimentacion, int index)
  {  
    boolean wasAdded = false;
    if(addAlimentacion(aAlimentacion))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAlimentacions()) { index = numberOfAlimentacions() - 1; }
      alimentacions.remove(aAlimentacion);
      alimentacions.add(index, aAlimentacion);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAlimentacionAt(Alimentacion aAlimentacion, int index)
  {
    boolean wasAdded = false;
    if(alimentacions.contains(aAlimentacion))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAlimentacions()) { index = numberOfAlimentacions() - 1; }
      alimentacions.remove(aAlimentacion);
      alimentacions.add(index, aAlimentacion);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAlimentacionAt(aAlimentacion, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=alimentacions.size(); i > 0; i--)
    {
      Alimentacion aAlimentacion = alimentacions.get(i - 1);
      aAlimentacion.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "nombre" + ":" + getNombre()+ "," +
            "tipo" + ":" + getTipo()+ "]";
  }
}