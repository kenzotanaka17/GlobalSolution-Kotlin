package kenzotanaka17.com.github.andrekenzo_rm94306.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kenzotanaka17.com.github.andrekenzo_rm94306.R
import kenzotanaka17.com.github.andrekenzo_rm94306.model.DicaModel

class DicasAdapter(private val onDicaRemoved: (DicaModel) -> Unit) :
    RecyclerView.Adapter<DicasAdapter.DicaViewHolder>() {

    private var dicas = listOf<DicaModel>()

    inner class DicaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val textView = view.findViewById<TextView>(R.id.textViewDica)
        private val descriptionView = view.findViewById<TextView>(R.id.textViewDescription)
        private val button = view.findViewById<ImageButton>(R.id.imageButton)

        fun bind(dica: DicaModel) {
            textView?.text = dica.name
            descriptionView?.text = dica.description
            button?.setOnClickListener {
                onDicaRemoved(dica)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DicaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dica_layout, parent, false)
        return DicaViewHolder(view)
    }

    override fun getItemCount(): Int = dicas.size

    override fun onBindViewHolder(holder: DicaViewHolder, position: Int) {
        val dica = dicas[position]
        holder.bind(dica)
    }

    fun updateDicas(newDicas: List<DicaModel>) {
        dicas = newDicas
        notifyDataSetChanged()
    }
}
