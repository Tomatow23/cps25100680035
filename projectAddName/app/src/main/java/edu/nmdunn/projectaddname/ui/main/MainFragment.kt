package edu.nmdunn.projectaddname.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import edu.nmdunn.projectaddname.R
import edu.nmdunn.projectaddname.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // TODO: Use the ViewModel
        val enterName : EditText = binding.enterName
        val visNames : TextView = binding.visNames
        val addName : Button = binding.addName
        var getNames : String


        val listener = View.OnClickListener { v ->
            viewModel.setName(enterName.text.toString())
//            getNames = viewModel.getName()
            visNames.text = viewModel.getName()
        }
        addName.setOnClickListener(listener)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}