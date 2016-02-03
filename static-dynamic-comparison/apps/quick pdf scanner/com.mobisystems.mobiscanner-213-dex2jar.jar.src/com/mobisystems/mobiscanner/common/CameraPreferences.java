package com.mobisystems.mobiscanner.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public enum CameraPreferences
{
  private static final c apd;
  private static SharedPreferences ape;
  private static ArrayList<a> apf;
  private boolean mDisplayInSettings;
  private String mKey;
  private m mPref = null;
  
  static
  {
    apd = new c();
    ape = null;
    apf = new ArrayList();
    apf.add(new a(4, 3));
    apf.add(new a(16, 9));
  }
  
  private CameraPreferences(String paramString, boolean paramBoolean)
  {
    this.mKey = paramString;
    this.mDisplayInSettings = paramBoolean;
  }
  
  @TargetApi(9)
  public static void CX()
  {
    SharedPreferences.Editor localEditor = ape.edit();
    CameraPreferences[] arrayOfCameraPreferences = values();
    int j = arrayOfCameraPreferences.length;
    int i = 0;
    while (i < j)
    {
      n localn = (n)arrayOfCameraPreferences[i].CW();
      if (localn != null) {
        localn.c(localEditor);
      }
      i += 1;
    }
    if (d.Dv())
    {
      localEditor.apply();
      return;
    }
    localEditor.commit();
  }
  
  @TargetApi(14)
  public static Camera.Parameters a(Camera.Parameters paramParameters)
  {
    paramParameters.setPictureFormat(256);
    paramParameters.setJpegThumbnailSize(0, 0);
    Object localObject = (l)aoQ.CW();
    if (localObject != null) {
      paramParameters.setSceneMode(((l)localObject).Di());
    }
    localObject = (l)aoR.CW();
    if (localObject != null) {
      paramParameters.setFocusMode(((l)localObject).Di());
    }
    localObject = (l)aoS.CW();
    if (localObject != null) {
      paramParameters.setFlashMode(((l)localObject).Di());
    }
    localObject = (i)aoT.CW();
    if (localObject != null) {
      paramParameters.setPictureSize(((Camera.Size)((i)localObject).Dh()).width, ((Camera.Size)((i)localObject).Dh()).height);
    }
    localObject = (f)aoU.CW();
    if (localObject != null) {
      paramParameters.setJpegQuality(((f)localObject).Db());
    }
    localObject = (l)aoV.CW();
    if (localObject != null) {
      paramParameters.setColorEffect(((l)localObject).Di());
    }
    localObject = (l)aoX.CW();
    if (localObject != null) {
      paramParameters.setWhiteBalance(((l)localObject).Di());
    }
    localObject = (c)aoY.CW();
    if ((localObject != null) && (d.Dy())) {
      paramParameters.setAutoWhiteBalanceLock(((c)localObject).Da());
    }
    localObject = (f)aoZ.CW();
    if (localObject != null) {
      paramParameters.setExposureCompensation(((f)localObject).Db());
    }
    localObject = (c)apa.CW();
    if ((localObject != null) && (d.Dy())) {
      paramParameters.setAutoExposureLock(((c)localObject).Da());
    }
    return paramParameters;
  }
  
  private static a a(Camera.Size paramSize)
  {
    int i = 1;
    a locala = new a(1, 1);
    float f1 = paramSize.width / paramSize.height;
    for (;;)
    {
      if (i <= 20)
      {
        float f2 = i * f1;
        int j = Math.round(f2);
        if (Math.abs(f2 - j) < 0.01F)
        {
          locala.width = j;
          locala.height = i;
        }
      }
      else
      {
        return locala;
      }
      i += 1;
    }
  }
  
  @TargetApi(14)
  public static void a(Context paramContext, Camera.Parameters paramParameters)
  {
    if (ape != null) {
      return;
    }
    ape = paramContext.getSharedPreferences("CAMERA_PREFS", 0);
    paramContext = paramParameters.getSupportedSceneModes();
    if ((paramContext != null) && (paramContext.size() > 1)) {
      aoQ.a(new l(aoQ.getKey(), 2131296775, paramContext, paramParameters.getSceneMode()));
    }
    paramContext = paramParameters.getSupportedFocusModes();
    if ((paramContext != null) && (paramContext.size() > 1)) {
      aoR.a(new l(aoR.getKey(), 2131296776, paramContext, "auto"));
    }
    paramContext = paramParameters.getSupportedFlashModes();
    if ((paramContext != null) && (paramContext.size() > 0)) {
      aoS.a(new l(aoS.getKey(), 2131296777, paramContext, "auto"));
    }
    paramContext = paramParameters.getSupportedPictureSizes();
    k(paramContext);
    if ((paramContext != null) && (paramContext.size() > 1)) {
      aoT.a(new i(aoT.getKey(), 2131296778, paramContext, null));
    }
    aoU.a(new f(aoU.getKey(), 2131296779, 1, 100, 100));
    paramContext = paramParameters.getSupportedColorEffects();
    if ((paramContext != null) && (paramContext.size() > 1)) {
      aoV.a(new l(aoV.getKey(), 2131296780, paramContext, paramParameters.getColorEffect()));
    }
    paramContext = paramParameters.getSupportedAntibanding();
    if ((paramContext != null) && (paramContext.size() > 1)) {
      aoW.a(new l(aoW.getKey(), 2131296781, paramContext, paramParameters.getAntibanding()));
    }
    paramContext = paramParameters.getSupportedWhiteBalance();
    if ((paramContext != null) && (paramContext.size() > 1)) {
      aoX.a(new l(aoX.getKey(), 2131296782, paramContext, paramParameters.getWhiteBalance()));
    }
    if ((d.Dy()) && (paramParameters.isAutoWhiteBalanceLockSupported())) {
      aoY.a(new c(aoY.getKey(), 2131296783, false));
    }
    int i = paramParameters.getMinExposureCompensation();
    int j = paramParameters.getMaxExposureCompensation();
    if (i != j) {
      aoZ.a(new f(aoZ.getKey(), 2131296784, i, j, 0));
    }
    if ((d.Dy()) && (paramParameters.isAutoExposureLockSupported())) {
      apa.a(new c(apa.getKey(), 2131296785, false));
    }
    apb.a(new c(apb.getKey(), 2131296786, false));
    apc.a(new c(apc.getKey(), 2131296787, true));
  }
  
  private void a(m paramm)
  {
    this.mPref = paramm;
  }
  
  private static void k(List<Camera.Size> paramList)
  {
    paramList = paramList.listIterator();
    while (paramList.hasNext())
    {
      a locala = a((Camera.Size)paramList.next());
      if (!apf.contains(locala)) {
        paramList.remove();
      }
    }
  }
  
  public boolean CV()
  {
    return this.mDisplayInSettings;
  }
  
  public m CW()
  {
    return this.mPref;
  }
  
  public String getKey()
  {
    return this.mKey;
  }
  
  private static class a
  {
    public int height;
    public int width;
    
    public a(int paramInt1, int paramInt2)
    {
      this.width = paramInt1;
      this.height = paramInt2;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a)) {}
      do
      {
        return false;
        paramObject = (a)paramObject;
      } while ((this.width != ((a)paramObject).width) || (this.height != ((a)paramObject).height));
      return true;
    }
  }
  
  public static abstract interface b
    extends CameraPreferences.m
  {
    public abstract boolean Da();
    
    public abstract void aR(boolean paramBoolean);
  }
  
  private static class c
    extends CameraPreferences.n
    implements CameraPreferences.b
  {
    boolean aph;
    
    public c(String paramString, int paramInt, boolean paramBoolean)
    {
      super(paramInt);
      this.aph = aS(paramBoolean);
      CameraPreferences.CZ().dl("Create BooleanPreference " + this.mKey + ", value=" + this.aph);
    }
    
    public boolean Da()
    {
      return this.aph;
    }
    
    public void aR(boolean paramBoolean)
    {
      this.aph = paramBoolean;
      CameraPreferences.CZ().dl("Set BooleanPreference " + this.mKey + ", value=" + this.aph);
    }
    
    protected boolean aS(boolean paramBoolean)
    {
      return CameraPreferences.CY().getBoolean(this.mKey, paramBoolean);
    }
    
    public void c(SharedPreferences.Editor paramEditor)
    {
      paramEditor.putBoolean(this.mKey, this.aph);
      CameraPreferences.CZ().dl("Store BooleanPreference " + this.mKey + ", value=" + this.aph);
    }
  }
  
  private static class d
    implements Comparator<Camera.Size>
  {
    public int a(Camera.Size paramSize1, Camera.Size paramSize2)
    {
      if (paramSize1.width < paramSize2.width) {}
      do
      {
        return -1;
        if (paramSize1.width > paramSize2.width) {
          return 1;
        }
      } while (paramSize1.height < paramSize2.height);
      if (paramSize1.height > paramSize2.height) {
        return 1;
      }
      return 0;
    }
  }
  
  public static abstract interface e
    extends CameraPreferences.m
  {
    public abstract int Db();
    
    public abstract void fO(int paramInt);
    
    public abstract int getMaxValue();
    
    public abstract int getMinValue();
  }
  
  private static class f
    extends CameraPreferences.n
    implements CameraPreferences.e
  {
    int api;
    int apj;
    int apk;
    
    public f(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super(paramInt1);
      this.api = paramInt2;
      this.apj = paramInt3;
      this.apk = fP(paramInt4);
      CameraPreferences.CZ().dl("Create IntegerPreference " + this.mKey + ", value=" + this.apk);
    }
    
    public int Db()
    {
      return this.apk;
    }
    
    public void c(SharedPreferences.Editor paramEditor)
    {
      paramEditor.putInt(this.mKey, this.apk);
      CameraPreferences.CZ().dl("Store IntegerPreference " + this.mKey + ", value=" + this.apk);
    }
    
    public void fO(int paramInt)
    {
      this.apk = paramInt;
      CameraPreferences.CZ().dl("Set IntegerPreference " + this.mKey + ", value=" + this.apk);
    }
    
    protected int fP(int paramInt)
    {
      int i = CameraPreferences.CY().getInt(this.mKey, paramInt);
      if ((i < this.api) || (i > this.apj)) {
        return paramInt;
      }
      return i;
    }
    
    public int getMaxValue()
    {
      return this.apj;
    }
    
    public int getMinValue()
    {
      return this.api;
    }
  }
  
  public static abstract interface g
    extends CameraPreferences.m
  {
    public abstract List<String> Dc();
    
    public abstract int Dd();
    
    public abstract void fQ(int paramInt);
  }
  
  public static abstract interface h
    extends CameraPreferences.g
  {
    public abstract boolean De();
  }
  
  private static class i
    extends CameraPreferences.j<Camera.Size>
    implements CameraPreferences.h
  {
    private static boolean apl = false;
    
    public i(String paramString, int paramInt, List<Camera.Size> paramList, Camera.Size paramSize)
    {
      super(paramInt, paramList, paramSize);
    }
    
    public boolean De()
    {
      return apl;
    }
    
    protected void Df()
    {
      Collections.sort(this.apo, new CameraPreferences.d(null));
      this.apn = new ArrayList(this.apo.size());
      Iterator localIterator = this.apo.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Camera.Size localSize = (Camera.Size)localIterator.next();
        CameraPreferences.a locala = CameraPreferences.b(localSize);
        if ((locala.width == 16) && (locala.height == 9)) {
          apl = true;
        }
        this.apn.add(i, String.valueOf(localSize.width) + " x " + String.valueOf(localSize.height) + " (" + String.valueOf(locala.width) + ":" + String.valueOf(locala.height) + ")");
        i += 1;
      }
    }
    
    protected String Dg()
    {
      Camera.Size localSize = (Camera.Size)this.apo.get(this.apm);
      return String.valueOf(localSize.width) + " x " + String.valueOf(localSize.height);
    }
    
    protected int c(Camera.Size paramSize)
    {
      float f1 = 0.0F;
      int j = 0;
      int i = 0;
      while (i < this.apo.size())
      {
        paramSize = (Camera.Size)this.apo.get(i);
        float f2 = paramSize.width;
        float f3 = paramSize.height * f2;
        f2 = f1;
        if (f3 > f1)
        {
          f2 = f3;
          j = i;
        }
        i += 1;
        f1 = f2;
      }
      return j;
    }
    
    protected Camera.Size cZ(String paramString)
    {
      int j = paramString.indexOf(" x ");
      if (j == -1)
      {
        CameraPreferences.CZ().A("Could not parse persistent value for parameter " + this.mKey);
        localObject = null;
        return (Camera.Size)localObject;
      }
      int i = Integer.parseInt(paramString.substring(0, j));
      j = Integer.parseInt(paramString.substring(j + " x ".length()));
      Object localObject = this.apo.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramString = (Camera.Size)((Iterator)localObject).next();
      } while ((paramString.width != i) || (paramString.height != j));
      for (;;)
      {
        localObject = paramString;
        if (paramString != null) {
          break;
        }
        CameraPreferences.CZ().A("Could not find persistent value for parameter " + this.mKey);
        return (Camera.Size)this.apo.get(0);
        paramString = null;
      }
    }
  }
  
  private static abstract class j<T>
    extends CameraPreferences.n
    implements CameraPreferences.g
  {
    int apm;
    ArrayList<String> apn;
    ArrayList<T> apo;
    
    public j(String paramString, int paramInt, List<T> paramList, T paramT)
    {
      super(paramInt);
      this.apo = new ArrayList(paramList);
      Df();
      this.apm = ax(paramT);
      CameraPreferences.CZ().dl("Create ListPreference " + this.mKey + ", value=" + Dg());
    }
    
    public List<String> Dc()
    {
      return this.apn;
    }
    
    public int Dd()
    {
      return this.apm;
    }
    
    protected abstract void Df();
    
    protected abstract String Dg();
    
    public T Dh()
    {
      return (T)this.apo.get(this.apm);
    }
    
    protected int aw(T paramT)
    {
      if (paramT != null) {}
      for (int i = this.apo.indexOf(paramT);; i = 0)
      {
        if (i < 0)
        {
          if (paramT != null) {
            CameraPreferences.CZ().A("Could not set the default value for parameter " + this.mKey);
          }
          return 0;
        }
        return i;
      }
    }
    
    protected int ax(T paramT)
    {
      int i = -1;
      Object localObject = CameraPreferences.CY().getString(this.mKey, "");
      if (!((String)localObject).equals(""))
      {
        localObject = da((String)localObject);
        i = this.apo.indexOf(localObject);
      }
      int j = i;
      if (i < 0) {
        j = aw(paramT);
      }
      return j;
    }
    
    public void c(SharedPreferences.Editor paramEditor)
    {
      paramEditor.putString(this.mKey, Dg());
      CameraPreferences.CZ().dl("Store ListPreference " + this.mKey + ", value=" + Dg());
    }
    
    protected abstract T da(String paramString);
    
    public void fQ(int paramInt)
    {
      this.apm = paramInt;
      CameraPreferences.CZ().dl("Set ListPreference " + this.mKey + ", value=" + Dg());
    }
  }
  
  public static abstract interface k
    extends CameraPreferences.g
  {
    public abstract String Di();
    
    public abstract int db(String paramString);
  }
  
  private static class l
    extends CameraPreferences.j<String>
    implements CameraPreferences.k
  {
    public l(String paramString1, int paramInt, List<String> paramList, String paramString2)
    {
      super(paramInt, paramList, paramString2);
    }
    
    protected void Df()
    {
      Collections.sort(this.apo);
      this.apn = new ArrayList(this.apo.size());
      Iterator localIterator = this.apo.iterator();
      while (localIterator.hasNext())
      {
        String str = d.dn(((String)localIterator.next()).replaceAll("[_-]", " "));
        this.apn.add(str);
      }
    }
    
    protected String Dg()
    {
      return (String)this.apo.get(this.apm);
    }
    
    public String Di()
    {
      return Dg();
    }
    
    public int db(String paramString)
    {
      int i = 0;
      if (i < this.apo.size()) {
        if (!((String)this.apo.get(i)).equals(paramString)) {}
      }
      for (;;)
      {
        if (i >= 0) {
          this.apm = i;
        }
        return i;
        i += 1;
        break;
        i = -1;
      }
    }
    
    protected String dc(String paramString)
    {
      return paramString;
    }
  }
  
  public static abstract interface m
  {
    public abstract int Dj();
    
    public abstract void Dk();
  }
  
  private static abstract class n
    implements CameraPreferences.m
  {
    int app;
    String mKey;
    
    public n(String paramString, int paramInt)
    {
      this.mKey = paramString;
      this.app = paramInt;
    }
    
    public int Dj()
    {
      return this.app;
    }
    
    @TargetApi(9)
    public void Dk()
    {
      SharedPreferences.Editor localEditor = CameraPreferences.CY().edit();
      c(localEditor);
      if (d.Dv())
      {
        localEditor.apply();
        return;
      }
      localEditor.commit();
    }
    
    public abstract void c(SharedPreferences.Editor paramEditor);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/common/CameraPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */