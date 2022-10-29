package edu.nmdunn.cps251_nmdunn.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import edu.nmdunn.cps251_nmdunn.DemoObserver
import edu.nmdunn.cps251_nmdunn.R
import edu.nmdunn.cps251_nmdunn.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        lifecycle.addObserver(DemoObserver())
        lifecycle.addObserver(DemoObserver())
        val strObs = Observer<String> {
                text -> binding.textView.text = text.toString()
        }
        viewModel.returnStr().observe(viewLifecycleOwner, strObs)
        binding.textView.text = viewModel.returnStr().value.toString()

        // TODO: Use the ViewModel
    }

}