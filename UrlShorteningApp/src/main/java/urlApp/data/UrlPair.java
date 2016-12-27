package urlApp.data;

public class UrlPair {

	private Long id;
	private String longUrl;
	private String shortUrl;
	
	public UrlPair(String longUrl, String shortUrl) {
		this.longUrl = longUrl;
		this.shortUrl = shortUrl;
	}
	
	public UrlPair(){
		
	}
	
	public UrlPair(Long id, String longUrl, String shortUrl) {
		this.id = id;
		this.longUrl = longUrl;
		this.shortUrl = shortUrl;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLongUrl() {
		return longUrl;
	}
	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
}