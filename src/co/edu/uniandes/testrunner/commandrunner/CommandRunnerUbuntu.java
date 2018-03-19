package co.edu.uniandes.testrunner.commandrunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import co.edu.uniandes.testrunner.util.ApplicationLogMessages;

/**
 * Implementación específica para Ubuntu 17.10 del {@link CommandRunner}
 * 
 * @author ms.puerto@uniandes.edu.co
 *
 */
public class CommandRunnerUbuntu extends CommandRunner {

	@Override
	public void runCommand(String command) {
		try {
			logger.info(String.format(ApplicationLogMessages.LOG_RUNNING_COMMAND, command));
			process = Runtime.getRuntime().exec(command);
			process.waitFor();
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			logger.info(ApplicationLogMessages.LOG_COMMAND_COMPLETE);
		} catch (IOException | InterruptedException e) {
			logger.error(ApplicationLogMessages.LOG_COMMAND_ERROR, e);
		}
	}

}
