package com.magmamobile.game.engine;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.magmamobile.game.engine.ex.Vector2D;
import com.magmamobile.game.engine.features.FeatureWrapper;
import com.magmamobile.game.engine.features.FeatureWrapper01;
import com.magmamobile.game.engine.features.FeatureWrapper04;
import com.magmamobile.game.engine.features.FeatureWrapper05;
import com.magmamobile.game.engine.features.FeatureWrapper11;
import com.magmamobile.game.engine.features.FeatureWrapper18;
import com.magmamobile.game.engine.features.FeatureWrapper19;
import com.magmamobile.game.engine.thirdparty.GoogleAnalytics;
import com.magmamobile.game.engine.tmp.AnimPackage;
import com.magmamobile.game.engine.tmp.text.StrokeTextDrawer;
import com.magmamobile.mmusia.activities.MMUSIAMoreGamesActivity;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class Game
{
  public static final int CENTERED = Integer.MIN_VALUE;
  public static final byte COLOR_MODE_AUTO = 0;
  public static final byte COLOR_MODE_HIGH = 2;
  public static final byte COLOR_MODE_LOW = 1;
  public static final boolean DEBUG = false;
  public static final int ENGINE_MODE_BALANCED = 0;
  public static final int ENGINE_MODE_TEMPORAL = 1;
  protected static final int EVENT_HIDE_ADS = 65538;
  protected static final int EVENT_SHOW_ADS = 65537;
  protected static final int EVENT_SHOW_TOAST = 7;
  public static final long GAME_PAUSE = 1000L;
  public static final int GAME_STAGE_MAIN = 0;
  public static final int GAME_STAGE_QUIT = -1;
  public static final int MAX_VOLUME = 15;
  public static final byte ORIENTATION_HORIZONTAL = 1;
  public static final int ORIENTATION_LANDSCAPE = 0;
  public static final int ORIENTATION_LANDSCAPE_REVERSE = 8;
  public static final int ORIENTATION_LANDSCAPE_SENSOR = 6;
  public static final int ORIENTATION_NOTSET = -1;
  public static final int ORIENTATION_PORTRAIT = 1;
  public static final int ORIENTATION_PORTRAIT_REVERSE = 9;
  public static final int ORIENTATION_PORTRAIT_SENSOR = 7;
  public static final int ORIENTATION_SENSOR = 4;
  public static final byte ORIENTATION_VERTICAL = 0;
  protected static Class<?> Rdrawable;
  protected static Class<?> Rid;
  protected static Class<?> Rlayout;
  protected static Class<?> Rstring;
  public static final int SOUND_STREAM = 3;
  public static final int TOUCH_ACTION_DOWN = 1;
  public static final int TOUCH_ACTION_MOVE = 2;
  public static final int TOUCH_ACTION_NONE = 0;
  public static final int TOUCH_ACTION_UP = 3;
  public static final int TOUCH_MODE_MANAGED = 0;
  public static final int TOUCH_MODE_TOPLEVEL = 2;
  public static final int TOUCH_MODE_UNMANAGED = 1;
  private static final long WAIT_TIMEOUT = 3000L;
  protected static Paint _alphaPaint;
  protected static Paint _bitBltPaint;
  protected static int _touchmode;
  private static long acCurTime;
  private static long acDeltaTime;
  private static boolean acLoop;
  private static long acNextTime;
  private static boolean acting;
  public static long actionFreq;
  public static GameRate actionRate;
  private static Object actionSync;
  public static Thread actionThread;
  protected static GameActivity activity;
  public static AdLayout adBanner;
  public static AdLayout adSquare;
  public static int androidSDKVersion;
  public static String appPackageName;
  public static int appVersionCode;
  public static String appVersionName;
  protected static GameApplication application;
  protected static SparseArray<Bitmap> bitmapCache;
  public static Bitmap buffer;
  private static int charLastSize;
  private static Bitmap charLayer;
  private static int charRealX;
  private static int charRealY;
  private static int charXSpace;
  private static int charYSpace;
  protected static int colorMode;
  protected static DebugToolReceiver debugToolReceiver;
  protected static float density;
  protected static int displayHeight;
  protected static int displayWidth;
  private static RectF dr = new RectF();
  public static Canvas drawCanvas;
  public static Rect dstRect;
  public static PaintFlagsDrawFilter dwfilter;
  protected static int engineMode;
  protected static FeatureWrapper featureWrapper;
  public static GameRenderMode gameRenderMode;
  protected static String hash;
  protected static boolean hideActionBar;
  public static SurfaceHolder holder;
  protected static boolean isDebuggable;
  public static boolean isDirty;
  protected static boolean isiDTouch;
  protected static boolean lateResume;
  public static GameLayout layout;
  protected static Locale locale;
  public static int mBufferCH;
  public static int mBufferCW;
  public static int mBufferDiagonal;
  public static int mBufferHeight;
  public static int mBufferWidth;
  public static boolean mCLipFix;
  public static Canvas mCanvas;
  protected static float mDivRatioX;
  protected static float mDivRatioY;
  public static GameMessageHandler mHandler;
  protected static float mMulRatioX;
  protected static float mMulRatioY;
  public static boolean mNoStretch;
  public static Thread mThread;
  protected static MarketWrapper marketWrapper;
  protected static Matrix matrix;
  protected static String metaMarket;
  protected static boolean metaiDTGV;
  private static MMQiClient mmqi;
  protected static float multiplier;
  protected static SparseArray<Music> musicCache;
  protected static int ninePatchSize1 = 16;
  protected static int ninePatchSize2 = 32;
  protected static int ninePatchSize3 = 48;
  private static int ninePatchStyle = 0;
  public static boolean opAlias;
  public static boolean opFirst;
  public static boolean opHaptic;
  private static boolean opLoaded;
  public static boolean opMusic;
  public static boolean opSound;
  public static boolean opStretch;
  public static boolean opVibrate;
  public static int opVolume;
  public static boolean opWakeup;
  public static int orientation;
  protected static PackageInfo packageInfo;
  private static int paintClr;
  private static Paint paintColor;
  protected static AppParameters parameters;
  public static boolean paused;
  protected static SharedPreferences preferences;
  protected static Rect rcDst;
  protected static Rect rcSrc;
  private static long reCurTime;
  private static long reDeltaTime;
  private static boolean reLoop;
  private static long reNextTime;
  public static boolean ready;
  public static long renderFreq;
  public static GameRate renderRate;
  private static Object renderSync;
  public static Thread renderThread;
  private static boolean rendering;
  protected static ErrorReporter reporter;
  private static String[] res_cache;
  private static String[] res_d;
  private static String[] res_l;
  private static String res_lang;
  private static int res_langid;
  private static int[][] res_t;
  public static boolean running;
  public static AudioManager soundMngr;
  public static SoundPool soundPool;
  protected static String sourceDir;
  public static Rect srcRect;
  private static StrokeTextDrawer stp;
  private static float stpf;
  protected static int surfaceHeight;
  protected static int surfaceWidth;
  private static Rect textBound;
  public static long tick;
  public static Typeface typeface;
  private static Vibrator vibrator;
  public static SurfaceView view;
  
  public static final void OnSystemUiVisibility(View paramView, int paramInt)
  {
    if ((paramInt & 0x1) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      hideActionBar = bool;
      return;
    }
  }
  
  public static final boolean OutOfBound(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramInt1 < -paramInt3) || (paramInt2 < -paramInt4) || (paramInt1 + paramInt3 > mBufferWidth) || (paramInt2 + paramInt4 > mBufferHeight);
  }
  
  public static final void Quit()
  {
    StageManager.setStage(-1);
  }
  
  public static final void bitBltBitmap(Bitmap paramBitmap)
  {
    mCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, _bitBltPaint);
  }
  
  public static final void bitBltBitmap(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    mCanvas.drawBitmap(paramBitmap, paramFloat1, paramFloat2, _bitBltPaint);
  }
  
  public static final int bufferToScreenX(int paramInt)
  {
    return (int)(mDivRatioX * paramInt);
  }
  
  public static final int bufferToScreenY(int paramInt)
  {
    return (int)(mDivRatioY * paramInt);
  }
  
  public static final int centerX(int paramInt)
  {
    return mBufferWidth - paramInt >> 1;
  }
  
  public static final int centerY(int paramInt)
  {
    return mBufferHeight - paramInt >> 1;
  }
  
  private static void checkErrorReporter(Context paramContext)
  {
    if (reporter != null) {
      reporter.CheckErrorAndSendMail(paramContext);
    }
  }
  
  public static final void clearBitmapPixel(Bitmap paramBitmap)
  {
    new Canvas(paramBitmap).drawColor(0, PorterDuff.Mode.SRC);
  }
  
  public static final void clipClear()
  {
    mCanvas.clipRect(0.0F, 0.0F, mBufferWidth, mBufferHeight, Region.Op.REPLACE);
  }
  
  public static final void clipRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mCanvas.clipRect(paramInt1, paramInt2, paramInt3, paramInt4, Region.Op.REPLACE);
  }
  
  public static final void clipTranslate(float paramFloat1, float paramFloat2)
  {
    mCanvas.translate(paramFloat1, paramFloat2);
  }
  
  public static final Bitmap cloneBitmap(Bitmap paramBitmap)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), getBitmapOptions().inPreferredConfig);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    return localBitmap;
  }
  
  public static final Bitmap createBitmap(int paramInt1, int paramInt2)
  {
    return Bitmap.createBitmap(paramInt1, paramInt2, getBitmapOptions().inPreferredConfig);
  }
  
  public static final Bitmap createBitmap(byte[] paramArrayOfByte)
  {
    return BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, getBitmapOptions());
  }
  
  public static final float dpi(float paramFloat)
  {
    if (density == 1.0F) {
      return paramFloat;
    }
    return paramFloat * density;
  }
  
  public static final void drawArc(RectF paramRectF, float paramFloat1, float paramFloat2, boolean paramBoolean, Paint paramPaint)
  {
    mCanvas.drawArc(paramRectF, paramFloat1, paramFloat2, paramBoolean, paramPaint);
  }
  
  public static final void drawBackground(int paramInt)
  {
    mCanvas.drawBitmap(getBitmap(paramInt), 0.0F, 0.0F, _bitBltPaint);
  }
  
  public static final void drawBackground(int paramInt, float paramFloat1, float paramFloat2)
  {
    mCanvas.drawBitmap(getBitmap(paramInt), paramFloat1, paramFloat2, _bitBltPaint);
  }
  
  public static final void drawBitmap(Bitmap paramBitmap)
  {
    mCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
  }
  
  public static final void drawBitmap(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    mCanvas.drawBitmap(paramBitmap, paramFloat1, paramFloat2, null);
  }
  
  public static final void drawBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    mCanvas.drawBitmap(paramBitmap, paramInt1, paramInt2, null);
  }
  
  public static final void drawBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, float paramFloat, Paint paramPaint)
  {
    matrix.reset();
    if (paramInt3 != 0) {
      matrix.postRotate(paramInt3);
    }
    matrix.preTranslate(-paramBitmap.getWidth() >> 1, -paramBitmap.getHeight() >> 1);
    if (paramFloat != 1.0F) {
      matrix.postScale(paramFloat, paramFloat);
    }
    matrix.postTranslate(paramInt1, paramInt2);
    mCanvas.drawBitmap(paramBitmap, matrix, paramPaint);
  }
  
  public static final void drawBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    rcSrc.set(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    rcDst.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    mCanvas.drawBitmap(paramBitmap, rcSrc, rcDst, null);
  }
  
  public static final void drawBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, Paint paramPaint)
  {
    rcSrc.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    rcDst.set(paramInt5, paramInt6, paramInt5 + paramInt7, paramInt6 + paramInt8);
    mCanvas.drawBitmap(paramBitmap, rcSrc, rcDst, paramPaint);
  }
  
  public static final void drawBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    matrix.reset();
    if (paramInt5 != 0) {
      matrix.postRotate(paramInt5);
    }
    matrix.preTranslate(paramInt3, paramInt4);
    matrix.postTranslate(paramInt1, paramInt2);
    mCanvas.drawBitmap(paramBitmap, matrix, paramPaint);
  }
  
  public static final void drawBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint paramPaint)
  {
    rcSrc.set(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    rcDst.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    mCanvas.drawBitmap(paramBitmap, rcSrc, rcDst, paramPaint);
  }
  
  public static final void drawBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint)
  {
    matrix.reset();
    matrix.postRotate(paramInt3);
    matrix.preTranslate(-paramBitmap.getWidth() >> 1, -paramBitmap.getHeight() >> 1);
    matrix.postTranslate(paramInt1, paramInt2);
    mCanvas.drawBitmap(paramBitmap, matrix, paramPaint);
  }
  
  public static final void drawBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, Paint paramPaint)
  {
    mCanvas.drawBitmap(paramBitmap, paramInt1, paramInt2, paramPaint);
  }
  
  public static final void drawBitmap(Bitmap paramBitmap, Matrix paramMatrix, Paint paramPaint)
  {
    mCanvas.drawBitmap(paramBitmap, paramMatrix, paramPaint);
  }
  
  public static final void drawBitmap(Bitmap paramBitmap, Vector2D paramVector2D, float paramFloat1, float paramFloat2)
  {
    matrix.reset();
    if (paramFloat1 != 0.0F) {
      matrix.postRotate(paramFloat1);
    }
    matrix.preTranslate(-paramBitmap.getWidth() >> 1, -paramBitmap.getHeight() >> 1);
    if (paramFloat2 != 1.0F) {
      matrix.postScale(paramFloat2, paramFloat2);
    }
    matrix.postTranslate(paramVector2D.x, paramVector2D.y);
    mCanvas.drawBitmap(paramBitmap, matrix, null);
  }
  
  public static final void drawBitmap(Bitmap paramBitmap, Vector2D paramVector2D, float paramFloat1, float paramFloat2, int paramInt)
  {
    matrix.reset();
    if (paramFloat1 != 0.0F) {
      matrix.postRotate(paramFloat1);
    }
    matrix.preTranslate(-paramBitmap.getWidth() >> 1, -paramBitmap.getHeight() >> 1);
    if (paramFloat2 != 1.0F) {
      matrix.postScale(paramFloat2, paramFloat2);
    }
    matrix.postTranslate(paramVector2D.x, paramVector2D.y);
    _alphaPaint.setAlpha(paramInt);
    mCanvas.drawBitmap(paramBitmap, matrix, _alphaPaint);
  }
  
  public static void drawBitmap9(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint paramPaint)
  {
    Rect localRect1 = rcSrc;
    Rect localRect2 = rcDst;
    int k = paramInt3 - ninePatchSize2;
    int m = paramInt4 - ninePatchSize2;
    if (ninePatchStyle == 0)
    {
      localRect1.set(0, 0, ninePatchSize1, ninePatchSize1);
      localRect2.set(paramInt1, paramInt2, ninePatchSize1 + paramInt1, ninePatchSize1 + paramInt2);
      mCanvas.drawBitmap(paramBitmap, localRect1, localRect2, paramPaint);
      if (k > 0)
      {
        localRect1.set(ninePatchSize1, 0, ninePatchSize2, ninePatchSize1);
        localRect2.set(ninePatchSize1 + paramInt1, paramInt2, ninePatchSize1 + paramInt1 + k, ninePatchSize1 + paramInt2);
        mCanvas.drawBitmap(paramBitmap, localRect1, localRect2, paramPaint);
      }
      localRect1.set(ninePatchSize2, 0, ninePatchSize3, ninePatchSize1);
      localRect2.set(paramInt1 + paramInt3 - ninePatchSize1, paramInt2, paramInt1 + paramInt3, ninePatchSize1 + paramInt2);
      mCanvas.drawBitmap(paramBitmap, localRect1, localRect2, paramPaint);
      if (m > 0)
      {
        localRect1.set(0, ninePatchSize1, ninePatchSize1, ninePatchSize2);
        localRect2.set(paramInt1, ninePatchSize1 + paramInt2, ninePatchSize1 + paramInt1, ninePatchSize1 + paramInt2 + m);
        mCanvas.drawBitmap(paramBitmap, localRect1, localRect2, paramPaint);
        if (k > 0)
        {
          localRect1.set(ninePatchSize1, ninePatchSize1, ninePatchSize2, ninePatchSize2);
          localRect2.set(ninePatchSize1 + paramInt1, ninePatchSize1 + paramInt2, ninePatchSize1 + paramInt1 + k, ninePatchSize1 + paramInt2 + m);
          mCanvas.drawBitmap(paramBitmap, localRect1, localRect2, paramPaint);
        }
        localRect1.set(ninePatchSize2, ninePatchSize1, ninePatchSize3, ninePatchSize2);
        localRect2.set(paramInt1 + paramInt3 - ninePatchSize1, ninePatchSize1 + paramInt2, paramInt1 + paramInt3, ninePatchSize1 + paramInt2 + m);
        mCanvas.drawBitmap(paramBitmap, localRect1, localRect2, paramPaint);
      }
      localRect1.set(0, ninePatchSize2, ninePatchSize1, ninePatchSize3);
      localRect2.set(paramInt1, paramInt2 + paramInt4 - ninePatchSize1, ninePatchSize1 + paramInt1, paramInt2 + paramInt4);
      mCanvas.drawBitmap(paramBitmap, localRect1, localRect2, paramPaint);
      if (k > 0)
      {
        localRect1.set(ninePatchSize1, ninePatchSize2, ninePatchSize2, ninePatchSize3);
        localRect2.set(ninePatchSize1 + paramInt1, paramInt2 + paramInt4 - ninePatchSize1, ninePatchSize1 + paramInt1 + k, paramInt2 + paramInt4);
        mCanvas.drawBitmap(paramBitmap, localRect1, localRect2, paramPaint);
      }
      localRect1.set(ninePatchSize2, ninePatchSize2, ninePatchSize3, ninePatchSize3);
      localRect2.set(paramInt1 + paramInt3 - ninePatchSize1, paramInt2 + paramInt4 - ninePatchSize1, paramInt1 + paramInt3, paramInt2 + paramInt4);
      mCanvas.drawBitmap(paramBitmap, localRect1, localRect2, paramPaint);
    }
    while (ninePatchStyle != 1) {
      return;
    }
    localRect1.set(0, 0, ninePatchSize1, ninePatchSize1);
    localRect2.set(paramInt1, paramInt2, ninePatchSize1 + paramInt1, ninePatchSize1 + paramInt2);
    mCanvas.drawBitmap(paramBitmap, localRect1, localRect2, paramPaint);
    int i;
    if (k > 0)
    {
      i = paramInt1 + ninePatchSize1;
      if (i < ninePatchSize1 + paramInt1 + k) {}
    }
    else
    {
      localRect1.set(ninePatchSize2, 0, ninePatchSize3, ninePatchSize1);
      localRect2.set(paramInt1 + paramInt3 - ninePatchSize1, paramInt2, paramInt1 + paramInt3, ninePatchSize1 + paramInt2);
      mCanvas.drawBitmap(paramBitmap, localRect1, localRect2, paramPaint);
      if (m > 0)
      {
        localRect1.set(0, ninePatchSize1, ninePatchSize1, ninePatchSize2);
        localRect2.set(paramInt1, ninePatchSize1 + paramInt2, ninePatchSize1 + paramInt1, ninePatchSize1 + paramInt2 + m);
        mCanvas.drawBitmap(paramBitmap, localRect1, localRect2, paramPaint);
        if (k > 0)
        {
          i = paramInt1 + ninePatchSize1;
          if (i < ninePatchSize1 + paramInt1 + k) {
            break label991;
          }
        }
        localRect1.set(ninePatchSize2, ninePatchSize1, ninePatchSize3, ninePatchSize2);
        localRect2.set(paramInt1 + paramInt3 - ninePatchSize1, ninePatchSize1 + paramInt2, paramInt1 + paramInt3, ninePatchSize1 + paramInt2 + m);
        mCanvas.drawBitmap(paramBitmap, localRect1, localRect2, paramPaint);
      }
      localRect1.set(0, ninePatchSize2, ninePatchSize1, ninePatchSize3);
      localRect2.set(paramInt1, paramInt2 + paramInt4 - ninePatchSize1, ninePatchSize1 + paramInt1, paramInt2 + paramInt4);
      mCanvas.drawBitmap(paramBitmap, localRect1, localRect2, paramPaint);
      if (k > 0) {
        i = paramInt1 + ninePatchSize1;
      }
    }
    for (;;)
    {
      if (i >= ninePatchSize1 + paramInt1 + k)
      {
        localRect1.set(ninePatchSize2, ninePatchSize2, ninePatchSize3, ninePatchSize3);
        localRect2.set(paramInt1 + paramInt3 - ninePatchSize1, paramInt2 + paramInt4 - ninePatchSize1, paramInt1 + paramInt3, paramInt2 + paramInt4);
        mCanvas.drawBitmap(paramBitmap, localRect1, localRect2, paramPaint);
        return;
        localRect1.set(ninePatchSize1, 0, ninePatchSize2, ninePatchSize1);
        localRect2.set(i, paramInt2, ninePatchSize1 + i, ninePatchSize1 + paramInt2);
        mCanvas.drawBitmap(paramBitmap, localRect1, localRect2, paramPaint);
        i += ninePatchSize1;
        break;
        label991:
        int j = paramInt2 + ninePatchSize1;
        for (;;)
        {
          if (j >= ninePatchSize1 + paramInt2 + m)
          {
            i += ninePatchSize1;
            break;
          }
          localRect1.set(ninePatchSize1, ninePatchSize1, ninePatchSize2, ninePatchSize2);
          localRect2.set(i, j, ninePatchSize1 + i, ninePatchSize1 + j);
          mCanvas.drawBitmap(paramBitmap, localRect1, localRect2, paramPaint);
          j += ninePatchSize1;
        }
      }
      localRect1.set(ninePatchSize1, ninePatchSize2, ninePatchSize2, ninePatchSize3);
      localRect2.set(i, paramInt2 + paramInt4 - ninePatchSize1, ninePatchSize1 + i, paramInt2 + paramInt4);
      mCanvas.drawBitmap(paramBitmap, localRect1, localRect2, paramPaint);
      i += ninePatchSize1;
    }
  }
  
  public static void drawBitmapAlpha(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    _alphaPaint.setAlpha(paramInt3);
    mCanvas.drawBitmap(paramBitmap, paramInt1, paramInt2, _alphaPaint);
  }
  
  public static void drawBitmapAlpha(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, float paramFloat, int paramInt4)
  {
    _alphaPaint.setAlpha(paramInt4);
    matrix.reset();
    if (paramInt3 != 0) {
      matrix.postRotate(paramInt3);
    }
    matrix.preTranslate(-paramBitmap.getWidth() >> 1, -paramBitmap.getHeight() >> 1);
    if (paramFloat != 1.0F) {
      matrix.postScale(paramFloat, paramFloat);
    }
    matrix.postTranslate(paramInt1, paramInt2);
    mCanvas.drawBitmap(paramBitmap, matrix, _alphaPaint);
  }
  
  public static void drawBitmapAlpha(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    _alphaPaint.setAlpha(paramInt5);
    rcSrc.set(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    rcDst.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    mCanvas.drawBitmap(paramBitmap, rcSrc, rcDst, _alphaPaint);
  }
  
  public static void drawBitmapCentered(Bitmap paramBitmap)
  {
    mCanvas.drawBitmap(paramBitmap, mBufferWidth - paramBitmap.getWidth() >> 1, mBufferHeight - paramBitmap.getHeight() >> 1, null);
  }
  
  public static void drawBitmapCentered(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramInt1 == Integer.MIN_VALUE)
    {
      if (paramInt2 == Integer.MIN_VALUE)
      {
        mCanvas.drawBitmap(paramBitmap, mBufferWidth - paramBitmap.getWidth() >> 1, mBufferHeight - paramBitmap.getHeight() >> 1, null);
        return;
      }
      mCanvas.drawBitmap(paramBitmap, mBufferWidth - paramBitmap.getWidth() >> 1, paramInt2, null);
      return;
    }
    if (paramInt2 == Integer.MIN_VALUE)
    {
      mCanvas.drawBitmap(paramBitmap, paramInt1, mBufferHeight - paramBitmap.getHeight() >> 1, null);
      return;
    }
    mCanvas.drawBitmap(paramBitmap, paramInt1, paramInt2, null);
  }
  
  public static void drawBitmapCentered(Bitmap paramBitmap, int paramInt1, int paramInt2, Paint paramPaint)
  {
    if (paramInt1 == Integer.MIN_VALUE)
    {
      if (paramInt2 == Integer.MIN_VALUE)
      {
        mCanvas.drawBitmap(paramBitmap, mBufferWidth - paramBitmap.getWidth() >> 1, mBufferHeight - paramBitmap.getHeight() >> 1, paramPaint);
        return;
      }
      mCanvas.drawBitmap(paramBitmap, mBufferWidth - paramBitmap.getWidth() >> 1, paramInt2, paramPaint);
      return;
    }
    if (paramInt2 == Integer.MIN_VALUE)
    {
      mCanvas.drawBitmap(paramBitmap, paramInt1, mBufferHeight - paramBitmap.getHeight() >> 1, paramPaint);
      return;
    }
    mCanvas.drawBitmap(paramBitmap, paramInt1, paramInt2, paramPaint);
  }
  
  public static void drawBitmapCentered(Bitmap paramBitmap, Paint paramPaint)
  {
    mCanvas.drawBitmap(paramBitmap, mBufferWidth - paramBitmap.getWidth() >> 1, mBufferHeight - paramBitmap.getHeight() >> 1, paramPaint);
  }
  
  public static void drawBitmapFlipped(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, Paint paramPaint)
  {
    int j = -1;
    matrix.reset();
    Matrix localMatrix = matrix;
    int i;
    float f;
    if (paramBoolean1)
    {
      i = -1;
      f = i;
      if (!paramBoolean2) {
        break label108;
      }
      i = j;
      label35:
      localMatrix.setScale(f, i);
      localMatrix = matrix;
      if (!paramBoolean1) {
        break label114;
      }
      i = paramBitmap.getWidth();
      label60:
      f = i + paramInt1;
      if (!paramBoolean2) {
        break label120;
      }
    }
    label108:
    label114:
    label120:
    for (paramInt1 = paramBitmap.getHeight();; paramInt1 = 0)
    {
      localMatrix.postTranslate(f, paramInt1 + paramInt2);
      mCanvas.drawBitmap(paramBitmap, matrix, paramPaint);
      return;
      i = 1;
      break;
      i = 1;
      break label35;
      i = 0;
      break label60;
    }
  }
  
  public static void drawBitmapFlippedAlpha(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    int i = -1;
    _alphaPaint.setAlpha(paramInt3);
    matrix.reset();
    Matrix localMatrix = matrix;
    float f;
    if (paramBoolean1)
    {
      paramInt3 = -1;
      f = paramInt3;
      if (!paramBoolean2) {
        break label117;
      }
      paramInt3 = i;
      label43:
      localMatrix.setScale(f, paramInt3);
      localMatrix = matrix;
      if (!paramBoolean1) {
        break label123;
      }
      paramInt3 = paramBitmap.getWidth();
      label68:
      f = paramInt3 + paramInt1;
      if (!paramBoolean2) {
        break label129;
      }
    }
    label117:
    label123:
    label129:
    for (paramInt1 = paramBitmap.getHeight();; paramInt1 = 0)
    {
      localMatrix.postTranslate(f, paramInt1 + paramInt2);
      mCanvas.drawBitmap(paramBitmap, matrix, _alphaPaint);
      return;
      paramInt3 = 1;
      break;
      paramInt3 = 1;
      break label43;
      paramInt3 = 0;
      break label68;
    }
  }
  
  public static void drawBitmapFlippedAlpha(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, int paramInt4)
  {
    int i = -1;
    _alphaPaint.setAlpha(paramInt3);
    matrix.reset();
    Matrix localMatrix = matrix;
    float f;
    if (paramBoolean1)
    {
      paramInt3 = -1;
      f = paramInt3;
      if (!paramBoolean2) {
        break label150;
      }
      paramInt3 = i;
      label43:
      localMatrix.setScale(f, paramInt3);
      matrix.postRotate(paramInt4);
      matrix.preTranslate(-paramBitmap.getWidth() >> 1, -paramBitmap.getHeight() >> 1);
      localMatrix = matrix;
      if (!paramBoolean1) {
        break label156;
      }
      paramInt3 = paramBitmap.getWidth();
      label101:
      f = paramInt3 + paramInt1;
      if (!paramBoolean2) {
        break label162;
      }
    }
    label150:
    label156:
    label162:
    for (paramInt1 = paramBitmap.getHeight();; paramInt1 = 0)
    {
      localMatrix.postTranslate(f, paramInt1 + paramInt2);
      mCanvas.drawBitmap(paramBitmap, matrix, _alphaPaint);
      return;
      paramInt3 = 1;
      break;
      paramInt3 = 1;
      break label43;
      paramInt3 = 0;
      break label101;
    }
  }
  
  public static final void drawBitmapLine(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint paramPaint)
  {
    paramInt3 -= paramInt1;
    paramInt4 -= paramInt2;
    int i = -paramBitmap.getHeight();
    float f1 = (float)Math.sqrt(paramInt3 * paramInt3 + paramInt4 * paramInt4) / paramBitmap.getWidth();
    float f2 = (float)Math.atan2(paramInt4, paramInt3);
    matrix.reset();
    matrix.preTranslate(0.0F, i >> 1);
    matrix.postScale(f1, 1.0F);
    matrix.postRotate(f2 * 57.29578F);
    matrix.postTranslate(paramInt1, paramInt2);
    mCanvas.drawBitmap(paramBitmap, matrix, paramPaint);
  }
  
  public static void drawBitmapLineAngle(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint paramPaint)
  {
    paramInt3 -= paramInt1;
    paramInt4 -= paramInt2;
    int i = -paramBitmap.getHeight();
    int j = (int)Math.sqrt(paramInt3 * paramInt3 + paramInt4 * paramInt4);
    float f = (float)Math.atan2(paramInt4, paramInt3);
    rcSrc.set(0, 0, j, paramBitmap.getHeight());
    mCanvas.save();
    mCanvas.translate(paramInt1, paramInt2);
    mCanvas.rotate(f * 57.29578F);
    mCanvas.translate(0.0F, i >> 1);
    mCanvas.drawBitmap(paramBitmap, rcSrc, rcSrc, paramPaint);
    mCanvas.restore();
  }
  
  public static void drawBitmapParcel(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    rcSrc.set(0, 0, paramInt3, paramInt4);
    rcDst.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    mCanvas.drawBitmap(paramBitmap, rcSrc, rcDst, null);
  }
  
  public static void drawBitmapParcel(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    rcSrc.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    rcDst.set(paramInt5, paramInt6, paramInt5 + paramInt3, paramInt6 + paramInt4);
    mCanvas.drawBitmap(paramBitmap, rcSrc, rcDst, null);
  }
  
  public static void drawBitmapParcel(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    rcSrc.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    rcDst.set(paramInt5, paramInt6, paramInt5 + paramInt7, paramInt6 + paramInt8);
    mCanvas.drawBitmap(paramBitmap, rcSrc, rcDst, null);
  }
  
  public static final void drawBmpText(int paramInt1, int paramInt2, int paramInt3)
  {
    drawBmpText(paramInt1, paramInt2, paramInt3, null);
  }
  
  public static final void drawBmpText(int paramInt1, int paramInt2, int paramInt3, Paint paramPaint)
  {
    if ((paramInt3 < 0) || (paramInt3 > 90) || (charLayer == null)) {
      return;
    }
    rcSrc.set(charRealX * paramInt3, 0, charRealX * paramInt3 + charRealX, charRealY);
    rcDst.set(paramInt1, paramInt2, charXSpace + paramInt1, charYSpace + paramInt2);
    mCanvas.drawBitmap(charLayer, rcSrc, rcDst, paramPaint);
  }
  
  public static final void drawBmpText(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    drawBmpText(paramInt1, paramInt2, paramCharSequence, null);
  }
  
  public static final void drawBmpText(int paramInt1, int paramInt2, CharSequence paramCharSequence, Paint paramPaint)
  {
    int j = 0;
    int k = paramCharSequence.length();
    int i = paramInt1;
    paramInt1 = j;
    for (;;)
    {
      if (paramInt1 >= k) {
        return;
      }
      drawBmpText(i, paramInt2, paramCharSequence.charAt(paramInt1) - ' ', paramPaint);
      i += charXSpace;
      paramInt1 += 1;
    }
  }
  
  public static final void drawBmpTextNumber(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 < 0) || (paramInt3 > 9)) {
      return;
    }
    drawBmpText(paramInt1, paramInt2, paramInt3 + 16);
  }
  
  public static final void drawBmpTextTime(int paramInt1, int paramInt2, long paramLong)
  {
    int i = (int)(paramLong / 10L);
    int j = paramInt1 - charXSpace;
    drawBmpTextNumber(j, paramInt2, i % 10);
    j -= 15;
    i /= 10;
    drawBmpTextNumber(j, paramInt2, i % 10);
    int k = j - 15;
    j = i / 10;
    drawBmpText(k, paramInt2, 14);
    i = k - 15;
    if (j != 0) {
      if (j > 0) {}
    }
    for (;;)
    {
      charLastSize = paramInt1 - i - 24;
      return;
      drawBmpTextNumber(i, paramInt2, j % 10);
      j /= 10;
      i -= charRealX;
      break;
      drawBmpText(i, paramInt2, 0);
      i -= charRealX;
    }
  }
  
  public static final void drawBox(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint paramPaint)
  {
    mCanvas.drawRect(paramInt1, paramInt2, paramInt3, paramInt4, paramPaint);
  }
  
  public static final void drawCircle(float paramFloat1, float paramFloat2, float paramFloat3, Paint paramPaint)
  {
    mCanvas.drawCircle(paramFloat1, paramFloat2, paramFloat3, paramPaint);
  }
  
  public static final void drawCircle(int paramInt1, int paramInt2, int paramInt3, Paint paramPaint)
  {
    mCanvas.drawCircle(paramInt1, paramInt2, paramInt3, paramPaint);
  }
  
  public static final void drawColor(int paramInt)
  {
    if (paintClr != paramInt)
    {
      paintClr = paramInt;
      paintColor.setColor(paintClr);
    }
    mCanvas.drawPaint(paintColor);
  }
  
  public static final void drawLine(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Paint paramPaint)
  {
    mCanvas.drawLine(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramPaint);
  }
  
  public static final void drawLine(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint paramPaint)
  {
    mCanvas.drawLine(paramInt1, paramInt2, paramInt3, paramInt4, paramPaint);
  }
  
  public static final void drawPaint(Paint paramPaint)
  {
    mCanvas.drawPaint(paramPaint);
  }
  
  public static final void drawPath(Path paramPath, Paint paramPaint)
  {
    mCanvas.drawPath(paramPath, paramPaint);
  }
  
  public static final void drawRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Paint paramPaint)
  {
    mCanvas.drawRect(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, paramPaint);
  }
  
  public static final void drawRoundRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    dr.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    mCanvas.drawRoundRect(dr, paramInt5, paramInt5, paramPaint);
  }
  
  public static final void drawSolidCircle(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    if (paintClr != paramInt)
    {
      paintClr = paramInt;
      paintColor.setColor(paintClr);
    }
    mCanvas.drawCircle(paramFloat1, paramFloat2, paramFloat3, paintColor);
  }
  
  public static final void drawSolidLine(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    if (paintClr != paramInt)
    {
      paintClr = paramInt;
      paintColor.setColor(paintClr);
    }
    mCanvas.drawLine(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paintColor);
  }
  
  public static final void drawSolidRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    if (paintClr != paramInt)
    {
      paintClr = paramInt;
      paintColor.setColor(paintClr);
    }
    mCanvas.drawRect(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, paintColor);
  }
  
  public static final void drawText(String paramString, int paramInt1, int paramInt2, Paint paramPaint)
  {
    if (paramString == null) {
      return;
    }
    mCanvas.drawText(paramString, paramInt1, paramInt2, paramPaint);
  }
  
  public static final void drawText(char[] paramArrayOfChar, int paramInt1, int paramInt2, Paint paramPaint)
  {
    if (paramArrayOfChar == null) {
      return;
    }
    mCanvas.drawText(paramArrayOfChar, 0, paramArrayOfChar.length, paramInt1, paramInt2, paramPaint);
  }
  
  public static final void drawTextCE(String paramString, int paramInt1, int paramInt2, Paint paramPaint)
  {
    if (paramString == null) {
      return;
    }
    if ((paramInt1 == Integer.MIN_VALUE) || (paramInt2 == Integer.MIN_VALUE))
    {
      paramPaint.getTextBounds(paramString, 0, paramString.length(), textBound);
      if (paramInt1 == Integer.MIN_VALUE)
      {
        paramInt1 = centerX(textBound.right - textBound.left);
        if (paramInt2 != Integer.MIN_VALUE) {
          break label92;
        }
        paramInt2 = centerY(textBound.bottom - textBound.top);
      }
      label92:
      for (;;)
      {
        mCanvas.drawText(paramString, paramInt1, paramInt2, paramPaint);
        return;
        break;
      }
    }
    mCanvas.drawText(paramString, paramInt1, paramInt2, paramPaint);
  }
  
  public static final int drawTextLine(String paramString, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint)
  {
    paramString = new StringTokenizer(paramString, " ,:;.", true);
    float f = paramPaint.getTextSize();
    String[] arrayOfString = new String[10];
    int i = 0;
    arrayOfString[0] = "";
    if (!paramString.hasMoreTokens()) {
      paramInt3 = 0;
    }
    for (;;)
    {
      if (paramInt3 > i)
      {
        return i;
        String str = paramString.nextToken();
        if (TextUtils.getTextWidth(arrayOfString[i] + str, paramPaint) > paramInt3)
        {
          arrayOfString[(i + 1)] = str;
          i += 1;
          break;
        }
        arrayOfString[i] = (arrayOfString[i] + str);
        break;
      }
      drawText(arrayOfString[paramInt3], paramInt1, (int)(paramInt2 + paramInt3 * (f + 4.0F)), paramPaint);
      paramInt3 += 1;
    }
  }
  
  public static final void enableAliasing(boolean paramBoolean) {}
  
  protected static final void freeAllMusic()
  {
    int i = 0;
    int j = musicCache.size();
    for (;;)
    {
      if (i >= j) {
        return;
      }
      ((Music)musicCache.valueAt(i)).terminate();
      i += 1;
    }
  }
  
  public static final void freeBitmap(int paramInt)
  {
    Bitmap localBitmap;
    if ((paramInt < 0) || (paramInt >= GamePak._cache.length))
    {
      localBitmap = (Bitmap)bitmapCache.get(paramInt);
      if (localBitmap != null)
      {
        bitmapCache.remove(paramInt);
        localBitmap.recycle();
      }
    }
    do
    {
      return;
      localBitmap = (Bitmap)GamePak._cache[paramInt];
    } while (localBitmap == null);
    GamePak._cache[paramInt] = null;
    localBitmap.recycle();
  }
  
  public static final void freeMusic(int paramInt)
  {
    Music localMusic = (Music)GamePak._cache[paramInt];
    if (localMusic != null)
    {
      localMusic.terminate();
      GamePak._cache[paramInt] = null;
      musicCache.remove(paramInt);
    }
  }
  
  public static final GameRate getActionRate()
  {
    return actionRate;
  }
  
  public static final AdLayout getAdBanner()
  {
    return adBanner;
  }
  
  public static final AdLayout getAdSquare()
  {
    return adSquare;
  }
  
  public static final boolean getAliasing()
  {
    return getAntiAliasEnabled();
  }
  
  public static final int getAndroidSDKVersion()
  {
    return androidSDKVersion;
  }
  
  public static final AnimPackage getAnimPackage(int paramInt)
  {
    AnimPackage localAnimPackage2 = (AnimPackage)GamePak._cache[paramInt];
    AnimPackage localAnimPackage1 = localAnimPackage2;
    if (localAnimPackage2 == null)
    {
      localAnimPackage1 = AnimPackage.loadFromRes(paramInt);
      GamePak._cache[paramInt] = localAnimPackage1;
    }
    return localAnimPackage1;
  }
  
  public static final boolean getAntiAliasEnabled()
  {
    return opAlias;
  }
  
  public static final int getAppVersion()
  {
    return appVersionCode;
  }
  
  public static final String getAppVersionName()
  {
    return appVersionName;
  }
  
  public static final GameApplication getApplication()
  {
    return application;
  }
  
  public static final Context getBaseContext()
  {
    if (activity != null) {
      return activity;
    }
    return application;
  }
  
  public static final Bitmap getBitmap(int paramInt)
  {
    Bitmap localBitmap2 = (Bitmap)GamePak._cache[paramInt];
    Bitmap localBitmap1;
    if (localBitmap2 != null)
    {
      localBitmap1 = localBitmap2;
      if (!localBitmap2.isRecycled()) {}
    }
    else
    {
      localBitmap1 = GamePak.getBitmap(paramInt, getBitmapOptions());
      GamePak._cache[paramInt] = localBitmap1;
    }
    return localBitmap1;
  }
  
  public static final BitmapFactory.Options getBitmapOptions()
  {
    if (androidSDKVersion <= 3) {
      return BitmapUtils_API3.createOption();
    }
    return BitmapUtils_API4.createOption();
  }
  
  public static final Bitmap getBitmapSafe(int paramInt)
  {
    Bitmap localBitmap2 = getBitmap(paramInt);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 != null)
    {
      localBitmap1 = localBitmap2;
      if (localBitmap2.isRecycled())
      {
        freeBitmap(paramInt);
        localBitmap1 = getBitmap(paramInt);
      }
    }
    return localBitmap1;
  }
  
  public static final int getBufferHeight()
  {
    return mBufferHeight;
  }
  
  public static final int getBufferWidth()
  {
    return mBufferWidth;
  }
  
  public static final int getColorMode()
  {
    return colorMode;
  }
  
  public static final GameActivity getContext()
  {
    return activity;
  }
  
  public static final IGameStage getCurrentStage()
  {
    return StageManager._currentStage;
  }
  
  public static final float getDensity()
  {
    return density;
  }
  
  public static final int getDisplayHeight()
  {
    return displayHeight;
  }
  
  public static final int getDisplaySize()
  {
    return (int)Math.sqrt(displayWidth * displayWidth + displayHeight * displayHeight);
  }
  
  public static final int getDisplayWidth()
  {
    return displayWidth;
  }
  
  public static final FeatureWrapper getFeatureWrapper()
  {
    return featureWrapper;
  }
  
  public static final File getFile(String paramString)
  {
    return new File(getFilesDir().getAbsolutePath().concat("/").concat(paramString));
  }
  
  public static final File getFilesDir()
  {
    return getBaseContext().getFilesDir();
  }
  
  public static final String getFootprint()
  {
    return hash;
  }
  
  public static final GameMessageHandler getHandler()
  {
    return mHandler;
  }
  
  public static final boolean getHapticEnable()
  {
    return opHaptic;
  }
  
  public static final String getLang()
  {
    return res_lang;
  }
  
  public static final String getLangDesc(int paramInt)
  {
    return res_d[paramInt];
  }
  
  public static final String getLangDesc(String paramString)
  {
    String str;
    if (paramString == null)
    {
      str = res_d[0];
      return str;
    }
    int i = 0;
    for (;;)
    {
      str = paramString;
      if (i >= res_l.length) {
        break;
      }
      if (res_l[i].equals(paramString)) {
        return res_d[i];
      }
      i += 1;
    }
  }
  
  public static final String[] getLangs()
  {
    return res_l;
  }
  
  public static final String getLanguage()
  {
    return locale.getLanguage();
  }
  
  public static final int getLastBmpTextSize()
  {
    return charLastSize;
  }
  
  public static final GameLayout getLayout()
  {
    return layout;
  }
  
  public static final MarketWrapper getMarket()
  {
    return marketWrapper;
  }
  
  public static final float getMultiplier()
  {
    return multiplier;
  }
  
  public static final Music getMusic(int paramInt)
  {
    Music localMusic2 = (Music)GamePak._cache[paramInt];
    Music localMusic1 = localMusic2;
    if (localMusic2 == null)
    {
      localMusic1 = new Music(paramInt);
      GamePak._cache[paramInt] = localMusic1;
      musicCache.put(paramInt, localMusic1);
    }
    return localMusic1;
  }
  
  public static final boolean getMusicEnable()
  {
    return opMusic;
  }
  
  public static final int getOrientation()
  {
    return orientation;
  }
  
  public static final String getPackageName()
  {
    return appPackageName;
  }
  
  public static final AppParameters getParameters()
  {
    return parameters;
  }
  
  public static final boolean getPrefBoolean(String paramString, boolean paramBoolean)
  {
    return getPreferences().getBoolean(paramString, paramBoolean);
  }
  
  public static final float getPrefFloat(String paramString, float paramFloat)
  {
    return getPreferences().getFloat(paramString, paramFloat);
  }
  
  public static final int getPrefInt(String paramString, int paramInt)
  {
    return getPreferences().getInt(paramString, paramInt);
  }
  
  public static final long getPrefLong(String paramString, long paramLong)
  {
    return getPreferences().getLong(paramString, paramLong);
  }
  
  public static final String getPrefString(String paramString1, String paramString2)
  {
    return getPreferences().getString(paramString1, paramString2);
  }
  
  public static final SharedPreferences getPreferences()
  {
    if (preferences == null) {
      preferences = PreferenceManager.getDefaultSharedPreferences(application);
    }
    return preferences;
  }
  
  private static final Class<?> getRClass(String paramString)
  {
    try
    {
      paramString = Class.forName(appPackageName + ".R$" + paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static final int getRDrawable(String paramString)
  {
    try
    {
      int i = ((Integer)Rdrawable.getField(paramString).get(Rdrawable)).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static final int getRId(String paramString)
  {
    try
    {
      int i = ((Integer)Rid.getField(paramString).get(Rid)).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static final int getRLayout(String paramString)
  {
    try
    {
      int i = ((Integer)Rlayout.getField(paramString).get(Rlayout)).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static final int getRString(String paramString)
  {
    try
    {
      int i = ((Integer)Rstring.getField(paramString).get(Rstring)).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static final GameRate getRate()
  {
    return renderRate;
  }
  
  public static final GameRenderMode getRenderMode()
  {
    return gameRenderMode;
  }
  
  public static final GameRate getRenderRate()
  {
    return renderRate;
  }
  
  public static final Bitmap getResBitmap(int paramInt)
  {
    Bitmap localBitmap2 = (Bitmap)bitmapCache.get(paramInt);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localBitmap1 = BitmapFactory.decodeResource(activity.getResources(), paramInt, getBitmapOptions());
      bitmapCache.put(paramInt, localBitmap1);
    }
    return localBitmap1;
  }
  
  public static final String getResString(int paramInt)
  {
    Object localObject1;
    if ((res_langid < 0) || (res_t == null)) {
      localObject1 = application.getResources().getString(paramInt);
    }
    for (;;)
    {
      return (String)localObject1;
      if (res_cache == null) {
        res_cache = new String[res_t[res_langid].length];
      }
      int j = paramInt & 0xFFFF;
      String str = res_cache[j];
      localObject1 = str;
      if (str != null) {
        continue;
      }
      localObject2 = str;
      try
      {
        int i = res_t[res_langid][j];
        paramInt = i;
        if (i == 0)
        {
          localObject2 = str;
          paramInt = res_t[0][j];
        }
        localObject1 = str;
        if (paramInt <= 0) {
          continue;
        }
        localObject2 = str;
        ZipFile localZipFile = new ZipFile(sourceDir);
        localObject2 = str;
        Object localObject3 = localZipFile.getEntry("resources.arsc");
        localObject1 = str;
        if (localObject3 != null)
        {
          localObject2 = str;
          localObject3 = new BufferedInputStream(localZipFile.getInputStream((ZipEntry)localObject3));
          localObject2 = str;
          ((BufferedInputStream)localObject3).skip(paramInt);
          localObject2 = str;
          paramInt = ((BufferedInputStream)localObject3).read();
          localObject2 = str;
          i = ((BufferedInputStream)localObject3).read();
          localObject1 = str;
          if (paramInt > 0)
          {
            if (paramInt != i) {
              break label272;
            }
            localObject2 = str;
            localObject1 = new byte[paramInt];
            localObject2 = str;
            ((BufferedInputStream)localObject3).read((byte[])localObject1, 0, localObject1.length);
            localObject2 = str;
          }
        }
        for (localObject1 = new String((byte[])localObject1, "UTF-8");; localObject1 = new String((byte[])localObject1, "UTF-16LE"))
        {
          localObject2 = localObject1;
          res_cache[j] = localObject1;
          localObject2 = localObject1;
          ((BufferedInputStream)localObject3).close();
          localObject2 = localObject1;
          localZipFile.close();
          return (String)localObject1;
          label272:
          localObject2 = str;
          localObject1 = new byte[paramInt * 2];
          localObject2 = str;
          ((BufferedInputStream)localObject3).read((byte[])localObject1, 0, localObject1.length);
          localObject2 = str;
        }
        return (String)localObject2;
      }
      catch (Exception localException) {}
    }
  }
  
  public static final String[] getResStringArray(int paramInt)
  {
    return application.getResources().getStringArray(paramInt);
  }
  
  public static final Sound getSound(int paramInt)
  {
    Sound localSound2 = (Sound)GamePak._cache[paramInt];
    Sound localSound1 = localSound2;
    if (localSound2 == null)
    {
      localSound1 = new Sound(GamePak.getSound(soundPool, paramInt));
      GamePak._cache[paramInt] = localSound1;
    }
    return localSound1;
  }
  
  public static final boolean getSoundEnable()
  {
    return opSound;
  }
  
  public static final float getSoundLevel()
  {
    return opVolume / 15.0F;
  }
  
  public static final int getSurfaceHeight()
  {
    return surfaceHeight;
  }
  
  public static final int getSurfaceWidth()
  {
    return surfaceWidth;
  }
  
  public static final Typeface getSystemDefaultTypeface()
  {
    return Typeface.DEFAULT;
  }
  
  public static final File getTempDir()
  {
    return getBaseContext().getCacheDir();
  }
  
  public static final File getTempFile(String paramString)
  {
    return new File(getTempDir().getAbsolutePath().concat("/").concat(paramString));
  }
  
  public static final int getTextHeight(String paramString, Paint paramPaint)
  {
    paramPaint.getTextBounds(paramString, 0, paramString.length(), textBound);
    return textBound.bottom - textBound.top;
  }
  
  public static final int getTextHeight(char[] paramArrayOfChar, Paint paramPaint)
  {
    paramPaint.getTextBounds(paramArrayOfChar, 0, paramArrayOfChar.length, textBound);
    return textBound.bottom - textBound.top;
  }
  
  public static final int getTextWidth(String paramString, Paint paramPaint)
  {
    paramPaint.getTextBounds(paramString, 0, paramString.length(), textBound);
    return textBound.right - textBound.left;
  }
  
  public static final int getTextWidth(char[] paramArrayOfChar, Paint paramPaint)
  {
    paramPaint.getTextBounds(paramArrayOfChar, 0, paramArrayOfChar.length, textBound);
    return textBound.right - textBound.left;
  }
  
  public static final Thread getThread(int paramInt)
  {
    if (paramInt == 1) {
      return actionThread;
    }
    if (paramInt == 2) {
      return renderThread;
    }
    return null;
  }
  
  public static final float getTick(int paramInt)
  {
    if (paramInt != 0) {
      return (float)(tick % paramInt) / paramInt;
    }
    return 0.0F;
  }
  
  public static int getTouchMode()
  {
    return _touchmode;
  }
  
  public static final Typeface getTypeface()
  {
    return typeface;
  }
  
  public static final boolean getVibrateEnable()
  {
    return opVibrate;
  }
  
  public static final int getVolume()
  {
    return opVolume;
  }
  
  public static final boolean getWakeupEnable()
  {
    return opWakeup;
  }
  
  protected static final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return;
              if (paramMessage.obj != null)
              {
                ((IGameStage)paramMessage.obj).onCall(paramMessage.arg1);
                return;
                if (paramMessage.obj != null)
                {
                  IGameStage localIGameStage = (IGameStage)paramMessage.obj;
                  if (localIGameStage.getContentView() == null) {}
                  for (paramMessage = localIGameStage.onCreateView(); paramMessage != null; paramMessage = localIGameStage.getContentView())
                  {
                    localIGameStage.setContentView(paramMessage);
                    if (paramMessage.getParent() == null) {
                      layout.addView(paramMessage, 2, new GameLayout.LayoutParams(-1, -1));
                    }
                    localIGameStage.onShowView();
                    return;
                  }
                }
              }
            }
          } while (paramMessage.obj == null);
          layout.removeView(((IGameStage)paramMessage.obj).getContentView());
          return;
        } while (paramMessage.obj == null);
        ((AdLayout)paramMessage.obj).onShowCallback();
        return;
      } while (paramMessage.obj == null);
      ((AdLayout)paramMessage.obj).onHideCallback();
      return;
    } while (paramMessage.obj == null);
    Toast.makeText(activity, (String)paramMessage.obj, 0).show();
  }
  
  public static final void hideBanner()
  {
    if (adBanner != null) {
      adBanner.hide();
    }
  }
  
  public static final void hideSquare()
  {
    if (adSquare != null) {
      adSquare.hide();
    }
  }
  
  public static final void invalidate()
  {
    isDirty = true;
  }
  
  private static final boolean is720x1280()
  {
    return ((displayWidth == 720) && (displayHeight == 1280)) || ((displayWidth == 1280) && (displayHeight == 720));
  }
  
  public static final boolean isBitmapReady(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {}
    while (paramBitmap.isRecycled()) {
      return false;
    }
    return true;
  }
  
  public static final boolean isDebuggable()
  {
    return isDebuggable;
  }
  
  public static final boolean isFirstUse()
  {
    return opFirst;
  }
  
  public static final boolean isHD()
  {
    return getDisplaySize() > 577;
  }
  
  public static final boolean isMainThread()
  {
    return Thread.currentThread().equals(Looper.getMainLooper().getThread());
  }
  
  public static final boolean isNullOrEmpty(String paramString)
  {
    if (paramString == null) {}
    while (paramString.length() == 0) {
      return true;
    }
    return false;
  }
  
  public static final boolean isTablet()
  {
    boolean bool = false;
    try
    {
      DisplayMetrics localDisplayMetrics = activity.getResources().getDisplayMetrics();
      float f1 = localDisplayMetrics.widthPixels / localDisplayMetrics.xdpi;
      float f2 = localDisplayMetrics.heightPixels / localDisplayMetrics.ydpi;
      double d = Math.sqrt(f1 * f1 + f2 * f2);
      if (d >= 6.0D) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static final boolean isiDTGV()
  {
    return metaiDTGV;
  }
  
  public static final boolean isiDTouch()
  {
    return isiDTouch;
  }
  
  private static int keyConvert(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    }
    return 0;
  }
  
  public static Bitmap loadBitmap(int paramInt)
  {
    return GamePak.getBitmap(paramInt, getBitmapOptions());
  }
  
  private static void loadPreferences()
  {
    SharedPreferences localSharedPreferences = getPreferences();
    opFirst = localSharedPreferences.getBoolean("first", true);
    opSound = localSharedPreferences.getBoolean("sound", parameters.DEFAULT_SOUND_ENABLED);
    opMusic = localSharedPreferences.getBoolean("music", parameters.DEFAULT_MUSIC_ENABLED);
    opVibrate = localSharedPreferences.getBoolean("vibrate", parameters.DEFAULT_VIBRATE_ENABLED);
    opHaptic = localSharedPreferences.getBoolean("haptic", parameters.DEFAULT_HAPTIC_ENABLED);
    opAlias = localSharedPreferences.getBoolean("aliasing", parameters.DEFAULT_ALIASING_ENABLED);
    opStretch = localSharedPreferences.getBoolean("stretch", parameters.DEFAULT_STRETCH_ENABLED);
    opWakeup = localSharedPreferences.getBoolean("wakeup", parameters.DEFAULT_KEEPSCREENON_ENABLED);
    if (soundMngr != null) {
      opVolume = soundMngr.getStreamVolume(3);
    }
    opLoaded = true;
  }
  
  public static final Typeface loadTypeface(String paramString)
  {
    if (paramString == null) {}
    try
    {
      return getSystemDefaultTypeface();
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    paramString = Typeface.createFromAsset(activity.getAssets(), paramString);
    return paramString;
    return getSystemDefaultTypeface();
  }
  
  /* Error */
  protected static final void onActionCycle()
  {
    // Byte code:
    //   0: lconst_0
    //   1: putstatic 1297	com/magmamobile/game/engine/Game:acNextTime	J
    //   4: iconst_1
    //   5: putstatic 1299	com/magmamobile/game/engine/Game:acLoop	Z
    //   8: new 4	java/lang/Object
    //   11: dup
    //   12: invokespecial 257	java/lang/Object:<init>	()V
    //   15: putstatic 1301	com/magmamobile/game/engine/Game:actionSync	Ljava/lang/Object;
    //   18: invokestatic 1306	com/magmamobile/game/engine/ActionCounter:restart	()V
    //   21: getstatic 1308	com/magmamobile/game/engine/Game:running	Z
    //   24: ifne +34 -> 58
    //   27: iconst_0
    //   28: putstatic 1299	com/magmamobile/game/engine/Game:acLoop	Z
    //   31: getstatic 1310	com/magmamobile/game/engine/Game:rendering	Z
    //   34: ifeq +20 -> 54
    //   37: getstatic 1312	com/magmamobile/game/engine/Game:renderSync	Ljava/lang/Object;
    //   40: astore_0
    //   41: aload_0
    //   42: monitorenter
    //   43: getstatic 1312	com/magmamobile/game/engine/Game:renderSync	Ljava/lang/Object;
    //   46: ldc2_w 74
    //   49: invokevirtual 1316	java/lang/Object:wait	(J)V
    //   52: aload_0
    //   53: monitorexit
    //   54: invokestatic 1319	com/magmamobile/game/engine/Game:syncQuit	()V
    //   57: return
    //   58: getstatic 1321	com/magmamobile/game/engine/Game:ready	Z
    //   61: ifeq +211 -> 272
    //   64: getstatic 1323	com/magmamobile/game/engine/Game:paused	Z
    //   67: ifne +205 -> 272
    //   70: invokestatic 1329	android/os/SystemClock:elapsedRealtime	()J
    //   73: putstatic 1331	com/magmamobile/game/engine/Game:acCurTime	J
    //   76: getstatic 1297	com/magmamobile/game/engine/Game:acNextTime	J
    //   79: getstatic 1331	com/magmamobile/game/engine/Game:acCurTime	J
    //   82: lsub
    //   83: putstatic 1333	com/magmamobile/game/engine/Game:acDeltaTime	J
    //   86: getstatic 1333	com/magmamobile/game/engine/Game:acDeltaTime	J
    //   89: lconst_0
    //   90: lcmp
    //   91: ifgt +168 -> 259
    //   94: getstatic 1331	com/magmamobile/game/engine/Game:acCurTime	J
    //   97: getstatic 1335	com/magmamobile/game/engine/Game:actionFreq	J
    //   100: ladd
    //   101: putstatic 1297	com/magmamobile/game/engine/Game:acNextTime	J
    //   104: getstatic 1310	com/magmamobile/game/engine/Game:rendering	Z
    //   107: ifeq +20 -> 127
    //   110: getstatic 1312	com/magmamobile/game/engine/Game:renderSync	Ljava/lang/Object;
    //   113: astore_0
    //   114: aload_0
    //   115: monitorenter
    //   116: getstatic 1312	com/magmamobile/game/engine/Game:renderSync	Ljava/lang/Object;
    //   119: ldc2_w 74
    //   122: invokevirtual 1316	java/lang/Object:wait	(J)V
    //   125: aload_0
    //   126: monitorexit
    //   127: iconst_1
    //   128: putstatic 1337	com/magmamobile/game/engine/Game:acting	Z
    //   131: invokestatic 1342	com/magmamobile/game/engine/GameActionStack:hasData	()Z
    //   134: ifne +84 -> 218
    //   137: getstatic 766	com/magmamobile/game/engine/StageManager:_currentStage	Lcom/magmamobile/game/engine/IGameStage;
    //   140: ifnull +22 -> 162
    //   143: getstatic 766	com/magmamobile/game/engine/StageManager:_currentStage	Lcom/magmamobile/game/engine/IGameStage;
    //   146: invokeinterface 1345 1 0
    //   151: ifeq +11 -> 162
    //   154: getstatic 766	com/magmamobile/game/engine/StageManager:_currentStage	Lcom/magmamobile/game/engine/IGameStage;
    //   157: invokeinterface 1348 1 0
    //   162: invokestatic 1353	com/magmamobile/game/engine/Keyboard:clear	()V
    //   165: invokestatic 1356	com/magmamobile/game/engine/TouchScreen:clear	()V
    //   168: getstatic 866	com/magmamobile/game/engine/Game:parameters	Lcom/magmamobile/game/engine/AppParameters;
    //   171: getfield 1359	com/magmamobile/game/engine/AppParameters:USE_ACTION_COUNTER	Z
    //   174: ifeq +6 -> 180
    //   177: invokestatic 1362	com/magmamobile/game/engine/ActionCounter:next	()V
    //   180: iconst_0
    //   181: putstatic 1337	com/magmamobile/game/engine/Game:acting	Z
    //   184: getstatic 1301	com/magmamobile/game/engine/Game:actionSync	Ljava/lang/Object;
    //   187: astore_0
    //   188: aload_0
    //   189: monitorenter
    //   190: getstatic 1301	com/magmamobile/game/engine/Game:actionSync	Ljava/lang/Object;
    //   193: invokevirtual 1365	java/lang/Object:notifyAll	()V
    //   196: aload_0
    //   197: monitorexit
    //   198: getstatic 1077	com/magmamobile/game/engine/Game:tick	J
    //   201: lconst_1
    //   202: ladd
    //   203: putstatic 1077	com/magmamobile/game/engine/Game:tick	J
    //   206: goto -185 -> 21
    //   209: astore_1
    //   210: aload_0
    //   211: monitorexit
    //   212: aload_1
    //   213: athrow
    //   214: astore_0
    //   215: goto -88 -> 127
    //   218: invokestatic 1368	com/magmamobile/game/engine/GameActionStack:pop	()I
    //   221: tableswitch	default:+19->240, 4:+22->243
    //   240: goto -109 -> 131
    //   243: invokestatic 1370	com/magmamobile/game/engine/StageManager:getCurrentStage	()Lcom/magmamobile/game/engine/IGameStage;
    //   246: invokeinterface 1373 1 0
    //   251: goto -120 -> 131
    //   254: astore_1
    //   255: aload_0
    //   256: monitorexit
    //   257: aload_1
    //   258: athrow
    //   259: getstatic 1333	com/magmamobile/game/engine/Game:acDeltaTime	J
    //   262: invokestatic 1376	java/lang/Thread:sleep	(J)V
    //   265: goto -244 -> 21
    //   268: astore_0
    //   269: goto -248 -> 21
    //   272: ldc2_w 37
    //   275: invokestatic 1376	java/lang/Thread:sleep	(J)V
    //   278: goto -257 -> 21
    //   281: astore_0
    //   282: goto -261 -> 21
    //   285: astore_1
    //   286: aload_0
    //   287: monitorexit
    //   288: aload_1
    //   289: athrow
    //   290: astore_0
    //   291: goto -237 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   214	42	0	localInterruptedException1	InterruptedException
    //   268	1	0	localInterruptedException2	InterruptedException
    //   281	6	0	localInterruptedException3	InterruptedException
    //   290	1	0	localInterruptedException4	InterruptedException
    //   209	4	1	localObject2	Object
    //   254	4	1	localObject3	Object
    //   285	4	1	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   116	127	209	finally
    //   210	212	209	finally
    //   110	116	214	java/lang/InterruptedException
    //   212	214	214	java/lang/InterruptedException
    //   190	198	254	finally
    //   255	257	254	finally
    //   259	265	268	java/lang/InterruptedException
    //   272	278	281	java/lang/InterruptedException
    //   43	54	285	finally
    //   286	288	285	finally
    //   37	43	290	java/lang/InterruptedException
    //   288	290	290	java/lang/InterruptedException
  }
  
  protected static void onActivityCreate(GameActivity paramGameActivity)
  {
    if (metaiDTGV) {
      paramGameActivity.getWindow().addFlags(524288);
    }
    checkErrorReporter(paramGameActivity);
    System.gc();
    setContext(paramGameActivity);
    paramGameActivity.setVolumeControlStream(3);
    setDisplayData(paramGameActivity.getWindowManager());
    mHandler = new GameMessageHandler();
    colorMode = parameters.getColorMode();
    mBufferWidth = parameters.getBufferWidth();
    mBufferHeight = parameters.getBufferHeight();
    boolean bool;
    if ((displayWidth == mBufferWidth) && (displayHeight == mBufferHeight))
    {
      bool = true;
      mNoStretch = bool;
      mBufferDiagonal = (int)Math.sqrt(mBufferWidth * mBufferWidth + mBufferHeight * mBufferHeight);
      mBufferCW = mBufferWidth >> 1;
      mBufferCH = mBufferHeight >> 1;
      updateRatio();
      renderRate = parameters.DEFAULT_GAMERATE;
      actionRate = parameters.DEFAULT_GAMERATE;
      renderFreq = parameters.DEFAULT_GAMERATE.getTime();
      actionFreq = parameters.DEFAULT_GAMERATE.getTime();
      engineMode = parameters.DEFAULT_ENGINE_MODE;
      gameRenderMode = parameters.DEFAULT_RENDERMODE;
      GamePak.initialize(parameters.getPack());
      soundPool = new SoundPool(parameters.SOUND_MAX, 3, parameters.SOUND_QUALITY);
      soundMngr = (AudioManager)paramGameActivity.getSystemService("audio");
      SensorsManager.onInitialize();
      loadPreferences();
      if (opFirst)
      {
        application.onFirstUse();
        savePreferences();
      }
      layout = new GameLayout(paramGameActivity);
      view = featureWrapper.createGameView(paramGameActivity);
      if (!isiDTouch) {
        break label760;
      }
      view.setKeepScreenOn(false);
      label302:
      holder = view.getHolder();
      if (parameters.DEFAULT_RENDERER != 0) {
        break label782;
      }
      holder.setFixedSize(mBufferWidth, mBufferHeight);
      if ((androidSDKVersion < 16) || (!is720x1280()) || (parameters.FIX_GS3BLACKSCREEN == 2)) {
        break label772;
      }
      holder.setFormat(1);
    }
    for (;;)
    {
      holder.addCallback(new GameSurfaceCallback());
      GameLayout.LayoutParams localLayoutParams = new GameLayout.LayoutParams(0, 0);
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      layout.addView(view, localLayoutParams);
      AdManager.onCreate(layout);
      adBanner = application.onCreateAdBanner();
      if (adBanner != null) {
        AdManager.add(adBanner);
      }
      adSquare = application.onCreateAdSquare();
      if (adSquare != null) {
        AdManager.add(adSquare);
      }
      paramGameActivity.onCreateViews(layout);
      paramGameActivity.setContentView(layout);
      featureWrapper.setOnSystemUiVisibilityChangeListener(layout);
      setFullScreen();
      buffer = createBitmap(mBufferWidth, mBufferHeight);
      mCanvas = new Canvas(buffer);
      dwfilter = new PaintFlagsDrawFilter(0, 71);
      mCanvas.setDrawFilter(dwfilter);
      textBound = new Rect();
      typeface = Label.loadTypeface(parameters.DEFAULT_LABEL_TYPEFACE);
      musicCache = new SparseArray();
      bitmapCache = new SparseArray();
      rcSrc = new Rect();
      rcDst = new Rect();
      matrix = new Matrix();
      _bitBltPaint = new Paint();
      _bitBltPaint.setFilterBitmap(true);
      _bitBltPaint.setAntiAlias(false);
      _bitBltPaint.setDither(false);
      _bitBltPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
      _alphaPaint = new Paint();
      _alphaPaint.setAntiAlias(getAliasing());
      _alphaPaint.setFilterBitmap(getAliasing());
      charLayer = null;
      charRealX = 24;
      charRealY = 24;
      charXSpace = charRealX;
      charYSpace = charRealY;
      vibrator = (Vibrator)paramGameActivity.getSystemService("vibrator");
      paintClr = 0;
      paintColor = new Paint();
      paintColor.setColor(paintClr);
      Keyboard.reset();
      TouchScreen.reset();
      BackgroundMusic.reset();
      return;
      bool = false;
      break;
      label760:
      view.setKeepScreenOn(opWakeup);
      break label302;
      label772:
      view.setBackgroundColor(0);
      continue;
      label782:
      srcRect = new Rect(0, 0, mBufferWidth, mBufferHeight);
      dstRect = new Rect();
      view.setBackgroundColor(0);
    }
  }
  
  protected static final void onActivityDestroy()
  {
    StageManager.onTerminate();
    AdManager.onDestroy();
  }
  
  protected static boolean onActivityKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramKeyEvent.getAction() == 0)
    {
      if ((paramInt != 82) && (paramInt != 24) && (paramInt != 25)) {
        break label45;
      }
      opVolume = soundMngr.getStreamVolume(3);
      bool1 = false;
    }
    label45:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                int i = keyConvert(paramInt);
                if (i != -1)
                {
                  Keyboard.keys[i] = -1;
                  Keyboard.state[i] = -1;
                }
                if (paramInt == 4)
                {
                  paramKeyEvent = StageManager.getCurrentStage();
                  if (paramKeyEvent != null) {
                    paramKeyEvent.onBackButton();
                  }
                }
                bool1 = bool2;
              } while (!parameters.USE_DPAD_FOCUS);
              if ((paramInt != 19) && (paramInt != 21)) {
                break;
              }
              paramKeyEvent = (GameStage)StageManager.getCurrentStage();
              bool1 = bool2;
            } while (paramKeyEvent == null);
            paramKeyEvent._foucs.goPrevious();
            return true;
            if ((paramInt != 20) && (paramInt != 22)) {
              break;
            }
            paramKeyEvent = (GameStage)StageManager.getCurrentStage();
            bool1 = bool2;
          } while (paramKeyEvent == null);
          paramKeyEvent._foucs.goNext();
          return true;
          bool1 = bool2;
        } while (paramInt != 23);
        paramKeyEvent = (GameStage)StageManager.getCurrentStage();
        bool1 = bool2;
      } while (paramKeyEvent == null);
      paramKeyEvent = paramKeyEvent._foucs.getFocus();
      bool1 = bool2;
    } while (paramKeyEvent == null);
    paramKeyEvent.focusClick = true;
    return true;
  }
  
  protected static boolean onActivityKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramKeyEvent.getAction() == 1)
    {
      if ((paramInt != 82) && (paramInt != 24) && (paramInt != 25)) {
        break label44;
      }
      opVolume = soundMngr.getStreamVolume(3);
      bool1 = false;
    }
    label44:
    do
    {
      return bool1;
      paramInt = keyConvert(paramInt);
      bool1 = bool2;
    } while (paramInt == -1);
    Keyboard.keys[paramInt] = 0;
    Keyboard.state[paramInt] = 1;
    return true;
  }
  
  protected static final void onActivityPause()
  {
    SensorsManager.onPause();
    AdManager.onPause();
    BackgroundMusic.pause();
    paused = true;
  }
  
  protected static void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent = StageManager.getCurrentStage();
    if (paramIntent != null)
    {
      lateResume = true;
      if (paramIntent.enterOnResume()) {
        paramIntent.onEnter();
      }
    }
  }
  
  protected static final void onActivityResume()
  {
    setAppOrientation();
    SensorsManager.onResume();
    AdManager.onResume();
    BackgroundMusic.resume();
    paused = false;
  }
  
  protected static final void onActivityStart()
  {
    
    if (running) {
      return;
    }
    loadPreferences();
    running = true;
    paused = false;
    mThread = new Thread()
    {
      public void run()
      {
        System.gc();
        Game.onJoypadClear();
        Keyboard.reset();
        TouchScreen.reset();
        Game.application.onEngineInitialize();
        StageManager.initializeStages();
        if (Game.lateResume)
        {
          Game.lateResume = false;
          if (StageManager.getCurrentStage() != null) {
            StageManager.getCurrentStage().onLateResume();
          }
        }
        if (Game.engineMode == 0)
        {
          if (Game.parameters.DEFAULT_RENDERER == 1) {}
          for (Game.renderThread = new Thread()
              {
                public void run() {}
              };; Game.renderThread = new Thread()
              {
                public void run() {}
              })
          {
            Game.actionThread = new Thread()
            {
              public void run() {}
            };
            Game.actionThread.start();
            Game.renderThread.start();
            return;
          }
        }
        Game.renderThread = new GameThreadTemporal();
        Game.actionThread = Game.renderThread;
        Game.actionThread.start();
      }
    };
    mThread.start();
  }
  
  protected static final void onActivityStop()
  {
    
    if (running)
    {
      BackgroundMusic.stop();
      running = false;
      paused = true;
    }
  }
  
  protected static void onApplicationConfigurationChanged(Configuration paramConfiguration)
  {
    if (!paramConfiguration.locale.getLanguage().equals(locale.getLanguage())) {
      locale = paramConfiguration.locale;
    }
  }
  
  protected static void onApplicationCreate(GameApplication paramGameApplication)
  {
    boolean bool2 = false;
    multiplier = 1.0F;
    application = paramGameApplication;
    appPackageName = paramGameApplication.getPackageName();
    locale = Locale.getDefault();
    androidSDKVersion = Integer.valueOf(Build.VERSION.SDK).intValue();
    Object localObject = Build.PRODUCT;
    isiDTouch = "iDTable".equals(localObject) | "iDWall".equals(localObject);
    for (;;)
    {
      try
      {
        ApplicationInfo localApplicationInfo = paramGameApplication.getPackageManager().getApplicationInfo(appPackageName, 128);
        if ((localApplicationInfo.flags & 0x2) == 0) {
          continue;
        }
        bool1 = true;
        isDebuggable = bool1;
        if (localApplicationInfo.metaData == null) {
          continue;
        }
        localObject = localApplicationInfo.metaData.getString("market");
        metaMarket = (String)localObject;
        bool1 = bool2;
        if (localApplicationInfo.metaData != null) {
          bool1 = localApplicationInfo.metaData.getBoolean("iDTGV");
        }
        metaiDTGV = bool1;
        sourceDir = localApplicationInfo.sourceDir;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        boolean bool1;
        localNameNotFoundException.printStackTrace();
        continue;
        if (androidSDKVersion < 18) {
          continue;
        }
        featureWrapper = new FeatureWrapper18();
        continue;
        if (androidSDKVersion < 11) {
          continue;
        }
        featureWrapper = new FeatureWrapper11();
        continue;
        if (androidSDKVersion < 5) {
          continue;
        }
        featureWrapper = new FeatureWrapper05();
        continue;
        if (androidSDKVersion < 4) {
          continue;
        }
        featureWrapper = new FeatureWrapper04();
        continue;
        featureWrapper = new FeatureWrapper01();
        continue;
        marketWrapper = new MarketGooglePlay();
        continue;
      }
      if (androidSDKVersion < 19) {
        continue;
      }
      featureWrapper = new FeatureWrapper19();
      if (!"Amazon".equals(metaMarket)) {
        continue;
      }
      marketWrapper = new MarketAmazon();
      setDisplayData((WindowManager)application.getSystemService("window"));
      localObject = application.onCreateParameters();
      parameters = (AppParameters)localObject;
      if (((AppParameters)localObject).USE_ERROR_REPORTER) {
        reporter = new ErrorReporter(application);
      }
      if (((AppParameters)localObject).BACKTRACK_ENABLED) {
        hash = ArrayUtils.md5(paramGameApplication);
      }
      if (((AppParameters)localObject).DEBUG_MESSAGE_ENABLED)
      {
        debugToolReceiver = new DebugToolReceiver();
        paramGameApplication.registerReceiver(debugToolReceiver, new IntentFilter("com.magmamobile.debugtool"));
      }
      if (getParameters().ANALYTICS_ENABLED) {
        GoogleAnalytics.startAndDispatch(application, "home");
      }
      if (((AppParameters)localObject).ADWHIRL_ENABLED) {
        WrapperAdWhirl.check((AppParameters)localObject);
      }
      AdManager.onInitialize();
      onJoypadInitialize();
      res_init();
      return;
      bool1 = false;
      continue;
      localObject = null;
    }
  }
  
  protected static void onApplicationLowMemory() {}
  
  protected static void onApplicationTerminate()
  {
    if ((application != null) && (debugToolReceiver != null)) {
      application.unregisterReceiver(debugToolReceiver);
    }
    AdManager.onTerminate();
  }
  
  static final void onJoypadClear()
  {
    if (androidSDKVersion >= 5)
    {
      JoypadUtils_API5.onJoypadClear();
      return;
    }
    JoypadUtils_API4.onJoypadClear();
  }
  
  static final boolean onJoypadEvent(MotionEvent paramMotionEvent)
  {
    if (androidSDKVersion >= 5) {
      return JoypadUtils_API5.onJoypadEvent(paramMotionEvent);
    }
    return JoypadUtils_API4.onJoypadEvent(paramMotionEvent);
  }
  
  static final void onJoypadInitialize()
  {
    if (androidSDKVersion >= 5)
    {
      JoypadUtils_API5.onJoypadInitialize();
      return;
    }
    JoypadUtils_API4.onJoypadInitialize();
  }
  
  /* Error */
  protected static final void onRenderCycleHarware()
  {
    // Byte code:
    //   0: lconst_0
    //   1: putstatic 1894	com/magmamobile/game/engine/Game:reNextTime	J
    //   4: iconst_1
    //   5: putstatic 1896	com/magmamobile/game/engine/Game:reLoop	Z
    //   8: new 4	java/lang/Object
    //   11: dup
    //   12: invokespecial 257	java/lang/Object:<init>	()V
    //   15: putstatic 1312	com/magmamobile/game/engine/Game:renderSync	Ljava/lang/Object;
    //   18: invokestatic 1899	com/magmamobile/game/engine/RenderCounter:restart	()V
    //   21: getstatic 1308	com/magmamobile/game/engine/Game:running	Z
    //   24: ifne +34 -> 58
    //   27: iconst_0
    //   28: putstatic 1896	com/magmamobile/game/engine/Game:reLoop	Z
    //   31: getstatic 1337	com/magmamobile/game/engine/Game:acting	Z
    //   34: ifeq +20 -> 54
    //   37: getstatic 1301	com/magmamobile/game/engine/Game:actionSync	Ljava/lang/Object;
    //   40: astore_0
    //   41: aload_0
    //   42: monitorenter
    //   43: getstatic 1301	com/magmamobile/game/engine/Game:actionSync	Ljava/lang/Object;
    //   46: ldc2_w 74
    //   49: invokevirtual 1316	java/lang/Object:wait	(J)V
    //   52: aload_0
    //   53: monitorexit
    //   54: invokestatic 1319	com/magmamobile/game/engine/Game:syncQuit	()V
    //   57: return
    //   58: getstatic 1321	com/magmamobile/game/engine/Game:ready	Z
    //   61: ifeq +87 -> 148
    //   64: getstatic 1323	com/magmamobile/game/engine/Game:paused	Z
    //   67: ifne +81 -> 148
    //   70: invokestatic 1329	android/os/SystemClock:elapsedRealtime	()J
    //   73: putstatic 1901	com/magmamobile/game/engine/Game:reCurTime	J
    //   76: getstatic 1894	com/magmamobile/game/engine/Game:reNextTime	J
    //   79: getstatic 1901	com/magmamobile/game/engine/Game:reCurTime	J
    //   82: lsub
    //   83: putstatic 1903	com/magmamobile/game/engine/Game:reDeltaTime	J
    //   86: getstatic 1903	com/magmamobile/game/engine/Game:reDeltaTime	J
    //   89: lconst_0
    //   90: lcmp
    //   91: ifgt +44 -> 135
    //   94: getstatic 1901	com/magmamobile/game/engine/Game:reCurTime	J
    //   97: getstatic 1439	com/magmamobile/game/engine/Game:renderFreq	J
    //   100: ladd
    //   101: putstatic 1894	com/magmamobile/game/engine/Game:reNextTime	J
    //   104: getstatic 952	com/magmamobile/game/engine/Game:gameRenderMode	Lcom/magmamobile/game/engine/GameRenderMode;
    //   107: getstatic 1908	com/magmamobile/game/engine/GameRenderMode:OnDemand	Lcom/magmamobile/game/engine/GameRenderMode;
    //   110: if_acmpne +19 -> 129
    //   113: getstatic 1167	com/magmamobile/game/engine/Game:isDirty	Z
    //   116: ifeq -95 -> 21
    //   119: invokestatic 1911	com/magmamobile/game/engine/Game:v0	()V
    //   122: iconst_0
    //   123: putstatic 1167	com/magmamobile/game/engine/Game:isDirty	Z
    //   126: goto -105 -> 21
    //   129: invokestatic 1911	com/magmamobile/game/engine/Game:v0	()V
    //   132: goto -111 -> 21
    //   135: getstatic 1903	com/magmamobile/game/engine/Game:reDeltaTime	J
    //   138: invokestatic 1376	java/lang/Thread:sleep	(J)V
    //   141: goto -120 -> 21
    //   144: astore_0
    //   145: goto -124 -> 21
    //   148: ldc2_w 37
    //   151: invokestatic 1376	java/lang/Thread:sleep	(J)V
    //   154: goto -133 -> 21
    //   157: astore_0
    //   158: goto -137 -> 21
    //   161: astore_1
    //   162: aload_0
    //   163: monitorexit
    //   164: aload_1
    //   165: athrow
    //   166: astore_0
    //   167: goto -113 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   144	1	0	localInterruptedException1	InterruptedException
    //   157	6	0	localInterruptedException2	InterruptedException
    //   166	1	0	localInterruptedException3	InterruptedException
    //   161	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   135	141	144	java/lang/InterruptedException
    //   148	154	157	java/lang/InterruptedException
    //   43	54	161	finally
    //   162	164	161	finally
    //   37	43	166	java/lang/InterruptedException
    //   164	166	166	java/lang/InterruptedException
  }
  
  /* Error */
  protected static final void onRenderCycleSoftware()
  {
    // Byte code:
    //   0: lconst_0
    //   1: putstatic 1894	com/magmamobile/game/engine/Game:reNextTime	J
    //   4: iconst_1
    //   5: putstatic 1896	com/magmamobile/game/engine/Game:reLoop	Z
    //   8: new 4	java/lang/Object
    //   11: dup
    //   12: invokespecial 257	java/lang/Object:<init>	()V
    //   15: putstatic 1312	com/magmamobile/game/engine/Game:renderSync	Ljava/lang/Object;
    //   18: invokestatic 1899	com/magmamobile/game/engine/RenderCounter:restart	()V
    //   21: getstatic 1308	com/magmamobile/game/engine/Game:running	Z
    //   24: ifne +34 -> 58
    //   27: iconst_0
    //   28: putstatic 1896	com/magmamobile/game/engine/Game:reLoop	Z
    //   31: getstatic 1337	com/magmamobile/game/engine/Game:acting	Z
    //   34: ifeq +20 -> 54
    //   37: getstatic 1301	com/magmamobile/game/engine/Game:actionSync	Ljava/lang/Object;
    //   40: astore_0
    //   41: aload_0
    //   42: monitorenter
    //   43: getstatic 1301	com/magmamobile/game/engine/Game:actionSync	Ljava/lang/Object;
    //   46: ldc2_w 74
    //   49: invokevirtual 1316	java/lang/Object:wait	(J)V
    //   52: aload_0
    //   53: monitorexit
    //   54: invokestatic 1319	com/magmamobile/game/engine/Game:syncQuit	()V
    //   57: return
    //   58: getstatic 1321	com/magmamobile/game/engine/Game:ready	Z
    //   61: ifeq +87 -> 148
    //   64: getstatic 1323	com/magmamobile/game/engine/Game:paused	Z
    //   67: ifne +81 -> 148
    //   70: invokestatic 1329	android/os/SystemClock:elapsedRealtime	()J
    //   73: putstatic 1901	com/magmamobile/game/engine/Game:reCurTime	J
    //   76: getstatic 1894	com/magmamobile/game/engine/Game:reNextTime	J
    //   79: getstatic 1901	com/magmamobile/game/engine/Game:reCurTime	J
    //   82: lsub
    //   83: putstatic 1903	com/magmamobile/game/engine/Game:reDeltaTime	J
    //   86: getstatic 1903	com/magmamobile/game/engine/Game:reDeltaTime	J
    //   89: lconst_0
    //   90: lcmp
    //   91: ifgt +44 -> 135
    //   94: getstatic 1901	com/magmamobile/game/engine/Game:reCurTime	J
    //   97: getstatic 1439	com/magmamobile/game/engine/Game:renderFreq	J
    //   100: ladd
    //   101: putstatic 1894	com/magmamobile/game/engine/Game:reNextTime	J
    //   104: getstatic 952	com/magmamobile/game/engine/Game:gameRenderMode	Lcom/magmamobile/game/engine/GameRenderMode;
    //   107: getstatic 1908	com/magmamobile/game/engine/GameRenderMode:OnDemand	Lcom/magmamobile/game/engine/GameRenderMode;
    //   110: if_acmpne +19 -> 129
    //   113: getstatic 1167	com/magmamobile/game/engine/Game:isDirty	Z
    //   116: ifeq -95 -> 21
    //   119: invokestatic 1915	com/magmamobile/game/engine/Game:v1	()V
    //   122: iconst_0
    //   123: putstatic 1167	com/magmamobile/game/engine/Game:isDirty	Z
    //   126: goto -105 -> 21
    //   129: invokestatic 1915	com/magmamobile/game/engine/Game:v1	()V
    //   132: goto -111 -> 21
    //   135: getstatic 1903	com/magmamobile/game/engine/Game:reDeltaTime	J
    //   138: invokestatic 1376	java/lang/Thread:sleep	(J)V
    //   141: goto -120 -> 21
    //   144: astore_0
    //   145: goto -124 -> 21
    //   148: ldc2_w 37
    //   151: invokestatic 1376	java/lang/Thread:sleep	(J)V
    //   154: goto -133 -> 21
    //   157: astore_0
    //   158: goto -137 -> 21
    //   161: astore_1
    //   162: aload_0
    //   163: monitorexit
    //   164: aload_1
    //   165: athrow
    //   166: astore_0
    //   167: goto -113 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   144	1	0	localInterruptedException1	InterruptedException
    //   157	6	0	localInterruptedException2	InterruptedException
    //   166	1	0	localInterruptedException3	InterruptedException
    //   161	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   135	141	144	java/lang/InterruptedException
    //   148	154	157	java/lang/InterruptedException
    //   43	54	161	finally
    //   162	164	161	finally
    //   37	43	166	java/lang/InterruptedException
    //   164	166	166	java/lang/InterruptedException
  }
  
  protected static final void onSensorAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  protected static final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    IGameStage localIGameStage = StageManager.getCurrentStage();
    if ((localIGameStage != null) && (localIGameStage.isActive())) {
      localIGameStage.onSensorEvent(paramSensorEvent);
    }
  }
  
  protected static final void onSurfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (parameters.DEFAULT_RENDERER == 1) {
      dstRect.set(0, 0, displayWidth, displayHeight);
    }
    surfaceWidth = paramInt2;
    surfaceHeight = paramInt3;
    updateRatio();
    if ((mBufferWidth > displayWidth) || (mBufferHeight > displayHeight)) {}
    for (mCLipFix = true;; mCLipFix = false)
    {
      ready = true;
      view.measure(-1, -1);
      return;
    }
  }
  
  protected static final void onSurfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  protected static final void onSurfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    ready = false;
  }
  
  protected static final void onTemporalCycleHardware()
  {
    acNextTime = 0L;
    acLoop = true;
    reLoop = true;
    ActionCounter.restart();
    RenderCounter.restart();
    for (;;)
    {
      if (!running)
      {
        acLoop = false;
        reLoop = false;
        syncQuit();
        return;
      }
      if ((ready) && (!paused))
      {
        acCurTime = SystemClock.elapsedRealtime();
        acDeltaTime = acNextTime - acCurTime;
        if (acDeltaTime <= 0L)
        {
          acNextTime = acCurTime + actionFreq;
          acting = true;
          if (!GameActionStack.hasData())
          {
            if ((StageManager._currentStage != null) && (StageManager._currentStage.isActive())) {
              StageManager._currentStage.onAction();
            }
            Keyboard.clear();
            TouchScreen.clear();
            if (parameters.USE_ACTION_COUNTER) {
              ActionCounter.next();
            }
            drawCanvas = holder.lockCanvas();
            if (drawCanvas != null)
            {
              rendering = true;
              if ((StageManager._currentStage != null) && (StageManager._currentStage.isActive())) {
                StageManager._currentStage.onRender();
              }
              if (mCLipFix) {
                drawCanvas.clipRect(0.0F, 0.0F, mBufferWidth, mBufferHeight, Region.Op.REPLACE);
              }
              if (!opAlias) {
                break label306;
              }
              drawCanvas.setDrawFilter(dwfilter);
              drawCanvas.drawBitmap(buffer, 0.0F, 0.0F, null);
            }
          }
          for (;;)
          {
            holder.unlockCanvasAndPost(drawCanvas);
            if (parameters.USE_RENDER_COUNTER) {
              RenderCounter.next();
            }
            rendering = false;
            tick += 1L;
            break;
            switch (GameActionStack.pop())
            {
            default: 
              break;
            case 4: 
              StageManager.getCurrentStage().onBackButton();
              break;
              label306:
              drawCanvas.drawBitmap(buffer, 0.0F, 0.0F, null);
            }
          }
        }
        try
        {
          Thread.sleep(acDeltaTime);
        }
        catch (InterruptedException localInterruptedException1) {}
      }
      else
      {
        try
        {
          Thread.sleep(1000L);
        }
        catch (InterruptedException localInterruptedException2) {}
      }
    }
  }
  
  protected static final void onTemporalCycleSoftware()
  {
    acNextTime = 0L;
    acLoop = true;
    reLoop = true;
    ActionCounter.restart();
    RenderCounter.restart();
    for (;;)
    {
      if (!running)
      {
        acLoop = false;
        reLoop = false;
        syncQuit();
        return;
      }
      if ((ready) && (!paused))
      {
        acCurTime = SystemClock.elapsedRealtime();
        acDeltaTime = acNextTime - acCurTime;
        if (acDeltaTime <= 0L)
        {
          acNextTime = acCurTime + actionFreq;
          acting = true;
          if (!GameActionStack.hasData())
          {
            if ((StageManager._currentStage != null) && (StageManager._currentStage.isActive())) {
              StageManager._currentStage.onAction();
            }
            Keyboard.clear();
            TouchScreen.clear();
            if (parameters.USE_ACTION_COUNTER) {
              ActionCounter.next();
            }
            drawCanvas = holder.lockCanvas();
            if (drawCanvas != null)
            {
              rendering = true;
              if ((StageManager._currentStage != null) && (StageManager._currentStage.isActive())) {
                StageManager._currentStage.onRender();
              }
              if (!opAlias) {
                break label306;
              }
              if (!mNoStretch) {
                break label278;
              }
              drawCanvas.drawBitmap(buffer, 0.0F, 0.0F, null);
            }
          }
          for (;;)
          {
            holder.unlockCanvasAndPost(drawCanvas);
            if (parameters.USE_RENDER_COUNTER) {
              RenderCounter.next();
            }
            rendering = false;
            tick += 1L;
            break;
            switch (GameActionStack.pop())
            {
            default: 
              break;
            case 4: 
              StageManager.getCurrentStage().onBackButton();
              break;
              label278:
              drawCanvas.setDrawFilter(dwfilter);
              drawCanvas.drawBitmap(buffer, srcRect, dstRect, null);
              continue;
              label306:
              if (mNoStretch) {
                drawCanvas.drawBitmap(buffer, 0.0F, 0.0F, null);
              } else {
                drawCanvas.drawBitmap(buffer, srcRect, dstRect, null);
              }
              break;
            }
          }
        }
        try
        {
          Thread.sleep(acDeltaTime);
        }
        catch (InterruptedException localInterruptedException1) {}
      }
      else
      {
        try
        {
          Thread.sleep(1000L);
        }
        catch (InterruptedException localInterruptedException2) {}
      }
    }
  }
  
  public static final void postAction(int paramInt, Object paramObject)
  {
    mHandler.sendMessage(mHandler.obtainMessage(2, paramInt, 0, paramObject));
  }
  
  public static final boolean postRunnable(Runnable paramRunnable)
  {
    return mHandler.post(paramRunnable);
  }
  
  public static final boolean postRunnableDelayed(Runnable paramRunnable, long paramLong)
  {
    return mHandler.postDelayed(paramRunnable, paramLong);
  }
  
  public static final void pushToast(String paramString)
  {
    mHandler.pushToast(paramString);
  }
  
  public static final InputStreamEx readFile(String paramString)
  {
    paramString = new File(getFilesDir().getAbsolutePath().concat("/").concat(paramString));
    if (paramString.exists()) {
      try
      {
        paramString = new InputStreamEx(paramString);
        return paramString;
      }
      catch (FileNotFoundException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static final void registerJoypad(Joypad paramJoypad)
  {
    if (androidSDKVersion >= 5)
    {
      JoypadUtils_API5.registerJoypad(paramJoypad);
      return;
    }
    JoypadUtils_API4.registerJoypad(paramJoypad);
  }
  
  private static final void res_init()
  {
    try
    {
      Class localClass = Class.forName(appPackageName + ".S");
      res_t = (int[][])localClass.getField("T").get(localClass);
      res_l = (String[])localClass.getField("L").get(localClass);
      res_d = (String[])localClass.getField("D").get(localClass);
      res_lang = null;
      res_langid = -1;
      setLang(null);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static final void restart()
  {
    if (activity == null) {
      return;
    }
    activity.startActivity(new Intent(activity, activity.getClass()));
    System.exit(0);
  }
  
  public static final void restart(Class<?> paramClass)
  {
    if (activity == null) {
      return;
    }
    activity.startActivity(new Intent(activity, paramClass));
    System.exit(0);
  }
  
  protected static final void savePreferences()
  {
    if (!opLoaded) {
      throw new RuntimeException("SavePreferences called before LoadPreferences");
    }
    SharedPreferences.Editor localEditor = getPreferences().edit();
    localEditor.putBoolean("first", false);
    localEditor.putBoolean("vibrate", opVibrate);
    localEditor.putBoolean("haptic", opHaptic);
    localEditor.putBoolean("sound", opSound);
    localEditor.putBoolean("music", opMusic);
    localEditor.putBoolean("aliasing", opAlias);
    localEditor.putBoolean("stretch", opStretch);
    localEditor.putBoolean("wakeup", opWakeup);
    if (soundMngr != null) {
      soundMngr.setStreamVolume(3, opVolume, 0);
    }
    localEditor.commit();
  }
  
  public static final float scalef(float paramFloat)
  {
    float f = paramFloat;
    if (multiplier != 1.0F) {
      f = paramFloat * multiplier;
    }
    return f;
  }
  
  public static final int scalei(float paramFloat)
  {
    if (multiplier == 1.0F) {
      return (int)paramFloat;
    }
    return (int)(multiplier * paramFloat);
  }
  
  public static final int scalei(int paramInt)
  {
    int i = paramInt;
    if (multiplier != 1.0F) {
      i = (int)(paramInt * multiplier);
    }
    return i;
  }
  
  public static final int screenTobufferX(float paramFloat)
  {
    return (int)(mMulRatioX * paramFloat);
  }
  
  public static final int screenTobufferY(float paramFloat)
  {
    return (int)(mMulRatioY * paramFloat);
  }
  
  public static final File screenshot(String paramString)
  {
    synchronized (buffer)
    {
      try
      {
        Object localObject = System.currentTimeMillis();
        paramString = new File(Environment.getExternalStorageDirectory().getPath().concat("/" + paramString + "-" + (String)localObject + ".png"));
        localObject = new FileOutputStream(paramString);
        buffer.compress(Bitmap.CompressFormat.PNG, 90, (OutputStream)localObject);
        ((FileOutputStream)localObject).close();
        activity.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
  }
  
  public static final void setActionRate(GameRate paramGameRate)
  {
    actionRate = paramGameRate;
    actionFreq = paramGameRate.getTime();
  }
  
  public static final void setAliasing(boolean paramBoolean)
  {
    setAntiAliasEnabled(paramBoolean);
  }
  
  public static final void setAntiAliasEnabled(boolean paramBoolean)
  {
    if (opAlias == paramBoolean) {
      return;
    }
    opAlias = paramBoolean;
    savePreferences();
  }
  
  protected static final void setAppOrientation()
  {
    if ((androidSDKVersion >= 11) && (parameters != null))
    {
      int i = parameters.APP_ORIENTATION;
      if (i != -1) {
        activity.setRequestedOrientation(i);
      }
    }
  }
  
  public static final void setBmpTextBitmap(Bitmap paramBitmap)
  {
    charLayer = paramBitmap;
  }
  
  public static final void setBmpTextSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    charRealX = paramInt1;
    charRealY = paramInt2;
    charXSpace = paramInt3;
    charYSpace = paramInt4;
  }
  
  public static final void setColorMode(int paramInt)
  {
    colorMode = paramInt;
  }
  
  protected static void setContext(GameActivity paramGameActivity)
  {
    activity = paramGameActivity;
    try
    {
      packageInfo = activity.getPackageManager().getPackageInfo(appPackageName, 0);
      appVersionCode = packageInfo.versionCode;
      appVersionName = packageInfo.versionName;
      Rstring = getRClass("string");
      Rdrawable = getRClass("drawable");
      Rlayout = getRClass("layout");
      Rid = getRClass("id");
      return;
    }
    catch (PackageManager.NameNotFoundException paramGameActivity)
    {
      for (;;)
      {
        paramGameActivity.printStackTrace();
      }
    }
  }
  
  protected static void setDisplayData(WindowManager paramWindowManager)
  {
    paramWindowManager = paramWindowManager.getDefaultDisplay();
    displayWidth = paramWindowManager.getWidth();
    displayHeight = paramWindowManager.getHeight();
    if (displayHeight >= displayWidth) {}
    for (int i = 0;; i = 1)
    {
      orientation = i;
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramWindowManager.getMetrics(localDisplayMetrics);
      density = localDisplayMetrics.density;
      return;
    }
  }
  
  protected static final void setFullScreen()
  {
    hideActionBar = false;
    View localView = activity.getWindow().getDecorView();
    featureWrapper.setSystemUiVisibility(localView, 1);
  }
  
  public static final void setHapticEnable(boolean paramBoolean)
  {
    if (opHaptic == paramBoolean) {
      return;
    }
    opHaptic = paramBoolean;
    savePreferences();
  }
  
  public static final void setLang(String paramString)
  {
    Object localObject2 = null;
    int j = -1;
    Object localObject1 = localObject2;
    int i = j;
    if (paramString != null)
    {
      localObject1 = paramString.toLowerCase();
      i = 0;
    }
    for (;;)
    {
      if (i >= res_l.length)
      {
        i = j;
        localObject1 = localObject2;
      }
      while (res_l[i].equals(localObject1))
      {
        if (res_langid != i)
        {
          paramString = res_lang;
          res_langid = i;
          res_lang = (String)localObject1;
          res_cache = null;
          application.onEngineLanguageChanged(paramString, (String)localObject1);
        }
        return;
      }
      i += 1;
    }
  }
  
  public static final void setLayerTypeSofware(View paramView)
  {
    featureWrapper.setLayerTypeSofware(paramView);
  }
  
  public static final void setMultiplier(float paramFloat)
  {
    multiplier = paramFloat;
  }
  
  public static final void setMusicEnable(boolean paramBoolean)
  {
    if (opMusic == paramBoolean) {
      return;
    }
    opMusic = paramBoolean;
    savePreferences();
  }
  
  public static void setNinePatchSize(int paramInt)
  {
    ninePatchSize1 = paramInt;
    ninePatchSize2 = ninePatchSize1 * 2;
    ninePatchSize3 = ninePatchSize1 * 3;
  }
  
  public static final void setPrefBoolean(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = getPreferences().edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.commit();
  }
  
  public static final void setPrefFloat(String paramString, float paramFloat)
  {
    SharedPreferences.Editor localEditor = getPreferences().edit();
    localEditor.putFloat(paramString, paramFloat);
    localEditor.commit();
  }
  
  public static final void setPrefInt(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = getPreferences().edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.commit();
  }
  
  public static final void setPrefLong(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = getPreferences().edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.commit();
  }
  
  public static final void setPrefString(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = getPreferences().edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  public static final void setRate(GameRate paramGameRate)
  {
    renderRate = paramGameRate;
    actionRate = paramGameRate;
    renderFreq = paramGameRate.getTime();
    actionFreq = paramGameRate.getTime();
  }
  
  public static final void setRenderMode(GameRenderMode paramGameRenderMode)
  {
    gameRenderMode = paramGameRenderMode;
  }
  
  public static final void setRenderRate(GameRate paramGameRate)
  {
    renderRate = paramGameRate;
    renderFreq = paramGameRate.getTime();
  }
  
  public static final void setSoundEnable(boolean paramBoolean)
  {
    if (opSound == paramBoolean) {
      return;
    }
    opSound = paramBoolean;
    savePreferences();
  }
  
  public static void setStage(int paramInt)
  {
    StageManager.setStage(paramInt);
  }
  
  public static void setTouchMode(int paramInt)
  {
    _touchmode = paramInt;
  }
  
  public static final void setVibrateEnable(boolean paramBoolean)
  {
    if (opVibrate == paramBoolean) {
      return;
    }
    opVibrate = paramBoolean;
    savePreferences();
  }
  
  public static final void setVolume(int paramInt)
  {
    if (soundMngr == null) {}
    while (opVolume == paramInt) {
      return;
    }
    opVolume = paramInt;
    if (opVolume <= 0)
    {
      opSound = false;
      opVolume = 0;
    }
    for (;;)
    {
      savePreferences();
      return;
      opSound = true;
      if (opVolume > 15) {
        opVolume = 15;
      }
    }
  }
  
  public static final void setWakeupEnable(boolean paramBoolean)
  {
    if (opWakeup == paramBoolean) {
      return;
    }
    opWakeup = paramBoolean;
    if (view != null) {
      mHandler.post(new Runnable()
      {
        public void run()
        {
          Game.view.setKeepScreenOn(this.val$v);
        }
      });
    }
    savePreferences();
  }
  
  public static final void showAlertDialog(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new AlertDialog.Builder(paramContext);
    paramContext.setMessage(paramString2);
    paramContext.setTitle(paramString1);
    paramContext.show();
  }
  
  public static final void showAlertDialog(String paramString1, String paramString2)
  {
    showAlertDialog(activity, paramString1, paramString2);
  }
  
  public static final void showBanner()
  {
    if (adBanner != null) {
      adBanner.show();
    }
  }
  
  public static final boolean showBrowser(String paramString)
  {
    try
    {
      activity.startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(paramString)), -1);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static final boolean showFacebookPage()
  {
    return showBrowser("https://m.facebook.com/MagmaMobile?v=feed");
  }
  
  public static final boolean showMarket(String paramString)
  {
    return marketWrapper.showGame(paramString);
  }
  
  public static final boolean showMarket(String paramString1, String paramString2)
  {
    return marketWrapper.showGame(paramString1, paramString2);
  }
  
  public static final boolean showMarketPublisher()
  {
    return marketWrapper.showPublisher();
  }
  
  public static final boolean showMarketPublisher(String paramString)
  {
    return marketWrapper.showPublisher(paramString);
  }
  
  public static final boolean showMarketUpdate()
  {
    return marketWrapper.showCurrentGame();
  }
  
  public static final boolean showMarketUpdate(String paramString)
  {
    return marketWrapper.showCurrentGame(paramString);
  }
  
  public static final void showMoreGames()
  {
    try
    {
      activity.startActivityForResult(new Intent(activity, MMUSIAMoreGamesActivity.class), 1);
      return;
    }
    catch (Exception localException) {}
  }
  
  public static final boolean showPrivacyPolicy()
  {
    return showBrowser("http://www.magmamobile.com/privacypolicy");
  }
  
  public static final void showSquare()
  {
    if (adSquare != null) {
      adSquare.show();
    }
  }
  
  public static final void sleep(long paramLong)
  {
    try
    {
      Thread.sleep(paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  private static void syncQuit()
  {
    if ((!acLoop) && (!reLoop))
    {
      if ((activity != null) && (StageManager.isQuit()))
      {
        StageManager.free();
        activity.finish();
      }
      application.onEngineTerminate();
      freeAllMusic();
    }
  }
  
  public static final void toast(int paramInt)
  {
    mHandler.pushToast(getResString(paramInt));
  }
  
  public static final void toast(String paramString)
  {
    mHandler.pushToast(paramString);
  }
  
  public static final void unregisterJoypad(Joypad paramJoypad)
  {
    if (androidSDKVersion >= 5)
    {
      JoypadUtils_API5.unregisterJoypad(paramJoypad);
      return;
    }
    JoypadUtils_API4.unregisterJoypad(paramJoypad);
  }
  
  protected static final void updateRatio()
  {
    mDivRatioX = displayWidth / mBufferWidth;
    mDivRatioY = displayHeight / mBufferHeight;
    mMulRatioX = mBufferWidth / displayWidth;
    mMulRatioY = mBufferHeight / displayHeight;
  }
  
  /* Error */
  private static final void v0()
  {
    // Byte code:
    //   0: getstatic 1503	com/magmamobile/game/engine/Game:holder	Landroid/view/SurfaceHolder;
    //   3: invokeinterface 1937 1 0
    //   8: putstatic 1939	com/magmamobile/game/engine/Game:drawCanvas	Landroid/graphics/Canvas;
    //   11: getstatic 1939	com/magmamobile/game/engine/Game:drawCanvas	Landroid/graphics/Canvas;
    //   14: ifnonnull +4 -> 18
    //   17: return
    //   18: getstatic 1337	com/magmamobile/game/engine/Game:acting	Z
    //   21: ifeq +20 -> 41
    //   24: getstatic 1301	com/magmamobile/game/engine/Game:actionSync	Ljava/lang/Object;
    //   27: astore_0
    //   28: aload_0
    //   29: monitorenter
    //   30: getstatic 1301	com/magmamobile/game/engine/Game:actionSync	Ljava/lang/Object;
    //   33: ldc2_w 74
    //   36: invokevirtual 1316	java/lang/Object:wait	(J)V
    //   39: aload_0
    //   40: monitorexit
    //   41: iconst_1
    //   42: putstatic 1310	com/magmamobile/game/engine/Game:rendering	Z
    //   45: getstatic 766	com/magmamobile/game/engine/StageManager:_currentStage	Lcom/magmamobile/game/engine/IGameStage;
    //   48: ifnull +22 -> 70
    //   51: getstatic 766	com/magmamobile/game/engine/StageManager:_currentStage	Lcom/magmamobile/game/engine/IGameStage;
    //   54: invokeinterface 1345 1 0
    //   59: ifeq +11 -> 70
    //   62: getstatic 766	com/magmamobile/game/engine/StageManager:_currentStage	Lcom/magmamobile/game/engine/IGameStage;
    //   65: invokeinterface 1942 1 0
    //   70: getstatic 1926	com/magmamobile/game/engine/Game:mCLipFix	Z
    //   73: ifeq +23 -> 96
    //   76: getstatic 1939	com/magmamobile/game/engine/Game:drawCanvas	Landroid/graphics/Canvas;
    //   79: fconst_0
    //   80: fconst_0
    //   81: getstatic 265	com/magmamobile/game/engine/Game:mBufferWidth	I
    //   84: i2f
    //   85: getstatic 267	com/magmamobile/game/engine/Game:mBufferHeight	I
    //   88: i2f
    //   89: getstatic 325	android/graphics/Region$Op:REPLACE	Landroid/graphics/Region$Op;
    //   92: invokevirtual 329	android/graphics/Canvas:clipRect	(FFFFLandroid/graphics/Region$Op;)Z
    //   95: pop
    //   96: getstatic 722	com/magmamobile/game/engine/Game:opAlias	Z
    //   99: ifeq +80 -> 179
    //   102: getstatic 1939	com/magmamobile/game/engine/Game:drawCanvas	Landroid/graphics/Canvas;
    //   105: getstatic 1571	com/magmamobile/game/engine/Game:dwfilter	Landroid/graphics/PaintFlagsDrawFilter;
    //   108: invokevirtual 1575	android/graphics/Canvas:setDrawFilter	(Landroid/graphics/DrawFilter;)V
    //   111: getstatic 1939	com/magmamobile/game/engine/Game:drawCanvas	Landroid/graphics/Canvas;
    //   114: getstatic 1566	com/magmamobile/game/engine/Game:buffer	Landroid/graphics/Bitmap;
    //   117: fconst_0
    //   118: fconst_0
    //   119: aconst_null
    //   120: invokevirtual 286	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   123: getstatic 1503	com/magmamobile/game/engine/Game:holder	Landroid/view/SurfaceHolder;
    //   126: getstatic 1939	com/magmamobile/game/engine/Game:drawCanvas	Landroid/graphics/Canvas;
    //   129: invokeinterface 1946 2 0
    //   134: getstatic 866	com/magmamobile/game/engine/Game:parameters	Lcom/magmamobile/game/engine/AppParameters;
    //   137: getfield 1949	com/magmamobile/game/engine/AppParameters:USE_RENDER_COUNTER	Z
    //   140: ifeq +6 -> 146
    //   143: invokestatic 1950	com/magmamobile/game/engine/RenderCounter:next	()V
    //   146: iconst_0
    //   147: putstatic 1310	com/magmamobile/game/engine/Game:rendering	Z
    //   150: getstatic 1312	com/magmamobile/game/engine/Game:renderSync	Ljava/lang/Object;
    //   153: astore_0
    //   154: aload_0
    //   155: monitorenter
    //   156: getstatic 1312	com/magmamobile/game/engine/Game:renderSync	Ljava/lang/Object;
    //   159: invokevirtual 1365	java/lang/Object:notifyAll	()V
    //   162: aload_0
    //   163: monitorexit
    //   164: return
    //   165: astore_1
    //   166: aload_0
    //   167: monitorexit
    //   168: aload_1
    //   169: athrow
    //   170: astore_1
    //   171: aload_0
    //   172: monitorexit
    //   173: aload_1
    //   174: athrow
    //   175: astore_0
    //   176: goto -135 -> 41
    //   179: getstatic 1939	com/magmamobile/game/engine/Game:drawCanvas	Landroid/graphics/Canvas;
    //   182: getstatic 1566	com/magmamobile/game/engine/Game:buffer	Landroid/graphics/Bitmap;
    //   185: fconst_0
    //   186: fconst_0
    //   187: aconst_null
    //   188: invokevirtual 286	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   191: goto -68 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   175	1	0	localInterruptedException	InterruptedException
    //   165	4	1	localObject2	Object
    //   170	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   156	164	165	finally
    //   166	168	165	finally
    //   30	41	170	finally
    //   171	173	170	finally
    //   24	30	175	java/lang/InterruptedException
    //   173	175	175	java/lang/InterruptedException
  }
  
  /* Error */
  private static final void v1()
  {
    // Byte code:
    //   0: getstatic 1503	com/magmamobile/game/engine/Game:holder	Landroid/view/SurfaceHolder;
    //   3: invokeinterface 1937 1 0
    //   8: putstatic 1939	com/magmamobile/game/engine/Game:drawCanvas	Landroid/graphics/Canvas;
    //   11: getstatic 1939	com/magmamobile/game/engine/Game:drawCanvas	Landroid/graphics/Canvas;
    //   14: ifnonnull +4 -> 18
    //   17: return
    //   18: getstatic 1337	com/magmamobile/game/engine/Game:acting	Z
    //   21: ifeq +20 -> 41
    //   24: getstatic 1301	com/magmamobile/game/engine/Game:actionSync	Ljava/lang/Object;
    //   27: astore_0
    //   28: aload_0
    //   29: monitorenter
    //   30: getstatic 1301	com/magmamobile/game/engine/Game:actionSync	Ljava/lang/Object;
    //   33: ldc2_w 74
    //   36: invokevirtual 1316	java/lang/Object:wait	(J)V
    //   39: aload_0
    //   40: monitorexit
    //   41: iconst_1
    //   42: putstatic 1310	com/magmamobile/game/engine/Game:rendering	Z
    //   45: getstatic 766	com/magmamobile/game/engine/StageManager:_currentStage	Lcom/magmamobile/game/engine/IGameStage;
    //   48: ifnull +22 -> 70
    //   51: getstatic 766	com/magmamobile/game/engine/StageManager:_currentStage	Lcom/magmamobile/game/engine/IGameStage;
    //   54: invokeinterface 1345 1 0
    //   59: ifeq +11 -> 70
    //   62: getstatic 766	com/magmamobile/game/engine/StageManager:_currentStage	Lcom/magmamobile/game/engine/IGameStage;
    //   65: invokeinterface 1942 1 0
    //   70: getstatic 722	com/magmamobile/game/engine/Game:opAlias	Z
    //   73: ifeq +105 -> 178
    //   76: getstatic 1420	com/magmamobile/game/engine/Game:mNoStretch	Z
    //   79: ifeq +71 -> 150
    //   82: getstatic 1939	com/magmamobile/game/engine/Game:drawCanvas	Landroid/graphics/Canvas;
    //   85: getstatic 1566	com/magmamobile/game/engine/Game:buffer	Landroid/graphics/Bitmap;
    //   88: fconst_0
    //   89: fconst_0
    //   90: aconst_null
    //   91: invokevirtual 286	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   94: getstatic 1503	com/magmamobile/game/engine/Game:holder	Landroid/view/SurfaceHolder;
    //   97: getstatic 1939	com/magmamobile/game/engine/Game:drawCanvas	Landroid/graphics/Canvas;
    //   100: invokeinterface 1946 2 0
    //   105: getstatic 866	com/magmamobile/game/engine/Game:parameters	Lcom/magmamobile/game/engine/AppParameters;
    //   108: getfield 1949	com/magmamobile/game/engine/AppParameters:USE_RENDER_COUNTER	Z
    //   111: ifeq +6 -> 117
    //   114: invokestatic 1950	com/magmamobile/game/engine/RenderCounter:next	()V
    //   117: iconst_0
    //   118: putstatic 1310	com/magmamobile/game/engine/Game:rendering	Z
    //   121: getstatic 1312	com/magmamobile/game/engine/Game:renderSync	Ljava/lang/Object;
    //   124: astore_0
    //   125: aload_0
    //   126: monitorenter
    //   127: getstatic 1312	com/magmamobile/game/engine/Game:renderSync	Ljava/lang/Object;
    //   130: invokevirtual 1365	java/lang/Object:notifyAll	()V
    //   133: aload_0
    //   134: monitorexit
    //   135: return
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    //   146: astore_0
    //   147: goto -106 -> 41
    //   150: getstatic 1939	com/magmamobile/game/engine/Game:drawCanvas	Landroid/graphics/Canvas;
    //   153: getstatic 1571	com/magmamobile/game/engine/Game:dwfilter	Landroid/graphics/PaintFlagsDrawFilter;
    //   156: invokevirtual 1575	android/graphics/Canvas:setDrawFilter	(Landroid/graphics/DrawFilter;)V
    //   159: getstatic 1939	com/magmamobile/game/engine/Game:drawCanvas	Landroid/graphics/Canvas;
    //   162: getstatic 1566	com/magmamobile/game/engine/Game:buffer	Landroid/graphics/Bitmap;
    //   165: getstatic 1613	com/magmamobile/game/engine/Game:srcRect	Landroid/graphics/Rect;
    //   168: getstatic 1615	com/magmamobile/game/engine/Game:dstRect	Landroid/graphics/Rect;
    //   171: aconst_null
    //   172: invokevirtual 433	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   175: goto -81 -> 94
    //   178: getstatic 1420	com/magmamobile/game/engine/Game:mNoStretch	Z
    //   181: ifeq +18 -> 199
    //   184: getstatic 1939	com/magmamobile/game/engine/Game:drawCanvas	Landroid/graphics/Canvas;
    //   187: getstatic 1566	com/magmamobile/game/engine/Game:buffer	Landroid/graphics/Bitmap;
    //   190: fconst_0
    //   191: fconst_0
    //   192: aconst_null
    //   193: invokevirtual 286	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   196: goto -102 -> 94
    //   199: getstatic 1939	com/magmamobile/game/engine/Game:drawCanvas	Landroid/graphics/Canvas;
    //   202: getstatic 1566	com/magmamobile/game/engine/Game:buffer	Landroid/graphics/Bitmap;
    //   205: getstatic 1613	com/magmamobile/game/engine/Game:srcRect	Landroid/graphics/Rect;
    //   208: getstatic 1615	com/magmamobile/game/engine/Game:dstRect	Landroid/graphics/Rect;
    //   211: aconst_null
    //   212: invokevirtual 433	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   215: goto -121 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   146	1	0	localInterruptedException	InterruptedException
    //   136	4	1	localObject2	Object
    //   141	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   127	135	136	finally
    //   137	139	136	finally
    //   30	41	141	finally
    //   142	144	141	finally
    //   24	30	146	java/lang/InterruptedException
    //   144	146	146	java/lang/InterruptedException
  }
  
  public static final void vibrate(long paramLong)
  {
    if ((!opVibrate) || (vibrator == null)) {
      return;
    }
    vibrator.vibrate(paramLong);
  }
  
  public static final void vibrate(long[] paramArrayOfLong, int paramInt)
  {
    if ((!opVibrate) || (vibrator == null)) {
      return;
    }
    vibrator.vibrate(paramArrayOfLong, paramInt);
  }
  
  public static final void volumeDown()
  {
    setVolume(opVolume - 1);
  }
  
  public static final void volumeUp()
  {
    setVolume(opVolume + 1);
  }
  
  public static final OutputStreamEx writeFile(String paramString)
  {
    paramString = new File(getFilesDir().getAbsolutePath().concat("/").concat(paramString));
    try
    {
      paramString = new OutputStreamEx(paramString);
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/Game.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */