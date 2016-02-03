package mobi.beyondpod.ui.views.base;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import mobi.beyondpod.ui.core.SimpleMenu;

public class TitleBarActionMode
  extends LinearLayout
{
  ImageView _CancelButton;
  View.OnClickListener _CancelClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      TitleBarActionMode.this.finishMultiselect();
    }
  };
  Animation _EnterAnimation;
  Animation _ExitAnimation;
  EpisodeMultiselectAction _MultisielectMode = null;
  TextView _SubTitle;
  TextView _Title;
  View _TitleArea;
  
  public TitleBarActionMode(Context paramContext)
  {
    super(paramContext);
  }
  
  public TitleBarActionMode(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void UpdateMenuItemVisibility(SimpleMenu paramSimpleMenu)
  {
    int i = 0;
    if (i >= paramSimpleMenu.size()) {
      return;
    }
    MenuItem localMenuItem = paramSimpleMenu.getItem(i);
    View localView = findViewById(localMenuItem.getItemId());
    if (localView != null) {
      if (!localMenuItem.isVisible()) {
        break label76;
      }
    }
    label76:
    for (int j = 0;; j = 8)
    {
      localView.setVisibility(j);
      ((ImageButton)localView).setImageDrawable(localMenuItem.getIcon());
      i += 1;
      break;
    }
  }
  
  public void BuildMenuItems(SimpleMenu paramSimpleMenu)
  {
    removeAllViews();
    addView(this._CancelButton);
    addView(this._TitleArea);
    int i = 0;
    for (;;)
    {
      if (i >= paramSimpleMenu.size()) {
        return;
      }
      BuildToolbarButtonFromMenuItem(paramSimpleMenu.getItem(i));
      i += 1;
    }
  }
  
  public void BuildToolbarButtonFromMenuItem(final MenuItem paramMenuItem)
  {
    ImageButton localImageButton = new ImageButton(getContext(), null, 2130772189);
    localImageButton.setLayoutParams(new ViewGroup.LayoutParams((int)getContext().getResources().getDimension(2131492908), -1));
    localImageButton.setScaleType(ImageView.ScaleType.CENTER);
    localImageButton.setImageDrawable(paramMenuItem.getIcon());
    localImageButton.setId(paramMenuItem.getItemId());
    int i;
    if (paramMenuItem.isVisible())
    {
      i = 0;
      localImageButton.setVisibility(i);
      localImageButton.setContentDescription(paramMenuItem.getTitle());
      if (paramMenuItem.hasSubMenu()) {
        break label127;
      }
      localImageButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          TitleBarActionMode.this._MultisielectMode.itemSelected(paramMenuItem);
        }
      });
    }
    for (;;)
    {
      addView(localImageButton);
      return;
      i = 8;
      break;
      label127:
      localImageButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = paramMenuItem.getSubMenu();
          ArrayList localArrayList1 = new ArrayList();
          final ArrayList localArrayList2 = new ArrayList();
          int i = 0;
          if (i == paramAnonymousView.size())
          {
            new AlertDialog.Builder(TitleBarActionMode.this.getContext()).setItems((CharSequence[])localArrayList1.toArray(new String[localArrayList1.size()]), new DialogInterface.OnClickListener()
            {
              public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                TitleBarActionMode.this._MultisielectMode.itemSelected((MenuItem)localArrayList2.get(paramAnonymous2Int));
              }
            }).setCancelable(true).create().show();
            return;
          }
          MenuItem localMenuItem = paramAnonymousView.getItem(i);
          if ((!localMenuItem.isVisible()) || (!localMenuItem.isEnabled())) {}
          for (;;)
          {
            i += 1;
            break;
            localArrayList1.add(localMenuItem.getTitle().toString());
            localArrayList2.add(localMenuItem);
          }
        }
      });
    }
  }
  
  public void Initialize()
  {
    this._TitleArea = findViewById(2131230758);
    this._Title = ((TextView)findViewById(2131230759));
    this._SubTitle = ((TextView)findViewById(2131230760));
    this._CancelButton = ((ImageView)findViewById(2131231209));
    this._CancelButton.setOnClickListener(this._CancelClickListener);
    this._EnterAnimation = AnimationUtils.loadAnimation(getContext(), 2130968592);
    this._EnterAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation) {}
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        TitleBarActionMode.this.setVisibility(0);
      }
    });
    this._ExitAnimation = AnimationUtils.loadAnimation(getContext(), 2130968595);
    this._ExitAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        TitleBarActionMode.this.setVisibility(8);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
  }
  
  public void finishMultiselect()
  {
    if (this._MultisielectMode != null) {
      this._MultisielectMode.finish();
    }
  }
  
  public boolean isActive()
  {
    return this._MultisielectMode != null;
  }
  
  public ActionModeBP startMultiselect(ActionModeBP.Callback paramCallback)
  {
    this._MultisielectMode = new EpisodeMultiselectAction(paramCallback, getContext());
    this._MultisielectMode.start();
    return this._MultisielectMode;
  }
  
  class EpisodeMultiselectAction
    implements ActionModeBP
  {
    private ActionModeBP.Callback _Callback;
    Context _Context;
    SimpleMenu _Menu;
    
    public EpisodeMultiselectAction(ActionModeBP.Callback paramCallback, Context paramContext)
    {
      this._Callback = paramCallback;
      this._Context = paramContext;
      this._Menu = new SimpleMenu(this._Context);
    }
    
    public void finish()
    {
      this._Callback.onDestroyActionMode(this);
      TitleBarActionMode.this._MultisielectMode = null;
      TitleBarActionMode.this.startAnimation(TitleBarActionMode.this._ExitAnimation);
    }
    
    public SimpleMenu getActionMenus()
    {
      return this._Menu;
    }
    
    public void invalidateOptionsMenu()
    {
      this._Callback.onUpdateActionModeToolsVisibility(this, this._Menu);
      TitleBarActionMode.this.UpdateMenuItemVisibility(this._Menu);
    }
    
    public boolean isEmulated()
    {
      return true;
    }
    
    public void itemSelected(MenuItem paramMenuItem)
    {
      if (paramMenuItem != null) {
        this._Callback.onActionItemClicked(this, paramMenuItem);
      }
    }
    
    public void setSubTitle(CharSequence paramCharSequence)
    {
      TitleBarActionMode.this._SubTitle.setText(paramCharSequence);
      TextView localTextView = TitleBarActionMode.this._SubTitle;
      if ((paramCharSequence == null) || (paramCharSequence.length() == 0)) {}
      for (int i = 8;; i = 0)
      {
        localTextView.setVisibility(i);
        return;
      }
    }
    
    public void setTitle(CharSequence paramCharSequence)
    {
      TitleBarActionMode.this._Title.setText(paramCharSequence);
    }
    
    public void start()
    {
      this._Callback.onCreateActionMode(this, this._Menu);
      this._Callback.onUpdateActionModeToolsVisibility(this, this._Menu);
      TitleBarActionMode.this._Title.setText("");
      TitleBarActionMode.this.BuildMenuItems(this._Menu);
      TitleBarActionMode.this.setVisibility(0);
      this._Callback.onAfterActionModeCreate(this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/base/TitleBarActionMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */