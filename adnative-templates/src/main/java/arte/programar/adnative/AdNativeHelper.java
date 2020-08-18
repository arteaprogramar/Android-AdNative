package arte.programar.adnative;

import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.formats.UnifiedNativeAd;

public class AdNativeHelper {

    /**
     * NativeAd load & show
     * Require view inflater!
     *
     * @param view
     * @param idNative
     */
    public static void show(final AdNativeView view, String idNative) {
        try {
            AdLoader loader = new AdLoader.Builder(view.getContext(), idNative).forUnifiedNativeAd(
                    new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                        @Override
                        public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                            view.setNativeAd(unifiedNativeAd);
                        }
                    }
            ).build();
            loader.loadAd(new AdRequest.Builder().build());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * NativeAd load & show
     * Require view inflater and AdRequest Build
     *
     * @param view
     * @param idNative
     * @param request
     */
    public static void show(final AdNativeView view, String idNative, AdRequest request) {
        try {
            AdLoader loader = new AdLoader.Builder(view.getContext(), idNative).forUnifiedNativeAd(
                    new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                        @Override
                        public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                            view.setNativeAd(unifiedNativeAd);
                        }
                    }
            ).build();
            loader.loadAd(request);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Instance Destroy
     *
     * @param view
     */
    public static void destroy(AdNativeView view) {
        if (view != null) {
            view.destroyNativeAd();
        }
    }

}
