package vn.com.lab_5.vi_du_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vn.com.lab_5.R;

public class MainActivity extends AppCompatActivity {
    private Button buttonOpenURL;
    private Button buttonSendEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.buttonOpenURL = (Button) this.findViewById(R.id.button_openURL);
        this.buttonSendEmail = (Button) this.findViewById(R.id.button_sendEmail);
        this.buttonOpenURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openURL();
            }
        });
        this.buttonSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }
    public void openURL( ) {
        String url="https://google.com";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        this.startActivity(intent);
    }
    public void sendEmail( ) {
        String[] recipients=new String[]{"vukhuongduy999@gmail.com"};
        String subject="Hi, how are you!";
        String content ="This is my test email";
        Intent intentEmail = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        intentEmail.putExtra(Intent.EXTRA_EMAIL, recipients);
        intentEmail.putExtra(Intent.EXTRA_SUBJECT, subject);
        intentEmail.putExtra(Intent.EXTRA_TEXT, content);
        intentEmail.setType("text/plain");
        startActivity(Intent.createChooser(intentEmail, "Choose an email client from..."));
    }
}