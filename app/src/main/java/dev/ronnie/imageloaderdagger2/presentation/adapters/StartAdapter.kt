package dev.ronnie.imageloaderdagger2.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.ronnie.imageloaderdagger2.R
import dev.ronnie.imageloaderdagger2.data.images.ImagesItem


class StartAdapter: RecyclerView.Adapter<StartAdapter.StartViewHolder>() { // АДАПТЕР наслідуєм від РЕСАКЛвю. і для нього писали в LEyoutManger// Назва АДАПТЕРА і Придумуєм назву для ХОЛДЕРА

    var listStart = emptyList<ImagesItem>()// Перемінна  яка хоче модель в себе ( НЕ ЛІСТ А МОДЕЛЬ )  ( ЛІСТ получим так чи так )


    class StartViewHolder(view: View): RecyclerView.ViewHolder(view)// ХОЛДЕРА наслідуєм від ресклВЮ

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)

        return StartViewHolder(view)// Вертаєм ВЮШКУ
    }

    override fun onBindViewHolder(holder: StartViewHolder, position: Int) {
        //Берем позицію (ІД того що прилетить ) робим привязку
            //??? НЕзнаю як зробити привязку


    }

    override fun getItemCount(): Int {

        return listStart.size// Вертає розмір Списку

    }

    @SuppressLint("NotifyDataSetChanger")// Функція яка буде установлювати наш ліст
    fun setList(list: List<ImagesItem>){//Не простий ліст а Ліст ImagesItem
        listStart = list
        notifyDataSetChanged()// якщо щось поміняється в даних він зразу про це скаже
    }
}
