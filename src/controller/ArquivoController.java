package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

@Named
@ViewScoped
public class ArquivoController implements Serializable {

	private static final long serialVersionUID = -5327718259663670232L;

	private Part uploadedFile;
	private String folder = "C:\\Upload";

	public void salvar() {

		try (InputStream input = uploadedFile.getInputStream()) {
			String fileName = uploadedFile.getSubmittedFileName();
			Files.copy(input, new File(folder, fileName).toPath());

			System.out.println("Tipo do arquivo: " + getUploadedFile().getContentType());
			System.out.println("Nome do arquivo: " + getUploadedFile().getName());
			System.out.println("Nome original do arquivo: " + getUploadedFile().getSubmittedFileName());
			System.out.println("Tamanho em bytes: " + getUploadedFile().getSize() + " bytes");
			System.out.println("Caminho do arquivo: " + folder + "\\" + getUploadedFile().getSubmittedFileName());

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro ao salvar arquivo.");
		}
	}

	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

}
