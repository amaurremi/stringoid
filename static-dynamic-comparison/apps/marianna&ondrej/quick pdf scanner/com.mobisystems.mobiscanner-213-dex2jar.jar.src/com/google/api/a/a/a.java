package com.google.api.a.a;

import com.google.api.client.http.s;
import com.google.api.client.http.w;
import com.google.api.client.json.d;
import com.google.api.client.util.o;
import com.google.api.client.util.x;

public class a
  extends com.google.api.client.googleapis.a.a.a
{
  static
  {
    if ((com.google.api.client.googleapis.a.Zw.intValue() == 1) && (com.google.api.client.googleapis.a.Zx.intValue() >= 15)) {}
    for (boolean bool = true;; bool = false)
    {
      x.c(bool, "You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.16.0-rc of the Drive API library.", new Object[] { com.google.api.client.googleapis.a.VERSION });
      return;
    }
  }
  
  a(a parama)
  {
    super(parama);
  }
  
  protected void a(com.google.api.client.googleapis.a.b<?> paramb)
  {
    super.a(paramb);
  }
  
  public b yX()
  {
    return new b();
  }
  
  public static final class a
    extends com.google.api.client.googleapis.a.a.a.a
  {
    public a(w paramw, d paramd, s params)
    {
      super(paramd, "https://www.googleapis.com/", "drive/v2/", params, false);
    }
    
    public a cB(String paramString)
    {
      return (a)super.bF(paramString);
    }
    
    public a cC(String paramString)
    {
      return (a)super.bG(paramString);
    }
    
    public a yY()
    {
      return new a(this);
    }
  }
  
  public class b
  {
    public b() {}
    
    public b a(com.google.api.a.a.a.a parama, com.google.api.client.http.b paramb)
    {
      parama = new b(parama, paramb);
      a.this.a(parama);
      return parama;
    }
    
    public a cD(String paramString)
    {
      paramString = new a(paramString);
      a.this.a(paramString);
      return paramString;
    }
    
    public c yZ()
    {
      c localc = new c();
      a.this.a(localc);
      return localc;
    }
    
    public class a
      extends b<Void>
    {
      @o
      private String fileId;
      
      protected a(String paramString)
      {
        super("DELETE", "files/{fileId}", null, Void.class);
        this.fileId = ((String)x.h(paramString, "Required parameter fileId must be specified."));
      }
      
      public a j(String paramString, Object paramObject)
      {
        return (a)super.k(paramString, paramObject);
      }
    }
    
    public class b
      extends b<com.google.api.a.a.a.a>
    {
      @o
      private Boolean convert;
      @o
      private Boolean ocr;
      @o
      private String ocrLanguage;
      @o
      private Boolean pinned;
      @o
      private String timedTextLanguage;
      @o
      private String timedTextTrackName;
      @o
      private Boolean useContentAsIndexableText;
      @o
      private String visibility;
      
      protected b(com.google.api.a.a.a.a parama, com.google.api.client.http.b paramb)
      {
        super("POST", "/upload/" + a.this.wV() + "files", parama, com.google.api.a.a.a.a.class);
        a(paramb);
      }
      
      public b cE(String paramString)
      {
        this.ocrLanguage = paramString;
        return this;
      }
      
      public b d(Boolean paramBoolean)
      {
        this.convert = paramBoolean;
        return this;
      }
      
      public b e(Boolean paramBoolean)
      {
        this.ocr = paramBoolean;
        return this;
      }
      
      public b l(String paramString, Object paramObject)
      {
        return (b)super.k(paramString, paramObject);
      }
    }
    
    public class c
      extends b<com.google.api.a.a.a.b>
    {
      @o
      private Integer maxResults;
      @o
      private String pageToken;
      @o
      private String projection;
      @o
      private String q;
      
      protected c()
      {
        super("GET", "files", null, com.google.api.a.a.a.b.class);
      }
      
      public c cF(String paramString)
      {
        this.q = paramString;
        return this;
      }
      
      public c m(String paramString, Object paramObject)
      {
        return (c)super.k(paramString, paramObject);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */