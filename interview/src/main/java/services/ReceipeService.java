package services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import models.Receipe;
import models.Step;
import rowmappers.ReceipeMapper;
import rowmappers.StepMapper;

@Service
public class ReceipeService {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate template;
	
	public List<Receipe> listAllReceipes() throws SQLException {
		String query = "SELECT id, receipeName, servingSize, region, entreetype FROM receipes";
		List<Receipe> listOfReceipes = jdbcTemplate.query(query, new Object[] {},
				new ReceipeMapper());
		   
		return listOfReceipes;
	}
	
	public Receipe getFullReceipe(Receipe r) throws SQLException {
		String query = "SELECT id, step_ordinal, cooktime, instructions FROM steps WHERE receipeId = ? ORDER BY step_ordinal DESC";
		List<Step> steps = jdbcTemplate.query(query, new Object[] {},
				new StepMapper());
		r.setInstructionSteps(steps);
		return r;
		
	}
	
	public List<Receipe> searchForReceipe(String name) throws SQLException {
		String query = "SELECT id, receipeName, servingSize, region, entreetype FROM receipes WHERE receipeName like :name";
		Map<String, Object> searchTerms = new HashMap<>();
		searchTerms.put("name", "%" + name + "%");
		List<Receipe> listOfReceipes = template.query(query, searchTerms,
				new ReceipeMapper());
		   
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
