@DataProvider(name = "IReadExcelSheets")
public Object[][] myExcelsheetReader() throws Exception {
  SimpleExcelDataProvider dataProvider =
   new SimpleExcelDataProvider("src/test/resources/testdata/MyDataFile.xls");
  MyDataSheet dataRow = new MyDataSheet();
  MyDataSheet myData =
    (MyDataSheet) dataProvider.getSingleExcelRow(dataRow, "c");

  Object[][] data = new Object[1][1];
  data[0][0] = myData;

  return data;
}