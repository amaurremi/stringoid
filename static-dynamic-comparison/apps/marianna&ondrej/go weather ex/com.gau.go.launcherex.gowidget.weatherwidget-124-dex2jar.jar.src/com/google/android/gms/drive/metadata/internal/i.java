package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;

public class i
  extends b<String>
{
  public i(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  public static final Collection<String> ay(String paramString)
    throws JSONException
  {
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramString = new JSONArray(paramString);
    int i = 0;
    while (i < paramString.length())
    {
      localArrayList.add(paramString.getString(i));
      i += 1;
    }
    return Collections.unmodifiableCollection(localArrayList);
  }
  
  protected void a(Bundle paramBundle, Collection<String> paramCollection)
  {
    paramBundle.putStringArrayList(getName(), new ArrayList(paramCollection));
  }
  
  protected Collection<String> c(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    try
    {
      paramDataHolder = ay(paramDataHolder.getString(getName(), paramInt1, paramInt2));
      return paramDataHolder;
    }
    catch (JSONException paramDataHolder)
    {
      throw new IllegalStateException("DataHolder supplied invalid JSON", paramDataHolder);
    }
  }
  
  protected Collection<String> j(Bundle paramBundle)
  {
    return paramBundle.getStringArrayList(getName());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */