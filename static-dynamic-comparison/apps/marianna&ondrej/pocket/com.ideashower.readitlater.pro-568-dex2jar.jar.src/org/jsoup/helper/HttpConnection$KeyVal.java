package org.jsoup.helper;

import org.jsoup.Connection.KeyVal;

public class HttpConnection$KeyVal
  implements Connection.KeyVal
{
  private String key;
  private String value;
  
  private HttpConnection$KeyVal(String paramString1, String paramString2)
  {
    this.key = paramString1;
    this.value = paramString2;
  }
  
  public static KeyVal create(String paramString1, String paramString2)
  {
    Validate.notEmpty(paramString1, "Data key must not be empty");
    Validate.notNull(paramString2, "Data value must not be null");
    return new KeyVal(paramString1, paramString2);
  }
  
  public String key()
  {
    return this.key;
  }
  
  public KeyVal key(String paramString)
  {
    Validate.notEmpty(paramString, "Data key must not be empty");
    this.key = paramString;
    return this;
  }
  
  public String toString()
  {
    return this.key + "=" + this.value;
  }
  
  public String value()
  {
    return this.value;
  }
  
  public KeyVal value(String paramString)
  {
    Validate.notNull(paramString, "Data value must not be null");
    this.value = paramString;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/helper/HttpConnection$KeyVal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */