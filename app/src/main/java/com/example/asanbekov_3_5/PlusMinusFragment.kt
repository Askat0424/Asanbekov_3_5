package com.example.asanbekov_3_5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.asanbekov_3_5.databinding.FragmentPlusMinusBinding

class PlusMinusFragment : Fragment() {

    private lateinit var binding: FragmentPlusMinusBinding
    private var itsWasTen: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlusMinusBinding.inflate(layoutInflater)
        binding.textView.setText("0")
        itsWasTen = false
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            if (!itsWasTen){
                binding.textView.text = (binding.textView.text.toString().toInt() + 1).toString()

                if (binding.textView.text.toString().toInt() == 10){
                    binding.button.text = "-1"
                    itsWasTen = true
                }
            } else {
                binding.textView.text = (binding.textView.text.toString().toInt() - 1).toString()

                if (binding.textView.text.toString() == "0"){

                    val bandle = Bundle()
                    bandle.putString("RESULT", binding.editText.text.toString())
                    val resultFragment = ResultFragment()
                    resultFragment.arguments = bandle

                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.container, resultFragment)?.addToBackStack(null)?.commit()
                }
            }
        }
    }
}