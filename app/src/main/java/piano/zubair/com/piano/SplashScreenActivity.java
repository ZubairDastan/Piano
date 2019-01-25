package piano.zubair.com.piano;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreenActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        progressBar = findViewById(R.id.splashID);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                doWork();
                startApp();
                finish();
            }
        });

        thread.start();

    }


    private void doWork() {

        for (int progress = 0; progress <=100; progress +=5){
            try {
                Thread.sleep(500);
                progressBar.setProgress(progress);
            }

            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void startApp() {
        Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
