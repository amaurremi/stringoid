package com.skplanet.tad.videoplayer.manager;

import com.skplanet.tad.videoplayer.data.d;
import java.util.ArrayList;

public class c
{
  com.skplanet.tad.videoplayer.data.c a;
  ArrayList b = new ArrayList();
  String c;
  
  public c(com.skplanet.tad.videoplayer.data.c paramc, String paramString)
  {
    this.a = paramc;
    this.c = paramString;
  }
  
  public void a(final d paramd)
  {
    new Thread()
    {
      public void run()
      {
        c.this.b(paramd);
      }
    }.start();
  }
  
  /* Error */
  public boolean b(d paramd)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: getfield 24	com/skplanet/tad/videoplayer/manager/c:a	Lcom/skplanet/tad/videoplayer/data/c;
    //   5: getfield 44	com/skplanet/tad/videoplayer/data/c:e	Ljava/lang/String;
    //   8: putfield 48	com/skplanet/tad/videoplayer/data/d:a	Ljava/lang/String;
    //   11: ldc 50
    //   13: astore 4
    //   15: aload_1
    //   16: getfield 52	com/skplanet/tad/videoplayer/data/d:b	Ljava/lang/String;
    //   19: astore 5
    //   21: ldc 54
    //   23: aload 5
    //   25: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   28: ifeq +199 -> 227
    //   31: aload_1
    //   32: getfield 63	com/skplanet/tad/videoplayer/data/d:d	Ljava/lang/String;
    //   35: astore 4
    //   37: aload_1
    //   38: getfield 66	com/skplanet/tad/videoplayer/data/d:e	I
    //   41: sipush 3600
    //   44: if_icmple +5 -> 49
    //   47: iconst_1
    //   48: ireturn
    //   49: aload 4
    //   51: ifnull +10 -> 61
    //   54: aload 4
    //   56: ldc 50
    //   58: if_acmpne +5 -> 63
    //   61: iconst_1
    //   62: ireturn
    //   63: aload_1
    //   64: invokevirtual 69	com/skplanet/tad/videoplayer/data/d:a	()Ljava/lang/String;
    //   67: astore 4
    //   69: new 71	java/lang/StringBuilder
    //   72: dup
    //   73: aload_0
    //   74: getfield 24	com/skplanet/tad/videoplayer/manager/c:a	Lcom/skplanet/tad/videoplayer/data/c;
    //   77: invokevirtual 72	com/skplanet/tad/videoplayer/data/c:a	()Ljava/lang/String;
    //   80: invokestatic 76	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   83: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   86: ldc 81
    //   88: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload 4
    //   93: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore_1
    //   100: new 71	java/lang/StringBuilder
    //   103: dup
    //   104: ldc 90
    //   106: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   109: aload_0
    //   110: getfield 26	com/skplanet/tad/videoplayer/manager/c:c	Ljava/lang/String;
    //   113: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 94	com/skplanet/tad/videoplayer/util/b:a	(Ljava/lang/String;)V
    //   122: new 71	java/lang/StringBuilder
    //   125: dup
    //   126: ldc 96
    //   128: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: aload_1
    //   132: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 94	com/skplanet/tad/videoplayer/util/b:a	(Ljava/lang/String;)V
    //   141: ldc 98
    //   143: new 71	java/lang/StringBuilder
    //   146: dup
    //   147: ldc 100
    //   149: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: aload_1
    //   153: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc 102
    //   158: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_0
    //   162: getfield 26	com/skplanet/tad/videoplayer/manager/c:c	Ljava/lang/String;
    //   165: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 107	com/skplanet/tad/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload_0
    //   175: getfield 26	com/skplanet/tad/videoplayer/manager/c:c	Ljava/lang/String;
    //   178: ldc 109
    //   180: aload_1
    //   181: invokestatic 114	com/skplanet/tad/videoplayer/manager/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   184: astore 4
    //   186: ldc 116
    //   188: aload 5
    //   190: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   193: ifne +32 -> 225
    //   196: aload 4
    //   198: ldc 118
    //   200: invokevirtual 122	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   203: ifne +22 -> 225
    //   206: aload 4
    //   208: ldc 124
    //   210: invokevirtual 122	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   213: istore_3
    //   214: iload_3
    //   215: ifne +10 -> 225
    //   218: iconst_0
    //   219: istore_2
    //   220: iload_2
    //   221: iconst_3
    //   222: if_icmplt +81 -> 303
    //   225: iconst_1
    //   226: ireturn
    //   227: ldc 126
    //   229: aload 5
    //   231: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   234: ifeq +12 -> 246
    //   237: aload_1
    //   238: invokevirtual 128	com/skplanet/tad/videoplayer/data/d:b	()Ljava/lang/String;
    //   241: astore 4
    //   243: goto -174 -> 69
    //   246: ldc -126
    //   248: aload 5
    //   250: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   253: ifeq +12 -> 265
    //   256: aload_1
    //   257: invokevirtual 132	com/skplanet/tad/videoplayer/data/d:c	()Ljava/lang/String;
    //   260: astore 4
    //   262: goto -193 -> 69
    //   265: ldc -122
    //   267: aload 5
    //   269: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   272: ifeq +12 -> 284
    //   275: aload_1
    //   276: invokevirtual 136	com/skplanet/tad/videoplayer/data/d:d	()Ljava/lang/String;
    //   279: astore 4
    //   281: goto -212 -> 69
    //   284: ldc 116
    //   286: aload 5
    //   288: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   291: ifeq -222 -> 69
    //   294: aload_1
    //   295: invokevirtual 138	com/skplanet/tad/videoplayer/data/d:e	()Ljava/lang/String;
    //   298: astore 4
    //   300: goto -231 -> 69
    //   303: new 71	java/lang/StringBuilder
    //   306: dup
    //   307: iload_2
    //   308: invokestatic 141	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   311: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   314: ldc -113
    //   316: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 94	com/skplanet/tad/videoplayer/util/b:a	(Ljava/lang/String;)V
    //   325: ldc2_w 144
    //   328: invokestatic 151	java/lang/Thread:sleep	(J)V
    //   331: aload_0
    //   332: getfield 26	com/skplanet/tad/videoplayer/manager/c:c	Ljava/lang/String;
    //   335: ldc 109
    //   337: aload_1
    //   338: invokestatic 114	com/skplanet/tad/videoplayer/manager/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   341: astore 4
    //   343: aload 4
    //   345: ldc 118
    //   347: invokevirtual 122	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   350: ifne +13 -> 363
    //   353: aload 4
    //   355: ldc 124
    //   357: invokevirtual 122	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   360: ifeq +30 -> 390
    //   363: ldc 98
    //   365: ldc -103
    //   367: invokestatic 107	com/skplanet/tad/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: goto -145 -> 225
    //   373: astore_1
    //   374: aload_1
    //   375: invokevirtual 156	java/lang/Exception:printStackTrace	()V
    //   378: iconst_0
    //   379: ireturn
    //   380: astore 4
    //   382: aload 4
    //   384: invokevirtual 157	java/lang/InterruptedException:printStackTrace	()V
    //   387: goto -56 -> 331
    //   390: iload_2
    //   391: iconst_1
    //   392: iadd
    //   393: istore_2
    //   394: goto -174 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	c
    //   0	397	1	paramd	d
    //   219	175	2	i	int
    //   213	2	3	bool	boolean
    //   13	341	4	str1	String
    //   380	3	4	localInterruptedException	InterruptedException
    //   19	268	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   174	214	373	java/lang/Exception
    //   303	325	373	java/lang/Exception
    //   325	331	373	java/lang/Exception
    //   331	363	373	java/lang/Exception
    //   363	370	373	java/lang/Exception
    //   382	387	373	java/lang/Exception
    //   325	331	380	java/lang/InterruptedException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/videoplayer/manager/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */