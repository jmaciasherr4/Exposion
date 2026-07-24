/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.37.0.8639.dcaf9c798 modeling language!*/

package ec.uteq.camaronera.piscinas;
import java.util.*;
import java.sql.Date;

// line 14 "../../../../../model.ump"
// line 96 "../../../../../model.ump"
public class Piscina
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Piscina Attributes
  private String codigo;
  private double areaHa;

  //Piscina Associations
  private List<CicloCultivo> cicloCultivos;
  private Camaronera camaronera;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Piscina(String aCodigo, double aAreaHa, Camaronera aCamaronera)
  {
    codigo = aCodigo;
    areaHa = aAreaHa;
    cicloCultivos = new ArrayList<CicloCultivo>();
    boolean didAddCamaronera = setCamaronera(aCamaronera);
    if (!didAddCamaronera)
    {
      throw new RuntimeException("Unable to create piscina due to camaronera. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCodigo(String aCodigo)
  {
    boolean wasSet = false;
    codigo = aCodigo;
    wasSet = true;
    return wasSet;
  }

  public boolean setAreaHa(double aAreaHa)
  {
    boolean wasSet = false;
    areaHa = aAreaHa;
    wasSet = true;
    return wasSet;
  }

  public String getCodigo()
  {
    return codigo;
  }

  public double getAreaHa()
  {
    return areaHa;
  }
  /* Code from template association_GetMany */
  public CicloCultivo getCicloCultivo(int index)
  {
    CicloCultivo aCicloCultivo = cicloCultivos.get(index);
    return aCicloCultivo;
  }

  public List<CicloCultivo> getCicloCultivos()
  {
    List<CicloCultivo> newCicloCultivos = Collections.unmodifiableList(cicloCultivos);
    return newCicloCultivos;
  }

  public int numberOfCicloCultivos()
  {
    int number = cicloCultivos.size();
    return number;
  }

  public boolean hasCicloCultivos()
  {
    boolean has = cicloCultivos.size() > 0;
    return has;
  }

  public int indexOfCicloCultivo(CicloCultivo aCicloCultivo)
  {
    int index = cicloCultivos.indexOf(aCicloCultivo);
    return index;
  }
  /* Code from template association_GetOne */
  public Camaronera getCamaronera()
  {
    return camaronera;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCicloCultivos()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public CicloCultivo addCicloCultivo(Date aFechaSiembra, int aDensidadPL, String aEstado)
  {
    return new CicloCultivo(aFechaSiembra, aDensidadPL, aEstado, this);
  }

  public boolean addCicloCultivo(CicloCultivo aCicloCultivo)
  {
    boolean wasAdded = false;
    if (cicloCultivos.contains(aCicloCultivo)) { return false; }
    Piscina existingPiscina = aCicloCultivo.getPiscina();
    boolean isNewPiscina = existingPiscina != null && !this.equals(existingPiscina);
    if (isNewPiscina)
    {
      aCicloCultivo.setPiscina(this);
    }
    else
    {
      cicloCultivos.add(aCicloCultivo);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCicloCultivo(CicloCultivo aCicloCultivo)
  {
    boolean wasRemoved = false;
    //Unable to remove aCicloCultivo, as it must always have a piscina
    if (!this.equals(aCicloCultivo.getPiscina()))
    {
      cicloCultivos.remove(aCicloCultivo);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCicloCultivoAt(CicloCultivo aCicloCultivo, int index)
  {  
    boolean wasAdded = false;
    if(addCicloCultivo(aCicloCultivo))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCicloCultivos()) { index = numberOfCicloCultivos() - 1; }
      cicloCultivos.remove(aCicloCultivo);
      cicloCultivos.add(index, aCicloCultivo);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCicloCultivoAt(CicloCultivo aCicloCultivo, int index)
  {
    boolean wasAdded = false;
    if(cicloCultivos.contains(aCicloCultivo))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCicloCultivos()) { index = numberOfCicloCultivos() - 1; }
      cicloCultivos.remove(aCicloCultivo);
      cicloCultivos.add(index, aCicloCultivo);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCicloCultivoAt(aCicloCultivo, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setCamaronera(Camaronera aCamaronera)
  {
    boolean wasSet = false;
    if (aCamaronera == null)
    {
      return wasSet;
    }

    Camaronera existingCamaronera = camaronera;
    camaronera = aCamaronera;
    if (existingCamaronera != null && !existingCamaronera.equals(aCamaronera))
    {
      existingCamaronera.removePiscina(this);
    }
    camaronera.addPiscina(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=cicloCultivos.size(); i > 0; i--)
    {
      CicloCultivo aCicloCultivo = cicloCultivos.get(i - 1);
      aCicloCultivo.delete();
    }
    Camaronera placeholderCamaronera = camaronera;
    this.camaronera = null;
    if(placeholderCamaronera != null)
    {
      placeholderCamaronera.removePiscina(this);
    }
  }

  // line 20 "../../../../../model.ump"
  public void iniciarCiclo(CicloCultivo c){
    addCicloCultivo(c);
  }


  public String toString()
  {
    return super.toString() + "["+
            "codigo" + ":" + getCodigo()+ "," +
            "areaHa" + ":" + getAreaHa()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "camaronera = "+(getCamaronera()!=null?Integer.toHexString(System.identityHashCode(getCamaronera())):"null");
  }
}