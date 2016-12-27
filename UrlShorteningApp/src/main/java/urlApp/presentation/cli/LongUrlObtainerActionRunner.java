package urlApp.presentation.cli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import urlApp.logic.actions.ILongUrlObtainer;
import urlApp.logic.urlExceptions.UrlNotFoundException;

@Component
public class LongUrlObtainerActionRunner implements CommandLineRunner {

	@Autowired
	private ICliParser parser;
	@Autowired
	private ILongUrlObtainer longUrlObtainer;

	@Override
	public void run(String... args){

	    	if(isLongUrlObtainer(parser)){
	    		
	    		String shortUrlToBeResolved = parser.getOptionValue(CliOptions.LONG_URL_OBTAINER_OPTION_NAME);
	    		
				try {
		    	
					String longResolvedUrl = longUrlObtainer.getLongUrl(shortUrlToBeResolved);
		    		System.out.println(longResolvedUrl);	

				} catch (UrlNotFoundException e) {
					System.err.println(e.getMessage());
				}

	    	}
	    		
	}

	private boolean isLongUrlObtainer(ICliParser line) {
		if (line.hasOption(CliOptions.LONG_URL_OBTAINER_OPTION_NAME)) {
			return true;
		}
		return false;
	}
}