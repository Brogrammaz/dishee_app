package ke.example.dishee

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import ke.example.dishee.databinding.FragmentCongratsBinding


class Congrats : Fragment() {

    companion object {
        fun newInstance() = ke.example.dishee.Congrats()
    }

    private lateinit var viewModel: ke.example.dishee.CongratsViewModel
    private lateinit var binding: FragmentCongratsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCongratsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner =this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ke.example.dishee.CongratsViewModel::class.java)
        binding.startBtn.setOnClickListener {
            this.findNavController().navigate(
                ke.example.dishee.CongratsDirections.actionCongratsToLogin()
            )
        }
    }

}
