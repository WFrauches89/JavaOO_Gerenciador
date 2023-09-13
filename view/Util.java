package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import data.BancoDeDados;
import model.Estudante;

public abstract class Util {
	private Util() {
	}

	static Scanner sc = new Scanner(System.in);

	/**
	 * Retorna uma String válida (diferente de null, de espaços em branco e de
	 * vazio)
	 */
	public static String entrada_S() {
		String value = null;
		Boolean passou = false;

		while (!passou) {
			if (sc.hasNext()) {
				value = sc.nextLine();
				if (value != null && !value.isBlank() && !value.isEmpty()) {
					passou = true;
				}
			}
		}
		return value;
	}

	/**
	 * Retorna true se o valor informado (String) é um número inteiro válido
	 */
	public static Boolean isInteger(String num, Integer min, Integer max) {
		try {
			if (num.matches("[0-9]*$") && (Integer.parseInt(num) >= min && Integer.parseInt(num) <= max)) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	/**
	 * Retorna true se o valor informado (String) é um texto válido
	 */
	public static Boolean isString(String texto) {
		if (texto != null && !texto.trim().equals("")) {
			return true;
		}
		return false;
	}

	public static String listaEstudantes_S(BancoDeDados db, String arguments, List<Estudante> estudantes) {
		Integer cont = 1;
		String listaEstudantes = "";

		for (Estudante e : estudantes) {
			listaEstudantes += cont + ". " + e.getNome() + " - " + e.getCurso() + "\n";
			cont++;
		}
		return listaEstudantes;
	}

	public static List<Estudante> listaEstudantes_L(BancoDeDados db, String arguments) {
		List<Estudante> estudantes = new ArrayList<>();
		return estudantes = db.query(Estudante.TABLE_NAME, arguments, "ORDER BY " + Estudante.COLUM_NOME + " ASC");
	}

	/**
	 * Retorna um valor Double válido
	 */
//	public static Double entrada_D() {
//		Double value = null;
//		Boolean passou = false;
//
//		while (!passou) {
//
//			if (sc.hasNext()) {
//				if (sc.hasNextDouble()) {
//					try {
//						value = sc.nextDouble();
//						passou = true;
//					} catch (Exception e) {
//						// TODO: handle exception
//					}
//				}
//			}
//		}
//		return value;
//	}

	/**
	 * Retorna um valor Integer válido
	 */
//	public static Integer entrada_I() {
//		Integer value = null;
//		Boolean passou = false;
//
//		while (!passou) {
//			try {
//				if (sc.hasNext()) {
//					if (sc.hasNextInt()) {
//						value = sc.nextInt();
//						passou = true;
//					}
//				}
//			} catch (Exception e) {
//				return -1;
//			}
//		}
//		return value;
//	}
}