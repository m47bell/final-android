package nyc.c4q.android.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import nyc.c4q.android.R;

public class LoginActivity extends Activity {

  private EditText emailField;
  private EditText passwordField;
  private Button loginButton;
  private final AuthenticationManager manager;

  public LoginActivity() {
    // TODO - fix this
    manager = null;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // TODO - load view hierarchy in R.layout.activity_login
        setContentView(R.layout.activity_login);

    // TODO - get references to views, and other setup

    emailField = (EditText) findViewById(R.id.email);
    passwordField = (EditText) findViewById(R.id.password);
    loginButton = (Button) findViewById(R.id.login);

     final String emailAddress = emailField.getText().toString();
     final String password = passwordField.getText().toString();


    // TODO - call checkCredentials via OnClickListener

    loginButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        checkCredentials(emailAddress,password);
      }
    });

  }

  private void checkCredentials(String email, String password) {
    if(manager.validateLogin(email, password)) {
      // TODO - go to EmailListActivity

      Intent intent = new Intent(getApplicationContext(),EmailListActivity.class);
      startActivity(intent);

    }
    else {
      // TODO launch alert dialog on failed login
      // check strings.xml for dialog

      new AlertDialog.Builder(getApplicationContext())
              .setTitle(R.string.alert_dialog_title)
              .setPositiveButton(R.string.alert_dialog_dismiss, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                  dialog.dismiss();
                }
              });



    }
  }
}
