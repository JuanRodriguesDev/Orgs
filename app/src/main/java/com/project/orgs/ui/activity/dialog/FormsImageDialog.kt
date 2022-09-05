package com.project.orgs.ui.activity.dialog

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.project.orgs.databinding.FormsImageBinding
import com.project.orgs.extensions.tryLoadImage

class FormsImageDialog (private val context: Context) {

    fun show(quandoImagemCarregada: (imagem: String) -> Unit) {
        val bindingFormsImage = FormsImageBinding.inflate(LayoutInflater.from(context))

            bindingFormsImage.btnRefresh.setOnClickListener {
                val url = bindingFormsImage.formsImageUrl.text.toString()
                bindingFormsImage.formsImage.tryLoadImage(url)
            }
            AlertDialog.Builder(context)
                .setView(bindingFormsImage.root)
                .setPositiveButton("Confirmar") { _, _ ->
                  val url = bindingFormsImage.formsImageUrl.text.toString()
                    quandoImagemCarregada(url)

                }
                .setNegativeButton("Cancelar"){ _, _ ->  }
                .show()
        }
}