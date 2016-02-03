package com.flurry.android;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class bs
{
  private int dO;
  private String dP;
  private Map<String, String> dQ;
  private long dR;
  private boolean dS;
  private long dT;
  
  public bs(int paramInt, String paramString, Map<String, String> paramMap, long paramLong, boolean paramBoolean)
  {
    this.dO = paramInt;
    this.dP = paramString;
    this.dQ = paramMap;
    this.dR = paramLong;
    this.dS = paramBoolean;
  }
  
  public final void c(long paramLong)
  {
    this.dT = (paramLong - this.dR);
    db.c("FlurryAgent", "Ended event '" + this.dP + "' (" + this.dR + ") after " + this.dT + "ms");
  }
  
  public final void d(Map<String, String> paramMap)
  {
    if ((this.dQ == null) || (this.dQ.size() == 0)) {
      this.dQ = paramMap;
    }
    for (;;)
    {
      return;
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if (this.dQ.containsKey(localEntry.getKey()))
        {
          this.dQ.remove(localEntry.getKey());
          this.dQ.put(localEntry.getKey(), localEntry.getValue());
        }
        else
        {
          this.dQ.put(localEntry.getKey(), localEntry.getValue());
        }
      }
    }
  }
  
  public final void e(Map<String, String> paramMap)
  {
    this.dQ = paramMap;
  }
  
  /* Error */
  public final byte[] getBytes()
  {
    // Byte code:
    //   0: new 123	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 124	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: new 126	java/io/DataOutputStream
    //   11: dup
    //   12: aload_2
    //   13: invokespecial 129	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_1
    //   17: aload_1
    //   18: aload_0
    //   19: getfield 23	com/flurry/android/bs:dO	I
    //   22: invokevirtual 133	java/io/DataOutputStream:writeShort	(I)V
    //   25: aload_1
    //   26: aload_0
    //   27: getfield 25	com/flurry/android/bs:dP	Ljava/lang/String;
    //   30: invokevirtual 137	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   33: aload_0
    //   34: getfield 27	com/flurry/android/bs:dQ	Ljava/util/Map;
    //   37: ifnonnull +39 -> 76
    //   40: aload_1
    //   41: iconst_0
    //   42: invokevirtual 133	java/io/DataOutputStream:writeShort	(I)V
    //   45: aload_1
    //   46: aload_0
    //   47: getfield 29	com/flurry/android/bs:dR	J
    //   50: invokevirtual 140	java/io/DataOutputStream:writeLong	(J)V
    //   53: aload_1
    //   54: aload_0
    //   55: getfield 38	com/flurry/android/bs:dT	J
    //   58: invokevirtual 140	java/io/DataOutputStream:writeLong	(J)V
    //   61: aload_1
    //   62: invokevirtual 143	java/io/DataOutputStream:flush	()V
    //   65: aload_2
    //   66: invokevirtual 146	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   69: astore_2
    //   70: aload_1
    //   71: invokestatic 152	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   74: aload_2
    //   75: areturn
    //   76: aload_1
    //   77: aload_0
    //   78: getfield 27	com/flurry/android/bs:dQ	Ljava/util/Map;
    //   81: invokeinterface 75 1 0
    //   86: invokevirtual 133	java/io/DataOutputStream:writeShort	(I)V
    //   89: aload_0
    //   90: getfield 27	com/flurry/android/bs:dQ	Ljava/util/Map;
    //   93: invokeinterface 79 1 0
    //   98: invokeinterface 85 1 0
    //   103: astore_3
    //   104: aload_3
    //   105: invokeinterface 91 1 0
    //   110: ifeq -65 -> 45
    //   113: aload_3
    //   114: invokeinterface 95 1 0
    //   119: checkcast 97	java/util/Map$Entry
    //   122: astore 4
    //   124: aload_1
    //   125: aload 4
    //   127: invokeinterface 100 1 0
    //   132: checkcast 154	java/lang/String
    //   135: invokestatic 158	com/flurry/android/bd:sanitize	(Ljava/lang/String;)Ljava/lang/String;
    //   138: invokevirtual 137	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   141: aload_1
    //   142: aload 4
    //   144: invokeinterface 111 1 0
    //   149: checkcast 154	java/lang/String
    //   152: invokestatic 158	com/flurry/android/bd:sanitize	(Ljava/lang/String;)Ljava/lang/String;
    //   155: invokevirtual 137	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   158: goto -54 -> 104
    //   161: astore_2
    //   162: aload_1
    //   163: invokestatic 152	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   166: iconst_0
    //   167: newarray <illegal type>
    //   169: areturn
    //   170: astore_1
    //   171: aconst_null
    //   172: astore_3
    //   173: aload_1
    //   174: astore_2
    //   175: aload_3
    //   176: invokestatic 152	com/flurry/android/bd:a	(Ljava/io/Closeable;)V
    //   179: aload_2
    //   180: athrow
    //   181: astore_2
    //   182: aload_1
    //   183: astore_3
    //   184: goto -9 -> 175
    //   187: astore_1
    //   188: goto -13 -> 175
    //   191: astore_1
    //   192: aconst_null
    //   193: astore_1
    //   194: goto -32 -> 162
    // Exception table:
    //   from	to	target	type
    //   17	45	161	java/io/IOException
    //   45	70	161	java/io/IOException
    //   76	104	161	java/io/IOException
    //   104	158	161	java/io/IOException
    //   0	17	170	finally
    //   17	45	181	finally
    //   45	70	181	finally
    //   76	104	181	finally
    //   104	158	181	finally
    //   0	17	191	java/io/IOException
  }
  
  public final Map<String, String> getParameters()
  {
    return this.dQ;
  }
  
  public final boolean w(String paramString)
  {
    return (this.dS) && (this.dT == 0L) && (this.dP.equals(paramString));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/android/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */