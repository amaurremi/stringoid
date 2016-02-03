package mobi.beyondpod.ui.dialogs;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;

public class WidgetPreferences
  extends Activity
{
  int _AppWidgetId;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setResult(0);
    setContentView(2130903177);
    paramBundle = getIntent().getExtras();
    if (paramBundle != null) {
      this._AppWidgetId = paramBundle.getInt("appWidgetId", 0);
    }
    if (this._AppWidgetId == 0) {
      finish();
    }
    paramBundle = (ListView)findViewById(2131231227);
    paramBundle.setAdapter(new ArrayAdapter(this, 2130903176, 2131231229, getResources().getStringArray(2131623994)));
    paramBundle.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          BeyondPodApplication.GetInstance().RefreshWidgets();
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("appWidgetId", WidgetPreferences.this._AppWidgetId);
          WidgetPreferences.this.setResult(-1, paramAnonymousAdapterView);
          WidgetPreferences.this.finish();
          return;
          Configuration.setWidgetBackgroundColor(1);
          continue;
          Configuration.setWidgetBackgroundColor(2);
          continue;
          Configuration.setWidgetBackgroundColor(3);
        }
      }
    });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/WidgetPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */