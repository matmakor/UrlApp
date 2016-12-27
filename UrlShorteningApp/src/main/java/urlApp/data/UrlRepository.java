package urlApp.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UrlRepository {
	
	@Autowired
	private JdbcTemplate jdbcOperations;

	private String SELECT_SHORT_URL = "select * from urlPairs where shortUrl = ?";
	private String SELECT_LONG_URL = "select * from urlPairs where longUrl = ?";
	
	private String INSERT_URL = "insert into urlPairs (longUrl, shortUrl) values (?,?)";	
	private String UPDATE_URL = "update urlPairs SET longUrl=?, shortUrl=? WHERE id=?";	
	
	public UrlRepository(JdbcTemplate jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}
	
	public List<UrlPair> findShortUrlUsingLong(String longUrl){
		return jdbcOperations.query(
		SELECT_LONG_URL,
		new RowMapper<UrlPair>() {
		public UrlPair mapRow(ResultSet rs, int rowNum)
		throws SQLException {
		UrlPair urlPair = new UrlPair();
		urlPair.setId(rs.getLong(1));
		urlPair.setLongUrl(rs.getString(2));
		urlPair.setShortUrl(rs.getString(3));
		return urlPair;
		}
		},longUrl);
		}		
	
	public List<UrlPair> findLongUrlUsingShort(String shortUrl){
		return jdbcOperations.query(
		SELECT_SHORT_URL,
		new RowMapper<UrlPair>() {
		public UrlPair mapRow(ResultSet rs, int rowNum)
		throws SQLException {
		UrlPair urlPair = new UrlPair();
		urlPair.setId(rs.getLong(1));
		urlPair.setLongUrl(rs.getString(2));
		urlPair.setShortUrl(rs.getString(3));
		return urlPair;
		}
		},shortUrl);
	}

	public List<UrlPair> findShortUrl(String shortUrl){
		return jdbcOperations.query(
		SELECT_SHORT_URL,
		new RowMapper<UrlPair>() {
		public UrlPair mapRow(ResultSet rs, int rowNum)
		throws SQLException {
		UrlPair urlPair = new UrlPair();
		urlPair.setId(rs.getLong(1));
		urlPair.setLongUrl(rs.getString(2));
		urlPair.setShortUrl(rs.getString(3));
		return urlPair;
		}
		},shortUrl);
		}		
	
	public List<UrlPair> findLongUrl(String longUrl){
		return jdbcOperations.query(
		SELECT_LONG_URL,
		new RowMapper<UrlPair>() {
		public UrlPair mapRow(ResultSet rs, int rowNum)
		throws SQLException {
		UrlPair urlPair = new UrlPair();
		urlPair.setId(rs.getLong(1));
		urlPair.setLongUrl(rs.getString(2));
		urlPair.setShortUrl(rs.getString(3));
		return urlPair;
		}
		},longUrl);
		}		

	public void save(UrlPair urlPair){
				jdbcOperations.update(INSERT_URL,urlPair.getLongUrl(),urlPair.getShortUrl());
		}
	
	public void update(UrlPair urlPair){
		jdbcOperations.update(UPDATE_URL,urlPair.getLongUrl(),urlPair.getShortUrl(),urlPair.getId());
}
}