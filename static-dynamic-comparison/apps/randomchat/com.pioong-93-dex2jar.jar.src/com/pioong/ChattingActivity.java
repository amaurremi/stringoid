package com.pioong;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.text.ClipboardManager;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.mocoplex.adlib.AdlibActivity;
import com.pioong.asynchttp.HttpConnection;
import com.pioong.customview.MessageListView;
import com.pioong.global.FileUpload;
import com.pioong.global.Network;
import com.pioong.global.Value;
import com.pioong.msgadapter.ChatMessage;
import com.pioong.msgadapter.MessageAdapter;
import com.pioong.msgadapter.SendingMessage;
import java.io.IOException;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.bson.types.ObjectId;
import org.json.JSONArray;
import org.json.JSONObject;

public class ChattingActivity
  extends AdlibActivity
  implements LocationListener
{
  private static final int PICK_IMAGE = 1;
  private static final int TAKE_IMAGE = 2;
  protected boolean bHavetoUpdate = false;
  public boolean bProcessing = false;
  private String clipboard = null;
  private ChatMessage failedCM = null;
  protected HeartbeatSender hbThread;
  private EditText input = null;
  public int lastRcvIndex = 0;
  String lc;
  public MessageListView listView;
  private ArrayList<ChatMessage> mArray;
  private Button mBtn;
  private ArrayList<SendingMessage> mSendQueue = new ArrayList();
  private MessageAdapter m_adapter = null;
  private LocationManager mlocManager;
  protected long nextAccess = 0L;
  private Handler oHandler = null;
  private Button photoBtn;
  protected UpdateThread tmThread;
  int widthSize;
  
  public static int getBitmapOfHeight(String paramString)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      int i = localOptions.outHeight;
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static int getBitmapOfWidth(String paramString)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      int i = localOptions.outWidth;
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-16777216);
    localCanvas.drawRoundRect(localRectF, 15.0F, 15.0F, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localBitmap;
  }
  
  public void btnChange()
  {
    if (Value.getInstance().isChatting())
    {
      this.mBtn.setBackgroundResource(2130837519);
      return;
    }
    this.mBtn.setBackgroundResource(2130837525);
  }
  
  public int dpToPx(int paramInt)
  {
    return (int)(paramInt * getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public String getPath(Uri paramUri)
  {
    Object localObject = null;
    Cursor localCursor = managedQuery(paramUri, new String[] { "_data" }, null, null, null);
    paramUri = (Uri)localObject;
    if (localCursor != null)
    {
      int i = localCursor.getColumnIndexOrThrow("_data");
      localCursor.moveToFirst();
      paramUri = localCursor.getString(i);
    }
    return paramUri;
  }
  
  public Bitmap getResizedImage(String paramString)
  {
    Object localObject = new BitmapFactory.Options();
    int i = getBitmapOfWidth(paramString);
    int j = getBitmapOfHeight(paramString);
    label42:
    int m;
    int k;
    float f2;
    float f3;
    if (i >= j)
    {
      if (i > 1024) {
        break label218;
      }
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      ((BitmapFactory.Options)localObject).inPurgeable = true;
      localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      m = ((Bitmap)localObject).getWidth();
      k = ((Bitmap)localObject).getHeight();
      i = k;
      f2 = 1.0F;
      float f1 = 1.0F;
      j = i;
      if (m > 1024)
      {
        f1 = 'Ѐ' / m;
        f2 = f1;
        j = (int)(i * f2);
      }
      f3 = f1;
      if (j > 1024)
      {
        f3 = 'Ѐ' / k;
        f1 = f3;
        f2 = f1;
      }
      j = 0;
    }
    try
    {
      i = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      j = i;
    }
    catch (IOException paramString)
    {
      label218:
      for (;;) {}
    }
    i = 0;
    if (j == 6) {
      i = 90;
    }
    for (;;)
    {
      paramString = new Matrix();
      paramString.postScale(f3, f2);
      paramString.postRotate(i);
      return Bitmap.createBitmap((Bitmap)localObject, 0, 0, m, k, paramString, true);
      i = j;
      break;
      if (i <= 2048)
      {
        ((BitmapFactory.Options)localObject).inSampleSize = 2;
        break label42;
      }
      if (i <= 4096)
      {
        ((BitmapFactory.Options)localObject).inSampleSize = 4;
        break label42;
      }
      ((BitmapFactory.Options)localObject).inSampleSize = 8;
      break label42;
      if (j == 3) {
        i = 180;
      } else if (j == 8) {
        i = 270;
      }
    }
  }
  
  public void goToHome(View paramView)
  {
    if (Value.getInstance().isChatting())
    {
      new AlertDialog.Builder(this).setMessage(getString(2131034117)).setPositiveButton(getString(2131034118), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          ChattingActivity.this.finish();
        }
      }).setNegativeButton(getString(2131034119), null).show();
      return;
    }
    finish();
  }
  
  public void hideKeyboard(View paramView)
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.input.getWindowToken(), 0);
  }
  
  protected boolean needToUpdate()
  {
    return this.nextAccess < System.currentTimeMillis();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 == 1) {}
      try
      {
        paramIntent = getPath(paramIntent.getData());
        if (paramIntent == null) {
          return;
        }
        str = new ObjectId().toString();
        localThumnail = new Thumnail();
        this.m_adapter.put(str, localThumnail.getThumImage(paramIntent));
        this.mArray.add(new ChatMessage(str, "I", paramIntent, pxToDp(localThumnail.mWidth), pxToDp(localThumnail.mHeight), "me", true));
        uploadImage(paramIntent, str, pxToDp(localThumnail.mWidth), pxToDp(localThumnail.mHeight));
        updateList();
        return;
      }
      catch (Exception paramIntent)
      {
        String str;
        Thumnail localThumnail;
        Toast.makeText(this, getString(2131034132), 0).show();
      }
      if (paramInt1 == 2)
      {
        paramIntent = getPath(paramIntent.getData());
        if (paramIntent != null)
        {
          str = new ObjectId().toString();
          localThumnail = new Thumnail();
          this.m_adapter.put(str, localThumnail.getThumImage(paramIntent));
          this.mArray.add(new ChatMessage(str, "I", paramIntent, pxToDp(localThumnail.mWidth), pxToDp(localThumnail.mHeight), "me", true));
          uploadImage(paramIntent, str, pxToDp(localThumnail.mWidth), pxToDp(localThumnail.mHeight));
          updateList();
          return;
        }
      }
    }
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onContextItemSelected(paramMenuItem);
      try
      {
        ((ClipboardManager)getSystemService("clipboard")).setText(this.clipboard);
        this.clipboard = null;
        continue;
        Object localObject = new Intent("android.intent.action.SEND");
        ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
        ((Intent)localObject).putExtra("android.intent.extra.TEXT", this.clipboard);
        ((Intent)localObject).setType("text/plain");
        startActivity((Intent)localObject);
        this.clipboard = null;
        continue;
        this.clipboard = null;
        continue;
        try
        {
          if (this.failedCM.getType().equals("T"))
          {
            localObject = new SendingMessage(this.failedCM.getID(), this.failedCM.getText());
            this.mSendQueue.add(localObject);
          }
          for (;;)
          {
            this.failedCM = null;
            break;
            localObject = this.m_adapter.getSentMessage(this.failedCM.getID());
            if (localObject != null) {
              ((ChatMessage)localObject).setSType("");
            }
            uploadImage(this.failedCM.getText(), this.failedCM.getID(), this.failedCM.getImgWidth(), this.failedCM.getImgHeight());
            updateList();
          }
        }
        catch (Exception localException1)
        {
          for (;;) {}
        }
        try
        {
          this.mArray.remove(this.failedCM);
          updateList();
          this.failedCM = null;
          continue;
          this.failedCM = null;
          continue;
          showGallery();
          continue;
          takePhoto();
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
      }
      catch (Exception localException3)
      {
        for (;;) {}
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    setAdsContainer(2131296260);
    this.input = ((EditText)findViewById(2131296263));
    this.listView = ((MessageListView)findViewById(2131296265));
    this.listView.setVerticalFadingEdgeEnabled(false);
    this.listView.setDividerHeight(0);
    this.listView.setOnItemClickListener(null);
    this.listView.setTranscriptMode(2);
    this.mBtn = ((Button)findViewById(2131296258));
    this.photoBtn = ((Button)findViewById(2131296262));
    this.lc = getResources().getConfiguration().locale.getLanguage();
    this.widthSize = getWindowManager().getDefaultDisplay().getWidth();
    this.mArray = Value.getInstance().mArrChatting;
    this.m_adapter = new MessageAdapter(this, 0, this.mArray, this.widthSize);
    this.listView.setAdapter(this.m_adapter);
    this.mlocManager = ((LocationManager)getSystemService("location"));
    this.oHandler = new Handler()
    {
      /* Error */
      public void handleMessage(Message arg1)
      {
        // Byte code:
        //   0: aload_1
        //   1: getfield 29	android/os/Message:what	I
        //   4: tableswitch	default:+292->296, 1:+32->36, 2:+111->115, 3:+178->182, 4:+198->202
        //   36: aload_0
        //   37: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   40: invokestatic 33	com/pioong/ChattingActivity:access$1	(Lcom/pioong/ChattingActivity;)Ljava/util/ArrayList;
        //   43: astore_1
        //   44: aload_1
        //   45: monitorenter
        //   46: aload_0
        //   47: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   50: invokestatic 33	com/pioong/ChattingActivity:access$1	(Lcom/pioong/ChattingActivity;)Ljava/util/ArrayList;
        //   53: invokevirtual 38	java/util/ArrayList:clear	()V
        //   56: aload_1
        //   57: monitorexit
        //   58: aload_0
        //   59: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   62: invokestatic 42	com/pioong/ChattingActivity:access$2	(Lcom/pioong/ChattingActivity;)Lcom/pioong/msgadapter/MessageAdapter;
        //   65: invokevirtual 45	com/pioong/msgadapter/MessageAdapter:clear	()V
        //   68: aload_0
        //   69: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   72: invokestatic 42	com/pioong/ChattingActivity:access$2	(Lcom/pioong/ChattingActivity;)Lcom/pioong/msgadapter/MessageAdapter;
        //   75: invokevirtual 48	com/pioong/msgadapter/MessageAdapter:clearCache	()V
        //   78: aload_0
        //   79: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   82: invokestatic 51	com/pioong/ChattingActivity:access$3	(Lcom/pioong/ChattingActivity;)Ljava/util/ArrayList;
        //   85: invokevirtual 38	java/util/ArrayList:clear	()V
        //   88: aload_0
        //   89: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   92: invokestatic 42	com/pioong/ChattingActivity:access$2	(Lcom/pioong/ChattingActivity;)Lcom/pioong/msgadapter/MessageAdapter;
        //   95: aload_0
        //   96: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   99: ldc 52
        //   101: invokevirtual 56	com/pioong/ChattingActivity:getString	(I)Ljava/lang/String;
        //   104: invokevirtual 60	com/pioong/msgadapter/MessageAdapter:addComment	(Ljava/lang/String;)V
        //   107: return
        //   108: astore_1
        //   109: return
        //   110: astore_2
        //   111: aload_1
        //   112: monitorexit
        //   113: aload_2
        //   114: athrow
        //   115: aload_1
        //   116: getfield 64	android/os/Message:obj	Ljava/lang/Object;
        //   119: checkcast 66	java/lang/String
        //   122: astore_1
        //   123: aload_0
        //   124: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   127: invokestatic 42	com/pioong/ChattingActivity:access$2	(Lcom/pioong/ChattingActivity;)Lcom/pioong/msgadapter/MessageAdapter;
        //   130: aload_1
        //   131: invokevirtual 60	com/pioong/msgadapter/MessageAdapter:addComment	(Ljava/lang/String;)V
        //   134: aload_0
        //   135: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   138: new 68	com/pioong/ChattingActivity$HeartbeatSender
        //   141: dup
        //   142: aload_0
        //   143: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   146: invokespecial 70	com/pioong/ChattingActivity$HeartbeatSender:<init>	(Lcom/pioong/ChattingActivity;)V
        //   149: putfield 74	com/pioong/ChattingActivity:hbThread	Lcom/pioong/ChattingActivity$HeartbeatSender;
        //   152: aload_0
        //   153: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   156: getfield 74	com/pioong/ChattingActivity:hbThread	Lcom/pioong/ChattingActivity$HeartbeatSender;
        //   159: invokevirtual 77	com/pioong/ChattingActivity$HeartbeatSender:start	()V
        //   162: aload_0
        //   163: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   166: invokevirtual 80	com/pioong/ChattingActivity:btnChange	()V
        //   169: aload_0
        //   170: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   173: invokestatic 84	com/pioong/ChattingActivity:access$4	(Lcom/pioong/ChattingActivity;)Landroid/widget/Button;
        //   176: ldc 85
        //   178: invokevirtual 91	android/widget/Button:setBackgroundResource	(I)V
        //   181: return
        //   182: aload_0
        //   183: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   186: invokestatic 42	com/pioong/ChattingActivity:access$2	(Lcom/pioong/ChattingActivity;)Lcom/pioong/msgadapter/MessageAdapter;
        //   189: aload_0
        //   190: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   193: ldc 92
        //   195: invokevirtual 56	com/pioong/ChattingActivity:getString	(I)Ljava/lang/String;
        //   198: invokevirtual 60	com/pioong/msgadapter/MessageAdapter:addComment	(Ljava/lang/String;)V
        //   201: return
        //   202: invokestatic 98	com/pioong/global/Value:getInstance	()Lcom/pioong/global/Value;
        //   205: invokevirtual 102	com/pioong/global/Value:isChatting	()Z
        //   208: ifeq +88 -> 296
        //   211: aload_0
        //   212: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   215: invokestatic 42	com/pioong/ChattingActivity:access$2	(Lcom/pioong/ChattingActivity;)Lcom/pioong/msgadapter/MessageAdapter;
        //   218: aload_0
        //   219: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   222: ldc 103
        //   224: invokevirtual 56	com/pioong/ChattingActivity:getString	(I)Ljava/lang/String;
        //   227: invokevirtual 60	com/pioong/msgadapter/MessageAdapter:addComment	(Ljava/lang/String;)V
        //   230: aload_0
        //   231: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   234: iconst_0
        //   235: putfield 107	com/pioong/ChattingActivity:bHavetoUpdate	Z
        //   238: aload_0
        //   239: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   242: getfield 74	com/pioong/ChattingActivity:hbThread	Lcom/pioong/ChattingActivity$HeartbeatSender;
        //   245: ifnull +21 -> 266
        //   248: aload_0
        //   249: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   252: getfield 74	com/pioong/ChattingActivity:hbThread	Lcom/pioong/ChattingActivity$HeartbeatSender;
        //   255: invokevirtual 110	com/pioong/ChattingActivity$HeartbeatSender:interrupt	()V
        //   258: aload_0
        //   259: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   262: aconst_null
        //   263: putfield 74	com/pioong/ChattingActivity:hbThread	Lcom/pioong/ChattingActivity$HeartbeatSender;
        //   266: invokestatic 98	com/pioong/global/Value:getInstance	()Lcom/pioong/global/Value;
        //   269: invokevirtual 113	com/pioong/global/Value:exitRoom	()V
        //   272: aload_0
        //   273: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   276: invokevirtual 80	com/pioong/ChattingActivity:btnChange	()V
        //   279: aload_0
        //   280: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   283: iconst_0
        //   284: putfield 116	com/pioong/ChattingActivity:bProcessing	Z
        //   287: aload_0
        //   288: getfield 15	com/pioong/ChattingActivity$1:this$0	Lcom/pioong/ChattingActivity;
        //   291: iconst_0
        //   292: putfield 119	com/pioong/ChattingActivity:lastRcvIndex	I
        //   295: return
        //   296: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	297	0	this	1
        //   110	4	2	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   0	36	108	java/lang/Exception
        //   36	46	108	java/lang/Exception
        //   58	107	108	java/lang/Exception
        //   113	115	108	java/lang/Exception
        //   115	181	108	java/lang/Exception
        //   182	201	108	java/lang/Exception
        //   202	266	108	java/lang/Exception
        //   266	295	108	java/lang/Exception
        //   46	58	110	finally
        //   111	113	110	finally
      }
    };
    Network.getInstance().findRoom(this, this.oHandler);
    this.mBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (Value.getInstance().isChatting())
        {
          Network.getInstance().exitRoom(ChattingActivity.this, ChattingActivity.this.oHandler);
          return;
        }
        Network.getInstance().findRoom(ChattingActivity.this, ChattingActivity.this.oHandler);
      }
    });
    registerForContextMenu(this.photoBtn);
    this.photoBtn.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener()
    {
      public void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        paramAnonymousContextMenu.setHeaderTitle(ChattingActivity.this.getString(2131034134));
        paramAnonymousContextMenu.add(0, 7, 1, ChattingActivity.this.getString(2131034141));
        paramAnonymousContextMenu.add(0, 8, 2, ChattingActivity.this.getString(2131034142));
      }
    });
    this.photoBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ChattingActivity.this.sendPhoto(ChattingActivity.this.photoBtn);
      }
    });
    this.photoBtn.setLongClickable(false);
  }
  
  protected void onDestroy()
  {
    Network.getInstance().exitChatting();
    if (this.m_adapter != null)
    {
      this.m_adapter.clear();
      this.m_adapter.clearCache();
      this.m_adapter = null;
    }
    this.oHandler = null;
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (Value.getInstance().isChatting()))
    {
      new AlertDialog.Builder(this).setMessage(getString(2131034117)).setPositiveButton(getString(2131034118), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          ChattingActivity.this.finish();
        }
      }).setNegativeButton(getString(2131034119), null).show();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    if (paramLocation != null) {
      Value.getInstance().setLocation(paramLocation);
    }
  }
  
  protected void onPause()
  {
    this.mlocManager.removeUpdates(this);
    if (this.hbThread != null)
    {
      this.hbThread.interrupt();
      this.hbThread = null;
    }
    if (this.tmThread != null)
    {
      this.tmThread.interrupt();
      this.tmThread = null;
    }
    super.onPause();
  }
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  protected void onResume()
  {
    super.onResume();
    try
    {
      this.mlocManager.requestLocationUpdates("network", 5000L, 0.0F, this);
      this.tmThread = new UpdateThread();
      this.tmThread.start();
      if (Value.getInstance().isChatting())
      {
        this.hbThread = new HeartbeatSender();
        this.hbThread.start();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  
  public int pxToDp(int paramInt)
  {
    float f = getResources().getDisplayMetrics().density;
    return (int)(paramInt / Float.valueOf(f).floatValue());
  }
  
  protected void resetNextAccess()
  {
    this.nextAccess = 0L;
  }
  
  public void sendMessage(View arg1)
  {
    if (!Value.getInstance().isChatting())
    {
      ??? = getString(2131034125);
      this.m_adapter.addComment(???);
    }
    Object localObject1;
    do
    {
      return;
      localObject1 = this.input.getText().toString();
    } while ((((String)localObject1).equals("")) || (localObject1 == null) || (((String)localObject1).trim().equals("")));
    String str = new ObjectId().toString();
    this.mArray.add(new ChatMessage(str, "T", (String)localObject1, "me", true));
    updateList();
    this.input.setText("");
    synchronized (this.mSendQueue)
    {
      localObject1 = new SendingMessage(str, (String)localObject1);
      this.mSendQueue.add(localObject1);
      return;
    }
  }
  
  public void sendPhoto(View paramView)
  {
    if (!Value.getInstance().isChatting()) {}
    try
    {
      paramView = getString(2131034125);
      this.m_adapter.addComment(paramView);
      return;
    }
    catch (Exception paramView) {}
    openContextMenu(paramView);
    return;
  }
  
  public void setClipboard(String paramString)
  {
    this.clipboard = paramString;
  }
  
  public void setFailedCM(ChatMessage paramChatMessage)
  {
    this.failedCM = paramChatMessage;
  }
  
  public void showGallery()
  {
    Intent localIntent = new Intent();
    localIntent.setType("image/*");
    localIntent.setAction("android.intent.action.GET_CONTENT");
    startActivityForResult(localIntent, 1);
  }
  
  public void takePhoto()
  {
    startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE"), 2);
  }
  
  public void updateList()
  {
    try
    {
      this.m_adapter.notifyDataSetChanged();
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void updateNextAccess()
  {
    this.nextAccess = (System.currentTimeMillis() + 10000L);
  }
  
  public void uploadImage(String paramString1, final String paramString2, int paramInt1, int paramInt2)
  {
    paramString1 = getResizedImage(paramString1);
    new FileUpload(new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default: 
          return;
        }
        try
        {
          paramAnonymousMessage = ChattingActivity.this.m_adapter.getSentMessage(paramString2);
          if (paramAnonymousMessage != null) {
            paramAnonymousMessage.setSType("OK");
          }
        }
        catch (Exception paramAnonymousMessage)
        {
          for (;;) {}
        }
        ChattingActivity.this.resetNextAccess();
        ChattingActivity.this.updateList();
        return;
        try
        {
          paramAnonymousMessage = ChattingActivity.this.m_adapter.getSentMessage(paramString2);
          if (paramAnonymousMessage != null) {
            paramAnonymousMessage.setSType("FAIL");
          }
        }
        catch (Exception paramAnonymousMessage)
        {
          for (;;) {}
        }
        ChattingActivity.this.resetNextAccess();
        ChattingActivity.this.updateList();
      }
    }, Network.URL_UPLOAD_IMAGE, paramString1, Value.getInstance().getSID(), Value.getInstance().getRoomNo(), paramString2, paramInt1, paramInt2);
  }
  
  public class HeartbeatSender
    extends Thread
  {
    byte HB = 0;
    private String ip = Value.getInstance().getIP();
    private long nextTime = 0L;
    private int port = 5434;
    ByteBuffer sb;
    DatagramSocket udp;
    
    HeartbeatSender() {}
    
    public void close()
    {
      if (this.udp != null)
      {
        this.udp.close();
        this.udp = null;
      }
    }
    
    protected ByteBuffer getByteBuffer()
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(100);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      return localByteBuffer;
    }
    
    protected void putString(ByteBuffer paramByteBuffer, String paramString)
    {
      try
      {
        paramByteBuffer.put(paramString.getBytes("UTF-8"));
        paramByteBuffer.put((byte)0);
        return;
      }
      catch (Exception paramByteBuffer) {}
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 100	com/pioong/ChattingActivity$HeartbeatSender:isInterrupted	()Z
      //   4: ifeq +8 -> 12
      //   7: aload_0
      //   8: invokevirtual 101	com/pioong/ChattingActivity$HeartbeatSender:close	()V
      //   11: return
      //   12: aload_0
      //   13: getfield 103	com/pioong/ChattingActivity$HeartbeatSender:sb	Ljava/nio/ByteBuffer;
      //   16: astore 6
      //   18: aload 6
      //   20: ifnonnull +37 -> 57
      //   23: aload_0
      //   24: aload_0
      //   25: invokevirtual 105	com/pioong/ChattingActivity$HeartbeatSender:getByteBuffer	()Ljava/nio/ByteBuffer;
      //   28: putfield 103	com/pioong/ChattingActivity$HeartbeatSender:sb	Ljava/nio/ByteBuffer;
      //   31: aload_0
      //   32: getfield 103	com/pioong/ChattingActivity$HeartbeatSender:sb	Ljava/nio/ByteBuffer;
      //   35: aload_0
      //   36: getfield 46	com/pioong/ChattingActivity$HeartbeatSender:HB	B
      //   39: invokevirtual 91	java/nio/ByteBuffer:put	(B)Ljava/nio/ByteBuffer;
      //   42: pop
      //   43: aload_0
      //   44: aload_0
      //   45: getfield 103	com/pioong/ChattingActivity$HeartbeatSender:sb	Ljava/nio/ByteBuffer;
      //   48: invokestatic 34	com/pioong/global/Value:getInstance	()Lcom/pioong/global/Value;
      //   51: invokevirtual 108	com/pioong/global/Value:getSID	()Ljava/lang/String;
      //   54: invokevirtual 110	com/pioong/ChattingActivity$HeartbeatSender:putString	(Ljava/nio/ByteBuffer;Ljava/lang/String;)V
      //   57: aload_0
      //   58: getfield 50	com/pioong/ChattingActivity$HeartbeatSender:udp	Ljava/net/DatagramSocket;
      //   61: astore 6
      //   63: aload 6
      //   65: ifnonnull +24 -> 89
      //   68: aload_0
      //   69: new 52	java/net/DatagramSocket
      //   72: dup
      //   73: invokespecial 111	java/net/DatagramSocket:<init>	()V
      //   76: putfield 50	com/pioong/ChattingActivity$HeartbeatSender:udp	Ljava/net/DatagramSocket;
      //   79: aload_0
      //   80: getfield 50	com/pioong/ChattingActivity$HeartbeatSender:udp	Ljava/net/DatagramSocket;
      //   83: sipush 300
      //   86: invokevirtual 115	java/net/DatagramSocket:setSoTimeout	(I)V
      //   89: aload_0
      //   90: getfield 44	com/pioong/ChattingActivity$HeartbeatSender:nextTime	J
      //   93: lstore_2
      //   94: invokestatic 121	java/lang/System:currentTimeMillis	()J
      //   97: lstore 4
      //   99: lload_2
      //   100: lload 4
      //   102: lcmp
      //   103: ifge +50 -> 153
      //   106: new 123	java/net/DatagramPacket
      //   109: dup
      //   110: aload_0
      //   111: getfield 103	com/pioong/ChattingActivity$HeartbeatSender:sb	Ljava/nio/ByteBuffer;
      //   114: invokevirtual 127	java/nio/ByteBuffer:array	()[B
      //   117: aload_0
      //   118: getfield 103	com/pioong/ChattingActivity$HeartbeatSender:sb	Ljava/nio/ByteBuffer;
      //   121: invokevirtual 131	java/nio/ByteBuffer:position	()I
      //   124: aload_0
      //   125: getfield 40	com/pioong/ChattingActivity$HeartbeatSender:ip	Ljava/lang/String;
      //   128: invokestatic 137	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
      //   131: aload_0
      //   132: getfield 42	com/pioong/ChattingActivity$HeartbeatSender:port	I
      //   135: invokespecial 140	java/net/DatagramPacket:<init>	([BILjava/net/InetAddress;I)V
      //   138: astore 6
      //   140: aload_0
      //   141: getfield 50	com/pioong/ChattingActivity$HeartbeatSender:udp	Ljava/net/DatagramSocket;
      //   144: aload 6
      //   146: invokevirtual 144	java/net/DatagramSocket:send	(Ljava/net/DatagramPacket;)V
      //   149: aload_0
      //   150: invokevirtual 147	com/pioong/ChattingActivity$HeartbeatSender:updateNextTime	()V
      //   153: bipush 100
      //   155: newarray <illegal type>
      //   157: astore 6
      //   159: new 123	java/net/DatagramPacket
      //   162: dup
      //   163: aload 6
      //   165: aload 6
      //   167: arraylength
      //   168: invokespecial 150	java/net/DatagramPacket:<init>	([BI)V
      //   171: astore 6
      //   173: aload_0
      //   174: getfield 50	com/pioong/ChattingActivity$HeartbeatSender:udp	Ljava/net/DatagramSocket;
      //   177: aload 6
      //   179: invokevirtual 153	java/net/DatagramSocket:receive	(Ljava/net/DatagramPacket;)V
      //   182: iconst_1
      //   183: istore_1
      //   184: iload_1
      //   185: ifeq -185 -> 0
      //   188: aload_0
      //   189: getfield 25	com/pioong/ChattingActivity$HeartbeatSender:this$0	Lcom/pioong/ChattingActivity;
      //   192: iconst_1
      //   193: putfield 157	com/pioong/ChattingActivity:bHavetoUpdate	Z
      //   196: ldc2_w 158
      //   199: invokestatic 163	java/lang/Thread:sleep	(J)V
      //   202: goto -202 -> 0
      //   205: astore 6
      //   207: aload_0
      //   208: invokevirtual 166	com/pioong/ChattingActivity$HeartbeatSender:interrupt	()V
      //   211: return
      //   212: astore 6
      //   214: aload 6
      //   216: invokevirtual 169	java/lang/Exception:printStackTrace	()V
      //   219: goto -162 -> 57
      //   222: astore 6
      //   224: aload 6
      //   226: invokevirtual 170	java/net/SocketException:printStackTrace	()V
      //   229: goto -140 -> 89
      //   232: astore 6
      //   234: iconst_0
      //   235: istore_1
      //   236: goto -52 -> 184
      //   239: astore 6
      //   241: goto -92 -> 149
      //   244: astore 6
      //   246: goto -246 -> 0
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	249	0	this	HeartbeatSender
      //   183	53	1	i	int
      //   93	7	2	l1	long
      //   97	4	4	l2	long
      //   16	162	6	localObject	Object
      //   205	1	6	localInterruptedException	InterruptedException
      //   212	3	6	localException1	Exception
      //   222	3	6	localSocketException	java.net.SocketException
      //   232	1	6	localException2	Exception
      //   239	1	6	localException3	Exception
      //   244	1	6	localException4	Exception
      // Exception table:
      //   from	to	target	type
      //   12	18	205	java/lang/InterruptedException
      //   23	57	205	java/lang/InterruptedException
      //   57	63	205	java/lang/InterruptedException
      //   68	89	205	java/lang/InterruptedException
      //   89	99	205	java/lang/InterruptedException
      //   106	149	205	java/lang/InterruptedException
      //   149	153	205	java/lang/InterruptedException
      //   153	173	205	java/lang/InterruptedException
      //   173	182	205	java/lang/InterruptedException
      //   188	202	205	java/lang/InterruptedException
      //   214	219	205	java/lang/InterruptedException
      //   224	229	205	java/lang/InterruptedException
      //   23	57	212	java/lang/Exception
      //   68	89	222	java/net/SocketException
      //   173	182	232	java/lang/Exception
      //   106	149	239	java/lang/Exception
      //   12	18	244	java/lang/Exception
      //   57	63	244	java/lang/Exception
      //   68	89	244	java/lang/Exception
      //   89	99	244	java/lang/Exception
      //   149	153	244	java/lang/Exception
      //   153	173	244	java/lang/Exception
      //   188	202	244	java/lang/Exception
      //   214	219	244	java/lang/Exception
      //   224	229	244	java/lang/Exception
    }
    
    protected void updateNextTime()
    {
      this.nextTime = (System.currentTimeMillis() + 10000L);
    }
  }
  
  public class Thumnail
  {
    public int mHeight = 0;
    public int mWidth = 0;
    
    public Thumnail() {}
    
    public Bitmap getThumImage(String paramString)
    {
      Object localObject = new BitmapFactory.Options();
      int i = ChattingActivity.getBitmapOfWidth(paramString);
      int j = ChattingActivity.getBitmapOfHeight(paramString);
      label42:
      float f2;
      float f1;
      if (i >= j)
      {
        if (i > 1024) {
          break label236;
        }
        ((BitmapFactory.Options)localObject).inSampleSize = 1;
        ((BitmapFactory.Options)localObject).inPurgeable = true;
        localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        f2 = ((Bitmap)localObject).getWidth();
        f1 = ((Bitmap)localObject).getHeight();
        if (f2 < f1) {
          break label280;
        }
        i = ChattingActivity.this.dpToPx(80);
        label87:
        float f3 = f2 / 100.0F;
        f3 = i / f3;
        f2 *= f3 / 100.0F;
        f1 *= f3 / 100.0F;
        this.mWidth = ((int)f2);
        this.mHeight = ((int)f1);
        j = 0;
      }
      try
      {
        i = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
        j = i;
      }
      catch (IOException paramString)
      {
        for (;;) {}
      }
      i = 0;
      if (j == 6)
      {
        i = 90;
        this.mWidth = ((int)f1);
        this.mHeight = ((int)f2);
      }
      for (;;)
      {
        paramString = new Matrix();
        paramString.postRotate(i);
        localObject = Bitmap.createScaledBitmap((Bitmap)localObject, (int)f2, (int)f1, true);
        return ChattingActivity.getRoundedCornerBitmap(Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), paramString, true));
        i = j;
        break;
        label236:
        if (i <= 2048)
        {
          ((BitmapFactory.Options)localObject).inSampleSize = 2;
          break label42;
        }
        if (i <= 4096)
        {
          ((BitmapFactory.Options)localObject).inSampleSize = 4;
          break label42;
        }
        ((BitmapFactory.Options)localObject).inSampleSize = 8;
        break label42;
        label280:
        i = ChattingActivity.this.dpToPx(60);
        break label87;
        if (j == 3)
        {
          i = 180;
        }
        else if (j == 8)
        {
          i = 270;
          this.mWidth = ((int)f1);
          this.mHeight = ((int)f2);
        }
      }
    }
  }
  
  protected class UpdateSendMsg
    implements Runnable
  {
    ChatMessage cMsg;
    ChatMessage imgCm;
    ArrayList<ChatMessage> tmp = new ArrayList();
    
    UpdateSendMsg(ChatMessage paramChatMessage)
    {
      this.cMsg = paramChatMessage;
    }
    
    public void run()
    {
      ChattingActivity.this.bProcessing = true;
      int i = ChattingActivity.this.mArray.size() - 1;
      for (;;)
      {
        if (i < 0)
        {
          label25:
          ChattingActivity.this.mArray.add(this.cMsg);
          if (ChattingActivity.this.mArray.size() > 200) {
            ChattingActivity.this.mArray.remove(0);
          }
          if (!this.cMsg.getWho().equals("you")) {}
        }
        try
        {
          ((Vibrator)ChattingActivity.this.getSystemService("vibrator")).vibrate(20L);
          i = 0;
          for (;;)
          {
            if (i >= this.tmp.size())
            {
              ChattingActivity.this.lastRcvIndex = this.cMsg.getIndex();
              if (ChattingActivity.this.m_adapter != null) {
                ChattingActivity.this.m_adapter.notifyDataSetChanged();
              }
              ChattingActivity.this.bProcessing = false;
              return;
              if (ChattingActivity.this.mArray.size() <= i) {
                break label25;
              }
              ChatMessage localChatMessage = (ChatMessage)ChattingActivity.this.mArray.get(i);
              if (!localChatMessage.isTemp()) {
                if (this.cMsg.getIndex() == localChatMessage.getIndex()) {
                  ChattingActivity.this.mArray.remove(i);
                }
              }
              for (;;)
              {
                i -= 1;
                break;
                ChattingActivity.this.mArray.remove(i);
                if (!localChatMessage.getSType().equals("OK")) {
                  this.tmp.add(localChatMessage);
                }
              }
            }
            ChattingActivity.this.mArray.add((ChatMessage)this.tmp.get(i));
            if (ChattingActivity.this.mArray.size() > 200) {
              ChattingActivity.this.mArray.remove(0);
            }
            i += 1;
          }
        }
        catch (Exception localException)
        {
          for (;;) {}
        }
      }
    }
  }
  
  private class UpdateThread
    extends Thread
  {
    Handler h = new Handler();
    
    UpdateThread() {}
    
    public void getRcvMessages()
    {
      if (ChattingActivity.this.bProcessing) {}
      for (;;)
      {
        return;
        ChattingActivity.this.updateNextAccess();
        Object localObject1 = Network.URL_RECEIVE;
        Object localObject2 = new ArrayList();
        ((List)localObject2).add(new BasicNameValuePair("sid", Value.getInstance().getSID()));
        ((List)localObject2).add(new BasicNameValuePair("idx", Integer.toString(ChattingActivity.this.lastRcvIndex)));
        ((List)localObject2).add(new BasicNameValuePair("room", Value.getInstance().getRoomNo()));
        try
        {
          localObject2 = new UrlEncodedFormEntity((List)localObject2, "UTF-8");
          String str1 = HttpConnection.post2((String)localObject1, (UrlEncodedFormEntity)localObject2);
          ArrayList localArrayList = new ArrayList();
          try
          {
            JSONArray localJSONArray = new JSONArray(str1);
            int i = 0;
            for (;;)
            {
              if (i >= localJSONArray.length())
              {
                Collections.sort(localArrayList, new CustomComparator());
                i = 0;
                while (i < localArrayList.size())
                {
                  localObject1 = (ChatMessage)localArrayList.get(i);
                  ChattingActivity.this.runOnUiThread(new ChattingActivity.UpdateSendMsg(ChattingActivity.this, (ChatMessage)localObject1));
                  i += 1;
                }
              }
              JSONObject localJSONObject = localJSONArray.getJSONObject(i);
              String str2 = localJSONObject.getString("mid");
              String str3 = localJSONObject.getString("ty").toUpperCase();
              String str4 = localJSONObject.getString("msg");
              long l = Long.parseLong(localJSONObject.getString("date"));
              String str5 = new SimpleDateFormat(ChattingActivity.this.getString(2131034133)).format(new Date(l));
              String str6 = localJSONObject.getString("who").toLowerCase();
              int m = localJSONObject.getInt("idx");
              localObject1 = "";
              for (;;)
              {
                try
                {
                  localObject2 = localJSONObject.getString("img");
                  localObject1 = localObject2;
                }
                catch (Exception localException5)
                {
                  int j;
                  int k;
                  continue;
                }
                try
                {
                  j = ChattingActivity.this.dpToPx(localJSONObject.getInt("w"));
                  k = ChattingActivity.this.dpToPx(localJSONObject.getInt("h"));
                  localArrayList.add(new ChatMessage(str2, str3, str4, (String)localObject1, str5, str6, m, j, k));
                  i += 1;
                }
                catch (Exception localException4)
                {
                  j = 0;
                  k = 0;
                }
              }
            }
          }
          catch (Exception localException1)
          {
            try
            {
              if ((!new JSONObject(str1).getString("res").equals("-77")) || (ChattingActivity.this.oHandler == null)) {
                continue;
              }
              ChattingActivity.this.oHandler.sendEmptyMessage(4);
              return;
            }
            catch (Exception localException2) {}
          }
          return;
        }
        catch (Exception localException3) {}
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 229	com/pioong/ChattingActivity$UpdateThread:isInterrupted	()Z
      //   4: ifeq +4 -> 8
      //   7: return
      //   8: invokestatic 60	com/pioong/global/Value:getInstance	()Lcom/pioong/global/Value;
      //   11: invokevirtual 232	com/pioong/global/Value:isChatting	()Z
      //   14: ifeq +13 -> 27
      //   17: aload_0
      //   18: getfield 20	com/pioong/ChattingActivity$UpdateThread:this$0	Lcom/pioong/ChattingActivity;
      //   21: getfield 38	com/pioong/ChattingActivity:bProcessing	Z
      //   24: ifeq +18 -> 42
      //   27: ldc2_w 233
      //   30: invokestatic 237	java/lang/Thread:sleep	(J)V
      //   33: goto -33 -> 0
      //   36: astore_2
      //   37: aload_0
      //   38: invokevirtual 240	com/pioong/ChattingActivity$UpdateThread:interrupt	()V
      //   41: return
      //   42: aload_0
      //   43: getfield 20	com/pioong/ChattingActivity$UpdateThread:this$0	Lcom/pioong/ChattingActivity;
      //   46: invokestatic 244	com/pioong/ChattingActivity:access$1	(Lcom/pioong/ChattingActivity;)Ljava/util/ArrayList;
      //   49: astore_2
      //   50: aload_2
      //   51: monitorenter
      //   52: iconst_0
      //   53: istore_1
      //   54: iload_1
      //   55: aload_0
      //   56: getfield 20	com/pioong/ChattingActivity$UpdateThread:this$0	Lcom/pioong/ChattingActivity;
      //   59: invokestatic 244	com/pioong/ChattingActivity:access$1	(Lcom/pioong/ChattingActivity;)Ljava/util/ArrayList;
      //   62: invokevirtual 124	java/util/ArrayList:size	()I
      //   65: if_icmplt +58 -> 123
      //   68: aload_2
      //   69: monitorexit
      //   70: aload_0
      //   71: getfield 20	com/pioong/ChattingActivity$UpdateThread:this$0	Lcom/pioong/ChattingActivity;
      //   74: invokevirtual 247	com/pioong/ChattingActivity:needToUpdate	()Z
      //   77: ifeq +11 -> 88
      //   80: aload_0
      //   81: getfield 20	com/pioong/ChattingActivity$UpdateThread:this$0	Lcom/pioong/ChattingActivity;
      //   84: iconst_1
      //   85: putfield 250	com/pioong/ChattingActivity:bHavetoUpdate	Z
      //   88: aload_0
      //   89: getfield 20	com/pioong/ChattingActivity$UpdateThread:this$0	Lcom/pioong/ChattingActivity;
      //   92: getfield 250	com/pioong/ChattingActivity:bHavetoUpdate	Z
      //   95: ifeq +15 -> 110
      //   98: aload_0
      //   99: getfield 20	com/pioong/ChattingActivity$UpdateThread:this$0	Lcom/pioong/ChattingActivity;
      //   102: iconst_0
      //   103: putfield 250	com/pioong/ChattingActivity:bHavetoUpdate	Z
      //   106: aload_0
      //   107: invokevirtual 252	com/pioong/ChattingActivity$UpdateThread:getRcvMessages	()V
      //   110: ldc2_w 233
      //   113: invokestatic 237	java/lang/Thread:sleep	(J)V
      //   116: goto -116 -> 0
      //   119: astore_2
      //   120: goto -120 -> 0
      //   123: aload_0
      //   124: getfield 20	com/pioong/ChattingActivity$UpdateThread:this$0	Lcom/pioong/ChattingActivity;
      //   127: invokestatic 244	com/pioong/ChattingActivity:access$1	(Lcom/pioong/ChattingActivity;)Ljava/util/ArrayList;
      //   130: iload_1
      //   131: invokevirtual 128	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   134: checkcast 254	com/pioong/msgadapter/SendingMessage
      //   137: astore_3
      //   138: getstatic 257	com/pioong/global/Network:URL_SENDMSG	Ljava/lang/String;
      //   141: astore 4
      //   143: new 49	java/util/ArrayList
      //   146: dup
      //   147: invokespecial 50	java/util/ArrayList:<init>	()V
      //   150: astore 5
      //   152: aload 5
      //   154: new 52	org/apache/http/message/BasicNameValuePair
      //   157: dup
      //   158: ldc 54
      //   160: invokestatic 60	com/pioong/global/Value:getInstance	()Lcom/pioong/global/Value;
      //   163: invokevirtual 64	com/pioong/global/Value:getSID	()Ljava/lang/String;
      //   166: invokespecial 67	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   169: invokeinterface 73 2 0
      //   174: pop
      //   175: aload 5
      //   177: new 52	org/apache/http/message/BasicNameValuePair
      //   180: dup
      //   181: ldc 87
      //   183: invokestatic 60	com/pioong/global/Value:getInstance	()Lcom/pioong/global/Value;
      //   186: invokevirtual 90	com/pioong/global/Value:getRoomNo	()Ljava/lang/String;
      //   189: invokespecial 67	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   192: invokeinterface 73 2 0
      //   197: pop
      //   198: aload 5
      //   200: new 52	org/apache/http/message/BasicNameValuePair
      //   203: dup
      //   204: ldc -96
      //   206: aload_3
      //   207: invokevirtual 260	com/pioong/msgadapter/SendingMessage:getMsg	()Ljava/lang/String;
      //   210: invokespecial 67	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   213: invokeinterface 73 2 0
      //   218: pop
      //   219: aload 5
      //   221: new 52	org/apache/http/message/BasicNameValuePair
      //   224: dup
      //   225: ldc -111
      //   227: aload_3
      //   228: invokevirtual 263	com/pioong/msgadapter/SendingMessage:getID	()Ljava/lang/String;
      //   231: invokespecial 67	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   234: invokeinterface 73 2 0
      //   239: pop
      //   240: new 92	org/apache/http/client/entity/UrlEncodedFormEntity
      //   243: dup
      //   244: aload 5
      //   246: ldc 94
      //   248: invokespecial 97	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
      //   251: astore 5
      //   253: aload 4
      //   255: aload 5
      //   257: invokestatic 103	com/pioong/asynchttp/HttpConnection:post2	(Ljava/lang/String;Lorg/apache/http/client/entity/UrlEncodedFormEntity;)Ljava/lang/String;
      //   260: ifnonnull +80 -> 340
      //   263: aload_0
      //   264: getfield 20	com/pioong/ChattingActivity$UpdateThread:this$0	Lcom/pioong/ChattingActivity;
      //   267: invokestatic 267	com/pioong/ChattingActivity:access$2	(Lcom/pioong/ChattingActivity;)Lcom/pioong/msgadapter/MessageAdapter;
      //   270: aload_3
      //   271: invokevirtual 263	com/pioong/msgadapter/SendingMessage:getID	()Ljava/lang/String;
      //   274: invokevirtual 273	com/pioong/msgadapter/MessageAdapter:getSentMessage	(Ljava/lang/String;)Lcom/pioong/msgadapter/ChatMessage;
      //   277: astore_3
      //   278: aload_3
      //   279: ifnull +10 -> 289
      //   282: aload_3
      //   283: ldc_w 275
      //   286: invokevirtual 278	com/pioong/msgadapter/ChatMessage:setSType	(Ljava/lang/String;)V
      //   289: aload_0
      //   290: getfield 20	com/pioong/ChattingActivity$UpdateThread:this$0	Lcom/pioong/ChattingActivity;
      //   293: invokevirtual 281	com/pioong/ChattingActivity:resetNextAccess	()V
      //   296: aload_0
      //   297: getfield 28	com/pioong/ChattingActivity$UpdateThread:h	Landroid/os/Handler;
      //   300: new 9	com/pioong/ChattingActivity$UpdateThread$1
      //   303: dup
      //   304: aload_0
      //   305: invokespecial 282	com/pioong/ChattingActivity$UpdateThread$1:<init>	(Lcom/pioong/ChattingActivity$UpdateThread;)V
      //   308: invokevirtual 286	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   311: pop
      //   312: aload_0
      //   313: getfield 20	com/pioong/ChattingActivity$UpdateThread:this$0	Lcom/pioong/ChattingActivity;
      //   316: invokestatic 244	com/pioong/ChattingActivity:access$1	(Lcom/pioong/ChattingActivity;)Ljava/util/ArrayList;
      //   319: iload_1
      //   320: invokevirtual 289	java/util/ArrayList:remove	(I)Ljava/lang/Object;
      //   323: pop
      //   324: iload_1
      //   325: iconst_1
      //   326: iadd
      //   327: istore_1
      //   328: goto -274 -> 54
      //   331: astore_3
      //   332: aload_2
      //   333: monitorexit
      //   334: return
      //   335: astore_3
      //   336: aload_2
      //   337: monitorexit
      //   338: aload_3
      //   339: athrow
      //   340: aload_0
      //   341: getfield 20	com/pioong/ChattingActivity$UpdateThread:this$0	Lcom/pioong/ChattingActivity;
      //   344: invokestatic 267	com/pioong/ChattingActivity:access$2	(Lcom/pioong/ChattingActivity;)Lcom/pioong/msgadapter/MessageAdapter;
      //   347: aload_3
      //   348: invokevirtual 263	com/pioong/msgadapter/SendingMessage:getID	()Ljava/lang/String;
      //   351: invokevirtual 273	com/pioong/msgadapter/MessageAdapter:getSentMessage	(Ljava/lang/String;)Lcom/pioong/msgadapter/ChatMessage;
      //   354: astore_3
      //   355: aload_3
      //   356: ifnull -67 -> 289
      //   359: aload_3
      //   360: ldc_w 291
      //   363: invokevirtual 278	com/pioong/msgadapter/ChatMessage:setSType	(Ljava/lang/String;)V
      //   366: aload_3
      //   367: new 170	java/text/SimpleDateFormat
      //   370: dup
      //   371: aload_0
      //   372: getfield 20	com/pioong/ChattingActivity$UpdateThread:this$0	Lcom/pioong/ChattingActivity;
      //   375: ldc -85
      //   377: invokevirtual 173	com/pioong/ChattingActivity:getString	(I)Ljava/lang/String;
      //   380: invokespecial 174	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
      //   383: new 176	java/util/Date
      //   386: dup
      //   387: invokespecial 292	java/util/Date:<init>	()V
      //   390: invokevirtual 183	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
      //   393: invokevirtual 295	com/pioong/msgadapter/ChatMessage:setTime	(Ljava/lang/String;)V
      //   396: goto -107 -> 289
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	399	0	this	UpdateThread
      //   53	275	1	i	int
      //   36	1	2	localInterruptedException	InterruptedException
      //   49	20	2	localArrayList	ArrayList
      //   119	218	2	localException1	Exception
      //   137	146	3	localObject1	Object
      //   331	1	3	localException2	Exception
      //   335	13	3	localObject2	Object
      //   354	13	3	localChatMessage	ChatMessage
      //   141	113	4	str	String
      //   150	106	5	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   8	27	36	java/lang/InterruptedException
      //   27	33	36	java/lang/InterruptedException
      //   42	52	36	java/lang/InterruptedException
      //   70	88	36	java/lang/InterruptedException
      //   88	110	36	java/lang/InterruptedException
      //   110	116	36	java/lang/InterruptedException
      //   338	340	36	java/lang/InterruptedException
      //   8	27	119	java/lang/Exception
      //   27	33	119	java/lang/Exception
      //   42	52	119	java/lang/Exception
      //   70	88	119	java/lang/Exception
      //   88	110	119	java/lang/Exception
      //   110	116	119	java/lang/Exception
      //   338	340	119	java/lang/Exception
      //   240	253	331	java/lang/Exception
      //   54	70	335	finally
      //   123	240	335	finally
      //   240	253	335	finally
      //   253	278	335	finally
      //   282	289	335	finally
      //   289	324	335	finally
      //   332	334	335	finally
      //   336	338	335	finally
      //   340	355	335	finally
      //   359	396	335	finally
    }
    
    public class CustomComparator
      implements Comparator<ChatMessage>
    {
      public CustomComparator() {}
      
      public int compare(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
      {
        return paramChatMessage1.getStringIdx().compareTo(paramChatMessage2.getStringIdx());
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/ChattingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */