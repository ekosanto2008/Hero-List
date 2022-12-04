package project.santosotech.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import project.santosotech.recyclerview.databinding.ItemHeroBinding

class HeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<HeroAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallBack(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val hero = listHero[position]

        Glide.with(holder.itemView.context)
            .load(hero.photo)
            .apply(RequestOptions().override(55,55))
            .into(holder.binding.imgHero)

        holder.binding.txtName.text = hero.name
        holder.binding.txtDetail.text = hero.desc

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listHero[holder.absoluteAdapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    inner class ListViewHolder(var binding: ItemHeroBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }
}