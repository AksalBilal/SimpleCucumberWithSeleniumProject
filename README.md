# SimpleCucumberWithSeleniumProject
This is an basic project with using selenium and cucumber frameworks.

(TestListener.java) The start and end of the test steps are listened with the event listeners, a screenshot is captured according to the result of the test step and the test status is logged.

(CustomElementWait.java) Before using web elements, possible errors are prevented by waiting with custom wait functions.

When starting the project, previously saved screenshots are deleted by default.

Example XML Report;
```html

    ?xml version="1.0" encoding="UTF-8" standalone="no"?>
<testsuite errors="0" failures="0" name="io.cucumber.core.plugin.JUnitFormatter" skipped="0" tests="1" time="40.839">
    <testcase classname="Youtube Search Test" name="Scenarios for Search and title control on Youtube" time="40.707">
        <system-out><![CDATA[Given Go to Youtube homepage................................................passed
When Find the input field and enter "selenium cucumber".....................passed
And Click the Search button.................................................passed
Then Click on 2. video for the results......................................passed
And Compare the title of the opened video with the title you expect.........passed
]]></system-out>
    </testcase>
</testsuite>>
```
Example Report; 

![image](https://user-images.githubusercontent.com/46024317/102017053-89f5fe00-3d75-11eb-86bd-eec2c777fa1d.png)
