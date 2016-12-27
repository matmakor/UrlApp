package urlApp.presentation.cli;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.springframework.stereotype.Component;

@Component
public class CliOptions extends Options{
		
	private static final long serialVersionUID = 1L;
	
	public static final String SHORT_URL_SETTER_OPTION_NAME = "o";
	public static final String SHORT_URL_OBTAINER_OPTION_NAME = "i";
	public static final String LONG_URL_OBTAINER_OPTION_NAME = "s";
	public static final char PARAM_VALUE_SEPARATOR = ' ';
	
	public CliOptions() {

		Option shortUrlSetterOption = 
				Option.builder(SHORT_URL_SETTER_OPTION_NAME).
				desc("Shorten a given URL to a URL with a specified alias.").
				hasArg(true).
				valueSeparator(PARAM_VALUE_SEPARATOR).
				build();
		
		addOption(shortUrlSetterOption);
		
		Option shortUrlObtainerOption = 
				Option.builder(SHORT_URL_OBTAINER_OPTION_NAME).
				desc("URL to be shortened.").
				hasArg(true).
				valueSeparator(PARAM_VALUE_SEPARATOR).
				build();

		addOption(shortUrlObtainerOption);
		
		Option longUrlObtainerOption = 
				Option.builder(LONG_URL_OBTAINER_OPTION_NAME).
				desc("Resolve short URL to original URL.").
				hasArg(true).
				valueSeparator(PARAM_VALUE_SEPARATOR).
				build();
				
		addOption(longUrlObtainerOption);
	}	
	
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		getOptions().stream().forEach(option -> sb.append(option.getDescription()+"\n"));
		
		return sb.toString();
	}
}