package com.facebook.ads.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AdAnalogData {
    private static Sensor accelerometer;
    private static volatile float[] accelerometerValues;
    private static Map<String, Object> analogInfo = new ConcurrentHashMap();
    private static Sensor gyroscope;
    private static volatile float[] gyroscopeValues;
    private static SensorManager sensorManager = null;

    static {
        accelerometer = null;
        gyroscope = null;
    }

    public static Map<String, Object> getAnalogInfo() {
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(analogInfo);
        putSensorData(localHashMap);
        return localHashMap;
    }

    private static void putBatteryData(Context paramContext) {
        paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (paramContext == null) {
            return;
        }
        int i = paramContext.getIntExtra("level", -1);
        int j = paramContext.getIntExtra("scale", -1);
        int k = paramContext.getIntExtra("status", -1);
        if ((k == 2) || (k == 5)) {
        }
        for (boolean bool = true; ; bool = false) {
            float f = 0.0F;
            if (j > 0) {
                f = i / j * 100.0F;
            }
            analogInfo.put("battery", Float.valueOf(f));
            analogInfo.put("charging", Boolean.valueOf(bool));
            return;
        }
    }

    private static void putDiskInfo(Context paramContext) {
        StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
        long l1 = localStatFs.getBlockSize();
        long l2 = localStatFs.getAvailableBlocks();
        analogInfo.put("free_space", Formatter.formatFileSize(paramContext, l2 * l1));
    }

    private static void putMemoryInfo(Context paramContext) {
        ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) paramContext.getSystemService("activity")).getMemoryInfo(localMemoryInfo);
        analogInfo.put("available_memory", String.valueOf(localMemoryInfo.availMem));
    }

    private static void putSensorData(Map<String, Object> paramMap) {
        int j = 0;
        float[] arrayOfFloat1 = accelerometerValues;
        float[] arrayOfFloat2 = gyroscopeValues;
        int i;
        if (arrayOfFloat1 != null) {
            i = 0;
            while (i < arrayOfFloat1.length) {
                paramMap.put("accelerometer_" + i, Float.valueOf(arrayOfFloat1[i]));
                i += 1;
            }
        }
        if (arrayOfFloat2 != null) {
            i = j;
            while (i < arrayOfFloat2.length) {
                paramMap.put("rotation_" + i, Float.valueOf(arrayOfFloat2[i]));
                i += 1;
            }
        }
    }

    /* Error */
    public static void startUpdate(Context paramContext) {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: aload_0
        //   4: invokestatic 184	com/facebook/ads/internal/AdAnalogData:putMemoryInfo	(Landroid/content/Context;)V
        //   7: aload_0
        //   8: invokestatic 186	com/facebook/ads/internal/AdAnalogData:putDiskInfo	(Landroid/content/Context;)V
        //   11: aload_0
        //   12: invokestatic 188	com/facebook/ads/internal/AdAnalogData:putBatteryData	(Landroid/content/Context;)V
        //   15: getstatic 19	com/facebook/ads/internal/AdAnalogData:sensorManager	Landroid/hardware/SensorManager;
        //   18: ifnonnull +27 -> 45
        //   21: aload_0
        //   22: ldc -66
        //   24: invokevirtual 146	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
        //   27: checkcast 192	android/hardware/SensorManager
        //   30: putstatic 19	com/facebook/ads/internal/AdAnalogData:sensorManager	Landroid/hardware/SensorManager;
        //   33: getstatic 19	com/facebook/ads/internal/AdAnalogData:sensorManager	Landroid/hardware/SensorManager;
        //   36: astore_0
        //   37: aload_0
        //   38: ifnonnull +7 -> 45
        //   41: ldc 2
        //   43: monitorexit
        //   44: return
        //   45: getstatic 21	com/facebook/ads/internal/AdAnalogData:accelerometer	Landroid/hardware/Sensor;
        //   48: ifnonnull +13 -> 61
        //   51: getstatic 19	com/facebook/ads/internal/AdAnalogData:sensorManager	Landroid/hardware/SensorManager;
        //   54: iconst_1
        //   55: invokevirtual 196	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
        //   58: putstatic 21	com/facebook/ads/internal/AdAnalogData:accelerometer	Landroid/hardware/Sensor;
        //   61: getstatic 23	com/facebook/ads/internal/AdAnalogData:gyroscope	Landroid/hardware/Sensor;
        //   64: ifnonnull +13 -> 77
        //   67: getstatic 19	com/facebook/ads/internal/AdAnalogData:sensorManager	Landroid/hardware/SensorManager;
        //   70: iconst_4
        //   71: invokevirtual 196	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
        //   74: putstatic 23	com/facebook/ads/internal/AdAnalogData:gyroscope	Landroid/hardware/Sensor;
        //   77: getstatic 21	com/facebook/ads/internal/AdAnalogData:accelerometer	Landroid/hardware/Sensor;
        //   80: ifnull +22 -> 102
        //   83: getstatic 19	com/facebook/ads/internal/AdAnalogData:sensorManager	Landroid/hardware/SensorManager;
        //   86: new 198	com/facebook/ads/internal/AdAnalogData$AdSensorEventListener
        //   89: dup
        //   90: aconst_null
        //   91: invokespecial 201	com/facebook/ads/internal/AdAnalogData$AdSensorEventListener:<init>	(Lcom/facebook/ads/internal/AdAnalogData$1;)V
        //   94: getstatic 21	com/facebook/ads/internal/AdAnalogData:accelerometer	Landroid/hardware/Sensor;
        //   97: iconst_3
        //   98: invokevirtual 205	android/hardware/SensorManager:registerListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z
        //   101: pop
        //   102: getstatic 23	com/facebook/ads/internal/AdAnalogData:gyroscope	Landroid/hardware/Sensor;
        //   105: ifnull -64 -> 41
        //   108: getstatic 19	com/facebook/ads/internal/AdAnalogData:sensorManager	Landroid/hardware/SensorManager;
        //   111: new 198	com/facebook/ads/internal/AdAnalogData$AdSensorEventListener
        //   114: dup
        //   115: aconst_null
        //   116: invokespecial 201	com/facebook/ads/internal/AdAnalogData$AdSensorEventListener:<init>	(Lcom/facebook/ads/internal/AdAnalogData$1;)V
        //   119: getstatic 23	com/facebook/ads/internal/AdAnalogData:gyroscope	Landroid/hardware/Sensor;
        //   122: iconst_3
        //   123: invokevirtual 205	android/hardware/SensorManager:registerListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z
        //   126: pop
        //   127: goto -86 -> 41
        //   130: astore_0
        //   131: ldc 2
        //   133: monitorexit
        //   134: aload_0
        //   135: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	136	0	paramContext	Context
        // Exception table:
        //   from	to	target	type
        //   3	37	130	finally
        //   45	61	130	finally
        //   61	77	130	finally
        //   77	102	130	finally
        //   102	127	130	finally
    }

    /* Error */
    public static void stopUpdate(AdAnalogData.AdSensorEventListener paramAdSensorEventListener) {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: getstatic 19	com/facebook/ads/internal/AdAnalogData:sensorManager	Landroid/hardware/SensorManager;
        //   6: astore_1
        //   7: aload_1
        //   8: ifnonnull +7 -> 15
        //   11: ldc 2
        //   13: monitorexit
        //   14: return
        //   15: getstatic 19	com/facebook/ads/internal/AdAnalogData:sensorManager	Landroid/hardware/SensorManager;
        //   18: aload_0
        //   19: invokevirtual 211	android/hardware/SensorManager:unregisterListener	(Landroid/hardware/SensorEventListener;)V
        //   22: goto -11 -> 11
        //   25: astore_0
        //   26: ldc 2
        //   28: monitorexit
        //   29: aload_0
        //   30: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	31	0	paramAdSensorEventListener	AdAnalogData.AdSensorEventListener
        //   6	2	1	localSensorManager	SensorManager
        // Exception table:
        //   from	to	target	type
        //   3	7	25	finally
        //   15	22	25	finally
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/ads/internal/AdAnalogData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */