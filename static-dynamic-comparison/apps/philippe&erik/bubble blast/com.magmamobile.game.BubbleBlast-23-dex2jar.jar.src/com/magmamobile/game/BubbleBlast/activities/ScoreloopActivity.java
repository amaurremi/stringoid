package com.magmamobile.game.BubbleBlast.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.magmamobile.game.BubbleBlast.utils.GoogleAnalytics;
import com.magmamobile.game.engine.Game;
import com.scoreloop.client.android.core.controller.RequestController;
import com.scoreloop.client.android.core.controller.UserController;
import com.scoreloop.client.android.core.controller.UserControllerObserver;
import com.scoreloop.client.android.core.model.Session;
import com.scoreloop.client.android.core.model.User;

public final class ScoreloopActivity
  extends Activity
  implements View.OnClickListener
{
  private Button btnUpdate;
  private ProgressDialog progressDialog;
  private boolean request;
  private EditText txtEmail;
  private EditText txtName;
  private UserController userController;
  
  private void enableControles(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.progressDialog.dismiss();
    }
    for (;;)
    {
      this.txtName.setEnabled(paramBoolean);
      this.txtEmail.setEnabled(paramBoolean);
      this.btnUpdate.setEnabled(paramBoolean);
      return;
      this.progressDialog.show();
    }
  }
  
  private void updateControles()
  {
    User localUser = Session.getCurrentSession().getUser();
    this.txtName.setText(localUser.getDisplayName());
    this.txtEmail.setText(localUser.getEmailAddress());
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = Session.getCurrentSession().getUser();
    paramView.setEmailAddress(this.txtEmail.getText().toString());
    paramView.setLogin(this.txtName.getText().toString());
    this.userController.submitUser();
    enableControles(false);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903053);
    this.txtName = ((EditText)findViewById(2131099702));
    this.txtEmail = ((EditText)findViewById(2131099703));
    this.btnUpdate = ((Button)findViewById(2131099704));
    this.btnUpdate.setOnClickListener(this);
    this.progressDialog = new ProgressDialog(this);
    this.progressDialog.setMessage("Loading...");
    this.progressDialog.setCancelable(false);
    this.progressDialog.setIndeterminate(true);
    enableControles(false);
    this.request = true;
    this.userController = new UserController(new UserUpdateObserver(null));
    updateControles();
    this.userController.submitUser();
    GoogleAnalytics.trackAndDispatch("ScoreloopPreferences");
  }
  
  private class UserUpdateObserver
    implements UserControllerObserver
  {
    private UserUpdateObserver() {}
    
    public void onEmailAlreadyTaken(UserController paramUserController)
    {
      Game.showAlertDialog(ScoreloopActivity.this, "Error", ScoreloopActivity.this.getString(2131034163));
      ScoreloopActivity.this.enableControles(true);
    }
    
    public void onEmailInvalidFormat(UserController paramUserController)
    {
      Game.showAlertDialog(ScoreloopActivity.this, "Error", ScoreloopActivity.this.getString(2131034164));
      ScoreloopActivity.this.enableControles(true);
    }
    
    public void onUsernameAlreadyTaken(UserController paramUserController)
    {
      Game.showAlertDialog(ScoreloopActivity.this, "Error", ScoreloopActivity.this.getString(2131034165));
      ScoreloopActivity.this.enableControles(true);
    }
    
    public void requestControllerDidFail(RequestController paramRequestController, Exception paramException)
    {
      Game.showAlertDialog(ScoreloopActivity.this, "Error", ScoreloopActivity.this.getString(2131034166));
      ScoreloopActivity.this.enableControles(true);
    }
    
    public void requestControllerDidReceiveResponse(RequestController paramRequestController)
    {
      if (ScoreloopActivity.this.request)
      {
        ScoreloopActivity.this.request = false;
        ScoreloopActivity.this.updateControles();
      }
      for (;;)
      {
        ScoreloopActivity.this.enableControles(true);
        return;
        Toast.makeText(ScoreloopActivity.this, ScoreloopActivity.this.getString(2131034167), 1).show();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/activities/ScoreloopActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */