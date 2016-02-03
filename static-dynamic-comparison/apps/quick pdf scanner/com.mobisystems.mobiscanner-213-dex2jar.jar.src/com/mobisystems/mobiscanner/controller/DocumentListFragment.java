package com.mobisystems.mobiscanner.controller;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.h;
import android.support.v4.widget.h.b;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.ActionMode.Callback;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.SearchView;
import com.actionbarsherlock.widget.SearchView.OnCloseListener;
import com.actionbarsherlock.widget.SearchView.OnQueryTextListener;
import com.actionbarsherlock.widget.SearchView.SearchAutoComplete;
import com.mobisystems.mobiscanner.common.CommonPreferences.Keys;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.common.d;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.mobiscanner.model.DocumentModel.DocListSortBy;
import com.mobisystems.mobiscanner.model.DocumentModel.SortOrder;
import com.mobisystems.mobiscanner.model.b;
import java.util.HashSet;
import java.util.Iterator;

public class DocumentListFragment
  extends SherlockListFragment
  implements View.OnClickListener, AbsListView.OnScrollListener, AdapterView.OnItemLongClickListener, CompoundButton.OnCheckedChangeListener, ActionMode.Callback
{
  private ViewGroup aBA;
  private TabHost aBB;
  private TabHost aBC;
  private SearchView aBD;
  private boolean aBE = false;
  private Object aBF = new Object();
  private long aBn;
  private t aBo;
  private boolean aBp = false;
  private c aBq;
  private c aBr;
  private h aBs;
  private s aBt;
  private com.mobisystems.mobiscanner.image.c aBu;
  private h aBv;
  private SparseIntArray aBw;
  private int aBx = 0;
  private int aBy = 0;
  private View aBz;
  private FragmentActivity mActivity;
  private HashSet<Long> mCheckedIds;
  public ListView mListView;
  private final com.mobisystems.mobiscanner.common.c mLog = new com.mobisystems.mobiscanner.common.c(this);
  private ProcType mProcType;
  
  @TargetApi(9)
  private void FG()
  {
    if (d.Dv()) {
      this.mListView.setOverScrollMode(2);
    }
  }
  
  private void FM()
  {
    this.aBs.ba(FK());
    this.aBs.a(this.aBo.Gd());
    this.aBs.a(this.aBo.Gc());
  }
  
  private void FN()
  {
    if (this.aBs.isVisible())
    {
      d(true, false);
      a(this.aBs.Gd(), this.aBs.Gc());
    }
  }
  
  private void FQ()
  {
    this.aBB = ((TabHost)this.aBA.findViewById(16908306));
    this.aBB.setup();
    this.aBB.getTabWidget().setDividerDrawable(null);
    this.aBB.setBackgroundColor(getResources().getColor(2131427348));
    this.aBB.addTab(this.aBB.newTabSpec(ProcTabs.aBW.name()).setIndicator(a(this.aBB.getContext(), ProcTabs.aBW)).setContent(new i(this.mActivity)));
    this.aBB.addTab(this.aBB.newTabSpec(ProcTabs.aBX.name()).setIndicator(a(this.aBB.getContext(), ProcTabs.aBX)).setContent(new i(this.mActivity)));
    this.aBB.addTab(this.aBB.newTabSpec(ProcTabs.aBU.name()).setIndicator(a(this.aBB.getContext(), ProcTabs.aBU)).setContent(new i(this.mActivity)));
    this.aBB.addTab(this.aBB.newTabSpec(ProcTabs.aBX.name()).setIndicator(a(this.aBB.getContext(), ProcTabs.aBX)).setContent(new i(this.mActivity)));
    this.aBB.addTab(this.aBB.newTabSpec(ProcTabs.aBV.name()).setIndicator(a(this.aBB.getContext(), ProcTabs.aBV)).setContent(new i(this.mActivity)));
    ProcTabs localProcTabs = ProcTabs.b(this.mProcType);
    this.aBB.setCurrentTabByTag(localProcTabs.name());
    if (!ProcTabs.aBW.name().equals(localProcTabs.name()))
    {
      this.aBt.aX(false);
      this.aBt.aW(false);
    }
    for (;;)
    {
      FR();
      this.aBB.setOnTabChangedListener(new TabHost.OnTabChangeListener()
      {
        public void onTabChanged(String paramAnonymousString)
        {
          DocumentListFragment.f(DocumentListFragment.this).dl("onTabChanged tab = " + paramAnonymousString);
          DocumentListFragment.ProcTabs localProcTabs = DocumentListFragment.ProcTabs.valueOf(paramAnonymousString);
          DocumentListFragment.o(DocumentListFragment.this);
          DocumentListFragment.this.a(localProcTabs.Gb());
          if (!DocumentListFragment.ProcTabs.aBW.name().equals(paramAnonymousString))
          {
            if (DocumentListFragment.p(DocumentListFragment.this).isVisible())
            {
              DocumentListFragment.this.FO();
              DocumentListFragment.this.e(false, false);
            }
            DocumentListFragment.b(DocumentListFragment.this).aX(false);
            if (DocumentListFragment.q(DocumentListFragment.this))
            {
              DocumentListFragment.r(DocumentListFragment.this);
              DocumentListFragment.this.d(false, false);
            }
            DocumentListFragment.b(DocumentListFragment.this).aW(false);
            return;
          }
          DocumentListFragment.this.FP();
          DocumentListFragment.s(DocumentListFragment.this);
          DocumentListFragment.b(DocumentListFragment.this).aX(DocumentListFragment.p(DocumentListFragment.this).isVisible());
          DocumentListFragment.b(DocumentListFragment.this).aW(DocumentListFragment.this.FK());
        }
      });
      return;
      this.aBt.aX(this.aBq.isVisible());
      this.aBt.aW(FK());
    }
  }
  
  private void FR()
  {
    int j = this.aBB.getCurrentTab();
    int k = this.aBB.getTabWidget().getChildCount();
    int i = 1;
    if (i < k)
    {
      View localView = this.aBB.getTabWidget().getChildAt(i);
      if (localView != null)
      {
        localView = localView.findViewById(2131165510);
        if (localView != null)
        {
          if ((j - 1 != i) && (j + 1 != i)) {
            break label87;
          }
          localView.setVisibility(8);
        }
      }
      for (;;)
      {
        i += 2;
        break;
        label87:
        localView.setVisibility(0);
      }
    }
  }
  
  private void FS()
  {
    this.aBC = ((TabHost)this.aBA.findViewById(2131165542));
    this.aBC.setup();
    this.aBC.getTabWidget().setDividerDrawable(null);
    this.aBC.setBackgroundColor(getResources().getColor(2131427348));
    this.aBC.addTab(this.aBC.newTabSpec(SortTabs.aCn.name()).setIndicator(a(this.aBC.getContext(), SortTabs.aCn)).setContent(new i(this.mActivity)));
    this.aBC.addTab(this.aBC.newTabSpec(SortTabs.aCq.name()).setIndicator(a(this.aBC.getContext(), SortTabs.aCq)).setContent(new i(this.mActivity)));
    this.aBC.addTab(this.aBC.newTabSpec(SortTabs.aCo.name()).setIndicator(a(this.aBC.getContext(), SortTabs.aCo)).setContent(new i(this.mActivity)));
    this.aBC.addTab(this.aBC.newTabSpec(SortTabs.aCq.name()).setIndicator(a(this.aBC.getContext(), SortTabs.aCq)).setContent(new i(this.mActivity)));
    this.aBC.addTab(this.aBC.newTabSpec(SortTabs.aCp.name()).setIndicator(a(this.aBC.getContext(), SortTabs.aCp)).setContent(new i(this.mActivity)));
    this.aBC.setOnTabChangedListener(new TabHost.OnTabChangeListener()
    {
      public void onTabChanged(String paramAnonymousString)
      {
        DocumentListFragment.f(DocumentListFragment.this).dl("onTabChanged tab = " + paramAnonymousString);
        DocumentListFragment.SortTabs localSortTabs = DocumentListFragment.SortTabs.valueOf(paramAnonymousString);
        if (!DocumentListFragment.SortTabs.aCq.equals(localSortTabs)) {
          DocumentListFragment.a(DocumentListFragment.this, paramAnonymousString);
        }
      }
    });
    ((ReclickableTabHost)this.aBC).a(new ReclickableTabHost.a()
    {
      public void gg(int paramAnonymousInt)
      {
        DocumentListFragment.a(DocumentListFragment.this, DocumentListFragment.t(DocumentListFragment.this).getCurrentTabTag());
      }
    });
  }
  
  private int FT()
  {
    int m = getResources().getDimensionPixelSize(2131230766);
    int k = getResources().getDimensionPixelSize(2131230767);
    int j = -(m + k);
    int i = j;
    if (this.aBp) {
      i = j + m;
    }
    j = i;
    if (this.aBq.isVisible()) {
      j = i + k;
    }
    return j;
  }
  
  private void FU()
  {
    this.aBD = new SearchView(new ContextThemeWrapper(getSherlockActivity().getSupportActionBar().getThemedContext(), 2131361881));
    Object localObject = (SearchView.SearchAutoComplete)this.aBD.findViewById(2131165258);
    if (localObject != null) {
      ((SearchView.SearchAutoComplete)localObject).setTextColor(getResources().getColor(2131427369));
    }
    localObject = (ImageView)this.aBD.findViewById(2131165256);
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(getResources().getDrawable(2130837876));
    }
    this.aBD.setOnKeyListener(new View.OnKeyListener()
    {
      public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        DocumentListFragment.f(DocumentListFragment.this).dl("key pressed " + paramAnonymousInt);
        if ((paramAnonymousInt == 66) && (TextUtils.isEmpty(DocumentListFragment.u(DocumentListFragment.this).getQuery()))) {
          DocumentListFragment.a(DocumentListFragment.this, DocumentListFragment.FilterStage.aBN);
        }
        return true;
      }
    });
    this.aBD.setInputType(524465);
    this.aBD.setOnCloseListener(new SearchView.OnCloseListener()
    {
      public boolean onClose()
      {
        DocumentListFragment.f(DocumentListFragment.this).dl("OnCloseListener");
        if (TextUtils.isEmpty(DocumentListFragment.u(DocumentListFragment.this).getQuery())) {
          DocumentListFragment.a(DocumentListFragment.this, DocumentListFragment.FilterStage.aBN);
        }
        for (;;)
        {
          return false;
          DocumentListFragment.a(DocumentListFragment.this, DocumentListFragment.FilterStage.aBP);
        }
      }
    });
    this.aBD.setOnQueryTextListener(new SearchView.OnQueryTextListener()
    {
      public boolean onQueryTextChange(String paramAnonymousString)
      {
        DocumentListFragment.this.dB(paramAnonymousString);
        DocumentListFragment.p(DocumentListFragment.this).dD(paramAnonymousString);
        return true;
      }
      
      public boolean onQueryTextSubmit(String paramAnonymousString)
      {
        DocumentListFragment.f(DocumentListFragment.this).dl("onQueryTextSubmit " + paramAnonymousString);
        if (TextUtils.isEmpty(paramAnonymousString)) {
          DocumentListFragment.a(DocumentListFragment.this, DocumentListFragment.FilterStage.aBN);
        }
        for (;;)
        {
          return false;
          DocumentListFragment.a(DocumentListFragment.this, DocumentListFragment.FilterStage.aBP);
        }
      }
    });
    this.aBD.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          ((InputMethodManager)DocumentListFragment.h(DocumentListFragment.this).getSystemService("input_method")).showSoftInput(DocumentListFragment.u(DocumentListFragment.this), 1);
        }
        while (!TextUtils.isEmpty(DocumentListFragment.u(DocumentListFragment.this).getQuery())) {
          return;
        }
        DocumentListFragment.a(DocumentListFragment.this, DocumentListFragment.FilterStage.aBN);
      }
    });
    this.aBD.setIconifiedByDefault(false);
    this.aBD.setId(2131165227);
    ((ViewGroup)this.aBA.findViewById(2131165536)).addView(this.aBD);
    this.aBD.getLayoutParams().width = -1;
    this.aBD.getLayoutParams().height = getResources().getDimensionPixelSize(2131230767);
    ((LinearLayout.LayoutParams)this.aBD.getLayoutParams()).weight = 1.0F;
    this.aBD.setVisibility(8);
    this.aBD.setPadding(getResources().getDimensionPixelSize(2131230769), getResources().getDimensionPixelSize(2131230771), getResources().getDimensionPixelSize(2131230770), getResources().getDimensionPixelSize(2131230772));
    this.aBD.setImeOptions(this.aBD.getImeOptions() | 0x10000000);
    ((TextView)this.aBA.findViewById(2131165539)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DocumentListFragment.a(DocumentListFragment.this, DocumentListFragment.FilterStage.aBO);
      }
    });
    ((CheckBox)this.aBA.findViewById(2131165540)).setOnCheckedChangeListener(this);
  }
  
  private void FV()
  {
    K(1, 0);
  }
  
  private void FW()
  {
    if (this.mListView.getFirstVisiblePosition() > 0) {
      K(1, 0);
    }
  }
  
  @TargetApi(11)
  private void K(int paramInt1, int paramInt2)
  {
    if (d.Dw())
    {
      this.mListView.smoothScrollToPositionFromTop(paramInt1, paramInt2);
      return;
    }
    this.mListView.setSelectionFromTop(paramInt1, paramInt2);
  }
  
  private void U(View paramView)
  {
    int[] arrayOfInt = new int[4];
    int[] tmp7_5 = arrayOfInt;
    tmp7_5[0] = 2131165304;
    int[] tmp13_7 = tmp7_5;
    tmp13_7[1] = 2131165302;
    int[] tmp19_13 = tmp13_7;
    tmp19_13[2] = 2131165307;
    int[] tmp25_19 = tmp19_13;
    tmp25_19[3] = 2131165309;
    tmp25_19;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      View localView = paramView.findViewById(arrayOfInt[i]);
      if (localView != null)
      {
        localView.setOnClickListener(this);
        localView.setOnLongClickListener((DocumentListActivity)this.mActivity);
      }
      i += 1;
    }
  }
  
  private void V(View paramView)
  {
    int i = 0;
    int j;
    if (this.aBt.Fp() != null)
    {
      j = 0;
      i = 8;
    }
    for (;;)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131165306);
      if (localLinearLayout != null) {
        localLinearLayout.setVisibility(j);
      }
      paramView = (LinearLayout)paramView.findViewById(2131165301);
      if (paramView != null) {
        paramView.setVisibility(i);
      }
      return;
      j = 8;
    }
  }
  
  private void W(long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.MAIN");
    localIntent.setClass(this.mActivity, PageGridActivity.class);
    localIntent.putExtra("TITLE_PAGE_SELECTION_ACTIVE", true);
    localIntent.putExtra("OPEN_DOCUMENT_SELECTED_DOC_ID", paramLong);
    localIntent.putExtra("OPEN_DOCUMENT_CURRENT_LIST_COUNT", 1);
    localIntent.putExtra("OPEN_DOCUMENT_CURRENT_LIST_FAVORITE_RANK", 0);
    startActivityForResult(localIntent, 2);
  }
  
  private void W(final View paramView)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.8F, 1.0F, 0.8F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(100L);
    localScaleAnimation.setFillEnabled(true);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        paramAnonymousAnimation = new ScaleAnimation(0.8F, 1.0F, 0.8F, 1.0F, 1, 0.5F, 1, 0.5F);
        paramAnonymousAnimation.setDuration(100L);
        paramAnonymousAnimation.setFillEnabled(true);
        paramAnonymousAnimation.setFillAfter(true);
        paramView.startAnimation(paramAnonymousAnimation);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    paramView.startAnimation(localScaleAnimation);
  }
  
  private View a(Context paramContext, ProcTabs paramProcTabs)
  {
    switch (3.aBI[paramProcTabs.Ga().ordinal()])
    {
    default: 
      return new View(paramContext);
    case 1: 
      paramContext = LayoutInflater.from(paramContext).inflate(2130903143, null);
      TextView localTextView = (TextView)paramContext.findViewById(2131165512);
      localTextView.setText(paramProcTabs.getText());
      ((ViewGroup.MarginLayoutParams)localTextView.getLayoutParams()).setMargins(0, 0, 0, 0);
      return paramContext;
    }
    paramContext = LayoutInflater.from(paramContext).inflate(2130903141, null);
    int i = getResources().getDimensionPixelSize(2131230765);
    paramProcTabs = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(2131230768), i);
    paramProcTabs.setMargins(0, 0, 0, 0);
    paramContext.setLayoutParams(paramProcTabs);
    return paramContext;
  }
  
  private View a(Context paramContext, SortTabs paramSortTabs)
  {
    switch (3.aBI[paramSortTabs.Ga().ordinal()])
    {
    default: 
      return new View(paramContext);
    case 1: 
      paramContext = LayoutInflater.from(paramContext).inflate(2130903144, null);
      Object localObject = (TextView)paramContext.findViewById(2131165512);
      ((TextView)localObject).setText(paramSortTabs.getText());
      ((ViewGroup.MarginLayoutParams)((TextView)localObject).getLayoutParams()).setMargins(0, 0, 0, 0);
      if (paramSortTabs.Gd().equals(this.aBo.Gd()))
      {
        localObject = (CheckBox)paramContext.findViewById(2131165514);
        if (DocumentModel.SortOrder.aIP != this.aBo.Gc()) {
          break label157;
        }
      }
      label157:
      for (boolean bool = true;; bool = false)
      {
        ((CheckBox)localObject).setChecked(bool);
        ((CheckBox)localObject).setVisibility(0);
        paramContext.setTag(paramSortTabs.Gd());
        return paramContext;
      }
    }
    paramContext = LayoutInflater.from(paramContext).inflate(2130903142, null);
    int i = getResources().getDimensionPixelSize(2131230766);
    paramSortTabs = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(2131230768), i);
    paramSortTabs.setMargins(0, 0, 0, 0);
    paramContext.setLayoutParams(paramSortTabs);
    return paramContext;
  }
  
  private void a(Cursor paramCursor)
  {
    paramCursor = this.aBv.swapCursor(paramCursor);
    if ((paramCursor != null) && (!paramCursor.isClosed())) {
      paramCursor.close();
    }
  }
  
  private void a(FilterStage paramFilterStage)
  {
    TextView localTextView = (TextView)this.aBA.findViewById(2131165539);
    View localView1 = this.aBA.findViewById(2131165537);
    View localView2 = this.aBA.findViewById(2131165538);
    CheckBox localCheckBox = (CheckBox)this.aBA.findViewById(2131165540);
    switch (3.aBJ[paramFilterStage.ordinal()])
    {
    }
    for (;;)
    {
      this.aBq.b(paramFilterStage);
      return;
      dB("");
      localTextView.setText(2131297014);
      localCheckBox.setText(2131296855);
      localCheckBox.setChecked(false);
      localCheckBox.setVisibility(0);
      localView2.setVisibility(8);
      localView1.setVisibility(0);
      this.aBD.setQuery("", false);
      this.aBD.setVisibility(8);
      continue;
      this.aBD.setIconified(false);
      localView1.setVisibility(8);
      localView2.setVisibility(0);
      this.aBD.setQueryHint(getResources().getString(2131297015));
      this.aBD.setVisibility(0);
      this.aBD.requestFocus();
      localCheckBox.setText(2131296856);
      localCheckBox.setVisibility(8);
      FV();
      continue;
      localView1.setVisibility(0);
      localView2.setVisibility(0);
      this.aBD.setVisibility(8);
      this.aBD.setQueryHint(getResources().getString(2131297015));
      localTextView.setText(this.aBD.getQuery());
      localCheckBox.setText(2131296856);
      localCheckBox.setOnCheckedChangeListener(null);
      localCheckBox.setChecked(true);
      localCheckBox.setOnCheckedChangeListener(this);
      localCheckBox.setVisibility(0);
    }
  }
  
  private void a(SlideableType paramSlideableType, boolean paramBoolean1, boolean paramBoolean2)
  {
    int m = getResources().getInteger(2131492866);
    View localView = null;
    int k;
    int j;
    switch (3.aBK[paramSlideableType.ordinal()])
    {
    default: 
      i = 1;
      paramSlideableType = localView;
      boolean bool = paramBoolean2;
      if (paramBoolean1)
      {
        bool = paramBoolean2;
        if (i != 0)
        {
          bool = paramBoolean2;
          if (!this.aBB.getCurrentTabTag().equals(ProcTabs.aBW.name()))
          {
            this.aBB.setCurrentTabByTag(ProcTabs.aBW.name());
            bool = false;
          }
        }
      }
      k = (int)getResources().getDimension(2131230767);
      if (!bool)
      {
        localView = getView().findViewById(2131165544);
        if (localView != null)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
          m = localLayoutParams.bottomMargin;
          j = m;
          if (i != 0)
          {
            if (paramBoolean1)
            {
              j = m + k;
              paramSlideableType.getLayoutParams().height = k;
            }
          }
          else
          {
            localLayoutParams.bottomMargin = j;
            localView.requestLayout();
          }
        }
        else
        {
          if (!paramBoolean1) {
            break label347;
          }
          paramSlideableType.getLayoutParams().height = k;
          paramSlideableType.requestLayout();
          this.aBA.requestLayout();
          return;
        }
      }
      break;
    case 1: 
      label184:
      label209:
      localView = this.aBA.findViewById(2131165541);
      if (this.aBp != paramBoolean1) {}
      break;
    }
    for (int i = 0;; i = 1)
    {
      this.aBp = paramBoolean1;
      j = i;
      paramSlideableType = localView;
      if (this.aBB.getCurrentTabTag().equals(ProcTabs.aBW.name()))
      {
        this.aBs.ba(paramBoolean1);
        paramSlideableType = localView;
        break;
        if (this.aBq.isVisible() != paramBoolean1) {
          break label470;
        }
      }
      label347:
      label371:
      label387:
      label446:
      label461:
      label470:
      for (j = 0;; j = 1)
      {
        paramSlideableType = this.aBA.findViewById(2131165536);
        this.aBq.setVisible(paramBoolean1);
        i = j;
        break;
        j = m - k;
        paramSlideableType.getLayoutParams().height = 0;
        break label184;
        paramSlideableType.getLayoutParams().height = 0;
        break label209;
        if (this.mListView.getFirstVisiblePosition() < 2)
        {
          paramBoolean2 = true;
          if (i == 0) {
            break label461;
          }
          if (!paramBoolean1) {
            break label446;
          }
          i = 0;
          j = k;
        }
        for (;;)
        {
          if (getView().findViewById(2131165544) == null) {}
          for (paramBoolean1 = true;; paramBoolean1 = false)
          {
            paramSlideableType = new g(this, paramSlideableType, m, i, j, paramBoolean2, paramBoolean1);
            paramSlideableType.setFillAfter(true);
            paramSlideableType.setFillEnabled(true);
            this.aBA.startAnimation(paramSlideableType);
            break;
            paramBoolean2 = false;
            break label371;
            i = k;
            j = 0;
            break label387;
          }
          j = 0;
          i = 0;
        }
      }
    }
  }
  
  private void a(c paramc)
  {
    if (paramc != null)
    {
      this.mLog.dl("_restoreFilterState filterState = " + paramc.toString());
      if (paramc.isVisible())
      {
        e(true, false);
        String str = paramc.getQuery();
        if (str != null) {
          this.aBD.setQuery(str, true);
        }
        if (paramc.FZ() != null) {
          a(paramc.FZ());
        }
      }
      this.aBt.aX(paramc.isVisible());
    }
  }
  
  private void a(DocumentModel.DocListSortBy paramDocListSortBy, DocumentModel.SortOrder paramSortOrder)
  {
    TabWidget localTabWidget = this.aBC.getTabWidget();
    int j = localTabWidget.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = localTabWidget.getChildAt(i);
      CheckBox localCheckBox;
      boolean bool;
      if (localView != null)
      {
        localCheckBox = (CheckBox)localView.findViewById(2131165514);
        if (localCheckBox != null)
        {
          if (SortTabs.valueOf(((DocumentModel.DocListSortBy)localView.getTag()).name()).Gd() != paramDocListSortBy) {
            break label132;
          }
          if (DocumentModel.SortOrder.aIP != paramSortOrder) {
            break label126;
          }
          bool = true;
          label86:
          localCheckBox.setChecked(bool);
          this.aBo.a(paramDocListSortBy);
          this.aBo.a(paramSortOrder);
          reloadContent();
          localCheckBox.setVisibility(0);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label126:
        bool = false;
        break label86;
        label132:
        localCheckBox.setVisibility(8);
      }
    }
    FW();
  }
  
  private void a(b paramb)
  {
    boolean bool = false;
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.MAIN");
    localIntent.setClass(this.mActivity, PageGridActivity.class);
    t localt = new t(this.aBo);
    if (this.mProcType == ProcType.aCa)
    {
      localt.a(DocumentModel.DocListSortBy.aIN);
      localt.a(DocumentModel.SortOrder.aIQ);
    }
    localIntent.putExtra("OPEN_DOCUMENT_SELECTED_DOC_ID", paramb.getId());
    localIntent.putExtra("OPEN_DOCUMENT_CURRENT_LIST_COUNT", this.aBv.getCount() - 2);
    if (this.mProcType == ProcType.aCb) {}
    for (int i = 1;; i = 0)
    {
      localIntent.putExtra("OPEN_DOCUMENT_CURRENT_LIST_FAVORITE_RANK", i);
      if (this.aBt.Fp() != null) {
        bool = true;
      }
      localIntent.putExtra("OPEN_DOCUMENT_SELECTION_MODE", bool);
      localIntent.putExtra("OPEN_DOCUMENT_SELECTION_MODE_INITIAL", getCheckedItemIds());
      localt.f(localIntent);
      startActivityForResult(localIntent, 1);
      return;
    }
  }
  
  private void aZ(boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    int j;
    int k;
    if (this.aBv != null)
    {
      localObject1 = new int[2];
      Object tmp14_12 = localObject1;
      tmp14_12[0] = 0;
      Object tmp18_14 = tmp14_12;
      tmp18_14[1] = 0;
      tmp18_14;
      if (!paramBoolean) {
        break label251;
      }
      if ((this.aBz != null) && (getView().findViewById(2131165544) == null)) {
        this.aBz = null;
      }
      if (this.aBz == null) {
        break label251;
      }
      this.aBz.getLocationOnScreen((int[])localObject1);
      localObject2 = getView();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      i = localDisplayMetrics.heightPixels;
      j = ((View)localObject2).getMeasuredHeight();
      k = this.aBt.FC();
    }
    label251:
    for (int i = Math.max(0, localObject1[1] - (i - j - k));; i = 0)
    {
      j = this.aBA.getTop();
      if (i != j) {
        this.aBA.offsetTopAndBottom(i - j);
      }
      this.aBA.bringToFront();
      localObject1 = getView().findViewById(2131165446);
      localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
      if ((((View)localObject1).getVisibility() == 0) && (localObject2 != null))
      {
        i = this.aBA.getTop() + getResources().getDimensionPixelSize(2131230765);
        ((FrameLayout.LayoutParams)localObject2).setMargins(0, (getView().getMeasuredHeight() - i - ((View)localObject1).getHeight()) / 2 + i, 0, 0);
      }
      return;
    }
  }
  
  private void b(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2130837869;; i = 2130837868)
    {
      int j = paramView.getPaddingLeft();
      int k = paramView.getPaddingTop();
      int m = paramView.getPaddingRight();
      int n = paramView.getPaddingBottom();
      paramView.setBackgroundResource(i);
      paramView.setPadding(j, k, m, n);
      return;
    }
  }
  
  private void dC(String paramString)
  {
    TabWidget localTabWidget = this.aBC.getTabWidget();
    int k = localTabWidget.getChildCount();
    int i = 0;
    if (i < k)
    {
      Object localObject = localTabWidget.getChildAt(i);
      CheckBox localCheckBox;
      int j;
      label76:
      label89:
      boolean bool;
      if (localObject != null)
      {
        localCheckBox = (CheckBox)((View)localObject).findViewById(2131165514);
        if (localCheckBox != null)
        {
          if (this.aBC.getCurrentTab() != i) {
            break label186;
          }
          if (localCheckBox.getVisibility() == 0) {
            break label151;
          }
          j = 1;
          localObject = this.aBo.Gc();
          if (j == 0) {
            break label156;
          }
          if (DocumentModel.SortOrder.aIP != localObject) {
            break label180;
          }
          bool = true;
          label100:
          localCheckBox.setChecked(bool);
          DocumentModel.DocListSortBy localDocListSortBy = SortTabs.valueOf(paramString).Gd();
          this.aBo.a(localDocListSortBy);
          this.aBo.a((DocumentModel.SortOrder)localObject);
          reloadContent();
          localCheckBox.setVisibility(0);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label151:
        j = 0;
        break label76;
        label156:
        if (DocumentModel.SortOrder.aIQ == localObject)
        {
          localObject = DocumentModel.SortOrder.aIP;
          break label89;
        }
        localObject = DocumentModel.SortOrder.aIQ;
        break label89;
        label180:
        bool = false;
        break label100;
        label186:
        localCheckBox.setVisibility(8);
      }
    }
    FW();
  }
  
  private void setLoadingViews(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mListView.setEmptyView(getView().findViewById(2131165449));
      return;
    }
    getView().findViewById(2131165449).setVisibility(8);
  }
  
  public void FH()
  {
    int k = 0;
    int m = this.mListView.getCount();
    Object localObject = this.mCheckedIds;
    this.mCheckedIds = new HashSet();
    int j = 0;
    int i;
    long l;
    for (;;)
    {
      i = k;
      if (j >= m) {
        break;
      }
      l = this.mListView.getItemIdAtPosition(j);
      if ((l >= 0L) && (!((HashSet)localObject).contains(Long.valueOf(l)))) {
        this.mCheckedIds.add(Long.valueOf(l));
      }
      j += 1;
    }
    while (i < this.mListView.getChildCount())
    {
      localObject = this.mListView.getChildAt(i);
      j = this.mListView.getPositionForView((View)localObject);
      if (j != -1)
      {
        l = this.mListView.getItemIdAtPosition(j);
        b((View)localObject, this.mCheckedIds.contains(Long.valueOf(l)));
      }
      i += 1;
    }
  }
  
  public int FI()
  {
    return this.mCheckedIds.size();
  }
  
  public String FJ()
  {
    return this.aBo.FJ();
  }
  
  public boolean FK()
  {
    return this.aBp;
  }
  
  public boolean FL()
  {
    return this.aBq.isVisible();
  }
  
  public void FO()
  {
    if (this.aBr == null) {
      this.aBr = new c(this.aBq);
    }
  }
  
  public void FP()
  {
    a(this.aBr);
    this.aBr = null;
  }
  
  public boolean FX()
  {
    return this.mProcType == ProcType.aCc;
  }
  
  public void a(ProcType paramProcType)
  {
    if (paramProcType != this.mProcType)
    {
      this.mProcType = paramProcType;
      reloadContent();
    }
  }
  
  public void aY(boolean paramBoolean)
  {
    int k = 0;
    int m = this.mListView.getCount();
    this.mCheckedIds.clear();
    int j = k;
    if (paramBoolean)
    {
      int i = 0;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        long l = this.mListView.getItemIdAtPosition(i);
        if (l >= 0L) {
          this.mCheckedIds.add(Long.valueOf(l));
        }
        i += 1;
      }
    }
    while (j < this.mListView.getChildCount())
    {
      View localView = this.mListView.getChildAt(j);
      if (this.mListView.getPositionForView(localView) != -1) {
        b(localView, true);
      }
      j += 1;
    }
  }
  
  public void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(SlideableType.aCi, paramBoolean1, paramBoolean2);
  }
  
  public void dB(String paramString)
  {
    if (!FJ().equals(paramString))
    {
      if (paramString != null) {
        this.aBo.setFilterText(paramString);
      }
      ((a)this.aBv.getFilterQueryProvider()).FY();
      this.aBv.getFilter().filter(paramString);
    }
  }
  
  public void e(Intent paramIntent)
  {
    this.mCheckedIds.clear();
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getLongArrayExtra("DOCUMENT_SELECTION_MODE_RESULT");
      if (paramIntent != null)
      {
        int j = paramIntent.length;
        int i = 0;
        while (i < j)
        {
          long l = paramIntent[i];
          this.mCheckedIds.add(Long.valueOf(l));
          i += 1;
        }
      }
      redrawList();
    }
    this.aBt.k(getTag(), this.mCheckedIds.size());
  }
  
  public void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mLog.dl("_restoreFilterState showFilter " + paramBoolean1);
    if (!paramBoolean1)
    {
      dB("");
      if (this.aBD != null)
      {
        ((InputMethodManager)this.mActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.aBD.getWindowToken(), 0);
        getView().requestFocus();
      }
    }
    for (;;)
    {
      a(SlideableType.aCj, paramBoolean1, paramBoolean2);
      return;
      dB(String.valueOf(this.aBD.getQuery()));
    }
  }
  
  public long[] getCheckedItemIds()
  {
    long[] arrayOfLong = new long[this.mCheckedIds.size()];
    Iterator localIterator = this.mCheckedIds.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      arrayOfLong[i] = ((Long)localIterator.next()).longValue();
      i += 1;
    }
    return arrayOfLong;
  }
  
  public void gf(int paramInt)
  {
    int i;
    long l;
    View localView;
    if (this.aBt.Fp() == null)
    {
      i = 1;
      if (i != 0)
      {
        this.mCheckedIds.clear();
        this.aBt.dA(getTag());
      }
      this.mLog.dl("selectListItem " + paramInt);
      l = this.mListView.getItemIdAtPosition(paramInt);
      localView = this.mListView.getChildAt(paramInt - this.mListView.getFirstVisiblePosition());
      if (!this.mCheckedIds.contains(Long.valueOf(l))) {
        break label181;
      }
      this.mCheckedIds.remove(Long.valueOf(l));
    }
    for (;;)
    {
      b(localView, this.mCheckedIds.contains(Long.valueOf(l)));
      W(localView.findViewById(2131165526));
      this.aBt.k(getTag(), this.mCheckedIds.size());
      if (i != 0) {
        redrawList();
      }
      return;
      i = 0;
      break;
      label181:
      this.mCheckedIds.add(Long.valueOf(l));
    }
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    this.mLog.dl("onActivityCreated called");
    super.onActivityCreated(paramBundle);
    this.aBu = new com.mobisystems.mobiscanner.image.c(this.mActivity.getApplicationContext(), this.mActivity.getSupportFragmentManager());
    this.aBA = ((ViewGroup)LayoutInflater.from(this.mActivity).inflate(2130903152, null));
    ((ViewGroup)getView()).addView(this.aBA, 0);
    FQ();
    FS();
    FU();
    this.aBv = new g(this.mActivity.getApplicationContext(), 2130903148, null, new String[] { "_id", "doc_name", "doc_last_modification_time", "doc_num_pages", "doc_favorite_rank" }, new int[] { 2131165526, 2131165529, 2131165532, 2131165530, 2131165534 }, 0);
    this.aBv.a(new b(null));
    this.aBv.setFilterQueryProvider(new a());
    setListAdapter(this.aBv);
    aZ(true);
    this.mListView = getListView();
    this.mListView.setOnItemLongClickListener(this);
    this.mListView.setOnScrollListener(this);
    this.mListView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        DocumentListFragment.a(DocumentListFragment.this, true);
      }
    });
    FG();
    U(this.mActivity.getWindow().getDecorView());
    if (this.aBp) {
      d(true, false);
    }
    if (this.aBq.isVisible())
    {
      if (this.aBr != null) {
        FP();
      }
    }
    else {
      return;
    }
    a(this.aBq);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      e(paramIntent);
    }
    while ((paramInt1 != 2) || (paramIntent == null)) {
      return;
    }
    long[] arrayOfLong = paramIntent.getLongArrayExtra("DOCUMENT_SELECTION_MODE_RESULT");
    if ((arrayOfLong != null) && (arrayOfLong.length > 0))
    {
      long l1 = arrayOfLong[0];
      long l2 = paramIntent.getLongExtra("OPEN_DOCUMENT_SELECTED_DOC_ID", -1L);
      if (l2 > -1L) {
        new e(l2).execute(new Long[] { Long.valueOf(l1) });
      }
    }
    redrawList();
  }
  
  public void onAttach(Activity paramActivity)
  {
    this.mLog.dl("onAttach called");
    super.onAttach(paramActivity);
    if ((paramActivity instanceof FragmentActivity)) {
      this.mActivity = ((FragmentActivity)paramActivity);
    }
    if ((paramActivity instanceof s)) {
      this.aBt = ((s)paramActivity);
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (2131165540 == paramCompoundButton.getId())
    {
      if (paramBoolean) {
        a(FilterStage.aBO);
      }
    }
    else {
      return;
    }
    a(FilterStage.aBN);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131165303: 
    case 2131165305: 
    case 2131165306: 
    case 2131165308: 
    default: 
      return;
    case 2131165304: 
      this.aBt.Fq();
      return;
    case 2131165302: 
      this.aBt.Fr();
      return;
    case 2131165307: 
      aY(true);
      this.aBt.k(getTag(), this.mCheckedIds.size());
      return;
    }
    FH();
    this.aBt.k(getTag(), this.mCheckedIds.size());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mLog.dl("onCreate called");
    super.onCreate(paramBundle);
    if (paramBundle == null) {}
    for (this.aBo = new t();; this.aBo = new t(paramBundle))
    {
      this.mProcType = ProcType.aCc;
      SortTabs.init(this.mActivity);
      ProcTabs.init(this.mActivity);
      this.mCheckedIds = new HashSet();
      this.aBq = new c();
      this.aBs = new h(null);
      setRetainInstance(true);
      return;
    }
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    this.mLog.dl("onCreateActionMode called");
    this.aBt.k(getTag(), this.mCheckedIds.size());
    V(this.mActivity.getWindow().getDecorView());
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mLog.dl("onCreateView called");
    return paramLayoutInflater.inflate(2130903111, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    this.mLog.dl("onDestroy called");
    super.onDestroy();
    this.aBu.Ii();
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode)
  {
    this.mLog.dl("onDestroyActionMode called");
    int j = this.mListView.getFirstVisiblePosition();
    int i = 0;
    while (i < this.mListView.getChildCount())
    {
      if (this.mCheckedIds.contains(Long.valueOf(this.aBv.getItemId(i + j))))
      {
        paramActionMode = (ViewGroup)this.mListView.getChildAt(i);
        if (paramActionMode != null) {
          W(paramActionMode.findViewById(2131165526));
        }
      }
      i += 1;
    }
    redrawList();
    V(this.mActivity.getWindow().getDecorView());
  }
  
  public void onDetach()
  {
    this.mLog.dl("onDetach called");
    a(null);
    super.onDetach();
    this.mActivity = null;
    this.aBt = null;
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt - 2 >= 0)
    {
      paramAdapterView = new l();
      paramView = new Bundle();
      paramView.putLong("DOC_CONTEXT_ID", paramLong);
      paramView.putInt("DOC_CONTEXT_POSITION", paramInt);
      paramAdapterView.setArguments(paramView);
      paramAdapterView.a(this);
      paramAdapterView.show(this.mActivity.getSupportFragmentManager(), "");
      return true;
    }
    return false;
  }
  
  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    paramInt -= 2;
    if (paramInt >= 0)
    {
      paramListView = ((h)paramListView.getAdapter()).getCursor();
      paramListView.moveToPosition(paramInt);
      a(new b(paramListView));
    }
  }
  
  public void onPause()
  {
    this.mLog.dl("onPause called");
    super.onPause();
    this.aBu.flushCache();
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    int i = 0;
    this.mLog.dl("onSaveInstanceState called");
    super.onSaveInstanceState(paramBundle);
    this.aBo.p(paramBundle);
    this.aBx = this.mListView.getFirstVisiblePosition();
    paramBundle = this.mListView.getChildAt(0);
    if (paramBundle == null) {}
    for (;;)
    {
      this.aBy = i;
      return;
      i = paramBundle.getTop();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    if (paramInt1 > 2) {
      bool = false;
    }
    aZ(bool);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void onStart()
  {
    this.mLog.dl("onStart called");
    super.onStart();
    reloadContent();
  }
  
  public void redrawList()
  {
    this.mListView.invalidateViews();
  }
  
  public void reloadContent()
  {
    dB(null);
    setLoadingViews(true);
  }
  
  private static enum FilterStage
  {
    private FilterStage() {}
  }
  
  private static enum ProcTabs
  {
    private static SparseArray<ProcTabs> aBY;
    private final DocumentListFragment.ProcType mProcType;
    private String mText;
    private final int mTextResId;
    private final DocumentListFragment.TabType mType;
    
    private ProcTabs(int paramInt, DocumentListFragment.TabType paramTabType, DocumentListFragment.ProcType paramProcType)
    {
      this.mTextResId = paramInt;
      this.mType = paramTabType;
      this.mProcType = paramProcType;
    }
    
    public static ProcTabs b(DocumentListFragment.ProcType paramProcType)
    {
      return (ProcTabs)aBY.get(paramProcType.ordinal());
    }
    
    public static void init(Context paramContext)
    {
      aBY = new SparseArray();
      ProcTabs[] arrayOfProcTabs = values();
      int j = arrayOfProcTabs.length;
      int i = 0;
      while (i < j)
      {
        ProcTabs localProcTabs = arrayOfProcTabs[i];
        localProcTabs.mText = paramContext.getResources().getString(localProcTabs.mTextResId);
        if (localProcTabs.mProcType != null) {
          aBY.put(localProcTabs.mProcType.ordinal(), localProcTabs);
        }
        i += 1;
      }
    }
    
    public DocumentListFragment.TabType Ga()
    {
      return this.mType;
    }
    
    public DocumentListFragment.ProcType Gb()
    {
      return this.mProcType;
    }
    
    public String getText()
    {
      return this.mText;
    }
  }
  
  public static enum ProcType
  {
    private ProcType() {}
  }
  
  private static enum SlideableType
  {
    private SlideableType() {}
  }
  
  public static enum SortTabs
  {
    private final DocumentModel.DocListSortBy mSortBy;
    private String mText;
    private final int mTextResId;
    private final DocumentListFragment.TabType mType;
    
    private SortTabs(int paramInt, DocumentListFragment.TabType paramTabType, DocumentModel.DocListSortBy paramDocListSortBy)
    {
      this.mTextResId = paramInt;
      this.mType = paramTabType;
      this.mSortBy = paramDocListSortBy;
    }
    
    public static void init(Context paramContext)
    {
      SortTabs[] arrayOfSortTabs = values();
      int j = arrayOfSortTabs.length;
      int i = 0;
      while (i < j)
      {
        SortTabs localSortTabs = arrayOfSortTabs[i];
        localSortTabs.mText = paramContext.getResources().getString(localSortTabs.mTextResId);
        i += 1;
      }
    }
    
    public DocumentListFragment.TabType Ga()
    {
      return this.mType;
    }
    
    public DocumentModel.DocListSortBy Gd()
    {
      return this.mSortBy;
    }
    
    public String getText()
    {
      return this.mText;
    }
  }
  
  private static enum TabType
  {
    private TabType() {}
  }
  
  private class a
    implements FilterQueryProvider
  {
    private DocumentModel aBL = new DocumentModel();
    private t aBM = null;
    
    public a() {}
    
    public void FY()
    {
      if (DocumentListFragment.b(DocumentListFragment.this) != null) {
        this.aBM = new t(DocumentListFragment.c(DocumentListFragment.this));
      }
    }
    
    public Cursor runQuery(CharSequence paramCharSequence)
    {
      Object localObject2 = null;
      int k = -1;
      int j = 0;
      Object localObject1 = localObject2;
      if (paramCharSequence != null)
      {
        localObject1 = localObject2;
        if (paramCharSequence.length() > 0) {
          localObject1 = String.valueOf(paramCharSequence);
        }
      }
      paramCharSequence = (CharSequence)localObject1;
      if (localObject1 == null) {
        paramCharSequence = this.aBM.FJ();
      }
      int i;
      if (DocumentListFragment.d(DocumentListFragment.this) == DocumentListFragment.ProcType.aCa)
      {
        localObject2 = DocumentModel.DocListSortBy.aIN;
        localObject1 = DocumentModel.SortOrder.aIQ;
        i = CommonPreferences.Keys.apt.getIntValue();
      }
      for (;;)
      {
        return this.aBL.a(paramCharSequence, (DocumentModel.DocListSortBy)localObject2, (DocumentModel.SortOrder)localObject1, j, i);
        DocumentModel.DocListSortBy localDocListSortBy = this.aBM.Gd();
        DocumentModel.SortOrder localSortOrder = this.aBM.Gc();
        localObject2 = localDocListSortBy;
        localObject1 = localSortOrder;
        i = k;
        if (DocumentListFragment.d(DocumentListFragment.this) == DocumentListFragment.ProcType.aCb)
        {
          j = 1;
          localObject2 = localDocListSortBy;
          localObject1 = localSortOrder;
          i = k;
        }
      }
    }
  }
  
  private class b
    implements h.b
  {
    private b() {}
    
    public boolean setViewValue(View paramView, Cursor paramCursor, int paramInt)
    {
      int i = -1;
      long l1;
      if (paramInt == paramCursor.getColumnIndex("doc_last_modification_time"))
      {
        l1 = paramCursor.getLong(paramInt);
        paramCursor = d.a(DocumentListFragment.h(DocumentListFragment.this), l1 * 1000L);
        ((TextView)paramView).setText(paramCursor);
        return true;
      }
      if (paramInt == paramCursor.getColumnIndex("doc_name"))
      {
        String str = paramCursor.getString(paramInt);
        ((TextView)paramView).setText(str);
        if (paramCursor.getInt(paramCursor.getColumnIndex("doc_accessed_flag")) == 0) {
          ((TextView)paramView).setTypeface(null, 1);
        }
        for (;;)
        {
          return true;
          ((TextView)paramView).setTypeface(null, 0);
        }
      }
      if (paramInt == paramCursor.getColumnIndex("doc_favorite_rank"))
      {
        if (DocumentListFragment.g(DocumentListFragment.this) != null) {
          i = DocumentListFragment.g(DocumentListFragment.this).get(paramCursor.getPosition(), -1);
        }
        int j = i;
        if (i < 0) {
          j = paramCursor.getInt(paramInt);
        }
        paramView = (CheckBox)paramView;
        paramView.setEnabled(false);
        if (j <= 0) {
          paramView.setChecked(false);
        }
        for (;;)
        {
          paramView.setEnabled(true);
          return true;
          paramView.setChecked(true);
        }
      }
      if (paramInt == paramCursor.getColumnIndex("_id"))
      {
        i = paramCursor.getPosition();
        DocumentListFragment.f(DocumentListFragment.this).dl("DocumentViewBinder.setViewValue called for column " + paramInt + ", cursor position=" + i + ", view=" + d.ay(paramView));
        l1 = paramCursor.getLong(paramCursor.getColumnIndex("doc_title_page_id"));
        long l2 = paramCursor.getLong(paramCursor.getColumnIndex("doc_last_modification_time"));
        if (l1 >= 0L) {
          DocumentListFragment.n(DocumentListFragment.this).a(l1, l2, paramView);
        }
        label407:
        for (;;)
        {
          return true;
          if (ImageView.class.isInstance(paramView)) {
            paramView = (ImageView)paramView;
          }
          for (;;)
          {
            if (paramView == null) {
              break label407;
            }
            paramView.setImageDrawable(DocumentListFragment.this.getResources().getDrawable(2130837875));
            break;
            if (ViewGroup.class.isInstance(paramView)) {
              paramView = (ImageView)d.a((ViewGroup)paramView, ImageView.class);
            } else {
              paramView = null;
            }
          }
        }
      }
      return false;
    }
  }
  
  private class c
  {
    private boolean aBR = false;
    private String aBS = "";
    private DocumentListFragment.FilterStage aBT = DocumentListFragment.FilterStage.aBN;
    
    public c() {}
    
    public c(c paramc)
    {
      this.aBR = paramc.aBR;
      this.aBS = paramc.aBS;
      this.aBT = paramc.aBT;
    }
    
    public DocumentListFragment.FilterStage FZ()
    {
      return this.aBT;
    }
    
    public void b(DocumentListFragment.FilterStage paramFilterStage)
    {
      this.aBT = paramFilterStage;
    }
    
    public void dD(String paramString)
    {
      this.aBS = paramString;
    }
    
    public String getQuery()
    {
      return this.aBS;
    }
    
    public boolean isVisible()
    {
      return this.aBR;
    }
    
    public void setVisible(boolean paramBoolean)
    {
      this.aBR = paramBoolean;
    }
    
    public String toString()
    {
      return "visible = " + this.aBR + " ; query = " + this.aBS + " ; stage = " + this.aBT.name();
    }
  }
  
  private class d
    extends AsyncTask<Void, Void, Boolean>
  {
    long aAa;
    SparseIntArray aCe;
    int aCf;
    int mPosition;
    
    public d(long paramLong, int paramInt1, SparseIntArray paramSparseIntArray, int paramInt2)
    {
      this.aAa = paramLong;
      this.mPosition = paramInt1;
      this.aCe = paramSparseIntArray;
      this.aCf = paramInt2;
    }
    
    public Boolean d(Void... paramVarArgs)
    {
      return Boolean.valueOf(new DocumentModel().b(this.aAa, this.aCf));
    }
    
    public void f(Boolean paramBoolean)
    {
      if (!paramBoolean.booleanValue()) {
        if (this.aCf <= 0) {
          Toast.makeText(DocumentListFragment.this.getActivity(), OperationStatus.awl.Ds(), 0).show();
        }
      }
      while (this.aCe == null)
      {
        return;
        Toast.makeText(DocumentListFragment.this.getActivity(), OperationStatus.awk.Ds(), 0).show();
        return;
      }
      this.aCe.append(this.mPosition, this.aCf);
    }
  }
  
  private class e
    extends AsyncTask<Long, Void, b>
  {
    private long aCg;
    
    public e(long paramLong)
    {
      this.aCg = paramLong;
    }
    
    protected b a(Long... paramVarArgs)
    {
      Object localObject1 = null;
      synchronized (DocumentListFragment.v(DocumentListFragment.this))
      {
        for (;;)
        {
          boolean bool = DocumentListFragment.w(DocumentListFragment.this);
          if (!bool) {
            break;
          }
          try
          {
            DocumentListFragment.v(DocumentListFragment.this).wait();
          }
          catch (InterruptedException localInterruptedException) {}
        }
        DocumentListFragment.b(DocumentListFragment.this, true);
        long l = paramVarArgs[0].longValue();
        DocumentListFragment.f(DocumentListFragment.this).dl("Async set title page started, docId=" + this.aCg + ", pageId " + l);
        DocumentModel localDocumentModel = new DocumentModel();
        paramVarArgs = (Long[])localObject1;
        if (localDocumentModel.e(this.aCg, l)) {
          paramVarArgs = localDocumentModel.ae(this.aCg);
        }
        return paramVarArgs;
      }
    }
    
    protected void b(b arg1)
    {
      if (??? == null)
      {
        DocumentListFragment.f(DocumentListFragment.this).dl("Async set title page failed");
        Toast.makeText(DocumentListFragment.h(DocumentListFragment.this), OperationStatus.awm.Ds(), 0).show();
      }
      synchronized (DocumentListFragment.v(DocumentListFragment.this))
      {
        DocumentListFragment.b(DocumentListFragment.this, false);
        DocumentListFragment.v(DocumentListFragment.this).notifyAll();
        return;
        DocumentListFragment.f(DocumentListFragment.this).dl("Async set title page finished");
        DocumentListFragment.this.reloadContent();
      }
    }
  }
  
  private class f
    extends h
    implements CompoundButton.OnCheckedChangeListener
  {
    f(Context paramContext, int paramInt1, Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt2)
    {
      super(paramInt1, paramCursor, paramArrayOfString, paramArrayOfInt, paramInt2);
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView != null) {
        ((CheckBox)paramView.findViewById(2131165534)).setTag(null);
      }
      paramView = super.getView(paramInt, paramView, paramViewGroup);
      paramViewGroup = (CheckBox)paramView.findViewById(2131165534);
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131165533);
      if (DocumentListFragment.b(DocumentListFragment.this).Fp() != null)
      {
        long l = super.getItemId(paramInt);
        DocumentListFragment.a(DocumentListFragment.this, paramView, DocumentListFragment.e(DocumentListFragment.this).contains(Long.valueOf(l)));
      }
      for (;;)
      {
        paramViewGroup.setOnCheckedChangeListener(this);
        paramViewGroup.setTag(Integer.valueOf(paramInt));
        return paramView;
        DocumentListFragment.a(DocumentListFragment.this, paramView, false);
        localLinearLayout.setVisibility(0);
      }
    }
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      Object localObject = paramCompoundButton.getTag();
      int j;
      long l;
      if ((localObject != null) && (paramCompoundButton.isEnabled()))
      {
        j = ((Integer)localObject).intValue();
        DocumentListFragment.f(DocumentListFragment.this).dl("checkedChanged , position = " + j);
        paramCompoundButton = getCursor();
        if ((paramCompoundButton != null) && (paramCompoundButton.moveToPosition(j)))
        {
          l = super.getItemId(j);
          paramCompoundButton = DocumentListFragment.this;
          localObject = DocumentListFragment.g(DocumentListFragment.this);
          if (!paramBoolean) {
            break label130;
          }
        }
      }
      label130:
      for (int i = 1;; i = 0)
      {
        new DocumentListFragment.d(paramCompoundButton, l, j, (SparseIntArray)localObject, i).execute(new Void[0]);
        return;
      }
    }
    
    public Cursor swapCursor(Cursor paramCursor)
    {
      DocumentListFragment.a(DocumentListFragment.this, new SparseIntArray());
      return super.swapCursor(paramCursor);
    }
  }
  
  private class g
    extends DocumentListFragment.f
    implements View.OnClickListener, View.OnLongClickListener
  {
    private LayoutInflater mInflater = (LayoutInflater)DocumentListFragment.h(DocumentListFragment.this).getSystemService("layout_inflater");
    
    g(Context paramContext, int paramInt1, Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt2)
    {
      super(paramContext, paramInt1, paramCursor, paramArrayOfString, paramArrayOfInt, paramInt2);
    }
    
    public int getCount()
    {
      return super.getCount() + 2;
    }
    
    public Object getItem(int paramInt)
    {
      return super.getItem(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      if (paramInt >= 2) {
        return super.getItemId(paramInt - 2);
      }
      return paramInt - 2;
    }
    
    public int getItemViewType(int paramInt)
    {
      if (paramInt == 0) {
        return 1;
      }
      if (1 == paramInt) {
        return 2;
      }
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = getItemViewType(paramInt);
      if (i == 0)
      {
        paramView = super.getView(paramInt - 2, paramView, paramViewGroup);
        paramViewGroup = paramView.findViewById(2131165526);
        paramViewGroup.setOnClickListener(this);
        paramViewGroup.setOnLongClickListener(this);
        return paramView;
      }
      if (paramView == null)
      {
        switch (i)
        {
        default: 
          return paramView;
        case 1: 
          paramView = this.mInflater.inflate(2130903149, null);
          DocumentListFragment.a(DocumentListFragment.this, paramView);
          DocumentListFragment.b(DocumentListFragment.this, paramView);
          return paramView;
        }
        paramView = this.mInflater.inflate(2130903153, null);
        DocumentListFragment.c(DocumentListFragment.this, paramView.findViewById(2131165544));
        ((LinearLayout.LayoutParams)DocumentListFragment.i(DocumentListFragment.this).getLayoutParams()).bottomMargin = DocumentListFragment.j(DocumentListFragment.this);
        return paramView;
      }
      switch (i)
      {
      default: 
        return paramView;
      case 1: 
        DocumentListFragment.b(DocumentListFragment.this, paramView);
        return paramView;
      }
      paramView.clearAnimation();
      DocumentListFragment.c(DocumentListFragment.this, paramView.findViewById(2131165544));
      ((LinearLayout.LayoutParams)DocumentListFragment.i(DocumentListFragment.this).getLayoutParams()).bottomMargin = DocumentListFragment.j(DocumentListFragment.this);
      DocumentListFragment.i(DocumentListFragment.this).requestLayout();
      return paramView;
    }
    
    public int getViewTypeCount()
    {
      return 3;
    }
    
    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      }
      int i;
      do
      {
        return;
        i = DocumentListFragment.this.mListView.getPositionForView(paramView);
      } while (-1 == i);
      DocumentListFragment.this.gf(i);
    }
    
    public boolean onLongClick(View paramView)
    {
      switch (paramView.getId())
      {
      default: 
        return false;
      }
      DocumentListFragment.b(DocumentListFragment.this, getItemId(DocumentListFragment.this.mListView.getPositionForView(paramView)));
      return true;
    }
    
    public Cursor swapCursor(Cursor paramCursor)
    {
      Cursor localCursor = super.swapCursor(paramCursor);
      Object localObject = DocumentListFragment.this.getView();
      if (localObject != null) {}
      for (localObject = ((View)localObject).findViewById(2131165446);; localObject = null)
      {
        int i;
        if (paramCursor != null) {
          if ((DocumentListFragment.k(DocumentListFragment.this) != 0) || (DocumentListFragment.l(DocumentListFragment.this) != 0))
          {
            if (DocumentListFragment.k(DocumentListFragment.this) == 0)
            {
              DocumentListFragment.this.mListView.setSelectionFromTop(DocumentListFragment.k(DocumentListFragment.this), 0);
              DocumentListFragment.a(DocumentListFragment.this, 0);
              DocumentListFragment.b(DocumentListFragment.this, 0);
            }
          }
          else
          {
            if (localObject != null)
            {
              if ((paramCursor.getCount() <= 0) && (TextUtils.isEmpty(DocumentListFragment.this.FJ()))) {
                break label200;
              }
              i = 8;
              label130:
              ((View)localObject).setVisibility(i);
            }
            label136:
            localObject = new a(null);
            if (paramCursor == null) {
              break label232;
            }
          }
        }
        label200:
        label232:
        for (boolean bool = true;; bool = false)
        {
          ((a)localObject).execute(new Boolean[] { Boolean.valueOf(bool) });
          return localCursor;
          DocumentListFragment.this.mListView.setSelectionFromTop(DocumentListFragment.k(DocumentListFragment.this), DocumentListFragment.l(DocumentListFragment.this));
          break;
          i = 0;
          break label130;
          if ((localObject == null) || (!TextUtils.isEmpty(DocumentListFragment.this.FJ()))) {
            break label136;
          }
          ((View)localObject).setVisibility(0);
          break label136;
        }
      }
    }
    
    private class a
      extends AsyncTask<Boolean, Void, Long>
    {
      private a() {}
      
      protected Long a(Boolean... paramVarArgs)
      {
        boolean bool = paramVarArgs[0].booleanValue();
        long l = 0L;
        if (bool) {
          l = DocumentModel.Ip();
        }
        return Long.valueOf(l);
      }
      
      protected void b(Long paramLong)
      {
        if (DocumentListFragment.m(DocumentListFragment.this) < paramLong.longValue())
        {
          if (DocumentListFragment.m(DocumentListFragment.this) > 0L) {
            DocumentListFragment.b(DocumentListFragment.this).FD();
          }
          DocumentListFragment.a(DocumentListFragment.this, paramLong.longValue());
        }
      }
    }
  }
  
  private class h
  {
    private DocumentModel.SortOrder aCl = DocumentModel.SortOrder.aIQ;
    private boolean aCm = false;
    private DocumentModel.DocListSortBy mSortBy = DocumentModel.DocListSortBy.aIL;
    
    private h() {}
    
    public DocumentModel.SortOrder Gc()
    {
      return this.aCl;
    }
    
    public DocumentModel.DocListSortBy Gd()
    {
      return this.mSortBy;
    }
    
    public void a(DocumentModel.DocListSortBy paramDocListSortBy)
    {
      this.mSortBy = paramDocListSortBy;
    }
    
    public void a(DocumentModel.SortOrder paramSortOrder)
    {
      this.aCl = paramSortOrder;
    }
    
    public void ba(boolean paramBoolean)
    {
      this.aCm = paramBoolean;
    }
    
    public boolean isVisible()
    {
      return this.aCm;
    }
  }
  
  class i
    implements TabHost.TabContentFactory
  {
    private final Context mContext;
    
    public i(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public View createTabContent(String paramString)
    {
      paramString = new View(this.mContext);
      paramString.setMinimumWidth(0);
      paramString.setMinimumHeight(0);
      return paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/DocumentListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */