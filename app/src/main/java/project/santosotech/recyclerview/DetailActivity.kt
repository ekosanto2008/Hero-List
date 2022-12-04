package project.santosotech.recyclerview

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import project.santosotech.recyclerview.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_KEY = "extra_key"
    }

    private lateinit var binding: ActivityDetailBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hero = intent.getParcelableExtra(EXTRA_KEY, Hero::class.java)

        binding.nameDetail.text = hero?.name
        binding.descDetail.text = hero?.desc
        Glide.with(this)
            .load(hero?.photo)
            .apply(RequestOptions().override(125, 125))
            .into(binding.imgDetail)
    }

}