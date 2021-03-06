package lab5.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lab5.pessoas.Fornecedor;
import lab5.produtos.Comida;

/**
 * Controlador de Fornecedor
 * 
 * @author Jos? Alisson
 *
 */
public class FornecedorController {

	private Map<String, Fornecedor> fornecedores;

	public FornecedorController() {
		this.fornecedores = new HashMap<>();
	}

	/**
	 * Metodo que permite pegar o mapa de fornecedores
	 * 
	 * @return Retorna o mapa de fornecedores
	 */
	public Map<String, Fornecedor> getFornecedores() {
		return this.fornecedores;
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ FORNECEDOR
	/**
	 * Metodo que adiciona um fornecedor
	 * 
	 * @param nome     nome do fornecedor
	 * @param email    email do fornecedor
	 * @param telefone telefone do fornecedor
	 * @return String mostrandp o nome do fornecedor adicionado
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
		this.fornecedores.put(nome, fornecedor);
		return nome;
	}

	/**
	 * Metodo que edita um fornecedor
	 * 
	 * @param nome      nome do fornecedor
	 * @param atributo  atributo que vai ser editado
	 * @param novoValor novo valor do atributo editado
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		switch (atributo) {
		case "nome":
			throw new Error("Erro na edicao do fornecedor: nome nao pode ser editado.");
		case "email":
			this.fornecedores.get(nome).setEmail(novoValor);
			return;
		case "telefone":
			this.fornecedores.get(nome).setTelefone(novoValor);
			return;
		default:
			throw new Error("Erro na edicao do fornecedor: atributo nao existe.");
		}
	}

	/**
	 * Metodo que exibe um fornecedor determinado
	 * 
	 * @param nome nome do fornecedor
	 * @return String com uma representacao do fornecedor
	 */
	public String exibeFornecedor(String nome) {
		return this.fornecedores.get(nome).toString();
	}

	/**
	 * Metodo que exibe todos os fornecedores cadastrados
	 * 
	 * @return String com todos os fornecedores cadastrados
	 */
	public String exibeTodos() {
		ArrayList<Fornecedor> arrayFornecedores = getArrayFornecedores();
		Collections.sort(arrayFornecedores);
		return arrayToString(arrayPutInfos(arrayFornecedores));
	}

	/**
	 * Metodo que remove um fornecedor a partir do nome
	 * 
	 * @param nome nome do fornecedor
	 */
	public void removeFornecedor(String nome) {
		this.fornecedores.remove(nome);
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PRODUTOS SIMPLES

	/**
	 * Metodo que adiciona um produto simples a um fornecedor
	 * 
	 * @param nomeFornecedor nome do fornecedor do produto
	 * @param nomeProduto    nome do produto
	 * @param descricao      descricao do produto
	 * @param preco          preco do produto
	 * @return String mostrandp o id (nome e descricao) do produto adicionado
	 */
	public String cadastraProdutoSimples(String nomeFornecedor, String nomeProduto, String descricao, String preco) {
		return fornecedorValido(nomeFornecedor, "no cadastro de produto").cadastraProdutoSimples(nomeProduto, descricao,
				preco);
	}

	/**
	 * Metodo que edita um produto simples
	 * 
	 * @param nomeProduto    novo nome do produto
	 * @param descricao      nova descricao do produto
	 * @param novoPreco      novo preco do produto
	 * @param nomeFornecedor nome do fornecedor do produto
	 */
	public void editaProdutoSimples(String nomeProduto, String descricao, String nomeFornecedor, String novoPreco) {
		fornecedorValido(nomeFornecedor, "na edicao de produto").editaProdutoSimples(nomeProduto, descricao, novoPreco);
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PRODUTOS COMBO

	/**
	 * Metodo que adiciona um produto COMBO a um fornecedor
	 * 
	 * @param nomeFornecedor nome do fornecedor do produto
	 * @param nomeProduto    nome do produto
	 * @param descricao      descricao do produto
	 * @param fator          fator do produto
	 * @param produtos       produtos que compoem o combo
	 * @return String mostrandp o id (nome e descricao) do produto adicionado
	 */
	public String cadastraProdutoCombo(String nomeFornecedor, String nomeProduto, String descricao, String fator,
			String produtos) {
		return fornecedorValido(nomeFornecedor, "no cadastro de combo").cadastraProdutoCombo(nomeProduto, descricao,
				fator, produtos);
	}

	/**
	 * Metodo que edita um produto COMBO
	 * 
	 * @param nomeProduto    novo nome do produto
	 * @param descricao      nova descricao do produto
	 * @param novoFator      novo fator do produto
	 * @param nomeFornecedor nome do fornecedor do produto
	 */
	public void editaProdutoCombo(String nomeProduto, String descricao, String nomeFornecedor, String novoFator) {
		fornecedorValido(nomeFornecedor, "na edicao de combo").editaProdutoCombo(nomeProduto, descricao, novoFator);
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PRODUTOS

	/**
	 * Metodo que exibe um produto determinado
	 * 
	 * @param nome           nome do produto
	 * @param descricao      descricao do produto
	 * @param nomeFornecedor nome do fornecedor do produto
	 * @return String com uma representacao do produto
	 */
	public String exibeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		return fornecedorValido(nomeFornecedor, "na exibicao de produto").exibeProduto(nomeProduto, descricao);
	}

	/**
	 * Metodo que exibe todoss produtos de um fornecedor
	 * 
	 * @param nomeFornecedor nome do fornecedor dos produtos
	 * @return String com todos os produtos de um fornecedor
	 */
	public String exibeProdutosFornecedor(String nomeFornecedor) {
		return fornecedorValido(nomeFornecedor, "na exibicao de produto").exibeTodosProdutos();
	}

	/**
	 * Metodo que exibe todos os produtos cadastrados (de todos os fornecedores)
	 * 
	 * @return String com todos os produtos cadastrados
	 */
	public String exibeTodosProdutos() {
		ArrayList<Fornecedor> arrayFornecedores = getArrayFornecedores();
		Collections.sort(arrayFornecedores);

		ArrayList<String> arrayProdutos = new ArrayList<>();
		for (Fornecedor fornecedor : arrayFornecedores) {
			arrayProdutos.add(fornecedor.exibeTodosProdutos());
		}
		return arrayToString(arrayProdutos);
	}

	/**
	 * Metodo que remove um produto de um fornecedor a partir do nome e descricao
	 * 
	 * @param nome           nome do produto
	 * @param descricao      descricao do produto
	 * @param nomeFornecedor nome do fornecedor do produto
	 */
	public void removeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		fornecedorValido(nomeFornecedor, "na remocao de produto").removeProduto(nomeProduto, descricao);
	}

	/**
	 * Metodo que tranforma um mapa de fornecedores em um array
	 * 
	 * @return ArrayList de fornecedores
	 */
	public ArrayList<Fornecedor> getArrayFornecedores() {
		ArrayList<Fornecedor> arrayDeInfos = new ArrayList<>();
		for (Object key : this.fornecedores.keySet()) {
			arrayDeInfos.add(this.fornecedores.get(key));
		}
		return arrayDeInfos;
	}

	/**
	 * Metodo que cooca informacoes no array de fornecedores
	 * 
	 * @param arrayFornecedores array de fornecedores
	 * @return Um array de fornecedores com as informacoes dos fornecedores
	 */
	private ArrayList<String> arrayPutInfos(ArrayList<?> arrayFornecedores) {
		ArrayList<String> arrayDeInfos = new ArrayList<>();
		for (int i = 0; i < arrayFornecedores.size(); i++) {
			arrayDeInfos.add(arrayFornecedores.get(i).toString());
		}
		return arrayDeInfos;
	}

	/**
	 * Metodo que coloca as informações de um array em uma unica string
	 * 
	 * @param arrayFornecedores array a ser convertido
	 * @return String com as informações do array
	 */
	private String arrayToString(ArrayList<?> arrayFornecedores) {
		String saida = arrayFornecedores.get(0).toString();
		for (int i = 1; i < arrayFornecedores.size(); i++) {
			saida += " | " + arrayFornecedores.get(i);
		}
		return saida;
	}

	/**
	 * Metodo que pega um fornecedor valido
	 * 
	 * @param nomeFornecedor nome do fornecedor
	 * @param campo          campo onde esta sendo chamada o metodo
	 * @return
	 */
	private Fornecedor fornecedorValido(String nomeFornecedor, String campo) {
		if (nomeFornecedor == null || nomeFornecedor.trim().equals(""))
			throw new Error("Erro " + campo + ": fornecedor nao pode ser vazio ou nulo.");
		else if (!this.fornecedores.containsKey(nomeFornecedor))
			throw new Error("Erro " + campo + ": fornecedor nao existe.");
		Fornecedor fornecedor = fornecedores.get(nomeFornecedor);
		return fornecedor;
	}

	/**
	 * Metodo que permite pegar os produtos de um determinado fornecedor
	 * 
	 * @param nomeFornecedor nome do fornecedor
	 * @return Retorna o array de produtos
	 */
	public Map<String, Comida> getProdutos(String nomeFornecedor) {
		return this.fornecedores.get(nomeFornecedor).getProdutos();
	}

}
