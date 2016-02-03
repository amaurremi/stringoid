package com.android.ex.chips;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import java.util.Set;

public class d
  extends Filter
{
  protected d(c paramc) {}
  
  public CharSequence convertResultToString(Object paramObject)
  {
    return ((aa)paramObject).toString();
  }
  
  /* Error */
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/android/ex/chips/d:a	Lcom/android/ex/chips/c;
    //   4: invokestatic 29	com/android/ex/chips/c:a	(Lcom/android/ex/chips/c;)Lcom/android/ex/chips/k;
    //   7: ifnull +16 -> 23
    //   10: aload_0
    //   11: getfield 10	com/android/ex/chips/d:a	Lcom/android/ex/chips/c;
    //   14: invokestatic 29	com/android/ex/chips/c:a	(Lcom/android/ex/chips/c;)Lcom/android/ex/chips/k;
    //   17: aload_1
    //   18: invokeinterface 34 2 0
    //   23: new 36	android/widget/Filter$FilterResults
    //   26: dup
    //   27: invokespecial 37	android/widget/Filter$FilterResults:<init>	()V
    //   30: astore 4
    //   32: aload_0
    //   33: getfield 10	com/android/ex/chips/d:a	Lcom/android/ex/chips/c;
    //   36: invokestatic 41	com/android/ex/chips/c:b	(Lcom/android/ex/chips/c;)Z
    //   39: ifne +31 -> 70
    //   42: aload_1
    //   43: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifeq +24 -> 70
    //   49: aload 4
    //   51: new 49	com/android/ex/chips/e
    //   54: dup
    //   55: invokespecial 50	com/android/ex/chips/e:<init>	()V
    //   58: putfield 54	android/widget/Filter$FilterResults:values	Ljava/lang/Object;
    //   61: aload 4
    //   63: iconst_1
    //   64: putfield 58	android/widget/Filter$FilterResults:count	I
    //   67: aload 4
    //   69: areturn
    //   70: new 60	java/util/LinkedHashMap
    //   73: dup
    //   74: invokespecial 61	java/util/LinkedHashMap:<init>	()V
    //   77: astore 5
    //   79: new 63	java/util/ArrayList
    //   82: dup
    //   83: invokespecial 64	java/util/ArrayList:<init>	()V
    //   86: astore 6
    //   88: new 66	java/util/HashSet
    //   91: dup
    //   92: invokespecial 67	java/util/HashSet:<init>	()V
    //   95: astore 7
    //   97: aload_0
    //   98: getfield 10	com/android/ex/chips/d:a	Lcom/android/ex/chips/c;
    //   101: aload_1
    //   102: aload 5
    //   104: aload 6
    //   106: aload 7
    //   108: invokevirtual 70	com/android/ex/chips/c:a	(Ljava/lang/CharSequence;Ljava/util/LinkedHashMap;Ljava/util/List;Ljava/util/Set;)V
    //   111: aload_1
    //   112: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   115: ifne +250 -> 365
    //   118: aload_0
    //   119: getfield 10	com/android/ex/chips/d:a	Lcom/android/ex/chips/c;
    //   122: aload_1
    //   123: aload_0
    //   124: getfield 10	com/android/ex/chips/d:a	Lcom/android/ex/chips/c;
    //   127: invokestatic 74	com/android/ex/chips/c:c	(Lcom/android/ex/chips/c;)I
    //   130: aconst_null
    //   131: invokestatic 77	com/android/ex/chips/c:a	(Lcom/android/ex/chips/c;Ljava/lang/CharSequence;ILjava/lang/Long;)Landroid/database/Cursor;
    //   134: astore_1
    //   135: aload_1
    //   136: ifnull +75 -> 211
    //   139: aload_1
    //   140: invokeinterface 83 1 0
    //   145: ifeq +66 -> 211
    //   148: aload_0
    //   149: getfield 10	com/android/ex/chips/d:a	Lcom/android/ex/chips/c;
    //   152: new 85	com/android/ex/chips/m
    //   155: dup
    //   156: aload_1
    //   157: aload_0
    //   158: getfield 10	com/android/ex/chips/d:a	Lcom/android/ex/chips/c;
    //   161: invokestatic 88	com/android/ex/chips/c:d	(Lcom/android/ex/chips/c;)Z
    //   164: invokespecial 91	com/android/ex/chips/m:<init>	(Landroid/database/Cursor;Z)V
    //   167: iconst_1
    //   168: aload 5
    //   170: aload 6
    //   172: aload 7
    //   174: invokevirtual 94	com/android/ex/chips/c:a	(Lcom/android/ex/chips/m;ZLjava/util/LinkedHashMap;Ljava/util/List;Ljava/util/Set;)V
    //   177: goto -38 -> 139
    //   180: astore 4
    //   182: aconst_null
    //   183: astore_2
    //   184: aload_1
    //   185: astore_3
    //   186: aload 4
    //   188: astore_1
    //   189: aload_3
    //   190: ifnull +9 -> 199
    //   193: aload_3
    //   194: invokeinterface 97 1 0
    //   199: aload_2
    //   200: ifnull +9 -> 209
    //   203: aload_2
    //   204: invokeinterface 97 1 0
    //   209: aload_1
    //   210: athrow
    //   211: aload_0
    //   212: getfield 10	com/android/ex/chips/d:a	Lcom/android/ex/chips/c;
    //   215: iconst_0
    //   216: aload 5
    //   218: aload 6
    //   220: aload 7
    //   222: invokevirtual 100	com/android/ex/chips/c:a	(ZLjava/util/LinkedHashMap;Ljava/util/List;Ljava/util/Set;)Ljava/util/List;
    //   225: astore 8
    //   227: aload_0
    //   228: getfield 10	com/android/ex/chips/d:a	Lcom/android/ex/chips/c;
    //   231: invokestatic 74	com/android/ex/chips/c:c	(Lcom/android/ex/chips/c;)I
    //   234: aload 7
    //   236: invokeinterface 106 1 0
    //   241: isub
    //   242: ifle +88 -> 330
    //   245: invokestatic 111	com/ideashower/readitlater/util/a:e	()Z
    //   248: ifeq +82 -> 330
    //   251: aload_0
    //   252: getfield 10	com/android/ex/chips/d:a	Lcom/android/ex/chips/c;
    //   255: invokestatic 114	com/android/ex/chips/c:e	(Lcom/android/ex/chips/c;)Landroid/content/ContentResolver;
    //   258: getstatic 119	com/android/ex/chips/h:a	Landroid/net/Uri;
    //   261: getstatic 122	com/android/ex/chips/h:b	[Ljava/lang/String;
    //   264: aconst_null
    //   265: aconst_null
    //   266: aconst_null
    //   267: invokevirtual 128	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   270: astore_2
    //   271: aload_0
    //   272: getfield 10	com/android/ex/chips/d:a	Lcom/android/ex/chips/c;
    //   275: aload_2
    //   276: invokestatic 131	com/android/ex/chips/c:a	(Lcom/android/ex/chips/c;Landroid/database/Cursor;)Ljava/util/List;
    //   279: astore_3
    //   280: aload 4
    //   282: new 49	com/android/ex/chips/e
    //   285: dup
    //   286: aload 8
    //   288: aload 5
    //   290: aload 6
    //   292: aload 7
    //   294: aload_3
    //   295: invokespecial 134	com/android/ex/chips/e:<init>	(Ljava/util/List;Ljava/util/LinkedHashMap;Ljava/util/List;Ljava/util/Set;Ljava/util/List;)V
    //   298: putfield 54	android/widget/Filter$FilterResults:values	Ljava/lang/Object;
    //   301: aload 4
    //   303: iconst_1
    //   304: putfield 58	android/widget/Filter$FilterResults:count	I
    //   307: aload_1
    //   308: ifnull +9 -> 317
    //   311: aload_1
    //   312: invokeinterface 97 1 0
    //   317: aload_2
    //   318: ifnull +9 -> 327
    //   321: aload_2
    //   322: invokeinterface 97 1 0
    //   327: aload 4
    //   329: areturn
    //   330: aconst_null
    //   331: astore_3
    //   332: aconst_null
    //   333: astore_2
    //   334: goto -54 -> 280
    //   337: astore_1
    //   338: aconst_null
    //   339: astore_3
    //   340: aconst_null
    //   341: astore_2
    //   342: goto -153 -> 189
    //   345: astore 4
    //   347: aload_1
    //   348: astore_3
    //   349: aload 4
    //   351: astore_1
    //   352: goto -163 -> 189
    //   355: astore 4
    //   357: aload_1
    //   358: astore_3
    //   359: aload 4
    //   361: astore_1
    //   362: goto -173 -> 189
    //   365: aconst_null
    //   366: astore_1
    //   367: goto -232 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	this	d
    //   0	370	1	paramCharSequence	CharSequence
    //   183	159	2	localCursor	android.database.Cursor
    //   185	174	3	localObject1	Object
    //   30	38	4	localFilterResults1	Filter.FilterResults
    //   180	148	4	localFilterResults2	Filter.FilterResults
    //   345	5	4	localObject2	Object
    //   355	5	4	localObject3	Object
    //   77	212	5	localLinkedHashMap	java.util.LinkedHashMap
    //   86	205	6	localArrayList	java.util.ArrayList
    //   95	198	7	localHashSet	java.util.HashSet
    //   225	62	8	localList	java.util.List
    // Exception table:
    //   from	to	target	type
    //   139	177	180	finally
    //   211	271	180	finally
    //   111	135	337	finally
    //   271	280	345	finally
    //   280	307	355	finally
  }
  
  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    c.a(this.a, paramCharSequence);
    if (paramFilterResults.values != null)
    {
      paramFilterResults = (e)paramFilterResults.values;
      if (paramFilterResults.f) {
        break label121;
      }
      c.a(this.a, paramFilterResults.b);
      c.a(this.a, paramFilterResults.c);
      c.a(this.a, paramFilterResults.d);
      c.b(this.a, paramFilterResults.a);
      if (paramFilterResults.e != null)
      {
        int i = c.c(this.a);
        int j = paramFilterResults.d.size();
        c.a(this.a, paramCharSequence, paramFilterResults.e, i - j);
      }
    }
    return;
    label121:
    c.b(this.a, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/android/ex/chips/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */