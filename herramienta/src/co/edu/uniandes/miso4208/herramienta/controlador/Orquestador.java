package co.edu.uniandes.miso4208.herramienta.controlador;

import co.edu.uniandes.miso4208.herramienta.repositorio.Prueba;
import co.edu.uniandes.testrunner.commandrunner.CommandRunner;

public class Orquestador {
	
	private static final String ANDROID_SDK = "C:\\Users\\jdcbc\\AppData\\Local\\Android\\Sdk\\platform-tools";

	public static void ejecutarPrueba(Prueba prueba){
		CommandRunner runner = CommandRunner.getRunner();
		String comando = ANDROID_SDK+">"+prueba.getComando();
		System.out.println(comando);
		
		runner.runCommand(comando);
	}

}
