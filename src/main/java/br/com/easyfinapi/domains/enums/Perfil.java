package br.com.easyfinapi.domains.enums;

public enum Perfil {

	ROLE_ADMIN(1, "ROLE_ADMIN"),
	ROLE_MANAGER(2, "MANAGER"),
	ROLE_STUDENT(3, "ROLE_STUDENT");

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
	

	public static Perfil toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (Perfil x : Perfil.values()) {
			if (cod.equals(x.getCodPerfil())) {
				return x;
			}
		}
		return null;
	}

}