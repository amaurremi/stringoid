package com.tapjoy.mraid.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tapjoy.TapjoyLog;

public class Browser
  extends Activity
{
  private static final String BACKGROUND_PNG = "iVBORw0KGgoAAAANSUhEUgAAAAEAAAAsCAIAAAArRUU2AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ\nbWFnZVJlYWR5ccllPAAAAEFJREFUeNpicPP0Zvr3/z/T/3//gDQQg+i//5j+gum/QBqIQXwg+x+Y\njckH6fkL0/f3NwMPHz8jKxsbAw0AQIABAGYHPKslk98oAAAAAElFTkSuQmCC";
  private static final int BackwardId = 103;
  private static final int ButtonId = 100;
  private static final int ForwardId = 102;
  private static final String LEFT_ARROW_PNG = "iVBORw0KGgoAAAANSUhEUgAAABIAAAAUCAYAAACAl21KAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ\nbWFnZVJlYWR5ccllPAAAApVJREFUeNqUVEuLkmEYfT6/9/MejjjeRhvvOo7XomLIzRTChEQU0Sa6\nLdoEA21azN6NzG9oIGE2bdwERYggrdqI2SLb5G5o0VwYRZGZ0a/zig5WNo4PHF4+5DnvOed9Htnq\n6irNUuVymeHQARbA5XA4vDirbAYCBQ4NYAIuarXacDQafbK0tJRqNBr32TkIBBxKwAgsKBQKTzgc\nfgCCO36/XxOPx6lYLBKbQsB/vwDYuI3FxcWby8vLDwOBwEIkEiFO4vV6qVarTSYCiYhDC5g5gdFo\nTMLGs2AwGIeSAUEoFCKLxUJqtZpEUfyTaJiDapiDU6lUBmKx2CM03YAKiRNAESFg0ul0BJunvWzM\nhgTMAXauAs13gXsgmOMEUEQul4sMBgMx9q8RNnxOPWDlBHa7/TpufQobbn47J0GoZDKZCApJEISJ\nmbKhEpter78GGy+gYgUklEgkiOdhs9lIo9H8l+CUCDcJaHjsdDpf+nw+3cgGvgnkgyDPU2xvb6+L\n5D96PJ4MpjwJVTQ/Pz8xh7NKgea+SqX6lMvlruzs7DxvtVq/jo6OSJblmYhEt9tNvV6PoETe3Nz8\ncnx8/BoKJazAZVzAuLVp+ZRKpbeDQej3+9RsNimdTsu7u7sHmUzmVT6fT1YqlQ/7+/t0cnIy3dr4\nB29AZrS2tibX6/XvqVTqdqFQuPUNBcuDC8+09ndxq7wR+yRD6Q+o28IDHMDuCmyr+UOM2+XWJhKN\nCnnR4eEhYdd62Wz2MxRtYaYMWI9LyE8YjcZUIl789brdLmFVuLXOxsbGe6vV+g7CglDokSSJqtXq\nm6lEo+L5dDodPu1yu93+ub6+vo3/pa8gu4px2RZm/asdvBC2nm8/9pLMZrMK1sXfAgwAtiLartJw\n+UAAAAAASUVORK5CYII=";
  private static final String REFRESH_PNG = "iVBORw0KGgoAAAANSUhEUgAAABMAAAAUCAYAAABvVQZ0AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ\nbWFnZVJlYWR5ccllPAAAA2NJREFUeNqMVF1Ik1EYPm7TpsIca84pGs6VrboYaeRPpFgXKUzBH4S8\nsLoIMVCpRERCAgfSZXpR2ZVJCEIgaIQm+MdCIkXRTTTnQG0qorCFm21zp+f9+IQ5NHvh4eP7vnOe\n877Ped5Xyv4dEYAMSK2rq/tkt9tlXq83Cu9BwC8+zyQ4B5wHLgAG4M7IyAgfHR31FhcXv8F7EXAZ\nUADSo43SMCLKQimS0GKDTqfLys7OvlldXZ2Vnp4uy8nJuZGWlmacnp52ejyeANZ4AB/AQ4kigSQg\nT6/XPzebzd8pk4WFBb6+vs6xkVP4/X6+s7PDx8bGPJWVlWasTxGTOJZRInC3oaHh88zMjLDh4OCA\n+3w+4RkIBPhRHB4e8u3tbd7f38+rqqpM2CcJ1YhKu4Vsvq2urnKIzN1uN3c4HHxqaso1Pj7+Y3d3\nVyAicqfTyaHhenNzc1Eo0VF5F2traz+srKwIRFtbW3xoaMjW1tZ2X9Q12WazcZfLxefn53lXV9fb\niooKjZjIsVAkJSXdIw1IFyqvt7d3pLy8PCFksXJgYIAPDg5aGxsbs8OzCY2E+vr692tra4LIFovl\nd15eXmrYqbKmpiZzuNAnRXJ3d7eVStjc3OQo7ZXos7OC5ImjZAA1EE0nSbRarUYulzNoxeCfb/gW\n+A+yGEAvuoC8ZieyoFKpVEulUgYPMVy3Qyzn8IwuiYWNXl5FQB4/9r0gIf+gxG34iEVFRbH8/HwS\nOPakmwovMTMz81JZWZm+oKDAkJiYGENk3o2NjSVYgsXFxbHc3NxCMXX5KYRkFRU2XzEajQZUxSQS\nCdvb2/tJZAfLy8uDyI4pFApmMpkKNRpNJr7rxEaWiaS0NhrQAuk1NTVPoDWDiRmS2RweHrYK9aO0\nFPjMvb+/z3EC7+vr+6VWqx/j321xauhEsa8DJjR9NxIQDI6xxFtbW58emx4tLS0PFhcXhT4kwomJ\nCS/67qNKparH/4fAo4yMDHNHR8c8EdDB1J8w+NRJVors7Ox8t7S0JCwkIH1utVr57Owsn5ub49Ru\ndBAdSC2HG7SVlJRoT7ssaXt7e+3k5KSLiIiQJgRFMBgUmpzIqE97enq+lJaWhrbciYwRKE+NW32G\nIVgcHx9/TSaTMfAxkLsx2ywge40J8zV8bP8VYACAQuluULZPjQAAAABJRU5ErkJggg==";
  private static final String RIGHT_ARROW_PNG = "iVBORw0KGgoAAAANSUhEUgAAABEAAAAUCAYAAABroNZJAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ\nbWFnZVJlYWR5ccllPAAAAq5JREFUeNqUlN9LmmEUx4++/ihKy6yZGEMjlExdEjgqQmm78ioGu41g\nu7Ftt+5mBF0Go8sIBvsTtggqGgODboK66aIwNi0lJ7p+2TT89b7Pvo/LaKucHTj4+LzP+bzne855\nXpnVan0ZiUSSoiimiCgBP4UXfD4fozpsbW2NhP7+/vdDQ0MvFLBkMnmBfQEuHhwclOHMbDbXhOAM\nCQ6HY8Lr9Tr8fv9ji8Xy6PDw8CKTyUh4LoNzUBkg9l/I4OCg2ePxkNPpfOB2u0cbGhoeQuJZsVjk\nWbHLrMTbYBVIb2/vhMvlMttsNurs7CSj0Si32+0W7D0BRMthOKuAS5cw6brEvyCQQk1NTdTY2Eht\nbW3U1dWlxr6rp6dnJJVKldLpdBEx8kuJYrVeNyAcwE0QBGpubqb29nbq7u7WDgwMjABs39/fz+Ry\nOV4rVoXx9a0QbjKZjJRKJWm1WjIYDIRRMKJeT/ECQzQazZTLZZ4Vb0D5Tsh1mFqtJp1ORyaTSejr\n67MixouMFLFY7AeOnCuoTsMYkV6vJ41GwxugR1cnNzY2POvr66/qhlzPChlRS0tLHuuv6F74XpCq\nYRg/7e7uvh0eHo7wwsrvE5zP53cQPIr6PMcV+T41NVUZvrog6MTPeDz+BoXn1yI0MzMjLS8v09bW\n1p961QpmjJWOj48/rKysvBsfHz+bm5tji4uLBBBls1nCzaeamUD3F1Tf3dHR8RoFPQ0GgywUCtHe\n3h5/dgWoQtg/ur+Fw+Fnra2tfoz7zvT0NFtdXaXt7W06Ojri0m68UI7+5/lCkqRfiUQiGAgEnPj9\nPDs7K3Ldm5ubhP9UKBS4vFuzlqtUqnPo+7i0tGTFpeMfqALXjSEijHdF+13BV/MzNjamWVhYyM7P\nzzOMcSXw5OSESqUS1ft5/C3AAL39YeI2ufApAAAAAElFTkSuQmCC";
  public static final String SHOW_BACK_EXTRA = "open_show_back";
  public static final String SHOW_FORWARD_EXTRA = "open_show_forward";
  public static final String SHOW_REFRESH_EXTRA = "open_show_refresh";
  private static final String TAG = "Mraid Browser";
  private static final String UN_RIGHT_ARROW_PNG = "iVBORw0KGgoAAAANSUhEUgAAABEAAAAUCAYAAABroNZJAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ\nbWFnZVJlYWR5ccllPAAAAqNJREFUeNqUlEtrE1EUx8+8EjNT27zTaMw0k6RJGpu+VqIi4k7rQtyK\nIn6FrEraRhTET+AnENxUXLpWcFfRhaCbCpY0Lc3DpE07c+dxPTckojTG5sAfhnvP/fE/99wz3IV4\n/Fl1Z+eDZVlVAKigmihjwuejcIpoNZsg+AOBlz6//2E4EonWazUGElC2oesWip7xeIZCMAeEUDhc\npBw3LkqubDqdvs1xQNqt1iHucygGshBEh0LQQREBY2fHx8F2HLfkcl1OJKaut1vtCiEGy6M9V/Yg\nWBcSDIWKHM+PyYoMLpcbJEkCYpoT/mDg1rloNF+tVrcwV0Q5PZjzZ4l/QdiGIAjAoxiI43jOtKyY\nOqXeVRRFrmPgGb5Xot2/rxMQnhe6dA4vRhDFLsymjkApzGta8iYhpNnpdAgrsQ9j3wMh/cB1EAUR\ny3QBsSyPMqbcUFX1UrPRqJimyUAOgw2F9GzhOsLQFXNHiBmMRCeXg8FgfG939wtmtLnszMwuJ4gR\nr98Hoij993E5jgPoAvSjI1A8ngPT0B+JMGIwV263G2RZhulU8lNle/vdyBAWc4XCdijgv7deKr1n\nFzsSJB6L6ZnMdHFtZeVFbrbgxBMa/Pi+BaeCeL1eZ3529tWT8vr9iwsLdiKVhka9BqZBuvtDIRJ2\nY3Fh/jM4dBkBlVQmSxv7NTAMHWzbBkrpcEg+l9ufjIQflFdX32byeRpTVfiJY29Z5u/D/TgBOR+N\nkmw287xcKj2eKczZqqZBs97AthKg2N5B48zjvLOnCzJO6LWrV95g330bG6/XtPS0zeo+aLeBoH3n\nH4CuE5wTktS0r1pSu/O0XP6WzuZop3OIg2Vg3dYJ64OCW1xamvy4ubmXwsOGfgz68TFY+CIdeqq/\nY/f3+EuAAQARwzy3ZhCNHQAAAABJRU5ErkJggg==";
  public static final String URL_EXTRA = "extra_url";
  private static final int WebViewId = 101;
  
  private Bitmap bitmapFromBase64(String paramString)
  {
    paramString = Base64.decode(paramString, 0);
    return BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
  }
  
  private Bitmap getDensityScaledBitmap(String paramString)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    Bitmap localBitmap = bitmapFromBase64(paramString);
    paramString = localBitmap;
    if (localBitmap != null)
    {
      int i = localBitmap.getWidth();
      int j = localBitmap.getHeight();
      float f1 = localDisplayMetrics.scaledDensity;
      float f2 = localDisplayMetrics.scaledDensity;
      paramString = new Matrix();
      paramString.postScale(f1, f2);
      paramString = Bitmap.createBitmap(localBitmap, 0, 0, i, j, paramString, true);
    }
    return paramString;
  }
  
  /* Error */
  public Bitmap bitmapFromJar(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: aload 7
    //   8: astore 4
    //   10: aload 8
    //   12: astore_3
    //   13: ldc -126
    //   15: invokevirtual 136	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   18: aload_1
    //   19: invokevirtual 142	java/lang/ClassLoader:getResource	(Ljava/lang/String;)Ljava/net/URL;
    //   22: invokevirtual 148	java/net/URL:getFile	()Ljava/lang/String;
    //   25: astore 6
    //   27: aload 6
    //   29: astore 5
    //   31: aload 7
    //   33: astore 4
    //   35: aload 8
    //   37: astore_3
    //   38: aload 6
    //   40: ldc -106
    //   42: invokevirtual 156	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   45: ifeq +18 -> 63
    //   48: aload 7
    //   50: astore 4
    //   52: aload 8
    //   54: astore_3
    //   55: aload 6
    //   57: iconst_5
    //   58: invokevirtual 160	java/lang/String:substring	(I)Ljava/lang/String;
    //   61: astore 5
    //   63: aload 7
    //   65: astore 4
    //   67: aload 8
    //   69: astore_3
    //   70: aload 5
    //   72: ldc -94
    //   74: invokevirtual 166	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   77: istore_2
    //   78: aload 5
    //   80: astore 6
    //   82: iload_2
    //   83: ifle +19 -> 102
    //   86: aload 7
    //   88: astore 4
    //   90: aload 8
    //   92: astore_3
    //   93: aload 5
    //   95: iconst_0
    //   96: iload_2
    //   97: invokevirtual 169	java/lang/String:substring	(II)Ljava/lang/String;
    //   100: astore 6
    //   102: aload 7
    //   104: astore 4
    //   106: aload 8
    //   108: astore_3
    //   109: new 171	java/util/jar/JarFile
    //   112: dup
    //   113: aload 6
    //   115: invokespecial 174	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   118: astore 5
    //   120: aload 7
    //   122: astore 4
    //   124: aload 8
    //   126: astore_3
    //   127: aload 5
    //   129: aload 5
    //   131: aload_1
    //   132: invokevirtual 178	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   135: invokevirtual 182	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   138: astore_1
    //   139: aload_1
    //   140: astore 4
    //   142: aload_1
    //   143: astore_3
    //   144: aload_1
    //   145: invokestatic 186	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   148: astore 5
    //   150: aload_1
    //   151: ifnull +7 -> 158
    //   154: aload_1
    //   155: invokevirtual 191	java/io/InputStream:close	()V
    //   158: aload 5
    //   160: areturn
    //   161: astore_1
    //   162: aload 4
    //   164: astore_3
    //   165: aload_1
    //   166: invokevirtual 194	java/lang/Exception:printStackTrace	()V
    //   169: aload 4
    //   171: ifnull +8 -> 179
    //   174: aload 4
    //   176: invokevirtual 191	java/io/InputStream:close	()V
    //   179: aconst_null
    //   180: areturn
    //   181: astore_1
    //   182: aload_3
    //   183: ifnull +7 -> 190
    //   186: aload_3
    //   187: invokevirtual 191	java/io/InputStream:close	()V
    //   190: aload_1
    //   191: athrow
    //   192: astore_1
    //   193: goto -35 -> 158
    //   196: astore_1
    //   197: goto -18 -> 179
    //   200: astore_3
    //   201: goto -11 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	Browser
    //   0	204	1	paramString	String
    //   77	20	2	i	int
    //   12	175	3	localObject1	Object
    //   200	1	3	localException	Exception
    //   8	167	4	localObject2	Object
    //   29	130	5	localObject3	Object
    //   25	89	6	localObject4	Object
    //   4	117	7	localObject5	Object
    //   1	124	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   13	27	161	java/lang/Exception
    //   38	48	161	java/lang/Exception
    //   55	63	161	java/lang/Exception
    //   70	78	161	java/lang/Exception
    //   93	102	161	java/lang/Exception
    //   109	120	161	java/lang/Exception
    //   127	139	161	java/lang/Exception
    //   144	150	161	java/lang/Exception
    //   13	27	181	finally
    //   38	48	181	finally
    //   55	63	181	finally
    //   70	78	181	finally
    //   93	102	181	finally
    //   109	120	181	finally
    //   127	139	181	finally
    //   144	150	181	finally
    //   165	169	181	finally
    //   154	158	192	java/lang/Exception
    //   174	179	196	java/lang/Exception
    //   186	190	200	java/lang/Exception
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new RelativeLayout(this);
    WebView localWebView = new WebView(this);
    getWindow().requestFeature(2);
    getWindow().setFeatureInt(2, -1);
    Intent localIntent = getIntent();
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setId(100);
    localLinearLayout.setWeightSum(100.0F);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(2, 100);
    localLinearLayout.setBackgroundDrawable(new BitmapDrawable(getDensityScaledBitmap("iVBORw0KGgoAAAANSUhEUgAAAAEAAAAsCAIAAAArRUU2AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ\nbWFnZVJlYWR5ccllPAAAAEFJREFUeNpicPP0Zvr3/z/T/3//gDQQg+i//5j+gum/QBqIQXwg+x+Y\njckH6fkL0/f3NwMPHz8jKxsbAw0AQIABAGYHPKslk98oAAAAAElFTkSuQmCC")));
    paramBundle.addView(localWebView, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
    paramBundle.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new LinearLayout.LayoutParams(-2, -1);
    ((LinearLayout.LayoutParams)localObject1).weight = 25.0F;
    ((LinearLayout.LayoutParams)localObject1).gravity = 16;
    Object localObject2 = new ImageButton(this);
    ((ImageButton)localObject2).setBackgroundColor(getResources().getColor(17170445));
    ((ImageButton)localObject2).setId(103);
    localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    if (!localIntent.getBooleanExtra("open_show_back", true)) {
      ((ImageButton)localObject2).setVisibility(8);
    }
    ((ImageButton)localObject2).setImageBitmap(getDensityScaledBitmap("iVBORw0KGgoAAAANSUhEUgAAABIAAAAUCAYAAACAl21KAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ\nbWFnZVJlYWR5ccllPAAAApVJREFUeNqUVEuLkmEYfT6/9/MejjjeRhvvOo7XomLIzRTChEQU0Sa6\nLdoEA21azN6NzG9oIGE2bdwERYggrdqI2SLb5G5o0VwYRZGZ0a/zig5WNo4PHF4+5DnvOed9Htnq\n6irNUuVymeHQARbA5XA4vDirbAYCBQ4NYAIuarXacDQafbK0tJRqNBr32TkIBBxKwAgsKBQKTzgc\nfgCCO36/XxOPx6lYLBKbQsB/vwDYuI3FxcWby8vLDwOBwEIkEiFO4vV6qVarTSYCiYhDC5g5gdFo\nTMLGs2AwGIeSAUEoFCKLxUJqtZpEUfyTaJiDapiDU6lUBmKx2CM03YAKiRNAESFg0ul0BJunvWzM\nhgTMAXauAs13gXsgmOMEUEQul4sMBgMx9q8RNnxOPWDlBHa7/TpufQobbn47J0GoZDKZCApJEISJ\nmbKhEpter78GGy+gYgUklEgkiOdhs9lIo9H8l+CUCDcJaHjsdDpf+nw+3cgGvgnkgyDPU2xvb6+L\n5D96PJ4MpjwJVTQ/Pz8xh7NKgea+SqX6lMvlruzs7DxvtVq/jo6OSJblmYhEt9tNvV6PoETe3Nz8\ncnx8/BoKJazAZVzAuLVp+ZRKpbeDQej3+9RsNimdTsu7u7sHmUzmVT6fT1YqlQ/7+/t0cnIy3dr4\nB29AZrS2tibX6/XvqVTqdqFQuPUNBcuDC8+09ndxq7wR+yRD6Q+o28IDHMDuCmyr+UOM2+XWJhKN\nCnnR4eEhYdd62Wz2MxRtYaYMWI9LyE8YjcZUIl789brdLmFVuLXOxsbGe6vV+g7CglDokSSJqtXq\nm6lEo+L5dDodPu1yu93+ub6+vo3/pa8gu4px2RZm/asdvBC2nm8/9pLMZrMK1sXfAgwAtiLartJw\n+UAAAAAASUVORK5CYII="));
    ((ImageButton)localObject2).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = (WebView)Browser.this.findViewById(101);
        if (paramAnonymousView.canGoBack())
        {
          paramAnonymousView.goBack();
          return;
        }
        Browser.this.finish();
      }
    });
    localObject1 = new ImageButton(this);
    ((ImageButton)localObject1).setBackgroundColor(getResources().getColor(17170445));
    ((ImageButton)localObject1).setId(102);
    localObject2 = new LinearLayout.LayoutParams(-2, -1);
    ((LinearLayout.LayoutParams)localObject2).weight = 25.0F;
    ((LinearLayout.LayoutParams)localObject2).gravity = 16;
    localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    if (!localIntent.getBooleanExtra("open_show_forward", true)) {
      ((ImageButton)localObject1).setVisibility(8);
    }
    ((ImageButton)localObject1).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ((WebView)Browser.this.findViewById(101)).goForward();
      }
    });
    localObject1 = new ImageButton(this);
    ((ImageButton)localObject1).setImageBitmap(getDensityScaledBitmap("iVBORw0KGgoAAAANSUhEUgAAABMAAAAUCAYAAABvVQZ0AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ\nbWFnZVJlYWR5ccllPAAAA2NJREFUeNqMVF1Ik1EYPm7TpsIca84pGs6VrboYaeRPpFgXKUzBH4S8\nsLoIMVCpRERCAgfSZXpR2ZVJCEIgaIQm+MdCIkXRTTTnQG0qorCFm21zp+f9+IQ5NHvh4eP7vnOe\n877Ped5Xyv4dEYAMSK2rq/tkt9tlXq83Cu9BwC8+zyQ4B5wHLgAG4M7IyAgfHR31FhcXv8F7EXAZ\nUADSo43SMCLKQimS0GKDTqfLys7OvlldXZ2Vnp4uy8nJuZGWlmacnp52ejyeANZ4AB/AQ4kigSQg\nT6/XPzebzd8pk4WFBb6+vs6xkVP4/X6+s7PDx8bGPJWVlWasTxGTOJZRInC3oaHh88zMjLDh4OCA\n+3w+4RkIBPhRHB4e8u3tbd7f38+rqqpM2CcJ1YhKu4Vsvq2urnKIzN1uN3c4HHxqaso1Pj7+Y3d3\nVyAicqfTyaHhenNzc1Eo0VF5F2traz+srKwIRFtbW3xoaMjW1tZ2X9Q12WazcZfLxefn53lXV9fb\niooKjZjIsVAkJSXdIw1IFyqvt7d3pLy8PCFksXJgYIAPDg5aGxsbs8OzCY2E+vr692tra4LIFovl\nd15eXmrYqbKmpiZzuNAnRXJ3d7eVStjc3OQo7ZXos7OC5ImjZAA1EE0nSbRarUYulzNoxeCfb/gW\n+A+yGEAvuoC8ZieyoFKpVEulUgYPMVy3Qyzn8IwuiYWNXl5FQB4/9r0gIf+gxG34iEVFRbH8/HwS\nOPakmwovMTMz81JZWZm+oKDAkJiYGENk3o2NjSVYgsXFxbHc3NxCMXX5KYRkFRU2XzEajQZUxSQS\nCdvb2/tJZAfLy8uDyI4pFApmMpkKNRpNJr7rxEaWiaS0NhrQAuk1NTVPoDWDiRmS2RweHrYK9aO0\nFPjMvb+/z3EC7+vr+6VWqx/j321xauhEsa8DJjR9NxIQDI6xxFtbW58emx4tLS0PFhcXhT4kwomJ\nCS/67qNKparH/4fAo4yMDHNHR8c8EdDB1J8w+NRJVors7Ox8t7S0JCwkIH1utVr57Owsn5ub49Ru\ndBAdSC2HG7SVlJRoT7ssaXt7e+3k5KSLiIiQJgRFMBgUmpzIqE97enq+lJaWhrbciYwRKE+NW32G\nIVgcHx9/TSaTMfAxkLsx2ywge40J8zV8bP8VYACAQuluULZPjQAAAABJRU5ErkJggg=="));
    ((ImageButton)localObject1).setBackgroundColor(getResources().getColor(17170445));
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).weight = 25.0F;
    ((LinearLayout.LayoutParams)localObject2).gravity = 16;
    localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    if (!localIntent.getBooleanExtra("open_show_refresh", true)) {
      ((ImageButton)localObject1).setVisibility(8);
    }
    ((ImageButton)localObject1).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ((WebView)Browser.this.findViewById(101)).reload();
      }
    });
    localObject1 = new ImageButton(this);
    ((ImageButton)localObject1).setBackgroundColor(getResources().getColor(17170445));
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).weight = 25.0F;
    ((LinearLayout.LayoutParams)localObject2).gravity = 16;
    localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    ((ImageButton)localObject1).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Browser.this.finish();
      }
    });
    getWindow().requestFeature(2);
    CookieSyncManager.createInstance(this);
    CookieSyncManager.getInstance().startSync();
    localWebView.getSettings().setJavaScriptEnabled(true);
    localWebView.loadUrl(localIntent.getStringExtra("extra_url"));
    localWebView.setId(101);
    localWebView.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        ImageButton localImageButton = (ImageButton)Browser.this.findViewById(102);
        TapjoyLog.i("Mraid Browser", "onPageFinished: " + paramAnonymousString);
        if (paramAnonymousWebView.canGoForward())
        {
          localImageButton.setImageBitmap(Browser.this.getDensityScaledBitmap("iVBORw0KGgoAAAANSUhEUgAAABEAAAAUCAYAAABroNZJAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ\nbWFnZVJlYWR5ccllPAAAAq5JREFUeNqUlN9LmmEUx4++/ihKy6yZGEMjlExdEjgqQmm78ioGu41g\nu7Ftt+5mBF0Go8sIBvsTtggqGgODboK66aIwNi0lJ7p+2TT89b7Pvo/LaKucHTj4+LzP+bzne855\nXpnVan0ZiUSSoiimiCgBP4UXfD4fozpsbW2NhP7+/vdDQ0MvFLBkMnmBfQEuHhwclOHMbDbXhOAM\nCQ6HY8Lr9Tr8fv9ji8Xy6PDw8CKTyUh4LoNzUBkg9l/I4OCg2ePxkNPpfOB2u0cbGhoeQuJZsVjk\nWbHLrMTbYBVIb2/vhMvlMttsNurs7CSj0Si32+0W7D0BRMthOKuAS5cw6brEvyCQQk1NTdTY2Eht\nbW3U1dWlxr6rp6dnJJVKldLpdBEx8kuJYrVeNyAcwE0QBGpubqb29nbq7u7WDgwMjABs39/fz+Ry\nOV4rVoXx9a0QbjKZjJRKJWm1WjIYDIRRMKJeT/ECQzQazZTLZZ4Vb0D5Tsh1mFqtJp1ORyaTSejr\n67MixouMFLFY7AeOnCuoTsMYkV6vJ41GwxugR1cnNzY2POvr66/qhlzPChlRS0tLHuuv6F74XpCq\nYRg/7e7uvh0eHo7wwsrvE5zP53cQPIr6PMcV+T41NVUZvrog6MTPeDz+BoXn1yI0MzMjLS8v09bW\n1p961QpmjJWOj48/rKysvBsfHz+bm5tji4uLBBBls1nCzaeamUD3F1Tf3dHR8RoFPQ0GgywUCtHe\n3h5/dgWoQtg/ur+Fw+Fnra2tfoz7zvT0NFtdXaXt7W06Ojri0m68UI7+5/lCkqRfiUQiGAgEnPj9\nPDs7K3Ldm5ubhP9UKBS4vFuzlqtUqnPo+7i0tGTFpeMfqALXjSEijHdF+13BV/MzNjamWVhYyM7P\nzzOMcSXw5OSESqUS1ft5/C3AAL39YeI2ufApAAAAAElFTkSuQmCC"));
          return;
        }
        localImageButton.setImageBitmap(Browser.this.getDensityScaledBitmap("iVBORw0KGgoAAAANSUhEUgAAABEAAAAUCAYAAABroNZJAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ\nbWFnZVJlYWR5ccllPAAAAqNJREFUeNqUlEtrE1EUx8+8EjNT27zTaMw0k6RJGpu+VqIi4k7rQtyK\nIn6FrEraRhTET+AnENxUXLpWcFfRhaCbCpY0Lc3DpE07c+dxPTckojTG5sAfhnvP/fE/99wz3IV4\n/Fl1Z+eDZVlVAKigmihjwuejcIpoNZsg+AOBlz6//2E4EonWazUGElC2oesWip7xeIZCMAeEUDhc\npBw3LkqubDqdvs1xQNqt1iHucygGshBEh0LQQREBY2fHx8F2HLfkcl1OJKaut1vtCiEGy6M9V/Yg\nWBcSDIWKHM+PyYoMLpcbJEkCYpoT/mDg1rloNF+tVrcwV0Q5PZjzZ4l/QdiGIAjAoxiI43jOtKyY\nOqXeVRRFrmPgGb5Xot2/rxMQnhe6dA4vRhDFLsymjkApzGta8iYhpNnpdAgrsQ9j3wMh/cB1EAUR\ny3QBsSyPMqbcUFX1UrPRqJimyUAOgw2F9GzhOsLQFXNHiBmMRCeXg8FgfG939wtmtLnszMwuJ4gR\nr98Hoij993E5jgPoAvSjI1A8ngPT0B+JMGIwV263G2RZhulU8lNle/vdyBAWc4XCdijgv7deKr1n\nFzsSJB6L6ZnMdHFtZeVFbrbgxBMa/Pi+BaeCeL1eZ3529tWT8vr9iwsLdiKVhka9BqZBuvtDIRJ2\nY3Fh/jM4dBkBlVQmSxv7NTAMHWzbBkrpcEg+l9ufjIQflFdX32byeRpTVfiJY29Z5u/D/TgBOR+N\nkmw287xcKj2eKczZqqZBs97AthKg2N5B48zjvLOnCzJO6LWrV95g330bG6/XtPS0zeo+aLeBoH3n\nH4CuE5wTktS0r1pSu/O0XP6WzuZop3OIg2Vg3dYJ64OCW1xamvy4ubmXwsOGfgz68TFY+CIdeqq/\nY/f3+EuAAQARwzy3ZhCNHQAAAABJRU5ErkJggg=="));
      }
      
      public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        super.onPageStarted(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        ((ImageButton)Browser.this.findViewById(102)).setImageBitmap(Browser.this.getDensityScaledBitmap("iVBORw0KGgoAAAANSUhEUgAAABEAAAAUCAYAAABroNZJAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJ\nbWFnZVJlYWR5ccllPAAAAqNJREFUeNqUlEtrE1EUx8+8EjNT27zTaMw0k6RJGpu+VqIi4k7rQtyK\nIn6FrEraRhTET+AnENxUXLpWcFfRhaCbCpY0Lc3DpE07c+dxPTckojTG5sAfhnvP/fE/99wz3IV4\n/Fl1Z+eDZVlVAKigmihjwuejcIpoNZsg+AOBlz6//2E4EonWazUGElC2oesWip7xeIZCMAeEUDhc\npBw3LkqubDqdvs1xQNqt1iHucygGshBEh0LQQREBY2fHx8F2HLfkcl1OJKaut1vtCiEGy6M9V/Yg\nWBcSDIWKHM+PyYoMLpcbJEkCYpoT/mDg1rloNF+tVrcwV0Q5PZjzZ4l/QdiGIAjAoxiI43jOtKyY\nOqXeVRRFrmPgGb5Xot2/rxMQnhe6dA4vRhDFLsymjkApzGta8iYhpNnpdAgrsQ9j3wMh/cB1EAUR\ny3QBsSyPMqbcUFX1UrPRqJimyUAOgw2F9GzhOsLQFXNHiBmMRCeXg8FgfG939wtmtLnszMwuJ4gR\nr98Hoij993E5jgPoAvSjI1A8ngPT0B+JMGIwV263G2RZhulU8lNle/vdyBAWc4XCdijgv7deKr1n\nFzsSJB6L6ZnMdHFtZeVFbrbgxBMa/Pi+BaeCeL1eZ3529tWT8vr9iwsLdiKVhka9BqZBuvtDIRJ2\nY3Fh/jM4dBkBlVQmSxv7NTAMHWzbBkrpcEg+l9ufjIQflFdX32byeRpTVfiJY29Z5u/D/TgBOR+N\nkmw287xcKj2eKczZqqZBs97AthKg2N5B48zjvLOnCzJO6LWrV95g330bG6/XtPS0zeo+aLeBoH3n\nH4CuE5wTktS0r1pSu/O0XP6WzuZop3OIg2Vg3dYJ64OCW1xamvy4ubmXwsOGfgz68TFY+CIdeqq/\nY/f3+EuAAQARwzy3ZhCNHQAAAABJRU5ErkJggg=="));
      }
      
      public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        TapjoyLog.i("Mraid Browser", "WebView error: " + paramAnonymousString1);
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        paramAnonymousWebView.loadUrl(paramAnonymousString);
        return true;
      }
    });
    setContentView(paramBundle);
    localWebView.setWebChromeClient(new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        Activity localActivity = (Activity)paramAnonymousWebView.getContext();
        localActivity.setTitle("Loading...");
        localActivity.setProgress(paramAnonymousInt * 100);
        if (paramAnonymousInt == 100) {
          localActivity.setTitle(paramAnonymousWebView.getUrl());
        }
      }
    });
  }
  
  protected void onPause()
  {
    super.onPause();
    CookieSyncManager.getInstance().stopSync();
  }
  
  protected void onResume()
  {
    super.onResume();
    CookieSyncManager.getInstance().startSync();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/mraid/view/Browser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */