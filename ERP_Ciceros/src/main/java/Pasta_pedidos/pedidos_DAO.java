/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pasta_pedidos;

import Pasta_conexao_Banco.ConexaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Jeff & Carla
 */
public class pedidos_DAO {
    
    Connection conn = new ConexaoDAO().conectaBD();
    PreparedStatement pstm;
    ResultSet rs;
    
    public int Salvar(pedidos_DTO objDTO){
            
        try {
            String SQL = "insert into tb_pedido(observacao, dia_pedido, cliente)VALUES(?,?,?,?)";
            
        } catch (Exception e) {
            
        }
           
        
}
   
    
}
