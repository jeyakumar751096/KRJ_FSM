package com.fms.springbatch.excel.mapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.support.rowset.RowSet;

import com.fms.entity.OutReachEventInformation;


public class RowMapperImpl implements RowMapper<OutReachEventInformation> {
	@Override
	public OutReachEventInformation mapRow(RowSet rs) throws Exception {
		if(rs == null && rs.getCurrentRow() == null)
		{
			return null;
		}
		// Excel record mapped into pojo.
		OutReachEventInformation orei=new OutReachEventInformation();
		System.out.println(" Read Column 0 is : "+rs.getColumnValue(0));	
		//System.out.println(" Read after Column 0 is : "+Math.round(Integer.parseInt(rs.getColumnValue(0))));
		//e.setId(Math.round(Integer.parseInt(rs.getColumnValue(0)))); // Emp Id in xlsx colunm name
		
		//:OutReachEventInformId,:EventID,:BaseLocation,:BeneficiaryName,:CouncilName,:EventName,
	//	:EventDescription,:EventDate,
		//:EmployeeID,:EmployeeName,:VolunteerHours,:TravelHours,:LivesImpacted,:BusinessUnit,:Status,:IIEPCategory);
		orei.setEventID(rs.getColumnValue(0));
		orei.setBaseLocation(rs.getColumnValue(1));
		orei.setBeneficiaryName(rs.getColumnValue(2));
		orei.setCouncilName(rs.getColumnValue(3));
		orei.setEventName(rs.getColumnValue(4));
		orei.setEventDescription(rs.getColumnValue(5));
		//orei.setEventDate(Date.parse(rs.getColumnValue(6)));
		DateFormat df = new SimpleDateFormat("dd-MM-yy");
		Date eventDate = df.parse(rs.getColumnValue(6));
		orei.setEventDate(eventDate);
		orei.setEmployeeID(rs.getColumnValue(7));
		orei.setEmployeeName(rs.getColumnValue(8));
		orei.setVolunteerHours(Double.parseDouble(rs.getColumnValue(9)));
		orei.setTravelHours(Double.parseDouble(rs.getColumnValue(10)));
		//orei.setTravelHours(Integer.valueOf(rs.getColumnValue(11)));
		orei.setLivesImpacted(Double.parseDouble(rs.getColumnValue(11)));
		orei.setBusinessUnit(rs.getColumnValue(12));
		orei.setStatus(rs.getColumnValue(13));
		orei.setIiepCategory(rs.getColumnValue(14));
		return orei;
	} 

}
