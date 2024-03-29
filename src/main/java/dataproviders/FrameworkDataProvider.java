package dataproviders;


import org.testng.annotations.DataProvider;
import utils.ExcelUtils;

public class FrameworkDataProvider {

    @DataProvider
    public Object[][] getDataForProductImagesTest() {
        return new Object[][]{
                {"MacBook", "MacBook Pro", 4},
                {"MacBook", "MacBook Air", 4},
                {"iMac", "iMac", 3},
                {"Samsung", "Samsung SyncMaster 941BW", 1}
        };
    }

    @DataProvider
    public Object[][] getDataForPlaceOrderTest(){
        return ExcelUtils.getData();
    }

}
