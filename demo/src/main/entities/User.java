package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

// precisa implementar Serializable!
@Entity
@Table(name = "Tabela_User")
public class User implements Serializable {
   
    // Id do objeto (chave primária)
    @Id
    // Forma de incrementar o valor do id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //Mudando o nome da coluna
    @Column(name = "ID")
    private Integer id;

    @Column(name = "FIRST_NAME")
    private String nome;

    @Column(name = "LAST_NAME")
    private String sobrenome;

    @Column(name = "EMAIL")
    private String email;

    // Marcando o atributo (coluna) como data
    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTHDAY")
    private Date dataNascimento;
    
    // Precisa ter um construtor vazio!
    public User() {

    }

    public Integer getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome  = nome;
    } 

    public String getNome() {
        return this.nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome  = sobrenome;
    } 

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    } 

    public String toString() {
		return "User [id=" + id + ", firstName=" + nome + ", lastName=" + sobrenome + ", email=" + email
				+ ", birthday=" + dataNascimento + "]";
	}

}