/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.0.8639.dcaf9c798 modeling language!*/

package ec.uteq.camaronera.piscinas;
import java.util.*;

// line 4 "../../../../../model.ump"
// line 91 "../../../../../model.ump"
public class Camaronera
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Camaronera Attributes
  private String nombre;
  private String ubicacion;

  //Camaronera Associations
  private List<Piscina> piscinas;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Camaronera(String aNombre, String aUbicacion)
  {
    nombre = aNombre;
    ubicacion = aUbicacion;
    piscinas = new ArrayList<Piscina>();
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

  public boolean setUbicacion(String aUbicacion)
  {
    boolean wasSet = false;
    ubicacion = aUbicacion;
    wasSet = true;
    return wasSet;
  }

  public String getNombre()
  {
    return nombre;
  }

  public String getUbicacion()
  {
    return ubicacion;
  }
  /* Code from template association_GetMany */
  public Piscina getPiscina(int index)
  {
    Piscina aPiscina = piscinas.get(index);
    return aPiscina;
  }

  public List<Piscina> getPiscinas()
  {
    List<Piscina> newPiscinas = Collections.unmodifiableList(piscinas);
    return newPiscinas;
  }

  public int numberOfPiscinas()
  {
    int number = piscinas.size();
    return number;
  }

  public boolean hasPiscinas()
  {
    boolean has = piscinas.size() > 0;
    return has;
  }

  public int indexOfPiscina(Piscina aPiscina)
  {
    int index = piscinas.indexOf(aPiscina);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPiscinas()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Piscina addPiscina(String aCodigo, double aAreaHa)
  {
    return new Piscina(aCodigo, aAreaHa, this);
  }

  public boolean addPiscina(Piscina aPiscina)
  {
    boolean wasAdded = false;
    if (piscinas.contains(aPiscina)) { return false; }
    Camaronera existingCamaronera = aPiscina.getCamaronera();
    boolean isNewCamaronera = existingCamaronera != null && !this.equals(existingCamaronera);
    if (isNewCamaronera)
    {
      aPiscina.setCamaronera(this);
    }
    else
    {
      piscinas.add(aPiscina);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePiscina(Piscina aPiscina)
  {
    boolean wasRemoved = false;
    //Unable to remove aPiscina, as it must always have a camaronera
    if (!this.equals(aPiscina.getCamaronera()))
    {
      piscinas.remove(aPiscina);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPiscinaAt(Piscina aPiscina, int index)
  {  
    boolean wasAdded = false;
    if(addPiscina(aPiscina))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPiscinas()) { index = numberOfPiscinas() - 1; }
      piscinas.remove(aPiscina);
      piscinas.add(index, aPiscina);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePiscinaAt(Piscina aPiscina, int index)
  {
    boolean wasAdded = false;
    if(piscinas.contains(aPiscina))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPiscinas()) { index = numberOfPiscinas() - 1; }
      piscinas.remove(aPiscina);
      piscinas.add(index, aPiscina);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPiscinaAt(aPiscina, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=piscinas.size(); i > 0; i--)
    {
      Piscina aPiscina = piscinas.get(i - 1);
      aPiscina.delete();
    }
  }

  // line 10 "../../../../../model.ump"
  public void registrarPiscina(Piscina p){
    addPiscina(p);
  }


  public String toString()
  {
    return super.toString() + "["+
            "nombre" + ":" + getNombre()+ "," +
            "ubicacion" + ":" + getUbicacion()+ "]";
  }
}