package co.edu.uniandes.testrunner.commandrunner;

import java.io.BufferedReader;

import org.apache.log4j.Logger;

import co.edu.uniandes.testrunner.util.ApplicationConstants;

/**
 * Clase abstracta que determina el {@link CommandRunner} a utilizar,
 * dependiendo del sistema operativo host. Actualmente solo se soporta Ubuntu
 * 17.10 y Windows 7 o superior
 * 
 * @author ms.puerto@uniandes.edu.co
 *
 */
public abstract class CommandRunner {

	protected Process process;
	protected BufferedReader reader;
	protected final static Logger logger = Logger.getLogger(CommandRunner.class);

	/**
	 * Detecta de forma automática el sistema operativo y selecciona el runner
	 * correspondiente
	 * 
	 * @return {@link CommandRunner} específico según el OS host
	 */
	public static CommandRunner getRunner() {
		return System.getProperty(ApplicationConstants.OS_NAME_PROPERTY).contains(ApplicationConstants.OS_LINUX)
				? new CommandRunnerUbuntu()
				: new CommandRunnerWindows();
	}

	/**
	 * Método abstracto a ser implementado por cada {@link CommandRunner} específico
	 * 
	 * @param command
	 *            Comando a ser enviado al OS
	 */
	public abstract void runCommand(String command);

}
