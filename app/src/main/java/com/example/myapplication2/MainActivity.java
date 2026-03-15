package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    ImageView searchButton, profileImage;
    EditText searchInput, postInput;
    TextView logoText;
    Button postButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. Initialize Views
        searchButton = findViewById(R.id.btn_search);
        searchInput = findViewById(R.id.et_search);
        logoText = findViewById(R.id.tv_logo);

        profileImage = findViewById(R.id.img_profile_small);
        postInput = findViewById(R.id.et_post_content);
        postButton = findViewById(R.id.btn_post);

        // 2. Search Logic
        searchButton.setOnClickListener(v -> {
            if (searchInput.getVisibility() == View.GONE) {
                logoText.setVisibility(View.GONE);
                searchInput.setVisibility(View.VISIBLE);
                searchInput.requestFocus();
            } else {
                Toast.makeText(MainActivity.this, "Searching...", Toast.LENGTH_SHORT).show();
            }
        });

        // 3. PROFILE LOGIC
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        // 4. POSTING LOGIC:
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = postInput.getText().toString();
                if(!content.isEmpty()){
                    // Show success message
                    Toast.makeText(MainActivity.this, "Posted to your Feed!", Toast.LENGTH_LONG).show();
                    // Clear the box so they can type again
                    postInput.setText("");
                } else {
                    postInput.setError("Please type something first");
                }
            }
        });
    }
}