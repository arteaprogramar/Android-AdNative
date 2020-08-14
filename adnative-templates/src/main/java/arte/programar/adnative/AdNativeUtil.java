package arte.programar.adnative;

import android.text.TextUtils;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

public class AdNativeUtil {

    public static final int SMALL_VIEW = R.layout.adt_small_template_view;
    public static final int MEDIUM_VIEW = R.layout.adt_medium_template_view;

    public static final String MEDIUM_TEMPLATE = "medium_template";
    public static final String SMALL_TEMPLATE = "small_template";

    static boolean adHasOnlyStore(UnifiedNativeAd nativeAd) {
        String store = nativeAd.getStore();
        String advertiser = nativeAd.getAdvertiser();
        return !TextUtils.isEmpty(store) && TextUtils.isEmpty(advertiser);
    }

}
