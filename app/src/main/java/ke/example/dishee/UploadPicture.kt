package ke.example.dishee

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ke.example.dishee.databinding.FragmentUploadPictureBinding

class UploadPicture : Fragment() {

    companion object {
        fun newInstance() = UploadPicture()
    }

    private lateinit var viewModel: UploadPictureViewModel
    private lateinit var binding: FragmentUploadPictureBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUploadPictureBinding.inflate(inflater, container,false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UploadPictureViewModel::class.java)
        binding.profileBtn.setOnClickListener {
            this.findNavController().navigate(
                UploadPictureDirections.actionUploadPictureToCongrats()
            )
        }

}

}
