package com.gau.go.launcherex.gowidget.weather.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Locale;

public class WidgetSettingBean
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new y();
  public int a = 2;
  public int b;
  public int c = 1;
  public String d;
  public String e;
  public boolean f = true;
  public boolean g;
  public boolean h = true;
  public boolean i;
  public boolean j;
  public int k;
  public boolean l = true;
  
  public WidgetSettingBean() {}
  
  private WidgetSettingBean(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.f = bool1;
      if (paramParcel.readByte() == 0) {
        break label169;
      }
      bool1 = true;
      label94:
      this.g = bool1;
      if (paramParcel.readByte() == 0) {
        break label174;
      }
      bool1 = true;
      label108:
      this.h = bool1;
      if (paramParcel.readByte() == 0) {
        break label179;
      }
      bool1 = true;
      label122:
      this.i = bool1;
      if (paramParcel.readByte() == 0) {
        break label184;
      }
      bool1 = true;
      label136:
      this.j = bool1;
      this.k = paramParcel.readInt();
      if (paramParcel.readByte() == 0) {
        break label189;
      }
    }
    label169:
    label174:
    label179:
    label184:
    label189:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.l = bool1;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label94;
      bool1 = false;
      break label108;
      bool1 = false;
      break label122;
      bool1 = false;
      break label136;
    }
  }
  
  public void a(Cursor paramCursor)
  {
    int m = paramCursor.getColumnIndex("setting_key");
    int n = paramCursor.getColumnIndex("setting_value");
    int i1 = Integer.parseInt("1");
    String str1 = paramCursor.getString(m);
    if (str1.equals("auto_location")) {
      if (paramCursor.getInt(n) == i1)
      {
        bool = true;
        this.i = bool;
      }
    }
    for (;;)
    {
      label65:
      if (!paramCursor.moveToNext())
      {
        return;
        bool = false;
        break;
        if (str1.equals("tempUnit"))
        {
          this.a = paramCursor.getInt(n);
        }
        else
        {
          if (str1.equals("calendarType"))
          {
            if (paramCursor.getInt(n) == i1) {}
            for (bool = true;; bool = false)
            {
              this.j = bool;
              break;
            }
          }
          if (str1.equals("festival"))
          {
            this.k = paramCursor.getInt(n);
          }
          else
          {
            if (str1.equals("isCycle"))
            {
              if (paramCursor.getInt(n) == i1) {}
              for (bool = true;; bool = false)
              {
                this.f = bool;
                break;
              }
            }
            if (str1.equals("dateStyle"))
            {
              this.c = paramCursor.getInt(n);
            }
            else if (str1.equals("windUnit"))
            {
              this.b = paramCursor.getInt(n);
              if (this.b > 6)
              {
                str1 = Locale.getDefault().getCountry();
                String str2 = Locale.getDefault().getLanguage();
                if ((str1.indexOf("CN") != -1) && (str2.equalsIgnoreCase("zh"))) {
                  this.b = 5;
                } else if ((str1.indexOf("KR") != -1) && (str2.equalsIgnoreCase("ko"))) {
                  this.b = 4;
                } else {
                  this.b = 2;
                }
              }
            }
            else
            {
              if (str1.equals("world_clock"))
              {
                if (paramCursor.getInt(n) == i1) {}
                for (bool = true;; bool = false)
                {
                  this.h = bool;
                  break;
                }
              }
              if (str1.equals("dynamic_icon_gowidget"))
              {
                if (paramCursor.getInt(n) == i1) {}
                for (bool = true;; bool = false)
                {
                  this.g = bool;
                  break;
                }
              }
              if (str1.equals("widgt_calendar")) {
                this.e = paramCursor.getString(n);
              } else if (str1.equals("widgt_clock")) {
                this.d = paramCursor.getString(n);
              } else if (str1.equals("widget_theme_switcher")) {
                if (paramCursor.getInt(n) != i1) {
                  break label507;
                }
              }
            }
          }
        }
      }
    }
    label507:
    for (boolean bool = true;; bool = false)
    {
      this.l = bool;
      break label65;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = 1;
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    if (this.f)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.g) {
        break label146;
      }
      paramInt = 1;
      label66:
      paramParcel.writeByte((byte)paramInt);
      if (!this.h) {
        break label151;
      }
      paramInt = 1;
      label81:
      paramParcel.writeByte((byte)paramInt);
      if (!this.i) {
        break label156;
      }
      paramInt = 1;
      label96:
      paramParcel.writeByte((byte)paramInt);
      if (!this.j) {
        break label161;
      }
      paramInt = 1;
      label111:
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.k);
      if (!this.l) {
        break label166;
      }
    }
    label146:
    label151:
    label156:
    label161:
    label166:
    for (paramInt = m;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label66;
      paramInt = 0;
      break label81;
      paramInt = 0;
      break label96;
      paramInt = 0;
      break label111;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/model/WidgetSettingBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */