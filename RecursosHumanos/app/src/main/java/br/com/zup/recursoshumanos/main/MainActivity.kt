package br.com.zup.recursoshumanos.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.recursoshumanos.FragmentoClick
import br.com.zup.recursoshumanos.databinding.ActivityMainBinding
import br.com.zup.recursoshumanos.fragments.CadastroFragment
import br.com.zup.recursoshumanos.fragments.SalarioFragment
import br.com.zup.recursoshumanos.model.Funcionario

class MainActivity : AppCompatActivity(), FragmentoClick {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(binding.container.id, CadastroFragment())
            .commit()
    }

    override fun clickFragmento(nome: String, hora: Int, valor: Double) {
        val funcionario = Funcionario(nome,hora,valor)

        val fragmentSalario = SalarioFragment ().apply {
            arguments = Bundle().apply {
                putParcelable("Funcionario", funcionario)
            }
        }

        supportFragmentManager
            .beginTransaction()
            .add(binding.container.id, fragmentSalario)
            .addToBackStack("Cadastro")
            .commit()
    }
}