package com.vladium.emma.report.html.doc;

public class HyperRef
  extends IElement.Factory.ElementImpl
{
  public HyperRef(String paramString1, String paramString2, boolean paramBoolean)
  {
    super(Tag.A, AttributeSet.create());
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      throw new IllegalArgumentException("null or empty input: href");
    }
    if ((paramString2 == null) || (paramString2.length() == 0)) {
      throw new IllegalArgumentException("null or empty input: text");
    }
    getAttributes().set(Attribute.HREF, paramString1);
    setText(paramString2, paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/report/html/doc/HyperRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */