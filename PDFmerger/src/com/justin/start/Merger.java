/*
*************************************************
File name:		Merger.java
Author:			Justin
Date Created:	28 Aug 2016
Purpose:		



*************************************************
*/

package com.justin.start;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Merger
{

	public static final String DEST = "results/merged.pdf";
	private static final String CLASSNAME = "Merger";
	private static final Logger logger = LogManager.getLogger();
	public static void main(String[] args)
	{
		final String methodName = "main"; 
		logger.trace("Entering " + methodName + " of class " + CLASSNAME);
		File file = new File(DEST);
    file.getParentFile().mkdirs();	
		PDFHadler handler = new PDFHadler();
		List<String> files = Arrays.asList(args);	
		try
		{
			logger.debug("Starting merging");
			handler.mergePDfs(files, DEST);
			logger.debug("End merging");
		}
		catch (IOException e)
		{
			logger.error("Exception in method " + methodName + " of class " + CLASSNAME);
		}
		logger.trace("Exiting " + methodName + " of class " + CLASSNAME);
	}
}
