package com.troll.face;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import com.appfireworks.android.track.AppTracker;
import com.jtpgodorncrqoeurl.AdController;
import com.troll.adapter.LazyFileAdapterPhoto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MyGalleryActivity
  extends Activity
{
  private AdController ad;
  LazyFileAdapterPhoto adapter;
  private AdController audioAd;
  DBAdapter db;
  GridView list;
  private Vector<ImageView> mySDCardImages;
  private ArrayList<String> mySDCardImagesAbsolutePath = new ArrayList();
  
  private Bitmap decodeFile(File paramFile)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeStream(new FileInputStream(paramFile), null, localOptions);
      int k = localOptions.outWidth;
      int j = localOptions.outHeight;
      int i = 1;
      for (;;)
      {
        if ((k / 2 < 70) || (j / 2 < 70))
        {
          localOptions = new BitmapFactory.Options();
          localOptions.inSampleSize = i;
          return BitmapFactory.decodeStream(new FileInputStream(paramFile), null, localOptions);
        }
        k /= 2;
        j /= 2;
        i *= 2;
      }
      return null;
    }
    catch (FileNotFoundException paramFile) {}
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2130903049);
    getWindow().setFeatureInt(7, 2130903051);
    this.ad = new AdController(this, "620641523");
    this.ad.loadAd();
    this.audioAd = new AdController(this, "734590306");
    this.audioAd.resumeAd();
    this.audioAd.loadAudioAd();
    if (Environment.getExternalStorageState().equalsIgnoreCase("MOUNTED")) {
      this.db = new DBAdapter(this);
    }
    if (Environment.getExternalStorageState().equalsIgnoreCase("MOUNTED")) {
      if (this.db.getMessage("Commented").getCount() == 0)
      {
        paramBundle = new AlertDialog.Builder(this);
        paramBundle.setTitle("Thank You");
        paramBundle.setMessage("If you like this app , leave a comment.");
        paramBundle.setPositiveButton("Ok", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            MyGalleryActivity.this.db.insertMessage("1", "Commented");
            paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.troll.face"));
            MyGalleryActivity.this.startActivity(paramAnonymousDialogInterface);
          }
        });
        paramBundle.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            MyGalleryActivity.this.db.insertMessage("1", "Commented");
          }
        });
        paramBundle.setNeutralButton("Later", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        paramBundle.show();
      }
    }
    for (;;)
    {
      ((MyApp)getApplication()).setAddFlag(true);
      return;
      paramBundle = new AlertDialog.Builder(this);
      paramBundle.setTitle("Thank You");
      paramBundle.setMessage("If you like this app , please support us and leave a comment.");
      paramBundle.setPositiveButton("Ok", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.troll.face"));
          MyGalleryActivity.this.startActivity(paramAnonymousDialogInterface);
        }
      });
      paramBundle.setNegativeButton("No", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      paramBundle.setNeutralButton("Later", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      paramBundle.show();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.ad != null) {
      this.ad.destroyAd();
    }
    if (this.audioAd != null)
    {
      this.audioAd.pauseAd();
      this.audioAd.destroyAd();
    }
    AppTracker.closeSession(getApplicationContext(), true);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.ad != null) {
      this.ad.destroyAd();
    }
    if (this.audioAd != null)
    {
      this.audioAd.pauseAd();
      this.audioAd.destroyAd();
    }
    if (!isFinishing()) {
      AppTracker.pause(getApplicationContext());
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.audioAd == null) {
      this.audioAd = new AdController(this, "734590306");
    }
    this.audioAd.loadAudioTrack(1L);
    AppTracker.resume(getApplicationContext());
    System.gc();
    this.mySDCardImagesAbsolutePath = new ArrayList();
    this.list = ((GridView)findViewById(2131165223));
    this.mySDCardImages = new Vector();
    ArrayList localArrayList = new ArrayList();
    int j = 12345;
    File[] arrayOfFile = new File("/sdcard/TrollFace").listFiles();
    new BitmapFactory.Options().inSampleSize = 5;
    if (arrayOfFile != null)
    {
      int m = arrayOfFile.length;
      int i = 0;
      for (;;)
      {
        if (i >= m)
        {
          this.adapter = new LazyFileAdapterPhoto(this, this, this.mySDCardImages);
          this.list.setAdapter(this.adapter);
          this.list.setOnItemClickListener(new AdapterView.OnItemClickListener()
          {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              MyGalleryActivity.this.getPackageName();
              paramAnonymousAdapterView = (MyApp)MyGalleryActivity.this.getApplication();
              paramAnonymousAdapterView.setMySDCardSingleImagesAbsolutePath((String)MyGalleryActivity.this.mySDCardImagesAbsolutePath.get(paramAnonymousInt));
              paramAnonymousAdapterView.setMySDCardImagesAbsolutePath(MyGalleryActivity.this.mySDCardImagesAbsolutePath);
              paramAnonymousAdapterView.setPosition(paramAnonymousInt);
              paramAnonymousAdapterView = new Intent(MyGalleryActivity.this, MyGalleryShowImage.class);
              MyGalleryActivity.this.startActivity(paramAnonymousAdapterView);
            }
          });
          return;
        }
        File localFile = arrayOfFile[i];
        System.gc();
        int k = j;
        if (!localFile.getAbsolutePath().contains("/TrolFaceImage.jpg"))
        {
          Object localObject = decodeFile(localFile);
          localObject = new BitmapDrawable(getResources(), (Bitmap)localObject);
          ImageView localImageView = new ImageView(getBaseContext());
          localImageView.setImageDrawable((Drawable)localObject);
          localImageView.setId(j);
          k = j + 1;
          localArrayList.add(Integer.valueOf(localImageView.getId()));
          this.mySDCardImages.add(localImageView);
          this.mySDCardImagesAbsolutePath.add(localFile.getAbsolutePath());
        }
        i += 1;
        j = k;
      }
    }
    Toast.makeText(this, "No Picture Saved", 0).show();
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.ad != null) {
      this.ad.destroyAd();
    }
    if (this.audioAd != null)
    {
      this.audioAd.pauseAd();
      this.audioAd.destroyAd();
    }
    if (!isFinishing()) {
      AppTracker.pause(getApplicationContext());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/troll/face/MyGalleryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */