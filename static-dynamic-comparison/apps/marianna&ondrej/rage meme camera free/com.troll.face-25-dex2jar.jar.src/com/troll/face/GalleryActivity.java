package com.troll.face;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.text.Editable;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.appfireworks.android.track.AppTracker;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.jtpgodorncrqoeurl.AdController;
import com.troll.canvas.ImageObject;
import com.troll.canvas.TouchManager;
import com.troll.canvas.Vector2D;
import com.troll.listtroll.LazyAdapterSearch;
import com.troll.listtroll.TeamItem;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class GalleryActivity
  extends Activity
  implements View.OnTouchListener
{
  private static final int CROP_FROM_CAMERA = 4;
  private static final float INCREMENT_COLOR = 1.0F;
  private static final int MAX_NUMBER_TROLL = 20;
  private static final int PICK_FROM_CAMERA = 1;
  private static final int PICK_FROM_FILE = 3;
  private static final int SHARE = 2;
  AbsoluteLayout aLayout;
  private AdController adFloat;
  private AdController adInter;
  LazyAdapterSearch adapterGallery;
  private View.OnClickListener addListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (GalleryActivity.this.numberTroll < 20)
      {
        paramAnonymousView = GalleryActivity.this;
        paramAnonymousView.numberTroll += 1;
        paramAnonymousView = (ImageView)GalleryActivity.this.findViewById(2131165208);
        paramAnonymousView.setImageResource(2130837694);
        paramAnonymousView.setVisibility(0);
        ((LinearLayout)GalleryActivity.this.findViewById(2131165207)).setVisibility(0);
        GalleryActivity.this.addflag = 1;
        GalleryActivity.this.palletflag = 0;
        GalleryActivity.this.aLayout = ((AbsoluteLayout)GalleryActivity.this.findViewById(2131165184));
        GalleryActivity.this.img = new ImageView(GalleryActivity.this);
        GalleryActivity.this.img.setOnTouchListener(GalleryActivity.this.ontuchlist);
        GalleryActivity.this.img.setScaleType(ImageView.ScaleType.MATRIX);
        paramAnonymousView = BitmapFactory.decodeResource(GalleryActivity.this.getResources(), 2130837504);
        Object localObject = Bitmap.createBitmap(paramAnonymousView, 0, 0, paramAnonymousView.getWidth(), paramAnonymousView.getHeight());
        GalleryActivity.this.img.setImageBitmap((Bitmap)localObject);
        localObject = GalleryActivity.this.getWindowManager().getDefaultDisplay();
        GalleryActivity.this.img.setTag(Integer.valueOf(GalleryActivity.this.countImage));
        localObject = new AbsoluteLayout.LayoutParams(paramAnonymousView.getWidth(), paramAnonymousView.getHeight(), ((Display)localObject).getWidth() / 2 - 200, ((Display)localObject).getHeight() / 2 - 180);
        GalleryActivity.this.img.setLayoutParams((ViewGroup.LayoutParams)localObject);
        GalleryActivity.this.aLayout.addView(GalleryActivity.this.img);
        GalleryActivity.this.bitmap = paramAnonymousView;
        GalleryActivity.this.img.setBackgroundResource(2130837681);
        if (GalleryActivity.this.lastselected != null) {
          GalleryActivity.this.lastselected.setBackgroundResource(0);
        }
        GalleryActivity.this.lastselected = GalleryActivity.this.img;
        localObject = new ImageObject();
        ((ImageObject)localObject).setHeight(paramAnonymousView.getHeight());
        ((ImageObject)localObject).setWidth(paramAnonymousView.getWidth());
        ((ImageObject)localObject).setBitmap(paramAnonymousView);
        ((ImageObject)localObject).setScale(1.0F);
        ((ImageObject)localObject).setAngle(0.0F);
        ((ImageObject)localObject).setDb(0.0F);
        ((ImageObject)localObject).setDg(0.0F);
        ((ImageObject)localObject).setDr(0.0F);
        ((ImageObject)localObject).setX(GalleryActivity.this.aLayout.getWidth() / 2 - 200);
        ((ImageObject)localObject).setY(GalleryActivity.this.aLayout.getHeight() / 2 - 180);
        ((ImageObject)localObject).setDrawableImageId(Integer.valueOf(2130837504));
        GalleryActivity.this.imageObjectArray.add(localObject);
        paramAnonymousView = GalleryActivity.this;
        paramAnonymousView.countImage += 1;
        ((Gallery)GalleryActivity.this.findViewById(2131165209)).setVisibility(0);
        GalleryActivity.this.selectedImageFlag = 1;
        return;
      }
      paramAnonymousView = new AlertDialog.Builder(GalleryActivity.this).create();
      paramAnonymousView.setTitle("Please calm down");
      paramAnonymousView.setMessage("You can't add more meme");
      paramAnonymousView.setButton("OK", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
      });
      paramAnonymousView.setIcon(2130837691);
      paramAnonymousView.show();
    }
  };
  int addflag = 0;
  int allowUnalloFlag = 0;
  private Bitmap bitmap;
  Bitmap bitmapImage;
  private View.OnClickListener blueListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      int i;
      float f1;
      int j;
      int k;
      float f4;
      Object localObject2;
      Object localObject1;
      Object localObject3;
      int n;
      if (GalleryActivity.this.selectedImageFlag == 1)
      {
        i = new Integer(GalleryActivity.this.img.getTag().toString()).intValue();
        paramAnonymousView = (ImageObject)GalleryActivity.this.imageObjectArray.get(i);
        GalleryActivity.this.aLayout = ((AbsoluteLayout)GalleryActivity.this.findViewById(2131165184));
        GalleryActivity.this.img.setOnTouchListener(GalleryActivity.this.ontuchlist);
        GalleryActivity.this.img.setScaleType(ImageView.ScaleType.MATRIX);
        f1 = paramAnonymousView.getScale();
        paramAnonymousView.getAngle();
        j = paramAnonymousView.getWidth();
        k = paramAnonymousView.getHeight();
        float f2 = paramAnonymousView.getDr();
        float f3 = paramAnonymousView.getDg();
        f4 = paramAnonymousView.getDb() + 1.0F;
        localObject2 = new ColorMatrix();
        ((ColorMatrix)localObject2).setSaturation(0.0F);
        ((ColorMatrix)localObject2).set(new float[] { 0.0F, f2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f4, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
        localObject1 = BitmapFactory.decodeResource(GalleryActivity.this.getResources(), paramAnonymousView.getDrawableImageId().intValue());
        localObject3 = new ColorMatrixColorFilter((ColorMatrix)localObject2);
        localObject2 = new Paint();
        ((Paint)localObject2).setColorFilter((ColorFilter)localObject3);
        int m = paramAnonymousView.getFlipFlag();
        n = paramAnonymousView.getFlipVerticalFlag();
        localObject3 = new Matrix();
        if ((m != 0) && (m != 3)) {
          break label493;
        }
        if ((n != 3) && (n != 0)) {
          break label481;
        }
        ((Matrix)localObject3).preScale(1.0F, 1.0F);
      }
      for (;;)
      {
        localObject1 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), (Matrix)localObject3, true).copy(Bitmap.Config.ARGB_8888, true);
        GalleryActivity.this.img.setImageBitmap((Bitmap)localObject1);
        new Canvas((Bitmap)localObject1).drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, (Paint)localObject2);
        localObject1 = new AbsoluteLayout.LayoutParams((int)(j * f1), (int)(k * f1), paramAnonymousView.getX(), paramAnonymousView.getY());
        GalleryActivity.this.img.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramAnonymousView.setDb(f4);
        GalleryActivity.this.imageObjectArray.set(i, paramAnonymousView);
        return;
        label481:
        ((Matrix)localObject3).preScale(1.0F, -1.0F);
        continue;
        label493:
        if ((n == 3) || (n == 0)) {
          ((Matrix)localObject3).preScale(-1.0F, 1.0F);
        } else {
          ((Matrix)localObject3).preScale(-1.0F, -1.0F);
        }
      }
    }
  };
  LayoutInflater controlInflater = null;
  private int countImage = 0;
  DBAdapter db;
  private View.OnClickListener flipListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      Toast.makeText(GalleryActivity.this.getApplicationContext(), "Flip Troll", 0).show();
      int i;
      Object localObject1;
      float f1;
      int j;
      int k;
      Object localObject2;
      int n;
      Matrix localMatrix;
      if (GalleryActivity.this.selectedImageFlag == 1)
      {
        i = new Integer(GalleryActivity.this.img.getTag().toString()).intValue();
        paramAnonymousView = (ImageObject)GalleryActivity.this.imageObjectArray.get(i);
        GalleryActivity.this.aLayout = ((AbsoluteLayout)GalleryActivity.this.findViewById(2131165184));
        GalleryActivity.this.img.setOnTouchListener(GalleryActivity.this.ontuchlist);
        GalleryActivity.this.img.setScaleType(ImageView.ScaleType.MATRIX);
        localObject1 = new Paint();
        f1 = paramAnonymousView.getScale();
        paramAnonymousView.getAngle();
        j = paramAnonymousView.getWidth();
        k = paramAnonymousView.getHeight();
        float f2 = paramAnonymousView.getDr();
        float f3 = paramAnonymousView.getDg();
        float f4 = paramAnonymousView.getDb();
        if ((f2 != 0.0F) || (f3 != 0.0F) || (f4 != 0.0F))
        {
          localObject2 = new ColorMatrix();
          ((ColorMatrix)localObject2).setSaturation(0.0F);
          ((ColorMatrix)localObject2).set(new float[] { 0.0F, f2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f4, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
          ((Paint)localObject1).setColorFilter(new ColorMatrixColorFilter((ColorMatrix)localObject2));
        }
        localObject2 = BitmapFactory.decodeResource(GalleryActivity.this.getResources(), paramAnonymousView.getDrawableImageId().intValue());
        int m = paramAnonymousView.getFlipFlag();
        n = paramAnonymousView.getFlipVerticalFlag();
        localMatrix = new Matrix();
        if ((m != 0) && (m != 3)) {
          break label524;
        }
        paramAnonymousView.setFlipFlag(1);
        if ((n != 3) && (n != 0)) {
          break label511;
        }
        localMatrix.preScale(-1.0F, 1.0F);
      }
      for (;;)
      {
        localObject2 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), localMatrix, true).copy(Bitmap.Config.ARGB_8888, true);
        GalleryActivity.this.img.setImageBitmap((Bitmap)localObject2);
        new Canvas((Bitmap)localObject2).drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, (Paint)localObject1);
        localObject1 = new AbsoluteLayout.LayoutParams((int)(j * f1), (int)(k * f1), paramAnonymousView.getX(), paramAnonymousView.getY());
        GalleryActivity.this.img.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        GalleryActivity.this.imageObjectArray.set(i, paramAnonymousView);
        return;
        label511:
        localMatrix.preScale(-1.0F, -1.0F);
        continue;
        label524:
        paramAnonymousView.setFlipFlag(0);
        if ((n == 3) || (n == 0)) {
          localMatrix.preScale(1.0F, 1.0F);
        } else {
          localMatrix.preScale(1.0F, -1.0F);
        }
      }
    }
  };
  private View.OnClickListener flipListenerVertical = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      Toast.makeText(GalleryActivity.this.getApplicationContext(), "Flip Troll", 0).show();
      int i;
      Object localObject1;
      float f1;
      int j;
      int k;
      Object localObject2;
      int n;
      Matrix localMatrix;
      if (GalleryActivity.this.selectedImageFlag == 1)
      {
        i = new Integer(GalleryActivity.this.img.getTag().toString()).intValue();
        paramAnonymousView = (ImageObject)GalleryActivity.this.imageObjectArray.get(i);
        GalleryActivity.this.aLayout = ((AbsoluteLayout)GalleryActivity.this.findViewById(2131165184));
        GalleryActivity.this.img.setOnTouchListener(GalleryActivity.this.ontuchlist);
        GalleryActivity.this.img.setScaleType(ImageView.ScaleType.MATRIX);
        localObject1 = new Paint();
        f1 = paramAnonymousView.getScale();
        paramAnonymousView.getAngle();
        j = paramAnonymousView.getWidth();
        k = paramAnonymousView.getHeight();
        float f2 = paramAnonymousView.getDr();
        float f3 = paramAnonymousView.getDg();
        float f4 = paramAnonymousView.getDb();
        if ((f2 != 0.0F) || (f3 != 0.0F) || (f4 != 0.0F))
        {
          localObject2 = new ColorMatrix();
          ((ColorMatrix)localObject2).setSaturation(0.0F);
          ((ColorMatrix)localObject2).set(new float[] { 0.0F, f2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f4, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
          ((Paint)localObject1).setColorFilter(new ColorMatrixColorFilter((ColorMatrix)localObject2));
        }
        localObject2 = BitmapFactory.decodeResource(GalleryActivity.this.getResources(), paramAnonymousView.getDrawableImageId().intValue());
        int m = paramAnonymousView.getFlipFlag();
        n = paramAnonymousView.getFlipVerticalFlag();
        localMatrix = new Matrix();
        if ((m != 0) && (m != 3)) {
          break label527;
        }
        if ((n != 3) && (n != 0)) {
          break label511;
        }
        paramAnonymousView.setFlipVerticalFlag(1);
        localMatrix.preScale(1.0F, -1.0F);
      }
      for (;;)
      {
        localObject2 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), localMatrix, true).copy(Bitmap.Config.ARGB_8888, true);
        GalleryActivity.this.img.setImageBitmap((Bitmap)localObject2);
        new Canvas((Bitmap)localObject2).drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, (Paint)localObject1);
        localObject1 = new AbsoluteLayout.LayoutParams((int)(j * f1), (int)(k * f1), paramAnonymousView.getX(), paramAnonymousView.getY());
        GalleryActivity.this.img.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        GalleryActivity.this.imageObjectArray.set(i, paramAnonymousView);
        return;
        label511:
        paramAnonymousView.setFlipVerticalFlag(0);
        localMatrix.preScale(1.0F, 1.0F);
        continue;
        label527:
        if ((n == 3) || (n == 0))
        {
          paramAnonymousView.setFlipVerticalFlag(1);
          localMatrix.preScale(-1.0F, -1.0F);
        }
        else
        {
          paramAnonymousView.setFlipVerticalFlag(0);
          localMatrix.preScale(-1.0F, 1.0F);
        }
      }
    }
  };
  private View.OnClickListener greenListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      int i;
      float f1;
      int j;
      int k;
      float f3;
      Object localObject1;
      Object localObject2;
      int n;
      Matrix localMatrix;
      if (GalleryActivity.this.selectedImageFlag == 1)
      {
        i = new Integer(GalleryActivity.this.img.getTag().toString()).intValue();
        paramAnonymousView = (ImageObject)GalleryActivity.this.imageObjectArray.get(i);
        GalleryActivity.this.aLayout = ((AbsoluteLayout)GalleryActivity.this.findViewById(2131165184));
        GalleryActivity.this.img.setOnTouchListener(GalleryActivity.this.ontuchlist);
        GalleryActivity.this.img.setScaleType(ImageView.ScaleType.MATRIX);
        f1 = paramAnonymousView.getScale();
        paramAnonymousView.getAngle();
        j = paramAnonymousView.getWidth();
        k = paramAnonymousView.getHeight();
        float f2 = paramAnonymousView.getDr();
        f3 = paramAnonymousView.getDg() + 1.0F;
        float f4 = paramAnonymousView.getDb();
        localObject1 = new ColorMatrix();
        ((ColorMatrix)localObject1).setSaturation(0.0F);
        ((ColorMatrix)localObject1).set(new float[] { 0.0F, f2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f4, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
        localObject2 = new ColorMatrixColorFilter((ColorMatrix)localObject1);
        localObject1 = new Paint();
        ((Paint)localObject1).setColorFilter((ColorFilter)localObject2);
        localObject2 = BitmapFactory.decodeResource(GalleryActivity.this.getResources(), paramAnonymousView.getDrawableImageId().intValue());
        int m = paramAnonymousView.getFlipFlag();
        n = paramAnonymousView.getFlipVerticalFlag();
        localMatrix = new Matrix();
        if ((m != 0) && (m != 3)) {
          break label493;
        }
        if ((n != 3) && (n != 0)) {
          break label481;
        }
        localMatrix.preScale(1.0F, 1.0F);
      }
      for (;;)
      {
        localObject2 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), localMatrix, true).copy(Bitmap.Config.ARGB_8888, true);
        GalleryActivity.this.img.setImageBitmap((Bitmap)localObject2);
        new Canvas((Bitmap)localObject2).drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, (Paint)localObject1);
        localObject1 = new AbsoluteLayout.LayoutParams((int)(j * f1), (int)(k * f1), paramAnonymousView.getX(), paramAnonymousView.getY());
        GalleryActivity.this.img.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramAnonymousView.setDg(f3);
        GalleryActivity.this.imageObjectArray.set(i, paramAnonymousView);
        return;
        label481:
        localMatrix.preScale(1.0F, -1.0F);
        continue;
        label493:
        if ((n == 3) || (n == 0)) {
          localMatrix.preScale(-1.0F, 1.0F);
        } else {
          localMatrix.preScale(-1.0F, -1.0F);
        }
      }
    }
  };
  int iamageSizeHeight = 250;
  int iamageSizeWidth = 250;
  ArrayList<ImageObject> imageObjectArray = new ArrayList();
  ImageView img;
  private boolean isInitialized = false;
  private AdapterView.OnItemClickListener itemGalleryClick = new AdapterView.OnItemClickListener()
  {
    public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      if (paramAnonymousInt >= 65)
      {
        paramAnonymousAdapterView = new AlertDialog.Builder(GalleryActivity.this);
        paramAnonymousAdapterView.setTitle("Buy Complete version");
        paramAnonymousAdapterView.setMessage("If you want use this picture , Buy the complete version from the Android Market");
        paramAnonymousAdapterView.setPositiveButton("Buy", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2DialogInterface = new Intent("android.intent.action.VIEW");
            paramAnonymous2DialogInterface.setData(Uri.parse("market://details?id=com.troll.face.complete"));
            GalleryActivity.this.startActivity(paramAnonymous2DialogInterface);
          }
        });
        paramAnonymousAdapterView.setNegativeButton("Close", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            paramAnonymous2DialogInterface.cancel();
          }
        });
        paramAnonymousAdapterView.show();
        return;
      }
      paramAnonymousAdapterView = (ImageView)GalleryActivity.this.findViewById(2131165208);
      int i = new Integer(GalleryActivity.this.img.getTag().toString()).intValue();
      paramAnonymousView = (ImageObject)GalleryActivity.this.imageObjectArray.get(i);
      GalleryActivity.this.allowUnalloFlag = 1;
      GalleryActivity.this.notSavedImageFlag = 1;
      paramAnonymousAdapterView.setImageResource(2130837694);
      paramAnonymousAdapterView.setVisibility(0);
      ((LinearLayout)GalleryActivity.this.findViewById(2131165207)).setVisibility(0);
      GalleryActivity.this.addflag = 1;
      GalleryActivity.this.palletflag = 0;
      GalleryActivity.this.showPalletPerform();
      GalleryActivity.this.aLayout = ((AbsoluteLayout)GalleryActivity.this.findViewById(2131165184));
      GalleryActivity.this.img.setOnTouchListener(GalleryActivity.this.ontuchlist);
      GalleryActivity.this.img.setScaleType(ImageView.ScaleType.MATRIX);
      paramAnonymousAdapterView = BitmapFactory.decodeResource(GalleryActivity.this.getResources(), GalleryActivity.this.mImageIds[paramAnonymousInt].intValue());
      paramAnonymousView = Bitmap.createBitmap(paramAnonymousAdapterView, 0, 0, paramAnonymousAdapterView.getWidth(), paramAnonymousAdapterView.getHeight());
      GalleryActivity.this.img.setImageBitmap(paramAnonymousView);
      paramAnonymousView = GalleryActivity.this.getWindowManager().getDefaultDisplay();
      paramAnonymousView = new AbsoluteLayout.LayoutParams(paramAnonymousAdapterView.getWidth(), paramAnonymousAdapterView.getHeight(), paramAnonymousView.getWidth() / 2 - 200, paramAnonymousView.getHeight() / 2 - 180);
      GalleryActivity.this.img.setLayoutParams(paramAnonymousView);
      GalleryActivity.this.bitmap = paramAnonymousAdapterView;
      paramAnonymousView = new ImageObject();
      paramAnonymousView.setHeight(paramAnonymousAdapterView.getHeight());
      paramAnonymousView.setWidth(paramAnonymousAdapterView.getWidth());
      paramAnonymousView.setBitmap(paramAnonymousAdapterView);
      paramAnonymousView.setScale(1.0F);
      paramAnonymousView.setAngle(0.0F);
      paramAnonymousView.setDb(0.0F);
      paramAnonymousView.setDg(0.0F);
      paramAnonymousView.setDr(0.0F);
      paramAnonymousView.setX(GalleryActivity.this.aLayout.getWidth() / 2 - 200);
      paramAnonymousView.setY(GalleryActivity.this.aLayout.getHeight() / 2 - 180);
      GalleryActivity.this.imageObjectArray.set(i, paramAnonymousView);
      paramAnonymousView.setDrawableImageId(GalleryActivity.this.mImageIds[paramAnonymousInt]);
      ((Gallery)GalleryActivity.this.findViewById(2131165209)).setVisibility(0);
    }
  };
  ImageView lastselected;
  AbsoluteLayout.LayoutParams lp = null;
  private Uri mImageCaptureUri;
  private Integer[] mImageIds = { Integer.valueOf(2130837504), Integer.valueOf(2130837588), Integer.valueOf(2130837599), Integer.valueOf(2130837610), Integer.valueOf(2130837621), Integer.valueOf(2130837632), Integer.valueOf(2130837643), Integer.valueOf(2130837654), Integer.valueOf(2130837665), Integer.valueOf(2130837505), Integer.valueOf(2130837516), Integer.valueOf(2130837527), Integer.valueOf(2130837538), Integer.valueOf(2130837549), Integer.valueOf(2130837560), Integer.valueOf(2130837571), Integer.valueOf(2130837582), Integer.valueOf(2130837586), Integer.valueOf(2130837587), Integer.valueOf(2130837589), Integer.valueOf(2130837590), Integer.valueOf(2130837591), Integer.valueOf(2130837592), Integer.valueOf(2130837593), Integer.valueOf(2130837594), Integer.valueOf(2130837595), Integer.valueOf(2130837596), Integer.valueOf(2130837597), Integer.valueOf(2130837598), Integer.valueOf(2130837600), Integer.valueOf(2130837601), Integer.valueOf(2130837602), Integer.valueOf(2130837603), Integer.valueOf(2130837604), Integer.valueOf(2130837605), Integer.valueOf(2130837606), Integer.valueOf(2130837607), Integer.valueOf(2130837608), Integer.valueOf(2130837609), Integer.valueOf(2130837611), Integer.valueOf(2130837612), Integer.valueOf(2130837613), Integer.valueOf(2130837614), Integer.valueOf(2130837615), Integer.valueOf(2130837616), Integer.valueOf(2130837617), Integer.valueOf(2130837618), Integer.valueOf(2130837619), Integer.valueOf(2130837620), Integer.valueOf(2130837622), Integer.valueOf(2130837623), Integer.valueOf(2130837624), Integer.valueOf(2130837625), Integer.valueOf(2130837626), Integer.valueOf(2130837627), Integer.valueOf(2130837628), Integer.valueOf(2130837629), Integer.valueOf(2130837630), Integer.valueOf(2130837631), Integer.valueOf(2130837633), Integer.valueOf(2130837634), Integer.valueOf(2130837635), Integer.valueOf(2130837636), Integer.valueOf(2130837637), Integer.valueOf(2130837638), Integer.valueOf(2130837639), Integer.valueOf(2130837640), Integer.valueOf(2130837641), Integer.valueOf(2130837642), Integer.valueOf(2130837644), Integer.valueOf(2130837645), Integer.valueOf(2130837646), Integer.valueOf(2130837647), Integer.valueOf(2130837648), Integer.valueOf(2130837649), Integer.valueOf(2130837650), Integer.valueOf(2130837651), Integer.valueOf(2130837652), Integer.valueOf(2130837653), Integer.valueOf(2130837655), Integer.valueOf(2130837656), Integer.valueOf(2130837657), Integer.valueOf(2130837658), Integer.valueOf(2130837659), Integer.valueOf(2130837660), Integer.valueOf(2130837661), Integer.valueOf(2130837662), Integer.valueOf(2130837663), Integer.valueOf(2130837664), Integer.valueOf(2130837666), Integer.valueOf(2130837667), Integer.valueOf(2130837668), Integer.valueOf(2130837669), Integer.valueOf(2130837670), Integer.valueOf(2130837671), Integer.valueOf(2130837672), Integer.valueOf(2130837673), Integer.valueOf(2130837674), Integer.valueOf(2130837675), Integer.valueOf(2130837506), Integer.valueOf(2130837507), Integer.valueOf(2130837508), Integer.valueOf(2130837509), Integer.valueOf(2130837510), Integer.valueOf(2130837511), Integer.valueOf(2130837512), Integer.valueOf(2130837513), Integer.valueOf(2130837514), Integer.valueOf(2130837515), Integer.valueOf(2130837517), Integer.valueOf(2130837518), Integer.valueOf(2130837519), Integer.valueOf(2130837520), Integer.valueOf(2130837521), Integer.valueOf(2130837522), Integer.valueOf(2130837523), Integer.valueOf(2130837524), Integer.valueOf(2130837525), Integer.valueOf(2130837526), Integer.valueOf(2130837528), Integer.valueOf(2130837529), Integer.valueOf(2130837530), Integer.valueOf(2130837531), Integer.valueOf(2130837532), Integer.valueOf(2130837533), Integer.valueOf(2130837534), Integer.valueOf(2130837535), Integer.valueOf(2130837536), Integer.valueOf(2130837537), Integer.valueOf(2130837539), Integer.valueOf(2130837540), Integer.valueOf(2130837541), Integer.valueOf(2130837542), Integer.valueOf(2130837543), Integer.valueOf(2130837544), Integer.valueOf(2130837545), Integer.valueOf(2130837546), Integer.valueOf(2130837547), Integer.valueOf(2130837548), Integer.valueOf(2130837550), Integer.valueOf(2130837550), Integer.valueOf(2130837552), Integer.valueOf(2130837553), Integer.valueOf(2130837554), Integer.valueOf(2130837555), Integer.valueOf(2130837556), Integer.valueOf(2130837557), Integer.valueOf(2130837558), Integer.valueOf(2130837559), Integer.valueOf(2130837561), Integer.valueOf(2130837562), Integer.valueOf(2130837563), Integer.valueOf(2130837564), Integer.valueOf(2130837565), Integer.valueOf(2130837566), Integer.valueOf(2130837567), Integer.valueOf(2130837568), Integer.valueOf(2130837569), Integer.valueOf(2130837570), Integer.valueOf(2130837572), Integer.valueOf(2130837573), Integer.valueOf(2130837574), Integer.valueOf(2130837575), Integer.valueOf(2130837576), Integer.valueOf(2130837577), Integer.valueOf(2130837578), Integer.valueOf(2130837579), Integer.valueOf(2130837580), Integer.valueOf(2130837581), Integer.valueOf(2130837583), Integer.valueOf(2130837584), Integer.valueOf(2130837585) };
  String namePlayer;
  int notSavedImageFlag = 0;
  int numberTroll = 0;
  View.OnTouchListener ontuchlist = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      GalleryActivity.this.img = ((ImageView)paramAnonymousView);
      if (GalleryActivity.this.lastselected != null) {
        GalleryActivity.this.lastselected.setBackgroundResource(0);
      }
      GalleryActivity.this.img.setBackgroundResource(2130837681);
      GalleryActivity.this.lastselected = GalleryActivity.this.img;
      GalleryActivity.this.selectedImageFlag = 1;
      return false;
    }
  };
  int optionsinSampleSize = 2;
  private View.OnClickListener palletListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      Toast.makeText(GalleryActivity.this.getApplicationContext(), "Paint Troll", 0).show();
      GalleryActivity.this.showPalletPerform();
    }
  };
  int palletflag = 0;
  private View.OnClickListener photoGalleyListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      Toast.makeText(GalleryActivity.this.getApplicationContext(), "Select a photo to edit", 0).show();
      GalleryActivity.this.photoGalleryPerform();
    }
  };
  private Vector2D position = new Vector2D();
  int raggiox = 0;
  int raggioy = 0;
  private View.OnClickListener reOpenListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      GalleryActivity.this.openGalleryPerform();
      Toast.makeText(GalleryActivity.this.getApplicationContext(), "Open Troll Gallery", 0).show();
    }
  };
  private View.OnClickListener redListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      int i;
      float f1;
      int j;
      int k;
      float f2;
      Object localObject1;
      Object localObject2;
      int n;
      Matrix localMatrix;
      if (GalleryActivity.this.selectedImageFlag == 1)
      {
        i = new Integer(GalleryActivity.this.img.getTag().toString()).intValue();
        paramAnonymousView = (ImageObject)GalleryActivity.this.imageObjectArray.get(i);
        GalleryActivity.this.aLayout = ((AbsoluteLayout)GalleryActivity.this.findViewById(2131165184));
        GalleryActivity.this.img.setOnTouchListener(GalleryActivity.this.ontuchlist);
        GalleryActivity.this.img.setScaleType(ImageView.ScaleType.MATRIX);
        f1 = paramAnonymousView.getScale();
        paramAnonymousView.getAngle();
        j = paramAnonymousView.getWidth();
        k = paramAnonymousView.getHeight();
        f2 = paramAnonymousView.getDr() + 1.0F;
        float f3 = paramAnonymousView.getDg();
        float f4 = paramAnonymousView.getDb();
        localObject1 = new ColorMatrix();
        ((ColorMatrix)localObject1).setSaturation(0.0F);
        ((ColorMatrix)localObject1).set(new float[] { 0.0F, f2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, f4, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
        localObject2 = new ColorMatrixColorFilter((ColorMatrix)localObject1);
        localObject1 = new Paint();
        ((Paint)localObject1).setColorFilter((ColorFilter)localObject2);
        localObject2 = BitmapFactory.decodeResource(GalleryActivity.this.getResources(), paramAnonymousView.getDrawableImageId().intValue());
        int m = paramAnonymousView.getFlipFlag();
        n = paramAnonymousView.getFlipVerticalFlag();
        localMatrix = new Matrix();
        if ((m != 0) && (m != 3)) {
          break label492;
        }
        if ((n != 3) && (n != 0)) {
          break label480;
        }
        localMatrix.preScale(1.0F, 1.0F);
      }
      for (;;)
      {
        localObject2 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), localMatrix, true).copy(Bitmap.Config.ARGB_8888, true);
        GalleryActivity.this.img.setImageBitmap((Bitmap)localObject2);
        new Canvas((Bitmap)localObject2).drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, (Paint)localObject1);
        localObject1 = new AbsoluteLayout.LayoutParams((int)(j * f1), (int)(k * f1), paramAnonymousView.getX(), paramAnonymousView.getY());
        GalleryActivity.this.img.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramAnonymousView.setDr(f2);
        GalleryActivity.this.imageObjectArray.set(i, paramAnonymousView);
        return;
        label480:
        localMatrix.preScale(1.0F, -1.0F);
        continue;
        label492:
        if ((n == 3) || (n == 0)) {
          localMatrix.preScale(-1.0F, 1.0F);
        } else {
          localMatrix.preScale(-1.0F, -1.0F);
        }
      }
    }
  };
  private int rotateCount = 1;
  private View.OnClickListener rotateListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (GalleryActivity.this.bitmapImage != null)
      {
        paramAnonymousView = GalleryActivity.this.getWindowManager().getDefaultDisplay();
        int i = paramAnonymousView.getWidth();
        int j = paramAnonymousView.getHeight();
        paramAnonymousView = new BitmapFactory.Options();
        paramAnonymousView.inSampleSize = GalleryActivity.this.optionsinSampleSize;
        GalleryActivity.this.bitmapImage = BitmapFactory.decodeFile(GalleryActivity.this.selectedImagePath, paramAnonymousView);
        paramAnonymousView = Bitmap.createScaledBitmap(GalleryActivity.this.bitmapImage, j, i, true);
        Matrix localMatrix = new Matrix();
        localMatrix.postRotate(GalleryActivity.this.rotateCount * -90);
        GalleryActivity localGalleryActivity = GalleryActivity.this;
        localGalleryActivity.rotateCount += 1;
        paramAnonymousView = new BitmapDrawable(Bitmap.createBitmap(paramAnonymousView, 0, 0, paramAnonymousView.getWidth(), paramAnonymousView.getHeight(), localMatrix, true));
        ((LinearLayout)GalleryActivity.this.findViewById(2131165194)).setBackgroundDrawable(paramAnonymousView);
      }
    }
  };
  int selectedImageFlag = 0;
  private String selectedImagePath;
  private View.OnClickListener shareListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      GalleryActivity.this.showShareDialogPerform();
    }
  };
  int status = 0;
  private TouchManager touchManager = new TouchManager(2);
  private Matrix transform = new Matrix();
  ArrayList<TeamItem> trollList = new ArrayList();
  private View.OnClickListener undoListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (GalleryActivity.this.selectedImageFlag == 1)
      {
        GalleryActivity.this.img.setImageBitmap(null);
        GalleryActivity.this.img.setVisibility(4);
      }
      Toast.makeText(GalleryActivity.this.getApplicationContext(), "Undo Troll change", 0).show();
    }
  };
  
  private static float getDegreesFromRadians(float paramFloat)
  {
    return (float)(paramFloat * 180.0D / 3.141592653589793D);
  }
  
  public void allowPerform(int paramInt)
  {
    if (this.notSavedImageFlag == 1)
    {
      Log.d("buttonAllowListener", "Allow");
      LinearLayout localLinearLayout = (LinearLayout)findViewById(2131165196);
      localLinearLayout.setVisibility(4);
      ((Gallery)findViewById(2131165209)).setVisibility(4);
      ImageView localImageView1 = (ImageView)findViewById(2131165208);
      localImageView1.setImageResource(2130837715);
      localImageView1.setVisibility(4);
      localImageView1 = (ImageView)findViewById(2131165214);
      localImageView1.setVisibility(4);
      ((LinearLayout)findViewById(2131165207)).setVisibility(4);
      ((ImageView)findViewById(2131165217)).setVisibility(4);
      ((ImageView)findViewById(2131165218)).setVisibility(4);
      ((ImageView)findViewById(2131165219)).setVisibility(4);
      ((ImageView)findViewById(2131165220)).setVisibility(4);
      ((ImageView)findViewById(2131165221)).setVisibility(4);
      ImageView localImageView2 = (ImageView)findViewById(2131165215);
      localImageView2.setVisibility(4);
      ImageView localImageView3 = (ImageView)findViewById(2131165212);
      localImageView3.setVisibility(4);
      ImageView localImageView4 = (ImageView)findViewById(2131165213);
      localImageView4.setVisibility(4);
      ImageView localImageView5 = (ImageView)findViewById(2131165216);
      localImageView5.setVisibility(4);
      ImageView localImageView6 = (ImageView)findViewById(2131165211);
      localImageView6.setVisibility(4);
      this.addflag = 0;
      this.palletflag = 0;
      this.notSavedImageFlag = 0;
      new View(this);
      Object localObject1 = getWindow().getDecorView().findViewById(16908290);
      ((View)localObject1).setDrawingCacheEnabled(true);
      ((View)localObject1).refreshDrawableState();
      localObject1 = ((View)localObject1).getDrawingCache();
      for (;;)
      {
        try
        {
          new File(Environment.getExternalStorageDirectory() + File.separator + "TrollFace").mkdirs();
          Object localObject2 = new FileOutputStream(Environment.getExternalStorageDirectory() + File.separator + "TrollFace" + File.separator + "TrolFaceImage.jpg");
          localIOException1.printStackTrace();
        }
        catch (FileNotFoundException localFileNotFoundException1)
        {
          try
          {
            localObject2 = new BufferedOutputStream((OutputStream)localObject2);
            ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 60, (OutputStream)localObject2);
            ((BufferedOutputStream)localObject2).flush();
            ((BufferedOutputStream)localObject2).close();
            if (paramInt == 2)
            {
              localObject2 = new BufferedOutputStream(new FileOutputStream(Environment.getExternalStorageDirectory() + File.separator + "TrollFace" + File.separator + String.valueOf(System.currentTimeMillis()) + "_" + "TrolFaceImage.jpg"));
              ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 60, (OutputStream)localObject2);
            }
            localLinearLayout.setVisibility(0);
            localImageView2.setVisibility(0);
            localImageView5.setVisibility(0);
            localImageView3.setVisibility(0);
            localImageView4.setVisibility(0);
            localImageView1.setVisibility(0);
            localImageView6.setVisibility(0);
            sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
            Toast.makeText(getApplicationContext(), "Change Saved", 0).show();
            return;
          }
          catch (IOException localIOException2)
          {
            for (;;) {}
          }
          catch (FileNotFoundException localFileNotFoundException2)
          {
            continue;
          }
          localFileNotFoundException1 = localFileNotFoundException1;
          localFileNotFoundException1.printStackTrace();
        }
        catch (IOException localIOException1) {}
      }
    }
    unAllowPerform();
  }
  
  public String getPath(Uri paramUri)
  {
    paramUri = managedQuery(paramUri, new String[] { "_data" }, null, null, null);
    int i = paramUri.getColumnIndexOrThrow("_data");
    paramUri.moveToFirst();
    return paramUri.getString(i);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = 2;
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.mImageCaptureUri == null) || (this.mImageCaptureUri.getPath() == null));
        this.selectedImagePath = this.mImageCaptureUri.getPath();
        ((MyApp)getApplication()).setImagePath(this.selectedImagePath);
        this.bitmapImage = BitmapFactory.decodeFile(this.selectedImagePath, localOptions);
        paramIntent = new BitmapDrawable(this.bitmapImage);
        ((LinearLayout)findViewById(2131165194)).setBackgroundDrawable(paramIntent);
        return;
      } while (paramIntent == null);
      this.mImageCaptureUri = paramIntent.getData();
      this.selectedImagePath = getPath(paramIntent.getData());
      ((MyApp)getApplication()).setImagePath(this.selectedImagePath);
      this.bitmapImage = BitmapFactory.decodeFile(this.selectedImagePath, localOptions);
      paramIntent = new BitmapDrawable(this.bitmapImage);
      ((LinearLayout)findViewById(2131165194)).setBackgroundDrawable(paramIntent);
      return;
      if (!Environment.getExternalStorageState().equalsIgnoreCase("MOUNTED")) {
        break;
      }
    } while (this.db.getMessage("Commented").getCount() != 0);
    paramIntent = new AlertDialog.Builder(this);
    paramIntent.setTitle("Thank You");
    paramIntent.setMessage("If you like this app , leave a comment.");
    paramIntent.setPositiveButton("Ok", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GalleryActivity.this.db.insertMessage("1", "Commented");
        paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.troll.face"));
        GalleryActivity.this.startActivity(paramAnonymousDialogInterface);
      }
    });
    paramIntent.setNegativeButton("No", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        GalleryActivity.this.db.insertMessage("1", "Commented");
      }
    });
    paramIntent.setNeutralButton("Later", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    paramIntent.show();
    return;
    paramIntent = new AlertDialog.Builder(this);
    paramIntent.setTitle("Thank You");
    paramIntent.setMessage("If you like this app , please support us and leave a comment.");
    paramIntent.setPositiveButton("Ok", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.troll.face"));
        GalleryActivity.this.startActivity(paramAnonymousDialogInterface);
      }
    });
    paramIntent.setNegativeButton("No", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    paramIntent.setNeutralButton("Later", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    paramIntent.show();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.adInter = new AdController(this, "620641523");
    this.adInter.loadAd();
    this.adFloat = new AdController(this, "515446838");
    this.adFloat.loadAd();
    requestWindowFeature(7);
    setContentView(2130903043);
    getWindow().setFeatureInt(7, 2130903051);
    this.controlInflater = LayoutInflater.from(getBaseContext());
    Object localObject = this.controlInflater.inflate(2130903040, null);
    paramBundle = new ViewGroup.LayoutParams(-1, -1);
    addContentView((View)localObject, paramBundle);
    this.aLayout = ((AbsoluteLayout)findViewById(2131165184));
    localObject = (MyApp)getApplication();
    this.selectedImagePath = ((MyApp)localObject).getImagePath();
    ((MyApp)localObject).setAddFlag(true);
    int i;
    if (this.selectedImagePath != null)
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inSampleSize = this.optionsinSampleSize;
      this.bitmapImage = BitmapFactory.decodeFile(this.selectedImagePath, (BitmapFactory.Options)localObject);
      localObject = new BitmapDrawable(this.bitmapImage);
      ((LinearLayout)findViewById(2131165194)).setBackgroundDrawable((Drawable)localObject);
      this.controlInflater = LayoutInflater.from(getBaseContext());
      addContentView(this.controlInflater.inflate(2130903048, null), paramBundle);
      if (Environment.getExternalStorageState().equalsIgnoreCase("MOUNTED")) {
        this.db = new DBAdapter(this);
      }
      new TeamItem();
      i = 0;
    }
    for (;;)
    {
      if (i >= 172)
      {
        paramBundle = (Gallery)findViewById(2131165209);
        this.adapterGallery = new LazyAdapterSearch(this, this.trollList, this);
        paramBundle.setAdapter(this.adapterGallery);
        paramBundle.setOnItemClickListener(this.itemGalleryClick);
        this.aLayout.setOnTouchListener(this);
        ((ImageView)findViewById(2131165214)).setOnClickListener(this.addListener);
        paramBundle = new AdView(this, AdSize.BANNER, "a14f6cc7dc55d03");
        paramBundle.setGravity(1);
        paramBundle.setHorizontalGravity(1);
        paramBundle.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ((LinearLayout)findViewById(2131165196)).addView(paramBundle);
        paramBundle.loadAd(new AdRequest());
        ((ImageView)findViewById(2131165220)).setOnClickListener(this.flipListener);
        ((ImageView)findViewById(2131165221)).setOnClickListener(this.flipListenerVertical);
        ((ImageView)findViewById(2131165215)).setOnClickListener(this.palletListener);
        ((ImageView)findViewById(2131165212)).setOnClickListener(this.rotateListener);
        ((ImageView)findViewById(2131165213)).setOnClickListener(this.shareListener);
        ((ImageView)findViewById(2131165211)).setOnClickListener(this.undoListener);
        ((ImageView)findViewById(2131165217)).setOnClickListener(this.redListener);
        ((ImageView)findViewById(2131165218)).setOnClickListener(this.greenListener);
        ((ImageView)findViewById(2131165219)).setOnClickListener(this.blueListener);
        ((ImageView)findViewById(2131165208)).setOnClickListener(this.reOpenListener);
        ((ImageView)findViewById(2131165216)).setOnClickListener(this.photoGalleyListener);
        return;
        photoGalleryPerform();
        break;
      }
      paramBundle = new TeamItem();
      paramBundle.setTitle("Team " + (i + 1));
      paramBundle.setImage(this.mImageIds[i]);
      this.trollList.add(paramBundle);
      i += 1;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    super.onCreateOptionsMenu(paramMenu);
    getMenuInflater().inflate(2131099648, paramMenu);
    return true;
  }
  
  public void onDestroy()
  {
    ((MyApp)getApplication()).setImagePath("");
    super.onDestroy();
    if (this.adInter != null) {
      this.adInter.destroyAd();
    }
    if (this.adFloat != null) {
      this.adFloat.destroyAd();
    }
    AppTracker.closeSession(getApplicationContext(), true);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return true;
    case 2131165225: 
      new Intent();
      paramMenuItem = new Intent("android.media.action.IMAGE_CAPTURE");
      new File(Environment.getExternalStorageDirectory() + File.separator + "TrollFace").mkdirs();
      this.mImageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory() + File.separator + "TrollFace" + File.separator + "TrolFaceImage.jpg"));
      paramMenuItem.putExtra("output", this.mImageCaptureUri);
      try
      {
        paramMenuItem.putExtra("return-data", true);
        startActivityForResult(paramMenuItem, 1);
        return true;
      }
      catch (ActivityNotFoundException paramMenuItem)
      {
        paramMenuItem.printStackTrace();
        return true;
      }
    case 2131165224: 
      new Intent();
      paramMenuItem = new Intent();
      paramMenuItem.setType("image/*");
      paramMenuItem.setAction("android.intent.action.GET_CONTENT");
      startActivityForResult(Intent.createChooser(paramMenuItem, "Complete action using"), 3);
      return true;
    case 2131165226: 
      showShareDialogPerform();
      return true;
    }
    savePhoto();
    return true;
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.adInter != null) {
      this.adInter.destroyAd();
    }
    if (this.adFloat != null) {
      this.adFloat.destroyAd();
    }
    if (!isFinishing()) {
      AppTracker.pause(getApplicationContext());
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i;
    float f3;
    int j;
    int k;
    if (this.selectedImageFlag == 1)
    {
      i = new Integer(this.img.getTag().toString()).intValue();
      paramView = (ImageObject)this.imageObjectArray.get(i);
      f3 = paramView.getScale();
      f5 = paramView.getAngle();
      j = paramView.getWidth();
      k = paramView.getHeight();
      f2 = f3;
    }
    try
    {
      this.touchManager.update(paramMotionEvent);
      f2 = f3;
      if (this.touchManager.getPressCount() != 1) {
        break label202;
      }
      f2 = f3;
      this.position.add(this.touchManager.moveDelta(0));
      f1 = f3;
      f4 = f5;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        int m;
        int n;
        float f4 = f5;
        float f1 = f2;
      }
    }
    if (!this.isInitialized)
    {
      m = this.bitmap.getWidth();
      n = this.bitmap.getHeight();
      this.position.set(m / 2, n / 2);
      this.isInitialized = true;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      label202:
      f4 = f5;
      f1 = f3;
      f2 = f3;
      if (this.touchManager.getPressCount() != 2) {
        break;
      }
      f2 = f3;
      Vector2D localVector2D1 = this.touchManager.getVector(0, 1);
      f2 = f3;
      Vector2D localVector2D2 = this.touchManager.getPreviousVector(0, 1);
      f2 = f3;
      f4 = localVector2D1.getLength();
      f2 = f3;
      float f6 = localVector2D2.getLength();
      f1 = f3;
      if (f6 != 0.0F)
      {
        f2 = f3;
        f1 = f3 * (f4 / f6);
      }
      f2 = f1;
      f3 = Vector2D.getSignedAngleBetween(localVector2D1, localVector2D2);
      f4 = f5 - f3;
      break;
      if (paramView.getX() != 0)
      {
        this.raggiox = ((int)paramMotionEvent.getRawX() - paramView.getX());
        this.raggioy = ((int)paramMotionEvent.getRawY() - paramView.getY());
      }
      else
      {
        this.raggiox = ((int)(j * f1) / 2);
        this.raggioy = ((int)(k * f1) / 2);
        continue;
        if (this.lastselected != null)
        {
          this.lastselected.setBackgroundResource(0);
          continue;
          this.transform.reset();
          this.transform.postTranslate(-j / 2.0F, -k / 2.0F);
          this.transform.postRotate(getDegreesFromRadians(f4));
          this.transform.postScale(f1, f1);
          this.transform.postTranslate(j * f1 / 2.0F, k * f1 / 2.0F);
          m = (int)paramMotionEvent.getRawX() - this.raggiox;
          n = (int)paramMotionEvent.getRawY() - this.raggioy;
          paramMotionEvent = new AbsoluteLayout.LayoutParams((int)(j * f1), (int)(k * f1), m, n);
          this.img.setLayoutParams(paramMotionEvent);
          this.img.setImageMatrix(this.transform);
          paramView.setScale(f1);
          paramView.setAngle(f4);
          paramView.setHeight(k);
          paramView.setWidth(j);
          paramView.setX(m);
          paramView.setY(n);
          this.imageObjectArray.set(i, paramView);
        }
      }
    }
  }
  
  public void openGalleryPerform()
  {
    ImageView localImageView = (ImageView)findViewById(2131165208);
    if (this.addflag == 0)
    {
      ((Gallery)findViewById(2131165209)).setVisibility(0);
      localImageView.setImageResource(2130837694);
      localImageView.setVisibility(0);
      ((LinearLayout)findViewById(2131165207)).setVisibility(0);
      this.addflag = 1;
      return;
    }
    if (this.allowUnalloFlag == 0)
    {
      localImageView.setVisibility(4);
      ((LinearLayout)findViewById(2131165207)).setVisibility(4);
    }
    ((Gallery)findViewById(2131165209)).setVisibility(4);
    localImageView.setImageResource(2130837715);
    this.addflag = 0;
  }
  
  public void photoGalleryPerform()
  {
    ArrayAdapter localArrayAdapter = new ArrayAdapter(this, 17367057, new String[] { "Take from camera", "Select from gallery" });
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle("Select Image");
    localBuilder.setAdapter(localArrayAdapter, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if (paramAnonymousInt == 0)
        {
          paramAnonymousDialogInterface = new Intent("android.media.action.IMAGE_CAPTURE");
          new File(Environment.getExternalStorageDirectory() + File.separator + "TrollFace").mkdirs();
          File localFile = new File(Environment.getExternalStorageDirectory() + File.separator + "TrollFace" + File.separator + "TrolFaceImage.jpg");
          if (localFile.exists()) {
            localFile.delete();
          }
          GalleryActivity.this.mImageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory() + File.separator + "TrollFace" + File.separator + "TrolFaceImage.jpg"));
          paramAnonymousDialogInterface.putExtra("output", GalleryActivity.this.mImageCaptureUri);
          try
          {
            paramAnonymousDialogInterface.putExtra("return-data", true);
            GalleryActivity.this.startActivityForResult(paramAnonymousDialogInterface, 1);
            return;
          }
          catch (ActivityNotFoundException paramAnonymousDialogInterface)
          {
            paramAnonymousDialogInterface.printStackTrace();
            return;
          }
        }
        paramAnonymousDialogInterface = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        paramAnonymousDialogInterface.setType("image/*");
        GalleryActivity.this.startActivityForResult(paramAnonymousDialogInterface, 3);
      }
    });
    localBuilder.create().show();
  }
  
  public void savePhoto()
  {
    Log.d("savePhoto", "save");
    final LinearLayout localLinearLayout = (LinearLayout)findViewById(2131165196);
    localLinearLayout.setVisibility(4);
    final ImageView localImageView = (ImageView)findViewById(2131165186);
    localImageView.setVisibility(0);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle("Type Name");
    localBuilder.setMessage("Insert Troll Name");
    final EditText localEditText = new EditText(this);
    localBuilder.setView(localEditText);
    localBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        ((InputMethodManager)GalleryActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(localEditText.getWindowToken(), 0);
        paramAnonymousDialogInterface = (TextView)GalleryActivity.this.findViewById(2131165187);
        Editable localEditable = localEditText.getText();
        GalleryActivity.this.namePlayer = localEditable.toString();
        paramAnonymousDialogInterface.setText(GalleryActivity.this.namePlayer);
        paramAnonymousDialogInterface.setVisibility(0);
        paramAnonymousDialogInterface.setGravity(1);
        GalleryActivity.this.notSavedImageFlag = 1;
        GalleryActivity.this.allowPerform(2);
        localImageView.setVisibility(4);
        localLinearLayout.setVisibility(0);
        paramAnonymousDialogInterface.setVisibility(4);
        paramAnonymousDialogInterface = new Intent("android.intent.action.SEND");
        paramAnonymousDialogInterface.putExtra("android.intent.extra.TEXT", "Troll Face , download app here:  market://details?id=com.troll.face");
        paramAnonymousDialogInterface.addFlags(1);
        paramAnonymousDialogInterface.setType("image/jpeg");
        paramAnonymousDialogInterface.putExtra("android.intent.extra.SUBJECT", "TrollFace , This App! Its AWESOME!  https://play.google.com/store/apps/details?id=com.troll.face");
        paramAnonymousDialogInterface.putExtra("android.intent.extra.STREAM", Uri.parse("file:///sdcard/TrollFace/TrolFaceImage.jpg"));
        GalleryActivity.this.startActivityForResult(Intent.createChooser(paramAnonymousDialogInterface, "TrollFace"), 2);
      }
    });
    localBuilder.show();
  }
  
  public void showPalletPerform()
  {
    if (this.palletflag == 0)
    {
      ((ImageView)findViewById(2131165217)).setVisibility(0);
      ((ImageView)findViewById(2131165218)).setVisibility(0);
      ((ImageView)findViewById(2131165219)).setVisibility(0);
      ((ImageView)findViewById(2131165220)).setVisibility(0);
      ((ImageView)findViewById(2131165221)).setVisibility(0);
      this.palletflag = 1;
      return;
    }
    ((ImageView)findViewById(2131165217)).setVisibility(4);
    ((ImageView)findViewById(2131165218)).setVisibility(4);
    ((ImageView)findViewById(2131165219)).setVisibility(4);
    ((ImageView)findViewById(2131165220)).setVisibility(4);
    ((ImageView)findViewById(2131165221)).setVisibility(4);
    this.palletflag = 0;
  }
  
  public void showShareDialogPerform()
  {
    Log.d("ShareListener", "share");
    final LinearLayout localLinearLayout = (LinearLayout)findViewById(2131165196);
    localLinearLayout.setVisibility(4);
    final ImageView localImageView = (ImageView)findViewById(2131165186);
    localImageView.setVisibility(0);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle("Type Name");
    localBuilder.setMessage("Insert Troll Name");
    final EditText localEditText = new EditText(this);
    localBuilder.setView(localEditText);
    localBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        ((InputMethodManager)GalleryActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(localEditText.getWindowToken(), 0);
        paramAnonymousDialogInterface = (TextView)GalleryActivity.this.findViewById(2131165187);
        Editable localEditable = localEditText.getText();
        GalleryActivity.this.namePlayer = localEditable.toString();
        paramAnonymousDialogInterface.setText(GalleryActivity.this.namePlayer);
        paramAnonymousDialogInterface.setVisibility(0);
        paramAnonymousDialogInterface.setGravity(1);
        GalleryActivity.this.notSavedImageFlag = 1;
        GalleryActivity.this.allowPerform(2);
        localImageView.setVisibility(4);
        localLinearLayout.setVisibility(0);
        paramAnonymousDialogInterface.setVisibility(4);
        paramAnonymousDialogInterface = new Intent("android.intent.action.SEND");
        paramAnonymousDialogInterface.putExtra("android.intent.extra.TEXT", "Troll Face , download app here:  market://details?id=com.troll.face");
        paramAnonymousDialogInterface.addFlags(1);
        paramAnonymousDialogInterface.setType("image/jpeg");
        paramAnonymousDialogInterface.putExtra("android.intent.extra.SUBJECT", "TrollFace , This App! Its AWESOME!  https://play.google.com/store/apps/details?id=com.troll.face");
        paramAnonymousDialogInterface.putExtra("android.intent.extra.STREAM", Uri.parse("file:///sdcard/TrollFace/TrolFaceImage.jpg"));
        GalleryActivity.this.startActivityForResult(Intent.createChooser(paramAnonymousDialogInterface, "TrollFace"), 2);
      }
    });
    localBuilder.show();
  }
  
  public void unAllowPerform()
  {
    ((Gallery)findViewById(2131165209)).setVisibility(4);
    ((ImageView)findViewById(2131165208)).setImageResource(2130837715);
    ((LinearLayout)findViewById(2131165207)).setVisibility(4);
    this.notSavedImageFlag = 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/troll/face/GalleryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */