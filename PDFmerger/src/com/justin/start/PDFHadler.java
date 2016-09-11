/*
 *************************************************
File name:		PDFHadler.java
Author:			Justin
Date Created:	29 Aug 2016
Purpose:		



 *************************************************
 */

package com.justin.start;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.kernel.geom.AffineTransform;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class PDFHadler
{
	private static final String CLASSNAME = "PDFHadler";

	public void createPdf(String dest) throws FileNotFoundException
	{
		

		PdfWriter writer = new PdfWriter(dest);

		// Initialize PDF document
		PdfDocument pdf = new PdfDocument(writer);

		// Initialize document
		Document document = new Document(pdf);

		// Add paragraph to the document
		document.add(new Paragraph("Hello World!"));

		// Close document
		document.close();

	}

	public void mergePDfs(List<String> files, String dest) throws IOException
	{
		List<Path> filePathList = new ArrayList<>();
		if (!files.isEmpty())
		{
			files.stream().forEach(a -> filePathList.add(Paths.get(a)));
		}

		PdfWriter writer = new PdfWriter(dest);
		PdfDocument destDoc = new PdfDocument(writer);

		if (!filePathList.isEmpty())
		{
			filePathList.stream().forEach(path -> {
				try
				{
					processPdf(destDoc, path.toFile().getPath());
				}
				catch (Exception e)
				{
					// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}	);
		}

		destDoc.close();
		writer.close();

	}

	private void processPdf(PdfDocument destDoc, String path) throws IOException
	{
		PdfReader reader = new PdfReader(path);
		PdfDocument srcDoc = new PdfDocument(reader);
		for (int i = 1; i <= srcDoc.getNumberOfPages(); i++)
		{
			PdfPage page = destDoc.addNewPage(PageSize.A4.rotate());

			PdfPage origPage = srcDoc.getPage(i);
			Rectangle orig = origPage.getPageSizeWithRotation();
			// Shrink original page content using transformation matrix
			PdfCanvas canvas = new PdfCanvas(page);
			PdfFormXObject pageCopy = origPage.copyAsFormXObject(destDoc);
			canvas.addXObject(pageCopy, 0, 0);
		}
		srcDoc.close();
		reader.close();
	}
}
