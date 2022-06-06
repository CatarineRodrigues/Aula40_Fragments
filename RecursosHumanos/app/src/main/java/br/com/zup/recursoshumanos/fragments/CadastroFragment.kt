package br.com.zup.recursoshumanos.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.recursoshumanos.FragmentoClick
import br.com.zup.recursoshumanos.main.MainActivity
import br.com.zup.recursoshumanos.databinding.FragmentCadastroBinding

class CadastroFragment : Fragment() {
    private lateinit var binding: FragmentCadastroBinding
    private lateinit var interfaceClick: FragmentoClick

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCadastroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            interfaceClick = context as MainActivity
        } catch (e: Exception){
            Log.i("Erro", "Erro na inicialização da interface ${e.message}")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCalcularSalario.setOnClickListener {
            interfaceClick.clickFragmento()
        }
    }
}