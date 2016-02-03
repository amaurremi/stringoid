package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.ir;
import com.google.android.gms.internal.it;
import com.google.android.gms.internal.iv;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private static Map<String, MetadataField<?>> JO = new HashMap();
  
  static
  {
    b(ir.JQ);
    b(ir.Ko);
    b(ir.Kh);
    b(ir.Km);
    b(ir.Kp);
    b(ir.Kb);
    b(ir.Kc);
    b(ir.JZ);
    b(ir.Ke);
    b(ir.Kk);
    b(ir.JR);
    b(ir.Kj);
    b(ir.JT);
    b(ir.Ka);
    b(ir.JU);
    b(ir.JV);
    b(ir.JW);
    b(ir.Kg);
    b(ir.Kd);
    b(ir.Ki);
    b(ir.Kl);
    b(ir.Kq);
    b(ir.Kr);
    b(ir.JY);
    b(ir.JX);
    b(ir.Kn);
    b(ir.Kf);
    b(ir.JS);
    b(ir.Ks);
    b(it.Kt);
    b(it.Kv);
    b(it.Kw);
    b(it.Kx);
    b(it.Ku);
    b(iv.Kz);
    b(iv.KA);
  }
  
  public static MetadataField<?> aN(String paramString)
  {
    return (MetadataField)JO.get(paramString);
  }
  
  private static void b(MetadataField<?> paramMetadataField)
  {
    if (JO.containsKey(paramMetadataField.getName())) {
      throw new IllegalArgumentException("Duplicate field name registered: " + paramMetadataField.getName());
    }
    JO.put(paramMetadataField.getName(), paramMetadataField);
  }
  
  public static Collection<MetadataField<?>> gz()
  {
    return Collections.unmodifiableCollection(JO.values());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */