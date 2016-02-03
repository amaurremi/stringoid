package com.google.api.client.googleapis.json;

import com.google.api.client.json.b;
import com.google.api.client.util.i;
import com.google.api.client.util.o;
import java.util.List;

public class a
  extends b
{
  @o
  private int code;
  @o
  private List<a> errors;
  @o
  private String message;
  
  static
  {
    i.j(a.class);
  }
  
  public a c(String paramString, Object paramObject)
  {
    return (a)super.set(paramString, paramObject);
  }
  
  public a wO()
  {
    return (a)super.clone();
  }
  
  public static class a
    extends b
  {
    @o
    private String domain;
    @o
    private String location;
    @o
    private String locationType;
    @o
    private String message;
    @o
    private String reason;
    
    public a d(String paramString, Object paramObject)
    {
      return (a)super.set(paramString, paramObject);
    }
    
    public a wP()
    {
      return (a)super.clone();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/googleapis/json/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */