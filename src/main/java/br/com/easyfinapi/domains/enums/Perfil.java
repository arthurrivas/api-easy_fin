package br.com.easyfinapi.domains.enums;

public enum Perfil {
	
	ADMIN(1,"ROLE_ADMIM"),
	PROFESSOR(2,"ROLE_PROFESSOR"),
	ALUNO(3,"ROLE_ALUNO");
	
	
	private Integer codPerfil;
	private String descricaoPerfil;
	
	Perfil(Integer i, String descricao) {
		this.codPerfil = i;
		this.descricaoPerfil = descricao;
	}

	public Integer getCodPerfil() {
		return codPerfil;
	}

	public void setCodPerfil(Integer codPerfil) {
		this.codPerfil = codPerfil;
	}

	public String getDescricaoPerfil() {
		return descricaoPerfil;
	}

	public void setDescricaoPerfil(String descricaoPerfil) {
		this.descricaoPerfil = descricaoPerfil;
	}
	
	
	
	
}
