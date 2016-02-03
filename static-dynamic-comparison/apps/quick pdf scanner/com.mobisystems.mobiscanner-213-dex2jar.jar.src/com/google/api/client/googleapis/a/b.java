package com.google.api.client.googleapis.a;

import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.UriTemplate;
import com.google.api.client.http.e;
import com.google.api.client.http.h;
import com.google.api.client.http.i;
import com.google.api.client.http.j;
import com.google.api.client.http.n;
import com.google.api.client.http.q;
import com.google.api.client.http.r;
import com.google.api.client.http.t;
import com.google.api.client.http.u;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.x;
import java.io.IOException;

public abstract class b<T>
  extends GenericData
{
  private final a aaA;
  private final String aaB;
  private final String aaC;
  private final j aaD;
  private n aaE = new n();
  private n aaF;
  private int aaG = -1;
  private String aaH;
  private Class<T> aaI;
  private boolean aah;
  private MediaHttpUploader aap;
  
  protected b(a parama, String paramString1, String paramString2, j paramj, Class<T> paramClass)
  {
    this.aaI = ((Class)x.ad(paramClass));
    this.aaA = ((a)x.ad(parama));
    this.aaB = ((String)x.ad(paramString1));
    this.aaC = ((String)x.ad(paramString2));
    this.aaD = paramj;
    parama = parama.wX();
    if (parama != null) {
      this.aaE.bY(parama);
    }
  }
  
  private q an(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.aap == null)
    {
      bool1 = true;
      x.av(bool1);
      if (paramBoolean)
      {
        bool1 = bool2;
        if (!this.aaB.equals("GET")) {}
      }
      else
      {
        bool1 = true;
      }
      x.av(bool1);
      if (!paramBoolean) {
        break label211;
      }
    }
    label211:
    for (final Object localObject = "HEAD";; localObject = this.aaB)
    {
      localObject = xb().wY().a((String)localObject, xc(), this.aaD);
      new com.google.api.client.googleapis.b().b((q)localObject);
      ((q)localObject).a(xb().xa());
      if ((this.aaD == null) && ((this.aaB.equals("POST")) || (this.aaB.equals("PUT")) || (this.aaB.equals("PATCH")))) {
        ((q)localObject).c(new e());
      }
      ((q)localObject).xC().putAll(this.aaE);
      if (!this.aah) {
        ((q)localObject).a(new h());
      }
      ((q)localObject).a(new u()
      {
        public void b(t paramAnonymoust)
        {
          if (this.aaJ != null) {
            this.aaJ.b(paramAnonymoust);
          }
          if ((!paramAnonymoust.xL()) && (localObject.xI())) {
            throw b.this.a(paramAnonymoust);
          }
        }
      });
      return (q)localObject;
      bool1 = false;
      break;
    }
  }
  
  private t ao(boolean paramBoolean)
  {
    Object localObject;
    if (this.aap == null) {
      localObject = an(paramBoolean).xJ();
    }
    t localt;
    do
    {
      do
      {
        this.aaF = ((t)localObject).xC();
        this.aaG = ((t)localObject).getStatusCode();
        this.aaH = ((t)localObject).xM();
        return (t)localObject;
        localObject = xc();
        paramBoolean = xb().wY().a(this.aaB, (i)localObject, this.aaD).xI();
        localt = this.aap.a(this.aaE).am(this.aah).a((i)localObject);
        localt.xN().a(xb().xa());
        localObject = localt;
      } while (!paramBoolean);
      localObject = localt;
    } while (localt.xL());
    throw a(localt);
  }
  
  protected IOException a(t paramt)
  {
    return new HttpResponseException(paramt);
  }
  
  protected final void a(com.google.api.client.http.b paramb)
  {
    r localr = this.aaA.wY();
    this.aap = new MediaHttpUploader(paramb, localr.xx(), localr.xK());
    this.aap.bA(this.aaB);
    if (this.aaD != null) {
      this.aap.a(this.aaD);
    }
  }
  
  public b<T> e(String paramString, Object paramObject)
  {
    return (b)super.set(paramString, paramObject);
  }
  
  public a xb()
  {
    return this.aaA;
  }
  
  public i xc()
  {
    return new i(UriTemplate.a(this.aaA.wW(), this.aaC, this, true));
  }
  
  public t xd()
  {
    return ao(false);
  }
  
  public T xe()
  {
    return (T)xd().f(this.aaI);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/googleapis/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */