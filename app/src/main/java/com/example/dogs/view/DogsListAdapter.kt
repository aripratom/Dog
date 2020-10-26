package com.example.dogs.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.dogs.R
import com.example.dogs.databinding.ItemDogBinding
import com.example.dogs.model.DogBreed
import com.example.dogs.util.getProgressDrawable
import com.example.dogs.util.loadImage
import kotlinx.android.synthetic.main.item_dog.view.*

class DogsListAdapter(val dogList: ArrayList<DogBreed>) :
    RecyclerView.Adapter<DogsListAdapter.DogViewHolder>(), DogClickListener {

    fun updateDogList(newDogList: List<DogBreed>){
        dogList.clear()
        dogList.addAll(newDogList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.item_dog, parent, false)
        val view = DataBindingUtil.inflate<ItemDogBinding>(inflater, R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    override fun getItemCount() = dogList.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view.dog = dogList[position]
        holder.view.listener = this
    }

    override fun onDogClicked(v: View) {
        val uuid = v.dogId.text.toString().toInt()
        val action = ListFragmentDirections.actionDetailFragment()
            action.dogUuid = uuid
            Navigation.findNavController(v).navigate(action)
    }

    class DogViewHolder(var view: ItemDogBinding) : RecyclerView.ViewHolder(view.root)

}