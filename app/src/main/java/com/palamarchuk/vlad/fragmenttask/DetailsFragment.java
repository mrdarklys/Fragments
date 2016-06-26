package com.palamarchuk.vlad.fragmenttask;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

/**
 * Created by User on 25.06.2016.
 */
public class DetailsFragment extends Fragment {
        WebView teamDescr;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intent launchigIntent = getActivity().getIntent();
        int teamName = launchigIntent.getIntExtra("teamPos",0);
        View viewer= inflater.inflate(R.layout.viewer, container,false);
        teamDescr = (WebView) viewer.findViewById(R.id.webView);
        updateTeamDescr(teamName);
        return viewer;

    }
    public class MyWebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }
    }
    public void updateTeamDescr(int name) {
        teamDescr.getSettings().setJavaScriptEnabled(true);
        teamDescr.setWebViewClient(new MyWebViewClient());
        teamDescr.loadUrl(Teams.mTeamUrlArray[name]);

        teamDescr.setBackgroundColor(Color.LTGRAY);

    }
}
