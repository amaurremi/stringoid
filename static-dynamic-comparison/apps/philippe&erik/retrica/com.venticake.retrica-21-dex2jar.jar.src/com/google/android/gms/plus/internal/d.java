package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.internal.hg;
import com.google.android.gms.internal.hr;
import com.google.android.gms.internal.ie;
import java.util.List;

public abstract interface d
  extends IInterface
{
  public abstract hg a(b paramb, int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  public abstract void a(ie paramie);
  
  public abstract void a(b paramb);
  
  public abstract void a(b paramb, int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3);
  
  public abstract void a(b paramb, Uri paramUri, Bundle paramBundle);
  
  public abstract void a(b paramb, ie paramie);
  
  public abstract void a(b paramb, String paramString);
  
  public abstract void a(b paramb, String paramString1, String paramString2);
  
  public abstract void a(b paramb, List<String> paramList);
  
  public abstract void a(String paramString, hr paramhr1, hr paramhr2);
  
  public abstract void b(b paramb);
  
  public abstract void b(b paramb, String paramString);
  
  public abstract void c(b paramb, String paramString);
  
  public abstract void clearDefaultAccount();
  
  public abstract void d(b paramb, String paramString);
  
  public abstract void e(b paramb, String paramString);
  
  public abstract String getAccountName();
  
  public abstract String jU();
  
  public abstract boolean jV();
  
  public abstract String jW();
  
  public abstract void removeMoment(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */