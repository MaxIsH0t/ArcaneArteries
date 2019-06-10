package BloodStuff;


public class Vector3
{
  public int x;
  
  public int y;
  public int z;
  
  public Vector3(int x, int y, int z)
  {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  public Vector3 add(Vector3 vec1)
  {
    return new Vector3(x + x, y + y, z + z);
  }
  

  public String toString()
  {
    return "V3(" + x + "}, " + y + "}," + z + "})";
  }
  
  private boolean canEqual(Object object)
  {
    return object instanceof Vector3;
  }
  

  public boolean equals(Object object)
  {
    return object == this;
  }
  

  public int hashCode()
  {
    return 48131 * x - 95021 * y + z;
  }
}
