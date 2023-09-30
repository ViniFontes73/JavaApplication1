package javaapplication1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JavaApplication1 {
    public static void main(String[] args) {
        Connection c;
        try {
            // chama o drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            // chama meu bd e faz a conexão
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja_departamentos", "root", "vinicius");
            //System.out.print(c);
            if (c != null) {
                //System.out.println("Conexão estabelecida com sucesso.");

                // Consulta para selecionar todos os clientes
                String selectQuery = "SELECT * FROM clientes";
                PreparedStatement preparedStatement = c.prepareStatement(selectQuery);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String cpf = resultSet.getString("cpf");
                    String nome = resultSet.getString("nome");
                    String email = resultSet.getString("email");
                    String telefone = resultSet.getString("telefone");
                    String endereco = resultSet.getString("endereco");
                    String contaBanco = resultSet.getString("ContaBanco");
                    String agenciaBanco = resultSet.getString("AgenciaBanco");

                    System.out.println("CPF: " + cpf);
                    System.out.println("Nome: " + nome);
                    System.out.println("Email: " + email);
                    System.out.println("Telefone: " + telefone);
                    System.out.println("Endereço: " + endereco);
                    System.out.println("Conta Bancária: " + contaBanco);
                    System.out.println("Agência Bancária: " + agenciaBanco);
                    System.out.println("---------------");
                }
            } else {
                System.out.println("Não foi possível conectar ao banco de dados.");
            }
        } catch (ClassNotFoundException | SQLException ex) {
        }
    }
}
