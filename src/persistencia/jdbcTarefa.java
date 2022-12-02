/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;
import modelo.Tarefa;
/**
 *
 * @author vitor
 */
public class jdbcTarefa {
    Connection conexao;

    public jdbcTarefa(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirTarefa(Tarefa t){
        String sql = "insert into tarefas(concluido, nome) values (?, ?)";
        PreparedStatement ps;

        try {
            ps = this.conexao.prepareStatement(sql);
            ps.setBoolean(1, t.isConcluido());
            ps.setString(2, t.getNome());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<Tarefa> listarTarefas(){
        ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
        String sql = "select * from tarefas";
        
         try {
            Statement declaração = conexao.createStatement();
            ResultSet resposta = declaração.executeQuery(sql);
            
            while(resposta.next()) {
                int id = resposta.getInt("id");
                boolean concluido = resposta.getBoolean("concluido");
                String nome = resposta.getString("nome");
                
                Tarefa t = new Tarefa(id, concluido, nome);
                tarefas.add(t);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return tarefas;
    }
    public Tarefa buscarPorId(String id) {
        Tarefa t = new Tarefa();
        String sql = "select * from tarefas where id =" + id;
        
        try {
            Statement declaração = conexao.createStatement();
            ResultSet resposta = declaração.executeQuery(sql);
            
            while(resposta.next()) {
                String nome = resposta.getString("nome");
                boolean concluido = resposta.getBoolean("concluido");
                
                t = new Tarefa(concluido, nome);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return t;
    }
    public void atualizarTarefa(Tarefa t){
        String sql = "update tarefas set nome = ?, concluido = ? where id = ?";
        PreparedStatement ps;
        
        try {
            ps = this.conexao.prepareStatement(sql);
            ps.setString(1, t.getNome());
            ps.setBoolean(2, t.isConcluido());
            ps.setInt(3, t.getId());
            ps.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
