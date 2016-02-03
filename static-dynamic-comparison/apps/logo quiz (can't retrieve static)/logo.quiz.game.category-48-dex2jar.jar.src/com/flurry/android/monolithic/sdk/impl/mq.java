package com.flurry.android.monolithic.sdk.impl;

import java.util.List;
import java.util.Map;

public abstract class mq
{
  public static final mq c = new nh("null");
  public static final mq d = new nh("boolean");
  public static final mq e = new nh("int");
  public static final mq f = new nh("long");
  public static final mq g = new nh("float");
  public static final mq h = new nh("double");
  public static final mq i = new nh("string");
  public static final mq j = new nh("bytes");
  public static final mq k = new nh("fixed");
  public static final mq l = new nh("enum");
  public static final mq m = new nh("union");
  public static final mq n = new nh("array-start");
  public static final mq o = new nh("array-end");
  public static final mq p = new nh("map-start");
  public static final mq q = new nh("map-end");
  public static final mq r = new nh("item-end");
  public static final mq s = new nh("field-action");
  public static final mq t = new my(false, null);
  public static final mq u = new my(true, null);
  public static final mq v = new my(true, null);
  public static final mq w = new my(true, null);
  public static final mq x = new my(true, null);
  public static final mq y = new nh("map-key-marker");
  public final na a;
  public final mq[] b;
  
  protected mq(na paramna)
  {
    this(paramna, null);
  }
  
  protected mq(na paramna, mq[] paramArrayOfmq)
  {
    this.b = paramArrayOfmq;
    this.a = paramna;
  }
  
  protected static int a(mq[] paramArrayOfmq, int paramInt)
  {
    int i2 = 0;
    int i1 = paramInt;
    paramInt = i2;
    if (i1 < paramArrayOfmq.length)
    {
      if ((paramArrayOfmq[i1] instanceof ne)) {
        paramInt = ((ne)paramArrayOfmq[i1]).a() + paramInt;
      }
      for (;;)
      {
        i1 += 1;
        break;
        paramInt += 1;
      }
    }
    return paramInt;
  }
  
  static mq a(mq parammq1, mq parammq2)
  {
    return new nc(parammq1, parammq2, null);
  }
  
  static mq a(mq parammq, mq... paramVarArgs)
  {
    return new nb(parammq, paramVarArgs, null);
  }
  
  static mq a(String paramString)
  {
    return new mv(paramString, null);
  }
  
  static mq a(mq... paramVarArgs)
  {
    return new nd(paramVarArgs, null);
  }
  
  static mq a(mq[] paramArrayOfmq, String[] paramArrayOfString)
  {
    return new ms(paramArrayOfmq, paramArrayOfString, null);
  }
  
  static void a(mq[] paramArrayOfmq1, int paramInt1, mq[] paramArrayOfmq2, int paramInt2, Map<ne, ne> paramMap, Map<ne, List<mx>> paramMap1)
  {
    int i1 = paramInt2;
    paramInt2 = paramInt1;
    if (paramInt2 < paramArrayOfmq1.length)
    {
      Object localObject = paramArrayOfmq1[paramInt2].a(paramMap, paramMap1);
      mq[] arrayOfmq;
      if ((localObject instanceof ne))
      {
        arrayOfmq = ((mq)localObject).b;
        localObject = (List)paramMap1.get(localObject);
        if (localObject == null) {
          System.arraycopy(arrayOfmq, 0, paramArrayOfmq2, i1, arrayOfmq.length);
        }
      }
      label69:
      for (paramInt1 = i1 + arrayOfmq.length;; paramInt1 = i1 + 1)
      {
        paramInt2 += 1;
        i1 = paramInt1;
        break;
        ((List)localObject).add(new mx(paramArrayOfmq2, i1));
        break label69;
        paramArrayOfmq2[i1] = localObject;
      }
    }
  }
  
  static mq b(mq... paramVarArgs)
  {
    return new ne(paramVarArgs, null);
  }
  
  public int a()
  {
    return 1;
  }
  
  public mq a(Map<ne, ne> paramMap, Map<ne, List<mx>> paramMap1)
  {
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/mq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */