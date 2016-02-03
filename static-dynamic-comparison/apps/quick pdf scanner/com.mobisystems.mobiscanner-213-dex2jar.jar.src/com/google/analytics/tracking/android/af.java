package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class af
{
  private final ag lt;
  private final Map<String, String> lu = new HashMap();
  private long lv = 120000L;
  private long lw;
  private final g lx;
  private final aa ly;
  private final f lz;
  private final String mName;
  
  af(String paramString1, String paramString2, ag paramag)
  {
    this(paramString1, paramString2, paramag, g.js(), aa.kl(), f.jr());
  }
  
  af(String paramString1, String paramString2, ag paramag, g paramg, aa paramaa, f paramf)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("Tracker name cannot be empty.");
    }
    this.mName = paramString1;
    this.lt = paramag;
    this.lu.put("&tid", paramString2);
    this.lu.put("useSecure", "1");
    this.lx = paramg;
    this.ly = paramaa;
    this.lz = paramf;
  }
  
  public void c(Map<String, String> paramMap)
  {
    GAUsage.jU().a(GAUsage.Field.jM);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.lu);
    if (paramMap != null) {
      localHashMap.putAll(paramMap);
    }
    if (TextUtils.isEmpty((CharSequence)localHashMap.get("&tid"))) {
      v.D(String.format("Missing tracking id (%s) parameter.", new Object[] { "&tid" }));
    }
    String str = (String)localHashMap.get("&t");
    paramMap = str;
    if (TextUtils.isEmpty(str))
    {
      v.D(String.format("Missing hit type (%s) parameter.", new Object[] { "&t" }));
      paramMap = "";
    }
    if ((!paramMap.equals("transaction")) && (!paramMap.equals("item")) && (!kn()))
    {
      v.D("Too many hits sent too quickly, rate limiting invoked.");
      return;
    }
    this.lt.b(localHashMap);
  }
  
  /* Error */
  boolean kn()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 164	java/lang/System:currentTimeMillis	()J
    //   5: lstore_1
    //   6: aload_0
    //   7: getfield 56	com/google/analytics/tracking/android/af:lv	J
    //   10: ldc2_w 53
    //   13: lcmp
    //   14: ifge +32 -> 46
    //   17: lload_1
    //   18: aload_0
    //   19: getfield 166	com/google/analytics/tracking/android/af:lw	J
    //   22: lsub
    //   23: lstore_3
    //   24: lload_3
    //   25: lconst_0
    //   26: lcmp
    //   27: ifle +19 -> 46
    //   30: aload_0
    //   31: ldc2_w 53
    //   34: lload_3
    //   35: aload_0
    //   36: getfield 56	com/google/analytics/tracking/android/af:lv	J
    //   39: ladd
    //   40: invokestatic 172	java/lang/Math:min	(JJ)J
    //   43: putfield 56	com/google/analytics/tracking/android/af:lv	J
    //   46: aload_0
    //   47: lload_1
    //   48: putfield 166	com/google/analytics/tracking/android/af:lw	J
    //   51: aload_0
    //   52: getfield 56	com/google/analytics/tracking/android/af:lv	J
    //   55: ldc2_w 173
    //   58: lcmp
    //   59: iflt +23 -> 82
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 56	com/google/analytics/tracking/android/af:lv	J
    //   67: ldc2_w 173
    //   70: lsub
    //   71: putfield 56	com/google/analytics/tracking/android/af:lv	J
    //   74: iconst_1
    //   75: istore 5
    //   77: aload_0
    //   78: monitorexit
    //   79: iload 5
    //   81: ireturn
    //   82: ldc -80
    //   84: invokestatic 131	com/google/analytics/tracking/android/v:D	(Ljava/lang/String;)V
    //   87: iconst_0
    //   88: istore 5
    //   90: goto -13 -> 77
    //   93: astore 6
    //   95: aload_0
    //   96: monitorexit
    //   97: aload 6
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	af
    //   5	43	1	l1	long
    //   23	12	3	l2	long
    //   75	14	5	bool	boolean
    //   93	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	93	finally
    //   30	46	93	finally
    //   46	74	93	finally
    //   82	87	93	finally
  }
  
  public void set(String paramString1, String paramString2)
  {
    GAUsage.jU().a(GAUsage.Field.jL);
    if (paramString2 == null)
    {
      this.lu.remove(paramString1);
      return;
    }
    this.lu.put(paramString1, paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/analytics/tracking/android/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */