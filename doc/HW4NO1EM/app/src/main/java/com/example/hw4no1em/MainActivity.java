package com.example.hw4no1em;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView circumference;
    private TextView area;
    private Button cC;
    private EditText editCircle;

    private Double areaCalc(int r) {
        return Math.PI*r*r;
    }
    private Double cirCalc(int r){
        return 2*Math.PI*r;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        this.circumference = (TextView) super.findViewById(R.id.circumferenceDisplay);
        this.area = (TextView) super.findViewById(R.id.areaDisplay);
        this.cC = (Button) super.findViewById(R.id.confirmCircle);
        this.editCircle = (EditText) super.findViewById(R.id.editCircle);
        this.cC.setOnClickListener(new ClickListen());



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private class ClickListen implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            try {
                double areaVal = areaCalc(Integer.parseInt(MainActivity.this.editCircle.getText().toString()));
                String areaTxt = getString(R.string.area_reslt, areaVal);

                double cirVal = cirCalc(Integer.parseInt(MainActivity.this.editCircle.getText().toString()));
                String cirTxt = getString(R.string.cir_reslt, cirVal);

                MainActivity.this.area.setText(areaTxt);
                MainActivity.this.circumference.setText(cirTxt);
            }catch(Exception e){
                MainActivity.this.area.setText("The area of the circle is: null");
                MainActivity.this.circumference.setText("The circumference of the circle is: null");
            }
        }
    }
}