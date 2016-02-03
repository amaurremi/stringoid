package com.ideashower.readitlater.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ideashower.readitlater.util.l;
import com.ideashower.readitlater.views.gallery.ImageViewer;
import com.ideashower.readitlater.views.gallery.i;
import org.codehaus.jackson.node.ObjectNode;

public class ImageViewerActivity
  extends a
  implements i
{
  private RelativeLayout A;
  private ImageButton B;
  private ImageButton C;
  private TextView D;
  private String E;
  private ImageViewer z;
  
  private void E()
  {
    Animation localAnimation = this.A.getAnimation();
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    F();
    this.A.setVisibility(0);
  }
  
  private void F()
  {
    Object localObject = this.z.getCurrentImage();
    if (localObject != null) {}
    for (localObject = ((com.ideashower.readitlater.e.a)localObject).d();; localObject = null)
    {
      if (localObject != null)
      {
        this.D.setText((CharSequence)localObject);
        this.D.setVisibility(0);
      }
      for (;;)
      {
        H();
        return;
        this.D.setText(null);
        this.D.setVisibility(8);
      }
    }
  }
  
  private void G()
  {
    if (this.A.getVisibility() == 8) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(600L);
    localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        ImageViewerActivity.b(ImageViewerActivity.this).setVisibility(8);
        ImageViewerActivity.b(ImageViewerActivity.this).setAnimation(null);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.A.startAnimation(localAlphaAnimation);
  }
  
  private void H()
  {
    this.B.setEnabled(this.z.b(-1));
    this.C.setEnabled(this.z.b(1));
  }
  
  public static void a(Activity paramActivity, ObjectNode paramObjectNode, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, ImageViewerActivity.class);
    localIntent.putExtra("com.ideashower.readitlater.extras.images", paramObjectNode.toString());
    localIntent.putExtra("com.ideashower.readitlater.extras.start_image", paramInt);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130968580, 0);
  }
  
  private void a(Bundle paramBundle)
  {
    int k = 1;
    String str = null;
    int i = 0;
    Object localObject = getIntent();
    if (localObject != null)
    {
      str = ((Intent)localObject).getStringExtra("com.ideashower.readitlater.extras.images");
      i = ((Intent)localObject).getIntExtra("com.ideashower.readitlater.extras.start_image", 1);
    }
    int j = i;
    localObject = str;
    if (str == null)
    {
      j = i;
      localObject = str;
      if (paramBundle != null)
      {
        localObject = paramBundle.getString("com.ideashower.readitlater.extras.images");
        j = paramBundle.getInt("com.ideashower.readitlater.extras.start_image", 1);
      }
    }
    if (localObject == null)
    {
      finish();
      return;
    }
    if (j < 1) {}
    for (i = k;; i = j)
    {
      paramBundle = l.a((String)localObject);
      if (paramBundle == null)
      {
        finish();
        return;
      }
      this.z.a(paramBundle, i);
      this.E = ((String)localObject);
      return;
    }
  }
  
  public void C()
  {
    F();
  }
  
  public void D()
  {
    if (this.A.getVisibility() == 8)
    {
      E();
      return;
    }
    if (this.A.getAnimation() != null)
    {
      E();
      return;
    }
    G();
  }
  
  public String f()
  {
    return "reader_image_viewer";
  }
  
  protected b l()
  {
    return b.a;
  }
  
  protected Drawable m()
  {
    return new ColorDrawable(-16777216);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    overridePendingTransition(0, 2130968581);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903051);
    this.z = ((ImageViewer)findViewById(2131230795));
    this.z.setBackgroundColor(-16777216);
    this.A = ((RelativeLayout)findViewById(2131230796));
    this.D = ((TextView)findViewById(2131230797));
    this.B = ((ImageButton)findViewById(2131230798));
    this.B.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ImageViewerActivity.a(ImageViewerActivity.this).a(-1);
      }
    });
    this.C = ((ImageButton)findViewById(2131230799));
    this.C.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ImageViewerActivity.a(ImageViewerActivity.this).a(1);
      }
    });
    this.z.setOnImageChangeListener(this);
    a(paramBundle);
    E();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.z != null) {
      this.z.b();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    com.pocket.m.a.a(6);
  }
  
  public void onResume()
  {
    super.onResume();
    com.pocket.m.a.a(6, true);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    com.ideashower.readitlater.e.a locala = this.z.getCurrentImage();
    if ((this.E != null) && (locala != null))
    {
      paramBundle.putString("com.ideashower.readitlater.extras.images", this.E);
      paramBundle.putInt("com.ideashower.readitlater.extras.start_image", locala.b());
    }
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/activity/ImageViewerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */