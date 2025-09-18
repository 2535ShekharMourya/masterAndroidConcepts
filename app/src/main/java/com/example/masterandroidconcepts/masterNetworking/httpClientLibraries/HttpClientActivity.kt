package com.example.masterandroidconcepts.masterNetworking.httpClientLibraries

import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.masterandroidconcepts.R
import com.google.ads.mediation.admob.AdMobAdapter
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration

class HttpClientActivity : AppCompatActivity() {
    private var adView: AdView? = null
    private lateinit var adContainer: FrameLayout

    // Google collapsible *test* banner ad unit
    private val testCollapsibleUnit = "ca-app-pub-3940256099942544/9214589741"//"ca-app-pub-3940256099942544/2014213617"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_http_client)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.root)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Optional: set test device(s) while developing
        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder()
                .setTestDeviceIds(listOf(AdRequest.DEVICE_ID_EMULATOR))
                .build()
        )
        MobileAds.initialize(this) {}

        adContainer = findViewById(R.id.ad_container)

        // Wait until container is laid out to get accurate width, then load
        adContainer.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                adContainer.viewTreeObserver.removeOnGlobalLayoutListener(this)
                loadCollapsibleBanner()
            }
        })
    }
    private fun loadCollapsibleBanner() {
        // Clean up any previous ad
        adView?.destroy()
        Log.d("HttpClientActivity", "loadCollapsibleBanner ${this}")
        adView = AdView(applicationContext).apply {
            adUnitId = testCollapsibleUnit  // replace with your own when going live
        }

        // Compute anchored adaptive size using container width (fallback to screen width)
        val displayMetrics = resources.displayMetrics
        val adWidthPx = (if (adContainer.width > 0) adContainer.width else displayMetrics.widthPixels)
        val adWidthDp = (adWidthPx / displayMetrics.density).toInt()
        val adSize = AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, 360)
        adView!!.setAdSize(AdSize.BANNER)

        // Build a *collapsible* request
        val extras = android.os.Bundle().apply { putString("collapsible", "bottom") } // or "top"
        val collapsibleRequest = AdRequest.Builder()
            .addNetworkExtrasBundle(AdMobAdapter::class.java, extras)
            .build()

        // Attach listeners + add to container
        adView!!.adListener = object : AdListener() {
            override fun onAdLoaded() {
                Log.d("Ads", "Collapsible ad loaded. isCollapsible=${adView?.isCollapsible}")
            }
            override fun onAdFailedToLoad(error: LoadAdError) {
                Log.w("Ads", "Collapsible failed: code=${error.code} domain=${error.domain} msg=${error.message}")
                // Fallback to standard anchored adaptive if NO_FILL
//                if (error.code == LoadAdError.) {
//                    Log.w("Ads", "Retrying with standard banner request (non-collapsible)")
//                    adView?.loadAd(AdRequest.Builder().build())
//                }
            }
        }

        adContainer.removeAllViews()
        adContainer.addView(adView)
        adView!!.loadAd(collapsibleRequest)
    }

    override fun onDestroy() {
        adView?.destroy()
        super.onDestroy()
    }
}