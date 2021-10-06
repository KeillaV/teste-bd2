package entities;

import java.io.Serializable;

public class IdUser implements Serializable {

	private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer cpf;
    
    public IdUser() {
    	
    }
    
    public IdUser(Integer id, Integer cpf) {
    	this.id = id;
    	this.cpf = cpf;
    }
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	// Precisa sobrescrever os métodos hashCode e equals:
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		IdUser idUser = (IdUser) obj;
		return cpf.equals(idUser.getCpf()) && id.equals(idUser.getId());
	}
    
    
}
