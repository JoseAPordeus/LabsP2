package lab5.pessoas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lab5.contas.Conta;
import lab5.produtos.Comida;

/**
 * Classe cliente
 * 
 * @author Jos? Alisson
 *
 */

public class Cliente implements Comparable<Cliente> {

	private String cpf;
	private String localizacao;
	private String email;
	private String nome;
	private Map<String, Conta> contas;

	public Cliente(String cpf, String nome, String email, String localizacao) {
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
		this.cpf = cpf;
		this.contas = new HashMap<>();
	}

	/**
	 * Metodo que permite mudar o nome
	 * 
	 * @param nome do cliente
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo que permite mudar o localizacao
	 * 
	 * @param localizacao do cliente
	 */
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	/**
	 * Metodo que permite mudar o email
	 * 
	 * @param email email do cliente
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public int compareTo(Cliente o) {
		return this.nome.compareTo(o.nome);
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ CONTAS / COMPRAS

	/**
	 * Metodo que adiciona uma compra de um cliente
	 * 
	 * @param cpf            cpf do cliente
	 * @param nomeFornecedor nome do fornecedor
	 * @param data           data da compra
	 * @param produto        produto a ser adicionado
	 * @return String com o id da conta do cliente
	 */
	public String adicionaCompra(String cpf, String nomeFornecedor, String data, Comida produto) {
		String id = cpf + " - " + nomeFornecedor;
		Conta conta = new Conta();
		if (this.contas.containsKey(id)) {
			this.contas.get(id).adicionaCompra(data, produto);
		} else {
			this.contas.put(id, conta);
			this.contas.get(id).adicionaCompra(data, produto);
		}
		return id;
	}

	/**
	 * Metodo que pega o debito da conta
	 * 
	 * @param cpf            cpf do cliente
	 * @param nomeFornecedor nome do fornecedor
	 * @return String com o preco da divida
	 */
	public String getDebito(String cpf, String nomeFornecedor) {
		String id = cpf + " - " + nomeFornecedor;
		if (!this.contas.containsKey(id) || this.contas.get(id).getDebito().equals("0.00"))
			throw new Error("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		return this.contas.get(id).getDebito();
	}

	/**
	 * Metodo que exibe uma determinada conta
	 * 
	 * @param cpf            cpf do cliente
	 * @param nomeFornecedor nome do fornecedor
	 * @return Strinf com a conta especificada
	 */
	public String exibeContas(String cpf, String nomeFornecedor) {
		String id = cpf + " - " + nomeFornecedor;
		if (!this.contas.containsKey(id) || this.contas.get(id).getProdutos().size() == 0)
			throw new Error("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		return "Cliente: " + this.nome + " | " + nomeFornecedor + this.contas.get(id).toString();
	}

	/**
	 * Metodo que exibe todas as contas de um cliente
	 * 
	 * @param cpf cpf do cliente
	 * @return String com todas as contas do cliente
	 */
	public String exibeTodasContas(String cpf) {
		String saida = "";
		for (String id : getContasCPF(cpf)) {
			saida += " | " + id.substring(14) + this.contas.get(id).toString();
		}
		return "Cliente: " + this.nome + saida;
	}

	/**
	 * Metodo que realiza o pagamento de determinada conta
	 * 
	 * @param cpf            cpf do cliente
	 * @param nomeFornecedor nome do fornecedor
	 */
	public void realizaPagamento(String cpf, String nomeFornecedor) {
		String id = cpf + " - " + nomeFornecedor;
		if (!this.contas.containsKey(id) || this.contas.get(id).getDebito().equals("0.00"))
			throw new Error("Erro no pagamento de conta: nao ha debito do cliente associado a este fornecedor.");
		this.contas.get(id).realizaPagamento();
	}

	/**
	 * Metodo que pega as contas que contem o cpf especificado
	 * 
	 * @param cpf cpf do cliente
	 * @return Sorted Array de contas que contem o cpf
	 */
	private ArrayList<String> getContasCPF(String cpf) {
		ArrayList<String> contasCPF = new ArrayList<>();
		for (String id : this.contas.keySet()) {
			if (id.substring(0, 11).equals(cpf))
				contasCPF.add(id);
		}
		Collections.sort(contasCPF);
		if (contasCPF.size() == 0)
			throw new Error("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
		return contasCPF;
	}

}
