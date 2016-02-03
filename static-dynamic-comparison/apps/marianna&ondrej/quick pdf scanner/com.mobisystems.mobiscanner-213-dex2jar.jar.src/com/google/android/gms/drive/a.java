package com.google.android.gms.drive;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.c.a;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.api.c.d;
import com.google.android.gms.common.api.h;
import com.google.android.gms.drive.internal.aa;
import com.google.android.gms.drive.internal.ac;
import com.google.android.gms.drive.internal.y;
import com.google.android.gms.internal.ee;
import java.util.List;

public final class a
{
  public static final a.b<aa> sJ = new a.b()
  {
    public aa b(Context paramAnonymousContext, Looper paramAnonymousLooper, ee paramAnonymousee, c.a paramAnonymousa, c.c paramAnonymousc, c.d paramAnonymousd)
    {
      paramAnonymousa = paramAnonymousee.qj();
      return new aa(paramAnonymousContext, paramAnonymousLooper, paramAnonymousee, paramAnonymousc, paramAnonymousd, (String[])paramAnonymousa.toArray(new String[paramAnonymousa.size()]));
    }
    
    public int getPriority()
    {
      return Integer.MAX_VALUE;
    }
  };
  public static final h sK = new h("https://www.googleapis.com/auth/drive.file");
  public static final h sL = new h("https://www.googleapis.com/auth/drive.appdata");
  public static final h sM = new h("https://www.googleapis.com/auth/drive");
  public static final com.google.android.gms.common.api.a sN = new com.google.android.gms.common.api.a(sJ, new h[0]);
  public static final b sO = new y();
  public static final k sP = new ac();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */