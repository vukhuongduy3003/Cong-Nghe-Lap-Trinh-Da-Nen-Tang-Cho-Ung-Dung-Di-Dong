package vn.com.a04_vukhuongduy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ActivityC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        double a = bundle.getDouble("soa", 0.0);
        double b = bundle.getDouble("sob", 0.0);
        String result;
        if (a == 0) {
            if (b > 0) {
                result = "Bất phương trình vô số nghiệm";
            } else {
                result = "Bất phương trình không có nghiệm";
            }
        } else {
            double x0 = -b / a;
            if (a > 0) {
                if (x0 == 0) {
                    result = "x > 0";
                } else {
                    result = String.format("x > %.2f", x0);
                }
            } else if (a < 0) {
                if (x0 == 0) {
                    result = "x < 0";
                } else {
                    result = String.format("x < %.2f", x0);
                }
            } else {
                if (b < 0) {
                    result = "Bất phương trình vô nghiệm";
                } else {
                    result = "Bất phương trình vô số nghiệm";
                }
            }
        }

        Intent resultIntent = new Intent(ActivityC.this,ActivityA.class);
        resultIntent.putExtra("result", result);
        setResult(5, resultIntent);
        finish();
    }
}