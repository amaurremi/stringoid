package com.fasterxml.jackson.databind;

public class PropertyName
{
  public static final PropertyName NO_NAME = new PropertyName(new String("#disabled"), null);
  public static final PropertyName USE_DEFAULT = new PropertyName("", null);
  protected final String _namespace;
  protected final String _simpleName;
  
  public PropertyName(String paramString)
  {
    this(paramString, null);
  }
  
  public PropertyName(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    this._simpleName = str;
    this._namespace = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool4 = true;
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool3;
        } while (paramObject == null);
        bool1 = bool3;
      } while (paramObject.getClass() != PropertyName.class);
      if (USE_DEFAULT == paramObject)
      {
        if (this == USE_DEFAULT) {}
        for (bool1 = bool2;; bool1 = false) {
          return bool1;
        }
      }
      if (this._simpleName != null) {
        break;
      }
      bool1 = bool3;
    } while (this._simpleName != null);
    if (this._namespace == null)
    {
      if (this._namespace == null) {}
      for (bool1 = bool4;; bool1 = false)
      {
        return bool1;
        if (this._simpleName.equals(this._simpleName)) {
          break;
        }
        return false;
      }
    }
    return this._namespace.equals(this._namespace);
  }
  
  public String getSimpleName()
  {
    return this._simpleName;
  }
  
  public boolean hasSimpleName()
  {
    return this._simpleName.length() > 0;
  }
  
  public int hashCode()
  {
    if (this._namespace == null) {
      return this._simpleName.hashCode();
    }
    return this._namespace.hashCode() ^ this._simpleName.hashCode();
  }
  
  public String toString()
  {
    if (this._namespace == null) {
      return this._simpleName;
    }
    return "{" + this._namespace + "}" + this._simpleName;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/PropertyName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */