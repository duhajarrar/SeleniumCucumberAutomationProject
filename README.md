# How it works?

- Right click on TestCase.feature and then run cucumber 
- Copy the logged code snipt
- Create a class file under `src/test/java/com/stepDefinition` name it as you wish.
- Right Click on Runner under `src/test/java/com/runner` and run Junit.
- Once it is executed, it generates reports under `Reports/cucumber/*.json` `*.xml` and `*.html`.
- run sh `upload.sh` to upload to Jira under `scripts/` it will zip `cucumber*.json` files and uplaod to jira executions.  It is based on linux.

