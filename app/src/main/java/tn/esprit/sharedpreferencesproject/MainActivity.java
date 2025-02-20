package tn.esprit.sharedpreferencesproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    EditText login;
    EditText pwd;
    Button singinbtn;

    private SharedPreferences mPreferences;
    public static final String SharedPrefFile = "tn.esprit.sharedpreferencesproject";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.loginTxt);
        pwd = findViewById(R.id.pwdTxt);
        singinbtn = findViewById(R.id.siginbtn);

        mPreferences = getSharedPreferences(SharedPrefFile, MODE_PRIVATE);

        login.setText(mPreferences.getString("login", ""));
        pwd.setText(mPreferences.getString("pwd", ""));


        singinbtn.setOnClickListener(v -> {
            SharedPreferences.Editor editor = mPreferences.edit();
            editor.putString("login", login.getText().toString());
            editor.putString("pwd", pwd.getText().toString());
            editor.apply();

            Intent intent = new Intent(this, FirstActivity.class);
            startActivity(intent);

        });






    }
}

