package com.freeman_smith.tthinteractivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.freeman_smith.tthinteractivestory.R;
import com.freeman_smith.tthinteractivestory.model.Page;
import com.freeman_smith.tthinteractivestory.model.Story;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StoryActivity extends AppCompatActivity {
    @Bind(R.id.storyImageView) ImageView mImageView;
    @Bind(R.id.storyTextView) TextView mTextView;
    @Bind(R.id.buttonChoice1) Button mChoice1;
    @Bind(R.id.buttonChoice2) Button mChoice2;

    public static final String TAG = StoryActivity.class.getSimpleName();
    private Story mStory = new Story();
    private String mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        if(mName == null) {
            mName = "Friend";
        }
        Log.d(TAG, mName);
        loadPage();
    }

  private void loadPage() {
    Page page = mStory.getPage(2);

    Drawable drawable = getResources().getDrawable(page.getImageId(), null);
    mImageView.setImageDrawable(drawable);

    String pageText = page.getText();
    pageText = String.format(pageText, mName);
    mTextView.setText(pageText);

    mChoice1.setText(page.getChoice1().getText());
    mChoice2.setText(page.getChoice2().getText());
  }

}
