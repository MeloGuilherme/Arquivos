package model;

import javax.servlet.http.Part;

public class Arquivo {

	private Integer id;

	private String nome;

	private Part arq_byte;

	public Arquivo() {

		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Part getArq_byte() {
		return arq_byte;
	}

	public void setArq_byte(Part arq_byte) {
		this.arq_byte = arq_byte;
	}

}