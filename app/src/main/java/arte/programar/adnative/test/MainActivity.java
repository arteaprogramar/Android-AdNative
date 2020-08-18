package arte.programar.adnative.test;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.gms.ads.MobileAds;

import arte.programar.adnative.AdNativeHelper;
import arte.programar.adnative.AdNativeView;

public class MainActivity extends AppCompatActivity {

    // KEY
    private static final String ID_NATIVE = "ca-app-pub-3940256099942544/2247696110";

    // View
    private AdNativeView template;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(getApplicationContext());

        template = findViewById(R.id.adnative_small);
        AdNativeHelper.show(template, ID_NATIVE);
    }

    private void customTemplate() {
        template.createAdMediumCustom(
                "Lorem ipsum dolor",
                "Ut enim ad minim veniam, quis nostrud exercitation",
                "Duis aute irure",
                ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_star),
                ContextCompat.getDrawable(getApplicationContext(), R.drawable.rectangle)
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AdNativeHelper.destroy(template);
    }
}