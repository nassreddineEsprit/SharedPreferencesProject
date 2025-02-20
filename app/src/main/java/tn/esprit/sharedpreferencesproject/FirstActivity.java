package tn.esprit.sharedpreferencesproject;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FirstActivity extends AppCompatActivity {
    TextView welcomTxt;
    Button logoutbtn;
    private SharedPreferences mPreferences;
    public static final String SharedPrefFile = "tn.esprit.sharedpreferencesproject";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        welcomTxt = findViewById(R.id.welcTxt);
        logoutbtn = findViewById(R.id.logoutbtn);

        mPreferences = getSharedPreferences(SharedPrefFile, MODE_PRIVATE);

        if (mPreferences != null) {
            String savedLogin = mPreferences.getString("login", "Guest");
            welcomTxt.setText("Welcome, " + savedLogin);
        }

        logoutbtn.setOnClickListener(v -> {
            if (mPreferences != null) {
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.clear();
                editor.apply();
            }
            finish();
        });






    }
}