package com.flurry.android;

import java.util.Map;

final class i
{
  private String a;
  private Map b;
  private long c;
  private boolean d;
  private long e;
  
  public i(String paramString, Map paramMap, long paramLong, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramMap;
    this.c = paramLong;
    this.d = paramBoolean;
  }
  
  public final void a(long paramLong)
  {
    this.e = (paramLong - this.c);
    ah.a("FlurryAgent", "Ended event '" + this.a + "' (" + this.c + ") after " + this.e + "ms");
  }
  
  public final boolean a(String paramString)
  {
    return (this.d) && (this.e == 0L) && (this.a.equals(paramString));
  }
  
  /* Error */
  public final byte[] a()
  {
    // Byte code:
    //   0: new 71	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 72	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: new 74	java/io/DataOutputStream
    //   11: dup
    //   12: aload_2
    //   13: invokespecial 77	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_1
    //   17: aload_1
    //   18: aload_0
    //   19: getfield 20	com/flurry/android/i:a	Ljava/lang/String;
    //   22: invokevirtual 81	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 22	com/flurry/android/i:b	Ljava/util/Map;
    //   29: ifnonnull +39 -> 68
    //   32: aload_1
    //   33: iconst_0
    //   34: invokevirtual 85	java/io/DataOutputStream:writeShort	(I)V
    //   37: aload_1
    //   38: aload_0
    //   39: getfield 24	com/flurry/android/i:c	J
    //   42: invokevirtual 88	java/io/DataOutputStream:writeLong	(J)V
    //   45: aload_1
    //   46: aload_0
    //   47: getfield 30	com/flurry/android/i:e	J
    //   50: invokevirtual 88	java/io/DataOutputStream:writeLong	(J)V
    //   53: aload_1
    //   54: invokevirtual 91	java/io/DataOutputStream:flush	()V
    //   57: aload_2
    //   58: invokevirtual 94	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   61: astore_2
    //   62: aload_1
    //   63: invokestatic 99	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   66: aload_2
    //   67: areturn
    //   68: aload_1
    //   69: aload_0
    //   70: getfield 22	com/flurry/android/i:b	Ljava/util/Map;
    //   73: invokeinterface 105 1 0
    //   78: invokevirtual 85	java/io/DataOutputStream:writeShort	(I)V
    //   81: aload_0
    //   82: getfield 22	com/flurry/android/i:b	Ljava/util/Map;
    //   85: invokeinterface 109 1 0
    //   90: invokeinterface 115 1 0
    //   95: astore_3
    //   96: aload_3
    //   97: invokeinterface 121 1 0
    //   102: ifeq -65 -> 37
    //   105: aload_3
    //   106: invokeinterface 125 1 0
    //   111: checkcast 127	java/util/Map$Entry
    //   114: astore 4
    //   116: aload_1
    //   117: aload 4
    //   119: invokeinterface 130 1 0
    //   124: checkcast 62	java/lang/String
    //   127: sipush 255
    //   130: invokestatic 133	com/flurry/android/r:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   133: invokevirtual 81	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   136: aload_1
    //   137: aload 4
    //   139: invokeinterface 136 1 0
    //   144: checkcast 62	java/lang/String
    //   147: sipush 255
    //   150: invokestatic 133	com/flurry/android/r:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   153: invokevirtual 81	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   156: goto -60 -> 96
    //   159: astore_2
    //   160: aload_1
    //   161: invokestatic 99	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   164: iconst_0
    //   165: newarray <illegal type>
    //   167: areturn
    //   168: astore_1
    //   169: aconst_null
    //   170: astore_3
    //   171: aload_1
    //   172: astore_2
    //   173: aload_3
    //   174: invokestatic 99	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   177: aload_2
    //   178: athrow
    //   179: astore_2
    //   180: aload_1
    //   181: astore_3
    //   182: goto -9 -> 173
    //   185: astore_1
    //   186: goto -13 -> 173
    //   189: astore_1
    //   190: aconst_null
    //   191: astore_1
    //   192: goto -32 -> 160
    // Exception table:
    //   from	to	target	type
    //   17	37	159	java/io/IOException
    //   37	62	159	java/io/IOException
    //   68	96	159	java/io/IOException
    //   96	156	159	java/io/IOException
    //   0	17	168	finally
    //   17	37	179	finally
    //   37	62	179	finally
    //   68	96	179	finally
    //   96	156	179	finally
    //   0	17	189	java/io/IOException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */