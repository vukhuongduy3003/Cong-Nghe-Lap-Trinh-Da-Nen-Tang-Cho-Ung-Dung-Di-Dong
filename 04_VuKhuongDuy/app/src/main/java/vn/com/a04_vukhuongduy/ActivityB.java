package vn.com.a04_vukhuongduy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        double a = bundle.getDouble("soa", 0.0);
        double b = bundle.getDouble("sob", 0.0);

        double result = a - b;
        double result2 = a + b;
        double result3 = a * b;
        String result4;
        if (b == 0) {
            result4 = "Không thể thực hiện phép chia cho 0";
        } else {
            double kq = a / b;
            result4 = String.format("%.2f", kq);
        }

        Intent resultIntent = new Intent(ActivityB.this, ActivityA.class);
        String s = "a-b: " + Math.round(result * 100.0) / 100.0 + ", a+b : "
                + Math.round(result2 * 100.0) / 100.0 + ", a*b : "
                + Math.round(result3 * 100.0) / 100.0 + ", a/b : " + result4;
        resultIntent.putExtra("result", s);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}