package com.google.api.client.googleapis.media;

import com.google.api.client.http.o;
import com.google.api.client.http.q;
import com.google.api.client.http.t;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class b
  implements o, com.google.api.client.http.x
{
  static final Logger aao = Logger.getLogger(b.class.getName());
  private final MediaHttpUploader aap;
  private final o aaq;
  private final com.google.api.client.http.x aar;
  
  public b(MediaHttpUploader paramMediaHttpUploader, q paramq)
  {
    this.aap = ((MediaHttpUploader)com.google.api.client.util.x.ad(paramMediaHttpUploader));
    this.aaq = paramq.xF();
    this.aar = paramq.xE();
    paramq.a(this);
    paramq.a(this);
  }
  
  public boolean a(q paramq, t paramt, boolean paramBoolean)
  {
    if ((this.aar != null) && (this.aar.a(paramq, paramt, paramBoolean))) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (paramBoolean) && (paramt.getStatusCode() / 100 == 5)) {}
      try
      {
        this.aap.wT();
        return bool;
      }
      catch (IOException paramq)
      {
        aao.log(Level.WARNING, "exception thrown while calling server callback", paramq);
      }
    }
    return bool;
  }
  
  public boolean a(q paramq, boolean paramBoolean)
  {
    if ((this.aaq != null) && (this.aaq.a(paramq, paramBoolean))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (paramBoolean) {}
      try
      {
        this.aap.wT();
        return paramBoolean;
      }
      catch (IOException paramq)
      {
        aao.log(Level.WARNING, "exception thrown while calling server callback", paramq);
      }
    }
    return paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/googleapis/media/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */