package com.flurry.org.codehaus.jackson.map.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class ISO8601Utils
{
  private static final String GMT_ID = "GMT";
  private static final TimeZone TIMEZONE_GMT = TimeZone.getTimeZone("GMT");
  
  private static void checkOffset(String paramString, int paramInt, char paramChar)
    throws IndexOutOfBoundsException
  {
    char c = paramString.charAt(paramInt);
    if (c != paramChar) {
      throw new IndexOutOfBoundsException("Expected '" + paramChar + "' character but found '" + c + "'");
    }
  }
  
  public static String format(Date paramDate)
  {
    return format(paramDate, false, TIMEZONE_GMT);
  }
  
  public static String format(Date paramDate, boolean paramBoolean)
  {
    return format(paramDate, paramBoolean, TIMEZONE_GMT);
  }
  
  public static String format(Date paramDate, boolean paramBoolean, TimeZone paramTimeZone)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(paramTimeZone, Locale.US);
    localGregorianCalendar.setTime(paramDate);
    int k = "yyyy-MM-ddThh:mm:ss".length();
    int i;
    int j;
    label51:
    char c;
    if (paramBoolean)
    {
      i = ".sss".length();
      if (paramTimeZone.getRawOffset() != 0) {
        break label320;
      }
      j = "Z".length();
      paramDate = new StringBuilder(k + i + j);
      padInt(paramDate, localGregorianCalendar.get(1), "yyyy".length());
      paramDate.append('-');
      padInt(paramDate, localGregorianCalendar.get(2) + 1, "MM".length());
      paramDate.append('-');
      padInt(paramDate, localGregorianCalendar.get(5), "dd".length());
      paramDate.append('T');
      padInt(paramDate, localGregorianCalendar.get(11), "hh".length());
      paramDate.append(':');
      padInt(paramDate, localGregorianCalendar.get(12), "mm".length());
      paramDate.append(':');
      padInt(paramDate, localGregorianCalendar.get(13), "ss".length());
      if (paramBoolean)
      {
        paramDate.append('.');
        padInt(paramDate, localGregorianCalendar.get(14), "sss".length());
      }
      i = paramTimeZone.getOffset(localGregorianCalendar.getTimeInMillis());
      if (i == 0) {
        break label336;
      }
      j = Math.abs(i / 60000 / 60);
      k = Math.abs(i / 60000 % 60);
      if (i >= 0) {
        break label330;
      }
      c = '-';
      label274:
      paramDate.append(c);
      padInt(paramDate, j, "hh".length());
      paramDate.append(':');
      padInt(paramDate, k, "mm".length());
    }
    for (;;)
    {
      return paramDate.toString();
      i = 0;
      break;
      label320:
      j = "+hh:mm".length();
      break label51;
      label330:
      c = '+';
      break label274;
      label336:
      paramDate.append('Z');
    }
  }
  
  private static void padInt(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    String str = Integer.toString(paramInt1);
    paramInt1 = paramInt2 - str.length();
    while (paramInt1 > 0)
    {
      paramStringBuilder.append('0');
      paramInt1 -= 1;
    }
    paramStringBuilder.append(str);
  }
  
  /* Error */
  public static Date parse(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: iconst_4
    //   2: iadd
    //   3: istore_3
    //   4: iload_3
    //   5: istore_2
    //   6: iload_3
    //   7: istore_2
    //   8: iload_3
    //   9: istore_2
    //   10: aload_0
    //   11: iconst_0
    //   12: iload_3
    //   13: invokestatic 150	com/flurry/org/codehaus/jackson/map/util/ISO8601Utils:parseInt	(Ljava/lang/String;II)I
    //   16: istore 5
    //   18: iload_3
    //   19: istore_2
    //   20: iload_3
    //   21: istore_2
    //   22: iload_3
    //   23: istore_2
    //   24: aload_0
    //   25: iload_3
    //   26: bipush 45
    //   28: invokestatic 152	com/flurry/org/codehaus/jackson/map/util/ISO8601Utils:checkOffset	(Ljava/lang/String;IC)V
    //   31: iload_3
    //   32: iconst_1
    //   33: iadd
    //   34: istore 4
    //   36: iload 4
    //   38: iconst_2
    //   39: iadd
    //   40: istore_3
    //   41: iload_3
    //   42: istore_2
    //   43: iload_3
    //   44: istore_2
    //   45: iload_3
    //   46: istore_2
    //   47: aload_0
    //   48: iload 4
    //   50: iload_3
    //   51: invokestatic 150	com/flurry/org/codehaus/jackson/map/util/ISO8601Utils:parseInt	(Ljava/lang/String;II)I
    //   54: istore 6
    //   56: iload_3
    //   57: istore_2
    //   58: iload_3
    //   59: istore_2
    //   60: iload_3
    //   61: istore_2
    //   62: aload_0
    //   63: iload_3
    //   64: bipush 45
    //   66: invokestatic 152	com/flurry/org/codehaus/jackson/map/util/ISO8601Utils:checkOffset	(Ljava/lang/String;IC)V
    //   69: iload_3
    //   70: iconst_1
    //   71: iadd
    //   72: istore 4
    //   74: iload 4
    //   76: iconst_2
    //   77: iadd
    //   78: istore_3
    //   79: iload_3
    //   80: istore_2
    //   81: iload_3
    //   82: istore_2
    //   83: iload_3
    //   84: istore_2
    //   85: aload_0
    //   86: iload 4
    //   88: iload_3
    //   89: invokestatic 150	com/flurry/org/codehaus/jackson/map/util/ISO8601Utils:parseInt	(Ljava/lang/String;II)I
    //   92: istore 7
    //   94: iload_3
    //   95: istore_2
    //   96: iload_3
    //   97: istore_2
    //   98: iload_3
    //   99: istore_2
    //   100: aload_0
    //   101: iload_3
    //   102: bipush 84
    //   104: invokestatic 152	com/flurry/org/codehaus/jackson/map/util/ISO8601Utils:checkOffset	(Ljava/lang/String;IC)V
    //   107: iload_3
    //   108: iconst_1
    //   109: iadd
    //   110: istore 4
    //   112: iload 4
    //   114: iconst_2
    //   115: iadd
    //   116: istore_3
    //   117: iload_3
    //   118: istore_2
    //   119: iload_3
    //   120: istore_2
    //   121: iload_3
    //   122: istore_2
    //   123: aload_0
    //   124: iload 4
    //   126: iload_3
    //   127: invokestatic 150	com/flurry/org/codehaus/jackson/map/util/ISO8601Utils:parseInt	(Ljava/lang/String;II)I
    //   130: istore 8
    //   132: iload_3
    //   133: istore_2
    //   134: iload_3
    //   135: istore_2
    //   136: iload_3
    //   137: istore_2
    //   138: aload_0
    //   139: iload_3
    //   140: bipush 58
    //   142: invokestatic 152	com/flurry/org/codehaus/jackson/map/util/ISO8601Utils:checkOffset	(Ljava/lang/String;IC)V
    //   145: iload_3
    //   146: iconst_1
    //   147: iadd
    //   148: istore 4
    //   150: iload 4
    //   152: iconst_2
    //   153: iadd
    //   154: istore_3
    //   155: iload_3
    //   156: istore_2
    //   157: iload_3
    //   158: istore_2
    //   159: iload_3
    //   160: istore_2
    //   161: aload_0
    //   162: iload 4
    //   164: iload_3
    //   165: invokestatic 150	com/flurry/org/codehaus/jackson/map/util/ISO8601Utils:parseInt	(Ljava/lang/String;II)I
    //   168: istore 9
    //   170: iload_3
    //   171: istore_2
    //   172: iload_3
    //   173: istore_2
    //   174: iload_3
    //   175: istore_2
    //   176: aload_0
    //   177: iload_3
    //   178: bipush 58
    //   180: invokestatic 152	com/flurry/org/codehaus/jackson/map/util/ISO8601Utils:checkOffset	(Ljava/lang/String;IC)V
    //   183: iload_3
    //   184: iconst_1
    //   185: iadd
    //   186: istore 4
    //   188: iload 4
    //   190: iconst_2
    //   191: iadd
    //   192: istore_3
    //   193: iload_3
    //   194: istore_2
    //   195: iload_3
    //   196: istore_2
    //   197: iload_3
    //   198: istore_2
    //   199: aload_0
    //   200: iload 4
    //   202: iload_3
    //   203: invokestatic 150	com/flurry/org/codehaus/jackson/map/util/ISO8601Utils:parseInt	(Ljava/lang/String;II)I
    //   206: istore 10
    //   208: iconst_0
    //   209: istore 4
    //   211: iload_3
    //   212: istore_2
    //   213: iload_3
    //   214: istore_2
    //   215: iload_3
    //   216: istore_2
    //   217: aload_0
    //   218: iload_3
    //   219: invokevirtual 34	java/lang/String:charAt	(I)C
    //   222: bipush 46
    //   224: if_icmpne +347 -> 571
    //   227: iload_3
    //   228: istore_2
    //   229: iload_3
    //   230: istore_2
    //   231: iload_3
    //   232: istore_2
    //   233: aload_0
    //   234: iload_3
    //   235: bipush 46
    //   237: invokestatic 152	com/flurry/org/codehaus/jackson/map/util/ISO8601Utils:checkOffset	(Ljava/lang/String;IC)V
    //   240: iload_3
    //   241: iconst_1
    //   242: iadd
    //   243: istore 4
    //   245: iload 4
    //   247: iconst_3
    //   248: iadd
    //   249: istore_3
    //   250: iload_3
    //   251: istore_2
    //   252: iload_3
    //   253: istore_2
    //   254: iload_3
    //   255: istore_2
    //   256: aload_0
    //   257: iload 4
    //   259: iload_3
    //   260: invokestatic 150	com/flurry/org/codehaus/jackson/map/util/ISO8601Utils:parseInt	(Ljava/lang/String;II)I
    //   263: istore_2
    //   264: aload_0
    //   265: iload_3
    //   266: invokevirtual 34	java/lang/String:charAt	(I)C
    //   269: istore_1
    //   270: iload_1
    //   271: bipush 43
    //   273: if_icmpeq +9 -> 282
    //   276: iload_1
    //   277: bipush 45
    //   279: if_icmpne +87 -> 366
    //   282: new 36	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   289: ldc 8
    //   291: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload_0
    //   295: iload_3
    //   296: invokevirtual 155	java/lang/String:substring	(I)Ljava/lang/String;
    //   299: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: astore 11
    //   307: aload 11
    //   309: invokestatic 18	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   312: astore 12
    //   314: aload 12
    //   316: invokevirtual 158	java/util/TimeZone:getID	()Ljava/lang/String;
    //   319: aload 11
    //   321: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   324: ifne +113 -> 437
    //   327: new 28	java/lang/IndexOutOfBoundsException
    //   330: dup
    //   331: invokespecial 163	java/lang/IndexOutOfBoundsException:<init>	()V
    //   334: athrow
    //   335: astore 11
    //   337: new 146	java/lang/IllegalArgumentException
    //   340: dup
    //   341: new 36	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   348: ldc -91
    //   350: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload_0
    //   354: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: aload 11
    //   362: invokespecial 168	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   365: athrow
    //   366: iload_1
    //   367: bipush 90
    //   369: if_icmpne +10 -> 379
    //   372: ldc 8
    //   374: astore 11
    //   376: goto -69 -> 307
    //   379: new 28	java/lang/IndexOutOfBoundsException
    //   382: dup
    //   383: new 36	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   390: ldc -86
    //   392: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: iload_1
    //   396: invokevirtual 46	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   399: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokespecial 57	java/lang/IndexOutOfBoundsException:<init>	(Ljava/lang/String;)V
    //   405: athrow
    //   406: astore 11
    //   408: new 146	java/lang/IllegalArgumentException
    //   411: dup
    //   412: new 36	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   419: ldc -91
    //   421: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_0
    //   425: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: aload 11
    //   433: invokespecial 168	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   436: athrow
    //   437: new 66	java/util/GregorianCalendar
    //   440: dup
    //   441: aload 12
    //   443: invokespecial 173	java/util/GregorianCalendar:<init>	(Ljava/util/TimeZone;)V
    //   446: astore 11
    //   448: aload 11
    //   450: iconst_0
    //   451: invokevirtual 177	java/util/Calendar:setLenient	(Z)V
    //   454: aload 11
    //   456: iconst_1
    //   457: iload 5
    //   459: invokevirtual 181	java/util/Calendar:set	(II)V
    //   462: aload 11
    //   464: iconst_2
    //   465: iload 6
    //   467: iconst_1
    //   468: isub
    //   469: invokevirtual 181	java/util/Calendar:set	(II)V
    //   472: aload 11
    //   474: iconst_5
    //   475: iload 7
    //   477: invokevirtual 181	java/util/Calendar:set	(II)V
    //   480: aload 11
    //   482: bipush 11
    //   484: iload 8
    //   486: invokevirtual 181	java/util/Calendar:set	(II)V
    //   489: aload 11
    //   491: bipush 12
    //   493: iload 9
    //   495: invokevirtual 181	java/util/Calendar:set	(II)V
    //   498: aload 11
    //   500: bipush 13
    //   502: iload 10
    //   504: invokevirtual 181	java/util/Calendar:set	(II)V
    //   507: aload 11
    //   509: bipush 14
    //   511: iload_2
    //   512: invokevirtual 181	java/util/Calendar:set	(II)V
    //   515: aload 11
    //   517: invokevirtual 185	java/util/Calendar:getTime	()Ljava/util/Date;
    //   520: astore 11
    //   522: aload 11
    //   524: areturn
    //   525: astore 11
    //   527: new 146	java/lang/IllegalArgumentException
    //   530: dup
    //   531: new 36	java/lang/StringBuilder
    //   534: dup
    //   535: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   538: ldc -91
    //   540: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload_0
    //   544: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: aload 11
    //   552: invokespecial 168	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   555: athrow
    //   556: astore 11
    //   558: goto -31 -> 527
    //   561: astore 11
    //   563: goto -155 -> 408
    //   566: astore 11
    //   568: goto -231 -> 337
    //   571: iload 4
    //   573: istore_2
    //   574: goto -310 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	577	0	paramString	String
    //   269	127	1	c	char
    //   5	569	2	i	int
    //   3	293	3	j	int
    //   34	538	4	k	int
    //   16	442	5	m	int
    //   54	415	6	n	int
    //   92	384	7	i1	int
    //   130	355	8	i2	int
    //   168	326	9	i3	int
    //   206	297	10	i4	int
    //   305	15	11	str1	String
    //   335	26	11	localIndexOutOfBoundsException1	IndexOutOfBoundsException
    //   374	1	11	str2	String
    //   406	26	11	localNumberFormatException1	NumberFormatException
    //   446	77	11	localObject	Object
    //   525	26	11	localIllegalArgumentException1	IllegalArgumentException
    //   556	1	11	localIllegalArgumentException2	IllegalArgumentException
    //   561	1	11	localNumberFormatException2	NumberFormatException
    //   566	1	11	localIndexOutOfBoundsException2	IndexOutOfBoundsException
    //   312	130	12	localTimeZone	TimeZone
    // Exception table:
    //   from	to	target	type
    //   264	270	335	java/lang/IndexOutOfBoundsException
    //   282	307	335	java/lang/IndexOutOfBoundsException
    //   307	335	335	java/lang/IndexOutOfBoundsException
    //   379	406	335	java/lang/IndexOutOfBoundsException
    //   437	522	335	java/lang/IndexOutOfBoundsException
    //   264	270	406	java/lang/NumberFormatException
    //   282	307	406	java/lang/NumberFormatException
    //   307	335	406	java/lang/NumberFormatException
    //   379	406	406	java/lang/NumberFormatException
    //   437	522	406	java/lang/NumberFormatException
    //   10	18	525	java/lang/IllegalArgumentException
    //   24	31	525	java/lang/IllegalArgumentException
    //   47	56	525	java/lang/IllegalArgumentException
    //   62	69	525	java/lang/IllegalArgumentException
    //   85	94	525	java/lang/IllegalArgumentException
    //   100	107	525	java/lang/IllegalArgumentException
    //   123	132	525	java/lang/IllegalArgumentException
    //   138	145	525	java/lang/IllegalArgumentException
    //   161	170	525	java/lang/IllegalArgumentException
    //   176	183	525	java/lang/IllegalArgumentException
    //   199	208	525	java/lang/IllegalArgumentException
    //   217	227	525	java/lang/IllegalArgumentException
    //   233	240	525	java/lang/IllegalArgumentException
    //   256	264	525	java/lang/IllegalArgumentException
    //   264	270	556	java/lang/IllegalArgumentException
    //   282	307	556	java/lang/IllegalArgumentException
    //   307	335	556	java/lang/IllegalArgumentException
    //   379	406	556	java/lang/IllegalArgumentException
    //   437	522	556	java/lang/IllegalArgumentException
    //   10	18	561	java/lang/NumberFormatException
    //   24	31	561	java/lang/NumberFormatException
    //   47	56	561	java/lang/NumberFormatException
    //   62	69	561	java/lang/NumberFormatException
    //   85	94	561	java/lang/NumberFormatException
    //   100	107	561	java/lang/NumberFormatException
    //   123	132	561	java/lang/NumberFormatException
    //   138	145	561	java/lang/NumberFormatException
    //   161	170	561	java/lang/NumberFormatException
    //   176	183	561	java/lang/NumberFormatException
    //   199	208	561	java/lang/NumberFormatException
    //   217	227	561	java/lang/NumberFormatException
    //   233	240	561	java/lang/NumberFormatException
    //   256	264	561	java/lang/NumberFormatException
    //   10	18	566	java/lang/IndexOutOfBoundsException
    //   24	31	566	java/lang/IndexOutOfBoundsException
    //   47	56	566	java/lang/IndexOutOfBoundsException
    //   62	69	566	java/lang/IndexOutOfBoundsException
    //   85	94	566	java/lang/IndexOutOfBoundsException
    //   100	107	566	java/lang/IndexOutOfBoundsException
    //   123	132	566	java/lang/IndexOutOfBoundsException
    //   138	145	566	java/lang/IndexOutOfBoundsException
    //   161	170	566	java/lang/IndexOutOfBoundsException
    //   176	183	566	java/lang/IndexOutOfBoundsException
    //   199	208	566	java/lang/IndexOutOfBoundsException
    //   217	227	566	java/lang/IndexOutOfBoundsException
    //   233	240	566	java/lang/IndexOutOfBoundsException
    //   256	264	566	java/lang/IndexOutOfBoundsException
  }
  
  private static int parseInt(String paramString, int paramInt1, int paramInt2)
    throws NumberFormatException
  {
    if ((paramInt1 < 0) || (paramInt2 > paramString.length()) || (paramInt1 > paramInt2)) {
      throw new NumberFormatException(paramString);
    }
    int i = 0;
    int j;
    if (paramInt1 < paramInt2)
    {
      j = paramInt1 + 1;
      paramInt1 = Character.digit(paramString.charAt(paramInt1), 10);
      if (paramInt1 < 0) {
        throw new NumberFormatException("Invalid number: " + paramString);
      }
      i = -paramInt1;
      paramInt1 = j;
    }
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        j = Character.digit(paramString.charAt(paramInt1), 10);
        if (j < 0) {
          throw new NumberFormatException("Invalid number: " + paramString);
        }
        i = i * 10 - j;
        paramInt1 += 1;
      }
      else
      {
        return -i;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/util/ISO8601Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */