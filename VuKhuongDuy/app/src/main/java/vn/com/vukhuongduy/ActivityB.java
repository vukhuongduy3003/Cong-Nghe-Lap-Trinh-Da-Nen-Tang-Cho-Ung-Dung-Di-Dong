package vn.com.vukhuongduy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ActivityB extends AppCompatActivity {
    private int number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Intent intent = getIntent();
        number1 = intent.getIntExtra("number1", 0);
        number2 = intent.getIntExtra("number2", 0);

        int gcd = findGCD(number1, number2);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("result", gcd);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    private int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}
