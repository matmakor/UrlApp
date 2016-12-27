package urlApp.logic.urlShorteningAlgorithms;

import org.springframework.stereotype.Component;

@Component
public class HashCodeBasedAlgorithm implements IShorteningAlgorithm{
	
	@Override
	public String shortenUrl(String urlToShorten) {
		
		return new Integer(urlToShorten.hashCode()).toString();		
	}
}