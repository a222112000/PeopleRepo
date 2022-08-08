package com.example.virginmoney.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoney.R
import com.example.virginmoney.adapter.PeopleAdapter
import com.example.virginmoney.databinding.FragmentPeopleBinding
import com.example.virginmoney.util.UIState

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PeopleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PeopleFragment : BaseFragment() {
    private val binding by lazy {
        FragmentPeopleBinding.inflate(layoutInflater)
    }
    private val peopleAdapter by lazy {
        PeopleAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initRecyclerView()
        observeData()
        return binding.root
    }
    private fun initRecyclerView(){
        binding.peopleRecVw.apply{
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            adapter = peopleAdapter
        }
    }

    private fun observeData(){
        virginViewModel.people.observe(viewLifecycleOwner){state ->
            when(state){
                is UIState.LOADING ->{

                }
                is UIState.SUCCESS2 -> {
                    peopleAdapter.setPeople(state.response)
                }
                is UIState.ERROR -> {
                    showError(state.error.localizedMessage){
                        virginViewModel.getRoom()
                    }
                }
                else -> {}
            }
        }
        virginViewModel.getPeople()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.let {
            null
        }
    }
}