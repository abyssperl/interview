package rowmappers;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import org.springframework.jdbc.core.RowMapper;

import models.Step;

public class StepMapper implements RowMapper<Step> {

	@Override
	public Step mapRow(ResultSet rs, int rowNum) throws SQLException {
		Blob b = null;
		Time t = null;
    	Step s = new Step(rs.getInt("id"));
    	t = rs.getTime("cooktime");
        s.setTime(t.getMinutes());
        s.setOrder(rs.getInt("step_ordinal"));
        b = rs.getBlob("instructions");
        s.setInstructionStep(b.toString());
    	return s;
	}

}
