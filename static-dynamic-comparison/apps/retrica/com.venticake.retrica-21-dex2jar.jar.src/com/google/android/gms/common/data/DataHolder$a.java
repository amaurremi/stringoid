package com.google.android.gms.common.data;

import com.google.android.gms.internal.hm;
import java.util.ArrayList;
import java.util.HashMap;

public class DataHolder$a
{
  private final String[] EG;
  private final ArrayList<HashMap<String, Object>> EP;
  private final String EQ;
  private final HashMap<Object, Integer> ER;
  private boolean ES;
  private String ET;
  
  private DataHolder$a(String[] paramArrayOfString, String paramString)
  {
    this.EG = ((String[])hm.f(paramArrayOfString));
    this.EP = new ArrayList();
    this.EQ = paramString;
    this.ER = new HashMap();
    this.ES = false;
    this.ET = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/data/DataHolder$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */