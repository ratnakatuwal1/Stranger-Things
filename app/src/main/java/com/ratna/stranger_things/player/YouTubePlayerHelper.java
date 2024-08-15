package com.ratna.stranger_things.player;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ratna.stranger_things.R;

public class YouTubePlayerHelper {
    private Context context;
    private String videoUrl;

    public YouTubePlayerHelper(Context context, String videoUrl) {
        this.context = context;
        this.videoUrl = videoUrl;
    }

    public void showYouTubeDialog() {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_youtube_iframe);

        WebView webView = dialog.findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        webView.setWebViewClient(new WebViewClient());

        String videoId = extractVideoId(videoUrl);

        String html = "<html><body style='margin:0;padding:0;'>" +
                "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/" + videoId +
                "\" frameborder=\"0\" allowfullscreen></iframe>" +
                "</body></html>";


        webView.loadUrl("https://www.youtube.com/embed/" + videoId);

        Log.d("htlm", html);
        dialog.show();
    }

    private String extractVideoId(String videoUrl) {
        Uri uri = Uri.parse(videoUrl);
        String videoId = uri.getQueryParameter("v");
        if (videoId == null) {
            videoId = uri.getLastPathSegment();
        }
        return videoId;
    }
}
