You need to implement a test which contains the following steps:

Test case scenario:

Open url: wrike.com;
Click "Get started for free" button near "Login" button;
Fill in the email field with random generated value of email with mask “<random_text>+wpt@wriketask.qaa” (e.g. “abcdef+wpt@wriketask.qaa”);
Click on "Create my Wrike account" button + check with assertion that you are moved to the next page;
Fill in the Q&A section at the left part of page (like random generated answers) + check with assertion that your answers are submitted;
Check that section "Follow us" at the site footer contains the "Twitter" button that leads to the correct url and has the correct icon;
Create results report using allure plugin (by maven).  
(You may close all needless tooltips on your way. If website has different behavior on some pages from time to time, you need to implement all these pages and use necessary one depending on URL.)

Stack of technologies for implementation:

Platform: java 11
Build and run: maven
Test framework: junit4
UI test: selenium 3 (without wrappers)
Pattern: pageObject (test -> steps -> pages)
Reporting: allure plugin
xpath (should be short and stable)

Browser used: Chrome
