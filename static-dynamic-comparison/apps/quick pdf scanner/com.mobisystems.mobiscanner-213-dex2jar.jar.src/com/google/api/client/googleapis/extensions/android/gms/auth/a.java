package com.google.api.client.googleapis.extensions.android.gms.auth;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.api.client.http.m;
import com.google.api.client.http.q;
import com.google.api.client.http.s;
import com.google.api.client.http.t;
import com.google.api.client.util.c;
import com.google.api.client.util.d;
import com.google.api.client.util.z;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class a
  implements s
{
  final Context ZB;
  final String ZC;
  private final com.google.api.client.googleapis.extensions.android.a.a ZD;
  private String ZE;
  private Account ZF;
  private z ZG = z.aef;
  private c ZH;
  
  public a(Context paramContext, String paramString)
  {
    this.ZD = new com.google.api.client.googleapis.extensions.android.a.a(paramContext);
    this.ZB = paramContext;
    this.ZC = paramString;
  }
  
  public static a b(Context paramContext, Collection<String> paramCollection)
  {
    if ((paramCollection != null) && (paramCollection.iterator().hasNext())) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.api.client.util.x.av(bool);
      return new a(paramContext, "oauth2: " + com.google.api.client.util.n.b(' ').a(paramCollection));
    }
  }
  
  public void a(q paramq)
  {
    a locala = new a();
    paramq.a(locala);
    paramq.a(locala);
  }
  
  public final a by(String paramString)
  {
    this.ZF = this.ZD.bx(paramString);
    if (this.ZF == null) {
      paramString = null;
    }
    this.ZE = paramString;
    return this;
  }
  
  public final Intent wJ()
  {
    return com.google.android.gms.common.a.newChooseAccountIntent(this.ZF, null, new String[] { "com.google" }, true, null, null, null, null);
  }
  
  public String wK()
  {
    if (this.ZH != null) {
      this.ZH.reset();
    }
    for (;;)
    {
      try
      {
        String str = com.google.android.gms.auth.a.a(this.ZB, this.ZE, this.ZC);
        return str;
      }
      catch (IOException localIOException)
      {
        try
        {
          if ((this.ZH == null) || (!d.a(this.ZG, this.ZH))) {
            throw localIOException;
          }
        }
        catch (InterruptedException localInterruptedException) {}
      }
    }
  }
  
  class a
    implements m, com.google.api.client.http.x
  {
    boolean ZI;
    String ZJ;
    
    a() {}
    
    public boolean a(q paramq, t paramt, boolean paramBoolean)
    {
      if ((paramt.getStatusCode() == 401) && (!this.ZI))
      {
        this.ZI = true;
        com.google.android.gms.auth.a.d(a.this.ZB, this.ZJ);
        return true;
      }
      return false;
    }
    
    public void b(q paramq)
    {
      try
      {
        this.ZJ = a.this.wK();
        paramq.xC().bP("Bearer " + this.ZJ);
        return;
      }
      catch (GooglePlayServicesAvailabilityException paramq)
      {
        throw new GooglePlayServicesAvailabilityIOException(paramq);
      }
      catch (UserRecoverableAuthException paramq)
      {
        throw new UserRecoverableAuthIOException(paramq);
      }
      catch (GoogleAuthException paramq)
      {
        throw new GoogleAuthIOException(paramq);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/googleapis/extensions/android/gms/auth/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */