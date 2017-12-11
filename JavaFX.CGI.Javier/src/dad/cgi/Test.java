package dad.cgi;

import java.io.File;

import dad.cgi.model.Comando;
import dad.cgi.model.Historial;
import dad.cgi.model.Interprete;

public class Test {

	public static void main(String[] args) throws Exception {

		/*
		 * Crea el comando 'netstat' con varios parámetros y lo ejecuta en el Símbolo del Sistema (cmd)
		 */

		Comando dir = new Comando();
		dir.setDescripcion("Listar el contenido de la raíz de la unidad C:");
		dir.asString().addListener((o, ov, nv) -> {
			System.out.println("Cambio detectado en el comando: " + nv);
		});
		
		dir.setInterprete(Interprete.SIMBOLO_SISTEMA);
		dir.setOrden("dir");
		dir.getParametros().add("c:\\");
		dir.ejecutar();
		
		System.out.println("Comando: " + dir);
		System.out.println("Salida:  " + dir.getSalida());
		System.out.println("Error:   " + dir.getError());
		System.out.println("Retorno: " + dir.getValorRetorno());
		
		System.out.println("============================================================");

		/*
		 * Crea el comando 'netstat' con varios parámetros y lo ejecuta en el Símbolo del Sistema (cmd)
		 */

		Comando netstat = new Comando();
		netstat.setDescripcion("Muestra los puertos abiertos");
		netstat.setInterprete(Interprete.SIMBOLO_SISTEMA);
		netstat.setOrden("netstat");
		netstat.getParametros().add("-a");
		netstat.getParametros().add("-n");
		netstat.getParametros().add("-o");
		netstat.getParametros().add("-p tcp");
		netstat.ejecutar();
		System.out.println("Comando: " + netstat);
		System.out.println("Salida:  " + netstat.getSalida());
		System.out.println("Error:   " + netstat.getError());
		System.out.println("Retorno: " + netstat.getValorRetorno());

		System.out.println("============================================================");

		/*
		 * Crea el comando 'Get-Process -Id 0' y lo ejecuta en PowerShell
		 */
		
		Comando gp = new Comando();
		gp.setDescripcion("Muestra información sobre el proceso con PID 0");
		gp.setInterprete(Interprete.POWERSHELL);
		gp.setOrden("Get-Process");
		gp.getParametros().add("-Id 0");
		gp.ejecutar();
		System.out.println("Comando: " + gp);
		System.out.println("Salida:  " + gp.getSalida());
		System.out.println("Error:   " + gp.getError());
		System.out.println("Retorno: " + gp.getValorRetorno());

		System.out.println("============================================================");
		
		/*
		 * Crea un historial nuevo, le añade los 3 comandos anteriores y lo guarda
		 */

		Historial historial = new Historial();
		historial.getComandos().add(dir);
		historial.getComandos().add(netstat);
		historial.getComandos().add(gp);
		historial.save(new File("test.history"));
		System.out.println("Historial guardado");
		
		/*
		 * Lee el historial desde fichero
		 */
		historial = Historial.load(new File("test.history"));
		System.out.println("Historial cargado");
		
	}

}
