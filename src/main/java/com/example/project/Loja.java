package com.example.project;

public class Loja {

    private static final String ENDLN = System.lineSeparator();
	private static boolean isEmpty(String str){
		if(str == null) return true;
		int spaceCount = str.length() - str.replace(".", "").length();
        return (spaceCount == str.length());
    }

    private String nomeLoja;
    private Endereco endereco;
    private String telefone;
    private String observacao;
    private String cnpj;
    private String inscricaoEstadual;

    public Loja(String nomeLoja, Endereco endereco, String telefone,
                String observacao, String cnpj, String inscricaoEstadual) {
        this.nomeLoja = nomeLoja;
        this.endereco = endereco;
        this.telefone = telefone;
        this.observacao = observacao;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNomeLoja() {
        return this.nomeLoja;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public String getInscricaoEstadual() {
        return this.inscricaoEstadual;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String dadosLoja() {
		if (isEmpty(this.getNomeLoja())){
            throw new RuntimeException("O campo nome da loja é obrigatório");
        }

		if(isEmpty(this.getEndereco().getLogradouro())){
			throw new RuntimeException("O campo logradouro do endereço é obrigatório");
		}

		String numero1 = this.getEndereco().getNumero() + "";
		if(this.getEndereco().getNumero() == 0){
			numero1 = "s/n";
		}

		if(isEmpty(this.getEndereco().getMunicipio())){
			throw new RuntimeException("O campo município do endereço é obrigatório");
		}
		
		if(isEmpty(this.getEndereco().getEstado())){
			throw new RuntimeException("O campo estado do endereço é obrigatório");
		}

		if(isEmpty(this.getCnpj())){
			throw new RuntimeException("O campo cnpj da loja é obrigatório");
		}

		if(isEmpty(this.getInscricaoEstadual())){
			throw new RuntimeException("O campo inscrição estadual da loja é obrigatório");
		}

		String linha2 = this.getEndereco().getLogradouro() + ", " + numero1;
		if (! isEmpty(this.getEndereco().getComplemento())){
			linha2 += " " + this.getEndereco().getComplemento();
		}
		
		String linha3 = "";
		if (! isEmpty(this.getEndereco().getBairro())){
		  linha3 += this.getEndereco().getBairro() + " - ";
		}
		linha3 += this.getEndereco().getMunicipio() + " - " + this.getEndereco().getEstado();
	  
		String linha4 = "";
		if (! isEmpty(this.getEndereco().getCep())){
		  linha4 = "CEP:" + this.getEndereco().getCep();
		}
		if (! isEmpty(this.getTelefone())){
		  if (! isEmpty(linha4)){
			linha4 += " ";
		  }
		  linha4 += "Tel " + this.getTelefone();
		}
		if (! isEmpty(linha4)){
		  linha4 += ENDLN;
		}
	  
		String linha5 = "";
		if (! isEmpty(this.getObservacao())){
		  linha5 += this.getObservacao();
		}
	  
		String output = this.getNomeLoja() + ENDLN;
		output += linha2 + ENDLN;
		output += linha3 + ENDLN;
		output += linha4;
		output += linha5 + ENDLN;
		output += "CNPJ: " + this.getCnpj() + ENDLN;
		output += "IE: " + this.getInscricaoEstadual() + ENDLN;
	  
		return output;
	}

}