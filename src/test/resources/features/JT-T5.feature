Feature: Save Featured Job
    @TestCaseKey=JT-T5
    Scenario Outline: Save Featured Job
        
        Given Navigate to "<login>" Page
        When Enter Email "<username>"
        And Enter Password "<password>"
        And Click on Login Button  
        And Navigate to Home Page
        And Click on featured job
        And Click on save job
        Then Should display saved successfully
        
        Examples: 
           | login				| username              | password |			                
           | job-seeker/login	| duha.jarrar@gmail.com | D12345@j |	