package com.amazonaws.javax.xml.stream.xerces.util;

import com.amazonaws.javax.xml.stream.xerces.xni.NamespaceContext;
import java.util.Enumeration;

public class NamespaceSupport
  implements NamespaceContext
{
  protected int[] fContext = new int[8];
  protected int fCurrentContext;
  protected String[] fNamespace = new String[32];
  protected int fNamespaceSize;
  protected String[] fPrefixes = new String[16];
  
  public NamespaceSupport() {}
  
  public NamespaceSupport(NamespaceContext paramNamespaceContext)
  {
    pushContext();
    Enumeration localEnumeration = paramNamespaceContext.getAllPrefixes();
    while (localEnumeration.hasMoreElements())
    {
      String str = (String)localEnumeration.nextElement();
      declarePrefix(str, paramNamespaceContext.getURI(str));
    }
  }
  
  public boolean containsPrefixInCurrentContext(String paramString)
  {
    int i = this.fContext[this.fCurrentContext];
    while (i < this.fNamespaceSize)
    {
      if (this.fNamespace[i] == paramString) {
        return true;
      }
      i += 2;
    }
    return false;
  }
  
  public boolean declarePrefix(String paramString1, String paramString2)
  {
    if ((paramString1 == XMLSymbols.PREFIX_XML) || (paramString1 == XMLSymbols.PREFIX_XMLNS)) {
      return false;
    }
    int i = this.fNamespaceSize;
    while (i > this.fContext[this.fCurrentContext])
    {
      if (this.fNamespace[(i - 2)] == paramString1)
      {
        this.fNamespace[(i - 1)] = paramString2;
        return true;
      }
      i -= 2;
    }
    if (this.fNamespaceSize == this.fNamespace.length)
    {
      arrayOfString = new String[this.fNamespaceSize * 2];
      System.arraycopy(this.fNamespace, 0, arrayOfString, 0, this.fNamespaceSize);
      this.fNamespace = arrayOfString;
    }
    String[] arrayOfString = this.fNamespace;
    i = this.fNamespaceSize;
    this.fNamespaceSize = (i + 1);
    arrayOfString[i] = paramString1;
    paramString1 = this.fNamespace;
    i = this.fNamespaceSize;
    this.fNamespaceSize = (i + 1);
    paramString1[i] = paramString2;
    return true;
  }
  
  public Enumeration getAllPrefixes()
  {
    if (this.fPrefixes.length < this.fNamespace.length / 2) {
      this.fPrefixes = new String[this.fNamespaceSize];
    }
    int j = 2;
    int i = 0;
    String str;
    if (j < this.fNamespaceSize - 2)
    {
      str = this.fNamespace[(j + 2)];
      k = 0;
      label52:
      if (k >= i) {
        break label123;
      }
      if (this.fPrefixes[k] != str) {}
    }
    label123:
    for (int k = 0;; k = 1)
    {
      if (k != 0)
      {
        String[] arrayOfString = this.fPrefixes;
        k = i + 1;
        arrayOfString[i] = str;
        i = k;
      }
      for (;;)
      {
        j += 2;
        break;
        k += 1;
        break label52;
        return new NamespaceSupport.Prefixes(this, this.fPrefixes, i);
      }
    }
  }
  
  public String getDeclaredPrefixAt(int paramInt)
  {
    return this.fNamespace[(this.fContext[this.fCurrentContext] + paramInt * 2)];
  }
  
  public int getDeclaredPrefixCount()
  {
    return (this.fNamespaceSize - this.fContext[this.fCurrentContext]) / 2;
  }
  
  public String getURI(String paramString)
  {
    int i = this.fNamespaceSize;
    while (i > 0)
    {
      if (this.fNamespace[(i - 2)] == paramString) {
        return this.fNamespace[(i - 1)];
      }
      i -= 2;
    }
    return null;
  }
  
  public void popContext()
  {
    int[] arrayOfInt = this.fContext;
    int i = this.fCurrentContext;
    this.fCurrentContext = (i - 1);
    this.fNamespaceSize = arrayOfInt[i];
  }
  
  public void pushContext()
  {
    if (this.fCurrentContext + 1 == this.fContext.length)
    {
      arrayOfInt = new int[this.fContext.length * 2];
      System.arraycopy(this.fContext, 0, arrayOfInt, 0, this.fContext.length);
      this.fContext = arrayOfInt;
    }
    int[] arrayOfInt = this.fContext;
    int i = this.fCurrentContext + 1;
    this.fCurrentContext = i;
    arrayOfInt[i] = this.fNamespaceSize;
  }
  
  public void reset()
  {
    this.fNamespaceSize = 0;
    this.fCurrentContext = 0;
    String[] arrayOfString = this.fNamespace;
    int i = this.fNamespaceSize;
    this.fNamespaceSize = (i + 1);
    arrayOfString[i] = XMLSymbols.PREFIX_XML;
    arrayOfString = this.fNamespace;
    i = this.fNamespaceSize;
    this.fNamespaceSize = (i + 1);
    arrayOfString[i] = NamespaceContext.XML_URI;
    arrayOfString = this.fNamespace;
    i = this.fNamespaceSize;
    this.fNamespaceSize = (i + 1);
    arrayOfString[i] = XMLSymbols.PREFIX_XMLNS;
    arrayOfString = this.fNamespace;
    i = this.fNamespaceSize;
    this.fNamespaceSize = (i + 1);
    arrayOfString[i] = NamespaceContext.XMLNS_URI;
    this.fContext[this.fCurrentContext] = this.fNamespaceSize;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/util/NamespaceSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */