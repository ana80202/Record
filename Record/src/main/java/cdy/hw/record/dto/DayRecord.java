package cdy.hw.record.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DayRecord {
	
	private int recordNo;
	private String  recordTitle;
	private String  recordMemo;
	private String  recordDate;
	private String  recordDeleteFlag;

}
