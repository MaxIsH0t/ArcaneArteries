package ThaumicStuff;

public class Pair<A, B>
{
  private A key;
  private B value;
  
  public Pair(A key, B value) {
    this.key = key;
    this.value = value;
  }
  
  public A getKey() {
    return key;
  }
  
  public B getValue() {
    return value;
  }
  
  public int hashCode()
  {
    int hash = 1;
    hash = hash * 37 + (key == null ? 0 : key.hashCode());
    hash = hash * 37 + (value == null ? 0 : value.hashCode());
    return hash;
  }
  

  public boolean equals(Object obj)
  {
    return ((obj instanceof Pair)) && (key.equals(key)) && (value.equals(value));
  }
}
