package com.parse.entity.mime;

public class MinimalField
{
  private final String name;
  private final String value;
  
  MinimalField(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.value = paramString2;
  }
  
  public String getBody()
  {
    return this.value;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name);
    localStringBuilder.append(": ");
    localStringBuilder.append(this.value);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/parse/entity/mime/MinimalField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */