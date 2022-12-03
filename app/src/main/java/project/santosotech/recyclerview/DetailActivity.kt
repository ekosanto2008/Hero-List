package project.santosotech.recyclerview

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_KEY = "extra_key"
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvName: TextView = findViewById(R.id.name_detail)
        val tvDesc: TextView = findViewById(R.id.desc_detail)
        val imgHero: ImageView = findViewById(R.id.img_detail)

        val hero = intent.getParcelableExtra(EXTRA_KEY, Hero::class.java)

        tvName.text = hero?.name
        tvDesc.text = hero?.desc
        Glide.with(this)
            .load(hero?.photo)
            .apply(RequestOptions().override(125, 125))
            .into(imgHero)
    }

}