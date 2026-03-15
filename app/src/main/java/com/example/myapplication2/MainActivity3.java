package com.example.myapplication2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    EditText num1, num2;
    TextView result;
    Button btnAdd, btnSub, btnMul, btnDiv, btnEqual;

    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnEqual = findViewById(R.id.btnEqual);

        // Operator buttons → store operator
        btnAdd.setOnClickListener(v -> operator = "+");
        btnSub.setOnClickListener(v -> operator = "-");
        btnMul.setOnClickListener(v -> operator = "*");
        btnDiv.setOnClickListener(v -> operator = "/");

        // Equal button → calculate
        btnEqual.setOnClickListener(v -> calculate());
    }

    void calculate() {
        if (num1.getText().toString().isEmpty() ||
                num2.getText().toString().isEmpty() ||
                operator.isEmpty()) {
            result.setText("Enter values & select operator");
            return;
        }

        int a = Integer.parseInt(num1.getText().toString());
        int b = Integer.parseInt(num2.getText().toString());
        int res;

        switch (operator) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
                res = a * b;
                break;
            case "/":
                if (b == 0) {
                    result.setText("Cannot divide by zero");
                    return;
                }
                res = a / b;
                break;
            default:
                return;
        }

        result.setText(String.valueOf(res));

    }
}
