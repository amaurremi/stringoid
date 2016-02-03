package com.mobisystems.pdf.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.mobisystems.pdf.PDFError;
import com.mobisystems.pdf.PDFMatrix;
import com.mobisystems.pdf.PDFPage;
import com.mobisystems.pdf.PDFPoint;
import com.mobisystems.pdf.PDFQuadrilateral;
import com.mobisystems.pdf.PDFRect;
import com.mobisystems.pdf.PDFText;
import com.mobisystems.pdf.PDFText.OffsetResult;
import com.mobisystems.pdf.PDFText.TextRegion;
import com.mobisystems.pdf.R.drawable;
import com.mobisystems.pdf.R.id;
import com.mobisystems.pdf.R.layout;
import com.mobisystems.pdf.annotation.HighlightAnnotation;
import com.mobisystems.pdf.annotation.StrikeOutAnnotation;
import com.mobisystems.pdf.annotation.TextMarkupAnnotation;
import com.mobisystems.pdf.annotation.UnderlineAnnotation;

public class TextSelectionView
  extends ViewGroup
  implements View.OnClickListener, View.OnTouchListener
{
  private static final String TAG = "TextSelectionView";
  private Point _contextMenuPoint = new Point();
  private RectF _rectDest = new RectF();
  private PDFPoint _tmpCursorEndPt = new PDFPoint();
  private PDFPoint _tmpCursorStartPt = new PDFPoint();
  private PDFText.OffsetResult _tmpOffsetResult = new PDFText.OffsetResult();
  private Paint _tmpPaint = new Paint();
  private PDFPoint _tmpPt = new PDFPoint();
  private PDFPoint _tmpPt2 = new PDFPoint();
  private LinearLayout contextMenu;
  private int contextMenuAnchorId = -1;
  private int currentLineIdx;
  private ImageView cursorEndView;
  private ImageView cursorStartView;
  private int distanceToDraggedPointerCenterSq = Integer.MAX_VALUE;
  private float draggedCursorOffsetY;
  private int draggedCursorViewId = -1;
  private PDFView.VisiblePage page;
  
  public TextSelectionView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public TextSelectionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextSelectionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.cursorStartView = new ImageView(paramContext);
    this.cursorStartView.setImageResource(R.drawable.pdf_selection_pointer_drawable);
    this.cursorStartView.setId(R.id.selection_start_id);
    addView(this.cursorStartView);
    this.cursorStartView.setOnTouchListener(this);
    this.cursorEndView = new ImageView(paramContext);
    this.cursorEndView.setImageResource(R.drawable.pdf_selection_pointer_drawable);
    this.cursorEndView.setId(R.id.selection_end_id);
    addView(this.cursorEndView);
    this.cursorEndView.setOnTouchListener(this);
    this.contextMenu = ((LinearLayout)LayoutInflater.from(paramContext).inflate(R.layout.pdf_selection_context_menu, null));
    addView(this.contextMenu);
    this.contextMenu.findViewById(R.id.selection_highlight_text).setOnClickListener(this);
    this.contextMenu.findViewById(R.id.selection_strikeout_text).setOnClickListener(this);
    this.contextMenu.findViewById(R.id.selection_underline_text).setOnClickListener(this);
    this.contextMenu.setVisibility(4);
    setWillNotDraw(false);
  }
  
  private void calculateCursorPoints()
  {
    PDFMatrix localPDFMatrix;
    if (this.page.getText().quadrilaterals() > 0)
    {
      Log.d("TextSelectionView", "calculateCursorPoints " + getScrollX() + " " + getScrollY() + " " + this.page.width() + " " + this.page.height());
      localPDFMatrix = this.page.makeTransformMatrix(0, 0);
      if (localPDFMatrix != null) {}
    }
    else
    {
      return;
    }
    PDFQuadrilateral localPDFQuadrilateral = this.page.getText().getQuadrilateral(0);
    this._tmpCursorStartPt.set(localPDFQuadrilateral.x1, localPDFQuadrilateral.y1);
    this._tmpCursorStartPt.convert(localPDFMatrix);
    localPDFQuadrilateral = this.page.getText().getQuadrilateral(this.page.getText().quadrilaterals() - 1);
    this._tmpCursorEndPt.set(localPDFQuadrilateral.x2, localPDFQuadrilateral.y2);
    this._tmpCursorEndPt.convert(localPDFMatrix);
  }
  
  private void setContextMenuVisibility(boolean paramBoolean)
  {
    int i = 4;
    Object localObject = this.page.container();
    if (((PDFView)localObject)._onStateChangeListener != null)
    {
      calculateContextMenuPoint();
      if (((PDFView)localObject)._onStateChangeListener.onContextMenu(PDFView.ContextMenuType.SELECTION, paramBoolean, this._contextMenuPoint))
      {
        this.contextMenu.setVisibility(4);
        return;
      }
    }
    localObject = this.contextMenu;
    if (paramBoolean) {
      i = 0;
    }
    ((LinearLayout)localObject).setVisibility(i);
  }
  
  private void stopCursorDrag()
  {
    this.draggedCursorViewId = -1;
    this.distanceToDraggedPointerCenterSq = Integer.MAX_VALUE;
    this.page.notifySelectionModificationEnd();
    setContextMenuVisibility(true);
  }
  
  public void calculateContextMenuPoint()
  {
    int i = this.cursorStartView.getDrawable().getIntrinsicWidth() / 2;
    int j = this.cursorStartView.getDrawable().getIntrinsicHeight();
    if (this.contextMenuAnchorId == R.id.selection_start_id) {
      this._contextMenuPoint.x = (i + (int)this._tmpCursorStartPt.x);
    }
    for (this._contextMenuPoint.y = (j + (int)this._tmpCursorStartPt.y);; this._contextMenuPoint.y = (j + (int)this._tmpCursorEndPt.y))
    {
      this._contextMenuPoint.x = Math.min(Math.max(this._contextMenuPoint.x, this.page.container().getScrollX()), this.page.container().getWidth() + this.page.container().getScrollX() - this.contextMenu.getMeasuredWidth());
      this._contextMenuPoint.y = Math.min(Math.max(this._contextMenuPoint.y, this.page.container().getScrollY()), this.page.container().getHeight() + this.page.container().getScrollY() - this.contextMenu.getMeasuredHeight());
      return;
      this._contextMenuPoint.x = (i + (int)this._tmpCursorEndPt.x);
    }
  }
  
  public ImageView getCursorEndView()
  {
    return this.cursorEndView;
  }
  
  public ImageView getCursorStartView()
  {
    return this.cursorStartView;
  }
  
  public PDFView.VisiblePage getPage()
  {
    return this.page;
  }
  
  public void init(PDFView.VisiblePage paramVisiblePage, PDFText.TextRegion paramTextRegion)
  {
    this.page = paramVisiblePage;
    paramVisiblePage.getText().setCursor(paramTextRegion.getStart(), false);
    paramVisiblePage.getText().setCursor(paramTextRegion.getEnd(), true);
    calculateCursorPoints();
    setContextMenuVisibility(true);
    invalidate();
    requestLayout();
  }
  
  public void markupSelectedText(Class<? extends TextMarkupAnnotation> paramClass)
  {
    Object localObject;
    if (this.page.getText().quadrilaterals() > 0)
    {
      localObject = this.page.getText().getQuadrilateral(0);
      localObject = new PDFPoint(((PDFQuadrilateral)localObject).x1, ((PDFQuadrilateral)localObject).y1);
    }
    try
    {
      paramClass = (TextMarkupAnnotation)this.page.page.addAnnotation(paramClass, (PDFPoint)localObject, (PDFPoint)localObject);
      paramClass.setColor(this.page.container().getDefaultAnnotationColor());
      int i = 0;
      while (i < this.page.getText().quadrilaterals())
      {
        localObject = this.page.getText().getQuadrilateral(i);
        paramClass.addQuadrilateral(((PDFQuadrilateral)localObject).x1, ((PDFQuadrilateral)localObject).y1, ((PDFQuadrilateral)localObject).x2, ((PDFQuadrilateral)localObject).y2, ((PDFQuadrilateral)localObject).x3, ((PDFQuadrilateral)localObject).y3, ((PDFQuadrilateral)localObject).x4, ((PDFQuadrilateral)localObject).y4);
        i += 1;
      }
      paramClass.serialize();
      this.page.reloadContent();
      this.page.container().endSelection();
      return;
    }
    catch (PDFError paramClass)
    {
      paramClass.printStackTrace();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.selection_highlight_text) {
      markupSelectedText(HighlightAnnotation.class);
    }
    do
    {
      return;
      if (paramView.getId() == R.id.selection_strikeout_text)
      {
        markupSelectedText(StrikeOutAnnotation.class);
        return;
      }
    } while (paramView.getId() != R.id.selection_underline_text);
    markupSelectedText(UnderlineAnnotation.class);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    PDFMatrix localPDFMatrix = this.page.makeTransformMatrix(0, 0);
    if (localPDFMatrix == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.page.getText().quadrilaterals())
      {
        Path localPath = Utils.quadraterialToPath(this.page.getText().getQuadrilateral(i), localPDFMatrix, this._tmpPt);
        this._tmpPaint.setColor(Color.argb(64, 0, 0, 224));
        paramCanvas.drawPath(localPath, this._tmpPaint);
        i += 1;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.page.getText().quadrilaterals() > 0)
    {
      calculateCursorPoints();
      paramInt1 = this.cursorStartView.getDrawable().getIntrinsicWidth();
      paramInt2 = paramInt1 / 2;
      int i = this.cursorStartView.getDrawable().getIntrinsicHeight();
      int j = (int)this._tmpCursorStartPt.x;
      int k = (int)this._tmpCursorStartPt.y;
      int m = (int)this._tmpCursorEndPt.x;
      int n = (int)this._tmpCursorEndPt.y;
      this.cursorStartView.layout(j - paramInt2, k, j + paramInt2 + paramInt1 % 2, k + i);
      this.cursorEndView.layout(m - paramInt2, n, paramInt1 % 2 + (paramInt2 + m), n + i);
      calculateContextMenuPoint();
      Log.d("TextSelectionView", "TextSelectionView.onLayout " + this._contextMenuPoint + " " + paramInt3 + " " + paramInt4 + " " + getWidth() + " " + getHeight());
      this.contextMenu.layout(this._contextMenuPoint.x, this._contextMenuPoint.y, this._contextMenuPoint.x + this.contextMenu.getMeasuredWidth(), this._contextMenuPoint.y + this.contextMenu.getMeasuredHeight());
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    setMeasuredDimension(paramInt1, paramInt2);
    if (this.page.getText().quadrilaterals() > 0) {
      this.contextMenu.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(paramInt2, Integer.MIN_VALUE));
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView != null) && ((paramView.getId() == R.id.selection_end_id) || (paramView.getId() == R.id.selection_start_id)))
    {
      int i = (int)paramMotionEvent.getX() - paramView.getWidth() / 2;
      int j = (int)paramMotionEvent.getY() - paramView.getHeight() / 2;
      i = i * i + j * j;
      if (i < this.distanceToDraggedPointerCenterSq)
      {
        this.distanceToDraggedPointerCenterSq = i;
        this.draggedCursorViewId = paramView.getId();
        this.contextMenuAnchorId = this.draggedCursorViewId;
        this.draggedCursorOffsetY = paramMotionEvent.getY();
      }
    }
    for (;;)
    {
      Log.d("TextSelectionView", "onTouch " + this.draggedCursorViewId);
      return false;
      this.draggedCursorViewId = -1;
      this.distanceToDraggedPointerCenterSq = Integer.MAX_VALUE;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      Log.d("TextSelectionView", "ACTION_DOWN " + this.draggedCursorViewId);
      if (paramMotionEvent.getPointerCount() == 1)
      {
        if (this.draggedCursorViewId >= 0)
        {
          this.page.notifySelectionModificationStart();
          setContextMenuVisibility(false);
          return true;
        }
      }
      else
      {
        stopCursorDrag();
        continue;
        if (paramMotionEvent.getPointerCount() == 1)
        {
          if (this.draggedCursorViewId >= 0)
          {
            Object localObject = this.page.makeTransformMatrix(0, 0);
            if ((localObject == null) || (!((PDFMatrix)localObject).invert())) {
              return false;
            }
            this._tmpPt.set(paramMotionEvent.getX(), paramMotionEvent.getY() - this.draggedCursorOffsetY);
            this._tmpPt.convert((PDFMatrix)localObject);
            Log.d("TextSelectionView", "cursor point: " + this._tmpPt.toString());
            int j = this.page.getText().getOffset(this._tmpPt.x, this._tmpPt.y, true, this._tmpOffsetResult);
            int i;
            if (j < 0)
            {
              localObject = this.page.getText().getLineQuadrilateral(this.currentLineIdx);
              i = j;
              if (localObject != null)
              {
                if (!((PDFQuadrilateral)localObject).getYProjection(this._tmpPt, this._tmpPt2)) {
                  break label378;
                }
                i = this.page.getText().getOffset(this._tmpPt2.x, this._tmpPt2.y);
              }
            }
            int k;
            for (;;)
            {
              Log.d("TextSelectionView", "Offset: " + i);
              if (i < 0) {
                break;
              }
              j = this.page.getText().getSelectionStart();
              k = this.page.getText().getSelectionEnd();
              if (this.draggedCursorViewId != R.id.selection_start_id) {
                break label535;
              }
              if (i < k) {
                break label471;
              }
              return true;
              label378:
              localObject = ((PDFQuadrilateral)localObject).getBoundingBox();
              if (this._tmpPt.x < ((PDFRect)localObject).left())
              {
                i = this.page.getText().getLineStart(this.currentLineIdx);
              }
              else
              {
                i = j;
                if (this._tmpPt.x > ((PDFRect)localObject).right())
                {
                  i = this.page.getText().getLineEnd(this.currentLineIdx);
                  continue;
                  this.currentLineIdx = this._tmpOffsetResult.lineIdx;
                  i = j;
                }
              }
            }
            label471:
            Log.d("TextSelectionView", "Setting start " + i);
            this.page.getText().setCursor(k, false);
            this.page.getText().setCursor(i, true);
            this.cursorStartView.requestLayout();
            for (;;)
            {
              invalidate();
              return true;
              label535:
              if (i <= j) {
                return true;
              }
              Log.d("TextSelectionView", "Setting end " + i);
              this.page.getText().setCursor(j, false);
              this.page.getText().setCursor(i, true);
              this.cursorEndView.requestLayout();
            }
          }
        }
        else
        {
          stopCursorDrag();
          continue;
          if (this.draggedCursorViewId >= 0) {
            stopCursorDrag();
          }
        }
      }
    }
  }
  
  public void setCursorEndView(ImageView paramImageView)
  {
    this.cursorEndView = paramImageView;
  }
  
  public void setCursorStartView(ImageView paramImageView)
  {
    this.cursorStartView = paramImageView;
  }
  
  public void setSelectionLineIdx(int paramInt)
  {
    this.currentLineIdx = paramInt;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/pdf/ui/TextSelectionView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */