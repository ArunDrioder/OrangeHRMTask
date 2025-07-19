package TestExecution;

import keywords.ActionKeywords;
import org.openqa.selenium.By;
import utils.ExcelReader;
import utils.Locators;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExecutionClass {

    ActionKeywords actionKeywords;
    Method[] methods;
    public static By locator;


    public ExecutionClass() {
        actionKeywords = new ActionKeywords();
        methods = actionKeywords.getClass().getMethods();
    }

    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException {
        ExcelReader reader = new ExcelReader();
        reader.readExcelFile(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\TestData.xlsx");
        ExecutionClass ec = new ExecutionClass();
        int locatorColumn = 3;
        int keywordColumn = locatorColumn + 1;
        int dataColumn = locatorColumn + 2;

        for (int row = 1; row <= ExcelReader.totalRows; row++) {


            reader.getAllValuesFromExcelSheet(row, locatorColumn, keywordColumn, dataColumn);
            ec.findWebElementsToBeUsed();
            ec.executeKeywords();


        }


    }


    public void findWebElementsToBeUsed() {
        switch (ExcelReader.locatorName) {
            case "id":
                locator = Locators.getId(ExcelReader.locatorValue);
                break;

            case "name":
                locator = Locators.getName(ExcelReader.locatorValue);
                break;

            case "xpath":
                locator = Locators.getXpath(ExcelReader.locatorValue);
                break;

            case "cssSelector":
                locator = Locators.getCssSelector(ExcelReader.locatorValue);
                break;

            case "linkText":
                locator = Locators.getLinkText(ExcelReader.locatorValue);
                break;

            case "partialLinkText":
                locator = Locators.getPartialLinkText(ExcelReader.locatorValue);
                break;

            case "className":
                locator = Locators.getClassName(ExcelReader.locatorValue);
                break;

            case "tagName":
                locator = Locators.getTagName(ExcelReader.locatorValue);
                break;

            default:
                break;
        }
    }

    public void executeKeywords() throws InvocationTargetException, IllegalAccessException {
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().equalsIgnoreCase(ExcelReader.keywordColumnValue)) {
                methods[i].invoke(actionKeywords);
                break;
            }

        }
    }
}
