package com.google.api.client.json;

import com.google.api.client.util.GenericData;
import com.google.api.client.util.ad;
import java.io.IOException;

public class b
  extends GenericData
  implements Cloneable
{
  private d acn;
  
  public b clone()
  {
    return (b)super.clone();
  }
  
  public final d getFactory()
  {
    return this.acn;
  }
  
  public b set(String paramString, Object paramObject)
  {
    return (b)super.set(paramString, paramObject);
  }
  
  public final void setFactory(d paramd)
  {
    this.acn = paramd;
  }
  
  public String toPrettyString()
  {
    if (this.acn != null) {
      return this.acn.aa(this);
    }
    return super.toString();
  }
  
  public String toString()
  {
    if (this.acn != null) {
      try
      {
        String str = this.acn.toString(this);
        return str;
      }
      catch (IOException localIOException)
      {
        throw ad.f(localIOException);
      }
    }
    return super.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/json/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */