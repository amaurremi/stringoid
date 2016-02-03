package com.tapjoy.mraid.controller;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tapjoy.mraid.util.NavigationStringEnum;
import com.tapjoy.mraid.util.TransitionStringEnum;
import com.tapjoy.mraid.view.MraidView;
import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class Abstract
{
  private static final String BOOLEAN_TYPE = "boolean";
  public static final String EXIT = "exit";
  private static final String FLOAT_TYPE = "float";
  public static final String FULL_SCREEN = "fullscreen";
  private static final String INT_TYPE = "int";
  private static final String NAVIGATION_TYPE = "class com.tapjoy.mraid.util.NavigationStringEnum";
  private static final String STRING_TYPE = "class java.lang.String";
  public static final String STYLE_NORMAL = "normal";
  private static final String TRANSITION_TYPE = "class com.tapjoy.mraid.util.TransitionStringEnum";
  protected Context mContext;
  protected MraidView mMraidView;
  
  public Abstract(MraidView paramMraidView, Context paramContext)
  {
    this.mMraidView = paramMraidView;
    this.mContext = paramContext;
  }
  
  protected static Object getFromJSON(JSONObject paramJSONObject, Class<?> paramClass)
    throws IllegalAccessException, InstantiationException, NumberFormatException, NullPointerException
  {
    Field[] arrayOfField = paramClass.getDeclaredFields();
    paramClass = paramClass.newInstance();
    int j = 0;
    Field localField;
    String str1;
    String str2;
    if (j < arrayOfField.length)
    {
      localField = arrayOfField[j];
      str1 = localField.getName().replace('_', '-');
      str2 = localField.getType().toString();
    }
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
        label114:
        localJSONException.printStackTrace();
        continue;
        if (str2.equals("boolean"))
        {
          localJSONException.set(paramClass, Boolean.valueOf(paramJSONObject.getBoolean(str1)));
          continue;
        }
        if (str2.equals("float"))
        {
          localJSONException.set(paramClass, Float.valueOf(Float.parseFloat(paramJSONObject.getString(str1))));
          continue;
        }
        if (str2.equals("class com.tapjoy.mraid.util.NavigationStringEnum"))
        {
          localJSONException.set(paramClass, NavigationStringEnum.fromString(paramJSONObject.getString(str1)));
          continue;
        }
        if (!str2.equals("class com.tapjoy.mraid.util.TransitionStringEnum")) {
          continue;
        }
        localJSONException.set(paramClass, TransitionStringEnum.fromString(paramJSONObject.getString(str1)));
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
      break label114;
      i = Integer.parseInt(str1);
      break label114;
      if (!str2.equals("class java.lang.String")) {
        break label194;
      }
      localField.set(paramClass, paramJSONObject.getString(str1));
    }
    label194:
    return paramClass;
  }
  
  public abstract void stopAllListeners();
  
  public static class Dimensions
    extends Abstract.ReflectedParcelable
  {
    public static final Parcelable.Creator<Dimensions> CREATOR = new Parcelable.Creator()
    {
      public Abstract.Dimensions createFromParcel(Parcel paramAnonymousParcel)
      {
        return new Abstract.Dimensions(paramAnonymousParcel);
      }
      
      public Abstract.Dimensions[] newArray(int paramAnonymousInt)
      {
        return new Abstract.Dimensions[paramAnonymousInt];
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
  
  public static class PlayerProperties
    extends Abstract.ReflectedParcelable
  {
    public static final Parcelable.Creator<PlayerProperties> CREATOR = new Parcelable.Creator()
    {
      public Abstract.PlayerProperties createFromParcel(Parcel paramAnonymousParcel)
      {
        return new Abstract.PlayerProperties(paramAnonymousParcel);
      }
      
      public Abstract.PlayerProperties[] newArray(int paramAnonymousInt)
      {
        return new Abstract.PlayerProperties[paramAnonymousInt];
      }
    };
    public boolean audioMuted;
    public boolean autoPlay;
    public boolean doLoop;
    public boolean inline;
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
      this.inline = false;
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
      return this.autoPlay == true;
    }
    
    public boolean isFullScreen()
    {
      return this.startStyle.equalsIgnoreCase("fullscreen");
    }
    
    public void muteAudio()
    {
      this.audioMuted = true;
    }
    
    public void setProperties(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString1, String paramString2)
    {
      this.autoPlay = paramBoolean2;
      this.showControl = paramBoolean3;
      this.doLoop = paramBoolean5;
      this.audioMuted = paramBoolean1;
      this.startStyle = paramString1;
      this.stopStyle = paramString2;
      this.inline = paramBoolean4;
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
    extends Abstract.ReflectedParcelable
  {
    public static final Parcelable.Creator<Properties> CREATOR = new Parcelable.Creator()
    {
      public Abstract.Properties createFromParcel(Parcel paramAnonymousParcel)
      {
        return new Abstract.Properties(paramAnonymousParcel);
      }
      
      public Abstract.Properties[] newArray(int paramAnonymousInt)
      {
        return new Abstract.Properties[paramAnonymousInt];
      }
    };
    public int backgroundColor;
    public float backgroundOpacity;
    public boolean isModal;
    public boolean lockOrientation;
    public boolean useBackground;
    public boolean useCustomClose;
    
    public Properties()
    {
      this.useBackground = false;
      this.backgroundColor = 0;
      this.backgroundOpacity = 0.0F;
      this.isModal = false;
      this.lockOrientation = false;
      this.useCustomClose = false;
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
      Field[] arrayOfField = getClass().getDeclaredFields();
      int i = 0;
      for (;;)
      {
        try
        {
          if (i < arrayOfField.length)
          {
            localField = arrayOfField[i];
            Object localObject = localField.getType();
            if (!((Class)localObject).isEnum()) {
              continue;
            }
            localObject = ((Class)localObject).toString();
            if (((String)localObject).equals("class com.tapjoy.mraid.util.NavigationStringEnum")) {
              localField.set(this, NavigationStringEnum.fromString(paramParcel.readString()));
            } else if (((String)localObject).equals("class com.tapjoy.mraid.util.TransitionStringEnum")) {
              localField.set(this, TransitionStringEnum.fromString(paramParcel.readString()));
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
      Field[] arrayOfField = getClass().getDeclaredFields();
      paramInt = 0;
      for (;;)
      {
        try
        {
          if (paramInt < arrayOfField.length)
          {
            localObject1 = arrayOfField[paramInt];
            Object localObject2 = ((Field)localObject1).getType();
            if (!((Class)localObject2).isEnum()) {
              continue;
            }
            localObject2 = ((Class)localObject2).toString();
            if (((String)localObject2).equals("class com.tapjoy.mraid.util.NavigationStringEnum")) {
              paramParcel.writeString(((NavigationStringEnum)((Field)localObject1).get(this)).getText());
            } else if (((String)localObject2).equals("class com.tapjoy.mraid.util.TransitionStringEnum")) {
              paramParcel.writeString(((TransitionStringEnum)((Field)localObject1).get(this)).getText());
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/mraid/controller/Abstract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */