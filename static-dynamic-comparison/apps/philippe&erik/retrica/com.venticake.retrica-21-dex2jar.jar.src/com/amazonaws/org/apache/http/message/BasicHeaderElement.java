package com.amazonaws.org.apache.http.message;

import com.amazonaws.org.apache.http.HeaderElement;
import com.amazonaws.org.apache.http.NameValuePair;
import com.amazonaws.org.apache.http.util.LangUtils;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class BasicHeaderElement
  implements HeaderElement, Cloneable
{
  private final String name;
  private final NameValuePair[] parameters;
  private final String value;
  
  public BasicHeaderElement(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null);
  }
  
  public BasicHeaderElement(String paramString1, String paramString2, NameValuePair[] paramArrayOfNameValuePair)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Name may not be null");
    }
    this.name = paramString1;
    this.value = paramString2;
    if (paramArrayOfNameValuePair != null)
    {
      this.parameters = paramArrayOfNameValuePair;
      return;
    }
    this.parameters = new NameValuePair[0];
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof HeaderElement)) {
        break;
      }
      paramObject = (BasicHeaderElement)paramObject;
    } while ((this.name.equals(((BasicHeaderElement)paramObject).name)) && (LangUtils.equals(this.value, ((BasicHeaderElement)paramObject).value)) && (LangUtils.equals(this.parameters, ((BasicHeaderElement)paramObject).parameters)));
    return false;
    return false;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public NameValuePair getParameter(int paramInt)
  {
    return this.parameters[paramInt];
  }
  
  public NameValuePair getParameterByName(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Name may not be null");
    }
    int i = 0;
    while (i < this.parameters.length)
    {
      NameValuePair localNameValuePair = this.parameters[i];
      if (localNameValuePair.getName().equalsIgnoreCase(paramString)) {
        return localNameValuePair;
      }
      i += 1;
    }
    return null;
  }
  
  public int getParameterCount()
  {
    return this.parameters.length;
  }
  
  public NameValuePair[] getParameters()
  {
    return (NameValuePair[])this.parameters.clone();
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    int j = LangUtils.hashCode(LangUtils.hashCode(17, this.name), this.value);
    int i = 0;
    while (i < this.parameters.length)
    {
      j = LangUtils.hashCode(j, this.parameters[i]);
      i += 1;
    }
    return j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name);
    if (this.value != null)
    {
      localStringBuilder.append("=");
      localStringBuilder.append(this.value);
    }
    int i = 0;
    while (i < this.parameters.length)
    {
      localStringBuilder.append("; ");
      localStringBuilder.append(this.parameters[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/message/BasicHeaderElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */