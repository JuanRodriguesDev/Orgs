package com.project.orgs

import android.app.Activity
import android.os.Bundle
import android.renderscript.Sampler
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        val name = findViewById<TextView>(R.id.name)
        name.text = ("cesta de fruta")
        val description = findViewById<TextView>(R.id.description)
        description.text = ("Laranja, Manga e Uva")
        val value = findViewById<TextView>(R.id.value)
        value.text = ("R$ 19,99")
    }

}