package com.inmobi.androidsdk.ai.container;

import android.content.pm.ActivityInfo;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.view.MotionEvent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IMWrapperFunctions
{
  private static final String FIELD_AXIS_SIZE = "AXIS_SIZE";
  private static final String FIELD_AXIS_X = "AXIS_X";
  private static final String FIELD_AXIS_Y = "AXIS_Y";
  private static final String FIELD_CONFIG_SCREEN_SIZE = "CONFIG_SCREEN_SIZE";
  private static final String FIELD_CONFIG_SMALLEST_SCREEN_SIZE = "CONFIG_SMALLEST_SCREEN_SIZE";
  private static final String FIELD_FILL_PARENT = "FILL_PARENT";
  private static final String FIELD_MATCH_PARENT = "MATCH_PARENT";
  private static final String FIELD_REVERSE_LANDSCAPE = "SCREEN_ORIENTATION_REVERSE_LANDSCAPE";
  private static final String FIELD_REVERSE_PORTRAIT = "SCREEN_ORIENTATION_REVERSE_PORTRAIT";
  private static final String METHOD_GETAXISVALUE = "getAxisValue";
  private static final String METHOD_GETHEIGHT = "getHeight";
  private static final String METHOD_GETSIZE = "getSize";
  private static final String METHOD_GETWIDTH = "getWidth";
  private static final String METHOD_SET_LAYERTYPE = "setLayerType";
  private static int a;
  
  public static void disableHardwareAccl(IMWebView paramIMWebView)
  {
    try
    {
      Method localMethod = paramIMWebView.getClass().getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class });
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(1);
      localMethod.invoke(paramIMWebView, arrayOfObject);
      return;
    }
    catch (IllegalArgumentException paramIMWebView)
    {
      paramIMWebView.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramIMWebView)
    {
      paramIMWebView.printStackTrace();
      return;
    }
    catch (InvocationTargetException paramIMWebView)
    {
      paramIMWebView.printStackTrace();
      return;
    }
    catch (NoSuchMethodException paramIMWebView) {}
  }
  
  public static int getDisplayHeight(Display paramDisplay)
  {
    Object localObject1 = null;
    int i = 1;
    try
    {
      localObject2 = Display.class.getMethod("getSize", new Class[] { Point.class });
      localObject1 = localObject2;
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      for (;;)
      {
        try
        {
          Object localObject2 = new Point();
          ((Method)localObject1).invoke(paramDisplay, new Object[] { localObject2 });
          i = ((Point)localObject2).y;
          return i;
        }
        catch (IllegalArgumentException paramDisplay)
        {
          return 0;
        }
        catch (IllegalAccessException paramDisplay)
        {
          return 0;
        }
        catch (InvocationTargetException paramDisplay) {}
        localNoSuchMethodException1 = localNoSuchMethodException1;
        try
        {
          Method localMethod = Display.class.getMethod("getHeight", null);
          localObject1 = localMethod;
          i = 0;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          i = 0;
        }
      }
      i = ((Integer)((Method)localObject1).invoke(paramDisplay, null)).intValue();
      return i;
    }
    if (i != 0) {}
    return 0;
  }
  
  public static int getDisplayWidth(Display paramDisplay)
  {
    Object localObject1 = null;
    int i = 1;
    try
    {
      localObject2 = Display.class.getMethod("getSize", new Class[] { Point.class });
      localObject1 = localObject2;
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      for (;;)
      {
        try
        {
          Object localObject2 = new Point();
          ((Method)localObject1).invoke(paramDisplay, new Object[] { localObject2 });
          i = ((Point)localObject2).x;
          return i;
        }
        catch (IllegalArgumentException paramDisplay)
        {
          return 0;
        }
        catch (IllegalAccessException paramDisplay)
        {
          return 0;
        }
        catch (InvocationTargetException paramDisplay) {}
        localNoSuchMethodException1 = localNoSuchMethodException1;
        try
        {
          Method localMethod = Display.class.getMethod("getWidth", null);
          localObject1 = localMethod;
          i = 0;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          i = 0;
        }
      }
      i = ((Integer)((Method)localObject1).invoke(paramDisplay, null)).intValue();
      return i;
    }
    if (i != 0) {}
    return 0;
  }
  
  public static int getParamConfigScreenSize()
  {
    int i = 0;
    ActivityInfo localActivityInfo = new ActivityInfo();
    try
    {
      Field localField = ActivityInfo.class.getField("CONFIG_SCREEN_SIZE");
      if (localField != null) {
        i = localField.getInt(localActivityInfo);
      }
      return i;
    }
    catch (Exception localException)
    {
      return 0;
    }
    catch (NoSuchFieldException localNoSuchFieldException) {}
    return 0;
  }
  
  public static int getParamConfigSmallestScreenSize()
  {
    int i = 0;
    ActivityInfo localActivityInfo = new ActivityInfo();
    try
    {
      Field localField = ActivityInfo.class.getField("CONFIG_SMALLEST_SCREEN_SIZE");
      if (localField != null) {
        i = localField.getInt(localActivityInfo);
      }
      return i;
    }
    catch (Exception localException)
    {
      return 0;
    }
    catch (NoSuchFieldException localNoSuchFieldException) {}
    return 0;
  }
  
  /* Error */
  public static int getParamFillParent()
  {
    // Byte code:
    //   0: getstatic 137	com/inmobi/androidsdk/ai/container/IMWrapperFunctions:a	I
    //   3: ifne +49 -> 52
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 137	com/inmobi/androidsdk/ai/container/IMWrapperFunctions:a	I
    //   12: ifne +37 -> 49
    //   15: new 139	android/view/ViewGroup$LayoutParams
    //   18: dup
    //   19: iconst_1
    //   20: iconst_1
    //   21: invokespecial 142	android/view/ViewGroup$LayoutParams:<init>	(II)V
    //   24: astore_2
    //   25: aconst_null
    //   26: astore_0
    //   27: ldc -117
    //   29: ldc 26
    //   31: invokevirtual 127	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   34: astore_1
    //   35: aload_1
    //   36: astore_0
    //   37: aload_0
    //   38: ifnull +11 -> 49
    //   41: aload_0
    //   42: aload_2
    //   43: invokevirtual 133	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   46: putstatic 137	com/inmobi/androidsdk/ai/container/IMWrapperFunctions:a	I
    //   49: ldc 2
    //   51: monitorexit
    //   52: getstatic 137	com/inmobi/androidsdk/ai/container/IMWrapperFunctions:a	I
    //   55: ireturn
    //   56: astore_1
    //   57: ldc -117
    //   59: ldc 23
    //   61: invokevirtual 127	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   64: astore_1
    //   65: aload_1
    //   66: astore_0
    //   67: goto -30 -> 37
    //   70: astore_0
    //   71: ldc 2
    //   73: monitorexit
    //   74: aload_0
    //   75: athrow
    //   76: astore_0
    //   77: goto -28 -> 49
    //   80: astore_1
    //   81: goto -44 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	41	0	localObject1	Object
    //   70	5	0	localObject2	Object
    //   76	1	0	localException	Exception
    //   34	2	1	localField1	Field
    //   56	1	1	localNoSuchFieldException1	NoSuchFieldException
    //   64	2	1	localField2	Field
    //   80	1	1	localNoSuchFieldException2	NoSuchFieldException
    //   24	19	2	localLayoutParams	android.view.ViewGroup.LayoutParams
    // Exception table:
    //   from	to	target	type
    //   27	35	56	java/lang/NoSuchFieldException
    //   9	25	70	finally
    //   27	35	70	finally
    //   41	49	70	finally
    //   49	52	70	finally
    //   57	65	70	finally
    //   71	74	70	finally
    //   41	49	76	java/lang/Exception
    //   57	65	80	java/lang/NoSuchFieldException
  }
  
  public static int getParamLandscapeOrientation(int paramInt)
  {
    int j = 0;
    int i = j;
    ActivityInfo localActivityInfo;
    if (paramInt == 3) {
      localActivityInfo = new ActivityInfo();
    }
    try
    {
      Field localField = ActivityInfo.class.getField("SCREEN_ORIENTATION_REVERSE_LANDSCAPE");
      i = j;
      if (localField != null) {
        i = localField.getInt(localActivityInfo);
      }
      return i;
    }
    catch (Exception localException)
    {
      return 0;
    }
    catch (NoSuchFieldException localNoSuchFieldException) {}
    return 0;
  }
  
  public static int getParamPortraitOrientation(int paramInt)
  {
    int j = 1;
    int i = j;
    ActivityInfo localActivityInfo;
    if (paramInt == 2) {
      localActivityInfo = new ActivityInfo();
    }
    try
    {
      Field localField = ActivityInfo.class.getField("SCREEN_ORIENTATION_REVERSE_PORTRAIT");
      i = j;
      if (localField != null) {
        i = localField.getInt(localActivityInfo);
      }
      return i;
    }
    catch (Exception localException)
    {
      return 1;
    }
    catch (NoSuchFieldException localNoSuchFieldException) {}
    return 1;
  }
  
  public static String getTapLocationX(MotionEvent paramMotionEvent)
  {
    try
    {
      paramMotionEvent = MotionEvent.class.getMethod("getAxisValue", new Class[] { Integer.TYPE }).invoke(paramMotionEvent, new Object[] { Integer.valueOf(MotionEvent.class.getField("AXIS_X").getInt(null)) }).toString();
      return paramMotionEvent;
    }
    catch (Exception paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return null;
  }
  
  public static String getTapLocationY(MotionEvent paramMotionEvent)
  {
    try
    {
      paramMotionEvent = MotionEvent.class.getMethod("getAxisValue", new Class[] { Integer.TYPE }).invoke(paramMotionEvent, new Object[] { Integer.valueOf(MotionEvent.class.getField("AXIS_Y").getInt(null)) }).toString();
      return paramMotionEvent;
    }
    catch (Exception paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return null;
  }
  
  public static String getTapSize(MotionEvent paramMotionEvent)
  {
    try
    {
      paramMotionEvent = MotionEvent.class.getMethod("getAxisValue", new Class[] { Integer.TYPE }).invoke(paramMotionEvent, new Object[] { Integer.valueOf(MotionEvent.class.getField("AXIS_SIZE").getInt(null)) }).toString();
      return paramMotionEvent;
    }
    catch (Exception paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/ai/container/IMWrapperFunctions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */