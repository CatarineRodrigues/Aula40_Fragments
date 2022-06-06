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
import kotlin.properties.Delegates

class CadastroFragment : Fragment() {
    private lateinit var binding: FragmentCadastroBinding
    private lateinit var interfaceClick: FragmentoClick
    private lateinit var nome: String
    private lateinit var horasTrabalhadas: String
    private lateinit var valorHora: String

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

    private fun recuperarDados(){
        this.nome = binding.etNome.text.toString()
        this.horasTrabalhadas = binding.etHorasTrabalhadas.text.toString()
        this.valorHora = binding.etValorHora.text.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCalcularSalario.setOnClickListener {
            recuperarDados()
            interfaceClick.clickFragmento(nome, horasTrabalhadas.toInt(), valorHora.toDouble())
        }
    }
}