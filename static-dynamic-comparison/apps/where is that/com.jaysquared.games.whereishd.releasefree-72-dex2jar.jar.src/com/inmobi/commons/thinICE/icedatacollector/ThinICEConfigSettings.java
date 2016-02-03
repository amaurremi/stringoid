package com.inmobi.commons.thinICE.icedatacollector;

public class ThinICEConfigSettings
{
  public static final int CELL_OP_FLAG_DISABLE_CURRENT_DETAILS = 2;
  public static final int CELL_OP_FLAG_DISABLE_SIM_DETAILS = 1;
  public static final int WIFI_FLAG_DISABLE_NOMAP_EXCLUSION = 2;
  public static final int WIFI_FLAG_DISABLE_SSID_COLLECTION = 1;
  private boolean a = true;
  private boolean b = true;
  private boolean c = true;
  private boolean d = true;
  private boolean e = true;
  private boolean f = true;
  private long g = 60000L;
  private long h = 3000L;
  private int i = 50;
  private int j = 0;
  private int k = 0;
  
  public ThinICEConfigSettings() {}
  
  public ThinICEConfigSettings(ThinICEConfigSettings paramThinICEConfigSettings)
  {
    this.a = paramThinICEConfigSettings.a;
    this.b = paramThinICEConfigSettings.b;
    this.c = paramThinICEConfigSettings.c;
    this.d = paramThinICEConfigSettings.d;
    this.e = paramThinICEConfigSettings.e;
    this.f = paramThinICEConfigSettings.f;
    this.g = paramThinICEConfigSettings.g;
    this.h = paramThinICEConfigSettings.h;
    this.i = paramThinICEConfigSettings.i;
    this.j = paramThinICEConfigSettings.j;
    this.k = paramThinICEConfigSettings.k;
  }
  
  public static boolean bitTest(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  public int getCellOpFlags()
  {
    return this.k;
  }
  
  public int getSampleHistorySize()
  {
    return this.i;
  }
  
  public long getSampleInterval()
  {
    return this.g;
  }
  
  public long getStopRequestTimeout()
  {
    return this.h;
  }
  
  public int getWifiFlags()
  {
    return this.j;
  }
  
  public boolean isEnabled()
  {
    return this.a;
  }
  
  public boolean isSampleCellEnabled()
  {
    return this.c;
  }
  
  public boolean isSampleCellOperatorEnabled()
  {
    return this.b;
  }
  
  public boolean isSampleConnectedWifiEnabled()
  {
    return this.d;
  }
  
  public boolean isSampleLocationEnabled()
  {
    return this.e;
  }
  
  public boolean isSampleVisibleWifiEnabled()
  {
    return this.f;
  }
  
  public ThinICEConfigSettings setCellOpFlags(int paramInt)
  {
    this.k = paramInt;
    return this;
  }
  
  public ThinICEConfigSettings setEnabled(boolean paramBoolean)
  {
    this.a = paramBoolean;
    return this;
  }
  
  public ThinICEConfigSettings setSampleCellEnabled(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public ThinICEConfigSettings setSampleCellOperatorEnabled(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  public ThinICEConfigSettings setSampleConnectedWifiEnabled(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public ThinICEConfigSettings setSampleHistorySize(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Sample history size must be greater than 0");
    }
    this.i = paramInt;
    return this;
  }
  
  public ThinICEConfigSettings setSampleInterval(long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("Sample interval must be greater than 0");
    }
    this.g = paramLong;
    return this;
  }
  
  public ThinICEConfigSettings setSampleLocationEnabled(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public ThinICEConfigSettings setSampleVisibleWifiEnabled(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public ThinICEConfigSettings setStopRequestTimeout(long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("Stop request timeout must be greater than 0");
    }
    this.h = paramLong;
    return this;
  }
  
  public ThinICEConfigSettings setWifiFlags(int paramInt)
  {
    this.j = paramInt;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName()).append("[");
    localStringBuilder.append("mEnabled=").append(this.a).append(", ");
    localStringBuilder.append("mSampleCellOperatorEnabled=").append(this.b).append(", ");
    localStringBuilder.append("mSampleCellEnabled=").append(this.c).append(", ");
    localStringBuilder.append("mSampleConnectedWifiEnabled=").append(this.d).append(", ");
    localStringBuilder.append("mSampleLocationEnabled=").append(this.e).append(", ");
    localStringBuilder.append("mSampleVisibleWifiEnabled=").append(this.f).append(", ");
    localStringBuilder.append("mSampleInterval=").append(this.g).append(", ");
    localStringBuilder.append("mStopRequestTimeout=").append(this.h).append(", ");
    localStringBuilder.append("mWifiFlags=").append(Integer.toBinaryString(this.j)).append(", ");
    localStringBuilder.append("mCellOpFlags=").append(Integer.toBinaryString(this.k));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/inmobi/commons/thinICE/icedatacollector/ThinICEConfigSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */