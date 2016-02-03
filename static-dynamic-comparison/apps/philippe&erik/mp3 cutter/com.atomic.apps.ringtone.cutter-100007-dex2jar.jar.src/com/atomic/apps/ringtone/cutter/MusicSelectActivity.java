package com.atomic.apps.ringtone.cutter;

import android.app.AlertDialog.Builder;
import android.app.ListActivity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MergeCursor;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Audio.Media;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.atomic.apps.ringtone.a.h;
import com.google.android.gms.ads.b;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.d;
import com.google.android.gms.ads.e;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MusicSelectActivity
  extends ListActivity
  implements TextWatcher
{
  private static final String[] f = { "_id", "_data", "title", "artist", "album", "is_ringtone", "is_alarm", "is_notification", "is_music", "\"" + MediaStore.Audio.Media.INTERNAL_CONTENT_URI + "\"" };
  private static final String[] g = { "_id", "_data", "title", "artist", "album", "is_ringtone", "is_alarm", "is_notification", "is_music", "\"" + MediaStore.Audio.Media.EXTERNAL_CONTENT_URI + "\"" };
  private TextView a;
  private SimpleCursorAdapter b;
  private boolean c;
  private boolean d;
  private e e;
  
  private Cursor a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if (this.d)
    {
      localObject1 = "(_DATA LIKE ?)";
      localArrayList.add("%");
      localObject2 = localObject1;
      if (paramString != null)
      {
        localObject2 = localObject1;
        if (paramString.length() > 0)
        {
          paramString = "%" + paramString + "%";
          localObject2 = "(" + (String)localObject1 + " AND ((TITLE LIKE ?) OR (ARTIST LIKE ?) OR (ALBUM LIKE ?)))";
          localArrayList.add(paramString);
          localArrayList.add(paramString);
          localArrayList.add(paramString);
        }
      }
      paramString = a((String)localObject2, localArrayList);
      localObject1 = (String[])localArrayList.toArray(new String[localArrayList.size()]);
      paramString = new p(this, new MergeCursor(new Cursor[] { getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, g, paramString, (String[])localObject1, "title_key"), getContentResolver().query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, f, paramString, (String[])localObject1, "title_key") }));
      startManagingCursor(paramString);
      return paramString;
    }
    Object localObject1 = "(";
    String[] arrayOfString = h.h();
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        localObject1 = localObject1 + ")";
        localObject1 = "(" + (String)localObject1 + ") AND (_DATA NOT LIKE ?)";
        localArrayList.add("%espeak-data/scratch%");
        break;
      }
      localObject2 = arrayOfString[i];
      localArrayList.add("%." + (String)localObject2);
      localObject2 = localObject1;
      if (((String)localObject1).length() > 1) {
        localObject2 = localObject1 + " OR ";
      }
      localObject1 = localObject2 + "(_DATA LIKE ?)";
      i += 1;
    }
  }
  
  private Uri a()
  {
    Cursor localCursor = this.b.getCursor();
    int j = localCursor.getColumnIndex("\"" + MediaStore.Audio.Media.INTERNAL_CONTENT_URI + "\"");
    int i = j;
    if (j == -1) {
      i = localCursor.getColumnIndex("\"" + MediaStore.Audio.Media.EXTERNAL_CONTENT_URI + "\"");
    }
    return Uri.parse(localCursor.getString(i) + "/" + localCursor.getString(localCursor.getColumnIndexOrThrow("_id")));
  }
  
  private void a(CharSequence paramCharSequence)
  {
    new AlertDialog.Builder(this).setTitle(getResources().getText(2130968665)).setMessage(paramCharSequence).setPositiveButton(2130968666, new o(this)).setCancelable(false).show();
  }
  
  private void b()
  {
    Object localObject = this.b.getCursor();
    localObject = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndexOrThrow("_data"));
    try
    {
      localObject = new Intent("android.intent.action.EDIT", Uri.parse((String)localObject));
      ((Intent)localObject).putExtra("was_get_content_intent", false);
      ((Intent)localObject).setClass(this, RingtoneEditActivity.class);
      startActivityForResult((Intent)localObject, 1);
      return;
    }
    catch (Exception localException)
    {
      Log.e("vimtec", "Couldn't start editor");
    }
  }
  
  private void c()
  {
    String str = this.a.getText().toString();
    stopManagingCursor(this.b.getCursor());
    this.b.changeCursor(a(str));
  }
  
  protected String a(String paramString, List paramList)
  {
    ((TextView)findViewById(2131099711)).setText("All Available Music");
    return paramString;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    c();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 1) {}
    while (paramInt2 != -1) {
      return;
    }
    setResult(-1, paramIntent);
    finish();
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    paramMenuItem.getMenuInfo();
    Object localObject;
    switch (paramMenuItem.getItemId())
    {
    case 7: 
    default: 
      return super.onContextItemSelected(paramMenuItem);
    case 4: 
      b();
      return true;
    case 5: 
      paramMenuItem = this.b.getCursor();
      paramMenuItem.getColumnIndexOrThrow("artist");
      if (paramMenuItem.getString(paramMenuItem.getColumnIndexOrThrow("artist")).equals(getResources().getText(2130968653)))
      {
        localObject = getResources().getText(2130968659);
        if (paramMenuItem.getInt(paramMenuItem.getColumnIndexOrThrow("is_ringtone")) == 0) {
          break label214;
        }
        paramMenuItem = getResources().getText(2130968654);
      }
      for (;;)
      {
        new AlertDialog.Builder(this).setTitle(paramMenuItem).setMessage((CharSequence)localObject).setPositiveButton(2130968661, new m(this)).setNegativeButton(2130968662, new n(this)).setCancelable(true).show();
        return true;
        localObject = getResources().getText(2130968660);
        break;
        if (paramMenuItem.getInt(paramMenuItem.getColumnIndexOrThrow("is_alarm")) != 0) {
          paramMenuItem = getResources().getText(2130968655);
        } else if (paramMenuItem.getInt(paramMenuItem.getColumnIndexOrThrow("is_notification")) != 0) {
          paramMenuItem = getResources().getText(2130968656);
        } else if (paramMenuItem.getInt(paramMenuItem.getColumnIndexOrThrow("is_music")) != 0) {
          paramMenuItem = getResources().getText(2130968657);
        } else {
          paramMenuItem = getResources().getText(2130968658);
        }
      }
    case 8: 
      label214:
      paramMenuItem = this.b.getCursor();
      paramMenuItem = Uri.fromFile(new File(paramMenuItem.getString(paramMenuItem.getColumnIndexOrThrow("_data"))));
      localObject = new Intent();
      ((Intent)localObject).setAction("android.intent.action.SEND");
      ((Intent)localObject).putExtra("android.intent.extra.STREAM", paramMenuItem);
      ((Intent)localObject).setType("audio/*");
      startActivity(Intent.createChooser((Intent)localObject, "Share Via..."));
      return true;
    }
    paramMenuItem = this.b.getCursor();
    if (paramMenuItem.getInt(paramMenuItem.getColumnIndexOrThrow("is_ringtone")) != 0)
    {
      RingtoneManager.setActualDefaultRingtoneUri(this, 1, a());
      Toast.makeText(this, 2130968670, 0).show();
    }
    for (;;)
    {
      return true;
      RingtoneManager.setActualDefaultRingtoneUri(this, 2, a());
      Toast.makeText(this, 2130968671, 0).show();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    this.d = false;
    paramBundle = Environment.getExternalStorageState();
    if (paramBundle.equals("mounted_ro")) {
      a(getResources().getText(2130968612));
    }
    for (;;)
    {
      return;
      if (paramBundle.equals("shared"))
      {
        a(getResources().getText(2130968614));
        return;
      }
      if (!paramBundle.equals("mounted"))
      {
        a(getResources().getText(2130968613));
        return;
      }
      getIntent();
      this.c = false;
      setContentView(2130903046);
      if (Build.VERSION.SDK_INT > 8)
      {
        paramBundle = (LinearLayout)findViewById(2131099675);
        paramBundle.setVisibility(8);
        this.e = new e(this);
        this.e.a("ca-app-pub-8029630852891329/2482807096");
        this.e.a(d.g);
        b localb = new c().b(b.a).a();
        this.e.a(new i(this, paramBundle));
        this.e.a(localb);
        paramBundle.addView(this.e);
      }
      try
      {
        this.b = new SimpleCursorAdapter(this, 2130903047, a(""), new String[] { "artist", "album", "title", "_id", "_id" }, new int[] { 2131099715, 2131099716, 2131099717, 2131099714, 2131099718 });
        setListAdapter(this.b);
        getListView().setItemsCanFocus(true);
        getListView().setDivider(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { -16759425, -1, -16759425 }));
        getListView().setDividerHeight(1);
        getListView().setOnItemClickListener(new j(this));
        this.b.setViewBinder(new k(this));
        registerForContextMenu(getListView());
        this.a = ((TextView)findViewById(2131099712));
        if (this.a == null) {
          continue;
        }
        this.a.addTextChangedListener(this);
        return;
      }
      catch (SecurityException paramBundle)
      {
        for (;;)
        {
          Log.e("vimtec", paramBundle.toString());
        }
      }
      catch (IllegalArgumentException paramBundle)
      {
        for (;;)
        {
          Log.e("vimtec", paramBundle.toString());
        }
      }
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramView = this.b.getCursor();
    paramContextMenu.setHeaderTitle(paramView.getString(paramView.getColumnIndexOrThrow("title")));
    paramContextMenu.add(0, 4, 0, 2130968640);
    paramContextMenu.add(0, 5, 0, 2130968641);
    paramContextMenu.add(0, 8, 0, "Share File...");
    if (paramView.getInt(paramView.getColumnIndexOrThrow("is_ringtone")) != 0) {
      paramContextMenu.add(0, 6, 0, 2130968642);
    }
    while (paramView.getInt(paramView.getColumnIndexOrThrow("is_notification")) == 0) {
      return;
    }
    paramContextMenu.add(0, 6, 0, 2130968643);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    super.onCreateOptionsMenu(paramMenu);
    paramMenu.add(0, 3, 0, 2130968639).setIcon(2130837556);
    return true;
  }
  
  public void onDestroy()
  {
    if (this.e != null) {
      this.e.a();
    }
    super.onDestroy();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    case 2: 
    default: 
      return false;
    case 1: 
      RingtoneEditActivity.a(this);
      return true;
    }
    this.d = true;
    c();
    return true;
  }
  
  public void onPause()
  {
    if (this.e != null) {
      this.e.b();
    }
    super.onPause();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    super.onPrepareOptionsMenu(paramMenu);
    paramMenu.findItem(3).setVisible(true);
    paramMenu = paramMenu.findItem(3);
    if (this.d) {}
    for (boolean bool = false;; bool = true)
    {
      paramMenu.setEnabled(bool);
      return true;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.e != null) {
      this.e.c();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/cutter/MusicSelectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */