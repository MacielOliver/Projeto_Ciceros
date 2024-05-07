/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pasta_pedidos;

import Pasta_conexao_Banco.ConexaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author Jeff & Carla
 */
public class pedidos_DAO {
    
    Connection conn = new ConexaoDAO().conectaBD();
    PreparedStatement pstm;
    ResultSet rs;
    
    public int Salvar(pedidos_DTO objDTO){
             int lastid=0;
        try {
            String SQL = "insert into tb_pedido(observacao, dia_pedido, cliente)VALUES(?,?,?)";
            
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, objDTO.getCampoObservacao());
            pstm.setString(2, objDTO.getData().toString());
            pstm.setInt(3, objDTO.getCampoIDCliente());
            pstm.execute();
            
            rs= pstm.executeQuery("SELECT LAST_INSERT_ID()");
            if(rs.next()){
                lastid = rs.getInt(1);
            }
            
            pstm.close();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso ");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na usuario_DAO ao salvar os dados: " + erro);
        }
        return  lastid;
        
    }
    
    public pedidos_DTO ConsultaUltimoID(){
        pedidos_DTO objDTO = new pedidos_DTO();
        try {
            
            
            String sql = "SELECT LAST_INSERT_ID() INTO @tb_pedido";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            objDTO.setIdPedidos(rs.getInt("id_ped_pk"));
            
            JOptionPane.showMessageDialog(null,"Consulta realizada com sucesso: ");
            
        }catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro na pedidos_DAO ao consultar o ID: " +  erro);
            
        }
        return objDTO;
    }
   
    
}
