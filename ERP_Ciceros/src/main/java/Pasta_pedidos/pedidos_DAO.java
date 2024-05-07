/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pasta_pedidos;

import Pasta_conexao_Banco.ConexaoDAO;
import Pasta_estoque.estoque_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.time.LocalDate;

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
    
  
    
    
    public ArrayList<pedidos_DTO> Consulta_por_Data(String filtro){
            ArrayList<pedidos_DTO> listaDTO = new ArrayList<pedidos_DTO>();
            
            String sql = "SELECT id_ped_pk, observacao, dia_pedido, nome,telefone FROM tb_pedido inner join tb_cliente on cliente = id_cli_pk WHERE dia_pedido like ?";
           
            try {
                   pstm = conn.prepareStatement(sql);
                   pstm.setString(1, "%"+filtro+"%");
                   rs = pstm.executeQuery();
                         while(rs.next()){
                            pedidos_DTO Obj_DTO = new pedidos_DTO();
                            Obj_DTO.setIdPedidos(rs.getInt("id_ped_pk"));
                            Obj_DTO.setCampoObservacao(rs.getString("observacao"));
                            Obj_DTO.setData(rs.getDate("dia_pedido").toLocalDate());
                            Obj_DTO.setNome(rs.getString("nome"));
                            Obj_DTO.setTelefone(rs.getString("telefone"));
                
                    listaDTO.add(Obj_DTO);
                
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro de Consulta "+ erro);
        }
    
    
            return listaDTO;
    }
    
    public pedidos_DTO Consulta_por_ID(int ID){
        pedidos_DTO objDTO = new pedidos_DTO();
        String sql = "SELECT * FROM tb_pedido WHERE id_ped_pk = ?";
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ID);
            
            rs = pstm.executeQuery();
            
            if(rs.next()){
                objDTO.setCampoObservacao(rs.getString("observacao"));
            }
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null,"Erro ao consultar por id: " + erro);
        }
        
        return objDTO;
    }
    
    public ArrayList<pedidos_DTO> Consulta_por_Tel(String filtro){
            ArrayList<pedidos_DTO> listaDTO = new ArrayList<pedidos_DTO>();
            
            String sql = "SELECT id_ped_pk, observacao, dia_pedido, nome,telefone FROM tb_pedido inner join tb_cliente on cliente = id_cli_pk WHERE telefone like ?";
           
            try {
                   pstm = conn.prepareStatement(sql);
                   pstm.setString(1, "%"+filtro+"%");
                   rs = pstm.executeQuery();
                         while(rs.next()){
                            pedidos_DTO Obj_DTO = new pedidos_DTO();
                            Obj_DTO.setIdPedidos(rs.getInt("id_ped_pk"));
                            Obj_DTO.setCampoObservacao(rs.getString("observacao"));
                            Obj_DTO.setData(rs.getDate("dia_pedido").toLocalDate());
                            Obj_DTO.setNome(rs.getString("nome"));
                            Obj_DTO.setTelefone(rs.getString("telefone"));
                
                    listaDTO.add(Obj_DTO);
                
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro de Consulta "+ erro);
        }
    
    
            return listaDTO;
    }
   
    
}
