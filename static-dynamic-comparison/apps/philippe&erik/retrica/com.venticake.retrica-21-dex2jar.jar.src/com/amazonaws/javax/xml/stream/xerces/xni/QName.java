package com.amazonaws.javax.xml.stream.xerces.xni;

public class QName
  implements Cloneable
{
  public char[] characters = null;
  public String localpart;
  public String prefix;
  public String rawname;
  public String uri;
  
  public QName()
  {
    clear();
  }
  
  public QName(QName paramQName)
  {
    setValues(paramQName);
  }
  
  public QName(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    setValues(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void clear()
  {
    this.prefix = null;
    this.localpart = null;
    this.rawname = null;
    this.uri = null;
  }
  
  public Object clone()
  {
    return new QName(this);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof QName))
    {
      paramObject = (QName)paramObject;
      if (((QName)paramObject).uri != null) {
        if ((this.uri != ((QName)paramObject).uri) || (this.localpart != ((QName)paramObject).localpart)) {}
      }
      do
      {
        return true;
        return false;
        if (this.uri != null) {
          break;
        }
      } while (this.rawname == ((QName)paramObject).rawname);
      return false;
    }
    return false;
  }
  
  public int hashCode()
  {
    if (this.uri != null) {
      return this.uri.hashCode() + this.localpart.hashCode();
    }
    return this.rawname.hashCode();
  }
  
  public void setValues(QName paramQName)
  {
    this.prefix = paramQName.prefix;
    this.localpart = paramQName.localpart;
    this.rawname = paramQName.rawname;
    this.uri = paramQName.uri;
    this.characters = paramQName.characters;
  }
  
  public void setValues(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.prefix = paramString1;
    this.localpart = paramString2;
    this.rawname = paramString3;
    this.uri = paramString4;
  }
  
  public String toString()
  {
    int k = 1;
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (this.prefix != null)
    {
      localStringBuffer.append("prefix=\"" + this.prefix + '"');
      i = 1;
    }
    int j = i;
    if (this.localpart != null)
    {
      if (i != 0) {
        localStringBuffer.append(',');
      }
      localStringBuffer.append("localpart=\"" + this.localpart + '"');
      j = 1;
    }
    if (this.rawname != null)
    {
      if (j != 0) {
        localStringBuffer.append(',');
      }
      localStringBuffer.append("rawname=\"" + this.rawname + '"');
    }
    for (i = k;; i = j)
    {
      if (this.uri != null)
      {
        if (i != 0) {
          localStringBuffer.append(',');
        }
        localStringBuffer.append("uri=\"" + this.uri + '"');
      }
      return localStringBuffer.toString();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/xerces/xni/QName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */