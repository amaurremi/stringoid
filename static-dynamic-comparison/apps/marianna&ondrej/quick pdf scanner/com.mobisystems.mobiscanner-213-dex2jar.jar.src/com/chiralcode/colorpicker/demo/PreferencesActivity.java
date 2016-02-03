package com.chiralcode.colorpicker.demo;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import com.mobisystems.pdf.simpleViewer.R.layout;

public class PreferencesActivity
  extends PreferenceActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    addPreferencesFromResource(R.layout.act_pref);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/chiralcode/colorpicker/demo/PreferencesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */