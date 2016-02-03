package com.mobisystems.mobiscanner.controller;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockPreferenceActivity;
import com.actionbarsherlock.view.MenuItem;
import com.google.analytics.tracking.android.l;
import com.mobisystems.mobiscanner.common.CommonPreferences.Keys;
import com.mobisystems.mobiscanner.common.CommonPreferences.MeasurementUnits;
import com.mobisystems.mobiscanner.common.CommonPreferences.PDFImageDensity;
import com.mobisystems.mobiscanner.common.CommonPreferences.PDFImageQuality;
import com.mobisystems.mobiscanner.common.CommonPreferences.PageOrientation;
import com.mobisystems.mobiscanner.common.CommonPreferences.PageSize;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.common.c;
import com.mobisystems.mobiscanner.common.d;
import com.mobisystems.mobiscanner.error.a;

public class SettingsActivity
  extends SherlockPreferenceActivity
  implements SharedPreferences.OnSharedPreferenceChangeListener, Preference.OnPreferenceChangeListener
{
  private final c mLog = new c(this);
  
  private void Ef()
  {
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }
  
  private void HG()
  {
    Object localObject = findPreference(CommonPreferences.Keys.apw.getKey());
    b(CommonPreferences.MeasurementUnits.de(((Preference)localObject).getSharedPreferences().getString(((Preference)localObject).getKey(), "")));
    a(CommonPreferences.PageSize.dk(CommonPreferences.Keys.apx.Dl()));
    localObject = CommonPreferences.PageOrientation.Dq();
    ListPreference localListPreference = (ListPreference)findPreference(CommonPreferences.Keys.apA.getKey());
    localListPreference.setEntries((CharSequence[])localObject);
    localListPreference.setSummary(localListPreference.getEntry());
    localObject = CommonPreferences.PDFImageQuality.Dq();
    localListPreference = (ListPreference)findPreference(CommonPreferences.Keys.apG.getKey());
    localListPreference.setEntries((CharSequence[])localObject);
    localListPreference.setSummary(localListPreference.getEntry());
    localObject = CommonPreferences.PDFImageDensity.Dq();
    localListPreference = (ListPreference)findPreference(CommonPreferences.Keys.apH.getKey());
    localListPreference.setEntries((CharSequence[])localObject);
    localListPreference.setSummary(localListPreference.getEntry());
  }
  
  private String HH()
  {
    Object localObject = findPreference(CommonPreferences.Keys.apC.getKey());
    localObject = "" + ((Preference)localObject).getSummary();
    localObject = (String)localObject + ";";
    Preference localPreference = findPreference(CommonPreferences.Keys.apD.getKey());
    localObject = (String)localObject + localPreference.getSummary();
    localObject = (String)localObject + ";";
    localPreference = findPreference(CommonPreferences.Keys.apE.getKey());
    localObject = (String)localObject + localPreference.getSummary();
    localObject = (String)localObject + ";";
    localPreference = findPreference(CommonPreferences.Keys.apF.getKey());
    return (String)localObject + localPreference.getSummary();
  }
  
  private void a(Preference paramPreference)
  {
    if ((paramPreference instanceof PreferenceGroup))
    {
      paramPreference = (PreferenceGroup)paramPreference;
      int j = paramPreference.getPreferenceCount();
      int i = 0;
      while (i < j)
      {
        a(paramPreference.getPreference(i));
        i += 1;
      }
    }
    paramPreference.setOnPreferenceChangeListener(this);
  }
  
  private void a(PreferenceGroup paramPreferenceGroup)
  {
    int j = paramPreferenceGroup.getPreferenceCount();
    int i = 0;
    while (i < j)
    {
      b(paramPreferenceGroup.getPreference(i));
      i += 1;
    }
  }
  
  private void a(CommonPreferences.PageSize paramPageSize)
  {
    Preference localPreference;
    if (paramPageSize == CommonPreferences.PageSize.auj)
    {
      localPreference = findPreference(CommonPreferences.Keys.apy.getKey());
      localPreference.setEnabled(true);
      b(localPreference);
      localPreference = findPreference(CommonPreferences.Keys.apz.getKey());
      localPreference.setEnabled(true);
      b(localPreference);
    }
    while (paramPageSize == CommonPreferences.PageSize.aui)
    {
      paramPageSize = findPreference(CommonPreferences.Keys.apA.getKey());
      paramPageSize.setEnabled(false);
      b(paramPageSize);
      return;
      localPreference = findPreference(CommonPreferences.Keys.apy.getKey());
      localPreference.setEnabled(false);
      b(localPreference);
      localPreference = findPreference(CommonPreferences.Keys.apz.getKey());
      localPreference.setEnabled(false);
      b(localPreference);
    }
    paramPageSize = findPreference(CommonPreferences.Keys.apA.getKey());
    paramPageSize.setEnabled(true);
    b(paramPageSize);
  }
  
  private void b(Preference paramPreference)
  {
    if ((paramPreference instanceof PreferenceGroup))
    {
      a((PreferenceGroup)paramPreference);
      if (CommonPreferences.Keys.apB.getKey().equals(paramPreference.getKey())) {
        paramPreference.setSummary(HH());
      }
    }
    do
    {
      return;
      if (!paramPreference.isEnabled()) {
        break;
      }
      if ((paramPreference instanceof ListPreference))
      {
        paramPreference.setSummary(((ListPreference)paramPreference).getEntry());
        return;
      }
      if ((paramPreference instanceof IntEditTextPreference))
      {
        paramPreference = (IntEditTextPreference)paramPreference;
        paramPreference.setSummary(String.valueOf(paramPreference.getValue()));
        return;
      }
      if ((paramPreference instanceof PageMeasureEditTextPreference))
      {
        paramPreference = (PageMeasureEditTextPreference)paramPreference;
        CommonPreferences.MeasurementUnits localMeasurementUnits = CommonPreferences.MeasurementUnits.de(CommonPreferences.Keys.apw.Dl());
        float f = CommonPreferences.MeasurementUnits.a(paramPreference.HB(), localMeasurementUnits);
        paramPreference.setSummary(String.valueOf(CommonPreferences.MeasurementUnits.z(f)) + localMeasurementUnits.Dn());
        String str = paramPreference.getTitle().toString();
        paramPreference.setDialogTitle(str + " (" + localMeasurementUnits.Do() + ")");
        return;
      }
    } while (!(paramPreference instanceof EditTextPreference));
    paramPreference.setSummary(((EditTextPreference)paramPreference).getText());
    return;
    paramPreference.setSummary(null);
  }
  
  private void b(CommonPreferences.MeasurementUnits paramMeasurementUnits)
  {
    paramMeasurementUnits = CommonPreferences.PageSize.a(paramMeasurementUnits);
    ListPreference localListPreference = (ListPreference)findPreference(CommonPreferences.Keys.apx.getKey());
    localListPreference.setEntries(paramMeasurementUnits);
    localListPreference.setSummary(localListPreference.getEntry());
    dI(CommonPreferences.Keys.apy.getKey());
    dI(CommonPreferences.Keys.apz.getKey());
    dI(CommonPreferences.Keys.apC.getKey());
    dI(CommonPreferences.Keys.apD.getKey());
    dI(CommonPreferences.Keys.apE.getKey());
    dI(CommonPreferences.Keys.apF.getKey());
    dI(CommonPreferences.Keys.apB.getKey());
  }
  
  private void dI(String paramString)
  {
    paramString = findPreference(paramString);
    if (paramString != null) {
      b(paramString);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    a.ay(getApplicationContext());
    super.onCreate(paramBundle);
    addPreferencesFromResource(2131034112);
    Ef();
    if (PreferenceManager.getDefaultSharedPreferences(this).getBoolean(CommonPreferences.Keys.apR.getKey(), false))
    {
      paramBundle = findPreference(getResources().getString(2131296378));
      if (paramBundle != null) {
        paramBundle.setEnabled(false);
      }
    }
    if (getSharedPreferences(getString(2131297115), 4).getBoolean(CommonPreferences.Keys.apT.getKey(), false))
    {
      paramBundle = findPreference(getResources().getString(2131296394));
      if (paramBundle != null) {
        paramBundle.setEnabled(false);
      }
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    finish();
    return true;
  }
  
  protected void onPause()
  {
    super.onPause();
    getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
  }
  
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    int i = 1;
    boolean bool3 = true;
    boolean bool2 = true;
    CommonPreferences.PageSize localPageSize = CommonPreferences.PageSize.dk(CommonPreferences.Keys.apx.Dl());
    float f2 = CommonPreferences.Keys.apy.getFloatValue();
    float f6 = CommonPreferences.Keys.apz.getFloatValue();
    float f1 = CommonPreferences.Keys.apC.getFloatValue();
    float f5 = CommonPreferences.Keys.apD.getFloatValue();
    float f3 = CommonPreferences.Keys.apE.getFloatValue();
    float f4 = CommonPreferences.Keys.apF.getFloatValue();
    paramPreference = paramPreference.getKey();
    this.mLog.dl("onPreferenceChange: " + paramPreference);
    float f7;
    float f8;
    if (paramPreference.equals(CommonPreferences.Keys.apx.getKey()))
    {
      paramPreference = CommonPreferences.PageSize.dk((String)paramObject);
      f7 = f6;
      f8 = f4;
      f6 = f1;
      f4 = f3;
      f3 = f8;
      f1 = f7;
    }
    for (;;)
    {
      boolean bool1 = bool3;
      if (i != 0)
      {
        bool1 = bool3;
        if (paramPreference != CommonPreferences.PageSize.aui)
        {
          if (paramPreference != CommonPreferences.PageSize.auj)
          {
            f2 = paramPreference.getWidth();
            f1 = paramPreference.getHeight();
          }
          if (f5 + f6 >= f2)
          {
            Toast.makeText(this, OperationStatus.avW.Ds(), 0).show();
            bool2 = false;
          }
          bool1 = bool2;
          if (bool2)
          {
            bool1 = bool2;
            if (f3 + f4 >= f1)
            {
              Toast.makeText(this, OperationStatus.avX.Ds(), 0).show();
              bool1 = false;
            }
          }
        }
      }
      return bool1;
      if (paramPreference.equals(CommonPreferences.Keys.apy.getKey()))
      {
        f2 = ((Float)paramObject).floatValue();
        f7 = f3;
        f8 = f1;
        f1 = f6;
        f3 = f4;
        f4 = f7;
        f6 = f8;
        paramPreference = localPageSize;
      }
      else if (paramPreference.equals(CommonPreferences.Keys.apz.getKey()))
      {
        f8 = ((Float)paramObject).floatValue();
        f6 = f3;
        f7 = f1;
        f1 = f8;
        f3 = f4;
        f4 = f6;
        f6 = f7;
        paramPreference = localPageSize;
      }
      else if (paramPreference.equals(CommonPreferences.Keys.apC.getKey()))
      {
        f7 = ((Float)paramObject).floatValue();
        f1 = f6;
        f6 = f3;
        f3 = f4;
        f4 = f6;
        f6 = f7;
        paramPreference = localPageSize;
      }
      else if (paramPreference.equals(CommonPreferences.Keys.apD.getKey()))
      {
        f5 = ((Float)paramObject).floatValue();
        f7 = f3;
        f8 = f1;
        f1 = f6;
        f3 = f4;
        f4 = f7;
        f6 = f8;
        paramPreference = localPageSize;
      }
      else if (paramPreference.equals(CommonPreferences.Keys.apE.getKey()))
      {
        f7 = ((Float)paramObject).floatValue();
        f3 = f4;
        f4 = f7;
        f7 = f1;
        f1 = f6;
        f6 = f7;
        paramPreference = localPageSize;
      }
      else if (paramPreference.equals(CommonPreferences.Keys.apF.getKey()))
      {
        f4 = ((Float)paramObject).floatValue();
        f7 = f3;
        f8 = f1;
        f1 = f6;
        f3 = f4;
        f4 = f7;
        f6 = f8;
        paramPreference = localPageSize;
      }
      else
      {
        i = 0;
        if (paramPreference.equals(CommonPreferences.Keys.apV.getKey()))
        {
          SharedPreferences.Editor localEditor = getSharedPreferences(getString(2131297115), 4).edit();
          localEditor.putInt(paramPreference, Integer.parseInt((String)paramObject));
          localEditor.commit();
          d.an(this);
        }
        f7 = f3;
        f8 = f1;
        f1 = f6;
        f3 = f4;
        f4 = f7;
        f6 = f8;
        paramPreference = localPageSize;
      }
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    PreferenceScreen localPreferenceScreen = getPreferenceScreen();
    localPreferenceScreen.getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    HG();
    a(localPreferenceScreen);
    a(localPreferenceScreen);
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    this.mLog.dl("onSharedPreferenceChanged: " + paramString);
    Preference localPreference = findPreference(paramString);
    if (CommonPreferences.Keys.apx.getKey().equals(paramString)) {
      a(CommonPreferences.PageSize.dk(paramSharedPreferences.getString(paramString, "")));
    }
    for (;;)
    {
      b(localPreference);
      if ((CommonPreferences.Keys.apC.getKey().equals(paramString)) || (CommonPreferences.Keys.apD.getKey().equals(paramString)) || (CommonPreferences.Keys.apE.getKey().equals(paramString)) || (CommonPreferences.Keys.apF.getKey().equals(paramString))) {
        findPreference(CommonPreferences.Keys.apB.getKey()).setSummary(HH());
      }
      paramSharedPreferences = getPreferenceScreen().getRootAdapter();
      if ((paramSharedPreferences instanceof BaseAdapter)) {
        ((BaseAdapter)paramSharedPreferences).notifyDataSetChanged();
      }
      return;
      if (CommonPreferences.Keys.apw.getKey().equals(paramString)) {
        b(CommonPreferences.MeasurementUnits.de(paramSharedPreferences.getString(paramString, "")));
      }
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    if (CommonPreferences.Keys.apu.Dm()) {
      getWindow().clearFlags(1024);
    }
    for (;;)
    {
      l.e(this).a(this);
      return;
      getWindow().addFlags(1024);
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    l.e(this).b(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/SettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */