Feature: Test login for Job seekers and employers

  @TestCaseKey=JT-T2
  Scenario Outline: Test login for Job seekers and employers
    Given Navigate to "<login>" Page
    When Enter Email "<username>"
    And Enter Password "<password>"
    And Click on Login Button
    Then It should display "<successfully>"

    Examples:
      | login            | username          | password   | successfully                     |
      | job-seeker/login | abuqare           | xxxxxxxxxx | Email address is invalid email   |
      | job-seeker/login | abuqare@gmail.com | xxxxxxxxxx | Invalid Credential               |
      | job-seeker/login | abuqare           | xxxxxxxxxx | Email address is invalid email   |
      | job-seeker/login |                   |            | Email address is invalid email   |
      | employer/login   | abuqare@gmail.com | xxx        | Maximum Password length is 4     |
      | employer/login   | abuqare@gmail.com | xxxxxxxxxx | Invalid Credentials              |
      | employer/login   | abuqare           | xxxxxxxxxx | Email address is invalid email   |
      | employer/login   |                   |            | Email address is invalid email   |
