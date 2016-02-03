package com.google.api.client.http;

import com.google.api.client.util.aa;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class h
  implements k
{
  public void a(aa paramaa, OutputStream paramOutputStream)
  {
    paramOutputStream = new GZIPOutputStream(new FilterOutputStream(paramOutputStream)
    {
      public void close()
      {
        try
        {
          flush();
          return;
        }
        catch (IOException localIOException) {}
      }
    });
    paramaa.writeTo(paramOutputStream);
    paramOutputStream.close();
  }
  
  public String getName()
  {
    return "gzip";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/http/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */