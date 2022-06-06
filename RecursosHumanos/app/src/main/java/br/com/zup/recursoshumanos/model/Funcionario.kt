package br.com.zup.recursoshumanos.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Funcionario(
    private var nome: String,
    private var horasTrabalhadas: Int,
    private var valorHora: Double
) : Parcelable {
    private var valorSalário = horasTrabalhadas*valorHora

    fun getNome() = this.nome
    fun getHorasTrabalhadas() = this.horasTrabalhadas
    fun getValorHora() = this.valorHora
    fun getValorSalario() = this.valorSalário
//    TODO perguntar se pode ser feito dessa forma o cálculo, ou se da exception
}