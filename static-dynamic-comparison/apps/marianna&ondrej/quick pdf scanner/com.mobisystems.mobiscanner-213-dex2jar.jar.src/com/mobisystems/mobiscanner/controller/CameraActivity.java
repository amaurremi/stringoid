package com.mobisystems.mobiscanner.controller;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.Transformation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.analytics.tracking.android.l;
import com.mobisystems.mobiscanner.common.CameraPreferences;
import com.mobisystems.mobiscanner.common.CameraPreferences.b;
import com.mobisystems.mobiscanner.common.CameraPreferences.h;
import com.mobisystems.mobiscanner.common.CameraPreferences.k;
import com.mobisystems.mobiscanner.common.CommonPreferences.Keys;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.common.d.a;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.mobiscanner.model.b;
import com.sonymobile.camera.addon.capturingmode.CapturingModeSelector;
import com.sonymobile.camera.addon.capturingmode.CapturingModeSelector.OnModeFinishListener;
import com.sonymobile.camera.addon.capturingmode.CapturingModeSelector.OnModeSelectListener;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class CameraActivity
  extends SherlockFragmentActivity
  implements Camera.PictureCallback, Camera.ShutterCallback, SensorEventListener, View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, CompoundButton.OnCheckedChangeListener, d, k
{
  private static final com.mobisystems.mobiscanner.common.c apd = new com.mobisystems.mobiscanner.common.c();
  private static boolean axT = false;
  private static boolean axX;
  private CapturingModeSelector axU = null;
  private int axV = 0;
  private String axW = null;
  private boolean axY = false;
  private b axZ = null;
  private int ayA = 1;
  private int ayB = 0;
  private long ayC = 0L;
  private boolean ayD = false;
  private boolean ayE = false;
  private Timer ayF = null;
  private a ayG = null;
  private boolean ayH = false;
  private d.a ayI;
  private Sensor ayJ;
  private float[] ayK;
  private float[] ayL;
  private boolean aya = true;
  private boolean ayb = false;
  private Object ayc = new Object();
  private com.mobisystems.mobiscanner.image.a ayd;
  private Camera aye;
  private CameraPreview ayf;
  private ViewGroup ayg;
  private ViewGroup ayh;
  private TextView ayi;
  private TextView ayj;
  private ImageView ayk;
  private CheckBox ayl;
  private g aym;
  private int ayn;
  private f ayo;
  private SensorManager ayp;
  private Sensor ayq;
  private boolean ayr;
  private boolean ays = false;
  private long ayt = 0L;
  private long ayu = 0L;
  private Timer ayv = null;
  private h ayw = null;
  private int ayx;
  private int ayy = 0;
  private int ayz = 0;
  private final com.mobisystems.mobiscanner.common.c mLog = new com.mobisystems.mobiscanner.common.c(this);
  private boolean mResumed = false;
  
  static
  {
    try
    {
      Class.forName("com.sonymobile.camera.addon.capturingmode.CapturingModeSelector");
      axT = true;
      axX = false;
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        apd.h("ClassNotFoundException while loading Sony Camera Add On Framework", localClassNotFoundException);
      }
    }
    catch (LinkageError localLinkageError)
    {
      for (;;)
      {
        apd.h("LinkageError while loading Sony Camera Add On Framework", localLinkageError);
      }
    }
  }
  
  private void EA()
  {
    if (!this.ays) {
      new e().show(getSupportFragmentManager(), "CAMERA_SETTINGS");
    }
  }
  
  private void EB()
  {
    CameraPreferences.b localb = (CameraPreferences.b)CameraPreferences.apb.CW();
    this.ayl.setChecked(localb.Da());
  }
  
  private boolean EC()
  {
    CameraPreferences.b localb = (CameraPreferences.b)CameraPreferences.apc.CW();
    if (localb != null) {
      return localb.Da();
    }
    return false;
  }
  
  private void ED()
  {
    this.ayE = false;
    if (this.ayG != null)
    {
      this.ayG.cancel();
      this.ayG = null;
    }
  }
  
  private void EE()
  {
    CameraPreferences.k localk = (CameraPreferences.k)CameraPreferences.aoS.CW();
    String str1;
    if (localk != null)
    {
      String str2 = localk.Di();
      str1 = str2;
      if (!"auto".equals(str2))
      {
        str1 = str2;
        if (!"on".equals(str2))
        {
          str1 = str2;
          if (!"torch".equals(str2))
          {
            str1 = str2;
            if (!"off".equals(str2))
            {
              str1 = "off";
              if (localk.db("off") >= 0)
              {
                Ey();
                str1 = "off";
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      dz(str1);
      return;
      this.mLog.A("Could not set initial flash mode");
      continue;
      str1 = null;
    }
  }
  
  private void EF()
  {
    Object localObject1;
    CameraPreferences.k localk;
    int j;
    Object localObject2;
    int i;
    if (!this.ays)
    {
      localObject1 = null;
      localk = (CameraPreferences.k)CameraPreferences.aoS.CW();
      if (localk != null)
      {
        String str = localk.Di();
        j = -1;
        localObject2 = str;
        while ("auto".equals(localObject2))
        {
          localObject1 = "on";
          j = localk.db("on");
          i = j;
          if (j < 0)
          {
            localObject1 = "torch";
            i = localk.db("torch");
          }
          if (i < 0)
          {
            j = i;
            localObject2 = localObject1;
            if (!str.equals(localObject1)) {
              break;
            }
          }
          else
          {
            if (i < 0) {
              break label193;
            }
            Ey();
          }
        }
      }
    }
    for (;;)
    {
      dz((String)localObject1);
      return;
      if (("on".equals(localObject2)) || ("torch".equals(localObject2)))
      {
        localObject1 = "off";
        i = localk.db("off");
        break;
      }
      i = j;
      localObject1 = localObject2;
      if (!"off".equals(localObject2)) {
        break;
      }
      localObject1 = "auto";
      i = localk.db("auto");
      break;
      label193:
      this.mLog.A("Could not toggle flash mode");
    }
  }
  
  private void EG()
  {
    if ((!this.ays) && (this.axU != null))
    {
      this.axU.open("QUICK_PDF_SCANNER");
      this.ayg.setVisibility(4);
      this.ayh.setVisibility(4);
      this.ayf.EY();
    }
  }
  
  @TargetApi(17)
  private void EH()
  {
    if ((com.mobisystems.mobiscanner.common.d.DA()) && (this.aye != null)) {
      this.aye.enableShutterSound(false);
    }
  }
  
  private void EI()
  {
    if ((axX) && ("QUICK_PDF_SCANNER".equals(this.axW)) && (this.axZ.IL() > 0))
    {
      EL();
      return;
    }
    if ("QUICK_PDF_SCANNER".equals(this.axW))
    {
      String str = EM();
      this.mLog.dl("Base activity: " + str);
      boolean bool = str.equals(DocumentListActivity.class.getSimpleName());
      if ((this.aya) && (bool)) {
        EK();
      }
    }
    a(this.axZ);
  }
  
  private void EJ()
  {
    if (this.axZ.IL() > 0)
    {
      if ((axX) && ("QUICK_PDF_SCANNER".equals(this.axW))) {
        EL();
      }
    }
    else {
      return;
    }
    a(this.axZ);
  }
  
  private void EK()
  {
    com.mobisystems.mobiscanner.common.d.ao(this);
    finish();
  }
  
  private void EL()
  {
    ag localag = new ag();
    Bundle localBundle = new Bundle();
    this.axZ.p(localBundle);
    localag.setArguments(localBundle);
    localag.show(getSupportFragmentManager(), "PAGE_ADD");
  }
  
  private String EM()
  {
    Object localObject = ((ActivityManager)getSystemService("activity")).getRunningTasks(1).iterator();
    if (((Iterator)localObject).hasNext())
    {
      String str = ((ActivityManager.RunningTaskInfo)((Iterator)localObject).next()).baseActivity.getShortClassName();
      int i = str.lastIndexOf('.');
      localObject = str;
      if (i >= 0) {
        localObject = str.substring(i + 1);
      }
      return (String)localObject;
    }
    return "";
  }
  
  private void Ep()
  {
    this.ayg = ((ViewGroup)findViewById(2131165284));
    this.ayg.bringToFront();
    this.ayg.setVisibility(0);
    this.ayh = ((ViewGroup)findViewById(2131165292));
    this.ayh.bringToFront();
    this.ayh.setVisibility(0);
    this.ayi = ((TextView)findViewById(2131165289));
    this.ayi.bringToFront();
    if ((axT) && (this.ayA != 0)) {
      e(this.ayi, 90.0F);
    }
    this.ayk = ((ImageView)findViewById(2131165286));
    this.ayj = ((TextView)findViewById(2131165287));
    this.ayj.bringToFront();
    this.ayl = ((CheckBox)findViewById(2131165295));
    if (this.ayA == 0) {
      e(this.ayl, 90.0F);
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams1 = (ViewGroup.MarginLayoutParams)this.ayg.getLayoutParams();
    ViewGroup.MarginLayoutParams localMarginLayoutParams2 = (ViewGroup.MarginLayoutParams)this.ayh.getLayoutParams();
    int i;
    if (this.ayA == 0)
    {
      i = this.ayI.height * 4 / 3;
      i = this.ayI.width - i;
      if (i > localMarginLayoutParams1.width + localMarginLayoutParams2.width)
      {
        localMarginLayoutParams1.width = (i / 2);
        localMarginLayoutParams2.width = (i / 2);
      }
    }
    for (;;)
    {
      this.ayg.setLayoutParams(localMarginLayoutParams1);
      this.ayh.setLayoutParams(localMarginLayoutParams2);
      return;
      if (i > localMarginLayoutParams2.width)
      {
        localMarginLayoutParams2.width = i;
        this.ayH = true;
        continue;
        i = this.ayI.width * 4 / 3;
        i = this.ayI.height - i;
        if (i > localMarginLayoutParams1.height + localMarginLayoutParams2.height)
        {
          localMarginLayoutParams1.height = (i / 2);
          localMarginLayoutParams2.height = (i / 2);
        }
        else if (i > localMarginLayoutParams2.height)
        {
          localMarginLayoutParams2.height = i;
          this.ayH = true;
        }
      }
    }
  }
  
  private void Eq()
  {
    Object localObject = (CameraPreferences.h)CameraPreferences.aoT.CW();
    ViewGroup.MarginLayoutParams localMarginLayoutParams1;
    int i;
    ViewGroup.MarginLayoutParams localMarginLayoutParams2;
    if ((localObject != null) && (((CameraPreferences.h)localObject).De()))
    {
      localObject = (ViewGroup.MarginLayoutParams)this.ayg.getLayoutParams();
      localMarginLayoutParams1 = (ViewGroup.MarginLayoutParams)this.ayh.getLayoutParams();
      if (this.ayA != 0) {
        break label162;
      }
      i = this.ayI.width * 9 / 16;
      if (i < this.ayI.height)
      {
        ((ViewGroup.MarginLayoutParams)localObject).height = i;
        localMarginLayoutParams1.height = i;
        localMarginLayoutParams2 = (ViewGroup.MarginLayoutParams)this.ayi.getLayoutParams();
        localMarginLayoutParams2.topMargin = ((this.ayI.height - i) / 2 + getResources().getDimensionPixelOffset(2131230795));
        this.ayi.setLayoutParams(localMarginLayoutParams2);
      }
    }
    for (;;)
    {
      this.ayg.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.ayh.setLayoutParams(localMarginLayoutParams1);
      getWindow().getDecorView().requestLayout();
      return;
      label162:
      i = (this.ayI.height + this.ayI.awD) * 9 / 16;
      if (i < this.ayI.width)
      {
        ((ViewGroup.MarginLayoutParams)localObject).width = i;
        localMarginLayoutParams1.width = i;
      }
      if (axT)
      {
        localMarginLayoutParams2 = (ViewGroup.MarginLayoutParams)this.ayi.getLayoutParams();
        localMarginLayoutParams2.topMargin = ((this.ayI.width - i) / 2 + getResources().getDimensionPixelOffset(2131230795));
        this.ayi.setLayoutParams(localMarginLayoutParams2);
      }
    }
  }
  
  private void Er()
  {
    if (this.axZ.getId() >= 0L)
    {
      if ((!axX) || (!"QUICK_PDF_SCANNER".equals(this.axW))) {
        this.ayi.setText(this.axZ.getName());
      }
      if (this.axZ.IL() > 0) {
        this.ayj.setText(String.valueOf(this.axZ.IL()));
      }
      return;
    }
    this.ayi.setText("");
    this.ayj.setText("");
  }
  
  private void Es()
  {
    a(this.ayg, this, this);
    a(this.ayh, this, this);
    findViewById(2131165294).setOnTouchListener(this);
    if (axT) {
      findViewById(2131165297).setOnTouchListener(this);
    }
    this.ayf.setOnClickListener(this);
    this.aym = new g(this);
    this.aym.enable();
  }
  
  private void Et()
  {
    this.aye = Ex();
    if (this.aye != null)
    {
      this.mLog.dl("Camera allocated");
      this.ayn = Ev();
      this.ayx = -1;
      Camera.Parameters localParameters = this.aye.getParameters();
      CameraPreferences.a(this, localParameters);
      localParameters = CameraPreferences.a(localParameters);
      this.aye.setParameters(localParameters);
      EH();
      this.ayf.a(this.aye, this.ayn);
    }
  }
  
  private void Eu()
  {
    this.ayf.a(null, 0);
    if (this.aye != null)
    {
      this.aye.release();
      this.aye = null;
      this.mLog.dl("Camera released ");
      return;
    }
    this.mLog.dl("releaseCamera: camera object is null ");
  }
  
  private int Ev()
  {
    int j = 0;
    int k = Ew();
    int m = getWindowManager().getDefaultDisplay().getRotation();
    int i = j;
    switch (m)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      i = (k - i + 360) % 360;
      this.mLog.dl("setCameraDisplayOrientation, Camera Orientation=" + k + ", Inital Display Rotation=" + this.ayI.rotation + ", Current Display Rotation=" + m + ", Camera setDisplayOrientation=" + i);
      this.aye.setDisplayOrientation(i);
      return i;
      i = 90;
      continue;
      i = 180;
      continue;
      i = 270;
    }
  }
  
  @TargetApi(9)
  private static int Ew()
  {
    int j = 90;
    int i = j;
    Camera.CameraInfo localCameraInfo;
    if (com.mobisystems.mobiscanner.common.d.Dv())
    {
      int k = Camera.getNumberOfCameras();
      i = 0;
      if (i >= k) {
        break label62;
      }
      localCameraInfo = new Camera.CameraInfo();
      Camera.getCameraInfo(i, localCameraInfo);
      if (localCameraInfo.facing != 0) {
        break label55;
      }
    }
    for (;;)
    {
      i = j;
      if (localCameraInfo != null) {
        i = localCameraInfo.orientation;
      }
      return i;
      label55:
      i += 1;
      break;
      label62:
      localCameraInfo = null;
    }
  }
  
  private static Camera Ex()
  {
    Object localObject2 = null;
    int j = com.mobisystems.mobiscanner.common.d.Du();
    int i = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i < 5) {}
      try
      {
        localObject1 = gc(j);
        return (Camera)localObject1;
      }
      catch (RuntimeException localRuntimeException)
      {
        apd.D("Camera is used by another process.");
        try
        {
          Thread.sleep(500L);
          i += 1;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            apd.dl("Retry to open the camera device.");
          }
        }
      }
      catch (Exception localException)
      {
        apd.g("Could not get camera instance", localException);
      }
    }
    return null;
  }
  
  private void Ey()
  {
    if (this.aye != null) {
      this.ayf.Ey();
    }
  }
  
  private void Ez()
  {
    if ((!this.ays) && (this.axY))
    {
      this.mLog.dl("takePicture called");
      this.ays = true;
      this.ayt = SystemClock.uptimeMillis();
      this.ayu += 1L;
      if (this.ayw != null) {
        this.ayw.cancel();
      }
      this.ayw = new h(this.ayu);
      if (this.ayv == null) {
        this.ayv = new Timer();
      }
      this.ayv.schedule(this.ayw, 7000L);
      this.ayf.a(this);
    }
  }
  
  private void a(View paramView, float paramFloat1, float paramFloat2, long paramLong)
  {
    RotateAnimation localRotateAnimation = new RotateAnimation(paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    localRotateAnimation.setDuration(paramLong);
    localRotateAnimation.setFillAfter(true);
    paramView.startAnimation(localRotateAnimation);
  }
  
  private void a(ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if (localView != null)
      {
        localView.setOnClickListener(paramOnClickListener);
        localView.setOnLongClickListener(paramOnLongClickListener);
        if ((localView instanceof CheckBox)) {
          ((CheckBox)localView).setOnCheckedChangeListener(this);
        }
      }
      i += 1;
    }
  }
  
  private void a(ImageView paramImageView, float paramFloat1, float paramFloat2, long paramLong)
  {
    i locali = new i(paramImageView, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    locali.setInterpolator(new LinearInterpolator());
    locali.setDuration(paramLong);
    locali.setFillAfter(true);
    paramImageView.startAnimation(locali);
  }
  
  private void a(b paramb)
  {
    if (paramb.getId() >= 0L)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.MAIN");
      localIntent.setFlags(67108864);
      localIntent.setClass(this, PageEnhanceActivity.class);
      t localt = new t();
      localIntent.putExtra("OPEN_DOCUMENT_SELECTED_DOC_ID", paramb.getId());
      localIntent.putExtra("OPEN_DOCUMENT_CURRENT_LIST_FAVORITE_RANK", 0);
      localt.f(localIntent);
      paramb.f(localIntent);
      startActivity(localIntent);
    }
    finish();
  }
  
  private void aU(boolean paramBoolean)
  {
    CameraPreferences.b localb = (CameraPreferences.b)CameraPreferences.apb.CW();
    if (localb != null)
    {
      localb.aR(paramBoolean);
      localb.Dk();
      this.ayf.ES();
    }
  }
  
  private void dz(String paramString)
  {
    int j = 2130837738;
    ImageButton localImageButton = (ImageButton)findViewById(2131165293);
    boolean bool = true;
    if ("auto".equals(paramString))
    {
      i = 2130837737;
      if (i < 0) {
        break label193;
      }
      localImageButton.setImageDrawable(getResources().getDrawable(i));
      label50:
      localImageButton.setEnabled(bool);
      if (!bool) {
        break label202;
      }
    }
    label193:
    label202:
    for (int i = getResources().getInteger(2131492870);; i = getResources().getInteger(2131492871))
    {
      localImageButton.getDrawable().mutate().setAlpha(i);
      paramString = new Matrix();
      paramString.postRotate(this.ayy, localImageButton.getDrawable().getBounds().width() / 2, localImageButton.getDrawable().getBounds().height() / 2);
      localImageButton.setScaleType(ImageView.ScaleType.MATRIX);
      localImageButton.setImageMatrix(paramString);
      return;
      if (("on".equals(paramString)) || ("torch".equals(paramString)))
      {
        i = 2130837739;
        break;
      }
      i = j;
      if ("off".equals(paramString)) {
        break;
      }
      bool = false;
      i = j;
      break;
      localImageButton.setImageDrawable(null);
      break label50;
    }
  }
  
  @TargetApi(11)
  private void e(View paramView, float paramFloat)
  {
    if (com.mobisystems.mobiscanner.common.d.Dw())
    {
      paramView.setRotation(90.0F);
      return;
    }
    a(paramView, 0.0F, 90.0F, 0L);
  }
  
  @TargetApi(9)
  private static Camera gc(int paramInt)
  {
    if (com.mobisystems.mobiscanner.common.d.Dv()) {
      return Camera.open(paramInt);
    }
    return Camera.open();
  }
  
  private void gd(int paramInt)
  {
    float f3 = 360.0F;
    if (this.axU != null)
    {
      if ((paramInt != 90) && (paramInt != 270)) {
        break label339;
      }
      i = 2;
      if (i != this.axV)
      {
        this.axU.setUiOrientation(i);
        this.axV = i;
      }
    }
    int i = this.ayB;
    long l = getResources().getInteger(2131492867);
    i = (360 - (i + paramInt) % 360) % 360;
    float f2;
    float f1;
    if (i != this.ayy)
    {
      this.mLog.dl("showOrientation, orientation=" + paramInt);
      f2 = this.ayy;
      f1 = i;
      if ((f2 != 270.0F) || (f1 != 0.0F)) {
        break label345;
      }
      f1 = f3;
    }
    for (;;)
    {
      this.mLog.dl("Rotate image views, from=" + f2 + ", to=" + f1);
      a(findViewById(2131165285), f2, f1, l);
      a(findViewById(2131165290), f2, f1, l);
      a((ImageView)findViewById(2131165293), f2, f1, l);
      a(findViewById(2131165294), f2, f1, l);
      if (axT) {
        a(findViewById(2131165297), f2, f1, l);
      }
      this.ayy = i;
      if ((!axT) && (i != this.ayz) && ((i == 0) || (i == 180)))
      {
        f1 = this.ayz;
        f2 = i;
        a(findViewById(2131165289), f1, f2, l);
        this.ayz = i;
      }
      return;
      label339:
      i = 1;
      break;
      label345:
      if ((f2 == 0.0F) && (f1 == 270.0F)) {
        f2 = 360.0F;
      }
    }
  }
  
  private void handleIntent(Intent paramIntent)
  {
    if (this.axZ == null) {
      this.axZ = new b(paramIntent);
    }
    this.aya = true;
    if (this.axZ.getId() >= 0L) {
      this.aya = false;
    }
    this.axW = paramIntent.getStringExtra("com.sonymobile.camera.addon.intent.extra.CAPTURING_MODE");
    this.mLog.dl("Extra capturing mode: " + this.axW);
  }
  
  void EN()
  {
    Intent localIntent = new Intent(this, UpdateGPSCoordsService.class);
    localIntent.putExtra("START_LOCATION_SERVICE", true);
    startService(localIntent);
  }
  
  void EO()
  {
    Intent localIntent = new Intent(this, UpdateGPSCoordsService.class);
    localIntent.putExtra("STOP_LOCATION_SERVICE", true);
    startService(localIntent);
  }
  
  public void En()
  {
    this.mLog.dl("onTakePicture called");
    if (!com.mobisystems.mobiscanner.common.d.DA()) {
      ((AudioManager)getSystemService("audio")).setStreamMute(1, true);
    }
    try
    {
      this.aye.takePicture(this, null, this);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      do
      {
        this.mLog.g("Runtime exception in takePicture", localRuntimeException);
      } while (com.mobisystems.mobiscanner.common.d.DA());
      ((AudioManager)getSystemService("audio")).setStreamMute(1, false);
    }
  }
  
  public void Eo()
  {
    this.mLog.dl("onFocusFailed called");
    if (this.ays)
    {
      this.ays = false;
      this.ayf.EV();
    }
  }
  
  void V(long paramLong)
  {
    Intent localIntent = new Intent(this, UpdateGPSCoordsService.class);
    localIntent.putExtra("LOCATION_SERVICE_IMAGE_TAKEN", true);
    localIntent.putExtra("LOCATION_SERVICE_IMAGE_TAKEN_IMAGE_ID", paramLong);
    startService(localIntent);
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onBackPressed()
  {
    if ((this.axU != null) && (this.axU.isOpened()))
    {
      this.axU.close();
      this.ayg.setVisibility(0);
      this.ayh.setVisibility(0);
      this.ayf.EZ();
      return;
    }
    EI();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    switch (paramCompoundButton.getId())
    {
    default: 
      return;
    }
    aU(paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131165286: 
    case 2131165287: 
    case 2131165288: 
    case 2131165289: 
    case 2131165292: 
    case 2131165295: 
    case 2131165296: 
    default: 
      return;
    case 2131165285: 
      EJ();
      return;
    case 2131165291: 
    case 2131165294: 
      Ez();
      return;
    case 2131165290: 
      EA();
      return;
    case 2131165293: 
      EF();
      return;
    }
    EG();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.mLog.dl("onConfigurationChanged called");
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    com.mobisystems.mobiscanner.error.a.ay(getApplicationContext());
    Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
    {
      public void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
      {
        SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(CameraActivity.this).edit();
        localEditor.putBoolean(CommonPreferences.Keys.apr.getKey(), false);
        localEditor.commit();
        CameraActivity.a(CameraActivity.this);
        if (this.ayM != null) {
          this.ayM.uncaughtException(paramAnonymousThread, paramAnonymousThrowable);
        }
      }
    });
    this.mLog.dl("OnCreate called");
    super.onCreate(paramBundle);
    if (!PreferenceManager.getDefaultSharedPreferences(this).getBoolean(CommonPreferences.Keys.apI.Dl(), false)) {
      a.a(getSupportFragmentManager());
    }
    getWindow().setFlags(1024, 1024);
    this.ayI = com.mobisystems.mobiscanner.common.d.ai(this);
    int j = this.ayI.awA;
    this.mLog.dl("Sony Camera Add On Framework available = " + axT);
    if (axT) {
      if (j == 2)
      {
        setRequestedOrientation(0);
        setContentView(2130903069);
        this.ayA = 0;
      }
    }
    for (;;)
    {
      this.ayf = ((CameraPreview)findViewById(2131165291));
      Ep();
      this.ayf.a(this.ayI, this.ayA, this.ayH);
      this.ayd = new com.mobisystems.mobiscanner.image.a(getApplicationContext(), getSupportFragmentManager());
      Es();
      this.ayp = ((SensorManager)getSystemService("sensor"));
      this.ayq = this.ayp.getDefaultSensor(1);
      this.ayJ = this.ayp.getDefaultSensor(2);
      return;
      setRequestedOrientation(1);
      setContentView(2130903068);
      this.ayA = 1;
      continue;
      int i = j;
      if (Build.BRAND.equals("samsung"))
      {
        i = j;
        if (Build.MODEL.equals("GT-S5360"))
        {
          i = j;
          if (Build.FINGERPRINT.contains("2.3.6"))
          {
            this.ayB = 90;
            i = 2;
          }
        }
      }
      if (i == 2)
      {
        setRequestedOrientation(0);
        setContentView(2130903067);
        this.ayA = 0;
      }
      else
      {
        setRequestedOrientation(1);
        setContentView(2130903066);
        this.ayA = 1;
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    this.mLog.dl("onCreateOptionsMenu called");
    getSupportMenuInflater().inflate(2131689472, paramMenu);
    return true;
  }
  
  public void onDestroy()
  {
    this.mLog.dl("onDestroy called");
    super.onDestroy();
    if (this.aym != null)
    {
      this.aym.disable();
      this.aym = null;
    }
    this.ayd.Ii();
  }
  
  public void onDialogNegativeAction(String paramString, Bundle paramBundle)
  {
    if ("ACCEPT_EULA".equals(paramString))
    {
      Toast.makeText(this, "You must accept the Terms before using the application ", 1).show();
      finish();
    }
  }
  
  public void onDialogPositiveAction(String paramString, Bundle paramBundle)
  {
    if ("CAMERA_SETTINGS".equals(paramString)) {
      Ey();
    }
    do
    {
      do
      {
        return;
        if (!"PAGE_ADD".equals(paramString)) {
          break;
        }
        paramString = new b(paramBundle);
      } while (paramString.getId() == -1L);
      a(paramString);
      return;
    } while (!"ACCEPT_EULA".equals(paramString));
    PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean(CommonPreferences.Keys.apI.Dl(), true).commit();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = super.onKeyDown(paramInt, paramKeyEvent);
    case 27: 
    case 80: 
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
                  if (paramKeyEvent.getRepeatCount() == 0)
                  {
                    this.mLog.dl("Hardware Camera Key pressed. Take a picture.");
                    this.ayC = SystemClock.uptimeMillis();
                    Ez();
                    return true;
                  }
                  bool1 = bool2;
                } while (!EC());
                bool1 = bool2;
              } while (this.ayE);
              bool1 = bool2;
            } while (SystemClock.uptimeMillis() - this.ayC <= ViewConfiguration.getLongPressTimeout());
            this.ayE = true;
            bool1 = bool2;
          } while (this.ays);
          Ez();
          return true;
          bool1 = bool2;
        } while (this.ays);
        bool1 = bool2;
      } while (paramKeyEvent.getRepeatCount() != 0);
      this.mLog.dl("Hardware Camera Focus Key pressed");
      this.ayf.ET();
      return true;
    }
    EA();
    return true;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyUp(paramInt, paramKeyEvent);
    case 27: 
      this.mLog.dl("Hardware Camera Key released.");
      ED();
      return true;
    }
    this.mLog.dl("Hardware Camera Focus Key released.");
    this.ayf.EU();
    return true;
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView.getId() == 2131165294)
    {
      if (!this.ays)
      {
        if (!EC()) {
          break label57;
        }
        this.mLog.dl("Long press on Camera Capture button. Take picture in burst mode.");
        this.ayE = true;
        this.ayf.ET();
        Ez();
      }
      for (;;)
      {
        this.ayD = true;
        return true;
        label57:
        this.mLog.dl("Long press on Camera Capture button. Do focus and lock.");
        this.ayf.ET();
      }
    }
    Toast.makeText(this, paramView.getContentDescription(), 0).show();
    return true;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    this.mLog.dl("onNewIntent called");
    this.axZ = null;
    setIntent(paramIntent);
    if (this.mResumed) {
      handleIntent(getIntent());
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 2131165594: 
      HelpAboutHelper.a(this, HelpAboutHelper.HelpTopic.aDe);
      return true;
    }
    HelpAboutHelper.showAbout(this);
    return true;
  }
  
  protected void onPause()
  {
    this.mLog.dl("onPause called");
    super.onPause();
    EO();
    Eu();
    if (this.aym != null) {
      this.aym.disable();
    }
    this.ayp.unregisterListener(this.ayf);
    this.ayp.unregisterListener(this);
    this.ayK = null;
    this.ayL = null;
    if (this.ayo != null)
    {
      this.ayo.release();
      this.ayo = null;
    }
    if (this.axU != null)
    {
      this.axU.release();
      this.axU = null;
    }
    this.mResumed = false;
    this.ayd.flushCache();
  }
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.mLog.dl("onPictureTaken called");
    if (this.ayw != null)
    {
      this.ayw.cancel();
      this.ayw = null;
    }
    new d().execute(new byte[][] { paramArrayOfByte });
    if (this.aye != null) {
      this.aye.startPreview();
    }
    this.ayf.EV();
    if (!com.mobisystems.mobiscanner.common.d.DA()) {
      ((AudioManager)getSystemService("audio")).setStreamMute(1, false);
    }
    this.ays = false;
    if (this.ayE)
    {
      long l = SystemClock.uptimeMillis() - this.ayt;
      if (l < 200L)
      {
        this.ayG = new a();
        if (this.ayF == null) {
          this.ayF = new Timer();
        }
        this.ayF.schedule(this.ayG, 200L - l);
      }
    }
    else
    {
      return;
    }
    Ez();
  }
  
  protected void onResume()
  {
    this.mLog.dl("onResume called");
    super.onResume();
    EN();
    this.ays = false;
    Et();
    if (this.aye == null)
    {
      Toast.makeText(this, OperationStatus.avY.Ds(), 0).show();
      finish();
      return;
    }
    EB();
    EE();
    Eq();
    if (this.aym != null) {
      this.aym.enable();
    }
    this.ayp.registerListener(this.ayf, this.ayq, 3);
    this.ayp.registerListener(this, this.ayq, 3);
    this.ayp.registerListener(this, this.ayJ, 3);
    this.ayo = new f(this);
    if (axT)
    {
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131165296);
      localViewGroup.bringToFront();
      this.axU = new CapturingModeSelector(this, localViewGroup);
      this.axU.setOnModeFinishListener(new e(null));
      this.axU.setOnModeSelectListener(new f(null));
    }
    this.ayr = false;
    this.mResumed = true;
    this.axY = true;
    this.ayD = false;
    this.ayE = false;
    handleIntent(getIntent());
    Er();
    if ((axX) && ("QUICK_PDF_SCANNER".equals(this.axW)) && (this.axZ.getId() < 0L))
    {
      this.axY = false;
      new b().execute(new Void[0]);
      return;
    }
    if (this.axZ.IL() > 0)
    {
      new c().execute(new Void[0]);
      return;
    }
    this.ayk.setImageDrawable(getResources().getDrawable(2130837875));
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    switch (paramSensorEvent.sensor.getType())
    {
    default: 
      return;
    case 1: 
      this.ayK = paramSensorEvent.values;
      return;
    }
    this.ayL = paramSensorEvent.values;
  }
  
  public void onShutter()
  {
    this.mLog.dl("onShutter called");
    if (this.ayo != null) {
      this.ayo.Fe();
    }
    this.ayf.EW();
  }
  
  protected void onStart()
  {
    super.onStart();
    l.e(this).a(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    l.e(this).b(this);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView.getId() == 2131165294) && (paramMotionEvent.getAction() == 1) && (this.ayD))
    {
      this.ayD = false;
      ED();
      if (!EC()) {
        Ez();
      }
      this.ayf.EU();
      return true;
    }
    if (paramView.getId() == 2131165297)
    {
      paramView = ((ImageView)paramView).getDrawable();
      if (paramView != null)
      {
        if (paramMotionEvent.getAction() == 0)
        {
          paramView.setColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
          return false;
        }
        if (paramMotionEvent.getAction() == 1) {
          paramView.setColorFilter(null);
        }
      }
    }
    return false;
  }
  
  private class a
    extends TimerTask
  {
    boolean ayO = false;
    final Runnable ayP = new Runnable()
    {
      public void run()
      {
        if ((!CameraActivity.c(CameraActivity.this)) && (CameraActivity.u(CameraActivity.this)) && (!CameraActivity.a.this.ayO)) {
          CameraActivity.v(CameraActivity.this);
        }
      }
    };
    
    public a()
    {
      CameraActivity.e(CameraActivity.this).dl("BurstModeTakePictureTask task created.");
    }
    
    public boolean cancel()
    {
      boolean bool = super.cancel();
      CameraActivity.e(CameraActivity.this).dl("BurstModeTakePictureTask task canceled, cancellation status = " + bool);
      this.ayO = true;
      return bool;
    }
    
    public void run()
    {
      CameraActivity.this.runOnUiThread(this.ayP);
    }
  }
  
  private class b
    extends AsyncTask<Void, Void, b>
  {
    public b() {}
    
    public b a(Void... arg1)
    {
      synchronized (CameraActivity.j(CameraActivity.this))
      {
        for (;;)
        {
          boolean bool = CameraActivity.k(CameraActivity.this);
          if (!bool) {
            break;
          }
          try
          {
            CameraActivity.j(CameraActivity.this).wait();
          }
          catch (InterruptedException localInterruptedException) {}
        }
        CameraActivity.a(CameraActivity.this, true);
        return new DocumentModel().Iu();
      }
    }
    
    public void b(b paramb)
    {
      if (paramb != null) {}
      synchronized (CameraActivity.j(CameraActivity.this))
      {
        CameraActivity.a(CameraActivity.this, paramb);
        CameraActivity.c(CameraActivity.this, true);
        CameraActivity.a(CameraActivity.this, false);
        CameraActivity.j(CameraActivity.this).notifyAll();
        if (CameraActivity.o(CameraActivity.this)) {
          CameraActivity.p(CameraActivity.this);
        }
        if (CameraActivity.l(CameraActivity.this).IL() > 0)
        {
          new CameraActivity.c(CameraActivity.this).execute(new Void[0]);
          return;
        }
      }
      CameraActivity.q(CameraActivity.this).setImageDrawable(CameraActivity.this.getResources().getDrawable(2130837875));
    }
  }
  
  private class c
    extends AsyncTask<Void, Void, com.mobisystems.mobiscanner.model.c>
  {
    public c() {}
    
    public com.mobisystems.mobiscanner.model.c b(Void... arg1)
    {
      synchronized (CameraActivity.j(CameraActivity.this))
      {
        for (;;)
        {
          boolean bool = CameraActivity.k(CameraActivity.this);
          if (!bool) {
            break;
          }
          try
          {
            CameraActivity.j(CameraActivity.this).wait();
          }
          catch (InterruptedException localInterruptedException) {}
        }
        CameraActivity.a(CameraActivity.this, true);
        long l = CameraActivity.l(CameraActivity.this).getId();
        int i = CameraActivity.l(CameraActivity.this).IL();
        return new DocumentModel().c(l, i);
      }
    }
    
    public void b(com.mobisystems.mobiscanner.model.c paramc)
    {
      if (paramc != null) {}
      synchronized (CameraActivity.j(CameraActivity.this))
      {
        CameraActivity.a(CameraActivity.this, paramc.IS());
        CameraActivity.a(CameraActivity.this, false);
        CameraActivity.j(CameraActivity.this).notifyAll();
        if ((CameraActivity.o(CameraActivity.this)) && (!CameraActivity.s(CameraActivity.this))) {
          CameraActivity.r(CameraActivity.this).a(paramc.getId(), paramc.IA(), CameraActivity.q(CameraActivity.this));
        }
        return;
      }
    }
  }
  
  private class d
    extends AsyncTask<byte[], Void, com.mobisystems.mobiscanner.model.c>
  {
    public d() {}
    
    public com.mobisystems.mobiscanner.model.c a(byte[]... arg1)
    {
      Object localObject1 = null;
      byte[] arrayOfByte = ???[0];
      for (;;)
      {
        synchronized (CameraActivity.j(CameraActivity.this))
        {
          boolean bool = CameraActivity.k(CameraActivity.this);
          if (bool)
          {
            try
            {
              CameraActivity.j(CameraActivity.this).wait();
            }
            catch (InterruptedException localInterruptedException) {}
            continue;
          }
          CameraActivity.a(CameraActivity.this, true);
          long l = CameraActivity.l(CameraActivity.this).getId();
          DocumentModel localDocumentModel = new DocumentModel();
          if ((CameraActivity.m(CameraActivity.this) != null) && (CameraActivity.n(CameraActivity.this) != null))
          {
            float[] arrayOfFloat = new float[9];
            if (SensorManager.getRotationMatrix(arrayOfFloat, null, CameraActivity.m(CameraActivity.this), CameraActivity.n(CameraActivity.this)))
            {
              ??? = new float[3];
              SensorManager.getOrientation(arrayOfFloat, ???);
              l = localDocumentModel.a(l, arrayOfByte, new com.mobisystems.mobiscanner.model.c(), ???);
              ??? = (byte[][])localObject1;
              if (l >= 0L)
              {
                ??? = localDocumentModel.aj(l);
                CameraActivity.this.V(l);
              }
              return (com.mobisystems.mobiscanner.model.c)???;
            }
          }
        }
        ??? = null;
      }
    }
    
    public void b(com.mobisystems.mobiscanner.model.c paramc)
    {
      if (paramc != null) {}
      synchronized (CameraActivity.j(CameraActivity.this))
      {
        CameraActivity.a(CameraActivity.this, paramc.IS());
        CameraActivity.a(CameraActivity.this, false);
        CameraActivity.j(CameraActivity.this).notifyAll();
        CameraActivity.b(CameraActivity.this, true);
        if (CameraActivity.o(CameraActivity.this))
        {
          CameraActivity.p(CameraActivity.this);
          CameraActivity.r(CameraActivity.this).a(paramc.getId(), paramc.IA(), CameraActivity.q(CameraActivity.this));
        }
        return;
      }
    }
  }
  
  private class e
    implements CapturingModeSelector.OnModeFinishListener
  {
    private e() {}
    
    public void onModeFinish()
    {
      if (CameraActivity.f(CameraActivity.this) != null) {
        CameraActivity.f(CameraActivity.this).close();
      }
      CameraActivity.this.finish();
    }
  }
  
  private class f
    implements CapturingModeSelector.OnModeSelectListener
  {
    private f() {}
    
    public void onModeSelect(String paramString)
    {
      if (CameraActivity.f(CameraActivity.this) != null) {
        CameraActivity.f(CameraActivity.this).close();
      }
      CameraActivity.g(CameraActivity.this).setVisibility(0);
      CameraActivity.h(CameraActivity.this).setVisibility(0);
      CameraActivity.i(CameraActivity.this).EZ();
      CameraActivity.a(CameraActivity.this, paramString);
    }
  }
  
  private class g
    extends OrientationEventListener
  {
    private boolean ayR = true;
    
    public g(Context paramContext)
    {
      super();
    }
    
    public void onOrientationChanged(int paramInt)
    {
      if (paramInt == -1) {}
      int i;
      do
      {
        return;
        i = (paramInt + 45) / 90 * 90 % 360;
      } while ((!this.ayR) && ((CameraActivity.b(CameraActivity.this) == null) || (CameraActivity.c(CameraActivity.this)) || (Math.abs(i - paramInt) >= 5)));
      if (com.mobisystems.mobiscanner.common.d.Dv()) {}
      for (paramInt = CameraActivity.EP();; paramInt = 0)
      {
        int j = (paramInt + i) % 360;
        if (j == CameraActivity.d(CameraActivity.this)) {
          break;
        }
        int k = CameraActivity.this.getWindowManager().getDefaultDisplay().getRotation();
        CameraActivity.e(CameraActivity.this).dl("onOrientationChanged, Camera Orientation=" + paramInt + ", Current Display Orientation=" + i + ", Current Display Rotation=" + k + ", Camera setRotation=" + j);
        Camera.Parameters localParameters = CameraActivity.b(CameraActivity.this).getParameters();
        localParameters.setRotation(j);
        CameraActivity.b(CameraActivity.this).setParameters(localParameters);
        CameraActivity.a(CameraActivity.this, j);
        CameraActivity.b(CameraActivity.this, i);
        this.ayR = false;
        return;
      }
    }
  }
  
  private class h
    extends TimerTask
  {
    private long ayS;
    final Runnable ayT = new Runnable()
    {
      public void run()
      {
        CameraActivity.e(CameraActivity.this).dl("ResetTakingPictureFlag task finished for picture ID: " + CameraActivity.h.a(CameraActivity.h.this) + ". Current picture ID = " + CameraActivity.t(CameraActivity.this) + ", Taking Picture Flag = " + CameraActivity.c(CameraActivity.this) + ", Resumed flag = " + CameraActivity.o(CameraActivity.this));
        if ((CameraActivity.t(CameraActivity.this) == CameraActivity.h.a(CameraActivity.h.this)) && (CameraActivity.c(CameraActivity.this)) && (CameraActivity.o(CameraActivity.this)))
        {
          CameraActivity.d(CameraActivity.this, false);
          CameraActivity.i(CameraActivity.this).EV();
        }
      }
    };
    
    public h(long paramLong)
    {
      CameraActivity.e(CameraActivity.this).dl("ResetTakingPictureFlag task created for picture ID: " + paramLong);
      this.ayS = paramLong;
    }
    
    public boolean cancel()
    {
      boolean bool = super.cancel();
      CameraActivity.e(CameraActivity.this).dl("ResetTakingPictureFlag task canceled for picture ID: " + this.ayS + ", cancellation status = " + bool);
      return bool;
    }
    
    public void run()
    {
      CameraActivity.this.runOnUiThread(this.ayT);
    }
  }
  
  private class i
    extends RotateAnimation
  {
    ImageView ayV;
    
    public i(ImageView paramImageView, float paramFloat1, float paramFloat2, int paramInt1, float paramFloat3, int paramInt2, float paramFloat4)
    {
      super(paramFloat2, paramInt1, paramFloat3, paramInt2, paramFloat4);
      this.ayV = paramImageView;
    }
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      super.applyTransformation(paramFloat, paramTransformation);
      paramTransformation = paramTransformation.getMatrix();
      this.ayV.setScaleType(ImageView.ScaleType.MATRIX);
      this.ayV.setImageMatrix(paramTransformation);
      paramTransformation.reset();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/CameraActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */