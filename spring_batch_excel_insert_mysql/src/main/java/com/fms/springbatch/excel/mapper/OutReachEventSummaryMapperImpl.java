package com.fms.springbatch.excel.mapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.support.rowset.RowSet;

import com.fms.entity.OutreachEventsSummary;

public class OutReachEventSummaryMapperImpl implements RowMapper<OutreachEventsSummary> {
	@Override
	public OutreachEventsSummary mapRow(RowSet rs) throws Exception {
		if(rs == null && rs.getCurrentRow() == null)
		{
			return null;
		}
		OutreachEventsSummary ores = new OutreachEventsSummary();
		System.out.println(" Read Column 0 is : "+rs.getColumnValue(0));
		//Event ID	Month	Base Location	Beneficiary Name	Venue Address	Council Name
		//Project	Category	
		//Event Name	Event Description	Event Date (DD-MM-YY)	Total no. of volunteers	Total Volunteer Hours	
		//Total Travel Hours	Overall Volunteering Hours	Lives Impacted	Activity Type	Status	
		//POC ID	POC Name	POC Contact Number

		ores.setEventID(rs.getColumnValue(0));
		ores.setMonths(rs.getColumnValue(1));
		ores.setBaseLocation(rs.getColumnValue(2));
		ores.setBeneficiaryName(rs.getColumnValue(3));
		ores.setVenueAddress(rs.getColumnValue(4));
		ores.setCouncilName(rs.getColumnValue(5));
		ores.setProject(rs.getColumnValue(6));
		ores.setCategory(rs.getColumnValue(7));
		ores.setEventName(rs.getColumnValue(8));
		ores.setEventDescription(rs.getColumnValue(9));
		//ores.setEventDate(rs.getColumnValue(8));
		DateFormat df = new SimpleDateFormat("dd-MM-yy");
		Date eventDates = df.parse(rs.getColumnValue(10));
		ores.setEventDate(eventDates);
		ores.setTotalNoOfVolunteers(Double.parseDouble(rs.getColumnValue(11)));
		ores.setTotalVolunteerHours(Double.parseDouble(rs.getColumnValue(12)));
		ores.setTotalTravelHours(Double.parseDouble(rs.getColumnValue(13)));
		ores.setOverallVolunteeringHours(Double.parseDouble(rs.getColumnValue(14)));
		ores.setLivesImpacted(Double.parseDouble(rs.getColumnValue(15)));
		ores.setActivityType(Double.parseDouble(rs.getColumnValue(16)));
		ores.setStatus(rs.getColumnValue(17));
		ores.setPocID(rs.getColumnValue(18));
		ores.setPocName(rs.getColumnValue(19));
		ores.setPocContactNumber(rs.getColumnValue(20));
		return ores;
		
	}
}
