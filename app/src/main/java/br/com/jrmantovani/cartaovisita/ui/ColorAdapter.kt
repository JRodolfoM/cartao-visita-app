package br.com.jrmantovani.cartaovisita.ui


import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import br.com.jrmantovani.cartaovisita.R


class ColorAdapter( context: Context, resource: Int, colors: Array<String>) : ArrayAdapter<String>(context, resource, colors) {
    private var  inflater: LayoutInflater =  context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater



    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View? {
        return getCustomView(position, convertView, parent)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    fun getCustomView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val row: View = inflater.inflate(R.layout.spinner_color,parent,false)
        val image: ImageView = row.findViewById(R.id.imageView) as ImageView

        //Obtém a cor referente a esta posição
        val color: Int = getColor(position)
        // Obtém a referência ao circlo
        val retangulo: Drawable = image.getDrawable()
        //Atribui a cor
        retangulo.setColorFilter(color, PorterDuff.Mode.MULTIPLY)
        return row
    }

    override fun getItem(position: Int): String? {
        return super.getItem(position)
    }

    fun getColor(position: Int): Int {
        return Color.parseColor(getItem(position))
    }
}