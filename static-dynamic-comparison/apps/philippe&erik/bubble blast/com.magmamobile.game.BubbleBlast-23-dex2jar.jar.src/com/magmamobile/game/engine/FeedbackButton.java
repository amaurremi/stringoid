package com.magmamobile.game.engine;

public final class FeedbackButton
  extends Button
{
  private String formkey;
  
  public FeedbackButton(String paramString)
  {
    this.formkey = paramString;
    setX(0.0F);
    setY(Game.scalei(60));
    setWidth(Game.getBufferWidth());
    setHeight(Game.scalei(50));
    getPainter().setFontSize(Game.scalef(30.0F));
    getPainter().setStrokeWidth(Game.scalef(4.0F));
    getPainter().setStrokeColor(-16777216);
    getPainter().setFontColor(-1);
    getLabel().setHorizontalAlign((byte)0);
    getLabel().setVerticalAlign((byte)0);
    setText("Feedback");
  }
  
  public String getFormkey()
  {
    return this.formkey;
  }
  
  public void onAction()
  {
    super.onAction();
    if (this.onClick) {
      Game.showBrowser("https://docs.google.com/spreadsheet/embeddedform?formkey=" + this.formkey);
    }
  }
  
  public void onRender()
  {
    super.onRender();
  }
  
  public void setFormkey(String paramString)
  {
    this.formkey = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/engine/FeedbackButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */