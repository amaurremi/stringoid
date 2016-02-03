package com.skplanet.tad.mraid.controller;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.skplanet.tad.mraid.view.MraidView;
import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class MraidController
{
  public static final String STYLE_CONTROLS = "controls";
  public static final String STYLE_EXIT = "exit";
  public static final String STYLE_FULLSCREEN = "fullscreen";
  public static final String STYLE_NORMAL = "normal";
  protected MraidView a;
  protected Context b;
  
  public MraidController(MraidView paramMraidView, Context paramContext)
  {
    this.a = paramMraidView;
    this.b = paramContext;
  }
  
  protected static Object a(JSONObject paramJSONObject, Class paramClass)
    throws IllegalAccessException, InstantiationException, NumberFormatException, NullPointerException
  {
    Field[] arrayOfField = (Field[])null;
    arrayOfField = paramClass.getDeclaredFields();
    paramClass = paramClass.newInstance();
    int j = 0;
    if (j >= arrayOfField.length) {
      return paramClass;
    }
    Field localField = arrayOfField[j];
    String str1 = localField.getName().replace('_', '-');
    str2 = localField.getType().toString();
    for (;;)
    {
      try
      {
        if (str2.equals("int"))
        {
          str1 = paramJSONObject.getString(str1).toLowerCase();
          boolean bool = str1.startsWith("#");
          if (bool) {
            i = -1;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        int i;
        int k;
        label122:
        localJSONException.printStackTrace();
        continue;
        if (str2.equals("boolean"))
        {
          localJSONException.set(paramClass, Boolean.valueOf(paramJSONObject.getBoolean(localException1)));
          continue;
        }
        if (!str2.equals("float")) {
          continue;
        }
        localJSONException.set(paramClass, Float.valueOf(Float.parseFloat(paramJSONObject.getString(localException1))));
        continue;
      }
      try
      {
        if (!str1.startsWith("#0x")) {
          continue;
        }
        k = Integer.decode(str1.substring(1)).intValue();
        i = k;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        continue;
      }
    }
    localField.set(paramClass, Integer.valueOf(i));
    for (;;)
    {
      j += 1;
      break;
      try
      {
        k = Integer.parseInt(str1.substring(1), 16);
        i = k;
      }
      catch (Exception localException2) {}
      try
      {
        i = Integer.parseInt(str1);
      }
      catch (Exception localException1)
      {
        i = 0;
      }
      break label122;
      if (!str2.equals("class java.lang.String")) {
        break label209;
      }
      localField.set(paramClass, paramJSONObject.getString(localException1));
    }
  }
  
  public abstract void stopAllListeners();
  
  public static class Dimensions
    extends MraidController.ReflectedParcelable
  {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
    {
      public MraidController.Dimensions createFromParcel(Parcel paramAnonymousParcel)
      {
        return new MraidController.Dimensions(paramAnonymousParcel);
      }
      
      public MraidController.Dimensions[] newArray(int paramAnonymousInt)
      {
        return new MraidController.Dimensions[paramAnonymousInt];
      }
    };
    public int height;
    public int width;
    public int x;
    public int y;
    
    public Dimensions()
    {
      this.x = -1;
      this.y = -1;
      this.width = -1;
      this.height = -1;
    }
    
    protected Dimensions(Parcel paramParcel)
    {
      super();
    }
  }
  
  public static class DownloadInfoProperties
    extends MraidController.ReflectedParcelable
  {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
    {
      public MraidController.DownloadInfoProperties createFromParcel(Parcel paramAnonymousParcel)
      {
        return new MraidController.DownloadInfoProperties(paramAnonymousParcel);
      }
      
      public MraidController.DownloadInfoProperties[] newArray(int paramAnonymousInt)
      {
        return new MraidController.DownloadInfoProperties[paramAnonymousInt];
      }
    };
    public String alternative;
    public String itunes;
    public String market;
    public String tstore;
    
    public DownloadInfoProperties()
    {
      this.tstore = "";
      this.market = "";
      this.itunes = "";
      this.alternative = "";
    }
    
    protected DownloadInfoProperties(Parcel paramParcel)
    {
      super();
    }
  }
  
  public static class ExpandProperties
    extends MraidController.ReflectedParcelable
  {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
    {
      public MraidController.ExpandProperties createFromParcel(Parcel paramAnonymousParcel)
      {
        return new MraidController.ExpandProperties(paramAnonymousParcel);
      }
      
      public MraidController.ExpandProperties[] newArray(int paramAnonymousInt)
      {
        return new MraidController.ExpandProperties[paramAnonymousInt];
      }
    };
    public int height;
    public boolean isModal;
    public boolean useCustomClose;
    public int width;
    
    public ExpandProperties()
    {
      this.width = 0;
      this.height = 0;
      this.useCustomClose = false;
      this.isModal = true;
    }
    
    protected ExpandProperties(Parcel paramParcel)
    {
      super();
    }
  }
  
  public static class OrientationProperties
    extends MraidController.ReflectedParcelable
  {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
    {
      public MraidController.OrientationProperties createFromParcel(Parcel paramAnonymousParcel)
      {
        return new MraidController.OrientationProperties(paramAnonymousParcel);
      }
      
      public MraidController.OrientationProperties[] newArray(int paramAnonymousInt)
      {
        return new MraidController.OrientationProperties[paramAnonymousInt];
      }
    };
    public boolean allowOrientationChange;
    public String forceOrientation;
    
    public OrientationProperties()
    {
      this.allowOrientationChange = true;
      this.forceOrientation = "none";
    }
    
    protected OrientationProperties(Parcel paramParcel)
    {
      super();
    }
  }
  
  public static class PackageInfoProperties
    extends MraidController.ReflectedParcelable
  {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
    {
      public MraidController.PackageInfoProperties createFromParcel(Parcel paramAnonymousParcel)
      {
        return new MraidController.PackageInfoProperties(paramAnonymousParcel);
      }
      
      public MraidController.PackageInfoProperties[] newArray(int paramAnonymousInt)
      {
        return new MraidController.PackageInfoProperties[paramAnonymousInt];
      }
    };
    public String android;
    public String ios;
    
    public PackageInfoProperties()
    {
      this.android = "";
      this.ios = "";
    }
    
    protected PackageInfoProperties(Parcel paramParcel)
    {
      super();
    }
  }
  
  public static class PlayerProperties
    extends MraidController.ReflectedParcelable
  {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
    {
      public MraidController.PlayerProperties createFromParcel(Parcel paramAnonymousParcel)
      {
        return new MraidController.PlayerProperties(paramAnonymousParcel);
      }
      
      public MraidController.PlayerProperties[] newArray(int paramAnonymousInt)
      {
        return new MraidController.PlayerProperties[paramAnonymousInt];
      }
    };
    public boolean autoPlay;
    public boolean doLoop;
    public boolean doMute;
    public boolean showControl;
    public String startStyle;
    public String stopStyle;
    
    public PlayerProperties()
    {
      this.showControl = true;
      this.autoPlay = true;
      this.doMute = false;
      this.doLoop = false;
      this.stopStyle = "normal";
      this.startStyle = "normal";
    }
    
    public PlayerProperties(Parcel paramParcel)
    {
      super();
    }
    
    public boolean doLoop()
    {
      return this.doLoop;
    }
    
    public boolean doMute()
    {
      return this.doMute;
    }
    
    public boolean exitOnComplete()
    {
      return this.stopStyle.equalsIgnoreCase("exit");
    }
    
    public boolean isAutoPlay()
    {
      return this.autoPlay;
    }
    
    public boolean isFullScreen()
    {
      return this.startStyle.equalsIgnoreCase("fullscreen");
    }
    
    public void muteAudio()
    {
      this.doMute = true;
    }
    
    public void setProperties(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2)
    {
      this.autoPlay = paramBoolean2;
      this.showControl = paramBoolean3;
      this.doLoop = paramBoolean4;
      this.doMute = paramBoolean1;
      this.startStyle = paramString1;
      this.stopStyle = paramString2;
    }
    
    public void setStopStyle(String paramString)
    {
      this.stopStyle = paramString;
    }
    
    public boolean showControl()
    {
      return this.showControl;
    }
  }
  
  public static class ReflectedParcelable
    implements Parcelable
  {
    public ReflectedParcelable() {}
    
    protected ReflectedParcelable(Parcel paramParcel)
    {
      Field[] arrayOfField = (Field[])null;
      arrayOfField = getClass().getDeclaredFields();
      int i = 0;
      try
      {
        for (;;)
        {
          if (i >= arrayOfField.length) {
            return;
          }
          Field localField = arrayOfField[i];
          if ((!localField.getType().isEnum()) && (!(localField.get(this) instanceof Parcelable.Creator))) {
            localField.set(this, paramParcel.readValue(null));
          }
          i += 1;
        }
        return;
      }
      catch (IllegalArgumentException paramParcel)
      {
        paramParcel.printStackTrace();
        return;
      }
      catch (IllegalAccessException paramParcel)
      {
        paramParcel.printStackTrace();
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      Field[] arrayOfField = (Field[])null;
      arrayOfField = getClass().getDeclaredFields();
      paramInt = 0;
      try
      {
        for (;;)
        {
          if (paramInt >= arrayOfField.length) {
            return;
          }
          Object localObject = arrayOfField[paramInt];
          if (!((Field)localObject).getType().isEnum())
          {
            localObject = ((Field)localObject).get(this);
            if (!(localObject instanceof Parcelable.Creator)) {
              paramParcel.writeValue(localObject);
            }
          }
          paramInt += 1;
        }
        return;
      }
      catch (IllegalArgumentException paramParcel)
      {
        paramParcel.printStackTrace();
        return;
      }
      catch (IllegalAccessException paramParcel)
      {
        paramParcel.printStackTrace();
      }
    }
  }
  
  public static class ResizeProperties
    extends MraidController.ReflectedParcelable
  {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
    {
      public MraidController.ResizeProperties createFromParcel(Parcel paramAnonymousParcel)
      {
        return new MraidController.ResizeProperties(paramAnonymousParcel);
      }
      
      public MraidController.ResizeProperties[] newArray(int paramAnonymousInt)
      {
        return new MraidController.ResizeProperties[paramAnonymousInt];
      }
    };
    public boolean allowOffscreen;
    public String customClosePosition;
    public int height;
    public int offsetX;
    public int offsetY;
    public int width;
    
    public ResizeProperties()
    {
      this.width = 0;
      this.height = 0;
      this.customClosePosition = "top-right";
      this.offsetX = 0;
      this.offsetY = 0;
      this.allowOffscreen = true;
    }
    
    protected ResizeProperties(Parcel paramParcel)
    {
      super();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/skplanet/tad/mraid/controller/MraidController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */