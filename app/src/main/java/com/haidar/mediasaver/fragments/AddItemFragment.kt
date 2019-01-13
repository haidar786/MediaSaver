package com.haidar.mediasaver.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment

import com.haidar.mediasaver.R
import com.haidar.mediasaver.viewmodel.AddItemViewModel

class AddItemFragment : Fragment() {

    companion object {
        fun newInstance() = AddItemFragment()
    }

    private lateinit var viewModel: AddItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_item_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddItemViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        menu?.clear()
        inflater?.inflate(R.menu.add_item_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onViewCreated(view, savedInstanceState)
    }
}
