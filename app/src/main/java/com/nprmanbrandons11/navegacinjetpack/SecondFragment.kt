package com.nprmanbrandons11.navegacinjetpack

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.nprmanbrandons11.navegacinjetpack.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var argumento:String? = null
    private var argumentoscore:String? = null
    private var _binding : FragmentSecondBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        argumento= arguments?.getString("user")
        _binding = FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        argumentoscore = arguments?.getString("score")
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(argumentoscore != null){
            binding.scoretv.text = argumentoscore}
        else{
            binding.scoretv.text = "0"
        }

        binding.usuarioNombre.text = argumento

        binding.botonCerrarsesion.setOnClickListener{
            findNavController().navigate(R.id.action_secondFragment_to_fragmentMain)
        }

        binding.botonCambiar.setOnClickListener{
            findNavController().navigate(R.id.action_secondFragment_to_loginFragment)

        }

        binding.botonIrbolado.setOnClickListener{
            findNavController().navigate(R.id.action_secondFragment_to_bolado)
        }
    }

}