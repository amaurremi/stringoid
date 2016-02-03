package com.venticake.retrica;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.GridView;
import com.venticake.retrica.util.UserInterfaceUtil;
import com.venticake.retrica.view.album.QuickViewActivity;

public class AlbumActivity
  extends c
{
  private Activity o;
  private GridView p;
  private a q;
  
  private int n()
  {
    return g.a();
  }
  
  public FrameLayout i()
  {
    return (FrameLayout)findViewById(2131296335);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (shouldDisplayAd())
    {
      if (paramConfiguration.orientation != 2) {
        break label32;
      }
      com.venticake.a.a.a().b(this, i());
    }
    label32:
    while (paramConfiguration.orientation != 1) {
      return;
    }
    com.venticake.a.a.a().b(this, i());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.o = this;
    getWindow().setFlags(1024, 1024);
    setContentView(2130903064);
    paramBundle = f();
    paramBundle.a(true);
    paramBundle.a(2130837931);
    this.p = ((GridView)findViewById(2131296334));
    this.q = new a(this);
    this.p.setColumnWidth(UserInterfaceUtil.dp2px(n(), this.p));
    this.p.setAdapter(this.q);
    this.p.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = Uri.fromFile(AlbumActivity.a(AlbumActivity.this).a[paramAnonymousInt]);
        Log.d("retrica", "Y: " + AlbumActivity.b(AlbumActivity.this).getScrollY());
        paramAnonymousView = new Intent(AlbumActivity.c(AlbumActivity.this), QuickViewActivity.class);
        paramAnonymousView.putExtra("From", "QuickView from album");
        paramAnonymousView.putExtra("DisplayAd", false);
        paramAnonymousView.putExtra("URI", paramAnonymousAdapterView.toString());
        paramAnonymousView.putExtra("Position", paramAnonymousInt);
        AlbumActivity.c(AlbumActivity.this).startActivity(paramAnonymousView);
      }
    });
    if (shouldDisplayAd()) {
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          com.venticake.a.a.a().a(jdField_this, AlbumActivity.this.i());
        }
      }, 100L);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623936, paramMenu);
    return true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (shouldDisplayAd()) {
      com.venticake.a.a.a().b(this);
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    paramMenuItem.getItemId();
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onPause()
  {
    super.onPause();
    Log.d("spad", "onPause - (shouldDisplayAd: " + shouldDisplayAd());
  }
  
  public void onResume()
  {
    super.onResume();
    Log.d("spad", "onResume - (shouldDisplayAd: " + shouldDisplayAd());
    this.q.a();
    this.q.notifyDataSetChanged();
    this.p.invalidateViews();
  }
  
  public boolean shouldDisplayAd()
  {
    return !com.venticake.retrica.setting.a.a().u();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/AlbumActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */