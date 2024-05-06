/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pasta_pedidos;

import java.time.LocalDate;

/**
 *
 * @author vsant
 */
public class pedidos_DTO {
    
    
    private int campoIDCliente;
    private int IdPedidos;
    private String campoObservacao;
    private String nome;
    private String telefone;
    private LocalDate data;

    /**
     * @return the campoIDCliente
     */
    public int getCampoIDCliente() {
        return campoIDCliente;
    }

    /**
     * @param campoIDCliente the campoIDCliente to set
     */
    public void setCampoIDCliente(int campoIDCliente) {
        this.campoIDCliente = campoIDCliente;
    }

    /**
     * @return the IdPedidos
     */
    public int getIdPedidos() {
        return IdPedidos;
    }

    /**
     * @param IdPedidos the IdPedidos to set
     */
    public void setIdPedidos(int IdPedidos) {
        this.IdPedidos = IdPedidos;
    }

    /**
     * @return the campoObservacao
     */
    public String getCampoObservacao() {
        return campoObservacao;
    }

    /**
     * @param campoObservacao the campoObservacao to set
     */
    public void setCampoObservacao(String campoObservacao) {
        this.campoObservacao = campoObservacao;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the data
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(LocalDate data) {
        this.data = data;
    }
    
    
    
    
}
