import javax.persistence.Entity;

@Entity
public class User {
   
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    
    // Precisa ter um construtor vazio!
    public User() {

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

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    } 
}