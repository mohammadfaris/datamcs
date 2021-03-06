package getdreams.todolist;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    public static final String ACTION_LOGOUT = "logout";

    private CallbackManager mCallbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FacebookSdk.sdkInitialize(getApplicationContext());


        if (ACTION_LOGOUT.equals(getIntent().getAction())) {
            logout();
        } else {
            AccessToken accessToken = AccessToken.getCurrentAccessToken();
            if (accessToken != null && !accessToken.isExpired()) {
                loginAsFacebookUser(accessToken.getToken(), accessToken.getUserId(), null);
                return;
            }

            if (isLoggedAsGuest()) {
                loginAsGuest();
                return;
            }
        }

        LoginButton facebookLoginButton = (LoginButton) findViewById(R.id.facebook_login_button);
        facebookLoginButton.setReadPermissions("public_profile");

        mCallbackManager = CallbackManager.Factory.create();
        facebookLoginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            private class TAG {
            }

            @Override
            public void onSuccess(LoginResult loginResult) {
                continueFacebookLogin(loginResult);
            }

            @Override
            public void onError(FacebookException error) {


            }

            @Override
            public void onCancel() { }
        });

        Button guestLoginButton = (Button) findViewById(R.id.guest_login_button);
        guestLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginAsGuest();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void continueFacebookLogin(final LoginResult loginResult) {
        GraphRequest request = GraphRequest.newMeRequest(
                loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        if (object == null) {

                            return;
                        }

                        try {
                            AccessToken accessToken = loginResult.getAccessToken();
                            String token = accessToken.getToken();
                            String userId = accessToken.getUserId();
                            String name = object.getString("name");
                            loginAsFacebookUser(token, userId, name);
                        } catch (JSONException e) {

                            return;
                        }
                    }
                }
        );

        Bundle parameters = new Bundle();
        parameters.putString("fields", "name");
        request.setParameters(parameters);
        request.executeAsync();
    }

    private void loginAsFacebookUser(String token, String userId, String name) {
        Application application = (Application) getApplication();
        application.loginAsFacebookUser(this, token, userId, name);
    }

    private void loginAsGuest() {
        SharedPreferences pref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("guest", true);
        editor.commit();
        Application application = (Application) getApplication();
        application.loginAsGuest(this);
    }

    private boolean isLoggedAsGuest() {
        SharedPreferences pref = getPreferences(Context.MODE_PRIVATE);
        return pref.getBoolean("guest", false);
    }

    private void logout() {
        SharedPreferences pref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove("guest");
        editor.commit();
        LoginManager.getInstance().logOut();
    }
    }
}
