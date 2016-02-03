package com.j256.ormlite.misc;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class JavaxPersistence
{
  /* Error */
  public static com.j256.ormlite.field.DatabaseFieldConfig createFieldConfig(com.j256.ormlite.db.DatabaseType paramDatabaseType, java.lang.reflect.Field paramField)
    throws java.sql.SQLException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 14
    //   3: aconst_null
    //   4: astore 13
    //   6: aconst_null
    //   7: astore 12
    //   9: aconst_null
    //   10: astore 11
    //   12: aconst_null
    //   13: astore 10
    //   15: aconst_null
    //   16: astore 9
    //   18: aconst_null
    //   19: astore 8
    //   21: aconst_null
    //   22: astore 7
    //   24: aconst_null
    //   25: astore 6
    //   27: aload_1
    //   28: invokevirtual 21	java/lang/reflect/Field:getAnnotations	()[Ljava/lang/annotation/Annotation;
    //   31: astore 15
    //   33: aload 15
    //   35: arraylength
    //   36: istore_3
    //   37: iconst_0
    //   38: istore_2
    //   39: iload_2
    //   40: iload_3
    //   41: if_icmpge +178 -> 219
    //   44: aload 15
    //   46: iload_2
    //   47: aaload
    //   48: astore 5
    //   50: aload 5
    //   52: invokeinterface 27 1 0
    //   57: astore 16
    //   59: aload 16
    //   61: invokevirtual 33	java/lang/Class:getName	()Ljava/lang/String;
    //   64: ldc 35
    //   66: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: ifeq +7 -> 76
    //   72: aload 5
    //   74: astore 14
    //   76: aload 16
    //   78: invokevirtual 33	java/lang/Class:getName	()Ljava/lang/String;
    //   81: ldc 43
    //   83: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   86: ifeq +7 -> 93
    //   89: aload 5
    //   91: astore 13
    //   93: aload 16
    //   95: invokevirtual 33	java/lang/Class:getName	()Ljava/lang/String;
    //   98: ldc 45
    //   100: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   103: ifeq +7 -> 110
    //   106: aload 5
    //   108: astore 12
    //   110: aload 16
    //   112: invokevirtual 33	java/lang/Class:getName	()Ljava/lang/String;
    //   115: ldc 47
    //   117: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   120: ifeq +7 -> 127
    //   123: aload 5
    //   125: astore 11
    //   127: aload 16
    //   129: invokevirtual 33	java/lang/Class:getName	()Ljava/lang/String;
    //   132: ldc 49
    //   134: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   137: ifeq +7 -> 144
    //   140: aload 5
    //   142: astore 10
    //   144: aload 16
    //   146: invokevirtual 33	java/lang/Class:getName	()Ljava/lang/String;
    //   149: ldc 51
    //   151: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   154: ifeq +7 -> 161
    //   157: aload 5
    //   159: astore 9
    //   161: aload 16
    //   163: invokevirtual 33	java/lang/Class:getName	()Ljava/lang/String;
    //   166: ldc 53
    //   168: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifeq +7 -> 178
    //   174: aload 5
    //   176: astore 8
    //   178: aload 16
    //   180: invokevirtual 33	java/lang/Class:getName	()Ljava/lang/String;
    //   183: ldc 55
    //   185: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   188: ifeq +7 -> 195
    //   191: aload 5
    //   193: astore 7
    //   195: aload 16
    //   197: invokevirtual 33	java/lang/Class:getName	()Ljava/lang/String;
    //   200: ldc 57
    //   202: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   205: ifeq +7 -> 212
    //   208: aload 5
    //   210: astore 6
    //   212: iload_2
    //   213: iconst_1
    //   214: iadd
    //   215: istore_2
    //   216: goto -177 -> 39
    //   219: aload 14
    //   221: ifnonnull +35 -> 256
    //   224: aload 13
    //   226: ifnonnull +30 -> 256
    //   229: aload 12
    //   231: ifnonnull +25 -> 256
    //   234: aload 10
    //   236: ifnonnull +20 -> 256
    //   239: aload 9
    //   241: ifnonnull +15 -> 256
    //   244: aload 7
    //   246: ifnonnull +10 -> 256
    //   249: aload 6
    //   251: ifnonnull +5 -> 256
    //   254: aconst_null
    //   255: areturn
    //   256: new 59	com/j256/ormlite/field/DatabaseFieldConfig
    //   259: dup
    //   260: invokespecial 60	com/j256/ormlite/field/DatabaseFieldConfig:<init>	()V
    //   263: astore 16
    //   265: aload_1
    //   266: invokevirtual 61	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   269: astore 15
    //   271: aload 15
    //   273: astore 5
    //   275: aload_0
    //   276: invokeinterface 67 1 0
    //   281: ifeq +10 -> 291
    //   284: aload 15
    //   286: invokevirtual 70	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   289: astore 5
    //   291: aload 16
    //   293: aload 5
    //   295: invokevirtual 74	com/j256/ormlite/field/DatabaseFieldConfig:setFieldName	(Ljava/lang/String;)V
    //   298: aload 14
    //   300: ifnull +205 -> 505
    //   303: aload 14
    //   305: invokevirtual 77	java/lang/Object:getClass	()Ljava/lang/Class;
    //   308: ldc 79
    //   310: iconst_0
    //   311: anewarray 29	java/lang/Class
    //   314: invokevirtual 83	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   317: aload 14
    //   319: iconst_0
    //   320: anewarray 4	java/lang/Object
    //   323: invokevirtual 89	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   326: checkcast 37	java/lang/String
    //   329: astore_0
    //   330: aload_0
    //   331: ifnull +16 -> 347
    //   334: aload_0
    //   335: invokevirtual 93	java/lang/String:length	()I
    //   338: ifle +9 -> 347
    //   341: aload 16
    //   343: aload_0
    //   344: invokevirtual 96	com/j256/ormlite/field/DatabaseFieldConfig:setColumnName	(Ljava/lang/String;)V
    //   347: aload 14
    //   349: invokevirtual 77	java/lang/Object:getClass	()Ljava/lang/Class;
    //   352: ldc 98
    //   354: iconst_0
    //   355: anewarray 29	java/lang/Class
    //   358: invokevirtual 83	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   361: aload 14
    //   363: iconst_0
    //   364: anewarray 4	java/lang/Object
    //   367: invokevirtual 89	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   370: checkcast 37	java/lang/String
    //   373: astore_0
    //   374: aload_0
    //   375: ifnull +16 -> 391
    //   378: aload_0
    //   379: invokevirtual 93	java/lang/String:length	()I
    //   382: ifle +9 -> 391
    //   385: aload 16
    //   387: aload_0
    //   388: invokevirtual 101	com/j256/ormlite/field/DatabaseFieldConfig:setColumnDefinition	(Ljava/lang/String;)V
    //   391: aload 16
    //   393: aload 14
    //   395: invokevirtual 77	java/lang/Object:getClass	()Ljava/lang/Class;
    //   398: ldc 102
    //   400: iconst_0
    //   401: anewarray 29	java/lang/Class
    //   404: invokevirtual 83	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   407: aload 14
    //   409: iconst_0
    //   410: anewarray 4	java/lang/Object
    //   413: invokevirtual 89	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   416: checkcast 104	java/lang/Integer
    //   419: invokevirtual 107	java/lang/Integer:intValue	()I
    //   422: invokevirtual 111	com/j256/ormlite/field/DatabaseFieldConfig:setWidth	(I)V
    //   425: aload 14
    //   427: invokevirtual 77	java/lang/Object:getClass	()Ljava/lang/Class;
    //   430: ldc 113
    //   432: iconst_0
    //   433: anewarray 29	java/lang/Class
    //   436: invokevirtual 83	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   439: aload 14
    //   441: iconst_0
    //   442: anewarray 4	java/lang/Object
    //   445: invokevirtual 89	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   448: checkcast 115	java/lang/Boolean
    //   451: astore_0
    //   452: aload_0
    //   453: ifnull +12 -> 465
    //   456: aload 16
    //   458: aload_0
    //   459: invokevirtual 118	java/lang/Boolean:booleanValue	()Z
    //   462: invokevirtual 122	com/j256/ormlite/field/DatabaseFieldConfig:setCanBeNull	(Z)V
    //   465: aload 14
    //   467: invokevirtual 77	java/lang/Object:getClass	()Ljava/lang/Class;
    //   470: ldc 124
    //   472: iconst_0
    //   473: anewarray 29	java/lang/Class
    //   476: invokevirtual 83	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   479: aload 14
    //   481: iconst_0
    //   482: anewarray 4	java/lang/Object
    //   485: invokevirtual 89	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   488: checkcast 115	java/lang/Boolean
    //   491: astore_0
    //   492: aload_0
    //   493: ifnull +12 -> 505
    //   496: aload 16
    //   498: aload_0
    //   499: invokevirtual 118	java/lang/Boolean:booleanValue	()Z
    //   502: invokevirtual 127	com/j256/ormlite/field/DatabaseFieldConfig:setUnique	(Z)V
    //   505: aload 13
    //   507: ifnull +40 -> 547
    //   510: aload 13
    //   512: invokevirtual 77	java/lang/Object:getClass	()Ljava/lang/Class;
    //   515: ldc -127
    //   517: iconst_0
    //   518: anewarray 29	java/lang/Class
    //   521: invokevirtual 83	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   524: aload 13
    //   526: iconst_0
    //   527: anewarray 4	java/lang/Object
    //   530: invokevirtual 89	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   533: checkcast 115	java/lang/Boolean
    //   536: astore_0
    //   537: aload_0
    //   538: ifnonnull +295 -> 833
    //   541: aload 16
    //   543: iconst_1
    //   544: invokevirtual 122	com/j256/ormlite/field/DatabaseFieldConfig:setCanBeNull	(Z)V
    //   547: aload 12
    //   549: ifnull +14 -> 563
    //   552: aload 11
    //   554: ifnonnull +316 -> 870
    //   557: aload 16
    //   559: iconst_1
    //   560: invokevirtual 132	com/j256/ormlite/field/DatabaseFieldConfig:setId	(Z)V
    //   563: aload 10
    //   565: ifnonnull +8 -> 573
    //   568: aload 9
    //   570: ifnull +128 -> 698
    //   573: ldc -122
    //   575: aload_1
    //   576: invokevirtual 137	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   579: invokevirtual 141	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   582: ifne +15 -> 597
    //   585: ldc -113
    //   587: aload_1
    //   588: invokevirtual 137	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   591: invokevirtual 141	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   594: ifeq +310 -> 904
    //   597: aload 16
    //   599: iconst_1
    //   600: invokevirtual 146	com/j256/ormlite/field/DatabaseFieldConfig:setForeignCollection	(Z)V
    //   603: aload 8
    //   605: ifnull +93 -> 698
    //   608: aload 8
    //   610: invokevirtual 77	java/lang/Object:getClass	()Ljava/lang/Class;
    //   613: ldc 79
    //   615: iconst_0
    //   616: anewarray 29	java/lang/Class
    //   619: invokevirtual 83	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   622: aload 8
    //   624: iconst_0
    //   625: anewarray 4	java/lang/Object
    //   628: invokevirtual 89	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   631: checkcast 37	java/lang/String
    //   634: astore_0
    //   635: aload_0
    //   636: ifnull +16 -> 652
    //   639: aload_0
    //   640: invokevirtual 93	java/lang/String:length	()I
    //   643: ifle +9 -> 652
    //   646: aload 16
    //   648: aload_0
    //   649: invokevirtual 149	com/j256/ormlite/field/DatabaseFieldConfig:setForeignCollectionColumnName	(Ljava/lang/String;)V
    //   652: aload 8
    //   654: invokevirtual 77	java/lang/Object:getClass	()Ljava/lang/Class;
    //   657: ldc -105
    //   659: iconst_0
    //   660: anewarray 29	java/lang/Class
    //   663: invokevirtual 83	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   666: aload 8
    //   668: iconst_0
    //   669: anewarray 4	java/lang/Object
    //   672: invokevirtual 89	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   675: astore_0
    //   676: aload_0
    //   677: ifnull +21 -> 698
    //   680: aload_0
    //   681: invokevirtual 154	java/lang/Object:toString	()Ljava/lang/String;
    //   684: ldc -100
    //   686: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   689: ifeq +9 -> 698
    //   692: aload 16
    //   694: iconst_1
    //   695: invokevirtual 159	com/j256/ormlite/field/DatabaseFieldConfig:setForeignCollectionEager	(Z)V
    //   698: aload 7
    //   700: ifnull +51 -> 751
    //   703: aload 7
    //   705: invokevirtual 77	java/lang/Object:getClass	()Ljava/lang/Class;
    //   708: ldc -95
    //   710: iconst_0
    //   711: anewarray 29	java/lang/Class
    //   714: invokevirtual 83	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   717: aload 7
    //   719: iconst_0
    //   720: anewarray 4	java/lang/Object
    //   723: invokevirtual 89	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   726: astore_0
    //   727: aload_0
    //   728: ifnull +339 -> 1067
    //   731: aload_0
    //   732: invokevirtual 154	java/lang/Object:toString	()Ljava/lang/String;
    //   735: ldc -93
    //   737: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   740: ifeq +327 -> 1067
    //   743: aload 16
    //   745: getstatic 169	com/j256/ormlite/field/DataType:ENUM_STRING	Lcom/j256/ormlite/field/DataType;
    //   748: invokevirtual 173	com/j256/ormlite/field/DatabaseFieldConfig:setDataType	(Lcom/j256/ormlite/field/DataType;)V
    //   751: aload 6
    //   753: ifnull +9 -> 762
    //   756: aload 16
    //   758: iconst_1
    //   759: invokevirtual 176	com/j256/ormlite/field/DatabaseFieldConfig:setVersion	(Z)V
    //   762: aload 16
    //   764: invokevirtual 180	com/j256/ormlite/field/DatabaseFieldConfig:getDataPersister	()Lcom/j256/ormlite/field/DataPersister;
    //   767: ifnonnull +12 -> 779
    //   770: aload 16
    //   772: aload_1
    //   773: invokestatic 186	com/j256/ormlite/field/DataPersisterManager:lookupForField	(Ljava/lang/reflect/Field;)Lcom/j256/ormlite/field/DataPersister;
    //   776: invokevirtual 190	com/j256/ormlite/field/DatabaseFieldConfig:setDataPersister	(Lcom/j256/ormlite/field/DataPersister;)V
    //   779: aload_1
    //   780: iconst_0
    //   781: invokestatic 194	com/j256/ormlite/field/DatabaseFieldConfig:findGetMethod	(Ljava/lang/reflect/Field;Z)Ljava/lang/reflect/Method;
    //   784: ifnull +319 -> 1103
    //   787: aload_1
    //   788: iconst_0
    //   789: invokestatic 197	com/j256/ormlite/field/DatabaseFieldConfig:findSetMethod	(Ljava/lang/reflect/Field;Z)Ljava/lang/reflect/Method;
    //   792: ifnull +311 -> 1103
    //   795: iconst_1
    //   796: istore 4
    //   798: aload 16
    //   800: iload 4
    //   802: invokevirtual 200	com/j256/ormlite/field/DatabaseFieldConfig:setUseGetSet	(Z)V
    //   805: aload 16
    //   807: areturn
    //   808: astore_0
    //   809: new 202	java/lang/StringBuilder
    //   812: dup
    //   813: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   816: ldc -51
    //   818: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: aload_1
    //   822: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   825: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: aload_0
    //   829: invokestatic 219	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   832: athrow
    //   833: aload 16
    //   835: aload_0
    //   836: invokevirtual 118	java/lang/Boolean:booleanValue	()Z
    //   839: invokevirtual 122	com/j256/ormlite/field/DatabaseFieldConfig:setCanBeNull	(Z)V
    //   842: goto -295 -> 547
    //   845: astore_0
    //   846: new 202	java/lang/StringBuilder
    //   849: dup
    //   850: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   853: ldc -35
    //   855: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: aload_1
    //   859: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   862: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   865: aload_0
    //   866: invokestatic 219	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   869: athrow
    //   870: aload 16
    //   872: iconst_1
    //   873: invokevirtual 224	com/j256/ormlite/field/DatabaseFieldConfig:setGeneratedId	(Z)V
    //   876: goto -313 -> 563
    //   879: astore_0
    //   880: new 202	java/lang/StringBuilder
    //   883: dup
    //   884: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   887: ldc -30
    //   889: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: aload_1
    //   893: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   896: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   899: aload_0
    //   900: invokestatic 219	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   903: athrow
    //   904: aload 16
    //   906: iconst_1
    //   907: invokevirtual 229	com/j256/ormlite/field/DatabaseFieldConfig:setForeign	(Z)V
    //   910: aload 8
    //   912: ifnull -214 -> 698
    //   915: aload 8
    //   917: invokevirtual 77	java/lang/Object:getClass	()Ljava/lang/Class;
    //   920: ldc 79
    //   922: iconst_0
    //   923: anewarray 29	java/lang/Class
    //   926: invokevirtual 83	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   929: aload 8
    //   931: iconst_0
    //   932: anewarray 4	java/lang/Object
    //   935: invokevirtual 89	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   938: checkcast 37	java/lang/String
    //   941: astore_0
    //   942: aload_0
    //   943: ifnull +16 -> 959
    //   946: aload_0
    //   947: invokevirtual 93	java/lang/String:length	()I
    //   950: ifle +9 -> 959
    //   953: aload 16
    //   955: aload_0
    //   956: invokevirtual 96	com/j256/ormlite/field/DatabaseFieldConfig:setColumnName	(Ljava/lang/String;)V
    //   959: aload 8
    //   961: invokevirtual 77	java/lang/Object:getClass	()Ljava/lang/Class;
    //   964: ldc 113
    //   966: iconst_0
    //   967: anewarray 29	java/lang/Class
    //   970: invokevirtual 83	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   973: aload 8
    //   975: iconst_0
    //   976: anewarray 4	java/lang/Object
    //   979: invokevirtual 89	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   982: checkcast 115	java/lang/Boolean
    //   985: astore_0
    //   986: aload_0
    //   987: ifnull +12 -> 999
    //   990: aload 16
    //   992: aload_0
    //   993: invokevirtual 118	java/lang/Boolean:booleanValue	()Z
    //   996: invokevirtual 122	com/j256/ormlite/field/DatabaseFieldConfig:setCanBeNull	(Z)V
    //   999: aload 8
    //   1001: invokevirtual 77	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1004: ldc 124
    //   1006: iconst_0
    //   1007: anewarray 29	java/lang/Class
    //   1010: invokevirtual 83	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1013: aload 8
    //   1015: iconst_0
    //   1016: anewarray 4	java/lang/Object
    //   1019: invokevirtual 89	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1022: checkcast 115	java/lang/Boolean
    //   1025: astore_0
    //   1026: aload_0
    //   1027: ifnull -329 -> 698
    //   1030: aload 16
    //   1032: aload_0
    //   1033: invokevirtual 118	java/lang/Boolean:booleanValue	()Z
    //   1036: invokevirtual 127	com/j256/ormlite/field/DatabaseFieldConfig:setUnique	(Z)V
    //   1039: goto -341 -> 698
    //   1042: astore_0
    //   1043: new 202	java/lang/StringBuilder
    //   1046: dup
    //   1047: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1050: ldc -30
    //   1052: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: aload_1
    //   1056: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1059: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1062: aload_0
    //   1063: invokestatic 219	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   1066: athrow
    //   1067: aload 16
    //   1069: getstatic 232	com/j256/ormlite/field/DataType:ENUM_INTEGER	Lcom/j256/ormlite/field/DataType;
    //   1072: invokevirtual 173	com/j256/ormlite/field/DatabaseFieldConfig:setDataType	(Lcom/j256/ormlite/field/DataType;)V
    //   1075: goto -324 -> 751
    //   1078: astore_0
    //   1079: new 202	java/lang/StringBuilder
    //   1082: dup
    //   1083: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1086: ldc -22
    //   1088: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: aload_1
    //   1092: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1095: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1098: aload_0
    //   1099: invokestatic 219	com/j256/ormlite/misc/SqlExceptionUtil:create	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;
    //   1102: athrow
    //   1103: iconst_0
    //   1104: istore 4
    //   1106: goto -308 -> 798
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1109	0	paramDatabaseType	com.j256.ormlite.db.DatabaseType
    //   0	1109	1	paramField	java.lang.reflect.Field
    //   38	178	2	i	int
    //   36	6	3	j	int
    //   796	309	4	bool	boolean
    //   48	246	5	localObject1	Object
    //   25	727	6	localObject2	Object
    //   22	696	7	localObject3	Object
    //   19	995	8	localObject4	Object
    //   16	553	9	localObject5	Object
    //   13	551	10	localObject6	Object
    //   10	543	11	localObject7	Object
    //   7	541	12	localObject8	Object
    //   4	521	13	localObject9	Object
    //   1	479	14	localObject10	Object
    //   31	254	15	localObject11	Object
    //   57	1011	16	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   303	330	808	java/lang/Exception
    //   334	347	808	java/lang/Exception
    //   347	374	808	java/lang/Exception
    //   378	391	808	java/lang/Exception
    //   391	452	808	java/lang/Exception
    //   456	465	808	java/lang/Exception
    //   465	492	808	java/lang/Exception
    //   496	505	808	java/lang/Exception
    //   510	537	845	java/lang/Exception
    //   541	547	845	java/lang/Exception
    //   833	842	845	java/lang/Exception
    //   608	635	879	java/lang/Exception
    //   639	652	879	java/lang/Exception
    //   652	676	879	java/lang/Exception
    //   680	698	879	java/lang/Exception
    //   915	942	1042	java/lang/Exception
    //   946	959	1042	java/lang/Exception
    //   959	986	1042	java/lang/Exception
    //   990	999	1042	java/lang/Exception
    //   999	1026	1042	java/lang/Exception
    //   1030	1039	1042	java/lang/Exception
    //   703	727	1078	java/lang/Exception
    //   731	751	1078	java/lang/Exception
    //   1067	1075	1078	java/lang/Exception
  }
  
  public static String getEntityName(Class<?> paramClass)
  {
    Object localObject = null;
    Annotation[] arrayOfAnnotation = paramClass.getAnnotations();
    int j = arrayOfAnnotation.length;
    int i = 0;
    while (i < j)
    {
      Annotation localAnnotation = arrayOfAnnotation[i];
      if (localAnnotation.annotationType().getName().equals("javax.persistence.Entity")) {
        localObject = localAnnotation;
      }
      i += 1;
    }
    if (localObject == null) {
      paramClass = null;
    }
    for (;;)
    {
      return paramClass;
      try
      {
        localObject = (String)localObject.getClass().getMethod("name", new Class[0]).invoke(localObject, new Object[0]);
        if (localObject != null)
        {
          i = ((String)localObject).length();
          paramClass = (Class<?>)localObject;
          if (i > 0) {
            continue;
          }
        }
        return null;
      }
      catch (Exception localException)
      {
        throw new IllegalStateException("Could not get entity name from class " + paramClass, localException);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/misc/JavaxPersistence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */