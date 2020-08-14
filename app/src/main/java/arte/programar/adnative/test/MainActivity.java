package arte.programar.adnative.test;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.UnifiedNativeAd;

import arte.programar.adnative.AdNativeView;

public class MainActivity extends AppCompatActivity {

    private static final String ID_NATIVE = "ca-app-pub-3940256099942544/2247696110";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(getApplicationContext());

        final AdNativeView template = findViewById(R.id.adnative_medium);
        template.createAdMediumCustom(
                "Lorem ipsum dolor",
                "Ut enim ad minim veniam, quis nostrud exercitation",
                "Duis aute irure",
                ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_star),
                ContextCompat.getDrawable(getApplicationContext(), R.drawable.rectangle)
        );

        AdLoader loader1 = new AdLoader.Builder(this, ID_NATIVE)
                .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                        //AdNativeView template = findViewById(R.id.adnative_small);
                        template.setNativeAd(unifiedNativeAd);
                    }
                })
                .build();

        loader1.loadAd(new AdRequest.Builder().build());
    }
}