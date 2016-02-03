package com.amazon.device.ads;

class ba {
    private bb a = bb.b;
    private int b = 6;

    private static double a(double paramDouble) {
        return Math.round(paramDouble * 60.0D) / 60.0D;
    }

    /* Error */
    public android.location.Location a() {
        // Byte code:
        //   0: ldc 36
        //   2: fstore_2
        //   3: invokestatic 42	com/amazon/device/ads/dn:i	()Lcom/amazon/device/ads/dl;
        //   6: invokeinterface 48 1 0
        //   11: astore_3
        //   12: aload_0
        //   13: getfield 18	com/amazon/device/ads/ba:a	Lcom/amazon/device/ads/bb;
        //   16: getstatic 51	com/amazon/device/ads/bb:c	Lcom/amazon/device/ads/bb;
        //   19: if_acmpne +5 -> 24
        //   22: aconst_null
        //   23: areturn
        //   24: aload_3
        //   25: ldc 53
        //   27: invokevirtual 59	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
        //   30: checkcast 61	android/location/LocationManager
        //   33: astore_3
        //   34: aload_3
        //   35: ldc 63
        //   37: invokevirtual 67	android/location/LocationManager:getLastKnownLocation	(Ljava/lang/String;)Landroid/location/Location;
        //   40: astore 4
        //   42: aload_3
        //   43: ldc 69
        //   45: invokevirtual 67	android/location/LocationManager:getLastKnownLocation	(Ljava/lang/String;)Landroid/location/Location;
        //   48: astore_3
        //   49: aload 4
        //   51: ifnonnull +7 -> 58
        //   54: aload_3
        //   55: ifnull -33 -> 22
        //   58: aload 4
        //   60: ifnull +267 -> 327
        //   63: aload_3
        //   64: ifnull +263 -> 327
        //   67: aload 4
        //   69: aload_3
        //   70: invokevirtual 75	android/location/Location:distanceTo	(Landroid/location/Location;)F
        //   73: ldc 76
        //   75: fdiv
        //   76: ldc 77
        //   78: fcmpg
        //   79: ifgt +212 -> 291
        //   82: aload 4
        //   84: invokevirtual 81	android/location/Location:hasAccuracy	()Z
        //   87: ifeq +185 -> 272
        //   90: aload 4
        //   92: invokevirtual 85	android/location/Location:getAccuracy	()F
        //   95: fstore_1
        //   96: aload_3
        //   97: invokevirtual 81	android/location/Location:hasAccuracy	()Z
        //   100: ifeq +8 -> 108
        //   103: aload_3
        //   104: invokevirtual 85	android/location/Location:getAccuracy	()F
        //   107: fstore_2
        //   108: fload_1
        //   109: fload_2
        //   110: fcmpg
        //   111: ifge +167 -> 278
        //   114: ldc 87
        //   116: ldc 89
        //   118: invokestatic 94	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   121: aload_0
        //   122: getfield 18	com/amazon/device/ads/ba:a	Lcom/amazon/device/ads/bb;
        //   125: getstatic 16	com/amazon/device/ads/bb:b	Lcom/amazon/device/ads/bb;
        //   128: if_acmpne +85 -> 213
        //   131: aload 4
        //   133: aload 4
        //   135: invokevirtual 98	android/location/Location:getLatitude	()D
        //   138: invokestatic 100	com/amazon/device/ads/ba:a	(D)D
        //   141: ldc2_w 101
        //   144: aload_0
        //   145: getfield 20	com/amazon/device/ads/ba:b	I
        //   148: i2d
        //   149: invokestatic 106	java/lang/Math:pow	(DD)D
        //   152: dmul
        //   153: invokestatic 30	java/lang/Math:round	(D)J
        //   156: l2d
        //   157: ldc2_w 101
        //   160: aload_0
        //   161: getfield 20	com/amazon/device/ads/ba:b	I
        //   164: i2d
        //   165: invokestatic 106	java/lang/Math:pow	(DD)D
        //   168: ddiv
        //   169: invokevirtual 110	android/location/Location:setLatitude	(D)V
        //   172: aload 4
        //   174: aload 4
        //   176: invokevirtual 113	android/location/Location:getLongitude	()D
        //   179: invokestatic 100	com/amazon/device/ads/ba:a	(D)D
        //   182: ldc2_w 101
        //   185: aload_0
        //   186: getfield 20	com/amazon/device/ads/ba:b	I
        //   189: i2d
        //   190: invokestatic 106	java/lang/Math:pow	(DD)D
        //   193: dmul
        //   194: invokestatic 30	java/lang/Math:round	(D)J
        //   197: l2d
        //   198: ldc2_w 101
        //   201: aload_0
        //   202: getfield 20	com/amazon/device/ads/ba:b	I
        //   205: i2d
        //   206: invokestatic 106	java/lang/Math:pow	(DD)D
        //   209: ddiv
        //   210: invokevirtual 116	android/location/Location:setLongitude	(D)V
        //   213: aload 4
        //   215: areturn
        //   216: astore 4
        //   218: ldc 87
        //   220: ldc 118
        //   222: invokestatic 94	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   225: aconst_null
        //   226: astore 4
        //   228: goto -186 -> 42
        //   231: astore 4
        //   233: ldc 87
        //   235: ldc 120
        //   237: invokestatic 94	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   240: aconst_null
        //   241: astore 4
        //   243: goto -201 -> 42
        //   246: astore_3
        //   247: ldc 87
        //   249: ldc 122
        //   251: invokestatic 94	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   254: aconst_null
        //   255: astore_3
        //   256: goto -207 -> 49
        //   259: astore_3
        //   260: ldc 87
        //   262: ldc 124
        //   264: invokestatic 94	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   267: aconst_null
        //   268: astore_3
        //   269: goto -220 -> 49
        //   272: ldc 36
        //   274: fstore_1
        //   275: goto -179 -> 96
        //   278: ldc 87
        //   280: ldc 126
        //   282: invokestatic 94	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   285: aload_3
        //   286: astore 4
        //   288: goto -167 -> 121
        //   291: aload 4
        //   293: invokevirtual 130	android/location/Location:getTime	()J
        //   296: aload_3
        //   297: invokevirtual 130	android/location/Location:getTime	()J
        //   300: lcmp
        //   301: ifle +13 -> 314
        //   304: ldc 87
        //   306: ldc -124
        //   308: invokestatic 94	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   311: goto -190 -> 121
        //   314: ldc 87
        //   316: ldc -122
        //   318: invokestatic 94	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   321: aload_3
        //   322: astore 4
        //   324: goto -203 -> 121
        //   327: aload 4
        //   329: ifnull +13 -> 342
        //   332: ldc 87
        //   334: ldc -120
        //   336: invokestatic 94	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   339: goto -218 -> 121
        //   342: ldc 87
        //   344: ldc -118
        //   346: invokestatic 94	com/amazon/device/ads/dv:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   349: aload_3
        //   350: astore 4
        //   352: goto -231 -> 121
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	355	0	this	ba
        //   95	180	1	f1	float
        //   2	108	2	f2	float
        //   11	93	3	localObject1	Object
        //   246	1	3	localSecurityException1	SecurityException
        //   255	1	3	localObject2	Object
        //   259	1	3	localIllegalArgumentException1	IllegalArgumentException
        //   268	82	3	localObject3	Object
        //   40	174	4	localLocation	android.location.Location
        //   216	1	4	localSecurityException2	SecurityException
        //   226	1	4	localObject4	Object
        //   231	1	4	localIllegalArgumentException2	IllegalArgumentException
        //   241	110	4	localObject5	Object
        // Exception table:
        //   from	to	target	type
        //   34	42	216	java/lang/SecurityException
        //   34	42	231	java/lang/IllegalArgumentException
        //   42	49	246	java/lang/SecurityException
        //   42	49	259	java/lang/IllegalArgumentException
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */