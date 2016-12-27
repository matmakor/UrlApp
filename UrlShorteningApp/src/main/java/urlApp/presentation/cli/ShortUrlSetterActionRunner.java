package urlApp.presentation.cli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import urlApp.logic.actions.IShortUrlSetter;

@Component
public class ShortUrlSetterActionRunner implements CommandLineRunner{

	@Autowired
	private ICliParser parser;
	@Autowired
	private IShortUrlSetter shortUrlSetter;

	@Override
	public void run(String... args){

	    	if(isShortUrlSetterChosen(parser)){
	    		
	    		String longUrlToBeConverted = parser.getOptionValue(CliOptions.SHORT_URL_OBTAINER_OPTION_NAME);
	    		String shortUrlToConvertTo = parser.getOptionValue(CliOptions.SHORT_URL_SETTER_OPTION_NAME);
	    		
	    		try{
	    			String setShortUrl = shortUrlSetter.setShortUrl(longUrlToBeConverted,shortUrlToConvertTo);
	    			System.out.println(setShortUrl);
	    		}catch(IllegalArgumentException e){
	    			System.err.println(e.getMessage());
	    		}
	    	}
	}
	
	private boolean isShortUrlSetterChosen(ICliParser line){
        if(line.hasOption(CliOptions.SHORT_URL_OBTAINER_OPTION_NAME)){
        	return true;
        }
        return false;
	}
}