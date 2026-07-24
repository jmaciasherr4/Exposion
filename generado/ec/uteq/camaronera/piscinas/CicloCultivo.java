/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.0.8639.dcaf9c798 modeling language!*/

package ec.uteq.camaronera.piscinas;
import java.sql.Date;
import java.util.*;

// line 24 "../../../../../model.ump"
// line 101 "../../../../../model.ump"
public class CicloCultivo
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CicloCultivo Attributes
  private Date fechaSiembra;
  private int densidadPL;
  private String estado;

  //CicloCultivo Associations
  private List<Muestreo> muestreos;
  private List<Alimentacion> alimentacions;
  private Cosecha cosecha;
  private Piscina piscina;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CicloCultivo(Date aFechaSiembra, int aDensidadPL, String aEstado, Piscina aPiscina)
  {
    fechaSiembra = aFechaSiembra;
    densidadPL = aDensidadPL;
    estado = aEstado;
    muestreos = new ArrayList<Muestreo>();
    alimentacions = new ArrayList<Alimentacion>();
    boolean didAddPiscina = setPiscina(aPiscina);
    if (!didAddPiscina)
    {
      throw new RuntimeException("Unable to create cicloCultivo due to piscina. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFechaSiembra(Date aFechaSiembra)
  {
    boolean wasSet = false;
    fechaSiembra = aFechaSiembra;
    wasSet = true;
    return wasSet;
  }

  public boolean setDensidadPL(int aDensidadPL)
  {
    boolean wasSet = false;
    densidadPL = aDensidadPL;
    wasSet = true;
    return wasSet;
  }

  public boolean setEstado(String aEstado)
  {
    boolean wasSet = false;
    estado = aEstado;
    wasSet = true;
    return wasSet;
  }

  public Date getFechaSiembra()
  {
    return fechaSiembra;
  }

  public int getDensidadPL()
  {
    return densidadPL;
  }

  public String getEstado()
  {
    return estado;
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
  /* Code from template association_GetOne */
  public Cosecha getCosecha()
  {
    return cosecha;
  }

  public boolean hasCosecha()
  {
    boolean has = cosecha != null;
    return has;
  }
  /* Code from template association_GetOne */
  public Piscina getPiscina()
  {
    return piscina;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfMuestreos()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Muestreo addMuestreo(Date aFecha, double aPesoPromG, Empleado aEmpleado)
  {
    return new Muestreo(aFecha, aPesoPromG, aEmpleado, this);
  }

  public boolean addMuestreo(Muestreo aMuestreo)
  {
    boolean wasAdded = false;
    if (muestreos.contains(aMuestreo)) { return false; }
    CicloCultivo existingCicloCultivo = aMuestreo.getCicloCultivo();
    boolean isNewCicloCultivo = existingCicloCultivo != null && !this.equals(existingCicloCultivo);
    if (isNewCicloCultivo)
    {
      aMuestreo.setCicloCultivo(this);
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
    //Unable to remove aMuestreo, as it must always have a cicloCultivo
    if (!this.equals(aMuestreo.getCicloCultivo()))
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAlimentacions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Alimentacion addAlimentacion(Date aFecha, double aCantidadKg, Insumo aInsumo)
  {
    return new Alimentacion(aFecha, aCantidadKg, aInsumo, this);
  }

  public boolean addAlimentacion(Alimentacion aAlimentacion)
  {
    boolean wasAdded = false;
    if (alimentacions.contains(aAlimentacion)) { return false; }
    CicloCultivo existingCicloCultivo = aAlimentacion.getCicloCultivo();
    boolean isNewCicloCultivo = existingCicloCultivo != null && !this.equals(existingCicloCultivo);
    if (isNewCicloCultivo)
    {
      aAlimentacion.setCicloCultivo(this);
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
    //Unable to remove aAlimentacion, as it must always have a cicloCultivo
    if (!this.equals(aAlimentacion.getCicloCultivo()))
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
  /* Code from template association_SetOptionalOneToOne */
  public boolean setCosecha(Cosecha aNewCosecha)
  {
    boolean wasSet = false;
    if (cosecha != null && !cosecha.equals(aNewCosecha) && equals(cosecha.getCicloCultivo()))
    {
      //Unable to setCosecha, as existing cosecha would become an orphan
      return wasSet;
    }

    cosecha = aNewCosecha;
    CicloCultivo anOldCicloCultivo = aNewCosecha != null ? aNewCosecha.getCicloCultivo() : null;

    if (!this.equals(anOldCicloCultivo))
    {
      if (anOldCicloCultivo != null)
      {
        anOldCicloCultivo.cosecha = null;
      }
      if (cosecha != null)
      {
        cosecha.setCicloCultivo(this);
      }
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setPiscina(Piscina aPiscina)
  {
    boolean wasSet = false;
    if (aPiscina == null)
    {
      return wasSet;
    }

    Piscina existingPiscina = piscina;
    piscina = aPiscina;
    if (existingPiscina != null && !existingPiscina.equals(aPiscina))
    {
      existingPiscina.removeCicloCultivo(this);
    }
    piscina.addCicloCultivo(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    while (muestreos.size() > 0)
    {
      Muestreo aMuestreo = muestreos.get(muestreos.size() - 1);
      aMuestreo.delete();
      muestreos.remove(aMuestreo);
    }
    
    while (alimentacions.size() > 0)
    {
      Alimentacion aAlimentacion = alimentacions.get(alimentacions.size() - 1);
      aAlimentacion.delete();
      alimentacions.remove(aAlimentacion);
    }
    
    Cosecha existingCosecha = cosecha;
    cosecha = null;
    if (existingCosecha != null)
    {
      existingCosecha.delete();
      existingCosecha.setCicloCultivo(null);
    }
    Piscina placeholderPiscina = piscina;
    this.piscina = null;
    if(placeholderPiscina != null)
    {
      placeholderPiscina.removeCicloCultivo(this);
    }
  }

  // line 34 "../../../../../model.ump"
  public void registrarMuestreo(Muestreo m){
    addMuestreo(m);
  }

  // line 38 "../../../../../model.ump"
  public void cerrarCiclo(){
    setEstado("cerrado");
  }


  public String toString()
  {
    return super.toString() + "["+
            "densidadPL" + ":" + getDensidadPL()+ "," +
            "estado" + ":" + getEstado()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "fechaSiembra" + "=" + (getFechaSiembra() != null ? !getFechaSiembra().equals(this)  ? getFechaSiembra().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "cosecha = "+(getCosecha()!=null?Integer.toHexString(System.identityHashCode(getCosecha())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "piscina = "+(getPiscina()!=null?Integer.toHexString(System.identityHashCode(getPiscina())):"null");
  }
}