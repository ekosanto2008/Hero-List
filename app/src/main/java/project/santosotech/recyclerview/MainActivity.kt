package project.santosotech.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import project.santosotech.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var list: ArrayList<Hero> = arrayListOf()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = resources.getString(R.string.hero)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvHero.setHasFixedSize(true)

        list.addAll(Data.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        binding.rvHero.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = HeroAdapter(list)
        binding.rvHero.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallBack(object : HeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }

        })
    }

    private fun showSelectedHero(data: Hero) {
        Toast.makeText(this, "You Choose " + data.name, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_KEY, data)
        startActivity(intent)
    }
}