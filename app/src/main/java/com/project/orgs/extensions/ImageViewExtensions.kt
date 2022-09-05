package com.project.orgs.extensions

import android.widget.ImageView
import coil.load
import com.project.orgs.R



fun ImageView.tryLoadImage (url: String? = null)  {
    load(url) {
        fallback(com.project.orgs.R.drawable.img_1)
        error(com.project.orgs.R.drawable.img_1)
        placeholder(com.project.orgs.R.drawable.placeholder)
    }
}