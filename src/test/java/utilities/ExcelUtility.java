package utilities;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class ExcelUtility
	{
	//props
		private File f;
		private FileInputStream fi;
		private FileOutputStream fo;
		private Workbook wb;
		private Sheet sh;
		
		// constructor
		public ExcelUtility(String fpath) throws Exception
		{
			f=new File(fpath);
			fi=new FileInputStream(f);
			wb=WorkbookFactory.create(fi);
			fo=new FileOutputStream(f);
		}
		
		//methods
		public void openSheet(String sheetname)
		{
			sh=wb.getSheet(sheetname);
		}
		
		public int getRowsCount()
		{
			int rc=sh.getPhysicalNumberOfRows();
			return(rc);
		}
		
		public int getCellCount()
		{
			int cc=sh.getRow(0).getLastCellNum();
			return(cc);
		}
		
		public void createResultColumn(int colindex)
		{
			sh.getRow(0).createCell(colindex).setCellValue("Output");
		}
		
		public String getCellValue(int rowindex,int colindex)
		{
			DataFormatter df=new DataFormatter();
			String value=df.formatCellValue(sh.getRow(rowindex).getCell(colindex));
			return(value);
		}
		
		public void setCellValue(int rowindex,int colindex,String result)
		{
			sh.getRow(rowindex).createCell(colindex).setCellValue(result);
			sh.autoSizeColumn(colindex);
		}
		
		public void saveAndCloseExcel() throws Exception
		{
			wb.write(fo);
			wb.close();
			fo.close();
			fi.close();
		}
		
	}



