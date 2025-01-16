package com.homework.mywardrobeup

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.app.AlertDialog
import android.content.DialogInterface
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class DetailActivity : AppCompatActivity() {

    private lateinit var backButton: Button
    private lateinit var detailImage: ImageView
    private lateinit var detailTitle: TextView
    private lateinit var detailDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        backButton = findViewById(R.id.backButton)

        val item = intent.getParcelableExtra<ClothingItem>("item")
        if (item != null) {
            detailImage.setImageResource(item.imageResId)
            detailTitle.text = item.title
            detailDescription.text = item.description
        }

        backButton.setOnClickListener {
            finish()
        }

        detailImage.setOnClickListener {
            showUpdateDialog(item)
        }
    }

    private fun showUpdateDialog(item: ClothingItem?) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Обновить данные")
        builder.setMessage("Вы хотите обновить данные?")

        builder.setPositiveButton("Обновить") { dialog, which ->
            // update data todo
        }

        builder.setNegativeButton("Отмена") { dialog, which ->
            dialog.dismiss()
        }

        builder.show()
    }
}