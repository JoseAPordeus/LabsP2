package lab5.controllers;

import lab5.Verificador;

/**
 * @author Jos? Alisson
 */
public class GeralController {

	private ClienteController cc;
	private FornecedorController fc;
	private Verificador u;

	public GeralController() {
		this.cc = new ClienteController();
		this.fc = new FornecedorController();
		this.u = new Verificador();
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ CLIENTES
	/**
	 * Metodo que adiciona um cliente
	 * 
	 * @param cpf         cpf do cliente
	 * @param nome        nome do cliente
	 * @param email       email do cliente
	 * @param localizacao localizacao do cliente
	 * @return String mostrandp o cpf do cliente adicionado
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		u.verificadorAdicionaCliente(cpf, nome, email, localizacao, this.cc.getClientes());
		return this.cc.adicionaCliente(cpf, nome, email, localizacao);
	}

	/**
	 * Metodo que edita um cliente
	 * 
	 * @param cpf       cpf do cliente
	 * @param atributo  atributo que vai ser editado
	 * @param novoValor novo valor do atributo editado
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		u.verificadorEditaPessoa(cpf, atributo, novoValor, "cliente", this.cc.getClientes());
		this.cc.editaCliente(cpf, atributo, novoValor);
	}

	/**
	 * Metodo que exibe um cliente determinado
	 * 
	 * @param cpf cpf do cliente
	 * @return String que representa o cliente
	 */
	public String exibeCliente(String cpf) {
		return this.cc.exibeCliente(cpf);
	}

	/**
	 * Metodo que exibe todos os clientes cadastrados
	 * 
	 * @return String com todos os clientes cadastrados
	 */
	public String exibeTodosClientes() {
		return this.cc.exibeTodos();
	}

	/**
	 * Metodo que remove um cliente a partir do cpf
	 * 
	 * @param cpf cpf do cliente
	 */
	public void removeCliente(String cpf) {
		this.cc.removeCliente(cpf);
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ FORNECEDORES

	/**
	 * Metodo que adiciona um fornecedor
	 * 
	 * @param nome     nome do fornecedor
	 * @param email    email do fornecedor
	 * @param telefone telefone do fornecedor
	 * @return String mostrandp o nome do fornecedor adicionado
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		u.verificadorAdicionaFornecedor(nome, email, telefone, this.fc.getFornecedores());
		return this.fc.adicionaFornecedor(nome, email, telefone);
	}

	/**
	 * Metodo que edita um fornecedor
	 * 
	 * @param nome      nome do fornecedor
	 * @param atributo  atributo que vai ser editado
	 * @param novoValor novo valor do atributo editado
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		u.verificadorEditaPessoa(nome, atributo, novoValor, "fornecedor", this.fc.getFornecedores());
		this.fc.editaFornecedor(nome, atributo, novoValor);
	}

	/**
	 * Metodo que exibe um fornecedor determinado
	 * 
	 * @param nome nome do fornecedor
	 * @return String com uma representacao do fornecedor
	 */
	public String exibeFornecedor(String nome) {
		u.verificadorExibeFornecedor(nome, "fornecedor", this.fc.getFornecedores());
		return this.fc.exibeFornecedor(nome);
	}

	/**
	 * Metodo que exibe todos os fornecedores cadastrados
	 * 
	 * @return String com todos os fornecedores cadastrados
	 */
	public String exibeTodosFornecedores() {
		return this.fc.exibeTodos();
	}

	/**
	 * Metodo que remove um fornecedor a partir do nome
	 * 
	 * @param nome nome do fornecedor
	 */
	public void removeFornecedor(String nome) {
		u.verificadorRemoveFornecedor(nome);
		this.fc.removeFornecedor(nome);
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
	public String adicionaProdutoSimples(String nomeFornecedor, String nomeProduto, String descricao, String preco) {
		u.verificadorAdicionaProdSimples(nomeFornecedor, nomeProduto, descricao, preco);
		return this.fc.cadastraProdutoSimples(nomeFornecedor, nomeProduto, descricao, preco);
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
		u.verificadorEditaProdSimples(nomeProduto, descricao, novoPreco);
		this.fc.editaProdutoSimples(nomeProduto, descricao, nomeFornecedor, novoPreco);
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PRODUTOS COMBOS

	/**
	 * Metodo que adiciona um produto COMBO a um fornecedor
	 * 
	 * @param nomeFornecedor nome do fornecedor do produto
	 * @param nomeProduto    nome do produto
	 * @param descricao      descricao do produto
	 * @param fator          fator do produto
	 * @param produtos		 produtos que compoem o combo
	 * @return String mostrandp o id (nome e descricao) do produto adicionado
	 */
	public String adicionaCombo(String nomeFornecedor, String nomeProduto, String descricao, String fator,
			String produtos) {
		u.verificadorAdicionaProdCombo(nomeFornecedor, nomeProduto, descricao, fator, produtos);
		return this.fc.cadastraProdutoCombo(nomeFornecedor, nomeProduto, descricao, fator, produtos);
	}

	/**
	 * Metodo que edita um produto COMBO
	 * 
	 * @param nomeProduto    novo nome do produto
	 * @param descricao      nova descricao do produto
	 * @param novoFator      novo fator do produto
	 * @param nomeFornecedor nome do fornecedor do produto
	 */
	public void editaCombo(String nomeProduto, String descricao, String nomeFornecedor, String novoFator) {
		u.verificadorEditaProdCombo(nomeProduto, descricao, novoFator);
		this.fc.editaProdutoCombo(nomeProduto, descricao, nomeFornecedor, novoFator);
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
		u.verificadorExibeProduto(nomeProduto, descricao);
		return this.fc.exibeProduto(nomeProduto, descricao, nomeFornecedor);
	}

	/**
	 * Metodo que exibe todoss produtos de um fornecedor
	 * 
	 * @param nomeFornecedor nome do fornecedor dos produtos
	 * @return String com todos os produtos de um fornecedor
	 */
	public String exibeProdutosFornecedor(String nomeFornecedor) {
		return this.fc.exibeProdutosFornecedor(nomeFornecedor);
	}

	/**
	 * Metodo que exibe todos os produtos cadastrados (de todos os fornecedores)
	 * 
	 * @return String com todos os produtos cadastrados
	 */
	public String exibeTodosProdutos() {
		return this.fc.exibeTodosProdutos();
	}

	/**
	 * Metodo que remove um produto de um fornecedor a partir do nome e descricao
	 * 
	 * @param nome           nome do produto
	 * @param descricao      descricao do produto
	 * @param nomeFornecedor nome do fornecedor do produto
	 */
	public void removeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		u.verificadorRemocaoProd(nomeProduto, descricao);
		this.fc.removeProduto(nomeProduto, descricao, nomeFornecedor);
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ CONTAS / COMPRAS

	/**
	 * Metodo que adiciona uma compra de um cliente
	 * 
	 * @param cpf            cpf do cliente
	 * @param nomeFornecedor nome do fornecedor
	 * @param data           data da compra
	 * @param nomeProd       nome do produto comprado
	 * @param descrProd      descricao do produto comprado
	 * @return String com o id da conta do cliente
	 */
	public String adicionaCompra(String cpf, String nomeFornecedor, String data, String nomeProd, String descrProd) {
		verificadorAdicionaCompra(cpf, nomeFornecedor, data, nomeProd, descrProd);
		String produto = nomeProd + " - " + descrProd;
		return this.cc.adicionaCompra(cpf, nomeFornecedor, data, this.fc.getProdutos(nomeFornecedor).get(produto));
	}

	/**
	 * Metodo que pega o debito da conta
	 * 
	 * @param cpf            cpf do cliente
	 * @param nomeFornecedor nome do fornecedor
	 * @return String com o preco da divida
	 */
	public String getDebito(String cpf, String nomeFornecedor) {
		u.verificaGetDebito(cpf, nomeFornecedor, this.fc.getFornecedores());
		return this.cc.getDebito(cpf, nomeFornecedor);
	}

	/**
	 * Metodo que exibe uma determinada conta
	 * 
	 * @param cpf            cpf do cliente
	 * @param nomeFornecedor nome do fornecedor
	 * @return Strinf com a conta especificada
	 */
	public String exibeContas(String cpf, String nomeFornecedor) {
		u.verificadorExibeContas(cpf, nomeFornecedor, this.fc.getFornecedores());
		return this.cc.exibeContas(cpf, nomeFornecedor);
	}

	/**
	 * Metodo que exibe todas as contas de um cliente
	 * 
	 * @param cpf cpf do cliente
	 * @return String com todas as contas do cliente
	 */
	public String exibeContasCliente(String cpf) {
		u.verifcadorCPF(cpf, "Erro ao exibir contas do cliente: cpf invalido.");
		return this.cc.exibeContasCliente(cpf);
	}

	/**
	 * Metodo que realiza o pagamento de determinada conta
	 * 
	 * @param cpf            cpf do cliente
	 * @param nomeFornecedor nome do fornecedor
	 */
	public void realizaPagamento(String cpf, String nomeFornecedor) {
		u.verificadorRealizaPagamento(cpf, nomeFornecedor, this.fc.getFornecedores());
		this.cc.realizaPagamento(cpf, nomeFornecedor);
	}

	/**
	 * Metodo que verifica se pode adicionar uma compra
	 *
	 * OBS: Esse metodo estava na classe verificador, mas estava bugando o código,
	 * nao identifiquei o motivo, mas nao tive tempo de ajeitar.
	 * 
	 * 
	 * @param cpf            cpf do cliente
	 * @param nomeFornecedor nome do fornecedor
	 * @param data           data da compra
	 * @param nomeProd       nome do produto
	 * @param descrProd      descricao do produto
	 */
	private void verificadorAdicionaCompra(String cpf, String nomeFornecedor, String data, String nomeProd, String descrProd) {
		String id = nomeProd + " - " + descrProd;
		u.verifcadorCPF(cpf, "Erro ao cadastrar compra: cpf invalido.");
		u.verificadorParametro(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		u.verificadorParametro(nomeProd, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		u.verificadorParametro(descrProd, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		u.verificadorParametro(nomeFornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		u.verificadorNaoExiste(nomeFornecedor, "Erro ao cadastrar compra: fornecedor nao existe.", this.fc.getFornecedores());
		u.verificadorNaoExiste(cpf, "Erro ao cadastrar compra: cliente nao existe.", this.cc.getClientes());
		u.verificadorNaoExiste(id, "Erro ao cadastrar compra: produto nao existe.",this.fc.getProdutos(nomeFornecedor));
		if (data.length() != 10)
			throw new Error("Erro ao cadastrar compra: data invalida.");
	}

}
