package project.santosotech.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_IMAGE = "extra_image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvName: TextView = findViewById(R.id.name_detail)
        val tvDesc: TextView = findViewById(R.id.desc_detail)
        val imgHero: ImageView = findViewById(R.id.img_detail)

        val name = intent.getStringExtra(EXTRA_NAME)
        val desc = intent.getStringExtra(EXTRA_DESC)
        val img = intent.getIntExtra(EXTRA_IMAGE, 0)

        supportActionBar?.title = name

        tvName.text = name
        tvDesc.text = desc
        Glide.with(this)
            .load(img)
            .apply(RequestOptions().override(125, 125))
            .into(imgHero)
    }
}