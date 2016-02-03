package com.mobisystems.mobiscanner.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragment;
import com.mobeta.android.dslv.DragSortListView.h;
import com.mobeta.android.dslv.DragSortListView.m;
import com.mobeta.android.dslv.e;
import com.mobeta.android.dslv.e.b;
import com.mobisystems.mobiscanner.common.OperationStatus;
import com.mobisystems.mobiscanner.common.d;
import com.mobisystems.mobiscanner.common.d.a;
import com.mobisystems.mobiscanner.image.ImageProcessing.ImageOperation;
import com.mobisystems.mobiscanner.image.h;
import com.mobisystems.mobiscanner.model.DocumentModel;
import com.mobisystems.mobiscanner.model.b;
import com.mobisystems.mobiscanner.view.DragAndDropGridViewV3;
import com.mobisystems.mobiscanner.view.DragAndDropGridViewV3.b;
import java.util.HashSet;
import java.util.Iterator;

public class au
  extends SherlockFragment
  implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, DragSortListView.h, DragSortListView.m, ba.a, bh.a
{
  private long aAa;
  private boolean aBE = false;
  private Object aBF = new Object();
  private int aBx;
  private int aBy;
  private boolean aCm = false;
  private f aFH;
  private DragAndDropGridViewV3 aFI;
  private av aFJ;
  private long aFK;
  private int aFL;
  private int aFM;
  private int aFN = 0;
  private boolean aFO = false;
  private FragmentActivity mActivity;
  private HashSet<Long> mCheckedIds;
  private final com.mobisystems.mobiscanner.common.c mLog = new com.mobisystems.mobiscanner.common.c(this);
  
  private void a(int paramInt, com.mobisystems.mobiscanner.model.c paramc)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.MAIN");
    localIntent.setClass(this.mActivity, PageDetailActivity.class);
    paramc.f(localIntent);
    if (this.aFJ.Fp() != null) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("OPEN_PAGE_SELECTION_MODE", bool);
      localIntent.putExtra("OPEN_PAGE_DOCUMENT_SELECTION_MODE", this.aFJ.Ho());
      localIntent.putExtra("PAGE_SELECTION_MODE_INITIAL", getCheckedItemIds());
      ((PageGridActivity)this.mActivity).g(localIntent);
      return;
    }
  }
  
  private void a(Cursor paramCursor)
  {
    if (this.aFH != null)
    {
      paramCursor = this.aFH.swapCursor(paramCursor);
      if ((paramCursor != null) && (!paramCursor.isClosed())) {
        paramCursor.close();
      }
    }
  }
  
  private void a(View paramView, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = false;
    if (this.aFJ != null) {}
    for (boolean bool1 = this.aFJ.Hv();; bool1 = false)
    {
      View localView1 = paramView.findViewById(2131165547);
      View localView2 = paramView.findViewById(2131165548);
      long l;
      if (localView1 != null)
      {
        if (!paramBoolean) {
          break label221;
        }
        localView1.setVisibility(0);
        l = this.aFI.getItemIdAtPosition(paramInt);
        if ((bool1) && (this.mCheckedIds.isEmpty()))
        {
          paramBoolean = bool2;
          if (this.aFK == l) {
            paramBoolean = true;
          }
          localView1.setVisibility(8);
          if (bool1)
          {
            paramInt = 2130837574;
            if (paramBoolean) {
              paramInt = 2130837568;
            }
            int i = paramView.getPaddingLeft();
            int j = paramView.getPaddingTop();
            int k = paramView.getPaddingRight();
            int m = paramView.getPaddingBottom();
            paramView.setBackgroundResource(paramInt);
            paramView.setPadding(i, j, k, m);
          }
          localView2.setOnClickListener(this.aFH);
          localView1.setOnClickListener(this.aFH);
        }
      }
      else
      {
        return;
      }
      paramBoolean = this.mCheckedIds.contains(Long.valueOf(l));
      if (paramBoolean) {}
      for (paramInt = 2130837884;; paramInt = 2130837883)
      {
        localView1.setBackgroundResource(paramInt);
        if (bool1) {
          localView1.setVisibility(8);
        }
        break;
      }
      label221:
      localView1.setVisibility(4);
      return;
    }
  }
  
  private void aa(long paramLong)
  {
    this.mCheckedIds.clear();
    this.mCheckedIds.add(Long.valueOf(paramLong));
    int k = this.aFI.getFirstVisiblePosition();
    int i = 0;
    if (i < this.aFI.getChildCount())
    {
      Object localObject = (ViewGroup)this.aFI.getChildAt(i);
      long l = this.aFI.getItemIdAtPosition(i + k);
      localObject = (CheckBox)((ViewGroup)localObject).findViewById(2131165452);
      boolean bool;
      if (localObject != null)
      {
        ((CheckBox)localObject).setOnCheckedChangeListener(null);
        if (l != paramLong) {
          break label141;
        }
        bool = true;
        label101:
        ((CheckBox)localObject).setChecked(bool);
        if (l != paramLong) {
          break label147;
        }
      }
      label141:
      label147:
      for (int j = 0;; j = 8)
      {
        ((CheckBox)localObject).setVisibility(j);
        ((CheckBox)localObject).setOnCheckedChangeListener(this.aFH);
        i += 1;
        break;
        bool = false;
        break label101;
      }
    }
    this.mActivity.onBackPressed();
  }
  
  private void gq(int paramInt)
  {
    d.a locala;
    int i;
    int j;
    if (this.aFN <= 0)
    {
      this.aFL = getResources().getInteger(2131492869);
      locala = d.ai(this.mActivity);
      if (locala.width >= locala.height) {
        break label138;
      }
      i = locala.width;
      if (locala.width <= locala.height) {
        break label147;
      }
      j = locala.width;
      label68:
      i /= this.aFL;
      this.aFM = (j / i);
      i = Math.max(i, j / this.aFM);
      if (this.aFJ != null) {
        this.aFJ.Hk().N(i, i);
      }
    }
    if (paramInt == 2) {}
    for (paramInt = this.aFM;; paramInt = this.aFL)
    {
      this.aFI.setNumColumns(paramInt);
      this.aFN = paramInt;
      return;
      label138:
      i = locala.height;
      break;
      label147:
      j = locala.height;
      break label68;
    }
  }
  
  private void setLoadingViews(boolean paramBoolean)
  {
    View localView = getView();
    if (localView != null)
    {
      if (paramBoolean)
      {
        localView.findViewById(2131165461).setVisibility(8);
        this.aFI.setEmptyView(getView().findViewById(2131165462));
      }
    }
    else {
      return;
    }
    localView.findViewById(2131165462).setVisibility(8);
    this.aFI.setEmptyView(getView().findViewById(2131165461));
  }
  
  public void F(int paramInt1, int paramInt2)
  {
    this.mLog.dl("Drop item, from " + paramInt1 + " to " + paramInt2);
    this.aFH.F(paramInt1, paramInt2);
    new a(this.aAa).execute(new Integer[] { Integer.valueOf(paramInt1 + 1), Integer.valueOf(paramInt2 + 1) });
  }
  
  public void FH()
  {
    int k = 0;
    int m = this.aFI.getCount();
    Object localObject = this.mCheckedIds;
    this.mCheckedIds = new HashSet();
    int j = 0;
    int i;
    for (;;)
    {
      i = k;
      if (j >= m) {
        break;
      }
      long l = this.aFI.getItemIdAtPosition(j);
      if ((l >= 0L) && (!((HashSet)localObject).contains(Long.valueOf(l)))) {
        this.mCheckedIds.add(Long.valueOf(l));
      }
      j += 1;
    }
    if (i < this.aFI.getChildCount())
    {
      localObject = this.aFI.getChildAt(i);
      j = this.aFI.getPositionForView((View)localObject);
      if (j != -1)
      {
        localObject = ((View)localObject).findViewById(2131165547);
        if (!this.mCheckedIds.contains(Long.valueOf(this.aFI.getItemIdAtPosition(j)))) {
          break label170;
        }
      }
      label170:
      for (j = 2130837884;; j = 2130837883)
      {
        ((View)localObject).setBackgroundResource(j);
        i += 1;
        break;
      }
    }
  }
  
  public int FI()
  {
    int i = 0;
    if (this.mCheckedIds != null) {
      i = this.mCheckedIds.size();
    }
    return i;
  }
  
  public void HA()
  {
    this.aCm = true;
  }
  
  public void Hy()
  {
    this.mCheckedIds.clear();
  }
  
  public void Hz()
  {
    this.aCm = true;
    this.aFO = true;
  }
  
  public void a(long[] paramArrayOfLong)
  {
    if (this.mCheckedIds == null) {
      this.mCheckedIds = new HashSet();
    }
    this.mCheckedIds.clear();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      this.mCheckedIds.add(Long.valueOf(l));
      i += 1;
    }
    redrawList();
  }
  
  public void aY(boolean paramBoolean)
  {
    int k = 0;
    int m = this.aFI.getCount();
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      long l = this.aFI.getItemIdAtPosition(i);
      this.mCheckedIds.add(Long.valueOf(l));
      i += 1;
    }
    while (j < this.aFI.getChildCount())
    {
      View localView = this.aFI.getChildAt(j);
      if (this.aFI.getPositionForView(localView) != -1) {
        localView.findViewById(2131165547).setBackgroundResource(2130837884);
      }
      j += 1;
    }
  }
  
  public void ab(long paramLong)
  {
    new e(this.aAa).execute(new Long[] { Long.valueOf(paramLong) });
  }
  
  public void b(ImageProcessing.ImageOperation paramImageOperation)
  {
    Cursor localCursor = this.aFH.getCursor();
    if (localCursor != null)
    {
      localCursor.moveToFirst();
      while (!localCursor.isAfterLast())
      {
        long l = localCursor.getLong(localCursor.getColumnIndex("_id"));
        if (this.mCheckedIds.contains(Long.valueOf(l))) {
          new ba(gp(localCursor.getPosition()), this).execute(new ImageProcessing.ImageOperation[] { paramImageOperation });
        }
        localCursor.moveToNext();
      }
    }
  }
  
  public void bm(boolean paramBoolean)
  {
    this.aFI.bw(paramBoolean);
  }
  
  public void bn(boolean paramBoolean)
  {
    if (this.aFI != null)
    {
      int j = this.aFI.getChildCount();
      int k = this.aFI.getFirstVisiblePosition();
      int i = 0;
      while (i < j)
      {
        int m = i + k;
        View localView = this.aFI.getChildAt(i);
        a(localView, paramBoolean, m);
        this.aFI.b(m, localView);
        i += 1;
      }
    }
  }
  
  public void c(com.mobisystems.mobiscanner.model.c paramc)
  {
    reloadContent();
  }
  
  public void d(com.mobisystems.mobiscanner.model.c paramc)
  {
    reloadContent();
  }
  
  public void dB(String paramString)
  {
    ((c)this.aFH.getFilterQueryProvider()).FY();
    this.aFH.getFilter().filter(paramString);
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
    if (this.aFJ.Fp() == null)
    {
      i = 1;
      if (i != 0)
      {
        this.mCheckedIds.clear();
        this.aFJ.dA(getTag());
      }
      l = this.aFI.getItemIdAtPosition(paramInt);
      if (!this.mCheckedIds.contains(Long.valueOf(l))) {
        break label104;
      }
      this.mCheckedIds.remove(Long.valueOf(l));
    }
    for (;;)
    {
      this.aFJ.a(getTag(), getCheckedItemIds());
      if (i != 0) {
        redrawList();
      }
      return;
      i = 0;
      break;
      label104:
      this.mCheckedIds.add(Long.valueOf(l));
    }
  }
  
  public com.mobisystems.mobiscanner.model.c gp(int paramInt)
  {
    Object localObject2 = null;
    Cursor localCursor = this.aFH.getCursor();
    Object localObject1 = localObject2;
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToPosition(paramInt)) {
        localObject1 = new com.mobisystems.mobiscanner.model.c(this.aFJ.Hj(), localCursor);
      }
    }
    return (com.mobisystems.mobiscanner.model.c)localObject1;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    this.mLog.dl("onActivityCreated called");
    super.onActivityCreated(paramBundle);
    this.aFH = new f(this.mActivity.getApplicationContext(), 2130903154, null, new String[] { "page_idx_within_doc", "page_raw_image_id" }, new int[] { 2131165549, 2131165545 }, 0);
    this.aFH.setFilterQueryProvider(new c());
    this.aFH.a(new d(null));
    this.aFI = ((DragAndDropGridViewV3)getView().findViewById(2131165460));
    gq(getResources().getConfiguration().orientation);
    this.aFI.a(this.aFH);
    this.aFI.setOnItemLongClickListener(this);
    this.aFI.setOnItemClickListener(this);
    paramBundle = this.aFI;
    if ((this.aFJ.Fp() == null) && (!this.aFJ.Ho()) && (!this.aFJ.Hv())) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.bw(bool);
      this.aAa = getArguments().getLong("PAGE_GRID_FRAGMENT_DOC_ID", -1L);
      this.aFK = getArguments().getLong("PAGE_GRID_FRAGMENT_TITLE_PAGE_ID", -1L);
      this.aFO = getArguments().getBoolean("DOC_DISPLAYED_FLAG", false);
      return;
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    this.mLog.dl("onAttach called");
    super.onAttach(paramActivity);
    if (PageGridActivity.class.isInstance(paramActivity))
    {
      this.mActivity = ((FragmentActivity)paramActivity);
      this.aFJ = ((av)paramActivity);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    int j;
    do
    {
      return;
      j = this.aFI.getPositionForView(paramView);
      this.mLog.dl("onCLick pos = " + j);
      paramView = this.aFH.getCursor();
    } while (!paramView.moveToPosition(j));
    if (paramView.getInt(paramView.getColumnIndex("page_image_version")) == 0) {}
    for (int i = 1;; i = 0)
    {
      new bh(this.aFH.getItemId(j), i, this).execute(new Void[0]);
      return;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    gq(paramConfiguration.orientation);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mLog.dl("onCreate called, savedInstanceState=" + d.ay(paramBundle));
    super.onCreate(paramBundle);
    this.mCheckedIds = new HashSet();
    setRetainInstance(true);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mLog.dl("onCreateView called, savedInstanceState=" + d.ay(paramBundle));
    return paramLayoutInflater.inflate(2130903114, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    this.mLog.dl("onDestroy called");
    super.onDestroy();
  }
  
  public void onDetach()
  {
    this.mLog.dl("onDetach called");
    super.onDetach();
    a(null);
    this.mActivity = null;
    this.aFJ = null;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.mLog.dl("onItemClick called, position=" + paramInt);
    paramAdapterView = this.aFH.getCursor();
    if (paramAdapterView.moveToPosition(paramInt))
    {
      if (this.aFJ.Hv())
      {
        aa(paramLong);
        return;
      }
      a(paramInt, new com.mobisystems.mobiscanner.model.c(this.aFJ.Hj(), paramAdapterView));
      return;
    }
    this.mLog.A("Could not move cursor to position " + paramInt);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (((this.mActivity != null) && (this.aFJ.Fp() != null)) || (this.aFJ.Ho())) {
      return false;
    }
    if (this.aFJ.Hv())
    {
      onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return false;
    }
    ((PageGridActivity)this.mActivity).bl(false);
    return true;
  }
  
  public void onPause()
  {
    this.mLog.dl("onPause called");
    super.onPause();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    int i = 0;
    this.mLog.dl("onSaveInstanceState called");
    super.onSaveInstanceState(paramBundle);
    this.aBx = this.aFI.getFirstVisiblePosition();
    paramBundle = this.aFI.getChildAt(0);
    if (paramBundle == null) {}
    for (;;)
    {
      this.aBy = i;
      return;
      i = paramBundle.getTop();
    }
  }
  
  public void onStart()
  {
    this.mLog.dl("onStart called");
    super.onStart();
    reloadContent();
  }
  
  public void redrawList()
  {
    if (this.aFI != null) {
      this.aFI.invalidateViews();
    }
  }
  
  public void reloadContent()
  {
    dB("");
    setLoadingViews(true);
  }
  
  public void remove(int paramInt) {}
  
  private class a
    extends AsyncTask<Integer, Void, au.b>
  {
    private long aCg;
    
    public a(long paramLong)
    {
      this.aCg = paramLong;
    }
    
    protected void a(au.b paramb)
    {
      if (!paramb.aFQ)
      {
        au.c(au.this).dl("Async pageMoved failed");
        Toast.makeText(au.d(au.this), OperationStatus.avU.Ds(), 0).show();
      }
      do
      {
        return;
        au.c(au.this).dl("Async pageMove finished");
        au.this.reloadContent();
      } while (paramb.aFR == null);
      au.e(au.this).a(au.this.getTag(), paramb.aFR);
    }
    
    protected au.b b(Integer... paramVarArgs)
    {
      Integer localInteger = paramVarArgs[0];
      paramVarArgs = paramVarArgs[1];
      au.c(au.this).dl("Async page move started, docId=" + this.aCg + ", from idx " + localInteger + ", to idx " + paramVarArgs);
      au.b localb = new au.b(au.this, null);
      DocumentModel localDocumentModel = new DocumentModel();
      localb.aFQ = localDocumentModel.a(this.aCg, localInteger.intValue(), paramVarArgs.intValue());
      if (localb.aFQ) {
        localb.aFR = localDocumentModel.ae(this.aCg);
      }
      return localb;
    }
  }
  
  private class b
  {
    boolean aFQ = false;
    b aFR = null;
    
    private b() {}
  }
  
  private class c
    implements FilterQueryProvider
  {
    private DocumentModel aBL = new DocumentModel();
    private long aFS;
    
    public c() {}
    
    public void FY()
    {
      this.aFS = au.b(au.this);
    }
    
    public Cursor runQuery(CharSequence paramCharSequence)
    {
      return this.aBL.ah(this.aFS);
    }
  }
  
  private class d
    implements e.b
  {
    private d() {}
    
    public boolean setViewValue(View paramView, Cursor paramCursor, int paramInt)
    {
      boolean bool2 = false;
      if (paramInt == paramCursor.getColumnIndex("page_idx_within_doc")) {
        ((TextView)paramView).setText(String.valueOf(paramCursor.getInt(paramInt)));
      }
      long l1;
      long l2;
      do
      {
        return true;
        if (paramInt != paramCursor.getColumnIndex("page_raw_image_id")) {
          break;
        }
        int i = paramCursor.getPosition();
        l1 = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
        l2 = paramCursor.getLong(paramCursor.getColumnIndex("page_last_modification_time"));
        au.c(au.this).dl("PageViewBinder.setViewValue called for column " + paramInt + ", cursor position=" + i + ", view=" + d.ay(paramView) + ", pageId=" + l1 + ", timestamp=" + l2);
      } while ((au.e(au.this) == null) || ((!au.j(au.this)) && (!au.k(au.this))));
      au.e(au.this).Hk().a(l1, l2, paramView);
      return true;
      if (paramInt == paramCursor.getColumnIndex("_id"))
      {
        boolean bool1 = bool2;
        if (au.e(au.this) != null)
        {
          l1 = au.e(au.this).Hj().IO();
          bool1 = bool2;
          if (l1 >= 0L)
          {
            bool1 = bool2;
            if (l1 == paramCursor.getLong(paramInt)) {
              bool1 = true;
            }
          }
        }
        ((RadioButton)paramView).setChecked(bool1);
        return true;
      }
      return false;
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
      synchronized (au.l(au.this))
      {
        for (;;)
        {
          boolean bool = au.m(au.this);
          if (!bool) {
            break;
          }
          try
          {
            au.l(au.this).wait();
          }
          catch (InterruptedException localInterruptedException) {}
        }
        au.b(au.this, true);
        long l = paramVarArgs[0].longValue();
        au.c(au.this).dl("Async set title page started, docId=" + this.aCg + ", pageId " + l);
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
        au.c(au.this).dl("Async set title page failed");
        Toast.makeText(au.d(au.this), OperationStatus.awm.Ds(), 0).show();
      }
      synchronized (au.l(au.this))
      {
        au.b(au.this, false);
        au.l(au.this).notifyAll();
        return;
        au.this.reloadContent();
      }
    }
  }
  
  private class f
    extends e
    implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, DragAndDropGridViewV3.b
  {
    f(Context paramContext, int paramInt1, Cursor paramCursor, String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt2)
    {
      super(paramInt1, paramCursor, paramArrayOfString, paramArrayOfInt, paramInt2);
    }
    
    public void F(int paramInt1, int paramInt2)
    {
      super.F(paramInt1, paramInt2);
      ((PageGridActivity)au.d(au.this)).bl(true);
    }
    
    public Bitmap getDragBitmap(int paramInt)
    {
      au.c(au.this).dl("getDragBitmap idx = " + paramInt);
      View localView = au.f(au.this).getChildAt(paramInt);
      if (localView != null)
      {
        localView.setDrawingCacheEnabled(true);
        if (localView.getDrawingCache() != null) {}
        for (localBitmap = Bitmap.createBitmap(localView.getDrawingCache());; localBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565))
        {
          localView.setDrawingCacheEnabled(false);
          return localBitmap;
        }
      }
      Bitmap localBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
      au.c(au.this).dl("get bitmap for index " + paramInt + " failed because there is no such child");
      return localBitmap;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = 0;
      paramViewGroup = super.getView(paramInt, paramView, paramViewGroup);
      boolean bool;
      long l;
      if ((au.e(au.this).Fp() != null) || (au.e(au.this).Hv()))
      {
        bool = true;
        au.a(au.this, paramViewGroup, bool, paramInt);
        if (this.mCursor.moveToPosition(paramInt))
        {
          l = this.mCursor.getLong(this.mCursor.getColumnIndex("page_proc_image_id"));
          if (-1L == l) {
            break label219;
          }
        }
      }
      for (;;)
      {
        ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131165457);
        localImageView.setVisibility(i);
        int k = this.mCursor.getInt(this.mCursor.getColumnIndex("page_image_version"));
        int j = 2130837774;
        i = j;
        if (l != -1L)
        {
          i = j;
          if (k == 0) {
            i = 2130837775;
          }
        }
        localImageView.setImageDrawable(au.this.getResources().getDrawable(i));
        localImageView.setOnClickListener(au.this);
        if (paramView != null) {
          au.f(au.this).b(paramInt, paramViewGroup);
        }
        return paramViewGroup;
        bool = false;
        break;
        label219:
        i = 8;
      }
    }
    
    public void moveItem(int paramInt1, int paramInt2)
    {
      au.c(au.this).dl("moveItem from = " + paramInt1 + " ; to = " + paramInt2);
      F(paramInt1, paramInt2);
      if ((au.e(au.this) != null) && (au.e(au.this).Hj() != null)) {
        new au.a(au.this, au.b(au.this)).execute(new Integer[] { Integer.valueOf(paramInt1 + 1), Integer.valueOf(paramInt2 + 1) });
      }
    }
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
    
    public void onClick(View paramView)
    {
      int i = paramView.getId();
      int j = au.f(au.this).getPositionForView(paramView);
      long l = au.f(au.this).getItemIdAtPosition(j);
      if (2131165548 == i)
      {
        paramView = getCursor();
        if (paramView.moveToPosition(j))
        {
          paramView = new com.mobisystems.mobiscanner.model.c(au.e(au.this).Hj(), paramView);
          au.a(au.this, j, paramView);
        }
      }
      while (2131165547 != i)
      {
        return;
        au.c(au.this).A("Could not move cursor to position " + j);
        return;
      }
      i = 0;
      if (au.i(au.this).contains(Long.valueOf(l)))
      {
        au.i(au.this).remove(Long.valueOf(l));
        if (i == 0) {
          break label215;
        }
      }
      label215:
      for (i = 2130837884;; i = 2130837883)
      {
        paramView.setBackgroundResource(i);
        au.e(au.this).a(au.this.getTag(), au.this.getCheckedItemIds());
        return;
        au.i(au.this).add(Long.valueOf(l));
        i = 1;
        break;
      }
    }
    
    public void performLongClick(int paramInt)
    {
      if (((au.d(au.this) != null) && (au.e(au.this).Fp() != null)) || (au.e(au.this).Ho())) {
        return;
      }
      ((PageGridActivity)au.d(au.this)).bl(true);
      long l = au.f(au.this).getItemIdAtPosition(paramInt);
      Object localObject = au.f(au.this).getChildAt(paramInt - au.f(au.this).getFirstVisiblePosition());
      au.f(au.this).b(paramInt, (View)localObject);
      ((PageGridActivity)au.d(au.this)).Z(l);
      localObject = new ak();
      Bundle localBundle = new Bundle();
      localBundle.putLong("doc_id", au.b(au.this));
      localBundle.putLong("PAGE_CONTEXT_ID", l);
      localBundle.putInt("PAGE_CONTEXT_POSITION", paramInt);
      ((ak)localObject).setArguments(localBundle);
      ((ak)localObject).a(au.this);
      ((ak)localObject).show(au.d(au.this).getSupportFragmentManager(), "");
    }
    
    public Cursor swapCursor(Cursor paramCursor)
    {
      if (paramCursor != null) {
        au.a(au.this, false);
      }
      if ((au.g(au.this) != 0) || (au.h(au.this) != 0))
      {
        au.f(au.this).setSelection(au.g(au.this));
        au.f(au.this).smoothScrollBy(au.h(au.this), 0);
        au.a(au.this, 0);
        au.b(au.this, 0);
      }
      return super.swapCursor(paramCursor);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */