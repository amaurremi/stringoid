package org.codehaus.jackson.map.type;

public final class ClassKey
  implements Comparable
{
  private Class _class;
  private String _className;
  private int _hashCode;
  
  public ClassKey()
  {
    this._class = null;
    this._className = null;
    this._hashCode = 0;
  }
  
  public ClassKey(Class paramClass)
  {
    this._class = paramClass;
    this._className = paramClass.getName();
    this._hashCode = this._className.hashCode();
  }
  
  public int compareTo(ClassKey paramClassKey)
  {
    return this._className.compareTo(paramClassKey._className);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (paramObject.getClass() != getClass()) {
        return false;
      }
    } while (((ClassKey)paramObject)._class == this._class);
    return false;
  }
  
  public int hashCode()
  {
    return this._hashCode;
  }
  
  public void reset(Class paramClass)
  {
    this._class = paramClass;
    this._className = paramClass.getName();
    this._hashCode = this._className.hashCode();
  }
  
  public String toString()
  {
    return this._className;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/type/ClassKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */