package com.google.api.client.googleapis;

import com.google.api.client.http.ac;
import com.google.api.client.http.e;
import com.google.api.client.http.i;
import com.google.api.client.http.m;
import com.google.api.client.http.n;
import com.google.api.client.http.q;
import com.google.api.client.http.s;
import com.google.api.client.http.w;

public final class b
  implements m, s
{
  private final boolean Zz;
  
  public b()
  {
    this(false);
  }
  
  b(boolean paramBoolean)
  {
    this.Zz = paramBoolean;
  }
  
  private boolean c(q paramq)
  {
    boolean bool2 = true;
    String str = paramq.getRequestMethod();
    boolean bool1;
    if (str.equals("POST")) {
      bool1 = false;
    }
    do
    {
      return bool1;
      if (!str.equals("GET")) {
        break;
      }
      bool1 = bool2;
    } while (paramq.xy().xo().length() > 2048);
    while (!this.Zz)
    {
      bool1 = bool2;
      if (!paramq.xx().cj(str)) {
        break;
      }
      return false;
    }
    return true;
  }
  
  public void a(q paramq)
  {
    paramq.a(this);
  }
  
  public void b(q paramq)
  {
    if (c(paramq))
    {
      String str = paramq.getRequestMethod();
      paramq.cf("POST");
      paramq.xC().h("X-HTTP-Method-Override", str);
      if (!str.equals("GET")) {
        break label57;
      }
      paramq.c(new ac(paramq.xy()));
    }
    label57:
    while (paramq.xz() != null) {
      return;
    }
    paramq.c(new e());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/googleapis/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */