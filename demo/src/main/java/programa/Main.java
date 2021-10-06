package programa;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.PersistenciaException;
import dao.UserDAO;
import entities.IdUser;
import entities.User;
import utilitarios.ConversorData;

public class Main {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		UserDAO userDAO = new UserDAO();
		
		System.out.println("1 - Adicionar usuário" +
							"\n2 - Deletar usuário" +
							"\n3 - Atualizar informações do usuário" +
							"\n4 - Encontrar usuário" +
							"\n5 - Listar todos os usuários" +
							"\n6 - Deletar todos os usuários" +
							"\nS - Sair do programa");
		System.out.println("Escolha uma das opções acima: ");
		String resposta = leitor.nextLine();
		
		while (!resposta.toLowerCase().equals("s")) {
			
			if (resposta.equals("1")) {
				
				System.out.println("Digite o cpf do usuário: ");
				Integer cpf = Integer.parseInt(leitor.nextLine());
				
				System.out.println("Digite o nome do usuário: ");
				String nome = leitor.nextLine();
				
				System.out.println("Digite o sobrenome: ");
				String sobrenome = leitor.nextLine();
				
				System.out.println("Digite o email: ");
				String email = leitor.nextLine();
				
				System.out.println("Digite a data do seu nascimento (dd/mm/yyyy): ");
				String dataNascimento = leitor.nextLine();
				Date dataConvertida = ConversorData.converterData(dataNascimento);
				
				User user = new User(cpf, nome, sobrenome, email, dataConvertida);
				
				try {
					userDAO.save(user);
					System.out.println("Usuário cadastrado com sucesso!");
				} catch (PersistenciaException e) {
					System.out.println(e.getMessage());
				}
				
			} else if (resposta.equals("2")) {
				System.out.println("Digite o id do usuário: ");
				Integer id = Integer.parseInt(leitor.nextLine()); 
				
				System.out.println("Digite o cpf do usuário: ");
				Integer cpf = Integer.parseInt(leitor.nextLine());
				
				IdUser pk = new IdUser(id, cpf);
				
				try {
					userDAO.delete(pk);
					System.out.println("Usuário excluído com sucesso!");
				} catch (PersistenciaException e) {
					System.out.println(e.getMessage());
				}
				
				
			} else if (resposta.equals("3")) {
				System.out.println("Digite o id do usuário: ");
				Integer id = Integer.parseInt(leitor.nextLine()); 
				
				System.out.println("Digite o cpf do usuário: ");
				Integer cpf = Integer.parseInt(leitor.nextLine());
				
				IdUser pk = new IdUser(id, cpf);
				
				User usuario;
				try {
					usuario = userDAO.getByPK(pk);
					System.out.println("Usuário encontrado!");
					
					System.out.println("Digite o novo nome do usuário: ");
					String nome = leitor.nextLine();
					
					System.out.println("Digite o novo sobrenome: ");
					String sobrenome = leitor.nextLine();
					
					System.out.println("Digite o novo email: ");
					String email = leitor.nextLine();
					
					System.out.println("Digite a data do seu nascimento (dd/mm/yyyy): ");
					String dataNascimento = leitor.nextLine();
					Date dataConvertida = ConversorData.converterData(dataNascimento);
					
					
					usuario.setNome(nome);
					usuario.setSobrenome(sobrenome);
					usuario.setEmail(email);
					usuario.setDataNascimento(dataConvertida);
					
					userDAO.update(usuario);
					System.out.println("Usuário atualizado com sucesso!");
					
				} catch (PersistenciaException e) {
					System.out.println(e.getMessage());
				}
				
			} else if (resposta.equals("4")) {
				System.out.println("Digite o id do usuário: ");
				Integer id = Integer.parseInt(leitor.nextLine()); 
				
				System.out.println("Digite o cpf do usuário: ");
				Integer cpf = Integer.parseInt(leitor.nextLine());
				
				IdUser pk = new IdUser(id, cpf);
				
				User usuario;
				try {
					usuario = userDAO.getByPK(pk);
					System.out.println(usuario);
				} catch (PersistenciaException e) {
					System.out.println(e.getMessage());
				}
				
			} else if (resposta.equals("5")) {
				
				try {
					List<User> listaUsuarios = userDAO.getAll();
					
					System.out.println("Lista de usuários cadastrados: \n");
					for (User user: listaUsuarios) {
						System.out.println(user);
					}
					
				} catch (PersistenciaException e) {
					System.out.println(e.getMessage());
				}
				
			} else if (resposta.equals("6")) {
				try {
					List<User> listaUsuarios = userDAO.getAll();
					
					IdUser pk = null;
					for (User user: listaUsuarios) {
						pk = new IdUser(user.getId(), user.getCpf());
						userDAO.delete(pk);
					}
					
					System.out.println("Todos os usuários foram deletados com sucesso!");
					
				} catch (PersistenciaException e) {
					System.out.println(e.getMessage());
				}
			}
			
			System.out.println("\n1 - Adicionar usuário" +
					"\n2 - Deletar usuário" +
					"\n3 - Atualizar informações do usuário" +
					"\n4 - Encontrar usuário pelo id" +
					"\n5 - Listar todos os usuários" +
					"\n6 - Deletar todos os usuários" +
					"\nS - Sair do programa");
			System.out.println("Escolha uma das opções acima: ");
			resposta = leitor.nextLine();
		} 
		
		leitor.close();
	}
	

}
