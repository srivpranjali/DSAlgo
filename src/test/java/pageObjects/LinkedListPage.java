package pageObjects;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import driverFactory.MyDriverFactory;
import utilities.ConfigReader;
import utilities.Utils;

public class LinkedListPage {
	
	private WebDriver driver;
	private ConfigReader reader = new ConfigReader();
	private Utils utils = new Utils();
	
	@FindBy (xpath = "//a[@href='linked-list']") WebElement getStarted_LinkedList;
	@FindBy (xpath = "//a[@href ='introduction']") WebElement introduction;
	@FindBy (xpath ="//a[@href ='creating-linked-list']") WebElement creating_linked_list;
	@FindBy (xpath ="//a[@href ='types-of-linked-list']") WebElement types_of_linked_list;
	@FindBy (xpath ="//a[@href ='implement-linked-list-in-python']") WebElement implement_linked_list_in_python;
	@FindBy (xpath ="//a[@href ='traversal']") WebElement traversal;
	@FindBy (xpath ="//a[@href ='insertion']") WebElement insertion;
	@FindBy (xpath ="//a[@href ='deletion']") WebElement deletion;
	@FindBy (xpath ="//a[@href='/tryEditor']") WebElement try_here;
	@FindBy (xpath = "//div[@class = 'CodeMirror-scroll']") WebElement codeEditor;
	@FindBy (id = "output")WebElement codeOutput;

	public LinkedListPage(WebDriver browserDriver) {
		driver = browserDriver;
		PageFactory.initElements(driver,this);
	}
	
	public String llTitle() {
		return driver.getTitle();
	}
	
	public String getOptionsTitle() {
		return driver.getTitle();
	}
	
	public void click_LinkedListOptions(String linkedListOptions) {
		switch(linkedListOptions) {
		case "Introduction":
			introduction.click();break;
		case "Creating Linked LIst":
			creating_linked_list.click();break;
		case "Types of Linked List":
			types_of_linked_list.click();break;
		case "Implemet Linked List in Python":
			implement_linked_list_in_python.click();break;
		case "Traversal":
			traversal.click();break;
		case "Insertion":
			insertion.click();break;
		case "Deletion":
			deletion.click();break;
		default:
			break;
			}
		}
	
	public void click_TryHere() {
		try_here.click();
	}
	}

