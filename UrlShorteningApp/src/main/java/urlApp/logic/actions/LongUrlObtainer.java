package urlApp.logic.actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import urlApp.logic.urlExceptions.UrlNotFoundException;
import urlApp.data.UrlPair;
import urlApp.data.UrlRepository;

@Component
public class LongUrlObtainer implements ILongUrlObtainer{

	@Autowired
	private UrlRepository urlRepo;

	public String getLongUrl(String shortUrlToBeResolved) throws UrlNotFoundException {

		List<UrlPair> foundUrlPair = urlRepo.findLongUrlUsingShort(shortUrlToBeResolved);

		if (foundUrlPair.isEmpty())
			throw new UrlNotFoundException("Cannot find '" + shortUrlToBeResolved + "' in database!");

		String resolvedLongUrl = foundUrlPair.get(0).getLongUrl();

		return resolvedLongUrl;
	}
}