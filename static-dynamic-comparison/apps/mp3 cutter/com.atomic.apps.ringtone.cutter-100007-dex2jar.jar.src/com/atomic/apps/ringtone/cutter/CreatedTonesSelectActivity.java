package com.atomic.apps.ringtone.cutter;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;

public class CreatedTonesSelectActivity
  extends MusicSelectActivity
{
  protected final String a(String paramString, List paramList)
  {
    TextView localTextView = new TextView(this);
    localTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    localTextView.setText("You have not yet edited and saved any ringtone using this app. Ringtones will be listed here when you edit and save ringtone using this app.");
    localTextView.setVisibility(8);
    ((ViewGroup)getListView().getParent()).addView(localTextView);
    getListView().setEmptyView(localTextView);
    paramString = "(" + paramString + " AND (ARTIST = ?) )";
    paramList.add(getResources().getText(2130968653).toString());
    ((TextView)findViewById(2131099711)).setText("Saved Ringtones");
    return paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/cutter/CreatedTonesSelectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */