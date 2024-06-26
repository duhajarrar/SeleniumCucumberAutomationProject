Feature: Add Personal Information for User with Invalid Mobile and Phone Number
  @TestCaseKey=JT-T8
  Scenario Outline: Testing Add Personal Information for User with Invalid Mobile and Phone Number
    Given Navigate to "<login>" Page
    When Enter Email "<username>"
    And Enter Password "<password>"
    And Click on Login Button
    And Navigate to Resume page
    And Enter First Name "<firstname>"
    And Enter Last Name "<lastname>"
    And Select BirthdateDay "<day>"
    And Select BrithdateMonth "<month>"
    And Select BirthdateYear "<year>"
    And Select Gender "<gender>"
    And Input Email "<email>"
    And Select Country "<country_id>"
    And Select City "<city_id>"
    And Enter Mobile "<mobile>"
    And Enter Phone "<phone>"
    And Enter Social Media Facebook url "<facebook_url>"
    And Enter Social Media Linkedin url "<linkedin_url>"
    And Click save button
    Then Phone and Mobile Error Should appear
    Examples:
      | login            | username              | password        | firstname | lastname | day | month | year | gender | email                 | country_id | city_id | mobile    | phone    | facebook_url                        | linkedin_url                                |
      | job-seeker/login | ce.emad1999@gmail.com | dpB6Z6fjBsuS2Qi | User      | User     | 30  | 5     | 1999 | m      | ce.emad1999@gmail.com | 25         | 27      | 059741823 | 09268648 | https://www.facebook.com/my_profile | https://www.linkedin.com/profile/my_profile |

