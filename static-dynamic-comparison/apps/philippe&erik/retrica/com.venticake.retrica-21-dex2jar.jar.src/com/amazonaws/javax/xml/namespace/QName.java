package com.amazonaws.javax.xml.namespace;

import java.io.Serializable;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class QName
  implements Serializable
{
  private static final long serialVersionUID;
  private static boolean useDefaultSerialVersionUID = true;
  private final String localPart;
  private final String namespaceURI;
  private final String prefix;
  
  static
  {
    for (;;)
    {
      try
      {
        String str = (String)AccessController.doPrivileged(new PrivilegedAction()
        {
          public Object run()
          {
            return System.getProperty("com.sun.xml.namespace.QName.useCompatibleSerialVersionUID");
          }
        });
        if ((str == null) || (!str.equals("1.0"))) {
          continue;
        }
        bool = false;
        useDefaultSerialVersionUID = bool;
      }
      catch (Exception localException)
      {
        boolean bool;
        useDefaultSerialVersionUID = true;
        continue;
        serialVersionUID = 4418622981026545151L;
      }
      if (!useDefaultSerialVersionUID) {
        continue;
      }
      serialVersionUID = -9120448754896609940L;
      return;
      bool = true;
    }
  }
  
  public QName(String paramString)
  {
    this("", paramString, "");
  }
  
  public QName(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, "");
  }
  
  public QName(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {}
    for (this.namespaceURI = ""; paramString2 == null; this.namespaceURI = paramString1) {
      throw new IllegalArgumentException("local part cannot be \"null\" when creating a QName");
    }
    this.localPart = paramString2;
    if (paramString3 == null) {
      throw new IllegalArgumentException("prefix cannot be \"null\" when creating a QName");
    }
    this.prefix = paramString3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof QName))) {
        return false;
      }
      paramObject = (QName)paramObject;
    } while ((this.localPart.equals(((QName)paramObject).localPart)) && (this.namespaceURI.equals(((QName)paramObject).namespaceURI)));
    return false;
  }
  
  public String getLocalPart()
  {
    return this.localPart;
  }
  
  public String getNamespaceURI()
  {
    return this.namespaceURI;
  }
  
  public String getPrefix()
  {
    return this.prefix;
  }
  
  public final int hashCode()
  {
    return this.namespaceURI.hashCode() ^ this.localPart.hashCode();
  }
  
  public String toString()
  {
    if (this.namespaceURI.equals("")) {
      return this.localPart;
    }
    return "{" + this.namespaceURI + "}" + this.localPart;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/namespace/QName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */