package com.example.virginmoney.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoney.R
import com.example.virginmoney.adapter.RoomAdapter
import com.example.virginmoney.databinding.FragmentRoomBinding
import com.example.virginmoney.util.UIState

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RoomFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RoomFragment : BaseFragment() {
   private val binding by lazy {
       FragmentRoomBinding.inflate(layoutInflater)
   }

    private val roomAdapter by lazy {
        RoomAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
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
        binding.RoomRV.apply {
            this.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            adapter = roomAdapter
        }
    }

    private fun observeData(){
        virginViewModel.rooms.observe(viewLifecycleOwner){state->
            when(state) {
                is UIState.LOADING -> {

                }
                is UIState.SUCCESS -> {
                    roomAdapter.setRoom(state.response)
                }
                is UIState.ERROR -> {
                    showError(state.error.localizedMessage) {
                        virginViewModel.getRoom()
                    }
                }
                else -> {}
            }
            virginViewModel.getRoom()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.let {
            null
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RoomFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RoomFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}