package services;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import models.EntreeType;
import models.Receipe;
import models.Region;
import models.Step;

@Service
public class ReceipeService {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate template;
	
	public List<Receipe> listAllReceipes() throws SQLException {
		String query = "SELECT id, receipeName, servingSize, region, entreetype FROM receipes";
		List<Receipe> listOfReceipes = jdbcTemplate.query(query, new Object[] {},
				new RowMapper<Receipe>() {
		    public Receipe mapRow(ResultSet rs, int RowNum) throws SQLException {
		    	String tmp = null;
		    	Receipe r = new Receipe(rs.getInt("id"));
		    	r.setReceipeName(rs.getString("receipeName"));
		    	r.setServingSize(rs.getInt("servingSize"));
		    	tmp = rs.getString("region");
		    	if (StringUtils.isBlank(tmp)) {
		    		r.setRegion(null);
		    	} else {
			    	r.setRegion(Region.valueOf(rs.getString("region")));
		    	}
		    	tmp = rs.getString("entreetype");
		    	if (StringUtils.isBlank(tmp)) {
		    		r.setEntreeList(null);
		    	} else {
			    	r.setEntreeList(EntreeType.valueOf(rs.getString("entreetype")));
		    	}
		    	return r;
		    }});
		   
		return listOfReceipes;
	}
	
	public Receipe getFullReceipe(Receipe r) throws SQLException {
		String query = "SELECT id, step_ordinal, cooktime, instructions FROM steps WHERE receipeId = ? ORDER BY step_ordinal DESC";
		List<Step> steps = jdbcTemplate.query(query, new Object[] {},
				new RowMapper<Step>() {
		    public Step mapRow(ResultSet rs, int RowNum) throws SQLException {
				Blob b = null;
				Time t = null;
		    	Step s = new Step(rs.getInt("id"));
		    	t = rs.getTime("cooktime");
		        s.setTime(t.getMinutes());
                s.setOrder(rs.getInt("step_ordinal"));
                b = rs.getBlob("instructions");
                s.setInstructionStep(b.toString());
		    	return s;
		    }});
		r.setInstructionSteps(steps);
		return r;
		
	}
	
	public List<Receipe> searchForReceipe(String name) throws SQLException {
		String query = "SELECT id, receipeName, servingSize, region, entreetype FROM receipes WHERE receipeName like :name";
		Map<String, Object> searchTerms = new HashMap<>();
		searchTerms.put("name", "%" + name + "%");
		List<Receipe> listOfReceipes = template.query(query, searchTerms,
				new RowMapper<Receipe>() {
		    public Receipe mapRow(ResultSet rs, int RowNum) throws SQLException {
		    	String tmp = null;
		    	Receipe r = new Receipe(rs.getInt("id"));
		    	r.setReceipeName(rs.getString("receipeName"));
		    	r.setServingSize(rs.getInt("servingSize"));
		    	tmp = rs.getString("region");
		    	if (StringUtils.isBlank(tmp)) {
		    		r.setRegion(null);
		    	} else {
			    	r.setRegion(Region.valueOf(rs.getString("region")));
		    	}
		    	tmp = rs.getString("entreetype");
		    	if (StringUtils.isBlank(tmp)) {
		    		r.setEntreeList(null);
		    	} else {
			    	r.setEntreeList(EntreeType.valueOf(rs.getString("entreetype")));
		    	}
		    	return r;
		    }});
		   
		return listOfReceipes;
	}
	
	public void updateReceipe(Receipe r) {
//		List<Conversation> actors = jdbcTemplate.query(
//			    SELECT_ALL_CONVERSATIONS_SQL_FULL,
//			    new Object[] {userId, dateFrom, dateTo},
//			    new RowMapper<Conversation>() {
//			        public Conversation mapRow(ResultSet rs, int rowNum) throws SQLException {
//			            Conversation c = new Conversation();
//			            c.setId(rs.getLong(1));
//			            c.setRoom(rs.getString(2));
//			            return c;
//			        }
//			    });
		
	}
	
	public void deleteReceipe(int id) {
		
	}

}
