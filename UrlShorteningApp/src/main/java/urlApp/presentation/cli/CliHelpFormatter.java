package urlApp.presentation.cli;

import org.apache.commons.cli.HelpFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CliHelpFormatter extends HelpFormatter implements ICliHelpFormatter{

	@Autowired
	CliOptions cliOptions;
	
	public void printHelp(){
	    printHelp("Url shortener","Help:",cliOptions,"", true);
	}	
}