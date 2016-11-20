package com.freeman_smith.tthinteractivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    private Page mCurrentPage;
    private String mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mName = intent.getStringExtra("name");
        if(mName == null) {
            mName = "Friend";
        }
        loadPage(0);
    }

  private void loadPage(int choice) {
    mCurrentPage = mStory.getPage(choice);

    Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId(), null);
    mImageView.setImageDrawable(drawable);

    String pageText = mCurrentPage.getText();
    pageText = String.format(pageText, mName);
    mTextView.setText(pageText);

    if(mCurrentPage.isFinal()){
      mChoice1.setVisibility(View.INVISIBLE);
      mChoice2.setText("Play Again");
      mChoice2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          finish();
        }
      });
    } else {
      mChoice1.setText(mCurrentPage.getChoice1().getText());
      mChoice2.setText(mCurrentPage.getChoice2().getText());

      mChoice1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          int nextPage = mCurrentPage.getChoice1().getNextPage();
          loadPage(nextPage);
        }
      });
      mChoice2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          int nextPage = mCurrentPage.getChoice2().getNextPage();
          loadPage(nextPage);
        }
      });
    }

  }

}
