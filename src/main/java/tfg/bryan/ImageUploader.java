package tfg.bryan;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.awt.Image;
import java.io.*;

import javax.imageio.ImageIO;

public class ImageUploader {

	public static void uploadImage(File imageFile, String ip) {
        FTPClient ftp = new FTPClient();
        FileInputStream inputStream = null;

        try {
            String servidorFTP = ip;
            int puertoFTP = 21;
            String usuarioFTP = "angel";
            String contraseñaFTP = "angel";

            ftp.connect(servidorFTP, puertoFTP);
            System.out.println("Conexión al servidor FTP establecida.");

            int reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                System.out.println("El servidor FTP rechazó la conexión.");
                return;
            }

            boolean login = ftp.login(usuarioFTP, contraseñaFTP);
            if (!login) {
                System.out.println("Error al iniciar sesión en el servidor FTP.");
                return;
            }
            System.out.println("Inicio de sesión en el servidor FTP exitoso.");

            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTP.BINARY_FILE_TYPE);

            String nombreArchivo = imageFile.getName();

            // Eliminar el archivo existente si existe
            boolean archivoExiste = ftp.listFiles(nombreArchivo).length > 0;
            if (archivoExiste) {
                boolean deleted = ftp.deleteFile(nombreArchivo);
                if (deleted) {
                    System.out.println("Archivo existente eliminado: " + nombreArchivo);
                } else {
                    System.out.println("Error al eliminar el archivo existente: " + nombreArchivo);
                    int replyCode = ftp.getReplyCode();
                    String replyString = ftp.getReplyString();
                    System.out.println("Código de respuesta del servidor FTP: " + replyCode);
                    System.out.println("Mensaje de respuesta del servidor FTP: " + replyString);
                    return;
                }
            }

            // Subir el nuevo archivo
            inputStream = new FileInputStream(imageFile);
            boolean success = ftp.storeFile(nombreArchivo, inputStream);

            if (success) {
                System.out.println("Archivo subido con éxito: " + nombreArchivo);
            } else {
                System.out.println("Error al subir el archivo: " + nombreArchivo);
                int replyCode = ftp.getReplyCode();
                String replyString = ftp.getReplyString();
                System.out.println("Código de respuesta del servidor FTP: " + replyCode);
                System.out.println("Mensaje de respuesta del servidor FTP: " + replyString);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (ftp.isConnected()) {
                    ftp.logout();
                    ftp.disconnect();
                    System.out.println("Desconectado del servidor FTP.");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

	public static Image downloadImage(String ip, String nombreArchivo) {
		try {
			String servidorFTP = ip;
			int puertoFTP = 21;
			String usuarioFTP = "angel";
			String contraseñaFTP = "angel";
			String rutaRemota = "/";

			FTPClient ftp = new FTPClient();
			ftp.connect(servidorFTP, puertoFTP);
			ftp.login(usuarioFTP, contraseñaFTP);
			ftp.enterLocalPassiveMode();
			ftp.setFileType(FTP.BINARY_FILE_TYPE);

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			boolean descargaExitosa = ftp.retrieveFile(rutaRemota + nombreArchivo, outputStream);
			InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
			Image image = ImageIO.read(inputStream);
			inputStream.close();

			if (descargaExitosa) {
				return image;
			} else {
				System.out.println("Fallo al descargar la imagen.");
			}

			ftp.logout();
			ftp.disconnect();
		} catch (IOException ex) {
			System.out.println("Error al conectar al servidor FTP: " + ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}
}