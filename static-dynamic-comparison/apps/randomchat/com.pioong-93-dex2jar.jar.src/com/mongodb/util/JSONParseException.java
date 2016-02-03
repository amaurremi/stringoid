package com.mongodb.util;

public class JSONParseException
  extends RuntimeException
{
  private static final long serialVersionUID = -4415279469780082174L;
  int pos;
  String s;
  
  public JSONParseException(String paramString, int paramInt)
  {
    this.s = paramString;
    this.pos = paramInt;
  }
  
  public JSONParseException(String paramString, int paramInt, Throwable paramThrowable)
  {
    super(paramThrowable);
    this.s = paramString;
    this.pos = paramInt;
  }
  
  public String getMessage()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n");
    localStringBuilder.append(this.s);
    localStringBuilder.append("\n");
    int i = 0;
    while (i < this.pos)
    {
      localStringBuilder.append(" ");
      i += 1;
    }
    localStringBuilder.append("^");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/JSONParseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */