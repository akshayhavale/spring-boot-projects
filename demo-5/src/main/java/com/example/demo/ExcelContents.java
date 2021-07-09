package com.example.demo;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExcelContents {

	private List<String[]> excelContents;

}
