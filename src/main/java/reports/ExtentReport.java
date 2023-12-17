package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private static final String OUTPUT_FOLDER = "./reports/";
    private static final String FILE_NAME = "TestExecutionReport.html";

    private static ExtentReports extent;

    private ExtentReport() {

    }

    public static void initReports() {
        if(Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
            extent.attachReporter(spark);
            extent.setSystemInfo("System","Windows");
            extent.setSystemInfo("ENV Name", System.getProperty("env"));
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Selenium Framework");
            spark.config().setReportName("Sanity");
        }
    }

    public static void flushReports() throws IOException {
        if(Objects.nonNull(extent)) {
            extent.flush();
            Desktop.getDesktop().browse(new File("reports/TestExecutionReport.html").toURI());
        }
    }

    public static void createTest(String testcasename){
       ExtentManager.setExtTest(extent.createTest(testcasename));
    }

    public static void addAuthors(String[] authors){
        for(String author : authors){
            ExtentManager.getExtTest().assignAuthor(author);
        }
    }

    public static void addCategories(String[] categories){
        for(String category : categories){
            ExtentManager.getExtTest().assignCategory(category);
        }
    }

}
