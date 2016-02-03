package com.amazonaws.javax.xml.stream;

public class FactoryConfigurationError
  extends Error
{
  Exception nested;
  
  public FactoryConfigurationError() {}
  
  public FactoryConfigurationError(String paramString)
  {
    super(paramString);
  }
  
  public Throwable getCause()
  {
    return this.nested;
  }
  
  public String getMessage()
  {
    Object localObject = super.getMessage();
    if (localObject != null) {}
    String str;
    do
    {
      do
      {
        return (String)localObject;
      } while (this.nested == null);
      str = this.nested.getMessage();
      localObject = str;
    } while (str != null);
    return this.nested.getClass().toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/FactoryConfigurationError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */