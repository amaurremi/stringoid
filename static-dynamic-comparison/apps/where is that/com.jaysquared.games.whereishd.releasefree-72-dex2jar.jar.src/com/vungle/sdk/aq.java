package com.vungle.sdk;

import java.io.File;
import java.util.Timer;

final class aq
  implements Runnable
{
  aq(ap.a parama, String paramString1, String paramString2, String paramString3) {}
  
  public final void run()
  {
    int i = 0;
    boolean bool = this.d.a(new String[] { this.a, this.b, this.c }).booleanValue();
    ap.a locala = this.d;
    Boolean localBoolean = Boolean.valueOf(bool);
    locala.a = true;
    Object localObject1;
    Object localObject2;
    if ((localBoolean.booleanValue()) && (locala.d != null))
    {
      localObject1 = ba.a(locala.c);
      int j = localObject1.length;
      localObject2 = new StringBuilder();
      while (i < j)
      {
        ((StringBuilder)localObject2).append(Character.forDigit(localObject1[i] >> 4 & 0xF, 16));
        ((StringBuilder)localObject2).append(Character.forDigit(localObject1[i] & 0xF, 16));
        i += 1;
      }
      if (((StringBuilder)localObject2).toString().equalsIgnoreCase(locala.d)) {
        new StringBuilder("File (").append(locala.e).append(") passes md5: ").append(locala.d);
      }
    }
    else
    {
      if (!localBoolean.booleanValue()) {
        break label272;
      }
      if (ap.b(locala.g) != null)
      {
        localObject1 = ap.b(locala.g);
        localObject2 = locala.c;
        ((ap.b)localObject1).b();
      }
    }
    for (;;)
    {
      locala.b = localBoolean.booleanValue();
      return;
      new StringBuilder("File (").append(locala.e).append(") fails md5 check, but we don't care.");
      break;
      label272:
      localObject1 = new File(locala.c);
      if (((File)localObject1).exists()) {
        ((File)localObject1).delete();
      }
      locala.c = null;
      if ((locala.f) && (ap.c(locala.g)))
      {
        new StringBuilder("Waiting for ").append(ap.d(locala.g)).append(" seconds before retrying...");
        new Timer().schedule(new ar(locala), ap.d(locala.g) * 1000);
      }
      else if (ap.b(locala.g) != null)
      {
        ap.b(locala.g).c();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */