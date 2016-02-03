package com.mapbar.android.maps;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class m
{
  private static String a = "[a-zA-Z]+";
  private static String b = "[0-9_]+";
  private static Paint c;
  
  static
  {
    Paint localPaint = new Paint();
    c = localPaint;
    localPaint.setColor(-65536);
  }
  
  public static k a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length() == 0) || (paramArrayOfByte.trim().length() == 0)) {
        return new k("", "", null);
      }
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
      }
      paramArrayOfByte = paramArrayOfByte.split("=", 2);
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length != 2)) {
        return new k("", "", null);
      }
    }
    return new k(paramArrayOfByte[0].replaceAll(b, ""), paramArrayOfByte[0].replaceAll(a, ""), b(paramArrayOfByte[1]));
  }
  
  private static l a(JSONObject paramJSONObject)
  {
    try
    {
      String str1 = paramJSONObject.getString("p");
      String str2 = paramJSONObject.getString("n");
      JSONObject localJSONObject4 = paramJSONObject.getJSONObject("r");
      JSONObject localJSONObject1 = localJSONObject4.getJSONObject("i");
      JSONObject localJSONObject2 = localJSONObject4.getJSONObject("a");
      JSONObject localJSONObject3 = localJSONObject4.getJSONObject("ai");
      localJSONObject4 = localJSONObject4.getJSONObject("aa");
      int i = localJSONObject1.getInt("x");
      int j = localJSONObject1.getInt("y");
      int k = localJSONObject2.getInt("x");
      int m = localJSONObject2.getInt("y");
      int n = localJSONObject3.getInt("x");
      int i1 = localJSONObject3.getInt("y");
      int i2 = localJSONObject4.getInt("x");
      int i3 = localJSONObject4.getInt("y");
      paramJSONObject = paramJSONObject.getString("l").split(",");
      double d = Double.parseDouble(paramJSONObject[0]);
      paramJSONObject = new l(new GeoPoint((int)(Double.parseDouble(paramJSONObject[1]) * 1000000.0D), (int)(d * 1000000.0D)), str1, str2, str2);
      localJSONException1.printStackTrace();
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        paramJSONObject.b().x = i;
        paramJSONObject.b().y = j;
        paramJSONObject.c().x = k;
        paramJSONObject.c().y = m;
        paramJSONObject.d().x = n;
        paramJSONObject.d().y = i1;
        paramJSONObject.e().x = i2;
        paramJSONObject.e().y = i3;
        return paramJSONObject;
      }
      catch (JSONException localJSONException2)
      {
        for (;;) {}
      }
      localJSONException1 = localJSONException1;
      paramJSONObject = null;
    }
    return paramJSONObject;
  }
  
  public static boolean a(k paramk, Canvas paramCanvas, Drawable paramDrawable)
  {
    if (paramk == null) {
      return false;
    }
    int i = paramk.a() - 1;
    while (i >= 0)
    {
      paramCanvas.save();
      PointF localPointF = paramk.a(i).a();
      paramCanvas.translate(localPointF.x, localPointF.y);
      if (paramDrawable != null) {
        paramDrawable.draw(paramCanvas);
      }
      paramCanvas.restore();
      i -= 1;
    }
    return true;
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: new 193	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 196	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: aload 5
    //   12: astore 4
    //   14: aload 5
    //   16: invokevirtual 201	java/io/InputStream:available	()I
    //   19: istore_2
    //   20: aload 5
    //   22: astore 4
    //   24: iload_2
    //   25: newarray <illegal type>
    //   27: astore_0
    //   28: iconst_0
    //   29: istore_1
    //   30: iload_1
    //   31: iload_2
    //   32: if_icmpeq +30 -> 62
    //   35: aload 5
    //   37: astore 4
    //   39: aload 5
    //   41: aload_0
    //   42: iload_1
    //   43: iload_2
    //   44: iload_1
    //   45: isub
    //   46: invokevirtual 205	java/io/InputStream:read	([BII)I
    //   49: istore_3
    //   50: iload_3
    //   51: iconst_m1
    //   52: if_icmpeq +10 -> 62
    //   55: iload_1
    //   56: iload_3
    //   57: iadd
    //   58: istore_1
    //   59: goto -29 -> 30
    //   62: aload 5
    //   64: invokevirtual 208	java/io/InputStream:close	()V
    //   67: aload_0
    //   68: astore 4
    //   70: aload 4
    //   72: areturn
    //   73: astore 6
    //   75: aconst_null
    //   76: astore 5
    //   78: aconst_null
    //   79: astore_0
    //   80: aload 5
    //   82: astore 4
    //   84: aload 6
    //   86: invokevirtual 209	java/lang/Exception:printStackTrace	()V
    //   89: aload_0
    //   90: astore 4
    //   92: aload 5
    //   94: ifnull -24 -> 70
    //   97: aload 5
    //   99: invokevirtual 208	java/io/InputStream:close	()V
    //   102: aload_0
    //   103: areturn
    //   104: astore 4
    //   106: aload_0
    //   107: areturn
    //   108: astore_0
    //   109: aconst_null
    //   110: astore 4
    //   112: aload 4
    //   114: ifnull +8 -> 122
    //   117: aload 4
    //   119: invokevirtual 208	java/io/InputStream:close	()V
    //   122: aload_0
    //   123: athrow
    //   124: astore 4
    //   126: aload_0
    //   127: areturn
    //   128: astore 4
    //   130: goto -8 -> 122
    //   133: astore_0
    //   134: goto -22 -> 112
    //   137: astore 6
    //   139: aconst_null
    //   140: astore_0
    //   141: goto -61 -> 80
    //   144: astore 6
    //   146: goto -66 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramString	String
    //   29	30	1	i	int
    //   19	27	2	j	int
    //   49	9	3	k	int
    //   12	79	4	localObject1	Object
    //   104	1	4	localIOException1	java.io.IOException
    //   110	8	4	localObject2	Object
    //   124	1	4	localIOException2	java.io.IOException
    //   128	1	4	localIOException3	java.io.IOException
    //   8	90	5	localFileInputStream	java.io.FileInputStream
    //   73	12	6	localException1	Exception
    //   137	1	6	localException2	Exception
    //   144	1	6	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   0	10	73	java/lang/Exception
    //   97	102	104	java/io/IOException
    //   0	10	108	finally
    //   62	67	124	java/io/IOException
    //   117	122	128	java/io/IOException
    //   14	20	133	finally
    //   24	28	133	finally
    //   39	50	133	finally
    //   84	89	133	finally
    //   14	20	137	java/lang/Exception
    //   24	28	137	java/lang/Exception
    //   39	50	144	java/lang/Exception
  }
  
  private static List<l> b(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    try
    {
      paramString = new JSONArray(paramString);
      if ((paramString == null) || (paramString.length() == 0)) {
        return localLinkedList;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
      int i = paramString.length() - 1;
      for (;;)
      {
        if (i >= 0) {
          try
          {
            l locall = a((JSONObject)paramString.get(i));
            if (locall != null) {
              localLinkedList.add(locall);
            }
            i -= 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
              Object localObject = null;
            }
          }
        }
      }
    }
    return localLinkedList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */