package com.mobisystems.pdf.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.mobisystems.pdf.PDFDocument;
import com.mobisystems.pdf.PDFError;
import com.mobisystems.pdf.PDFMatrix;
import com.mobisystems.pdf.PDFPage;
import com.mobisystems.pdf.PDFPoint;
import com.mobisystems.pdf.PDFQuadrilateral;
import com.mobisystems.pdf.PDFSize;
import com.mobisystems.pdf.PDFText;
import com.mobisystems.pdf.PDFText.OffsetResult;
import com.mobisystems.pdf.PDFText.TextRegion;
import com.mobisystems.pdf.R.id;
import com.mobisystems.pdf.R.layout;
import com.mobisystems.pdf.annotation.Annotation;
import com.mobisystems.pdf.annotation.FreeTextAnnotation;
import com.mobisystems.pdf.annotation.InkAnnotation;
import com.mobisystems.pdf.annotation.MarkupAnnotation;
import com.mobisystems.pdf.annotation.TextAnnotation;
import com.mobisystems.pdf.annotation.TextMarkupAnnotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class PDFView
  extends ViewGroup
  implements View.OnClickListener
{
  private static final String TAG = "PDFView";
  static final int _pageMargin = 4;
  private AnnotationEditorView _annotationEditor;
  private Rect _childBB = new Rect();
  Annotation _clickedAnnotation;
  PDFSize _contentSize = new PDFSize();
  int _currentHighlight = -1;
  PDFDocument _document;
  protected int _firstPageIndex;
  int _firstVisiblePageIndex;
  float _firstVisiblePageVOffset;
  protected GestureDetector _gestureDetector = new GestureDetector(paramContext, this._onGestureListener);
  protected String _highlightedText;
  int _highlightedTextLength;
  boolean _loadingBitmap = false;
  protected GestureDetector.OnGestureListener _onGestureListener = new GestureDetector.SimpleOnGestureListener()
  {
    public boolean onDown(MotionEvent paramAnonymousMotionEvent)
    {
      PDFView.this.endSelection();
      PDFView.VisiblePage localVisiblePage = PDFView.this.findVisiblePageByPoint(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY());
      if ((localVisiblePage == null) || (!localVisiblePage.isInitialized())) {}
      do
      {
        do
        {
          return true;
        } while (!localVisiblePage.isInitialized());
        paramAnonymousMotionEvent = new PDFPoint(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY());
      } while (!localVisiblePage.deviceToUserPoint(paramAnonymousMotionEvent));
      PDFView.this._clickedAnnotation = localVisiblePage.page.getAnnotationByPt(paramAnonymousMotionEvent.x, paramAnonymousMotionEvent.y);
      return true;
    }
    
    public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      PDFView.this.removeClickedAnnotation();
      int j = PDFView.this.computeHorizontalScrollRange() - PDFView.this.getWidth();
      if (j < 0) {
        j = PDFView.this.getScrollX();
      }
      for (int i = j;; i = 0)
      {
        int m = PDFView.this.computeVerticalScrollRange() - PDFView.this.getHeight();
        if (m < 0) {
          m = PDFView.this.getScrollY();
        }
        for (int k = m;; k = 0)
        {
          PDFView.this._scroller.fling(PDFView.this.getScrollX(), PDFView.this.getScrollY(), (int)-paramAnonymousFloat1, (int)-paramAnonymousFloat2, i, j, k, m);
          paramAnonymousMotionEvent1 = new Runnable()
          {
            public void run()
            {
              if (PDFView.this._scroller.computeScrollOffset())
              {
                PDFView.this.scrollTo(PDFView.this._scroller.getCurrX(), PDFView.this._scroller.getCurrY());
                if (!PDFView.this._scroller.isFinished()) {
                  PDFView.this.postDelayed(this, 42L);
                }
              }
            }
          };
          PDFView.this.post(paramAnonymousMotionEvent1);
          return true;
        }
      }
    }
    
    public void onLongPress(MotionEvent paramAnonymousMotionEvent)
    {
      PDFView.this.endSelection();
      PDFView.this.closeContextMenu();
      if (PDFView.this._clickedAnnotation != null) {
        if (!PDFView.this.isEditingAnnotation()) {}
      }
      do
      {
        PDFView.VisiblePage localVisiblePage;
        do
        {
          do
          {
            return;
          } while ((PDFView.this._onStateChangeListener == null) || (PDFView.this._onStateChangeListener.onAnnotationLongPress(PDFView.this, PDFView.this._clickedAnnotation)));
          PDFView.this.editAnnotation(PDFView.this._clickedAnnotation, false);
          return;
          localVisiblePage = PDFView.this.findVisiblePageByPoint(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY());
        } while ((localVisiblePage == null) || (!localVisiblePage.isInitialized()));
        PDFView.this.contextMenuPoint.x = ((int)paramAnonymousMotionEvent.getX());
        PDFView.this.contextMenuPoint.y = ((int)paramAnonymousMotionEvent.getY());
        PDFView.this.contextMenuContentPoint.set(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY());
        localVisiblePage.deviceToUserPoint(PDFView.this.contextMenuContentPoint);
        paramAnonymousMotionEvent = new PDFText.OffsetResult();
        localVisiblePage.getText().getOffset(PDFView.this.contextMenuContentPoint.x, PDFView.this.contextMenuContentPoint.y, true, paramAnonymousMotionEvent);
        if (paramAnonymousMotionEvent.offset >= 0)
        {
          PDFText.TextRegion localTextRegion = localVisiblePage.getText().getWord(paramAnonymousMotionEvent.offset);
          if (localTextRegion != null)
          {
            Log.d("PDFView", "Starting selection " + paramAnonymousMotionEvent);
            PDFView.this.startSelection(localVisiblePage, localTextRegion, paramAnonymousMotionEvent.lineIdx);
            return;
          }
        }
      } while ((PDFView.this._onStateChangeListener != null) && (PDFView.this._onStateChangeListener.onContextMenu(PDFView.ContextMenuType.LONG_PRESS_ON_EMPTY, true, PDFView.this.contextMenuPoint)));
      PDFView.this.openContextMenu();
    }
    
    public boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      PDFView.this.removeClickedAnnotation();
      int j = PDFView.this.getScrollX();
      int k = PDFView.this.computeHorizontalScrollRange() - PDFView.this.getWidth();
      int i = j;
      if (k > 0) {
        i = PDFView.getUnsigned(j + (int)(paramAnonymousFloat1 + 0.5D), k);
      }
      k = PDFView.this.getScrollY();
      int m = PDFView.this.computeVerticalScrollRange() - PDFView.this.getHeight();
      j = k;
      if (m > 0) {
        j = PDFView.getUnsigned(k + (int)(paramAnonymousFloat2 + 0.5D), m);
      }
      if ((i == PDFView.this.getScrollX()) && (j == PDFView.this.getScrollY())) {
        return false;
      }
      PDFView.this.scrollTo(i, j);
      return true;
    }
    
    public void onShowPress(MotionEvent paramAnonymousMotionEvent) {}
    
    public boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
    {
      boolean bool2 = false;
      PDFView.this.endSelection();
      PDFView.this.closeContextMenu();
      boolean bool1 = bool2;
      if (PDFView.this._clickedAnnotation != null)
      {
        bool1 = bool2;
        if (PDFView.this._onStateChangeListener != null) {
          bool1 = PDFView.this._onStateChangeListener.onAnnotationClick(PDFView.this, PDFView.this._clickedAnnotation);
        }
      }
      return bool1;
    }
  };
  protected ScaleGestureDetector.OnScaleGestureListener _onScaleGestureListener = new ScaleGestureDetector.OnScaleGestureListener()
  {
    public boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector)
    {
      float f1 = paramAnonymousScaleGestureDetector.getScaleFactor();
      int i;
      float f2;
      if (f1 < 1.0F)
      {
        i = 1;
        f2 = f1 * PDFView.this._scale;
        if (i == 0) {
          break label103;
        }
        if (PDFView.this._contentSize.width <= PDFView.this.getWidth()) {
          break label108;
        }
      }
      label103:
      label108:
      for (f1 = PDFView.this.getWidth() / PDFView.this._contentSize.width;; f1 = 1.0F)
      {
        if (f2 < f1) {}
        for (;;)
        {
          PDFView.this.scaleTo(f1, (int)paramAnonymousScaleGestureDetector.getFocusX(), (int)paramAnonymousScaleGestureDetector.getFocusY());
          return true;
          i = 0;
          break;
          f1 = f2;
        }
      }
    }
    
    public boolean onScaleBegin(ScaleGestureDetector paramAnonymousScaleGestureDetector)
    {
      PDFView.this.removeClickedAnnotation();
      return true;
    }
    
    public void onScaleEnd(ScaleGestureDetector paramAnonymousScaleGestureDetector) {}
  };
  protected OnStateChangeListener _onStateChangeListener;
  ArrayList<PageInfo> _pages = new ArrayList();
  Paint _paint = new Paint();
  RectF _rectDest = new RectF();
  Rect _rectSrc = new Rect();
  protected float _scale = 1.0F;
  protected ScaleGestureDetector _scaleGestureDetector;
  protected ScaleMode _scaleMode = ScaleMode.FIT_INSIDE;
  Scroller _scroller;
  private TextSelectionView _selectionView;
  ArrayList<VisiblePage> _visiblePages = new ArrayList();
  private LinearLayout contextMenu;
  private PDFPoint contextMenuContentPoint = new PDFPoint();
  private Point contextMenuPoint = new Point();
  private int defaultAnnotationColor = 16776960;
  private float defaultAnnotationLineWidth = 4.0F;
  private int defaultAnnotationOpacity = 255;
  
  public PDFView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public PDFView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PDFView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this._scroller = new Scroller(paramContext);
    this._scaleGestureDetector = new ScaleGestureDetector(paramContext, this._onScaleGestureListener);
    setWillNotDraw(false);
  }
  
  private void closeContextMenu()
  {
    if ((this._onStateChangeListener != null) && (this._onStateChangeListener.onContextMenu(ContextMenuType.LONG_PRESS_ON_EMPTY, false, null))) {}
    while (this.contextMenu == null) {
      return;
    }
    removeView(this.contextMenu);
    this.contextMenu = null;
  }
  
  static int getUnsigned(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 < 0) {
      i = 0;
    }
    do
    {
      return i;
      i = paramInt2;
    } while (paramInt1 > paramInt2);
    return paramInt1;
  }
  
  private void openContextMenu()
  {
    this.contextMenu = ((LinearLayout)LayoutInflater.from(getContext()).inflate(R.layout.pdf_long_press_context_menu, null));
    addView(this.contextMenu);
    this.contextMenu.findViewById(R.id.context_menu_add_note).setOnClickListener(this);
    this.contextMenu.findViewById(R.id.context_menu_add_free_text).setOnClickListener(this);
    this.contextMenu.findViewById(R.id.context_menu_add_free_draw).setOnClickListener(this);
  }
  
  public void addAnnotationView(Annotation paramAnnotation)
  {
    VisiblePage localVisiblePage = getVisiblePageByPageNumber(paramAnnotation.getPage());
    AnnotationView localAnnotationView;
    if ((localVisiblePage != null) && (localVisiblePage.isInitialized())) {
      localAnnotationView = new AnnotationView(getContext());
    }
    try
    {
      localAnnotationView.init(localVisiblePage, paramAnnotation);
      addView(localAnnotationView);
      return;
    }
    catch (PDFError paramAnnotation)
    {
      paramAnnotation.printStackTrace();
    }
  }
  
  public void closeAnnotationEditor(boolean paramBoolean)
  {
    if (this._annotationEditor == null) {
      return;
    }
    if (!paramBoolean) {
      if (getAnnotationEditor().canUndo())
      {
        getAnnotationEditor().undoAnnotation();
        reloadContent();
      }
    }
    for (;;)
    {
      removeView(this._annotationEditor);
      AnnotationEditorView localAnnotationEditorView = this._annotationEditor;
      this._annotationEditor = null;
      if (this._onStateChangeListener == null) {
        break;
      }
      this._onStateChangeListener.onAnnotationEditorDismiss(this, localAnnotationEditorView);
      return;
      getAnnotationEditor().removeAnnotation();
      continue;
      getAnnotationEditor().storeAnnotation();
      reloadContent();
    }
  }
  
  protected int computeHorizontalScrollExtent()
  {
    return getWidth();
  }
  
  protected int computeHorizontalScrollOffset()
  {
    return getScrollX();
  }
  
  protected int computeHorizontalScrollRange()
  {
    return (int)(this._scale * this._contentSize.width + 0.5D);
  }
  
  protected int computeVerticalScrollExtent()
  {
    return getHeight();
  }
  
  protected int computeVerticalScrollOffset()
  {
    return getScrollY();
  }
  
  protected int computeVerticalScrollRange()
  {
    float f2 = this._contentSize.height;
    float f1 = f2;
    if (this._pages.size() > 1) {
      f1 = f2 + (this._pages.size() - 1) * 4;
    }
    return (int)(f1 * this._scale + 0.5D);
  }
  
  public AnnotationEditorView createAnnotation(Class<? extends Annotation> paramClass)
  {
    float f1 = 100.0F;
    AnnotationEditorView localAnnotationEditorView = startAnnotationEditor(paramClass);
    if ((!(localAnnotationEditorView instanceof InkEditor)) || (!(localAnnotationEditorView instanceof TextMarkupEditor)))
    {
      if (!TextAnnotation.class.isAssignableFrom(paramClass)) {
        break label76;
      }
      f1 = 18.0F;
    }
    label76:
    for (float f2 = 18.0F;; f2 = 100.0F)
    {
      localAnnotationEditorView.addAnnotation(paramClass, f2, f1);
      if (this._onStateChangeListener != null) {
        this._onStateChangeListener.onAnnotationEditorStart(this, localAnnotationEditorView, true);
      }
      return localAnnotationEditorView;
    }
  }
  
  public void createAnnotationAtContextMenuPoint(Class<? extends Annotation> paramClass)
  {
    Annotation localAnnotation = null;
    VisiblePage localVisiblePage = findVisiblePageByPoint(this.contextMenuPoint.x, this.contextMenuPoint.y);
    try
    {
      if (TextAnnotation.class.equals(paramClass))
      {
        paramClass = new PDFPoint(this.contextMenuContentPoint.x + 18.0F, this.contextMenuContentPoint.y + 18.0F);
        localAnnotation = localVisiblePage.page.addAnnotation(TextAnnotation.class, this.contextMenuContentPoint, paramClass);
      }
      while (localAnnotation != null)
      {
        localAnnotation.setColor(getDefaultAnnotationColor());
        editAnnotation(localAnnotation, true);
        return;
        if (FreeTextAnnotation.class.equals(paramClass)) {
          localAnnotation = localVisiblePage.page.addAnnotation(FreeTextAnnotation.class, this.contextMenuContentPoint, this.contextMenuContentPoint);
        }
      }
      return;
    }
    catch (PDFError paramClass)
    {
      paramClass.printStackTrace();
    }
  }
  
  public int currentHighlight()
  {
    return this._currentHighlight;
  }
  
  public int currentPage()
  {
    int i = this._firstVisiblePageIndex;
    float f1 = this._firstVisiblePageVOffset;
    Iterator localIterator = this._visiblePages.iterator();
    for (;;)
    {
      VisiblePage localVisiblePage;
      if (localIterator.hasNext())
      {
        localVisiblePage = (VisiblePage)localIterator.next();
        if (this._scale * f1 < getScrollY()) {
          break label58;
        }
      }
      label58:
      float f2;
      do
      {
        return i;
        f2 = localVisiblePage.getHeightPlusMargin();
      } while ((f1 + f2) * this._scale >= getScrollY() + getHeight());
      i += 1;
      f1 = f2 + f1;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (((this._annotationEditor != null) || (this._selectionView != null)) && ((paramMotionEvent.getAction() & 0xFF) == 0)) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    return bool;
  }
  
  protected void drawPage(Canvas paramCanvas, VisiblePage paramVisiblePage)
  {
    this._rectDest.set(0.0F, 0.0F, paramVisiblePage.info.scaledWidth(), paramVisiblePage.info.scaledHeight());
    this._paint.setColor(-1);
    paramCanvas.drawRect(this._rectDest, this._paint);
    if (paramVisiblePage.bmpPage != null)
    {
      this._rectSrc.set(0, 0, paramVisiblePage.bmpPage.getWidth(), paramVisiblePage.bmpPage.getHeight());
      paramCanvas.drawBitmap(paramVisiblePage.bmpPage, this._rectSrc, this._rectDest, this._paint);
    }
    if ((paramVisiblePage.bmpFragment != null) && ((paramVisiblePage.bmpPage == null) || (paramVisiblePage.bmpPage.getWidth() != paramVisiblePage.info.scaledWidth())))
    {
      this._rectSrc.set(0, 0, paramVisiblePage.bmpFragment.getWidth(), paramVisiblePage.bmpFragment.getHeight());
      float f1 = paramVisiblePage.info.scaledWidth() / paramVisiblePage.fragmentPageWidth;
      this._rectDest.left = (paramVisiblePage.dxFragment * f1);
      this._rectDest.top = (paramVisiblePage.dyFragment * f1);
      this._rectDest.right = (this._rectDest.left + paramVisiblePage.bmpFragment.getWidth() * f1);
      RectF localRectF = this._rectDest;
      float f2 = this._rectDest.top;
      localRectF.bottom = (f1 * paramVisiblePage.bmpFragment.getHeight() + f2);
      paramCanvas.drawRect(this._rectDest, this._paint);
      paramCanvas.drawBitmap(paramVisiblePage.bmpFragment, this._rectSrc, this._rectDest, this._paint);
    }
    if (paramVisiblePage.bmpPage != null) {
      drawSearchResults(paramCanvas, paramVisiblePage);
    }
  }
  
  void drawSearchResults(Canvas paramCanvas, VisiblePage paramVisiblePage)
  {
    if (paramVisiblePage.searchResults.isEmpty()) {
      return;
    }
    for (;;)
    {
      Object localObject1;
      int j;
      try
      {
        PDFMatrix localPDFMatrix = paramVisiblePage.page.makeTransformMappingContentToRect(0.0F, 0.0F, paramVisiblePage.info.scaledWidth(), paramVisiblePage.info.scaledHeight());
        int i = this._currentHighlight;
        localObject1 = this._visiblePages.iterator();
        Object localObject2;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (VisiblePage)((Iterator)localObject1).next();
          if (!localObject2.equals(paramVisiblePage)) {}
        }
        else
        {
          localObject1 = new Paint();
          localObject2 = new PDFPoint();
          Iterator localIterator = paramVisiblePage.searchResults.iterator();
          j = 0;
          if (!localIterator.hasNext()) {
            break;
          }
          if (j != i) {
            break label251;
          }
          ((Paint)localObject1).setColor(Color.argb(96, 224, 96, 0));
          int k = ((Integer)localIterator.next()).intValue();
          paramVisiblePage.getText().setCursor(k, false);
          paramVisiblePage.getText().setCursor(k + this._highlightedTextLength, true);
          k = 0;
          if (k >= paramVisiblePage.getText().quadrilaterals()) {
            break label271;
          }
          paramCanvas.drawPath(Utils.quadraterialToPath(paramVisiblePage.getText().getQuadrilateral(k), localPDFMatrix, (PDFPoint)localObject2), (Paint)localObject1);
          k += 1;
          continue;
        }
        i -= ((VisiblePage)localObject2).searchResults.size();
      }
      catch (PDFError paramCanvas)
      {
        paramCanvas.printStackTrace();
        return;
      }
      continue;
      label251:
      ((Paint)localObject1).setColor(Color.argb(48, 224, 224, 0));
      continue;
      label271:
      j += 1;
    }
  }
  
  public void editAnnotation(Annotation paramAnnotation, boolean paramBoolean)
  {
    Class localClass = paramAnnotation.getClass();
    Object localObject = localClass;
    if (TextMarkupAnnotation.class.isAssignableFrom(localClass)) {
      localObject = MarkupAnnotation.class;
    }
    localObject = startAnnotationEditor((Class)localObject);
    ((AnnotationEditorView)localObject).editAnnotation(paramAnnotation);
    reloadContent();
    if (this._onStateChangeListener != null) {
      this._onStateChangeListener.onAnnotationEditorStart(this, (AnnotationEditorView)localObject, paramBoolean);
    }
  }
  
  public void endSelection()
  {
    if (this._selectionView != null)
    {
      removeView(this._selectionView);
      this._selectionView = null;
    }
  }
  
  protected VisiblePage findPage(PDFPage paramPDFPage)
  {
    Iterator localIterator = this._visiblePages.iterator();
    while (localIterator.hasNext())
    {
      VisiblePage localVisiblePage = (VisiblePage)localIterator.next();
      if (localVisiblePage.page == paramPDFPage) {
        return localVisiblePage;
      }
    }
    return null;
  }
  
  public VisiblePage findVisiblePageByPoint(float paramFloat1, float paramFloat2)
  {
    paramFloat2 += getScrollY();
    paramFloat1 += getScrollX();
    int i = (int)(this._firstVisiblePageVOffset * this._scale + 0.5D);
    Iterator localIterator = this._visiblePages.iterator();
    Object localObject1 = null;
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject2 = (VisiblePage)localIterator.next();
      if (paramFloat2 <= i)
      {
        localObject2 = localObject1;
        if (localObject1 != null) {
          if (paramFloat1 >= 0.0F)
          {
            localObject2 = localObject1;
            if (paramFloat1 <= ((VisiblePage)localObject1).info.scaledWidth()) {}
          }
          else
          {
            localObject2 = null;
          }
        }
      }
    }
    do
    {
      do
      {
        return (VisiblePage)localObject2;
        i = (int)(this._scale * ((VisiblePage)localObject2).getHeightPlusMargin() + 0.5D) + i;
        localObject1 = localObject2;
        break;
        if (paramFloat2 >= i) {
          break label180;
        }
        localObject2 = localObject1;
      } while (localObject1 == null);
      if (paramFloat1 < 0.0F) {
        break label178;
      }
      localObject2 = localObject1;
    } while (paramFloat1 <= ((VisiblePage)localObject1).info.scaledWidth());
    label178:
    return null;
    label180:
    return null;
  }
  
  public int firstRenderedPage()
  {
    return this._firstVisiblePageIndex;
  }
  
  public AnnotationEditorView getAnnotationEditor()
  {
    return this._annotationEditor;
  }
  
  public Integer getDefaultAnnotationColor()
  {
    return Integer.valueOf(this.defaultAnnotationColor);
  }
  
  public float getDefaultAnnotationLineWidth()
  {
    return this.defaultAnnotationLineWidth;
  }
  
  public int getDefaultAnnotationOpacity()
  {
    return this.defaultAnnotationOpacity;
  }
  
  public String getHighlightedText()
  {
    return this._highlightedText;
  }
  
  public int getHighlightsCount()
  {
    Iterator localIterator = this._visiblePages.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((VisiblePage)localIterator.next()).searchResults.size() + i) {}
    return i;
  }
  
  public OnStateChangeListener getOnSateChangeListener()
  {
    return this._onStateChangeListener;
  }
  
  public int getPageHighlighsCount(int paramInt)
  {
    paramInt -= firstRenderedPage();
    if ((paramInt < 0) || (paramInt >= renderedPagesCount())) {
      return 0;
    }
    return ((VisiblePage)this._visiblePages.get(paramInt)).searchResults.size();
  }
  
  float getScale()
  {
    return this._scale;
  }
  
  public TextSelectionView getTextSelectionView()
  {
    return this._selectionView;
  }
  
  public AnnotationView getViewByAnnotation(Annotation paramAnnotation)
  {
    VisiblePage localVisiblePage = getVisiblePageByPageNumber(paramAnnotation.getPage());
    if (localVisiblePage == null)
    {
      localObject = null;
      return (AnnotationView)localObject;
    }
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label78;
      }
      localObject = getChildAt(i);
      if ((localObject instanceof AnnotationView))
      {
        AnnotationView localAnnotationView = (AnnotationView)localObject;
        localObject = localAnnotationView;
        if (localAnnotationView.getAnnotation().equals(paramAnnotation)) {
          break;
        }
      }
      i += 1;
    }
    label78:
    Object localObject = new AnnotationView(getContext());
    try
    {
      ((AnnotationView)localObject).init(localVisiblePage, paramAnnotation);
      addView((View)localObject);
      return (AnnotationView)localObject;
    }
    catch (PDFError paramAnnotation)
    {
      paramAnnotation.printStackTrace();
    }
    return null;
  }
  
  public VisiblePage getVisiblePageByPageNumber(int paramInt)
  {
    paramInt -= this._firstPageIndex + this._firstVisiblePageIndex;
    if ((paramInt >= 0) && (paramInt < this._visiblePages.size())) {
      return (VisiblePage)this._visiblePages.get(paramInt);
    }
    return null;
  }
  
  public boolean isEditingAnnotation()
  {
    return getAnnotationEditor() != null;
  }
  
  protected void loadBackground(VisiblePage paramVisiblePage, boolean paramBoolean)
  {
    if (this._loadingBitmap) {}
    while (((!paramBoolean) && (paramVisiblePage.bmpPage != null)) || (paramVisiblePage.info.contentWidth <= 0.0F)) {
      return;
    }
    this._loadingBitmap = true;
    float f2 = getWidth() / paramVisiblePage.info.contentWidth;
    float f1 = f2;
    if (paramVisiblePage.info.contentHeight * f2 > getHeight()) {
      f1 = getHeight() / paramVisiblePage.info.contentHeight;
    }
    int i = (int)(paramVisiblePage.info.contentWidth * f1 + 0.5D);
    int j = (int)(f1 * paramVisiblePage.info.contentHeight + 0.5D);
    RequestQueue.post(new LoadBitmapRequest(paramVisiblePage.page, 0, 0, i, j, i, j));
  }
  
  protected void loadFragment(VisiblePage paramVisiblePage, int paramInt, boolean paramBoolean)
  {
    int i1 = 0;
    if (this._loadingBitmap) {}
    int m;
    int n;
    do
    {
      do
      {
        return;
      } while ((!paramVisiblePage.isInitialized()) || (paramVisiblePage.bmpPage == null));
      m = paramVisiblePage.info.scaledWidth();
      n = paramVisiblePage.info.scaledHeight();
    } while ((m == paramVisiblePage.bmpPage.getWidth()) && (n == paramVisiblePage.bmpPage.getHeight()));
    if (m > getWidth()) {}
    for (int j = getWidth();; j = m)
    {
      if (n > getHeight()) {}
      for (int i = getHeight();; i = n)
      {
        int i2 = getScrollX();
        int k = i2;
        if (i2 < 0) {
          k = 0;
        }
        if (k + j > m) {
          j = m - k;
        }
        for (;;)
        {
          paramInt = getScrollY() - paramInt;
          if (paramInt < 0) {
            paramInt = i1;
          }
          for (;;)
          {
            if (paramInt + i > n) {
              i = n - paramInt;
            }
            while ((j > 0) && (i > 0) && ((paramBoolean) || (paramVisiblePage.bmpFragment == null) || (paramVisiblePage.dxFragment != k) || (paramVisiblePage.dyFragment != paramInt) || (paramVisiblePage.fragmentPageWidth != m) || (paramVisiblePage.fragmentPageHeight != n) || (paramVisiblePage.bmpFragment.getWidth() != j) || (paramVisiblePage.bmpFragment.getHeight() != i)))
            {
              Log.i("PDFView", "loadFragment " + k + " " + paramInt + " " + j + " " + i + " " + m + " " + n);
              this._loadingBitmap = true;
              RequestQueue.post(new LoadBitmapRequest(paramVisiblePage.page, k, paramInt, j, i, m, n));
              return;
            }
            break;
          }
        }
      }
    }
  }
  
  public void onAnnotationPositionSet(Annotation paramAnnotation)
  {
    throw new RuntimeException("OPS: needs refactoring");
  }
  
  public void onClick(View paramView)
  {
    closeContextMenu();
    if (paramView.getId() == R.id.context_menu_add_free_draw) {
      createAnnotation(InkAnnotation.class);
    }
    do
    {
      return;
      if (paramView.getId() == R.id.context_menu_add_note)
      {
        createAnnotationAtContextMenuPoint(TextAnnotation.class);
        return;
      }
    } while (paramView.getId() != R.id.context_menu_add_free_text);
    createAnnotationAtContextMenuPoint(FreeTextAnnotation.class);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.translate(0.0F, this._firstVisiblePageVOffset * this._scale);
    float f1 = this._firstVisiblePageVOffset;
    Iterator localIterator = this._visiblePages.iterator();
    while (localIterator.hasNext())
    {
      VisiblePage localVisiblePage = (VisiblePage)localIterator.next();
      drawPage(paramCanvas, localVisiblePage);
      loadBackground(localVisiblePage, false);
      loadFragment(localVisiblePage, (int)(this._scale * f1 + 0.5D), false);
      float f2 = localVisiblePage.getHeightPlusMargin();
      paramCanvas.translate(0.0F, this._scale * f2);
      f1 = f2 + f1;
    }
    paramCanvas.translate(0.0F, -f1 * this._scale);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getChildCount();
    int i;
    if (this._annotationEditor != null)
    {
      paramInt2 = getScrollX();
      paramInt1 = paramInt2;
      if (paramInt2 < 0) {
        paramInt1 = 0;
      }
      paramInt3 = getScrollY();
      paramInt2 = paramInt3;
      if (paramInt3 < 0) {
        paramInt2 = 0;
      }
      paramInt4 = getWidth();
      paramInt3 = paramInt4;
      if (paramInt4 > computeHorizontalScrollRange()) {
        paramInt3 = computeHorizontalScrollRange();
      }
      i = getHeight();
      paramInt4 = i;
      if (i > computeVerticalScrollRange()) {
        paramInt4 = computeVerticalScrollRange();
      }
      this._annotationEditor.layout(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
    }
    Object localObject;
    if (this._selectionView != null)
    {
      localObject = this._selectionView.getPage();
      paramInt1 = (int)(((VisiblePage)localObject).getVOffset() * this._scale + 0.5F);
      this._selectionView.layout(0, paramInt1, ((VisiblePage)localObject).info.scaledWidth(), ((VisiblePage)localObject).info.scaledHeight() + paramInt1);
    }
    paramInt2 = 0;
    paramInt1 = 0;
    int k;
    if (paramInt2 < j)
    {
      localObject = getChildAt(paramInt2);
      if ((localObject instanceof LinearLayout))
      {
        if (((View)localObject).getId() != R.id.long_press_context_menu_id) {
          break label654;
        }
        i = this.contextMenuPoint.x;
        k = getScrollX();
        paramInt3 = this.contextMenuPoint.y;
        paramInt4 = getScrollY();
        i = Math.min(Math.max(i + k, getScrollX()), getWidth() + getScrollX() - ((View)localObject).getMeasuredWidth());
        paramInt3 = Math.min(Math.max(paramInt3 + paramInt4, getScrollY()), getHeight() + getScrollY() - ((View)localObject).getMeasuredHeight());
        ((View)localObject).layout(i, paramInt3, ((View)localObject).getMeasuredWidth() + i, ((View)localObject).getMeasuredHeight() + paramInt3);
      }
    }
    label654:
    for (;;)
    {
      paramInt2 += 1;
      break;
      if ((localObject instanceof AnnotationView))
      {
        localObject = (AnnotationView)localObject;
        VisiblePage localVisiblePage = getVisiblePageByPageNumber(((AnnotationView)localObject).getAnnotation().getPage());
        if (localVisiblePage == null)
        {
          Log.d("PDFView", "Annotation " + localObject + " is on invisible page");
          ((AnnotationView)localObject).setVisibility(4);
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          ((AnnotationView)localObject).setVisibility(0);
          k = localVisiblePage.info.scaledWidth();
          paramInt3 = localVisiblePage.info.scaledHeight();
          RectF localRectF = ((AnnotationView)localObject).getRelativeBoundingBox();
          Rect localRect = this._childBB;
          paramInt4 = (int)(localRectF.left * k + 0.5F);
          i = (int)(localRectF.top * paramInt3 + 0.5F);
          float f = localRectF.right;
          k = (int)(k * f + 0.5F);
          f = localRectF.bottom;
          localRect.set(paramInt4, i, k, (int)(paramInt3 * f + 0.5F));
          this._childBB.offset(0, (int)(localVisiblePage.getVOffset() * this._scale + 0.5F));
          ((AnnotationView)localObject).layout(this._childBB.left, this._childBB.top, this._childBB.right, this._childBB.bottom);
        }
      }
      if ((!(localObject instanceof AnnotationEditorView)) && (!(localObject instanceof TextSelectionView)))
      {
        throw new ClassCastException("Only AnnotationView and AnnotationEditorView instances are allowed for children of the PageView");
        Log.i("PDFView", "onLayout " + j + " annots=" + paramInt1);
        return;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = Integer.MAX_VALUE;
    int k = 1;
    int i = 0;
    int j;
    if (View.MeasureSpec.getMode(paramInt1) == 0)
    {
      i = 1;
      j = Integer.MAX_VALUE;
      if (View.MeasureSpec.getMode(paramInt1) != 0) {
        break label139;
      }
      paramInt2 = m;
    }
    for (paramInt1 = k;; paramInt1 = i)
    {
      setMeasuredDimension(j, paramInt2);
      if (paramInt1 == 0)
      {
        if (this._selectionView != null) {
          this._selectionView.measure(View.MeasureSpec.makeMeasureSpec(this._selectionView.getPage().info.scaledWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this._selectionView.getPage().info.scaledHeight(), 1073741824));
        }
        if (this.contextMenu != null) {
          this.contextMenu.measure(View.MeasureSpec.makeMeasureSpec(j, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(paramInt2, Integer.MIN_VALUE));
        }
      }
      return;
      j = View.MeasureSpec.getSize(paramInt1);
      break;
      label139:
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this._selectionView != null) {
      this._selectionView.requestLayout();
    }
    updateVisiblePages();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i("PDFView", "onSizeChanged " + paramInt1 + " " + paramInt2 + " " + paramInt3 + " " + paramInt4);
    int i = getScrollX();
    paramInt4 = getScrollY();
    paramInt3 = paramInt4;
    if (this._scale == 1.0F)
    {
      int j = computeVerticalScrollRange();
      updateLayout();
      paramInt3 = paramInt4;
      if (j > 0) {
        paramInt3 = paramInt4 * computeVerticalScrollRange() / j;
      }
    }
    if (paramInt1 > computeHorizontalScrollRange())
    {
      paramInt4 = (computeHorizontalScrollRange() - paramInt1) / 2;
      if (paramInt2 <= computeVerticalScrollRange()) {
        break label188;
      }
      paramInt1 = (computeVerticalScrollRange() - paramInt2) / 2;
    }
    for (;;)
    {
      scrollTo(paramInt4, paramInt1);
      return;
      paramInt4 = i;
      if (i + paramInt1 <= computeHorizontalScrollRange()) {
        break;
      }
      paramInt4 = computeHorizontalScrollRange() - paramInt1;
      break;
      label188:
      paramInt1 = paramInt3;
      if (paramInt3 + paramInt2 > computeVerticalScrollRange()) {
        paramInt1 = computeVerticalScrollRange() - paramInt2;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this._scaleGestureDetector.onTouchEvent(paramMotionEvent);
    if (this._scaleGestureDetector.isInProgress()) {}
    while (this._gestureDetector.onTouchEvent(paramMotionEvent)) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void refreshAnnotationViews()
  {
    int k = 0;
    Object localObject1 = new HashSet();
    Object localObject2 = this._visiblePages.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      VisiblePage localVisiblePage = (VisiblePage)((Iterator)localObject2).next();
      j = localVisiblePage.page.getAnnotationsCount();
      i = 0;
      label53:
      Annotation localAnnotation;
      if (i < j)
      {
        localAnnotation = localVisiblePage.page.getAnnotation(i);
        if (localAnnotation != null) {
          break label113;
        }
        Log.w("PDFView", "getAnnotation(" + i + ") returned null");
      }
      for (;;)
      {
        i += 1;
        break label53;
        break;
        label113:
        ((HashSet)localObject1).add(localAnnotation);
      }
    }
    int j = getChildCount() - 1;
    int i = k;
    if (j >= 0)
    {
      localObject2 = getChildAt(j);
      if ((!(localObject2 instanceof AnnotationView)) || (((HashSet)localObject1).remove(((AnnotationView)localObject2).getAnnotation()))) {
        break label259;
      }
      removeViewAt(j);
      i += 1;
    }
    label259:
    for (;;)
    {
      j -= 1;
      break;
      Log.d("PDFView", "refreshAnnotationViews removed " + i + " added " + ((HashSet)localObject1).size());
      localObject1 = ((HashSet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        addAnnotationView((Annotation)((Iterator)localObject1).next());
      }
      return;
    }
  }
  
  public void reloadContent()
  {
    float f = this._firstVisiblePageVOffset;
    Iterator localIterator = this._visiblePages.iterator();
    while (localIterator.hasNext())
    {
      VisiblePage localVisiblePage = (VisiblePage)localIterator.next();
      if (localVisiblePage.isInitialized())
      {
        loadBackground(localVisiblePage, true);
        loadFragment(localVisiblePage, (int)(this._scale * f + 0.5D), true);
      }
      f = localVisiblePage.getHeightPlusMargin() + f;
    }
  }
  
  void removeClickedAnnotation()
  {
    if (this._clickedAnnotation == null) {
      return;
    }
    this._clickedAnnotation = null;
    invalidate();
  }
  
  public int renderedPagesCount()
  {
    return this._visiblePages.size();
  }
  
  public void scaleTo(float paramFloat)
  {
    scaleTo(paramFloat, getWidth() / 2, getHeight() / 2);
  }
  
  public void scaleTo(float paramFloat, int paramInt1, int paramInt2)
  {
    this._scroller.forceFinished(true);
    float f1 = paramFloat / this._scale;
    this._scale = paramFloat;
    paramFloat = paramInt1;
    float f2 = paramInt1;
    float f3 = paramInt2;
    float f4 = paramInt2;
    paramInt1 = (int)(paramFloat * f1 - f2 + getScrollX() * f1 + 0.5D);
    paramInt2 = (int)(f1 * getScrollY() + (f3 * f1 - f4) + 0.5D);
    int i = computeHorizontalScrollRange();
    if (getWidth() > i)
    {
      paramInt1 = (i - getWidth()) / 2;
      i = computeVerticalScrollRange();
      if (getHeight() <= i) {
        break label155;
      }
    }
    label155:
    for (paramInt2 = (i - getHeight()) / 2;; paramInt2 = getUnsigned(paramInt2, i - getHeight()))
    {
      scrollTo(paramInt1, paramInt2);
      return;
      paramInt1 = getUnsigned(paramInt1, i - getWidth());
      break;
    }
  }
  
  public void scrollToPage(int paramInt)
  {
    if (this._pages.isEmpty()) {}
    while (computeVerticalScrollRange() < getHeight()) {
      return;
    }
    int i = paramInt;
    if (paramInt >= this._pages.size()) {
      i = this._pages.size() - 1;
    }
    float f = 0.0F;
    paramInt = 0;
    while (paramInt < i)
    {
      f += ((PageInfo)this._pages.get(paramInt)).getScaledHeightPlusMargin();
      paramInt += 1;
    }
    int j = getScrollX();
    i = (int)(this._scale * f + 0.5D);
    paramInt = i;
    if (getHeight() + i > computeVerticalScrollRange()) {
      paramInt = computeVerticalScrollRange() - getHeight();
    }
    scrollTo(j, paramInt);
  }
  
  public void setContent(PDFDocument paramPDFDocument)
  {
    if (paramPDFDocument != null) {}
    for (int i = paramPDFDocument.pageCount();; i = 0)
    {
      setContent(paramPDFDocument, 0, i);
      return;
    }
  }
  
  public void setContent(PDFDocument paramPDFDocument, int paramInt)
  {
    setContent(paramPDFDocument, paramInt, 1);
  }
  
  public void setContent(PDFDocument paramPDFDocument, int paramInt1, int paramInt2)
  {
    Log.i("PDFView", "setContent(" + paramPDFDocument + ", " + paramInt1 + ", " + paramInt2 + ")");
    if ((this._document == paramPDFDocument) && (paramInt1 == this._firstPageIndex) && (paramInt2 == this._pages.size())) {}
    do
    {
      return;
      this._document = paramPDFDocument;
      this._pages.clear();
    } while (paramPDFDocument == null);
    this._firstPageIndex = paramInt1;
    int i = 0;
    while (i < paramInt2)
    {
      paramPDFDocument = new PageInfo();
      this._pages.add(paramPDFDocument);
      i += 1;
    }
    updateLayout();
    scrollToPage(paramInt1);
  }
  
  void setCurrentHighlight(int paramInt)
  {
    this._currentHighlight = paramInt;
    invalidate();
    if (this._currentHighlight < 0) {
      return;
    }
    float f2 = this._firstVisiblePageVOffset;
    Object localObject = this._visiblePages.iterator();
    label31:
    VisiblePage localVisiblePage;
    if (((Iterator)localObject).hasNext())
    {
      localVisiblePage = (VisiblePage)((Iterator)localObject).next();
      if (paramInt >= localVisiblePage.searchResults.size()) {}
    }
    for (;;)
    {
      float f5;
      float f4;
      float f3;
      try
      {
        int i = localVisiblePage.info.scaledWidth();
        int j = localVisiblePage.info.scaledHeight();
        localObject = localVisiblePage.page.makeTransformMappingContentToRect(0.0F, 0.0F, i, j);
        paramInt = ((Integer)localVisiblePage.searchResults.get(paramInt)).intValue();
        localVisiblePage.getText().setCursor(paramInt, false);
        localVisiblePage.getText().setCursor(paramInt + this._highlightedTextLength, true);
        PDFPoint localPDFPoint = new PDFPoint();
        f1 = i;
        f5 = j;
        paramInt = 0;
        f4 = 0.0F;
        f3 = 0.0F;
        if (paramInt < localVisiblePage.getText().quadrilaterals())
        {
          PDFQuadrilateral localPDFQuadrilateral = localVisiblePage.getText().getQuadrilateral(paramInt);
          localPDFPoint.set(localPDFQuadrilateral.x1, localPDFQuadrilateral.y1);
          localPDFPoint.convert((PDFMatrix)localObject);
          f1 = Math.min(f1, localPDFPoint.x);
          f5 = Math.min(f5, localPDFPoint.y);
          f3 = Math.max(f3, localPDFPoint.x);
          f4 = Math.max(f4, localPDFPoint.y);
          localPDFPoint.set(localPDFQuadrilateral.x2, localPDFQuadrilateral.y2);
          localPDFPoint.convert((PDFMatrix)localObject);
          f1 = Math.min(f1, localPDFPoint.x);
          f5 = Math.min(f5, localPDFPoint.y);
          f3 = Math.max(f3, localPDFPoint.x);
          f4 = Math.max(f4, localPDFPoint.y);
          localPDFPoint.set(localPDFQuadrilateral.x3, localPDFQuadrilateral.y3);
          localPDFPoint.convert((PDFMatrix)localObject);
          f1 = Math.min(f1, localPDFPoint.x);
          f5 = Math.min(f5, localPDFPoint.y);
          f3 = Math.max(f3, localPDFPoint.x);
          f4 = Math.max(f4, localPDFPoint.y);
          localPDFPoint.set(localPDFQuadrilateral.x4, localPDFQuadrilateral.y4);
          localPDFPoint.convert((PDFMatrix)localObject);
          f1 = Math.min(f1, localPDFPoint.x);
          f5 = Math.min(f5, localPDFPoint.y);
          f3 = Math.max(f3, localPDFPoint.x);
          f4 = Math.max(f4, localPDFPoint.y);
          paramInt += 1;
          continue;
        }
        f5 = this._scale * f2 + f5;
        float f7 = f4 + f2 * this._scale;
        float f6 = getScrollX();
        f4 = getScrollY();
        f2 = f6;
        if (getWidth() + f6 < f3) {
          f2 = f3 - getWidth();
        }
        f3 = f4;
        if (getHeight() + f4 >= f7) {
          break label614;
        }
        f3 = f7 - getHeight();
      }
      catch (PDFError localPDFError)
      {
        localPDFError.printStackTrace();
        return;
      }
      scrollTo((int)f4, (int)f1);
      return;
      paramInt -= localPDFError.searchResults.size();
      f2 = localPDFError.info.getScaledHeightPlusMargin() + f2;
      break label31;
      break;
      label614:
      do
      {
        f1 = f3;
        break;
        f4 = f2;
        if (f2 > f1) {
          f4 = f1;
        }
      } while (f3 <= f5);
      float f1 = f5;
    }
  }
  
  public void setDefaultAnnotationColor(int paramInt)
  {
    this.defaultAnnotationColor = paramInt;
  }
  
  public void setDefaultAnnotationLineWidth(float paramFloat)
  {
    this.defaultAnnotationLineWidth = paramFloat;
  }
  
  public void setDefaultAnnotationOpacity(Integer paramInteger)
  {
    if ((paramInteger.intValue() < 0) || (paramInteger.intValue() > 255)) {
      throw new RuntimeException("opacity out of range [0, 0xff]");
    }
    this.defaultAnnotationOpacity = paramInteger.intValue();
  }
  
  public void setHighlightedText(String paramString)
  {
    if ((paramString != null) && (paramString.equals(this._highlightedText))) {
      return;
    }
    this._highlightedText = paramString;
    if ((paramString != null) && (paramString.length() == 0)) {
      this._highlightedText = null;
    }
    paramString = this._visiblePages.iterator();
    while (paramString.hasNext()) {
      ((VisiblePage)paramString.next()).updateHighlights();
    }
    invalidate();
  }
  
  public void setOnSateChangeListener(OnStateChangeListener paramOnStateChangeListener)
  {
    this._onStateChangeListener = paramOnStateChangeListener;
  }
  
  public void setScaleMode(ScaleMode paramScaleMode)
  {
    this._scaleMode = paramScaleMode;
    this._scale = 1.0F;
    updateLayout();
  }
  
  protected AnnotationEditorView startAnnotationEditor(Class<? extends Annotation> paramClass)
  {
    if (this._annotationEditor != null) {
      throw new IllegalStateException();
    }
    if (TextMarkupAnnotation.class.isAssignableFrom(paramClass)) {
      this._annotationEditor = new TextMarkupEditor(this);
    }
    for (;;)
    {
      addView(this._annotationEditor);
      return this._annotationEditor;
      if (InkAnnotation.class.isAssignableFrom(paramClass)) {
        this._annotationEditor = new InkEditor(this);
      } else {
        this._annotationEditor = new AnnotationEditorView(this);
      }
    }
  }
  
  public void startSelection(VisiblePage paramVisiblePage, PDFText.TextRegion paramTextRegion, int paramInt)
  {
    if (this._selectionView == null)
    {
      this._selectionView = new TextSelectionView(getContext());
      addView(this._selectionView);
    }
    this._selectionView.init(paramVisiblePage, paramTextRegion);
    this._selectionView.setSelectionLineIdx(paramInt);
  }
  
  protected void updateLayout()
  {
    int k = 0;
    if ((getWidth() == 0) || (getHeight() == 0)) {
      return;
    }
    int n = computeVerticalScrollRange();
    int j = getScrollY();
    this._contentSize.width = 0.0F;
    this._contentSize.height = 0.0F;
    this._firstVisiblePageVOffset = 0.0F;
    Iterator localIterator = this._pages.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      PageInfo localPageInfo = (PageInfo)localIterator.next();
      if (localPageInfo.contentWidth == 0.0F) {
        localPageInfo.contentHeight = getHeight();
      }
      localPageInfo.updateFitScale();
      float f1 = localPageInfo.pageScale * localPageInfo.contentWidth;
      float f2 = localPageInfo.pageScale;
      float f3 = localPageInfo.contentHeight;
      if (this._contentSize.width < f1) {
        this._contentSize.width = f1;
      }
      PDFSize localPDFSize = this._contentSize;
      localPDFSize.height = (f2 * f3 + localPDFSize.height);
      if (i < this._firstVisiblePageIndex)
      {
        f1 = this._firstVisiblePageVOffset;
        this._firstVisiblePageVOffset = (localPageInfo.getScaledHeightPlusMargin() + f1);
      }
      i += 1;
    }
    int m = getScrollX();
    if (computeHorizontalScrollRange() < computeHorizontalScrollExtent()) {
      i = (computeHorizontalScrollRange() - computeHorizontalScrollExtent()) / 2;
    }
    label397:
    label412:
    for (;;)
    {
      if (n > 0) {
        j = computeVerticalScrollRange() * j / n;
      }
      for (;;)
      {
        if (computeVerticalScrollRange() < computeVerticalScrollExtent())
        {
          j = (computeVerticalScrollRange() - computeVerticalScrollExtent()) / 2;
          scrollTo(i, j);
          updateVisiblePages();
          if (this._annotationEditor != null) {
            this._annotationEditor.refreshEdittedAnnotation();
          }
          if (this._selectionView == null) {
            break label397;
          }
          this._selectionView.requestLayout();
          return;
          i = m;
          if (m < 0) {
            i = 0;
          }
          if (computeHorizontalScrollExtent() + i <= computeHorizontalScrollRange()) {
            break label412;
          }
          i = computeHorizontalScrollRange() - computeHorizontalScrollExtent();
          break;
        }
        if (j < 0) {}
        for (;;)
        {
          j = k;
          if (computeVerticalScrollExtent() + k <= computeVerticalScrollRange()) {
            break;
          }
          j = computeVerticalScrollRange() - computeVerticalScrollExtent();
          break;
          requestLayout();
          return;
          k = j;
        }
      }
    }
  }
  
  protected void updateRenderedPages(float paramFloat1, float paramFloat2)
  {
    float f1 = paramFloat1 / this._scale;
    paramFloat2 /= this._scale;
    int i = this._firstVisiblePageIndex;
    paramFloat1 = this._firstVisiblePageVOffset;
    Object localObject2;
    int k;
    while ((i > 0) && (paramFloat1 > f1))
    {
      localObject2 = this._pages;
      i -= 1;
      paramFloat1 -= ((PageInfo)((ArrayList)localObject2).get(i)).getScaledHeightPlusMargin();
      continue;
      Object localObject1;
      paramFloat1 = localObject1 + paramFloat1;
      k += 1;
    }
    for (;;)
    {
      float f2;
      if (k + 1 < this._pages.size())
      {
        f2 = ((PageInfo)this._pages.get(k)).getScaledHeightPlusMargin();
        if (paramFloat1 + f2 <= f1) {
          break;
        }
      }
      i = 0;
      int m = 0;
      while ((k + m < this._pages.size()) && (i + paramFloat1 < f1 + paramFloat2))
      {
        localObject2 = (PageInfo)this._pages.get(m + k);
        f2 = i;
        i = (int)(((PageInfo)localObject2).getScaledHeightPlusMargin() + f2);
        m += 1;
      }
      for (int j = 0;; j = 1)
      {
        i = j;
        if (this._visiblePages.isEmpty()) {
          break;
        }
        i = j;
        if (this._firstVisiblePageIndex >= k) {
          break;
        }
        localObject2 = this._pages;
        i = this._firstVisiblePageIndex;
        this._firstVisiblePageIndex = (i + 1);
        localObject2 = (PageInfo)((ArrayList)localObject2).get(i);
        this._currentHighlight -= ((VisiblePage)this._visiblePages.get(0)).searchResults.size();
        this._visiblePages.remove(0);
        this._firstVisiblePageVOffset = (((PageInfo)localObject2).getScaledHeightPlusMargin() + this._firstVisiblePageVOffset);
      }
      while ((!this._visiblePages.isEmpty()) && (this._firstVisiblePageIndex + this._visiblePages.size() > k + m))
      {
        this._visiblePages.remove(this._visiblePages.size() - 1);
        i = 1;
      }
      if (!this._visiblePages.isEmpty()) {
        for (;;)
        {
          if (this._firstVisiblePageIndex > k) {
            try
            {
              i = this._firstVisiblePageIndex - 1;
              this._firstVisiblePageIndex = i;
              localObject2 = new VisiblePage(i);
              this._visiblePages.add(0, localObject2);
              paramFloat1 = ((PageInfo)this._pages.get(this._firstVisiblePageIndex)).getScaledHeightPlusMargin();
              this._firstVisiblePageVOffset -= paramFloat1;
              i = 1;
            }
            catch (PDFError localPDFError1)
            {
              localPDFError1.printStackTrace();
            }
          }
        }
      }
      do
      {
        return;
        this._firstVisiblePageIndex = k;
        this._firstVisiblePageVOffset = paramFloat1;
        while (this._visiblePages.size() < m) {
          try
          {
            VisiblePage localVisiblePage = new VisiblePage(this._firstVisiblePageIndex + this._visiblePages.size());
            this._visiblePages.add(localVisiblePage);
            i = 1;
          }
          catch (PDFError localPDFError2)
          {
            localPDFError2.printStackTrace();
            return;
          }
        }
      } while (i == 0);
      refreshAnnotationViews();
      return;
      k = i;
    }
  }
  
  protected void updateVisiblePages()
  {
    updateRenderedPages(getScrollY() - getHeight() / 2, getHeight() * 2);
  }
  
  public static enum ContextMenuType
  {
    LONG_PRESS_ON_EMPTY,  SELECTION;
    
    private ContextMenuType() {}
  }
  
  protected class LoadBitmapRequest
    extends RequestQueue.Request
  {
    Bitmap bitmap;
    int bitmap_height;
    int bitmap_width;
    int dx;
    int dy;
    PDFPage page;
    int page_height;
    int page_width;
    
    public LoadBitmapRequest(PDFPage paramPDFPage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      if ((paramPDFPage == null) || (paramInt3 <= 0) || (paramInt4 <= 0) || (paramInt5 <= 0) || (paramInt6 <= 0)) {
        throw new IllegalArgumentException();
      }
      this.page = paramPDFPage;
      this.bitmap_width = paramInt3;
      this.bitmap_height = paramInt4;
      this.page_width = paramInt5;
      this.page_height = paramInt6;
      this.dx = paramInt1;
      this.dy = paramInt2;
    }
    
    public void onAsyncExec()
    {
      PDFMatrix localPDFMatrix = this.page.makeTransformMappingContentToRect(-this.dx, -this.dy, this.page_width, this.page_height);
      int[] arrayOfInt = new int[this.bitmap_width * this.bitmap_height];
      int i = this.page.loadContent(localPDFMatrix, arrayOfInt, this.bitmap_width, null);
      this.bitmap = Bitmap.createBitmap(arrayOfInt, this.bitmap_width, this.bitmap_height, Bitmap.Config.ARGB_8888);
      PDFError.throwError(i);
    }
    
    public void onRequestFinished(Throwable paramThrowable)
    {
      Log.i("PDFView", "LoadBitmapRequest::onRequestFinished() page=-1");
      PDFView.this._loadingBitmap = false;
      PDFView.this.invalidate();
      PDFView.VisiblePage localVisiblePage = PDFView.this.findPage(this.page);
      if (localVisiblePage == null) {
        return;
      }
      if (this.bitmap != null)
      {
        if ((this.dx != 0) || (this.dy != 0) || (this.bitmap.getWidth() != this.page_width) || (this.bitmap.getHeight() != this.page_height)) {
          break label145;
        }
        localVisiblePage.bmpPage = this.bitmap;
        localVisiblePage.bmpFragment = null;
      }
      for (;;)
      {
        PDFView.this.requestLayout();
        if ((paramThrowable == null) || (PDFView.this._onStateChangeListener == null)) {
          break;
        }
        PDFView.this._onStateChangeListener.onContentLoadError(PDFView.this, localVisiblePage.getPageNumber(), paramThrowable);
        return;
        label145:
        localVisiblePage.bmpFragment = this.bitmap;
        localVisiblePage.dxFragment = this.dx;
        localVisiblePage.dyFragment = this.dy;
        localVisiblePage.fragmentPageWidth = this.page_width;
        localVisiblePage.fragmentPageHeight = this.page_height;
      }
    }
  }
  
  public static abstract interface OnStateChangeListener
  {
    public abstract boolean onAnnotationClick(PDFView paramPDFView, Annotation paramAnnotation);
    
    public abstract void onAnnotationEditorDismiss(PDFView paramPDFView, AnnotationEditorView paramAnnotationEditorView);
    
    public abstract void onAnnotationEditorStart(PDFView paramPDFView, AnnotationEditorView paramAnnotationEditorView, boolean paramBoolean);
    
    public abstract boolean onAnnotationLongPress(PDFView paramPDFView, Annotation paramAnnotation);
    
    public abstract void onContentLoadError(PDFView paramPDFView, int paramInt, Throwable paramThrowable);
    
    public abstract boolean onContextMenu(PDFView.ContextMenuType paramContextMenuType, boolean paramBoolean, Point paramPoint);
    
    public abstract void onPageLoadFailed(PDFView paramPDFView, int paramInt, Throwable paramThrowable);
    
    public abstract void onPageLoaded(PDFView paramPDFView, int paramInt);
  }
  
  protected class OpenPageRequest
    extends RequestQueue.Request
  {
    int index;
    PDFPage page;
    PDFSize size;
    PDFText text;
    
    OpenPageRequest(PDFPage paramPDFPage, int paramInt)
    {
      this.page = paramPDFPage;
      this.index = paramInt;
    }
    
    public void onAsyncExec()
    {
      this.page.open(this.index);
      this.size = this.page.getContentSize();
      this.text = new PDFText();
      this.page.loadContent(new PDFMatrix(), null, 0, this.text);
    }
    
    public void onRequestFinished(Throwable paramThrowable)
    {
      PDFView.VisiblePage localVisiblePage = PDFView.this.findPage(this.page);
      if (localVisiblePage == null) {}
      do
      {
        return;
        if (paramThrowable == null) {
          break;
        }
      } while (PDFView.this._onStateChangeListener == null);
      PDFView.this._onStateChangeListener.onPageLoadFailed(PDFView.this, this.index, paramThrowable);
      return;
      boolean bool;
      if ((localVisiblePage.info.contentWidth != this.size.width) || (localVisiblePage.info.contentHeight != this.size.height) || (localVisiblePage.info.userUnit != this.page.getUserUnit()))
      {
        bool = true;
        label115:
        localVisiblePage.text = this.text;
        Log.i("PDFView", "OpenPageRequest::onRequestFinished() page=" + this.index + " " + bool + " " + this.size);
        if (!bool) {
          break label382;
        }
        int i = localVisiblePage.info.scaledHeight();
        localVisiblePage.info.contentWidth = this.size.width;
        localVisiblePage.info.contentHeight = this.size.height;
        localVisiblePage.info.userUnit = this.page.getUserUnit();
        PDFView.this.updateLayout();
        int j = localVisiblePage.info.scaledHeight();
        if ((j != i) && (localVisiblePage.pageIndex() < PDFView.this.currentPage()))
        {
          j = j - i + PDFView.this.getScrollY();
          i = j;
          if (PDFView.this.computeVerticalScrollExtent() + j > PDFView.this.computeVerticalScrollRange()) {
            i = PDFView.this.computeVerticalScrollRange() - PDFView.this.computeVerticalScrollExtent();
          }
          PDFView.this.scrollTo(PDFView.this.getScrollX(), i);
        }
      }
      for (;;)
      {
        PDFView.this.refreshAnnotationViews();
        localVisiblePage.updateHighlights();
        if (PDFView.this._onStateChangeListener == null) {
          break;
        }
        PDFView.this._onStateChangeListener.onPageLoaded(PDFView.this, this.index);
        return;
        bool = false;
        break label115;
        label382:
        PDFView.this.invalidate();
      }
    }
  }
  
  class Page
    extends PDFPage
  {
    int index;
    
    public Page(PDFDocument paramPDFDocument)
    {
      super();
    }
    
    public boolean onWarning(int paramInt)
    {
      if (PDFView.this._onStateChangeListener != null) {
        PDFView.this._onStateChangeListener.onContentLoadError(PDFView.this, this.index, new PDFError(paramInt));
      }
      return true;
    }
    
    public void open(int paramInt)
    {
      this.index = paramInt;
      super.open(paramInt);
    }
  }
  
  protected class PageInfo
  {
    float contentHeight = 40.0F;
    float contentWidth = 0.0F;
    float pageScale = 1.0F;
    float userUnit = 1.0F;
    
    protected PageInfo() {}
    
    public float getScaledHeightPlusMargin()
    {
      return this.contentHeight * this.pageScale + 4.0F;
    }
    
    int scaledHeight()
    {
      return (int)(PDFView.this._scale * this.pageScale * this.contentHeight + 0.5D);
    }
    
    int scaledWidth()
    {
      return (int)(PDFView.this._scale * this.pageScale * this.contentWidth + 0.5D);
    }
    
    void updateFitScale()
    {
      if (PDFView.ScaleMode.KEEP_SIZE == PDFView.this._scaleMode) {
        this.pageScale = this.userUnit;
      }
      do
      {
        return;
        this.pageScale = 1.0F;
        if (this.contentWidth > 0.0F) {
          this.pageScale = (PDFView.this.getWidth() / this.contentWidth);
        }
      } while ((PDFView.ScaleMode.FIT_INSIDE != PDFView.this._scaleMode) || (this.contentHeight * this.pageScale <= PDFView.this.getHeight()));
      this.pageScale = (PDFView.this.getHeight() / this.contentHeight);
    }
  }
  
  public static enum ScaleMode
  {
    FIT_INSIDE,  FIT_WIDTH,  KEEP_SIZE;
    
    private ScaleMode() {}
  }
  
  public class VisiblePage
  {
    protected Bitmap bmpFragment;
    Bitmap bmpPage;
    int dxFragment;
    int dyFragment;
    int fragmentPageHeight;
    int fragmentPageWidth;
    protected PDFView.PageInfo info;
    protected PDFPage page;
    ArrayList<Integer> searchResults = new ArrayList();
    protected PDFText text;
    
    VisiblePage(int paramInt)
    {
      this.info = ((PDFView.PageInfo)PDFView.this._pages.get(paramInt));
      this.page = new PDFPage(PDFView.this._document);
      RequestQueue.post(new PDFView.OpenPageRequest(PDFView.this, this.page, PDFView.this._firstPageIndex + paramInt));
    }
    
    public PDFView container()
    {
      return PDFView.this;
    }
    
    public boolean deviceToUserPoint(PDFPoint paramPDFPoint)
    {
      PDFMatrix localPDFMatrix = makeTransformMatrix();
      if ((localPDFMatrix == null) || (!localPDFMatrix.invert())) {
        return false;
      }
      paramPDFPoint.convert(localPDFMatrix);
      return true;
    }
    
    public float getHeightPlusMargin()
    {
      return this.info.getScaledHeightPlusMargin();
    }
    
    public int getPageNumber()
    {
      int i = PDFView.this._visiblePages.indexOf(this);
      if (i < 0) {
        return i;
      }
      return i + (PDFView.this._firstVisiblePageIndex + PDFView.this._firstPageIndex);
    }
    
    public PDFText getText()
    {
      return this.text;
    }
    
    public float getVOffset()
    {
      float f = PDFView.this._firstVisiblePageVOffset;
      Iterator localIterator = PDFView.this._visiblePages.iterator();
      for (;;)
      {
        VisiblePage localVisiblePage;
        if (localIterator.hasNext())
        {
          localVisiblePage = (VisiblePage)localIterator.next();
          if (localVisiblePage != this) {}
        }
        else
        {
          return f;
        }
        f = localVisiblePage.getHeightPlusMargin() + f;
      }
    }
    
    public int height()
    {
      return this.info.scaledHeight();
    }
    
    boolean isInitialized()
    {
      return this.text != null;
    }
    
    public PDFMatrix makeTransformMatrix()
    {
      return makeTransformMatrix(PDFView.this.getScrollX(), PDFView.this.getScrollY() - (int)(getVOffset() * PDFView.this._scale + 0.5D));
    }
    
    public PDFMatrix makeTransformMatrix(int paramInt1, int paramInt2)
    {
      try
      {
        PDFMatrix localPDFMatrix = this.page.makeTransformMappingContentToRect(-paramInt1, -paramInt2, this.info.scaledWidth(), this.info.scaledHeight());
        return localPDFMatrix;
      }
      catch (PDFError localPDFError)
      {
        localPDFError.printStackTrace();
      }
      return null;
    }
    
    public void notifySelectionModificationEnd() {}
    
    public void notifySelectionModificationStart() {}
    
    public int pageIndex()
    {
      int i = PDFView.this._visiblePages.indexOf(this);
      if (i < 0) {
        return i;
      }
      return i + PDFView.this._firstVisiblePageIndex;
    }
    
    public void reloadContent()
    {
      this.bmpPage = null;
      this.bmpFragment = null;
      PDFView.this.invalidate();
    }
    
    protected void updateHighlights()
    {
      this.searchResults.clear();
      int i;
      if ((PDFView.this._highlightedText != null) && (isInitialized()))
      {
        PDFView.this._highlightedTextLength = PDFView.this._highlightedText.length();
        i = 0;
      }
      for (;;)
      {
        i = getText().indexOf(PDFView.this._highlightedText, i);
        if (i < 0) {
          return;
        }
        this.searchResults.add(Integer.valueOf(i));
        i += PDFView.this._highlightedTextLength;
      }
    }
    
    public boolean userToDevicePoint(PDFPoint paramPDFPoint)
    {
      PDFMatrix localPDFMatrix = makeTransformMatrix();
      if (localPDFMatrix == null) {
        return false;
      }
      paramPDFPoint.convert(localPDFMatrix);
      return true;
    }
    
    public int width()
    {
      return this.info.scaledWidth();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/PDFView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */