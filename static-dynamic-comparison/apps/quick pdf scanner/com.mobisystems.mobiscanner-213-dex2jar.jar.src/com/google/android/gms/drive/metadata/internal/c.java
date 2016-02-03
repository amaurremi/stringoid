package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.internal.dz;
import com.google.android.gms.internal.ea;
import com.google.android.gms.internal.ed;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static Map<String, b<?>> uc = new HashMap();
  
  static
  {
    b(dz.Mg);
    b(dz.ug);
    b(dz.uh);
    b(dz.ul);
    b(dz.ui);
    b(dz.Mh);
    b(dz.uo);
    b(dz.Mi);
    b(dz.Mj);
    b(dz.uj);
    b(dz.Mk);
    b(dz.Ml);
    b(dz.Mm);
    b(dz.Mn);
    b(dz.Mo);
    b(dz.Mp);
    b(dz.Mq);
    b(dz.Mr);
    b(dz.Ms);
    b(dz.Mt);
    b(dz.Mu);
    b(dz.Mv);
    b(dz.Mw);
    b(dz.Mx);
    b(dz.My);
    b(ea.MB);
    b(ea.Mz);
    b(ea.MA);
    b(ea.uk);
    b(ea.un);
    b(ed.MD);
    b(ed.ME);
  }
  
  public static b<?> at(String paramString)
  {
    return (b)uc.get(paramString);
  }
  
  private static void b(b<?> paramb)
  {
    if (uc.containsKey(paramb.getName())) {
      throw new IllegalArgumentException("Duplicate field name registered: " + paramb.getName());
    }
    uc.put(paramb.getName(), paramb);
  }
  
  public static Collection<b<?>> nu()
  {
    return Collections.unmodifiableCollection(uc.values());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */