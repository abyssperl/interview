package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import models.Step;

@Service
public class StepService {

	@Autowired
	JdbcTemplate jdbcTemplate;	
	
	public void updateStep(Step s) {
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
	
	public void deleteStep(int id) {
		
	}

}
