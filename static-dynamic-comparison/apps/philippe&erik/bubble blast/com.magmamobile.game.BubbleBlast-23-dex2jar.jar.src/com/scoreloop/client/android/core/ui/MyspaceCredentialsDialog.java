package com.scoreloop.client.android.core.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.scoreloop.client.android.core.utils.HTTPUtils;
import com.scoreloop.client.android.core.utils.Logger;
import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.http.client.ClientProtocolException;

public class MyspaceCredentialsDialog
  extends ScoreloopCustomDialog
{
  private MyspaceCredentialsListener a;
  
  public MyspaceCredentialsDialog(Context paramContext, MyspaceCredentialsListener paramMyspaceCredentialsListener)
  {
    super(paramContext);
    this.a = paramMyspaceCredentialsListener;
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
  }
  
  protected void onStart()
  {
    super.onStart();
    int i = Color.rgb(25, 70, 155);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundColor(i);
    localLinearLayout.setGravity(17);
    final Object localObject1 = null;
    try
    {
      localObject2 = BitmapFactory.decodeStream(HTTPUtils.a("http://community.scoreloop.com/images/myspace/android_login.png"));
      localObject1 = localObject2;
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      for (;;)
      {
        Object localObject2;
        final EditText localEditText;
        TextView localTextView;
        Button localButton;
        Logger.a("could not load background for myspace credentials dialog...");
        localClientProtocolException.printStackTrace();
      }
    }
    catch (URISyntaxException localURISyntaxException)
    {
      throw new IllegalStateException(localURISyntaxException);
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Logger.a("could not load background for myspace credentials dialog...");
        localIOException.printStackTrace();
      }
    }
    localObject2 = new ImageView(getContext());
    if (localObject1 != null) {
      ((ImageView)localObject2).setImageBitmap(a((Bitmap)localObject1, 209, 53));
    }
    setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        MyspaceCredentialsDialog.a(MyspaceCredentialsDialog.this).a();
      }
    });
    setCanceledOnTouchOutside(true);
    setCancelable(true);
    localObject1 = new EditText(getContext());
    ((EditText)localObject1).setWidth(150);
    ((EditText)localObject1).setHint("E-Mail");
    localEditText = new EditText(getContext());
    localEditText.setWidth(150);
    localEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
    localEditText.setHint("Password");
    localTextView = new TextView(getContext());
    localTextView.setText("Connect MySpace with this app to find your friends and post stories to MySpace");
    localTextView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localTextView.setBackgroundColor(i);
    localTextView.setSingleLine(false);
    localButton = new Button(getContext());
    localButton.setWidth(60);
    localButton.setText("Login");
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MyspaceCredentialsDialog.a(MyspaceCredentialsDialog.this).a(localObject1.getText().toString(), localEditText.getText().toString());
      }
    });
    localLinearLayout.addView((View)localObject2);
    localLinearLayout.addView((View)localObject1);
    localLinearLayout.addView(localEditText);
    localLinearLayout.addView(localButton);
    localLinearLayout.addView(localTextView);
    localLinearLayout.setPadding(50, 100, 50, 50);
    setContentView(localLinearLayout);
  }
  
  public static abstract interface MyspaceCredentialsListener
  {
    public abstract void a();
    
    public abstract void a(String paramString1, String paramString2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/ui/MyspaceCredentialsDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */