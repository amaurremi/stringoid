package com.admob.android.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.admob.android.ads.view.AdMobWebView;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  implements h
{
  private static final int c = Color.rgb(102, 102, 102);
  private static final Rect d = new Rect(0, 0, 0, 0);
  private static final PointF e;
  private static final PointF f;
  private static final PointF g = new PointF(0.5F, 0.5F);
  private static final Matrix h = new Matrix();
  private static final RectF i = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
  private Hashtable<String, byte[]> A = new Hashtable();
  private HashSet<r> B = new HashSet();
  private Vector<Bitmap> C = new Vector();
  private b D = null;
  private double E = -1.0D;
  private double F = -1.0D;
  private Vector<WeakReference<View>> G = null;
  protected View a;
  protected g b;
  private String j = null;
  private String k = null;
  private boolean l;
  private boolean m;
  private Vector<Intent> n = new Vector();
  private Vector<String> o = new Vector();
  private Vector<e> p = new Vector();
  private f q;
  private Rect r = null;
  private long s = 0L;
  private int t = -1;
  private int u = -1;
  private a v = null;
  private int w = -1;
  private int x = -1;
  private int y = -16777216;
  private JSONObject z;
  
  static
  {
    PointF localPointF = new PointF(0.0F, 0.0F);
    e = localPointF;
    f = localPointF;
  }
  
  private static float a(JSONObject paramJSONObject, String paramString, float paramFloat)
  {
    return (float)paramJSONObject.optDouble(paramString, paramFloat);
  }
  
  private static int a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString))) {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray(paramString);
        int i1 = (int)(paramJSONObject.getDouble(0) * 255.0D);
        int i2 = (int)(paramJSONObject.getDouble(1) * 255.0D);
        int i3 = (int)(paramJSONObject.getDouble(2) * 255.0D);
        i1 = Color.argb((int)(paramJSONObject.getDouble(3) * 255.0D), i1, i2, i3);
        return i1;
      }
      catch (Exception paramJSONObject)
      {
        return paramInt;
      }
    }
    return paramInt;
  }
  
  private static Matrix a(JSONArray paramJSONArray)
  {
    Object localObject = null;
    float[] arrayOfFloat = b(paramJSONArray);
    paramJSONArray = (JSONArray)localObject;
    if (arrayOfFloat != null)
    {
      paramJSONArray = (JSONArray)localObject;
      if (arrayOfFloat.length == 9)
      {
        paramJSONArray = new Matrix();
        paramJSONArray.setValues(arrayOfFloat);
      }
    }
    return paramJSONArray;
  }
  
  private static Matrix a(JSONObject paramJSONObject, String paramString, Matrix paramMatrix)
  {
    paramJSONObject = b(paramJSONObject, paramString);
    if ((paramJSONObject != null) && (paramJSONObject.length == 9))
    {
      paramString = new Matrix();
      paramString.setValues(paramJSONObject);
      return paramString;
    }
    return paramMatrix;
  }
  
  private static PointF a(RectF paramRectF, PointF paramPointF)
  {
    float f1 = paramRectF.width();
    float f2 = paramRectF.height();
    float f3 = paramRectF.left;
    float f4 = paramPointF.x;
    float f5 = paramRectF.top;
    return new PointF(f1 * f4 + f3, f2 * paramPointF.y + f5);
  }
  
  private static PointF a(JSONObject paramJSONObject, String paramString, PointF paramPointF)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString))) {
      try
      {
        paramJSONObject = e(paramJSONObject.getJSONArray(paramString));
        return paramJSONObject;
      }
      catch (JSONException paramJSONObject)
      {
        return paramPointF;
      }
    }
    return paramPointF;
  }
  
  private static Rect a(JSONObject paramJSONObject, String paramString, Rect paramRect)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString))) {
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray(paramString);
        int i1 = (int)paramJSONObject.getDouble(0);
        int i2 = (int)paramJSONObject.getDouble(1);
        paramJSONObject = new Rect(i1, i2, (int)paramJSONObject.getDouble(2) + i1, (int)paramJSONObject.getDouble(3) + i2);
        return paramJSONObject;
      }
      catch (JSONException paramJSONObject)
      {
        return paramRect;
      }
    }
    return paramRect;
  }
  
  private static RectF a(JSONObject paramJSONObject, String paramString, RectF paramRectF)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString))) {
      try
      {
        paramJSONObject = d(paramJSONObject.getJSONArray(paramString));
        return paramJSONObject;
      }
      catch (JSONException paramJSONObject)
      {
        return paramRectF;
      }
    }
    return paramRectF;
  }
  
  private View a(JSONObject paramJSONObject, Rect paramRect)
    throws JSONException
  {
    if (this.b != null)
    {
      float f1 = a(paramJSONObject, "ia", 0.5F);
      float f2 = a(paramJSONObject, "epy", 0.4375F);
      int i1 = a(paramJSONObject, "bc", this.y);
      try
      {
        paramJSONObject = Bitmap.createBitmap(paramRect.width(), paramRect.height(), Bitmap.Config.ARGB_8888);
        this.C.add(paramJSONObject);
        Canvas localCanvas = new Canvas(paramJSONObject);
        int i3 = (int)(f1 * 255.0F);
        int i2 = (int)(f2 * paramRect.height()) + paramRect.top;
        Object localObject1 = new Rect(paramRect.left, paramRect.top, paramRect.right, i2);
        Object localObject2 = new Paint();
        ((Paint)localObject2).setColor(-1);
        ((Paint)localObject2).setStyle(Paint.Style.FILL);
        localCanvas.drawRect((Rect)localObject1, (Paint)localObject2);
        i3 = Color.argb(i3, Color.red(i1), Color.green(i1), Color.blue(i1));
        localObject2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i3, i1 });
        ((GradientDrawable)localObject2).setBounds((Rect)localObject1);
        ((GradientDrawable)localObject2).draw(localCanvas);
        paramRect = new Rect(paramRect.left, i2, paramRect.right, paramRect.bottom);
        localObject1 = new Paint();
        ((Paint)localObject1).setColor(i1);
        ((Paint)localObject1).setStyle(Paint.Style.FILL);
        localCanvas.drawRect(paramRect, (Paint)localObject1);
        paramRect = new View(this.b.getContext());
        paramRect.setBackgroundDrawable(new BitmapDrawable(paramJSONObject));
        return paramRect;
      }
      catch (Throwable paramJSONObject)
      {
        return null;
      }
    }
    return null;
  }
  
  private static Animation a(int paramInt, String paramString1, String paramString2, float[] paramArrayOfFloat, JSONArray paramJSONArray1, String[] paramArrayOfString, long paramLong, View paramView, Rect paramRect, JSONObject paramJSONObject, JSONArray paramJSONArray2)
  {
    int i1 = paramInt + 1;
    float f1 = paramArrayOfFloat[paramInt];
    float f2 = paramArrayOfFloat[i1];
    if ((paramString1 == null) || (paramString2 == null))
    {
      if (!Log.isLoggable("AdMobSDK", 6)) {
        break label504;
      }
      Log.e("AdMobSDK", "Could not read keyframe animation: keyPath(" + paramString1 + ") or valueType(" + paramString2 + ") is null.");
    }
    label504:
    for (paramString1 = null;; paramString1 = null) {
      for (;;)
      {
        if (paramString1 != null)
        {
          i1 = (int)((float)paramLong * f1);
          long l1 = (int)((f2 - f1) * (float)paramLong);
          paramString1.setDuration(paramLong);
          paramString2 = a(paramArrayOfString[paramInt], i1, l1, paramLong);
          if (paramString2 != null) {
            paramString1.setInterpolator(paramString2);
          }
        }
        return paramString1;
        try
        {
          if (("position".equals(paramString1)) && ("P".equals(paramString2)))
          {
            paramString1 = a(e(paramJSONArray1.getJSONArray(paramInt)), e(paramJSONArray1.getJSONArray(i1)), paramView, paramRect);
          }
          else if (("opacity".equals(paramString1)) && ("F".equals(paramString2)))
          {
            paramString1 = a((float)paramJSONArray1.getDouble(paramInt), (float)paramJSONArray1.getDouble(i1));
          }
          else if (("bounds".equals(paramString1)) && ("R".equals(paramString2)))
          {
            paramString1 = a(d(paramJSONArray1.getJSONArray(paramInt)), d(paramJSONArray1.getJSONArray(i1)), paramView, paramRect);
          }
          else if (("zPosition".equals(paramString1)) && ("F".equals(paramString2)))
          {
            paramString1 = a((float)paramJSONArray1.getDouble(paramInt), (float)paramJSONArray1.getDouble(i1), paramView);
          }
          else if (("backgroundColor".equals(paramString1)) && ("C".equals(paramString2)))
          {
            paramString1 = a(c(paramJSONArray1.getJSONArray(paramInt)), c(paramJSONArray1.getJSONArray(i1)), paramView);
          }
          else
          {
            if (("transform".equals(paramString1)) && ("AT".equals(paramString2)))
            {
              if (paramJSONArray2 != null)
              {
                a(paramJSONArray1.getJSONArray(paramInt));
                a(paramJSONArray1.getJSONArray(i1));
                paramString1 = a(paramView, paramRect, paramJSONObject, paramJSONArray2.getJSONArray(paramInt), paramJSONArray2.getJSONArray(i1));
              }
            }
            else if (Log.isLoggable("AdMobSDK", 6)) {
              Log.e("AdMobSDK", "Could not read keyframe animation: could not interpret keyPath(" + paramString1 + ") and valueType(" + paramString2 + ") combination.");
            }
            paramString1 = null;
          }
        }
        catch (JSONException paramString1) {}
      }
    }
  }
  
  private static Animation a(View paramView, Rect paramRect, JSONObject paramJSONObject, JSONArray paramJSONArray1, JSONArray paramJSONArray2)
    throws JSONException
  {
    paramJSONObject = paramJSONObject.optString("tt", null);
    if (paramJSONObject != null)
    {
      if ("t".equals(paramJSONObject)) {
        return a(e(paramJSONArray1), e(paramJSONArray2), paramView, paramRect);
      }
      if ("r".equals(paramJSONObject))
      {
        paramJSONObject = b(paramJSONArray1);
        paramJSONArray1 = b(paramJSONArray2);
        if ((paramJSONObject == null) || (paramJSONArray1 == null) || (Arrays.equals(paramJSONObject, paramJSONArray1))) {
          break label245;
        }
        paramView = f.b(paramView);
        paramView = a(new RectF(paramRect), paramView);
        return new j(paramJSONObject, paramJSONArray1, paramView.x, paramView.y, 0.0F, false);
      }
      if ("sc".equals(paramJSONObject))
      {
        paramRect = b(paramJSONArray1);
        paramJSONObject = b(paramJSONArray2);
        paramView = f.b(paramView);
        return new ScaleAnimation(paramRect[0], paramJSONObject[0], paramRect[1], paramJSONObject[1], 1, paramView.x, 1, paramView.y);
      }
      if ("sk".equals(paramJSONObject))
      {
        paramJSONObject = b(paramJSONArray1);
        paramJSONArray1 = b(paramJSONArray2);
        if ((paramJSONObject != null) && (paramJSONArray1 != null) && (!Arrays.equals(paramJSONObject, paramJSONArray1)))
        {
          paramView = f.b(paramView);
          return new p(paramJSONObject, paramJSONArray1, a(new RectF(paramRect), paramView));
        }
      }
      else
      {
        "p".equals(paramJSONObject);
      }
    }
    else
    {
      return null;
    }
    return null;
    label245:
    return null;
  }
  
  private AnimationSet a(JSONArray paramJSONArray, JSONObject paramJSONObject, View paramView, Rect paramRect)
    throws JSONException
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    int i1 = 0;
    if (i1 < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i1);
      Object localObject1 = null;
      Object localObject2 = localJSONObject.optString("t", null);
      int i2 = (int)(a(localJSONObject, "d", 0.25F) * 1000.0D);
      if ("B".equals(localObject2))
      {
        localObject1 = localJSONObject.optString("kp", null);
        localObject2 = localJSONObject.optString("vt", null);
        if ((localObject1 == null) || (localObject2 == null))
        {
          if (!Log.isLoggable("AdMobSDK", 6)) {
            break label649;
          }
          Log.e("AdMobSDK", "Could not read basic animation: keyPath(" + (String)localObject1 + ") or valueType(" + (String)localObject2 + ") is null.");
          localObject1 = null;
          label165:
          if (localObject1 != null)
          {
            Interpolator localInterpolator = a(localJSONObject.optString("tf", null), -1L, -1L, -1L);
            localObject2 = localInterpolator;
            if (localInterpolator == null) {
              localObject2 = null;
            }
            if (localObject2 != null) {
              ((Animation)localObject1).setInterpolator((Interpolator)localObject2);
            }
          }
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          ((Animation)localObject1).setDuration(i2);
          a(localJSONObject, (Animation)localObject1, localAnimationSet);
          localAnimationSet.addAnimation((Animation)localObject1);
          ((Animation)localObject1).getDuration();
        }
        i1 += 1;
        break;
        if (("position".equals(localObject1)) && ("P".equals(localObject2)))
        {
          localObject1 = a(a(localJSONObject, "fv", e), a(localJSONObject, "tv", f), paramView, paramRect);
          break label165;
        }
        if (("opacity".equals(localObject1)) && ("F".equals(localObject2)))
        {
          localObject1 = a(a(localJSONObject, "fv", 0.0F), a(localJSONObject, "tv", 0.0F));
          break label165;
        }
        if (("transform".equals(localObject1)) && ("AT".equals(localObject2)))
        {
          a(localJSONObject, "fv", h);
          a(localJSONObject, "fv", h);
          localObject1 = a(paramView, paramRect, localJSONObject, localJSONObject.getJSONArray("tfv"), localJSONObject.getJSONArray("ttv"));
          break label165;
        }
        if (("bounds".equals(localObject1)) && ("R".equals(localObject2)))
        {
          localObject1 = a(a(localJSONObject, "fv", i), a(localJSONObject, "tv", i), null, paramRect);
          break label165;
        }
        if (("zPosition".equals(localObject1)) && ("F".equals(localObject2)))
        {
          localObject1 = a(a(localJSONObject, "fv", 0.0F), a(localJSONObject, "tv", 0.0F), paramView);
          break label165;
        }
        if (("backgroundColor".equals(localObject1)) && ("C".equals(localObject2)))
        {
          localObject1 = a(a(localJSONObject, "fv", 0), a(localJSONObject, "tv", 0), paramView);
          break label165;
        }
        if (Log.isLoggable("AdMobSDK", 6)) {
          Log.e("AdMobSDK", "Could not read basic animation: could not interpret keyPath(" + (String)localObject1 + ") and valueType(" + (String)localObject2 + ") combination.");
        }
        label649:
        localObject1 = null;
        break label165;
        if ("K".equals(localObject2)) {
          localObject1 = a(localJSONObject, paramView, paramRect, i2);
        }
      }
    }
    if (paramJSONObject != null) {
      a(paramJSONObject, localAnimationSet, null);
    }
    return localAnimationSet;
  }
  
  private AnimationSet a(JSONObject paramJSONObject, View paramView, Rect paramRect, long paramLong)
    throws JSONException
  {
    String str1 = paramJSONObject.getString("vt");
    float[] arrayOfFloat = b(paramJSONObject, "kt");
    JSONArray localJSONArray1 = paramJSONObject.getJSONArray("vs");
    String[] arrayOfString = a(paramJSONObject, "tfs");
    JSONArray localJSONArray2 = paramJSONObject.optJSONArray("ttvs");
    int i2 = arrayOfFloat.length;
    int i1 = localJSONArray1.length();
    int i3 = arrayOfString.length;
    if (((i2 != i1) || (i1 != i3 + 1)) && (arrayOfFloat[0] == 0.0D) && (arrayOfFloat[(i2 - 1)] == 1.0D))
    {
      if (Log.isLoggable("AdMobSDK", 6)) {
        Log.e("AdMobSDK", "keyframe animations were invalid: numKeyTimes=" + i2 + " numKeyValues=" + i1 + " numKeyFunctions=" + i3 + " keyTimes[0]=" + arrayOfFloat[0] + " keyTimes[" + (i2 - 1) + "]=" + arrayOfFloat[(i2 - 1)]);
      }
      return null;
    }
    AnimationSet localAnimationSet = new AnimationSet(false);
    String str2 = paramJSONObject.getString("kp");
    i3 = e(paramJSONObject);
    i1 = 0;
    while (i1 < i2 - 1)
    {
      Animation localAnimation = a(i1, str2, str1, arrayOfFloat, localJSONArray1, arrayOfString, paramLong, paramView, paramRect, paramJSONObject, localJSONArray2);
      if (localAnimation != null)
      {
        localAnimation.setRepeatCount(i3);
        localAnimationSet.addAnimation(localAnimation);
      }
      i1 += 1;
    }
    a(paramJSONObject.optString("fm", "r"), localAnimationSet);
    return localAnimationSet;
  }
  
  private static Interpolator a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    if ("i".equals(paramString)) {
      paramString = new AccelerateInterpolator();
    }
    for (;;)
    {
      if ((paramString != null) && (paramLong1 != -1L) && (paramLong2 != -1L) && (paramLong3 != -1L))
      {
        return new c(paramString, paramLong1, paramLong2, paramLong3);
        if ("o".equals(paramString))
        {
          paramString = new DecelerateInterpolator();
          continue;
        }
        if ("io".equals(paramString))
        {
          paramString = new AccelerateDecelerateInterpolator();
          continue;
        }
        if ("l".equals(paramString)) {
          paramString = new LinearInterpolator();
        }
      }
      else
      {
        return paramString;
      }
      paramString = null;
    }
  }
  
  private static b a(float paramFloat1, float paramFloat2, View paramView)
  {
    b localb = null;
    if (paramFloat1 != paramFloat2) {
      localb = new b(paramFloat1, paramFloat2, paramView);
    }
    return localb;
  }
  
  public static d a(a parama, JSONObject paramJSONObject, int paramInt1, int paramInt2, int paramInt3, g paramg)
  {
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {
      parama = null;
    }
    d locald;
    do
    {
      return parama;
      locald = new d();
      locald.v = parama;
      locald.w = paramInt1;
      locald.x = paramInt2;
      locald.y = paramInt3;
      locald.b = paramg;
      parama = locald;
    } while (locald.c(paramJSONObject));
    return null;
  }
  
  private static k a(int paramInt1, int paramInt2, View paramView)
  {
    k localk = null;
    if (paramInt1 != paramInt2) {
      localk = new k(paramInt1, paramInt2, paramView);
    }
    return localk;
  }
  
  private static l a(PointF paramPointF1, PointF paramPointF2, View paramView, Rect paramRect)
  {
    l locall = null;
    if (!paramPointF1.equals(paramPointF2))
    {
      paramView = f.b(paramView);
      float f1 = paramRect.width() * paramView.x + paramRect.left;
      float f2 = paramRect.height();
      f2 = paramView.y * f2 + paramRect.top;
      paramPointF1.x -= f1;
      paramPointF1.y -= f2;
      paramPointF2.x -= f1;
      paramPointF2.y -= f2;
      locall = new l(0, paramPointF1.x, 0, paramPointF2.x, 0, paramPointF1.y, 0, paramPointF2.y);
    }
    return locall;
  }
  
  private static m a(float paramFloat1, float paramFloat2)
  {
    m localm = null;
    if (paramFloat1 != paramFloat2) {
      localm = new m(paramFloat1, paramFloat2);
    }
    return localm;
  }
  
  private static n a(RectF paramRectF1, RectF paramRectF2, View paramView, Rect paramRect)
  {
    n localn = null;
    if (!paramRectF1.equals(paramRectF2))
    {
      paramView = a(paramRectF1, f.b(paramView));
      float f1 = paramRect.width();
      float f2 = paramRect.height();
      float f3 = paramRectF1.width() / f1;
      float f4 = paramRectF1.height() / f2;
      localn = new n(f3, paramRectF2.width() / f1, f4, paramRectF2.height() / f2, paramView.x, paramView.y);
    }
    return localn;
  }
  
  private static void a(Bundle paramBundle, String paramString, JSONArray paramJSONArray)
  {
    if ((paramString != null) && (paramJSONArray != null))
    {
      Object localObject = new Vector();
      int i2 = paramJSONArray.length();
      int i1 = 0;
      while (i1 < i2) {
        try
        {
          ((Vector)localObject).add(paramJSONArray.get(i1));
          i1 += 1;
        }
        catch (JSONException paramJSONArray)
        {
          if (Log.isLoggable("AdMobSDK", 6)) {
            Log.e("AdMobSDK", "couldn't read bundle array while adding extras");
          }
        }
      }
      if (i2 != 0) {
        try
        {
          paramJSONArray = ((Vector)localObject).get(0);
          if ((paramJSONArray instanceof String))
          {
            paramBundle.putStringArray(paramString, (String[])((Vector)localObject).toArray(new String[0]));
            return;
          }
          if ((paramJSONArray instanceof Integer))
          {
            paramJSONArray = (Integer[])((Vector)localObject).toArray(new Integer[0]);
            localObject = new int[paramJSONArray.length];
            i1 = 0;
            while (i1 < paramJSONArray.length)
            {
              localObject[i1] = paramJSONArray[i1].intValue();
              i1 += 1;
            }
            paramBundle.putIntArray(paramString, (int[])localObject);
            return;
          }
        }
        catch (ArrayStoreException paramBundle)
        {
          if (Log.isLoggable("AdMobSDK", 6))
          {
            Log.e("AdMobSDK", "Couldn't read in array when making extras");
            return;
            if ((paramJSONArray instanceof Boolean))
            {
              paramJSONArray = (Boolean[])((Vector)localObject).toArray(new Boolean[0]);
              localObject = new boolean[paramJSONArray.length];
              i1 = 0;
              while (i1 < localObject.length)
              {
                localObject[i1] = paramJSONArray[i1].booleanValue();
                i1 += 1;
              }
              paramBundle.putBooleanArray(paramString, (boolean[])localObject);
              return;
            }
            if ((paramJSONArray instanceof Double))
            {
              paramJSONArray = (Double[])((Vector)localObject).toArray(new Double[0]);
              localObject = new double[paramJSONArray.length];
              i1 = 0;
              while (i1 < localObject.length)
              {
                localObject[i1] = paramJSONArray[i1].doubleValue();
                i1 += 1;
              }
              paramBundle.putDoubleArray(paramString, (double[])localObject);
              return;
            }
            if ((paramJSONArray instanceof Long))
            {
              paramJSONArray = (Long[])((Vector)localObject).toArray(new Long[0]);
              localObject = new long[paramJSONArray.length];
              i1 = 0;
              while (i1 < localObject.length)
              {
                localObject[i1] = paramJSONArray[i1].longValue();
                i1 += 1;
              }
              paramBundle.putLongArray(paramString, (long[])localObject);
            }
          }
        }
      }
    }
  }
  
  private static void a(Animation paramAnimation, int paramInt1, int paramInt2, float paramFloat, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramAnimation.setRepeatMode(2);
    }
    paramAnimation.setRepeatCount(paramInt1);
    paramAnimation.setStartOffset(paramInt2);
    paramAnimation.startNow();
    paramAnimation.scaleCurrentDuration(paramFloat);
    a(paramString, paramAnimation);
  }
  
  private void a(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString))) {
      this.o.add(paramString);
    }
  }
  
  private static void a(String paramString, Animation paramAnimation)
  {
    Object localObject;
    if ((paramString != null) && (paramAnimation != null)) {
      localObject = paramAnimation.getClass();
    }
    try
    {
      localObject = ((Class)localObject).getMethod("setFillEnabled", new Class[] { Boolean.TYPE });
      if (localObject != null) {
        ((Method)localObject).invoke(paramAnimation, new Object[] { Boolean.valueOf(true) });
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if ("b".equals(paramString))
    {
      paramAnimation.setFillBefore(true);
      paramAnimation.setFillAfter(false);
    }
    do
    {
      return;
      if (("fb".equals(paramString)) || ("r".equals(paramString)))
      {
        paramAnimation.setFillBefore(true);
        paramAnimation.setFillAfter(true);
        return;
      }
      if ("f".equals(paramString))
      {
        paramAnimation.setFillBefore(false);
        paramAnimation.setFillAfter(true);
        return;
      }
    } while (!"r".equals(paramString));
    paramAnimation.setFillBefore(false);
    paramAnimation.setFillAfter(false);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if ((paramString != null) && (!"".equals(paramString))) {
      this.p.add(new e(paramString, paramBoolean));
    }
  }
  
  private void a(JSONObject paramJSONObject, Animation paramAnimation, AnimationSet paramAnimationSet)
  {
    float f1 = a(paramJSONObject, "bt", 0.0F);
    float f2 = a(paramJSONObject, "to", 0.0F);
    int i1 = e(paramJSONObject);
    boolean bool = paramJSONObject.optBoolean("ar", false);
    String str = paramJSONObject.optString("fm", "r");
    float f3 = a(paramJSONObject, "s", 1.0F);
    int i2 = (int)((f1 + 0.0F + f2) * 1000.0D);
    f1 = 1.0F / f3;
    a(paramAnimation, i1, i2, f1, str, bool);
    if (paramAnimationSet != null) {
      a(paramAnimationSet, i1, i2, f1, str, bool);
    }
  }
  
  private boolean a(JSONObject paramJSONObject, d paramd)
    throws JSONException
  {
    for (;;)
    {
      int i2;
      try
      {
        Object localObject2 = paramJSONObject.getString("t");
        Object localObject3 = a(a(paramJSONObject, "f", d));
        localObject1 = null;
        if ("l".equals(localObject2))
        {
          if (this.b == null) {
            break label838;
          }
          Object localObject4 = paramJSONObject.getString("x");
          float f1 = a(paramJSONObject, "fs", 13.0F);
          localObject2 = paramJSONObject.optJSONArray("fa");
          localObject1 = Typeface.DEFAULT;
          if (localObject2 == null) {
            break label814;
          }
          i3 = 0;
          i2 = 0;
          Object localObject5;
          if (i2 < ((JSONArray)localObject2).length())
          {
            localObject5 = ((JSONArray)localObject2).getString(i2);
            if ("b".equals(localObject5))
            {
              i1 = i3 | 0x1;
              break label817;
            }
            if ("i".equals(localObject5))
            {
              i1 = i3 | 0x2;
              break label817;
            }
            if ("m".equals(localObject5))
            {
              localObject1 = Typeface.MONOSPACE;
              i1 = i3;
              break label817;
            }
            if ("s".equals(localObject5))
            {
              localObject1 = Typeface.SERIF;
              i1 = i3;
              break label817;
            }
            i1 = i3;
            if (!"ss".equals(localObject5)) {
              break label817;
            }
            localObject1 = Typeface.SANS_SERIF;
            i1 = i3;
            break label817;
          }
          localObject1 = Typeface.create((Typeface)localObject1, i3);
          i2 = this.w;
          if (paramJSONObject.has("fco"))
          {
            i3 = a(paramJSONObject, "fco", i2);
            i1 = i2;
            if (i3 != i2) {
              i1 = i3;
            }
            boolean bool = paramJSONObject.optBoolean("afstfw", true);
            float f2 = a(paramJSONObject, "mfs", 8.0F);
            i2 = paramJSONObject.optInt("nol", 1);
            localObject2 = new q(this.b.getContext(), g.c());
            ((q)localObject2).b = bool;
            ((q)localObject2).a = (((q)localObject2).c * f2);
            ((q)localObject2).setBackgroundColor(0);
            ((q)localObject2).setText((CharSequence)localObject4);
            ((q)localObject2).setTextColor(i1);
            ((q)localObject2).setTextSize(1, f1);
            ((q)localObject2).setTypeface((Typeface)localObject1);
            ((q)localObject2).setLines(i2);
            localObject1 = localObject2;
            break label830;
            if (localObject1 == null) {
              break label785;
            }
            if (i1 != 0) {
              ((View)localObject1).setBackgroundColor(a(paramJSONObject, "bgc", 0));
            }
            localObject2 = a(paramJSONObject, "ap", g);
            localObject4 = f.c((View)localObject1);
            ((f)localObject4).b = ((PointF)localObject2);
            ((View)localObject1).setTag(localObject4);
            localObject2 = null;
            localObject4 = paramJSONObject.optJSONArray("a");
            localObject5 = paramJSONObject.optJSONObject("ag");
            if (localObject4 != null) {
              localObject2 = a((JSONArray)localObject4, (JSONObject)localObject5, (View)localObject1, (Rect)localObject3);
            }
            localObject4 = paramJSONObject.optString("ut", null);
            if ((localObject1 != null) && (localObject4 != null)) {
              ((View)localObject1).setTag(f.c((View)localObject1));
            }
            localObject4 = new RelativeLayout.LayoutParams(((Rect)localObject3).width(), ((Rect)localObject3).height());
            ((RelativeLayout.LayoutParams)localObject4).addRule(9);
            ((RelativeLayout.LayoutParams)localObject4).addRule(10);
            ((RelativeLayout.LayoutParams)localObject4).setMargins(((Rect)localObject3).left, ((Rect)localObject3).top, 0, 0);
            localObject3 = new g();
            ((g)localObject3).a = ((View)localObject1);
            ((g)localObject3).b = ((RelativeLayout.LayoutParams)localObject4);
            ((g)localObject3).c = ((AnimationSet)localObject2);
            paramd.a.add(localObject3);
            if ((!paramJSONObject.optBoolean("cav")) || (this.b == null)) {
              break label836;
            }
            this.b.a((View)localObject1, (RelativeLayout.LayoutParams)localObject4);
            break label836;
          }
          if (paramJSONObject.optInt("fc", 0) == 1)
          {
            i1 = this.x;
            continue;
          }
          i1 = this.w;
          continue;
        }
        if ("bg".equals(localObject2))
        {
          localObject1 = a(paramJSONObject, (Rect)localObject3);
          i1 = 0;
          continue;
        }
        if ("i".equals(localObject2)) {
          localObject1 = f(paramJSONObject);
        } else if ("P".equals(localObject2)) {
          if (this.b != null) {
            localObject1 = new View(this.b.getContext());
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (Log.isLoggable("AdMobSDK", 6)) {
          Log.e("AdMobSDK", "exception while trying to create a flex view.", paramJSONObject);
        }
        return false;
      }
      Object localObject1 = null;
      break label844;
      label785:
      if (Log.isLoggable("AdMobSDK", 6)) {
        Log.e("AdMobSDK", "created a null view.");
      }
      return false;
      int i1 = 1;
      continue;
      label814:
      continue;
      label817:
      i2 += 1;
      int i3 = i1;
      continue;
      for (;;)
      {
        label830:
        i1 = 1;
        break;
        label836:
        return true;
        label838:
        localObject1 = null;
      }
      label844:
      i1 = 1;
    }
  }
  
  private static String[] a(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if (paramJSONObject == null) {
      return null;
    }
    int i2 = paramJSONObject.length();
    try
    {
      paramString = new String[i2];
      int i1 = 0;
      while (i1 < i2)
      {
        paramString[i1] = paramJSONObject.getString(i1);
        i1 += 1;
      }
      return paramString;
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
  
  private void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      Object localObject = paramJSONObject.optString("a", null);
      String str = paramJSONObject.optString("d", null);
      int i1 = paramJSONObject.optInt("f", 268435456);
      paramJSONObject = d(paramJSONObject.optJSONObject("b"));
      Vector localVector = this.n;
      localObject = new Intent((String)localObject, Uri.parse(str));
      if (i1 != 0) {
        ((Intent)localObject).addFlags(i1);
      }
      if (paramJSONObject != null) {
        ((Intent)localObject).putExtras(paramJSONObject);
      }
      localVector.add(localObject);
    }
  }
  
  private static float[] b(JSONArray paramJSONArray)
  {
    int i2 = paramJSONArray.length();
    try
    {
      float[] arrayOfFloat = new float[i2];
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfFloat[i1] = ((float)paramJSONArray.getDouble(i1));
        i1 += 1;
      }
      return arrayOfFloat;
    }
    catch (JSONException paramJSONArray) {}
    return null;
  }
  
  private static float[] b(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if (paramJSONObject == null) {
      return null;
    }
    return b(paramJSONObject);
  }
  
  private static int c(JSONArray paramJSONArray)
    throws JSONException
  {
    int i1 = (int)(paramJSONArray.getDouble(0) * 255.0D);
    int i2 = (int)(paramJSONArray.getDouble(1) * 255.0D);
    int i3 = (int)(paramJSONArray.getDouble(2) * 255.0D);
    return Color.argb((int)(paramJSONArray.getDouble(3) * 255.0D), i1, i2, i3);
  }
  
  private boolean c(JSONObject paramJSONObject)
  {
    String str3 = paramJSONObject.optString("jsonp_url", null);
    Object localObject1 = paramJSONObject.optString("tracking_url", null);
    a(str3, true);
    a((String)localObject1, false);
    this.j = paramJSONObject.optString("text", null);
    Object localObject3 = paramJSONObject.optString("6", null);
    this.k = paramJSONObject.optString("8", null);
    localObject1 = f.d;
    if ("map".equals(localObject3)) {
      localObject1 = f.a;
    }
    String str2;
    for (;;)
    {
      this.q = ((f)localObject1);
      if ((localObject1 == f.g) && (!(this.b.getContext() instanceof Activity)))
      {
        if (this.v != null) {
          this.v.a();
        }
        return false;
        if ("video".equals(localObject3)) {
          localObject1 = f.b;
        } else if ("app".equals(localObject3)) {
          localObject1 = f.c;
        } else if ("url".equals(localObject3)) {
          localObject1 = f.d;
        } else if ("call".equals(localObject3)) {
          localObject1 = f.e;
        } else if ("itunes".equals(localObject3)) {
          localObject1 = f.f;
        } else if ("canvas".equals(localObject3)) {
          localObject1 = f.g;
        } else if ("contact".equals(localObject3)) {
          localObject1 = f.h;
        }
      }
      else
      {
        if (paramJSONObject.has("refreshInterval")) {
          this.E = paramJSONObject.optDouble("refreshInterval");
        }
        if (paramJSONObject.has("density")) {}
        for (this.F = paramJSONObject.optDouble("density");; this.F = g.c())
        {
          localObject3 = a(paramJSONObject, "d", null);
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = new PointF(320.0F, 48.0F);
          }
          if ((((PointF)localObject1).x >= 0.0F) && (((PointF)localObject1).y >= 0.0F)) {
            break;
          }
          return false;
        }
        int i1 = (int)((PointF)localObject1).x;
        int i2 = (int)((PointF)localObject1).y;
        this.t = i1;
        this.u = i2;
        localObject1 = paramJSONObject.optJSONObject("ac");
        if (localObject1 != null) {
          b((JSONObject)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray("ac");
        if (localObject1 != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 < ((JSONArray)localObject1).length()) {
              try
              {
                b(((JSONArray)localObject1).getJSONObject(i1));
                i1 += 1;
              }
              catch (JSONException localJSONException)
              {
                for (;;)
                {
                  if (Log.isLoggable("AdMobSDK", 6)) {
                    Log.e("AdMobSDK", "Could not form an intent from ad action response: " + ((JSONArray)localObject1).toString());
                  }
                }
              }
            }
          }
        }
        localObject1 = paramJSONObject.optString("cpm_url", null);
        if (localObject1 != null)
        {
          this.l = true;
          a((String)localObject1);
        }
        str2 = paramJSONObject.optString("tracking_pixel", null);
        localObject1 = str2;
        if (str2 != null) {}
        try
        {
          new URL(str2);
          localObject1 = str2;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            try
            {
              String str1 = URLEncoder.encode(str2, "UTF-8");
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              Object localObject2 = str2;
            }
            if (str3 == null)
            {
              if (Log.isLoggable("AdMobSDK", 6)) {
                Log.e("AdMobSDK", "Bad response:  didn't get clickURLString.  erroring out.");
              }
              return false;
            }
            this.z = paramJSONObject;
            try
            {
              n();
              m();
              double d1 = this.z.optDouble("itid");
              if (d1 > 0.0D) {
                this.s = ((d1 * 1000.0D));
              }
            }
            catch (JSONException paramJSONObject)
            {
              if (!Log.isLoggable("AdMobSDK", 6)) {
                continue;
              }
              Log.e("AdMobSDK", "Could not read in the flex ad.", paramJSONObject);
              continue;
            }
            l();
            if (k()) {
              o();
            }
            return true;
          }
        }
        if (localObject1 != null) {
          a((String)localObject1);
        }
        paramJSONObject = paramJSONObject.optJSONObject("markup");
        if (paramJSONObject == null) {
          return false;
        }
      }
    }
  }
  
  private static RectF d(JSONArray paramJSONArray)
    throws JSONException
  {
    float f1 = (float)paramJSONArray.getDouble(0);
    float f2 = (float)paramJSONArray.getDouble(1);
    return new RectF(f1, f2, (float)paramJSONArray.getDouble(2) + f1, (float)paramJSONArray.getDouble(3) + f2);
  }
  
  private static Bundle d(JSONObject paramJSONObject)
  {
    Bundle localBundle = null;
    Iterator localIterator;
    if (paramJSONObject != null)
    {
      localIterator = paramJSONObject.keys();
      if (!localIterator.hasNext()) {
        break label236;
      }
      localBundle = new Bundle();
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = paramJSONObject.opt(str);
        if ((str != null) && (localObject != null) && (str != null) && (localObject != null)) {
          if ((localObject instanceof String)) {
            localBundle.putString(str, (String)localObject);
          } else if ((localObject instanceof Integer)) {
            localBundle.putInt(str, ((Integer)localObject).intValue());
          } else if ((localObject instanceof Boolean)) {
            localBundle.putBoolean(str, ((Boolean)localObject).booleanValue());
          } else if ((localObject instanceof Double)) {
            localBundle.putDouble(str, ((Double)localObject).doubleValue());
          } else if ((localObject instanceof Long)) {
            localBundle.putLong(str, ((Long)localObject).longValue());
          } else if ((localObject instanceof JSONObject)) {
            localBundle.putBundle(str, d((JSONObject)localObject));
          } else if ((localObject instanceof JSONArray)) {
            a(localBundle, str, (JSONArray)localObject);
          }
        }
      }
      else
      {
        return localBundle;
        label236:
        localBundle = null;
      }
    }
  }
  
  private static int e(JSONObject paramJSONObject)
  {
    int i2 = (int)a(paramJSONObject, "rc", 1.0F);
    int i1 = i2;
    if (i2 > 0) {
      i1 = i2 - 1;
    }
    return i1;
  }
  
  private static PointF e(JSONArray paramJSONArray)
    throws JSONException
  {
    return new PointF((float)paramJSONArray.getDouble(0), (float)paramJSONArray.getDouble(1));
  }
  
  private View f(JSONObject paramJSONObject)
    throws JSONException
  {
    if (this.b != null)
    {
      Canvas localCanvas = null;
      Object localObject1 = paramJSONObject.getString("$");
      if (localObject1 != null)
      {
        localObject1 = (byte[])this.A.get(localObject1);
        if (localObject1 == null) {
          break label468;
        }
      }
      for (;;)
      {
        Bitmap localBitmap;
        try
        {
          localBitmap = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
          localObject1 = new ImageView(this.b.getContext());
        }
        catch (Throwable paramJSONObject)
        {
          float f2;
          int i1;
          float f3;
          float f1;
          int i2;
          int i3;
          Object localObject2;
          Object localObject3;
          localObject1 = localCanvas;
        }
        try
        {
          ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
          if (paramJSONObject.optBoolean("b", false))
          {
            f2 = a(paramJSONObject, "bw", 0.5F);
            i1 = a(paramJSONObject, "bdc", c);
            f3 = a(paramJSONObject, "br", 6.5F);
            f1 = f2;
            if (f2 < 1.0F) {
              f1 = 1.0F;
            }
            i2 = localBitmap.getWidth();
            i3 = localBitmap.getHeight();
          }
        }
        catch (Throwable paramJSONObject)
        {
          for (;;) {}
        }
        try
        {
          paramJSONObject = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
          paramJSONObject.eraseColor(0);
          localCanvas = new Canvas(paramJSONObject);
          localCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 1));
          f2 = f3 + f1;
          localObject2 = new Path();
          localObject3 = new RectF(0.0F, 0.0F, i2, i3);
          ((Path)localObject2).addRoundRect((RectF)localObject3, f2, f2, Path.Direction.CCW);
          localCanvas.clipPath((Path)localObject2, Region.Op.REPLACE);
          localCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, new Paint(3));
          localCanvas.clipRect((RectF)localObject3, Region.Op.REPLACE);
          localObject2 = new Paint(1);
          ((Paint)localObject2).setStrokeWidth(f1);
          ((Paint)localObject2).setColor(i1);
          ((Paint)localObject2).setStyle(Paint.Style.STROKE);
          localObject3 = new Path();
          f1 /= 2.0F;
          ((Path)localObject3).addRoundRect(new RectF(f1, f1, i2 - f1, i3 - f1), f3, f3, Path.Direction.CCW);
          localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
          if (localBitmap != null) {
            localBitmap.recycle();
          }
        }
        catch (Throwable paramJSONObject)
        {
          paramJSONObject = localBitmap;
        }
      }
      this.C.add(paramJSONObject);
      ((ImageView)localObject1).setImageBitmap(paramJSONObject);
      return (View)localObject1;
      this.C.add(localBitmap);
      ((ImageView)localObject1).setImageBitmap(localBitmap);
      return (View)localObject1;
      if (Log.isLoggable("AdMobSDK", 6)) {
        Log.e("AdMobSDK", "couldn't create an imageView", paramJSONObject);
      }
      return (View)localObject1;
      if (Log.isLoggable("AdMobSDK", 3)) {
        Log.d("AdMobSDK", "Could not find asset name " + paramJSONObject);
      }
      label468:
      return null;
    }
    return null;
  }
  
  private void j()
  {
    Context localContext;
    PackageManager localPackageManager;
    Iterator localIterator;
    if (this.b != null)
    {
      localContext = this.b.getContext();
      if (localContext == null) {
        break label93;
      }
      localPackageManager = localContext.getPackageManager();
      localIterator = this.n.iterator();
    }
    for (;;)
    {
      Intent localIntent;
      if (localIterator.hasNext())
      {
        localIntent = (Intent)localIterator.next();
        if (localPackageManager.resolveActivity(localIntent, 65536) == null) {}
      }
      else
      {
        for (;;)
        {
          label93:
          try
          {
            localContext.startActivity(localIntent);
            return;
          }
          catch (Exception localException) {}
          if (Log.isLoggable("AdMobSDK", 6))
          {
            Log.e("AdMobSDK", "Could not find a resolving intent on ad click");
            return;
            if (Log.isLoggable("AdMobSDK", 3))
            {
              Log.d("AdMobSDK", "Context null, not able to start Activity.");
              return;
            }
          }
        }
      }
    }
  }
  
  private boolean k()
  {
    return (this.B == null) || (this.B.size() == 0);
  }
  
  private void l()
  {
    if (this.B != null) {
      synchronized (this.B)
      {
        Iterator localIterator = this.B.iterator();
        if (localIterator.hasNext()) {
          ((r)localIterator.next()).g();
        }
      }
    }
  }
  
  private void m()
  {
    localRect2 = new Rect(0, 0, this.t, this.u);
    Object localObject = localRect2;
    if (this.z.has("ta")) {}
    try
    {
      localObject = this.z.getJSONArray("ta");
      int i1 = ((JSONArray)localObject).getInt(0);
      int i2 = ((JSONArray)localObject).getInt(1);
      Rect localRect3 = new Rect(i1, i2, ((JSONArray)localObject).getInt(2) + i1, ((JSONArray)localObject).getInt(3) + i2);
      localObject = localRect2;
      if (Math.abs(localRect3.width()) >= 44)
      {
        i1 = Math.abs(localRect3.height());
        localObject = localRect2;
        if (i1 >= 44) {
          localObject = localRect3;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Rect localRect1 = localRect2;
        if (Log.isLoggable("AdMobSDK", 3))
        {
          Log.d("AdMobSDK", "could not read in the touchable area for the ad.");
          localRect1 = localRect2;
        }
      }
    }
    this.r = ((Rect)localObject);
  }
  
  private void n()
    throws JSONException
  {
    JSONObject localJSONObject = this.z.optJSONObject("$");
    if (localJSONObject != null)
    {
      Iterator localIterator = localJSONObject.keys();
      if (this.B != null) {
        synchronized (this.B)
        {
          if (this.b != null)
          {
            Context localContext = this.b.getContext();
            if (localIterator.hasNext())
            {
              Object localObject2 = (String)localIterator.next();
              localObject2 = e.a(localJSONObject.getJSONObject((String)localObject2).getString("u"), (String)localObject2, AdManager.getUserId(localContext), this);
              this.B.add(localObject2);
            }
          }
        }
      }
    }
  }
  
  private void o()
  {
    if (this.z != null)
    {
      ??? = this.z;
      this.z = null;
    }
    try
    {
      ??? = ((JSONObject)???).optJSONArray("v");
      if (??? == null) {
        break label170;
      }
      locald = new d(this.b, this);
      i1 = 0;
    }
    catch (JSONException localJSONException)
    {
      synchronized (this.B)
      {
        do
        {
          for (;;)
          {
            d locald;
            int i1;
            this.B.clear();
            this.B = null;
            if (this.A != null)
            {
              this.A.clear();
              this.A = null;
            }
            return;
            i1 += 1;
            continue;
            AdView.a.post(locald);
            continue;
            localJSONException = localJSONException;
            if (Log.isLoggable("AdMobSDK", 3)) {
              Log.d("AdMobSDK", "couldn't construct the views.", localJSONException);
            }
          }
        } while (this.v == null);
        this.v.a();
      }
    }
    if (i1 < ((JSONArray)???).length()) {
      if (!a(((JSONArray)???).getJSONObject(i1), locald))
      {
        if (this.v != null) {
          this.v.a();
        }
        if (this.B == null) {}
      }
    }
  }
  
  private void p()
  {
    if (this.B != null)
    {
      synchronized (this.B)
      {
        Iterator localIterator = this.B.iterator();
        if (localIterator.hasNext()) {
          ((r)localIterator.next()).b();
        }
      }
      this.B.clear();
      this.B = null;
    }
    if (this.A != null)
    {
      this.A.clear();
      this.A = null;
    }
    this.z = null;
    if (this.v != null) {
      this.v.a();
    }
  }
  
  final double a()
  {
    return this.E;
  }
  
  final int a(int paramInt)
  {
    double d2 = paramInt;
    double d1 = d2;
    if (this.F > 0.0D) {
      d1 = d2 * this.F;
    }
    return (int)d1;
  }
  
  final Rect a(Rect paramRect)
  {
    Rect localRect = new Rect(paramRect);
    if (this.F > 0.0D)
    {
      localRect.left = a(paramRect.left);
      localRect.top = a(paramRect.top);
      localRect.right = a(paramRect.right);
      localRect.bottom = a(paramRect.bottom);
    }
    return localRect;
  }
  
  public final View a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setBackgroundColor(0);
    localRelativeLayout.setGravity(17);
    paramContext = new AdMobWebView(paramContext, localRelativeLayout, paramString2, this);
    paramContext.setBackgroundColor(-1);
    paramContext.setId(1);
    localRelativeLayout.addView(paramContext, new RelativeLayout.LayoutParams(a(paramInt1), a(paramInt2)));
    paramContext.b = (paramString1 + "#sdk");
    paramContext.loadUrl("http://mm.admob.com/static/android/canvas.html");
    return localRelativeLayout;
  }
  
  public final void a(View paramView)
  {
    if (this.G == null) {
      this.G = new Vector();
    }
    paramView = new WeakReference(paramView);
    this.G.add(paramView);
  }
  
  public final void a(b paramb)
  {
    this.D = paramb;
  }
  
  public final void a(g paramg)
  {
    this.b = paramg;
  }
  
  public final void a(r paramr)
  {
    ??? = paramr.e();
    byte[] arrayOfByte = paramr.d();
    if (arrayOfByte != null)
    {
      this.A.put(???, arrayOfByte);
      if (this.B != null) {}
      synchronized (this.B)
      {
        this.B.remove(paramr);
        if (k()) {
          o();
        }
        return;
      }
    }
    if (Log.isLoggable("AdMobSDK", 3)) {
      Log.d("AdMobSDK", "Failed reading asset(" + (String)??? + ") for ad");
    }
    p();
  }
  
  public final void a(r paramr, Exception paramException)
  {
    String str;
    if (paramException != null) {
      if (Log.isLoggable("AdMobSDK", 3))
      {
        if (paramr == null) {
          break label170;
        }
        str = paramr.e();
        paramr = paramr.f();
        if (paramr == null) {
          break label165;
        }
        paramr = paramr.toString();
      }
    }
    for (;;)
    {
      Log.d("AdMobSDK", "Failed downloading assets for ad: " + str + " " + paramr, paramException);
      do
      {
        p();
        return;
      } while (!Log.isLoggable("AdMobSDK", 3));
      if (paramr != null)
      {
        paramException = paramr.e();
        paramr = paramr.f();
        if (paramr != null) {
          paramr = paramr.toString();
        }
      }
      for (;;)
      {
        Log.d("AdMobSDK", "Failed downloading assets for ad: " + paramException + " " + paramr);
        break;
        paramr = null;
        continue;
        paramr = null;
        paramException = null;
      }
      label165:
      paramr = null;
      continue;
      label170:
      paramr = null;
      str = null;
    }
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    if (this.m)
    {
      Log.i("AdMobSDK", "Ad clicked again.  Stats on admob.com will only reflect the first click.");
      switch (1.a[this.q.ordinal()])
      {
      default: 
        j();
      }
    }
    for (;;)
    {
      if (this.D != null) {
        this.D.a();
      }
      return;
      this.m = true;
      Log.i("AdMobSDK", "Ad clicked.");
      if (this.b == null) {
        break;
      }
      Context localContext = this.b.getContext();
      Iterator localIterator = this.p.iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        h local2 = new h()
        {
          public final void a(r paramAnonymousr)
          {
            if (Log.isLoggable("AdMobSDK", 3)) {
              Log.d("AdMobSDK", "Click processed at " + paramAnonymousr.f());
            }
          }
          
          public final void a(r paramAnonymousr, Exception paramAnonymousException)
          {
            if (Log.isLoggable("AdMobSDK", 3)) {
              Log.d("AdMobSDK", "Click processing failed at " + paramAnonymousr.f(), paramAnonymousException);
            }
          }
        };
        localObject = null;
        if (locale.b) {
          localObject = paramJSONObject;
        }
        e.a(locale.a, "click_time_tracking", AdManager.getUserId(localContext), (JSONObject)localObject, local2).g();
      }
      paramJSONObject = (Intent)this.n.firstElement();
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.getData();
        if (paramJSONObject != null)
        {
          paramJSONObject = paramJSONObject.toString();
          localObject = this.k;
          if (AdView.a != null) {
            AdView.a.post(new c(paramJSONObject, (String)localObject, 320, 295, this));
          }
        }
      }
    }
  }
  
  public final g b()
  {
    return this.b;
  }
  
  public final void b(View paramView)
  {
    Object localObject;
    if ((this.G != null) && (paramView != null))
    {
      Iterator localIterator = this.G.iterator();
      localObject = null;
      if (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (!paramView.equals(localWeakReference.get())) {
          break label69;
        }
        localObject = localWeakReference;
      }
    }
    label69:
    for (;;)
    {
      break;
      this.G.remove(localObject);
      return;
    }
  }
  
  public final long c()
  {
    return this.s;
  }
  
  final boolean d()
  {
    return this.l;
  }
  
  public final int e()
  {
    return this.t;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof d))
    {
      paramObject = (d)paramObject;
      return toString().equals(((d)paramObject).toString());
    }
    return false;
  }
  
  public final int f()
  {
    return this.u;
  }
  
  public final Rect g()
  {
    if (this.r == null) {
      this.r = new Rect(0, 0, this.t, this.u);
    }
    return this.r;
  }
  
  final void h()
  {
    Object localObject1 = this.C.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Bitmap)((Iterator)localObject1).next();
      if (localObject2 != null) {
        ((Bitmap)localObject2).recycle();
      }
    }
    this.C.clear();
    if (this.b != null)
    {
      localObject1 = (WindowManager)this.b.getContext().getSystemService("window");
      if (this.G != null)
      {
        localObject2 = this.G.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          View localView = (View)((WeakReference)((Iterator)localObject2).next()).get();
          if (localView != null) {
            ((WindowManager)localObject1).removeView(localView);
          }
        }
        this.G.removeAllElements();
      }
    }
  }
  
  public final int hashCode()
  {
    return toString().hashCode();
  }
  
  final void i()
  {
    if (this.b != null)
    {
      Context localContext = this.b.getContext();
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext()) {
        e.a((String)localIterator.next(), "impression_request", AdManager.getUserId(localContext)).g();
      }
    }
  }
  
  public final String toString()
  {
    String str2 = this.j;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  protected static class a
  {
    WeakReference<AdView> a;
    
    public a(AdView paramAdView)
    {
      this.a = new WeakReference(paramAdView);
    }
    
    public void a()
    {
      AdView localAdView = (AdView)this.a.get();
      if (localAdView != null) {
        AdView.c(localAdView);
      }
    }
    
    public void a(d paramd)
    {
      AdView localAdView = (AdView)this.a.get();
      if (localAdView != null) {
        try
        {
          if ((AdView.a(localAdView) != null) && (paramd.equals(AdView.a(localAdView).b()))) {
            if (Log.isLoggable("AdMobSDK", 3)) {
              Log.d("AdMobSDK", "Received the same ad we already had.  Discarding it.");
            }
          }
          for (;;)
          {
            return;
            if (Log.isLoggable("AdMobSDK", 4)) {
              Log.i("AdMobSDK", "Ad returned (" + (SystemClock.uptimeMillis() - AdView.g(localAdView)) + " ms):  " + paramd);
            }
            localAdView.getContext();
            localAdView.a(paramd, paramd.b());
          }
          return;
        }
        finally {}
      }
    }
  }
  
  static abstract interface b
  {
    public abstract void a();
  }
  
  static final class c
    implements Runnable
  {
    private String a;
    private int b;
    private int c;
    private String d;
    private WeakReference<d> e;
    
    public c(String paramString1, String paramString2, int paramInt1, int paramInt2, d paramd)
    {
      this.a = paramString1;
      this.b = 320;
      this.c = 295;
      this.d = paramString2;
      this.e = new WeakReference(paramd);
    }
    
    public final void run()
    {
      try
      {
        d locald = (d)this.e.get();
        if ((locald != null) && (locald.b != null))
        {
          Context localContext = locald.b.getContext();
          WindowManager localWindowManager = (WindowManager)localContext.getSystemService("window");
          WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -1, 1000, 2, -3);
          localLayoutParams.dimAmount = 0.75F;
          locald.a = locald.a(localContext, this.a, this.d, this.b, this.c);
          localWindowManager.addView(locald.a, localLayoutParams);
          locald.a(locald.a);
        }
        return;
      }
      catch (Exception localException)
      {
        while (!Log.isLoggable("AdMobSDK", 6)) {}
        Log.e("AdMobSDK", "exception caught in Ad$WebViewLoader.run(), " + localException.getMessage());
      }
    }
  }
  
  private static final class d
    implements Runnable
  {
    Vector<d.g> a = new Vector();
    private g b;
    private WeakReference<d> c;
    
    public d(g paramg, d paramd)
    {
      this.b = paramg;
      this.c = new WeakReference(paramd);
    }
    
    public final void run()
    {
      try
      {
        if (this.b == null) {
          break label153;
        }
        this.b.setPadding(0, 0, 0, 0);
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (d.g)localIterator.next();
          View localView = ((d.g)localObject).a;
          this.b.addView(localView, ((d.g)localObject).b);
          localObject = ((d.g)localObject).c;
          if (localObject != null)
          {
            localView.startAnimation((Animation)localObject);
            continue;
            return;
          }
        }
      }
      catch (Exception localException)
      {
        if (Log.isLoggable("AdMobSDK", 6)) {
          Log.e("AdMobSDK", "exception caught in Ad$ViewAdd.run(), " + localException.getMessage());
        }
      }
      this.b.invalidate();
      this.b.requestLayout();
      for (;;)
      {
        d locald = (d)this.c.get();
        if (locald == null) {
          break;
        }
        d.a(locald);
        return;
        label153:
        if (Log.isLoggable("AdMobSDK", 6)) {
          Log.e("AdMobSDK", "containerView was null in ViewAdd!");
        }
      }
    }
  }
  
  private static final class e
  {
    public String a;
    public boolean b;
    
    public e(String paramString, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramBoolean;
    }
  }
  
  protected static enum f
  {
    private f() {}
  }
  
  private static final class g
  {
    public View a;
    public RelativeLayout.LayoutParams b;
    public AnimationSet c;
    
    private g(byte paramByte) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/hangman/com.games.HangManGame-14-dex2jar.jar!/com/admob/android/ads/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */