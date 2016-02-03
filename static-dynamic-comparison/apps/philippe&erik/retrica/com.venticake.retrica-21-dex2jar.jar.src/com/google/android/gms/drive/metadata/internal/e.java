package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.iq;
import com.google.android.gms.internal.is;
import com.google.android.gms.internal.iu;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private static Map<String, MetadataField<?>> JR = new HashMap();
  
  static
  {
    b(iq.JT);
    b(iq.Kr);
    b(iq.Kk);
    b(iq.Kp);
    b(iq.Ks);
    b(iq.Ke);
    b(iq.Kf);
    b(iq.Kc);
    b(iq.Kh);
    b(iq.Kn);
    b(iq.JU);
    b(iq.Km);
    b(iq.JW);
    b(iq.Kd);
    b(iq.JX);
    b(iq.JY);
    b(iq.JZ);
    b(iq.Kj);
    b(iq.Kg);
    b(iq.Kl);
    b(iq.Ko);
    b(iq.Kt);
    b(iq.Ku);
    b(iq.Kb);
    b(iq.Ka);
    b(iq.Kq);
    b(iq.Ki);
    b(iq.JV);
    b(iq.Kv);
    b(is.Kw);
    b(is.Ky);
    b(is.Kz);
    b(is.KA);
    b(is.Kx);
    b(iu.KC);
    b(iu.KD);
  }
  
  public static MetadataField<?> aN(String paramString)
  {
    return (MetadataField)JR.get(paramString);
  }
  
  private static void b(MetadataField<?> paramMetadataField)
  {
    if (JR.containsKey(paramMetadataField.getName())) {
      throw new IllegalArgumentException("Duplicate field name registered: " + paramMetadataField.getName());
    }
    JR.put(paramMetadataField.getName(), paramMetadataField);
  }
  
  public static Collection<MetadataField<?>> gE()
  {
    return Collections.unmodifiableCollection(JR.values());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */