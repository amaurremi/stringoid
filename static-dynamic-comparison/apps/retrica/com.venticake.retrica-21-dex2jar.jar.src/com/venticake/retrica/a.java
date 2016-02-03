package com.venticake.retrica;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.venticake.retrica.util.UserInterfaceUtil;
import java.io.File;
import java.util.HashMap;

public class a
  extends BaseAdapter
{
  public File[] a;
  private Activity b;
  private int c;
  private SQLiteOpenHelper d;
  private g e;
  private Handler f;
  private HashMap<ImageView, b> g;
  
  public a(Activity paramActivity)
  {
    this.b = paramActivity;
    try
    {
      this.a = g.a(true, this.b);
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      this.b.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      this.c = (localDisplayMetrics.widthPixels / 3);
      if (this.c < 50) {
        this.c = 50;
      }
      this.d = new SQLiteOpenHelper(paramActivity, "RETRICA_THUMBNAIL.sqlite", null, 1)
      {
        public void onCreate(SQLiteDatabase paramAnonymousSQLiteDatabase)
        {
          try
          {
            paramAnonymousSQLiteDatabase.execSQL("CREATE TABLE THUMBNAIL (uri TEXT, thumbnail_image BLOB);");
            return;
          }
          catch (Exception paramAnonymousSQLiteDatabase)
          {
            Log.d("retrica", "DB " + paramAnonymousSQLiteDatabase.getMessage());
          }
        }
        
        public void onUpgrade(SQLiteDatabase paramAnonymousSQLiteDatabase, int paramAnonymousInt1, int paramAnonymousInt2) {}
      };
      this.e = new g(paramActivity);
      paramActivity = new HandlerThread("mm");
      paramActivity.start();
      this.f = new Handler(paramActivity.getLooper());
      this.g = new HashMap();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        this.a = null;
      }
    }
  }
  
  private File a(int paramInt)
  {
    if ((this.a == null) || (paramInt >= this.a.length)) {
      return null;
    }
    return this.a[paramInt];
  }
  
  private int b()
  {
    return g.a();
  }
  
  public void a()
  {
    try
    {
      this.a = g.a(true, this.b);
      Log.d("retrica", "refreshData: " + this.a.length + " files");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a = null;
      Log.d("retrica", "refreshData: No files");
    }
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.length;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new ImageView(this.b);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, UserInterfaceUtil.dp2px(b(), paramView)));
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      int i = UserInterfaceUtil.dp2px(4.0F, paramView);
      paramView.setPadding(0, i, 0, i);
    }
    for (;;)
    {
      UserInterfaceUtil.setImageViewAlpha(paramView, 0, false);
      paramView.setImageResource(17170445);
      paramViewGroup = a(paramInt);
      if (paramViewGroup != null) {
        break;
      }
      return paramView;
      paramView = (ImageView)paramView;
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, UserInterfaceUtil.dp2px(b(), paramView)));
    }
    Uri localUri = Uri.fromFile(paramViewGroup);
    this.f.post(new b(this, paramView, paramViewGroup, localUri));
    return paramView;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */