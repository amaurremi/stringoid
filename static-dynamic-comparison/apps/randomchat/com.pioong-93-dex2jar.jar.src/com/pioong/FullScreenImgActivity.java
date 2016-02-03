package com.pioong;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.pioong.customview.MyProgressDialog;
import com.pioong.imagecache.ImageLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;

public class FullScreenImgActivity
  extends Activity
{
  ImageLoader imgLoader;
  ImageView iv;
  MediaScannerConnection msConn;
  MyProgressDialog progDialog;
  String url;
  
  public String fromInt(int paramInt)
  {
    return String.valueOf(paramInt);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903041);
    this.url = getIntent().getStringExtra("url");
    this.imgLoader = new ImageLoader(this);
    paramBundle = (ProgressBar)findViewById(2131296268);
    this.iv = ((ImageView)findViewById(2131296267));
    this.imgLoader.DisplayImage(this.url, this.iv, paramBundle);
    ((LinearLayout)findViewById(2131296269)).setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    ((Button)findViewById(2131296270)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        FullScreenImgActivity.this.saveImage(paramAnonymousView);
      }
    });
  }
  
  public void saveImage(View paramView)
  {
    this.progDialog = MyProgressDialog.show(this, "", "", true, true, null);
    paramView = this.imgLoader.getImage(this.url);
    File localFile = new File(Environment.getExternalStorageDirectory(), getString(2131034114));
    localFile.mkdir();
    Object localObject = Calendar.getInstance();
    localObject = fromInt(((Calendar)localObject).get(2)) + fromInt(((Calendar)localObject).get(5)) + fromInt(((Calendar)localObject).get(1)) + fromInt(((Calendar)localObject).get(11)) + fromInt(((Calendar)localObject).get(12)) + fromInt(((Calendar)localObject).get(13));
    localFile = new File(localFile, "rc_" + ((String)localObject).toString() + ".jpg");
    try
    {
      localObject = new FileOutputStream(localFile);
      if (this.progDialog == null) {
        break label229;
      }
    }
    catch (Exception paramView)
    {
      try
      {
        paramView.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
        ((FileOutputStream)localObject).flush();
        ((FileOutputStream)localObject).close();
        scanPhoto(localFile.toString());
        return;
      }
      catch (Exception paramView)
      {
        for (;;) {}
      }
      paramView = paramView;
    }
    this.progDialog.dismiss();
    this.progDialog = null;
    label229:
    Toast.makeText(this, getString(2131034121), 0).show();
  }
  
  public void scanPhoto(final String paramString)
  {
    this.msConn = new MediaScannerConnection(this, new MediaScannerConnection.MediaScannerConnectionClient()
    {
      public void onMediaScannerConnected()
      {
        try
        {
          FullScreenImgActivity.this.msConn.scanFile(paramString, null);
          return;
        }
        catch (IllegalStateException localIllegalStateException) {}
      }
      
      public void onScanCompleted(String paramAnonymousString, Uri paramAnonymousUri)
      {
        FullScreenImgActivity.this.msConn.disconnect();
        FullScreenImgActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            if (FullScreenImgActivity.this.progDialog != null) {}
            try
            {
              FullScreenImgActivity.this.progDialog.dismiss();
              FullScreenImgActivity.this.progDialog = null;
              Toast.makeText(FullScreenImgActivity.this, FullScreenImgActivity.this.getString(2131034120), 0).show();
              return;
            }
            catch (Exception localException)
            {
              for (;;) {}
            }
          }
        });
      }
    });
    this.msConn.connect();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/FullScreenImgActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */