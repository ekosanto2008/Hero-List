package project.santosotech.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class HeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<HeroAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallBack(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val hero = listHero[position]

        Glide.with(holder.itemView.context)
            .load(hero.photo)
            .apply(RequestOptions().override(55,55))
            .into(holder.imgHero)

        holder.tvName.text = hero.name
        holder.tvDesc.text = hero.desc

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listHero[holder.absoluteAdapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.txt_name)
        var tvDesc: TextView = itemView.findViewById(R.id.txt_detail)
        var imgHero: ImageView = itemView.findViewById(R.id.img_hero)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }
}