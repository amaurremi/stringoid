package com.mobisystems.pdf.ui;

import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.mobisystems.pdf.PDFError;
import com.mobisystems.pdf.PDFPage;
import com.mobisystems.pdf.PDFPoint;
import com.mobisystems.pdf.annotation.Annotation;
import com.mobisystems.pdf.annotation.FreeTextAnnotation;
import com.mobisystems.pdf.annotation.MarkupAnnotation;

public class AnnotationEditorView
  extends View
{
  protected static final String TAG = "AnnotationEditorView";
  Class<? extends Annotation> _annotationClass;
  private PDFView _container;
  GestureDetector _gestureDetector;
  float _initialAnnotationHeight;
  float _initialAnnotationWidth;
  GestureDetector.OnGestureListener _onGestureListener = new GestureDetector.SimpleOnGestureListener()
  {
    public boolean onDown(MotionEvent paramAnonymousMotionEvent)
    {
      return true;
    }
    
    public boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
    {
      Object localObject = new int[2];
      AnnotationEditorView.this.getPDFView().getLocationInWindow((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      AnnotationEditorView.this.getLocationInWindow((int[])localObject);
      int k = localObject[0];
      int m = localObject[1];
      float f1 = paramAnonymousMotionEvent.getX() - (i - k);
      float f2 = paramAnonymousMotionEvent.getY() - (j - m);
      if (!AnnotationEditorView.this.setPage(f1, f2)) {
        return true;
      }
      paramAnonymousMotionEvent = new PDFPoint(f1, f2);
      AnnotationEditorView.this.page.deviceToUserPoint(paramAnonymousMotionEvent);
      localObject = new PDFPoint(paramAnonymousMotionEvent.x + AnnotationEditorView.this._initialAnnotationWidth, paramAnonymousMotionEvent.y + AnnotationEditorView.this._initialAnnotationHeight);
      AnnotationEditorView.this.addAnnotation(AnnotationEditorView.this._annotationClass, paramAnonymousMotionEvent, (PDFPoint)localObject);
      return true;
    }
  };
  protected AnnotationView editedAnnotation;
  protected PDFView.VisiblePage page;
  protected boolean reloadAnnotationBitmapOnUpEvent;
  private UndoData undoData;
  
  public AnnotationEditorView(PDFView paramPDFView)
  {
    super(paramPDFView.getContext());
    this._container = paramPDFView;
  }
  
  public Annotation addAnnotation(Class<? extends Annotation> paramClass, PDFPoint paramPDFPoint1, PDFPoint paramPDFPoint2)
  {
    if (this.editedAnnotation != null) {
      throw new IllegalStateException("Annotation edition already in progress");
    }
    this._gestureDetector = null;
    try
    {
      paramClass = this.page.page.addAnnotation(paramClass, paramPDFPoint1, paramPDFPoint2);
      paramClass.setColor(this._container.getDefaultAnnotationColor());
      paramClass.setBorderWidth(this._container.getDefaultAnnotationLineWidth());
      if ((paramClass instanceof MarkupAnnotation)) {
        ((MarkupAnnotation)paramClass).setOpacity(this._container.getDefaultAnnotationOpacity());
      }
      this.editedAnnotation = new AnnotationView(getContext());
      this.editedAnnotation.init(this.page, paramClass);
      this._container.addView(this.editedAnnotation);
      this.page.page.lockAnnotation(paramClass);
      this.undoData = null;
      refreshEdittedAnnotation();
      return paramClass;
    }
    catch (PDFError paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public void addAnnotation(Class<? extends Annotation> paramClass, float paramFloat1, float paramFloat2)
  {
    if (this.editedAnnotation != null) {
      throw new IllegalStateException("Annotation edition already in progress");
    }
    this._annotationClass = paramClass;
    this._initialAnnotationWidth = paramFloat1;
    this._initialAnnotationHeight = paramFloat2;
    if (this._gestureDetector == null) {
      this._gestureDetector = new GestureDetector(getContext(), this._onGestureListener);
    }
  }
  
  public boolean canUndo()
  {
    return (this.editedAnnotation != null) && (this.undoData != null);
  }
  
  public void editAnnotation(Annotation paramAnnotation)
  {
    if (this.editedAnnotation != null) {
      throw new IllegalStateException("Annotation edition already in progress");
    }
    this.editedAnnotation = this._container.getViewByAnnotation(paramAnnotation);
    if (this.editedAnnotation == null) {
      return;
    }
    this.editedAnnotation.setDrawEditBox(true);
    this.page = this._container.getVisiblePageByPageNumber(paramAnnotation.getPage());
    this.page.page.lockAnnotation(paramAnnotation);
    this.undoData = new UndoData(null);
    UndoData.access$102(this.undoData, paramAnnotation.getColorRGB());
    UndoData.access$202(this.undoData, paramAnnotation.getContents());
    refreshEdittedAnnotation();
  }
  
  public Annotation getAnnotation()
  {
    if (this.editedAnnotation == null) {
      return null;
    }
    return this.editedAnnotation.getAnnotation();
  }
  
  public Class<? extends Annotation> getAnnotationClass()
  {
    if (getAnnotation() != null) {
      return getAnnotation().getClass();
    }
    return this._annotationClass;
  }
  
  public View getAnnotationView()
  {
    return this.editedAnnotation;
  }
  
  public PDFView getPDFView()
  {
    return this._container;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this._gestureDetector != null) {
      return this._gestureDetector.onTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void refreshEdittedAnnotation()
  {
    int j = 0;
    if (this.editedAnnotation == null) {
      return;
    }
    int k = getScrollX();
    int i = k;
    if (k < 0) {
      i = 0;
    }
    k = getScrollY();
    if (k < 0) {}
    for (;;)
    {
      this.editedAnnotation.refreshBoundingBox(this.page.info.contentWidth, this.page.info.contentHeight);
      this.editedAnnotation.startBitmapRequest(i, j);
      return;
      j = k;
    }
  }
  
  public void removeAnnotation()
  {
    if (this.editedAnnotation == null) {
      return;
    }
    this.page.page.unlockAnnotation(this.editedAnnotation.getAnnotation());
    try
    {
      this.page.page.removeAnnotation(this.editedAnnotation.getAnnotation());
      this._container.refreshAnnotationViews();
      this.editedAnnotation = null;
      this.page = null;
      return;
    }
    catch (PDFError localPDFError)
    {
      for (;;)
      {
        localPDFError.printStackTrace();
      }
    }
  }
  
  public void setBorderWidth(float paramFloat)
  {
    this.editedAnnotation.getAnnotation().setBorderWidth(paramFloat);
    refreshEdittedAnnotation();
  }
  
  public void setColor(int paramInt)
  {
    try
    {
      this.editedAnnotation.getAnnotation().setColor(paramInt);
      refreshEdittedAnnotation();
      return;
    }
    catch (PDFError localPDFError)
    {
      localPDFError.printStackTrace();
      Utils.showError(getContext(), localPDFError);
    }
  }
  
  public void setContents(String paramString)
  {
    try
    {
      Annotation localAnnotation = this.editedAnnotation.getAnnotation();
      if ((localAnnotation instanceof FreeTextAnnotation)) {
        ((FreeTextAnnotation)localAnnotation).setContentsAndResize(paramString, this.page.info.contentWidth);
      }
      for (;;)
      {
        refreshEdittedAnnotation();
        return;
        localAnnotation.setContents(paramString);
      }
      return;
    }
    catch (PDFError paramString)
    {
      paramString.printStackTrace();
      Utils.showError(getContext(), paramString);
    }
  }
  
  protected boolean setPage(float paramFloat1, float paramFloat2)
  {
    this.page = getPDFView().findVisiblePageByPoint(paramFloat1, paramFloat2);
    if (this.page == null) {
      return false;
    }
    if (!this.page.isInitialized())
    {
      this.page = null;
      return false;
    }
    return true;
  }
  
  protected void startBitmapRequest(int paramInt1, int paramInt2)
  {
    if (this.editedAnnotation.isBitmapRequestRunning())
    {
      this.reloadAnnotationBitmapOnUpEvent = true;
      return;
    }
    this.reloadAnnotationBitmapOnUpEvent = false;
    this.editedAnnotation.refreshBoundingBox(this.page.info.contentWidth, this.page.info.contentHeight);
    this.editedAnnotation.startBitmapRequest(paramInt1, paramInt2);
  }
  
  public void storeAnnotation()
  {
    if (this.page == null) {
      return;
    }
    try
    {
      this.editedAnnotation.getAnnotation().serialize();
      this.page.page.unlockAnnotation(this.editedAnnotation.getAnnotation());
      this.editedAnnotation.releaseBitmap();
      return;
    }
    catch (PDFError localPDFError)
    {
      localPDFError.printStackTrace();
    }
  }
  
  public void undoAnnotation()
  {
    try
    {
      this.editedAnnotation.getAnnotation().setColor(this.undoData.color);
      this.editedAnnotation.getAnnotation().setContents(this.undoData.text);
      this.page.page.unlockAnnotation(this.editedAnnotation.getAnnotation());
      this.editedAnnotation.releaseBitmap();
      return;
    }
    catch (PDFError localPDFError)
    {
      localPDFError.printStackTrace();
    }
  }
  
  private static class UndoData
  {
    private int color;
    private String text;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/AnnotationEditorView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */