package rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.RowMapper;

import models.EntreeType;
import models.Receipe;
import models.Region;

public class ReceipeMapper implements RowMapper<Receipe> {

	@Override
	public Receipe mapRow(ResultSet rs, int rowNum) throws SQLException {
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
	}
	
	

}
