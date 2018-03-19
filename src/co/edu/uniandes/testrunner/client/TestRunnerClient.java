package co.edu.uniandes.testrunner.client;

import co.edu.uniandes.testrunner.commandrunner.CommandRunner;

public class TestRunnerClient {

	public static void main(String[] args) {
		CommandRunner runner = CommandRunner.getRunner();
		runner.runCommand(
				"lighthouse --output json --chrome-flags=\"--headless\" --output-path=./lighthouse-results.json http://www.google.com");
	}

}
