package com.google.api.client.http;

import com.google.api.client.util.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public final class g
  extends b
{
  private final File file;
  
  public g(String paramString, File paramFile)
  {
    super(paramString);
    this.file = ((File)x.ad(paramFile));
  }
  
  public g ar(boolean paramBoolean)
  {
    return (g)super.ap(paramBoolean);
  }
  
  public g bJ(String paramString)
  {
    return (g)super.bH(paramString);
  }
  
  public InputStream getInputStream()
  {
    return new FileInputStream(this.file);
  }
  
  public long getLength()
  {
    return this.file.length();
  }
  
  public boolean xl()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */