package com.inmobi.androidsdk.ai.controller;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.inmobi.androidsdk.ai.container.IMWebView;
import com.inmobi.androidsdk.ai.controller.util.IMNavigationStringEnum;
import com.inmobi.androidsdk.ai.controller.util.IMTransitionStringEnum;
import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class JSController
{
  public static final String EXIT = "exit";
  public static final String FULL_SCREEN = "fullscreen";
  public static final String STYLE_NORMAL = "normal";
  protected ExpandProperties expProps;
  protected IMWebView imWebView;
  protected Context mContext;
  protected ExpandProperties temporaryexpProps;
  
  public JSController(IMWebView paramIMWebView, Context paramContext)
  {
    this.imWebView = paramIMWebView;
    this.mContext = paramContext;
    this.expProps = new ExpandProperties();
    this.temporaryexpProps = new ExpandProperties();
  }
  
  protected static Object getFromJSON(JSONObject paramJSONObject, Class<?> paramClass)
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
    String str2 = localField.getType().toString();
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
      catch (NumberFormatException localNumberFormatException) {}
    }
    localField.set(paramClass, Integer.valueOf(i));
    for (;;)
    {
      j += 1;
      break;
      k = Integer.parseInt(str1.substring(1), 16);
      i = k;
      break label122;
      i = Integer.parseInt(str1);
      break label122;
      if (str2.equals("class java.lang.String")) {
        localField.set(paramClass, paramJSONObject.getString(str1));
      } else if (str2.equals("boolean")) {
        localField.set(paramClass, Boolean.valueOf(paramJSONObject.getBoolean(str1)));
      } else if (str2.equals("float")) {
        localField.set(paramClass, Float.valueOf(Float.parseFloat(paramJSONObject.getString(str1))));
      } else if (str2.equals("class com.mraid.NavigationStringEnum")) {
        localField.set(paramClass, IMNavigationStringEnum.fromString(paramJSONObject.getString(str1)));
      } else if (str2.equals("class com.mraid.TransitionStringEnum")) {
        localField.set(paramClass, IMTransitionStringEnum.fromString(paramJSONObject.getString(str1)));
      }
    }
  }
  
  public void reinitializeExpandProperties()
  {
    this.expProps.reinitializeExpandProperties();
  }
  
  public abstract void stopAllListeners();
  
  public static class Dimensions
    extends JSController.ReflectedParcelable
  {
    public static final Parcelable.Creator<Dimensions> CREATOR = new Parcelable.Creator()
    {
      public JSController.Dimensions a(Parcel paramAnonymousParcel)
      {
        return new JSController.Dimensions(paramAnonymousParcel);
      }
      
      public JSController.Dimensions[] a(int paramAnonymousInt)
      {
        return new JSController.Dimensions[paramAnonymousInt];
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
    
    public String toString()
    {
      return "x: " + this.x + ", y: " + this.y + ", width: " + this.width + ", height: " + this.height;
    }
  }
  
  public static class ExpandProperties
    extends JSController.ReflectedParcelable
  {
    public static final Parcelable.Creator<ExpandProperties> CREATOR = new Parcelable.Creator()
    {
      public JSController.ExpandProperties a(Parcel paramAnonymousParcel)
      {
        return new JSController.ExpandProperties(paramAnonymousParcel);
      }
      
      public JSController.ExpandProperties[] a(int paramAnonymousInt)
      {
        return new JSController.ExpandProperties[paramAnonymousInt];
      }
    };
    public int actualHeightRequested;
    public int actualWidthRequested;
    public int bottomStuff;
    public int currentX;
    public int currentY;
    public int height;
    public boolean isModal;
    public boolean lockOrientation;
    public String orientation;
    public int portraitHeightRequested;
    public int portraitWidthRequested;
    public String rotationAtExpand;
    public int topStuff;
    public boolean useCustomClose;
    public int width;
    public int x;
    public int y;
    public boolean zeroWidthHeight;
    
    public ExpandProperties()
    {
      this.width = 0;
      this.height = 0;
      this.x = -1;
      this.y = -1;
      this.useCustomClose = false;
      this.isModal = true;
      this.lockOrientation = false;
      this.orientation = "";
      this.actualWidthRequested = 0;
      this.actualHeightRequested = 0;
      this.topStuff = 0;
      this.bottomStuff = 0;
      this.portraitWidthRequested = 0;
      this.portraitHeightRequested = 0;
      this.zeroWidthHeight = false;
      this.rotationAtExpand = "";
      this.currentX = 0;
      this.currentY = 0;
    }
    
    protected ExpandProperties(Parcel paramParcel)
    {
      super();
    }
    
    public void reinitializeExpandProperties()
    {
      this.width = 0;
      this.height = 0;
      this.x = -1;
      this.y = -1;
      this.useCustomClose = false;
      this.isModal = true;
      this.lockOrientation = false;
      this.orientation = "";
      this.actualWidthRequested = 0;
      this.actualHeightRequested = 0;
      this.topStuff = 0;
      this.bottomStuff = 0;
      this.portraitWidthRequested = 0;
      this.portraitHeightRequested = 0;
      this.zeroWidthHeight = false;
      this.rotationAtExpand = "";
      this.currentX = 0;
      this.currentY = 0;
    }
  }
  
  public static class PlayerProperties
    extends JSController.ReflectedParcelable
  {
    public static final Parcelable.Creator<PlayerProperties> CREATOR = new Parcelable.Creator()
    {
      public JSController.PlayerProperties a(Parcel paramAnonymousParcel)
      {
        return new JSController.PlayerProperties(paramAnonymousParcel);
      }
      
      public JSController.PlayerProperties[] a(int paramAnonymousInt)
      {
        return new JSController.PlayerProperties[paramAnonymousInt];
      }
    };
    public boolean audioMuted;
    public boolean autoPlay;
    public boolean doLoop;
    public String id;
    public boolean showControl;
    public String startStyle;
    public String stopStyle;
    
    public PlayerProperties()
    {
      this.showControl = true;
      this.autoPlay = true;
      this.audioMuted = false;
      this.doLoop = false;
      this.stopStyle = "normal";
      this.startStyle = "normal";
      this.id = "";
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
      return this.audioMuted;
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
    
    public void setFullScreen()
    {
      this.startStyle = "fullscreen";
    }
    
    public void setProperties(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2, String paramString3)
    {
      this.autoPlay = paramBoolean2;
      this.showControl = paramBoolean3;
      this.doLoop = paramBoolean4;
      this.audioMuted = paramBoolean1;
      this.startStyle = paramString1;
      this.stopStyle = paramString2;
      this.id = paramString3;
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
  
  public static class Properties
    extends JSController.ReflectedParcelable
  {
    public static final Parcelable.Creator<Properties> CREATOR = new Parcelable.Creator()
    {
      public JSController.Properties a(Parcel paramAnonymousParcel)
      {
        return new JSController.Properties(paramAnonymousParcel);
      }
      
      public JSController.Properties[] a(int paramAnonymousInt)
      {
        return new JSController.Properties[paramAnonymousInt];
      }
    };
    public int backgroundColor;
    public float backgroundOpacity;
    public boolean useBackground;
    
    public Properties()
    {
      this.useBackground = false;
      this.backgroundColor = 0;
      this.backgroundOpacity = 0.0F;
    }
    
    protected Properties(Parcel paramParcel)
    {
      super();
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
      for (;;)
      {
        try
        {
          if (i >= arrayOfField.length) {
            return;
          }
          localField = arrayOfField[i];
          Object localObject = localField.getType();
          if (((Class)localObject).isEnum())
          {
            localObject = ((Class)localObject).toString();
            if (((String)localObject).equals("class com.mraid.NavigationStringEnum")) {
              localField.set(this, IMNavigationStringEnum.fromString(paramParcel.readString()));
            } else if (((String)localObject).equals("class com.mraid.TransitionStringEnum")) {
              localField.set(this, IMTransitionStringEnum.fromString(paramParcel.readString()));
            }
          }
        }
        catch (IllegalArgumentException paramParcel)
        {
          Field localField;
          paramParcel.printStackTrace();
          return;
          if (!(localField.get(this) instanceof Parcelable.Creator)) {
            localField.set(this, paramParcel.readValue(null));
          }
        }
        catch (IllegalAccessException paramParcel)
        {
          paramParcel.printStackTrace();
          return;
        }
        i += 1;
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
      for (;;)
      {
        try
        {
          if (paramInt >= arrayOfField.length) {
            return;
          }
          localObject1 = arrayOfField[paramInt];
          Object localObject2 = ((Field)localObject1).getType();
          if (((Class)localObject2).isEnum())
          {
            localObject2 = ((Class)localObject2).toString();
            if (((String)localObject2).equals("class com.mraid.NavigationStringEnum")) {
              paramParcel.writeString(((IMNavigationStringEnum)((Field)localObject1).get(this)).getText());
            } else if (((String)localObject2).equals("class com.mraid.TransitionStringEnum")) {
              paramParcel.writeString(((IMTransitionStringEnum)((Field)localObject1).get(this)).getText());
            }
          }
        }
        catch (IllegalArgumentException paramParcel)
        {
          paramParcel.printStackTrace();
          return;
          Object localObject1 = ((Field)localObject1).get(this);
          if (!(localObject1 instanceof Parcelable.Creator)) {
            paramParcel.writeValue(localObject1);
          }
        }
        catch (IllegalAccessException paramParcel)
        {
          paramParcel.printStackTrace();
          return;
        }
        paramInt += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/ai/controller/JSController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */