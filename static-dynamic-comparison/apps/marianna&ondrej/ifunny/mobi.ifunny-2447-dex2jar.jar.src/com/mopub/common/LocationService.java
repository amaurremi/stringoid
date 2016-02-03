package com.mopub.common;

public class LocationService {
    /* Error */
    public static android.location.Location getLastKnownLocation(android.content.Context paramContext, int paramInt, MoPub.LocationAwareness paramLocationAwareness) {
        // Byte code:
        //   0: aload_2
        //   1: getstatic 21	com/mopub/common/MoPub$LocationAwareness:DISABLED	Lcom/mopub/common/MoPub$LocationAwareness;
        //   4: if_acmpne +5 -> 9
        //   7: aconst_null
        //   8: areturn
        //   9: aload_0
        //   10: ldc 23
        //   12: invokevirtual 29	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
        //   15: checkcast 31	android/location/LocationManager
        //   18: astore_0
        //   19: aload_0
        //   20: ldc 33
        //   22: invokevirtual 36	android/location/LocationManager:getLastKnownLocation	(Ljava/lang/String;)Landroid/location/Location;
        //   25: astore_3
        //   26: aload_0
        //   27: ldc 38
        //   29: invokevirtual 36	android/location/LocationManager:getLastKnownLocation	(Ljava/lang/String;)Landroid/location/Location;
        //   32: astore_0
        //   33: aload_3
        //   34: ifnonnull +7 -> 41
        //   37: aload_0
        //   38: ifnull -31 -> 7
        //   41: aload_3
        //   42: ifnull +124 -> 166
        //   45: aload_0
        //   46: ifnull +120 -> 166
        //   49: aload_3
        //   50: invokevirtual 44	android/location/Location:getTime	()J
        //   53: aload_0
        //   54: invokevirtual 44	android/location/Location:getTime	()J
        //   57: lcmp
        //   58: ifle +102 -> 160
        //   61: aload_3
        //   62: astore 4
        //   64: aload_2
        //   65: getstatic 47	com/mopub/common/MoPub$LocationAwareness:TRUNCATED	Lcom/mopub/common/MoPub$LocationAwareness;
        //   68: if_acmpne +45 -> 113
        //   71: aload 4
        //   73: aload 4
        //   75: invokevirtual 51	android/location/Location:getLatitude	()D
        //   78: invokestatic 57	java/math/BigDecimal:valueOf	(D)Ljava/math/BigDecimal;
        //   81: iload_1
        //   82: iconst_5
        //   83: invokevirtual 61	java/math/BigDecimal:setScale	(II)Ljava/math/BigDecimal;
        //   86: invokevirtual 64	java/math/BigDecimal:doubleValue	()D
        //   89: invokevirtual 68	android/location/Location:setLatitude	(D)V
        //   92: aload 4
        //   94: aload 4
        //   96: invokevirtual 71	android/location/Location:getLongitude	()D
        //   99: invokestatic 57	java/math/BigDecimal:valueOf	(D)Ljava/math/BigDecimal;
        //   102: iload_1
        //   103: iconst_5
        //   104: invokevirtual 61	java/math/BigDecimal:setScale	(II)Ljava/math/BigDecimal;
        //   107: invokevirtual 64	java/math/BigDecimal:doubleValue	()D
        //   110: invokevirtual 74	android/location/Location:setLongitude	(D)V
        //   113: aload 4
        //   115: areturn
        //   116: astore_3
        //   117: ldc 76
        //   119: invokestatic 82	com/mopub/common/logging/MoPubLog:d	(Ljava/lang/String;)V
        //   122: aconst_null
        //   123: astore_3
        //   124: goto -98 -> 26
        //   127: astore_3
        //   128: ldc 84
        //   130: invokestatic 82	com/mopub/common/logging/MoPubLog:d	(Ljava/lang/String;)V
        //   133: aconst_null
        //   134: astore_3
        //   135: goto -109 -> 26
        //   138: astore_0
        //   139: ldc 86
        //   141: invokestatic 82	com/mopub/common/logging/MoPubLog:d	(Ljava/lang/String;)V
        //   144: aconst_null
        //   145: astore_0
        //   146: goto -113 -> 33
        //   149: astore_0
        //   150: ldc 88
        //   152: invokestatic 82	com/mopub/common/logging/MoPubLog:d	(Ljava/lang/String;)V
        //   155: aconst_null
        //   156: astore_0
        //   157: goto -124 -> 33
        //   160: aload_0
        //   161: astore 4
        //   163: goto -99 -> 64
        //   166: aload_3
        //   167: astore 4
        //   169: aload_3
        //   170: ifnonnull -106 -> 64
        //   173: aload_0
        //   174: astore 4
        //   176: goto -112 -> 64
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	179	0	paramContext	android.content.Context
        //   0	179	1	paramInt	int
        //   0	179	2	paramLocationAwareness	MoPub.LocationAwareness
        //   25	37	3	localLocation	android.location.Location
        //   116	1	3	localSecurityException	SecurityException
        //   123	1	3	localObject1	Object
        //   127	1	3	localIllegalArgumentException	IllegalArgumentException
        //   134	36	3	localObject2	Object
        //   62	113	4	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   19	26	116	java/lang/SecurityException
        //   19	26	127	java/lang/IllegalArgumentException
        //   26	33	138	java/lang/SecurityException
        //   26	33	149	java/lang/IllegalArgumentException
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/LocationService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */