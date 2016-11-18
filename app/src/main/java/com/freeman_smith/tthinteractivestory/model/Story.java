package com.freeman_smith.tthinteractivestory.model;

import com.freeman_smith.tthinteractivestory.R;

/**
 * Created by Karen Freeman-Smith on 11/18/2016.
 */

public class Story {
    private Page[] mPages;

    public Story() {
        mPages = new Page[7];

        mPages[0]= new Page(
                R.drawable.page0,
                "page text",
                new Choice("Stop and investigate", 1),
                new Choice("Continue home to Earth", 2)
        );

        mPages[1]= new Page(
                R.drawable.page1,
                "You deftly land your ship...",
                new Choice("Explore the cave", 3),
                new Choice("Explore the rover", 4)
        );

        mPages[2]= new Page(
                R.drawable.page2,
                "You continue your couse to Earth...",
                new Choice("Head back to Mars to investigate", 4),
                new Choice("Continue home to Earth", 6)
        );

        mPages[3]= new Page(
                R.drawable.page3,
                "Your EVA suit is equiped with ...",
                new Choice("Refill at ship and explore the rover", 4),
                new Choice("Continue towards the faint light", 5)
        );

        mPages[4]= new Page(
                R.drawable.page4,
                "The rover is covered in dust and ...",
                new Choice("Explore the coordinates", 5),
                new Choice("Return to Earth", 6)
        );

        mPages[5]= new Page(
                R.drawable.page5,
                "After a long walk..."
        );

        mPages[6]= new Page(
                R.drawable.page6,
                "You arrive home..."
        );

    }
}
