Feature: Test login for Job seekers and employers for correct values
    @TestCaseKey=JT-T3
    Scenario Outline: Test login for Job seekers and employers for correct values
        
        Given Navigate to "<login>" Page
        When Enter Email "<username>"
        And Enter Password "<password>"
        And Click on Login Button
        Then It should navigate to "<navigate_to>"
        
        Examples:
          | login            | username          | password | navigate_to   |
          | job-seeker/login | abuqare@gmail.com | Abuqare# | job-seeker    |
          | employer/login   | abuqare@gmail.com | Abuqare# | employer/home |