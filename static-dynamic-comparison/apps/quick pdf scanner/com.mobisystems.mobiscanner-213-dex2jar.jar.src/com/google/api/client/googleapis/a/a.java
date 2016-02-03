package com.google.api.client.googleapis.a;

import com.google.api.client.http.r;
import com.google.api.client.http.s;
import com.google.api.client.http.w;
import com.google.api.client.util.ac;
import com.google.api.client.util.v;
import com.google.api.client.util.x;
import java.util.logging.Logger;

public abstract class a
{
  static final Logger aao = Logger.getLogger(a.class.getName());
  private final r ZO;
  private final c aas;
  private final String aat;
  private final String aau;
  private final String aav;
  private final v aaw;
  private boolean aax;
  private boolean aay;
  
  protected a(a parama)
  {
    this.aas = parama.aas;
    this.aat = bB(parama.aat);
    this.aau = bC(parama.aau);
    if (ac.cr(parama.aav)) {
      aao.warning("Application name is not set. Call Builder#setApplicationName.");
    }
    this.aav = parama.aav;
    if (parama.aaz == null) {}
    for (r localr = parama.ZP.xS();; localr = parama.ZP.a(parama.aaz))
    {
      this.ZO = localr;
      this.aaw = parama.aaw;
      this.aax = parama.aax;
      this.aay = parama.aay;
      return;
    }
  }
  
  static String bB(String paramString)
  {
    x.h(paramString, "root URL cannot be null.");
    String str = paramString;
    if (!paramString.endsWith("/")) {
      str = paramString + "/";
    }
    return str;
  }
  
  static String bC(String paramString)
  {
    x.h(paramString, "service path cannot be null");
    Object localObject;
    if (paramString.length() == 1)
    {
      x.d("/".equals(paramString), "service path must equal \"/\" if it is of length 1.");
      localObject = "";
    }
    String str;
    do
    {
      do
      {
        return (String)localObject;
        localObject = paramString;
      } while (paramString.length() <= 0);
      str = paramString;
      if (!paramString.endsWith("/")) {
        str = paramString + "/";
      }
      localObject = str;
    } while (!str.startsWith("/"));
    return str.substring(1);
  }
  
  protected void a(b<?> paramb)
  {
    if (wZ() != null) {
      wZ().a(paramb);
    }
  }
  
  public final String wV()
  {
    return this.aau;
  }
  
  public final String wW()
  {
    return this.aat + this.aau;
  }
  
  public final String wX()
  {
    return this.aav;
  }
  
  public final r wY()
  {
    return this.ZO;
  }
  
  public final c wZ()
  {
    return this.aas;
  }
  
  public v xa()
  {
    return this.aaw;
  }
  
  public static abstract class a
  {
    final w ZP;
    c aas;
    String aat;
    String aau;
    String aav;
    final v aaw;
    boolean aax;
    boolean aay;
    s aaz;
    
    protected a(w paramw, String paramString1, String paramString2, v paramv, s params)
    {
      this.ZP = ((w)x.ad(paramw));
      this.aaw = paramv;
      bD(paramString1);
      bE(paramString2);
      this.aaz = params;
    }
    
    public a bD(String paramString)
    {
      this.aat = a.bB(paramString);
      return this;
    }
    
    public a bE(String paramString)
    {
      this.aau = a.bC(paramString);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/googleapis/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */