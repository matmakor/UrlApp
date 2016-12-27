package urlApp.presentation.cli;

import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CliParser extends DefaultParser implements CommandLineRunner, ICliParser{

	@Autowired
	private CliOptions cliOptions;
	@Autowired
	private ICliHelpFormatter cliHelpFormatter;

	@Override
	public void run(String... args) throws Exception {
		
		if(args.length == 0) cliHelpFormatter.printHelp();
		
	    try {
	    stopAtNonOption = false;

	    parse(cliOptions, args);

	    }catch( ParseException exp ) {
	    	cliHelpFormatter.printHelp();
	        System.err.println( "Parsing failed.  Reason: " + exp.getMessage() );
	    }
	}
	
	public String getOptionValue(String arg){
		return cmd.getOptionValue(arg);
	}
	
	public boolean hasOption(String arg){
		return cmd.hasOption(arg);
	}
}