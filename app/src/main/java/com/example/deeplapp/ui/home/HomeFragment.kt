package com.example.deeplapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.deeplapp.R
import com.example.deeplapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val binding: FragmentHomeBinding = DataBindingUtil
            .inflate(layoutInflater, R.layout.fragment_home, container, false)



        /*val spinnerTranslateFrom : Spinner = root.findViewById(R.id.spinnerTranslateFrom)
        val spinnerTranslateTo : Spinner = root.findViewById(R.id.spinnerTranslateTo)
        homeViewModel.getSourceLanguages().observe(viewLifecycleOwner, Observer { languageList ->
            val adapter = ArrayAdapter(this.requireActivity(), android.R.layout.simple_spinner_dropdown_item, languageList)
            spinnerTranslateFrom.adapter = adapter
        })

        spinnerTranslateFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var selectedItem = homeViewModel.getSourceLanguages().value?.get(id.toInt())
                Toast.makeText(activity, selectedItem.toString(), Toast.LENGTH_LONG).show()
                var sourceList = homeViewModel.getSourceLanguages()
                val filteredList = sourceList.value?.filterNot { it.Language == selectedItem?.Language}
                if (filteredList != null) {
                    homeViewModel.setDestinationLanguages(filteredList)
                }
                val adapter = filteredList?.let {
                    ArrayAdapter(context!!, android.R.layout.simple_spinner_dropdown_item,
                        it
                    )
                }
                spinnerTranslateTo.adapter = adapter
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }*/
        return root
    }
}