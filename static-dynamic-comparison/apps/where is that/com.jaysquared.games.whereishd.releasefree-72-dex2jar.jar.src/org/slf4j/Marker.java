package org.slf4j;

import java.io.Serializable;
import java.util.Iterator;

public abstract interface Marker
  extends Serializable
{
  public static final String ANY_MARKER = "*";
  public static final String ANY_NON_NULL_MARKER = "+";
  
  public abstract void add(Marker paramMarker);
  
  public abstract boolean contains(String paramString);
  
  public abstract boolean contains(Marker paramMarker);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract String getName();
  
  public abstract boolean hasChildren();
  
  public abstract boolean hasReferences();
  
  public abstract int hashCode();
  
  public abstract Iterator iterator();
  
  public abstract boolean remove(Marker paramMarker);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/slf4j/Marker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */