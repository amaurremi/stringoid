package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.kd;
import com.google.android.gms.internal.kf;
import com.google.android.gms.internal.kh;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private static Map<String, MetadataField<?>> PC = new HashMap();
  
  static
  {
    b(kd.PE);
    b(kd.Qe);
    b(kd.PV);
    b(kd.Qc);
    b(kd.Qf);
    b(kd.PP);
    b(kd.PQ);
    b(kd.PN);
    b(kd.PS);
    b(kd.Qa);
    b(kd.PF);
    b(kd.PX);
    b(kd.PH);
    b(kd.PO);
    b(kd.PI);
    b(kd.PJ);
    b(kd.PK);
    b(kd.PU);
    b(kd.PR);
    b(kd.PW);
    b(kd.PY);
    b(kd.PZ);
    b(kd.Qb);
    b(kd.Qg);
    b(kd.Qh);
    b(kd.PM);
    b(kd.PL);
    b(kd.Qd);
    b(kd.PT);
    b(kd.PG);
    b(kd.Qi);
    b(kd.Qj);
    b(kd.Qk);
    b(kf.Ql);
    b(kf.Qn);
    b(kf.Qo);
    b(kf.Qp);
    b(kf.Qm);
    b(kh.Qr);
    b(kh.Qs);
  }
  
  private static void b(MetadataField<?> paramMetadataField)
  {
    if (PC.containsKey(paramMetadataField.getName())) {
      throw new IllegalArgumentException("Duplicate field name registered: " + paramMetadataField.getName());
    }
    PC.put(paramMetadataField.getName(), paramMetadataField);
  }
  
  public static MetadataField<?> bj(String paramString)
  {
    return (MetadataField)PC.get(paramString);
  }
  
  public static Collection<MetadataField<?>> in()
  {
    return Collections.unmodifiableCollection(PC.values());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */