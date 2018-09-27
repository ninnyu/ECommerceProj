package com.example.potatopaloozac.ecommerceproj.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.potatopaloozac.ecommerceproj.R;
import com.example.potatopaloozac.ecommerceproj.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    TextView tv_technologiesUsed;
    Button bt_startDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_technologiesUsed = findViewById(R.id.tv_technologiesUsed);
        bt_startDemo = findViewById(R.id.bt_startDemo);

        String s = "- MVP Design Pattern\n" +
                "- Dagger2 framework (Dependency Injection)\n" +
                "- Splash Screen\n" +
                "- Animation\n" +
                "- RecyclerView with a CardView\n" +
                "- Toolbar\n" +
                "- Regex (User input validation)\n" +
                "- API web service\n" +
                "- Volley library\n" +
                "- Viewbinding using ButterKnife\n" +
                "- Global class (extending application)\n" +
                "- SQLite Database\n" +
                "- Multi-language Support\n" +
                "- Shared Preferences\n" +
                "- Git (version control)\n" +
                "- JSON parsing";

        tv_technologiesUsed.setText(s);

        bt_startDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
