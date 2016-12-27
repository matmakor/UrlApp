package urlApp.logic.actions;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import urlApp.data.UrlPair;
import urlApp.data.UrlRepository;
import urlApp.logic.urlShorteningAlgorithms.IShorteningAlgorithm;

@Component
public class ShortUrlSetter implements IShortUrlSetter{

	@Autowired
	private UrlRepository urlRepo;
	@Autowired
	private IShorteningAlgorithm shorteningAlgorithm;
	
	public String setShortUrl(String longUrlToBeConverted, String shortUrlToConvertTo) throws IllegalArgumentException{
		
		if(shortUrlToConvertTo == null) shortUrlToConvertTo = shorteningAlgorithm.shortenUrl(longUrlToBeConverted);
		
		validateInputUrl(shortUrlToConvertTo);
		shortUrlToConvertTo = IShorteningAlgorithm.BASE_URL+IShorteningAlgorithm.URL_SEPARATOR+shortUrlToConvertTo;
		
		List<UrlPair> foundUrlPair = urlRepo.findShortUrl(shortUrlToConvertTo);

		if(!foundUrlPair.isEmpty()) throw new IllegalArgumentException("Error: Short URL already in use!");
		
		List<UrlPair> existingUrlPair = urlRepo.findLongUrl(longUrlToBeConverted);
		if(existingUrlPair.isEmpty())
			urlRepo.save(new UrlPair(longUrlToBeConverted,shortUrlToConvertTo));
		else{
			Long existingUrlId = existingUrlPair.get(0).getId();
			urlRepo.update(new UrlPair(existingUrlId,longUrlToBeConverted,shortUrlToConvertTo));
		}
		
		return shortUrlToConvertTo;
	}
	
	public void validateInputUrl(String inputUrl) throws IllegalArgumentException{
		
		if(!StringUtils.isAlphanumeric(inputUrl)) throw new IllegalArgumentException("Input url must be alphanumeric!");
	}
}