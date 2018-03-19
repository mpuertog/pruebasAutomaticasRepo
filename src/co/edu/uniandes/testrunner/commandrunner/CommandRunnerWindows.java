package co.edu.uniandes.testrunner.commandrunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import co.edu.uniandes.testrunner.util.ApplicationConstants;
import co.edu.uniandes.testrunner.util.ApplicationLogMessages;

/**
 * Implementación específica del {@link CommandRunner} para Windows
 * @author ms.puerto@uniandes.edu.co
 *
 */
public class CommandRunnerWindows extends CommandRunner {

	@Override
	public void runCommand(String command) {
		String s = null;
		try {
			logger.info(String.format(ApplicationLogMessages.LOG_RUNNING_COMMAND, command));
			process = Runtime.getRuntime().exec(ApplicationConstants.POWER_SHELL + command);
			process.waitFor();
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while ((s = reader.readLine()) != null) {
				logger.info(s);
			}
			logger.info(ApplicationLogMessages.LOG_COMMAND_COMPLETE);
		} catch (IOException | InterruptedException e) {
			logger.error(ApplicationLogMessages.LOG_COMMAND_ERROR, e);
		}

	}

}
