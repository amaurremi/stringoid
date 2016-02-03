package com.amazonaws.javax.xml.stream.xerces.util;

import java.util.Enumeration;
import java.util.NoSuchElementException;

public final class NamespaceSupport$Prefixes
  implements Enumeration
{
  private int counter = 0;
  private String[] prefixes;
  private int size = 0;
  
  public NamespaceSupport$Prefixes(NamespaceSupport paramNamespaceSupport, String[] paramArrayOfString, int paramInt)
  {
    this.prefixes = paramArrayOfString;
    this.size = paramInt;
  }
  
  public boolean hasMoreElements()
  {
    return this.counter < this.size;
  }
  
  public Object nextElement()
  {
    if (this.counter < this.size)
    {
      String[] arrayOfString = this.this$0.fPrefixes;
      int i = this.counter;
      this.counter = (i + 1);
      return arrayOfString[i];
    }
    throw new NoSuchElementException("Illegal access to Namespace prefixes enumeration.");
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < this.size)
    {
      localStringBuffer.append(this.prefixes[i]);
      localStringBuffer.append(" ");
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/util/NamespaceSupport$Prefixes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */